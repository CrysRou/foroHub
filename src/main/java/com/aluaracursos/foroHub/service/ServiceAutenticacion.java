package com.aluaracursos.foroHub.service;

import com.aluaracursos.foroHub.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class ServiceAutenticacion implements UserDetailsService {

    @Autowired
    private UsuarioRepository repository;
    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        return repository.findByEmail(login);
    }

}
