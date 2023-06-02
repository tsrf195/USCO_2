package com.test.USCO.service;


import com.test.USCO.entity.Rol;

import java.util.List;

public interface RoleService {
    List<Rol> listar();

    void save(Rol rol);


}
