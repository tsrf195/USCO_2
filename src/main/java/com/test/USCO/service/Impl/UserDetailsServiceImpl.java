package com.test.USCO.service.Impl;

import com.test.USCO.entity.Persona;
import com.test.USCO.entity.UserDetailsImpl;
import com.test.USCO.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("userDetail")
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    PersonaService personaService;

    @Transactional(readOnly = true)
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Persona persona = personaService.getByUserName(username).get();
        return UserDetailsImpl.build(persona);
    }
}
