package serveurNeo4j.Person;

import java.util.ArrayList;

public class ListOfPerson {

    private ArrayList<Person> persons;

    public ListOfPerson(ArrayList<Person> persons) {
        this.persons = persons;
    }

    public ArrayList<Person> getPersons() {
        return persons;
    }

    public void setPersons(ArrayList<Person> persons) {
        this.persons = persons;
    }

    @Override
    public String toString() {
        return "ListOfPerson{" +
                "persons=" + persons +
                '}';
    }
}
