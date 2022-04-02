package com.gussoft.pedidoscr.repository;

import com.gussoft.pedidoscr.models.Plato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlatoRepository extends JpaRepository<Plato, Integer> {

}
