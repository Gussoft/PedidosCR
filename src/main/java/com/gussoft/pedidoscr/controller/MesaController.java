package com.gussoft.pedidoscr.controller;

import com.gussoft.pedidoscr.exception.ModelNotFoundException;
import com.gussoft.pedidoscr.models.DetalleMesa;
import com.gussoft.pedidoscr.models.Mesa;
import com.gussoft.pedidoscr.models.dto.PedirPlato;
import com.gussoft.pedidoscr.service.DetalleMesaService;
import com.gussoft.pedidoscr.service.MesaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/mesas")
public class MesaController {

    @Autowired
    private MesaService service;

    @Autowired
    private DetalleMesaService service_Mesa;

    @GetMapping("/")
    public ResponseEntity<List<Mesa>> listar(){
        List<Mesa> obj = service.ToList();
        return new ResponseEntity<List<Mesa>>(obj, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Mesa> listarOne(@PathVariable("id") Integer id){
        Mesa obj = service.ReadById(id);
        if (obj == null){
            throw new ModelNotFoundException("Id no encontrado : " + id);
        }
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Object> registrar(@RequestBody PedirPlato datos){
        Mesa obj = service.hacerPedido(datos);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping
    public ResponseEntity<Object> modificar(@RequestBody Mesa datos){
        Mesa obj = service.Modify(datos);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> eliminar(@PathVariable("id") Integer id){
        Mesa obj = service.ReadById(id);
        if (obj == null){
            throw new ModelNotFoundException("Id no encontrado : " + id);
        }else{
            service.Deleted(id);
        }
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }

    @GetMapping("/detalles")
    public ResponseEntity<List<DetalleMesa>> listarDetalle(){
        List<DetalleMesa> obj = service_Mesa.ToList();
        return new ResponseEntity<List<DetalleMesa>>(obj, HttpStatus.OK);
    }

    @GetMapping("/detalles/{id}")
    public ResponseEntity<DetalleMesa> listarOneDetalle(@PathVariable("id") Integer id){
        DetalleMesa obj = service_Mesa.ReadById(id);
        if (obj == null){
            throw new ModelNotFoundException("Id no encontrado : " + id);
        }
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }
}
