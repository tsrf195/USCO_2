package com.test.USCO.repository;

import com.test.USCO.entity.Departamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IDepartamentoRepository extends JpaRepository <Departamento, Integer> {


    Optional<Departamento> findByNombre(String nombreDepartamento);
}
