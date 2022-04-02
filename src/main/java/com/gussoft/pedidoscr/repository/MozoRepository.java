package com.gussoft.pedidoscr.repository;

import com.gussoft.pedidoscr.models.Mozo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MozoRepository extends JpaRepository<Mozo, Integer> {

}
