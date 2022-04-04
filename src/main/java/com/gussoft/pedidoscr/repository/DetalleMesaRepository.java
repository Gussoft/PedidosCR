package com.gussoft.pedidoscr.repository;

import com.gussoft.pedidoscr.models.DetalleMesa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetalleMesaRepository extends JpaRepository<DetalleMesa, Integer> {

}
