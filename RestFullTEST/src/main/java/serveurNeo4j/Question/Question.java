package serveurNeo4j.Question;

public class Question {

    private String uuid;
    private String text;
    private String choice1;
    private String choice2;
    private String choice3;
    private String answer;
    private String hobby;
    private String uuidQuestion;

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

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getUuidQuestion() {
        return uuidQuestion;
    }

    public void setUuidQuestion(String uuidQuestion) {
        this.uuidQuestion = uuidQuestion;
    }

    public Question(String uuid, String text, String choice1, String choice2, String choice3, String answer, String hobby, String uuidQuestion) {
        this.uuid = uuid;
        this.text = text;
        this.choice1 = choice1;
        this.choice2 = choice2;
        this.choice3 = choice3;
        this.answer = answer;
        this.hobby = hobby;
        this.uuidQuestion = uuidQuestion;
    }

    public Question() {
    }

    @Override
    public String toString() {
        return "Question{" +
                "uuid='" + uuid + '\'' +
                ", text='" + text + '\'' +
                ", choice1='" + choice1 + '\'' +
                ", choice2='" + choice2 + '\'' +
                ", choice3='" + choice3 + '\'' +
                ", answer='" + answer + '\'' +
                ", hobby='" + hobby + '\'' +
                ", uuidQuestion='" + uuidQuestion + '\'' +
                '}';
    }
}
