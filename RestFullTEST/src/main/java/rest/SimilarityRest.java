package rest;

import org.neo4j.driver.AuthTokens;
import org.neo4j.driver.Driver;
import org.neo4j.driver.GraphDatabase;
import serveurNeo4j.CreationNode;
import serveurNeo4j.Hobby.Hobbies;
import serveurNeo4j.Person.GetPerson;
import serveurNeo4j.Person.ListOfPerson;
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
import java.util.UUID;

@Path("/similarity")
public class SimilarityRest {

    Driver driver = GraphDatabase.driver("bolt://localhost:7687", AuthTokens.basic("neo4j", "1234"));


    @POST
    @Path("/GetFriendsInCommon")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public ListOfPerson getFriendsInCommun(JsonObject info){

        String uuid = info.getString("uuid");
        String emailDiscovered = info.getString("email");


        return new ListOfPerson(GetPerson.getFriendsInCommun(uuid, emailDiscovered, driver));

    }

    @POST
    @Path("/GetHobbyInCommun")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Hobbies GetHobbyByuuid(JsonObject info){
        String uuid = info.getString("uuid");
        String emailDiscovered = info.getString("email");

        Hobbies hobbies = new Hobbies(RelationExperience.GetHobbyInCommun(uuid,emailDiscovered, driver));

        return hobbies;
    }

}
