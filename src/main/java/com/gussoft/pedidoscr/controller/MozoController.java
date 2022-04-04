package com.gussoft.pedidoscr.controller;

import com.gussoft.pedidoscr.exception.ModelNotFoundException;
import com.gussoft.pedidoscr.models.Mozo;
import com.gussoft.pedidoscr.service.MozoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/mozos")
public class MozoController {

    @Autowired
    private MozoService service;

    @GetMapping("/")
    public ResponseEntity<List<Mozo>> listar(){
        List<Mozo> obj = service.ToList();
        return new ResponseEntity<List<Mozo>>(obj, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Mozo> listarOne(@PathVariable("id") Integer id){
        Mozo obj = service.ReadById(id);
        if (obj == null){
            throw new ModelNotFoundException("Id no encontrado : " + id);
        }
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Object> registrar(@RequestBody Mozo datos){
        Mozo obj = service.Register(datos);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping
    public ResponseEntity<Object> modificar(@RequestBody Mozo datos){
        Mozo obj = service.Modify(datos);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> eliminar(@PathVariable("id") Integer id){
        Mozo obj = service.ReadById(id);
        if (obj == null){
            throw new ModelNotFoundException("Id no encontrado : " + id);
        }else{
            service.Deleted(id);
        }
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }
}
