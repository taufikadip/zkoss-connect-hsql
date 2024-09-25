package com.fif;

import com.fif.entity.Log;
import com.fif.entity.Person;
import com.fif.services.MyService;
import com.fif.services.impl.PersonServiceImpl;
import com.fif.services.PersonService;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.VariableResolver;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zul.ListModelList;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import static java.time.zone.ZoneRulesProvider.refresh;
import static org.zkoss.util.resource.Labels.reset;

@VariableResolver(org.zkoss.zkplus.spring.DelegatingVariableResolver.class)
public class SearchViewModel extends SelectorComposer<Component> {

    @WireVariable
    private PersonService personService = new PersonServiceImpl();
//    private ListModelList<Person> personListModel;
//    private PersonService personService;
    private Integer id;
    private String name;
    private String gender;
    private Date birthday;
    private String employment;
    private String country;
    private String keyword;
    private List<Person> personList;
    private Person selectedPerson;


    public void Person(String name, String gender, Date birthday, String employment, String country) {
        this.name = name;
        this.gender = gender;
        this.birthday = birthday;
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

//    @Command
//    public void delete() {
//        if (selectedPerson == null) {
//            throw new RuntimeException("Please select a user before deleting");
//        }
//        personService.delete(selectedPerson.getId());
//        personList.remove(selectedPerson);
//        System.out.println("--------------------");
//        System.out.println("Id: " + selectedPerson.getId());
//        System.out.println("Username: " + selectedPerson.getName());
//        System.out.println("Gender: " + selectedPerson.getGender());
//        System.out.println("--------------------");
//    }

    @Command
    public void deletePerson() {
//        personService.deletePerson(id);
//        personList.clear();
//        personList.addAll(personService.getPersons());
        if (selectedPerson == null) {
            throw new RuntimeException("Please select a user before deleting");
        }
        personService.deletePerson(selectedPerson.getId());
        personList.remove(selectedPerson);
        System.out.println("--------------------");
        System.out.println("Id: " + selectedPerson.getId());
        System.out.println("Username: " + selectedPerson.getName());
        System.out.println("Gender: " + selectedPerson.getGender());
        System.out.println("--------------------");
    }

//    @Command
//    public void addPerson() {
//        personService.addPerson(this.id, this.name, this.gender, this.birthday, this.employment, this.country);
//        System.out.println(this.id);
//        System.out.println(this.name);
//        System.out.println(this.gender);
//        System.out.println(this.birthday);
//        System.out.println(this.employment);
//        System.out.println(this.country);
//        Executions.sendRedirect("searchMvvm.zul");
//    }

    @Command
    @NotifyChange({"name", "gender", "birthday", "employment", "country"})
    public void add() {
        personService.addPerson(new Person(name, gender, birthday, employment, country));
//        System.out.println(this.id);
//        System.out.println(this.name);
//        System.out.println(this.gender);
//        System.out.println(this.birthday);
//        System.out.println(this.employment);
//        System.out.println(this.country);
        reset();
        Executions.sendRedirect("searchMvvm.zul");
        search();
    }

    @Command
    @NotifyChange("selectedPerson")
    public void search() {
        selectedPerson = null;
        personList.clear();
        personList.addAll(personService.search(keyword));
    }

    @Init
    public void init() throws ParseException {
        personList = new ListModelList<>();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMMM yyyy");
//        personService.addPerson(new Person(
//                            "ZK",
//                            "Male",
//                            dateFormat.parse("2 October 2000"),
//                            "fulltime",
//                            "Indonesia"
//                    )
//            );
//        personService.addPerson(new Person(
//                            "Luka",
//                            "Female",
//                            dateFormat.parse("2 October 2000"),
//                            "fulltime",
//                            "Japan"
//                    )
//        );
        personList.addAll(personService.getPersons());
    }

    @Command
    public void update(@BindingParam("id") String id) {
        Executions.sendRedirect("/updateform.zul?id=" + id);
    }

    public void setKeyword(String keyword) { this.keyword = keyword; }

    public String getKeyword() { return keyword; }

    public List<Person> getPersonList() { return personList; }

    public void setSelectedPerson(Person selectedPerson) {
        this.selectedPerson = selectedPerson;
    }

    public Person getSelectedPerson() { return selectedPerson; }
}
