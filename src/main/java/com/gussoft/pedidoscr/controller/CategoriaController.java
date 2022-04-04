package com.gussoft.pedidoscr.controller;

import com.gussoft.pedidoscr.exception.ModelNotFoundException;
import com.gussoft.pedidoscr.models.Categoria;
import com.gussoft.pedidoscr.models.Cliente;
import com.gussoft.pedidoscr.service.CategoriaService;
import com.gussoft.pedidoscr.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaService service;

    @GetMapping("/")
    public ResponseEntity<List<Categoria>> listar(){
        List<Categoria> obj = service.ToList();
        return new ResponseEntity<List<Categoria>>(obj, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Categoria> listarOne(@PathVariable("id") Integer id){
        Categoria obj = service.ReadById(id);
        if (obj == null){
            throw new ModelNotFoundException("Id no encontrado : " + id);
        }
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Object> registrar(@RequestBody Categoria datos){
        Categoria obj = service.Register(datos);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping
    public ResponseEntity<Object> modificar(@RequestBody Categoria datos){
        Categoria obj = service.Modify(datos);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> eliminar(@PathVariable("id") Integer id){
        Categoria obj = service.ReadById(id);
        if (obj == null){
            throw new ModelNotFoundException("Id no encontrado : " + id);
        }else{
            service.Deleted(id);
        }
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }
}
