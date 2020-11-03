package serveurNeo4j.Question;

import java.util.ArrayList;

public class Questions {

    private ArrayList<Question> questions = new ArrayList<Question>();

    public Questions(ArrayList<Question> questions) {
        this.questions = questions;
    }

    public ArrayList<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(ArrayList<Question> questions) {
        this.questions = questions;
    }

    @Override
    public String toString() {
        return "Questions{" +
                "questions=" + questions +
                '}';
    }
}
