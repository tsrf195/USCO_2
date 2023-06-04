package com.test.USCO.service;

import com.test.USCO.entity.Departamento;

import java.util.List;
import java.util.Optional;

public interface DepartamentoService {

    List<Departamento> listar();

    Optional<Departamento> getByName(String nombreDepartamento);
    void save(Departamento departamento);
}
