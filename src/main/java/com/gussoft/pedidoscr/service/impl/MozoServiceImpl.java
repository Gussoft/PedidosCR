package com.gussoft.pedidoscr.service.impl;

import com.gussoft.pedidoscr.models.Mozo;
import com.gussoft.pedidoscr.repository.MozoRepository;
import com.gussoft.pedidoscr.service.MozoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MozoServiceImpl implements MozoService {

    @Autowired
    private MozoRepository repo;

    @Override
    public Mozo Register(Mozo obj) {
        return repo.save(obj);
    }

    @Override
    public Mozo Modify(Mozo obj) {
        return repo.save(obj);
    }

    @Override
    public Mozo ReadById(Integer id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public List<Mozo> ToList() {
        return repo.findAll();
    }

    @Override
    public void Deleted(Integer id) {
        repo.deleteById(id);
    }
}
