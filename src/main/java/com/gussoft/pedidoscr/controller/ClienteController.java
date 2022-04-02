package com.gussoft.pedidoscr.controller;

import com.gussoft.pedidoscr.exception.ModelNotFoundException;
import com.gussoft.pedidoscr.models.Cliente;
import com.gussoft.pedidoscr.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService service;

    @GetMapping("/")
    public ResponseEntity<List<Cliente>> listar(){
        List<Cliente> obj = service.ToList();
        return new ResponseEntity<List<Cliente>>(obj, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> listarOne(@PathVariable("id") Integer id){
        Cliente obj = service.ReadById(id);
        if (obj == null){
            throw new ModelNotFoundException("Id no encontrado : " + id);
        }
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Object> registrar(@RequestBody Cliente datos){
        Cliente obj = service.Register(datos);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping
    public ResponseEntity<Object> modificar(@RequestBody Cliente datos){
        Cliente obj = service.Modify(datos);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> eliminar(@PathVariable("id") Integer id){
        Cliente obj = service.ReadById(id);
        if (obj == null){
            throw new ModelNotFoundException("Id no encontrado : " + id);
        }else{
            service.Deleted(id);
        }
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }
}
