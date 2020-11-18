package serveurNeo4j.Question;

import java.util.ArrayList;

public class ResultQuizz {
    ArrayList<QuestionResult> questionResults = new ArrayList<QuestionResult>();

    public ResultQuizz(ArrayList<QuestionResult> questionResults) {
        this.questionResults = questionResults;
    }

    public ResultQuizz() {
    }

    public ArrayList<QuestionResult> getQuestionResults() {
        return questionResults;
    }

    public void setQuestionResults(ArrayList<QuestionResult> questionResults) {
        this.questionResults = questionResults;
    }

    @Override
    public String toString() {
        return "ResultQuizz{" +
                "questionResults=" + questionResults +
                '}';
    }
}
