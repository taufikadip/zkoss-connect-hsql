package com.fif.services;

import com.fif.entity.Log;
import com.fif.entity.Person;

import java.util.Collection;
import java.util.Date;
import java.util.List;

public interface PersonService {

//    public List<Person> findAll();
//
//    public List<Person> search(String keyword);
//
//    void delete(Integer id);
//
//    void addPerson(Integer id, String name, String gender, Date birthday, String employment, String country);
//
//    void updatePerson(Integer id, String name, String gender, Date birthday, String employment, String country);

    Person getById(Integer id);

    Person addPerson(Person person);

    List<Person> getPersons();

    void deletePerson(Integer id);

    List<Person> search(String keyword);

    void updatePerson(Person person);
}
