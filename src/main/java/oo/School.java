package oo;

import java.util.ArrayList;

public class School {
    private ArrayList<Person> persons;

    public School() {
        this.persons = new ArrayList<>();
    }

    public void addPerson(Person person) {
        this.persons.add(person);
    }

    public void startSchool() {
        this.persons.forEach(person -> System.out.println(person.introduce()));
    }
}
