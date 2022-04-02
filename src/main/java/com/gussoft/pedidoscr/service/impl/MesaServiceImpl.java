package com.gussoft.pedidoscr.service.impl;

import com.gussoft.pedidoscr.models.Mesa;
import com.gussoft.pedidoscr.repository.MesaRepository;
import com.gussoft.pedidoscr.service.MesaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MesaServiceImpl implements MesaService {

    @Autowired
    private MesaRepository repo;

    @Override
    public Mesa Register(Mesa obj) {
        return repo.save(obj);
    }

    @Override
    public Mesa Modify(Mesa obj) {
        return repo.save(obj);
    }

    @Override
    public Mesa ReadById(Integer id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public List<Mesa> ToList() {
        return repo.findAll();
    }

    @Override
    public void Deleted(Integer id) {
        repo.deleteById(id);
    }
}
