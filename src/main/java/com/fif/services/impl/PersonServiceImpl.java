package com.fif.services.impl;

import com.fif.entity.Person;
import com.fif.repository.PersonRepository;
import com.fif.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("personService")
@Scope(value = "singleton", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class PersonServiceImpl implements PersonService {

//    private PersonRepository repository = new PersonRepository();
//
//    private List<Person> personList;
//
////    private static int id = 1;
//
//    public PersonServiceImpl() {
//        personList = repository.findAll();
//    }
//
//    public List<Person> findAll() { return personList; }
//
//    public List<Person> search(String keyword) {
//        List<Person> result = new LinkedList<Person>();
//        if (keyword==null || equals(keyword)){
//            result = personList;
//        } else {
//            for (Person p: personList) {
//                if (p.getName().toLowerCase().contains(keyword.toLowerCase())) {
//                    result.add(p);
//                } else if (p.getGender().equalsIgnoreCase(keyword)) {
//                    result.add(p);
//                }
//            }
//        }
//        return result;
//    }
//
//    @Override
//    public void delete(Integer id) {
//        Person personToRemove = null;
//
//        // Mencari person berdasarkan id
//        for (Person person : personList) {
//            if (person.getId().equals(id)) {
//                personToRemove = person;
//                break;
//            }
//        }
//
//        // Jika person ditemukan, hapus dari daftar
//        if (personToRemove != null) {
//            personList.remove(personToRemove);
//        }
//    }
//
//    @Override
//    public void addPerson(Integer id, String name, String gender, Date birthday, String employment, String country) {
//        personList.add(new Person(name, gender, birthday, employment, country));
//    }
//
//    @Override
//    public Person getById(Integer id) {
//        // Mencari person berdasarkan id
//        for (Person person : personList) {
//            if (person.getId().equals(id)) {
//                return person;
//            }
//        }
//        return null;
//    }
//
//    @Override
//    public void updatePerson(Integer id, String name, String gender, Date birthday, String employment, String country) {
//        Person personToUpdate = getById(id);
//        if (personToUpdate != null) {
//            delete(id);
//            addPerson(id, name, gender, birthday, employment, country);
//        }
//    }

    @Autowired
    PersonRepository personRepository;

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
