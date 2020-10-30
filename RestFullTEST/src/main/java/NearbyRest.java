import org.neo4j.driver.AuthTokens;
import org.neo4j.driver.Driver;
import org.neo4j.driver.GraphDatabase;
import serveurNeo4j.Person.GetPerson;
import serveurNeo4j.Person.Person;

import javax.json.JsonObject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.awt.*;

@Path("/nearby")
public class NearbyRest {


    @POST
    @Path("/newDiscovery")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Person getByEmail(JsonObject jsonObject){

        Driver driver = GraphDatabase.driver("bolt://localhost:7687", AuthTokens.basic("neo4j", "1234"));

        return GetPerson.getPersonbyEmail( jsonObject.getString("email") , driver).get(0);

    }
}
