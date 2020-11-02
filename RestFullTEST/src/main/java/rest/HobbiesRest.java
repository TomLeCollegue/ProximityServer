package rest;

import org.neo4j.driver.AuthTokens;
import org.neo4j.driver.Driver;
import org.neo4j.driver.GraphDatabase;
import serveurNeo4j.CreationNode;
import serveurNeo4j.Hobby.Hobbies;
import serveurNeo4j.Hobby.Hobby;
import serveurNeo4j.Person.Person;
import serveurNeo4j.Relation.RelationExperience;
import serveurNeo4j.accounts.Accounts;

import javax.json.JsonObject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.UUID;

@Path("/hobbies")
public class HobbiesRest {
    Driver driver = GraphDatabase.driver("bolt://localhost:7687", AuthTokens.basic("neo4j", "1234"));

    @POST
    @Path("/CreateHobby")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String CreateHobby(JsonObject jsonObject){
        CreationNode.CreateHobby(jsonObject.getString("name"), driver);
        return "{ \"response\": \"" + jsonObject.getString("name") + "\"}";
    }

    @POST
    @Path("/CreateRelationHobbyPerson")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String CreateRelationHobbyPerson(JsonObject jsonObject){
        String uuid = jsonObject.getString("uuid");
        String hobby = jsonObject.getString("hobby");
        RelationExperience.CreateRelationShipExperience(uuid,hobby,driver);
        return "{ \"response\": \"" + jsonObject.getString("hobby") + "\"}";
    }


    @POST
    @Path("/GetHobbyByUuid")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Hobbies GetHobbyByuuid(JsonObject jsonObject){
        String uuid = jsonObject.getString("uuid");

        Hobbies hobbies = new Hobbies(RelationExperience.GetHobbyByUuid(uuid,driver));

        return hobbies;
    }




}
