package com.gussoft.pedidoscr.service.impl;

import com.gussoft.pedidoscr.models.Plato;
import com.gussoft.pedidoscr.repository.PlatoRepository;
import com.gussoft.pedidoscr.service.PlatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlatoServiceImpl implements PlatoService {

    @Autowired
    private PlatoRepository repo;

    @Override
    public Plato Register(Plato obj) {
        return repo.save(obj);
    }

    @Override
    public Plato Modify(Plato obj) {
        return repo.save(obj);
    }

    @Override
    public Plato ReadById(Integer id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public List<Plato> ToList() {
        return repo.findAll();
    }

    @Override
    public void Deleted(Integer id) {
        repo.deleteById(id);
    }
}
