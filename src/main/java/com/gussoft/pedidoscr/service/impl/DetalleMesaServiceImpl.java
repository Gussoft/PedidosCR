package com.gussoft.pedidoscr.service.impl;

import com.gussoft.pedidoscr.models.DetalleMesa;
import com.gussoft.pedidoscr.repository.DetalleMesaRepository;
import com.gussoft.pedidoscr.service.DetalleMesaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetalleMesaServiceImpl implements DetalleMesaService {

    @Autowired
    private DetalleMesaRepository repo;

    @Override
    public DetalleMesa Register(DetalleMesa obj) {
        return null;
    }

    @Override
    public DetalleMesa Modify(DetalleMesa obj) {
        return null;
    }

    @Override
    public DetalleMesa ReadById(Integer id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public List<DetalleMesa> ToList() {
        return repo.findAll();
    }

    @Override
    public void Deleted(Integer id) {

    }
}
