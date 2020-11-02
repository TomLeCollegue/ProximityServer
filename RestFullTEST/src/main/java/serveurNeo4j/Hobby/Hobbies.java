package serveurNeo4j.Hobby;

import java.util.ArrayList;

public class Hobbies {
    private ArrayList<Hobby> hobbies = new ArrayList<Hobby>();

    public ArrayList<Hobby> getHobbies() {
        return hobbies;
    }

    public void setHobbies(ArrayList<Hobby> hobbies) {
        this.hobbies = hobbies;
    }

    public Hobbies(ArrayList<Hobby> hobbies) {
        this.hobbies = hobbies;
    }

    @Override
    public String toString() {
        return "Hobbies{" +
                "hobbies=" + hobbies +
                '}';
    }
}
