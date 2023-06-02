package com.test.USCO.controller;

import com.test.USCO.entity.Rol;
import com.test.USCO.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/role/")
public class RoleController {

    @Autowired
    RoleService roleService;

    @GetMapping(path = "listar")
    public List<Rol> listar() throws Exception{
        return roleService.listar();
    }

    @GetMapping(path = "crear")
    public void crear() throws Exception{
        Rol administrador = new Rol();
        administrador.setNombre("Admin");
        roleService.save(administrador);

        Rol paciente = new Rol();
        paciente.setNombre("Paciente");
        roleService.save(paciente);

        Rol medico = new Rol();
        medico.setNombre("Medico");
        roleService.save(medico);
    }


}
