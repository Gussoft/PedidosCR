package com.gussoft.pedidoscr.service.impl;

import com.gussoft.pedidoscr.models.Cliente;
import com.gussoft.pedidoscr.repository.ClienteRepository;
import com.gussoft.pedidoscr.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository repo;

    @Override
    public Cliente Register(Cliente cliente) {
        return repo.save(cliente);
    }

    @Override
    public Cliente Modify(Cliente cliente) {
        return repo.save(cliente);
    }

    @Override
    public Cliente ReadById(Integer id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public List<Cliente> ToList() {
        return repo.findAll();
    }

    @Override
    public void Deleted(Integer id) {
        repo.deleteById(id);
    }
}
