package com.fif.services.impl;

import com.fif.entity.PersonLogin;
import com.fif.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service("userService")
@Scope(value = "singleton", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class PersonLoginServiceImpl implements UserDetailsService {

    @Autowired
    PersonRepository personRepository;
//    PersonDao personDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            PersonLogin personLogin = personRepository.get(username);
            Set<GrantedAuthority> authorities = personLogin.getRoles()
                    .stream()
                    .map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toSet());
            return new org.springframework.security.core.userdetails.User(personLogin.getUsername(), personLogin.getPassword(), authorities);
        } catch (RuntimeException e) {
            e.printStackTrace();
            throw new RuntimeException("Invalid Login");
        }
    }

}
