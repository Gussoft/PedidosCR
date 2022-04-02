package com.gussoft.pedidoscr.service.impl;

import com.gussoft.pedidoscr.models.Categoria;
import com.gussoft.pedidoscr.repository.CategoriaRepository;
import com.gussoft.pedidoscr.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaServiceImpl implements CategoriaService {

    @Autowired
    private CategoriaRepository repo;

    @Override
    public Categoria Register(Categoria obj) {
        return repo.save(obj);
    }

    @Override
    public Categoria Modify(Categoria obj) {
        return repo.save(obj);
    }

    @Override
    public Categoria ReadById(Integer id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public List<Categoria> ToList() {
        return repo.findAll();
    }

    @Override
    public void Deleted(Integer id) {
        repo.deleteById(id);
    }
}
