package serveurNeo4j.Question;

import java.util.ArrayList;

public class QuestionsAnwers {

    private ArrayList<uuidAnswer> answers = new ArrayList<uuidAnswer>();

    private String uuid;

    public QuestionsAnwers() {
    }

    public QuestionsAnwers(ArrayList<uuidAnswer> answers, String uuid) {
        this.answers = answers;
        this.uuid = uuid;
    }

    public ArrayList<uuidAnswer> getAnswers() {
        return answers;
    }

    public void setAnswers(ArrayList<uuidAnswer> answers) {
        this.answers = answers;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    @Override
    public String toString() {
        return "QuestionsAnwers{" +
                "answers=" + answers +
                ", uuid='" + uuid + '\'' +
                '}';
    }
}
