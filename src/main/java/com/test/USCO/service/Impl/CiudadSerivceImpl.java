package com.test.USCO.service.Impl;

import com.test.USCO.entity.Ciudad;
import com.test.USCO.repository.ICiudadRepository;
import com.test.USCO.service.CiudadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional //transacciones con la DB
public class CiudadSerivceImpl implements CiudadService {

    @Autowired
    ICiudadRepository ciudadRepository;

    @Override
    public List<Ciudad> listar(){
        return ciudadRepository.findAll();
    }

    @Override
    public void save (Ciudad ciudad){ciudadRepository.save(ciudad);}
}
