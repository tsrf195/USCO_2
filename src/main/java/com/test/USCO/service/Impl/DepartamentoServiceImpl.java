package com.test.USCO.service.Impl;

import com.test.USCO.entity.Departamento;
import com.test.USCO.repository.IDepartamentoRepository;
import com.test.USCO.service.DepartamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional //transacciones con la DB
public class DepartamentoServiceImpl implements DepartamentoService {

    @Autowired
    IDepartamentoRepository departamentoRepository;

    @Override
    public List<Departamento> listar() {
        return departamentoRepository.findAll();
    }

    @Override
    public Optional<Departamento> getByName(String nombreDepartamento) {
        return departamentoRepository.findByNombre(nombreDepartamento);
    }

    @Override
    public void save(Departamento departamento) {
        departamentoRepository.save(departamento);
    }
}
