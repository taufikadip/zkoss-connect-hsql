package com.fif.services.impl;

import com.fif.entity.Person;
import com.fif.entity.PersonLogin;
import com.fif.repository.PersonRepository;
import com.fif.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service("personService")
@Scope(value = "singleton", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class PersonServiceImpl implements PersonService {

    @Autowired
    PersonRepository personRepository;
//    PersonDao personDao;

//    @Override
//    public UserDetails loadPersonByUsername(String username) throws UsernameNotFoundException {
//        try {
//            PersonLogin personLogin = personRepository.get(username);
//            Set<GrantedAuthority> authorities = personLogin.getRoles()
//                    .stream()
//                    .map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toSet());
//            return new org.springframework.security.core.userdetails.User(personLogin.getUsername(), personLogin.getPassword(), authorities);
//        } catch (RuntimeException e) {
//            e.printStackTrace();
//            throw new RuntimeException("Invalid Login");
//        }
//    }

    public Person addPerson(Person person) {
        return personRepository.save(person);
    }

    public List<Person> getPersons() {
        return personRepository.queryAll();
    }

    public List<Person>search(String keyword) {
        return personRepository.search(keyword);
    }

    public Person getById(Integer id) {
        return personRepository.get(id);
    }

    public void updatePerson(Person person) {
        personRepository.editPerson(person);
    }

    public void deletePerson(Integer id) {
        personRepository.delete(id);
    }
}
