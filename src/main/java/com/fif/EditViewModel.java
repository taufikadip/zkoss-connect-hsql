package com.fif;

import com.fif.entity.Person;
import com.fif.services.impl.PersonServiceImpl;
import com.fif.services.PersonService;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.VariableResolver;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zkplus.cdi.DelegatingVariableResolver;

import java.util.Date;

@VariableResolver(org.zkoss.zkplus.spring.DelegatingVariableResolver.class)
public class EditViewModel extends SelectorComposer<Component> {
    private Integer id;
    private String name;
    private String gender;
    private Date birthday;
    private String employment;
    private String country;

    @WireVariable
    PersonService personService;

    @Init
    public void init() {
        this.id = Integer.valueOf(Executions.getCurrent().getParameter("id"));
//        || this.id.isEmpty()
        if (this.id == null) {
            Executions.sendRedirect("helloworld.zul");
            return;
        }
        Person selectedPerson = personService.getById(id);
        if (selectedPerson == null)
            throw new RuntimeException("Please go through from Table");

        this.setName(selectedPerson.getName());
        this.setGender(selectedPerson.getGender());
        this.setBirthday(selectedPerson.getBirthday());
        this.setEmployment(selectedPerson.getEmployment());
        this.setCountry(selectedPerson.getCountry());
    }

//    @Command
//    public void updatePerson() {
//            personService.updatePerson(this.id, this.name, this.gender, this.birthday, this.employment, this.country);
//            Executions.sendRedirect("searchMvvm.zul");
//    }

    @Command
    public void updatePerson() {
        Person person = new Person();
        person.setId(id);
        person.setName(name);
        person.setGender(gender);
        person.setBirthday(birthday);
        person.setEmployment(employment);
        person.setCountry(country);
        personService.updatePerson(person);
        Executions.sendRedirect("searchMvvm.zul");
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public String getEmployment() {
        return employment;
    }

    public String getCountry() {
        return country;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public void setEmployment(String employment) {
        this.employment = employment;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
