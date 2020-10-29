package serveurNeo4j;

import org.neo4j.driver.AuthTokens;
import org.neo4j.driver.Driver;
import org.neo4j.driver.GraphDatabase;
import serveurNeo4j.Person.GetPerson;
import serveurNeo4j.Person.ListOfPerson;
import serveurNeo4j.Person.Person;

import javax.json.JsonObject;
import javax.print.attribute.standard.Media;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.awt.*;
import java.util.ArrayList;

@Path("/Friends")
public class FriendsRest {
    Driver driver = GraphDatabase.driver("bolt://localhost:7687", AuthTokens.basic("neo4j", "1234"));

    @POST
    @Path("/getFriendsByUuid")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public ListOfPerson getFriends(JsonObject uuid){
        return new ListOfPerson(GetPerson.getFriends(uuid.getString("uuid"), driver));

    }
}
