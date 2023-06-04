package com.test.USCO.repository;

import com.test.USCO.entity.Ciudad;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICiudadRepository extends JpaRepository<Ciudad, Integer> {
}
