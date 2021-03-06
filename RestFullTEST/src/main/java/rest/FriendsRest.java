package rest;

import org.neo4j.driver.AuthTokens;
import org.neo4j.driver.Driver;
import org.neo4j.driver.GraphDatabase;
import serveurNeo4j.Person.GetPerson;
import serveurNeo4j.Person.ListOfPerson;
import serveurNeo4j.Person.Person;
import serveurNeo4j.Relation.RelationFriends;

import javax.json.JsonObject;
import javax.print.attribute.standard.Media;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.awt.*;
import java.util.ArrayList;

@Path("/Friends")
public class FriendsRest {
    Driver driver = GraphDatabase.driver("bolt://89.87.13.28:62015", AuthTokens.basic("neo4j", "1234"));

    @POST
    @Path("/getFriendsByUuid")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public ListOfPerson getFriends(JsonObject uuid){
        return new ListOfPerson(GetPerson.getFriends(uuid.getString("uuid"), driver));

    }

    @POST
    @Path("/getDiscoveredByUuid")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public ListOfPerson getDiscovered(JsonObject uuid){
        return new ListOfPerson(GetPerson.GetPersonDiscovered(uuid.getString("uuid"), driver));

    }


    @POST
    @Path("/AcceptPerson")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public String Accept(JsonObject jsonObject){
        String uuid = jsonObject.getString("uuid");
        String emailPerson = jsonObject.getString("emailPerson");

        RelationFriends.CreateRelationShipAccepted(uuid,emailPerson,driver);
        RelationFriends.CreateRelationShipFriendsIfTwoAccepted(uuid,emailPerson,driver);

        return "{ \"response\": \"ok\" }";

    }

}
