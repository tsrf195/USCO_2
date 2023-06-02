package com.test.USCO.repository;

import com.test.USCO.config.UserGrantedAuthority;
import com.test.USCO.entity.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IRoleRepository extends JpaRepository<Rol, Integer> {

}
