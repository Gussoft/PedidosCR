package com.gussoft.pedidoscr.repository;

import com.gussoft.pedidoscr.models.Mesa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MesaPlatoRepository extends JpaRepository<Mesa, Integer> {

    @Modifying
    @Query(value = "INSERT INTO mesa_plato(id_plato, id_mesa) VALUES (:idplato, :idmesa)", nativeQuery = true)
    Integer registerQuery(@Param("idplato") Integer idplato, @Param("idmesa") Integer idmesa);
}
