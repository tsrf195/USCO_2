package com.test.USCO.service;

import com.test.USCO.entity.Ciudad;

import java.util.List;


public interface CiudadService {
    List<Ciudad> listar();
    void save(Ciudad  ciudad);
}
