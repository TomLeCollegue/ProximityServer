import org.neo4j.driver.AuthTokens;
import org.neo4j.driver.Driver;
import org.neo4j.driver.GraphDatabase;
import serveurNeo4j.Person.GetPerson;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

@Path("/person")
public class PersonRest {


    @GET
    @Path("/{email}/getByEmail")
    @Produces("text/plain")
    public String getByEmail(@PathParam("email") String email){

        Driver driver = GraphDatabase.driver("bolt://localhost:7687", AuthTokens.basic("neo4j", "1234"));

        return GetPerson.getPersonbyEmail( email , driver).get(0).getFirstname();

    }
}
