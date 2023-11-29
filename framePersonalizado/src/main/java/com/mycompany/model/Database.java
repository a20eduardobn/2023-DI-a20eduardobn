package com.mycompany.model;

import java.io.*;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Database {
    private final List<Person> people;

    public Database() {
        people = new LinkedList<Person>();
    }

    public void saveToFile(File file) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))){
            oos.writeObject(people);
        } catch (IOException ignored){}
    }
    public void loadFromFile(File file){
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))){
            people.clear();
            people.addAll((LinkedList<Person>) ois.readObject());
            if (!people.isEmpty()){
                people.get(0).setCount(people.size());
            }
        } catch (Exception ignored) {}
    }

    public void addPerson(Person person) {
        people.add(person);
    }

    public List<Person> getPeople() {
        return Collections.unmodifiableList(people);
    }

    public void removePeople(int index){people.remove(index);}

}
