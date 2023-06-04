package com.test.USCO.controller;

import com.test.USCO.entity.Departamento;
import com.test.USCO.service.DepartamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/departamento/")
public class DepartamentoController {

    @Autowired
    DepartamentoService departamentoService;

    @GetMapping(path = "listar")
    public List<Departamento> listar() throws Exception{
        return departamentoService.listar();
    }
    @GetMapping(path = "crear")
    public void crear() throws Exception{
        //codigo 1
        Departamento huila = new Departamento();
        huila.setNombre("Huila");
        departamentoService.save(huila);
        //codigo 2
        Departamento bogota  = new Departamento();
        bogota.setNombre("Bogota D.C.");
        departamentoService.save(bogota);
        //codigo 3
        Departamento antioquia = new Departamento();
        antioquia.setNombre("Antioquia");
        departamentoService.save(antioquia);
    }

}
