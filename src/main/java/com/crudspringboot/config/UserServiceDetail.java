package com.crudspringboot.config;
import com.crudspringboot.model.Client;
import com.crudspringboot.model.Role;
import com.crudspringboot.repository.ClientRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserServiceDetail implements UserDetailsService {

    private final ClientRepository userRepository;

    public UserServiceDetail(ClientRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Client client = userRepository.findByUsername(s);
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        for (Role role : client.getRoles()) {
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getRole()));
        }
        return new org.springframework.security.core.userdetails.User(client.getUsername(), client.getPassword(), grantedAuthorities);
    }
}