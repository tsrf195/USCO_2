package com.test.USCO.controller;

import com.test.USCO.entity.Ciudad;
import com.test.USCO.entity.Departamento;
import com.test.USCO.entity.Rol;
import com.test.USCO.service.CiudadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/ciudad/")
public class CiudadController {

    @Autowired
    CiudadService ciudadService;

    @GetMapping(path = "listar")
    public List<Ciudad> listar() throws Exception{
        return ciudadService.listar();
    }

    @GetMapping(path = "crear")
    public void crear(Ciudad ciudad) throws Exception{
        ciudadService.save(ciudad);
    }
}
