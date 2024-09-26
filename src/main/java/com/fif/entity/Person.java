package com.fif.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;

    @Column(name = "name")
    String name;

    @Column(name = "gender")
    String gender;

    @Temporal(TemporalType.TIMESTAMP)
    Date birthday;

    @Column(name = "employment")
    String employment;

    @Column(name = "country")
    String country;

    public Person(){
    }

    public Person(String name, String gender, Date birthday, String employment, String country) {
        this.name = name;
        this.gender = gender;
        this.birthday = birthday;  // Pastikan tipe birthday adalah Date
        this.employment = employment;
        this.country = country;
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

    public Date getBirthday() { return birthday; }

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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj)
            return true;
        if(obj == null)
            return false;
        if(getClass() != obj.getClass())
            return false;
        Person other = (Person)obj;
        if(id == null) {
            if(other.id != null)
                return false;
        } else if(!id.equals(other.id))
            return false;
        return true;
    }

}
