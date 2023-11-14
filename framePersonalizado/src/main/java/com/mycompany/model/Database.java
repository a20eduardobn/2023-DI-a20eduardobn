package com.mycompany.model;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Database {
    private List<Person> people;

    public Database(){
        people = new LinkedList<Person>();
    }

    public void addPerson(Person person) {
        people.add(person);
    }

    public List<Person> getPeople() {
        return Collections.unmodifiableList(people);
    }
}
