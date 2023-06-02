package com.test.USCO.service.Impl;


import com.test.USCO.entity.Rol;
import com.test.USCO.repository.IRoleRepository;
import com.test.USCO.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional //transacciones con la DB
public class RoleServiceImpl implements RoleService {

    @Autowired
    IRoleRepository roleRepository;

    @Override
    public List<Rol> listar(){
        return roleRepository.findAll();
    }

    @Override
    public void save(Rol rol){ roleRepository.save(rol); }






}
