package serveurNeo4j.Question;

import serveurNeo4j.Hobby.Hobby;
import serveurNeo4j.Person.Person;

public class Question {

    private Person person;
    private String text;
    private String choice1;
    private String choice2;
    private String choice3;
    private String answer;
    private Hobby hobby;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getChoice1() {
        return choice1;
    }

    public void setChoice1(String choice1) {
        this.choice1 = choice1;
    }

    public String getChoice2() {
        return choice2;
    }

    public void setChoice2(String choice2) {
        this.choice2 = choice2;
    }

    public String getChoice3() {
        return choice3;
    }

    public void setChoice3(String choice3) {
        this.choice3 = choice3;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Hobby getHobby() {
        return hobby;
    }

    public void setHobby(Hobby hobby) {
        this.hobby = hobby;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Question(Person person, String text, String choice1, String choice2, String choice3, String answer, Hobby hobby) {
        this.text = text;
        this.choice1 = choice1;
        this.choice2 = choice2;
        this.choice3 = choice3;
        this.answer = answer;
        this.hobby = hobby;
        this.person = person;
    }


    @Override
    public String toString() {
        return "Question{" +
                "text='" + text + '\'' +
                ", choice1='" + choice1 + '\'' +
                ", choice2='" + choice2 + '\'' +
                ", choice3='" + choice3 + '\'' +
                ", answer='" + answer + '\'' +
                ", hobby=" + hobby +
                '}';
    }
}
