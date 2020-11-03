package rest;

import org.neo4j.driver.AuthTokens;
import org.neo4j.driver.Driver;
import org.neo4j.driver.GraphDatabase;
import serveurNeo4j.CreationNode;
import serveurNeo4j.Hobby.Hobbies;
import serveurNeo4j.Question.Question;
import serveurNeo4j.Question.Questions;
import serveurNeo4j.Question.QuestionsRequest;
import serveurNeo4j.Relation.RelationExperience;

import javax.json.JsonObject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.UUID;

@Path("/questions")
public class QuestionsRest {
    Driver driver = GraphDatabase.driver("bolt://localhost:7687", AuthTokens.basic("neo4j", "1234"));


    @POST
    @Path("/CreateQuestion")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String CreateQuestion(JsonObject jsonObject){
        String uuid = jsonObject.getString("uuid");
        String text = jsonObject.getString("text");
        String choice1 = jsonObject.getString("choice1");
        String choice2 = jsonObject.getString("choice2");
        String choice3 = jsonObject.getString("choice3");
        String answer = jsonObject.getString("answer");
        String hobby = jsonObject.getString("hobby");

        UUID uuidQuestion = UUID.randomUUID();
        String randomUUIDString = uuidQuestion.toString();

        QuestionsRequest.CreateQuestions(uuid,text,choice1,choice2,choice3,answer,hobby, randomUUIDString, driver);
        return "{ \"response\": \"" + jsonObject.getString("text") + "\"}";
    }

    @POST
    @Path("/GetQuestionByUuid")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Questions GetQuestionsByuuid(JsonObject jsonObject){
        String uuid = jsonObject.getString("uuid");

        Questions questions = new Questions(QuestionsRequest.GetQuestionsByUuid(uuid,driver));

        return questions;
    }

    @POST
    @Path("/ModifyQuestion")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces("text/plain")
    public String ModifyQuestion(Question question){

        return QuestionsRequest.ModifQuestion(question,driver);
    }



}
