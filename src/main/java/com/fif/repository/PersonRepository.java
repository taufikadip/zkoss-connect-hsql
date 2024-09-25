package com.fif.repository;

import com.fif.entity.Person;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class PersonRepository {

//    private static List<Person> personList = new LinkedList<Person>();
//
//    static {
//        SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMMM yyyy");
//
//        try {
//            personList.add(
//                    new Person(
//                            "ZK",
//                            "Male",
//                            dateFormat.parse("2 October 2000"),
//                            "fulltime",
//                            "Indonesia"
//                    )
//            );
//            personList.add(
//                    new Person(
//                            "Luka",
//                            "Female",
//                            dateFormat.parse("2 October 2000"),
//                            "fulltime",
//                            "Japan"
//                    )
//            );
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    public List<Person> findAll() {
//        return personList;
//    }

    @PersistenceContext
    private EntityManager em;

    @Transactional(readOnly = true)
    public List<Person> queryAll() {
        Query query = em.createQuery("SELECT p FROM Person p");
        List<Person> result = query.getResultList();
        return result;
    }

    @Transactional(readOnly = true)
    public Person get(Integer id) {
        return em.find(Person.class, id);
    }

    @Transactional
    public Person save(Person person) {
        em.persist(person);
        em.flush();
        return person;
    }

    @Transactional
    public Person delete(Integer id) {
        Person selectedPerson = get(id);
        if (selectedPerson != null) {
            em.remove(selectedPerson);
        }
        return selectedPerson;
    }

    @Transactional(readOnly = true)
    public List<Person> search(String keyword) {
        Query query = em.createQuery("SELECT p FROM Person p WHERE p.name LIKE :kName or p.gender = :kGender");
        query.setParameter("kName", "%" + keyword + "%");
        query.setParameter("kGender", keyword);
        List<Person> result = query.getResultList();
        return result;
    }

//    @Transactional(readOnly = true)
//    public List<Person> search(String keyword) {
//        Query query = em.createQuery("SELECT p FROM Person p WHERE" +
//                " p.name LIKE :kName or p.gender = :kGender");
//        query.setParameter("kName", "%" + keyword + "%");
//        query.setParameter("kGender", keyword);
//        List<Person> result = query.getResultList();
//        return result;
//    }

    @Transactional
    public Person editPerson(Person person) {
        System.out.println(person.getId());
        Person selectedPerson = get(person.getId());
        if (selectedPerson != null) {
            selectedPerson.setName(person.getName());
            selectedPerson.setGender(person.getGender());
            selectedPerson.setBirthday(person.getBirthday());
            selectedPerson.setEmployment(person.getEmployment());
            selectedPerson.setCountry(person.getCountry());
            em.merge(selectedPerson);
        }
        return selectedPerson;
    }
}
