package com.gussoft.pedidoscr.controller;

import com.gussoft.pedidoscr.exception.ModelNotFoundException;
import com.gussoft.pedidoscr.models.Plato;
import com.gussoft.pedidoscr.service.PlatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/platos")
public class PlatoController {

    @Autowired
    private PlatoService service;

    @GetMapping("/")
    public ResponseEntity<List<Plato>> listar(){
        List<Plato> obj = service.ToList();
        return new ResponseEntity<List<Plato>>(obj, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Plato> listarOne(@PathVariable("id") Integer id){
        Plato obj = service.ReadById(id);
        if (obj == null){
            throw new ModelNotFoundException("Id no encontrado : " + id);
        }
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Object> registrar(@RequestBody Plato datos){
        Plato obj = service.Register(datos);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping
    public ResponseEntity<Object> modificar(@RequestBody Plato datos){
        Plato obj = service.Modify(datos);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> eliminar(@PathVariable("id") Integer id){
        Plato obj = service.ReadById(id);
        if (obj == null){
            throw new ModelNotFoundException("Id no encontrado : " + id);
        }else{
            service.Deleted(id);
        }
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }
}
