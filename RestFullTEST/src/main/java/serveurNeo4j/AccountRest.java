package serveurNeo4j;

import org.neo4j.driver.AuthTokens;
import org.neo4j.driver.Driver;
import org.neo4j.driver.GraphDatabase;
import serveurNeo4j.Person.InfoAccount;
import serveurNeo4j.Person.Person;
import serveurNeo4j.accounts.Accounts;

import javax.json.Json;
import javax.ws.rs.*;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import java.sql.SQLException;
import java.util.UUID;

@Path("/account")
public class AccountRest {
    Driver driver = GraphDatabase.driver("bolt://localhost:7687", AuthTokens.basic("neo4j", "1234"));


    @POST
    @Path("/signUP")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces("text/plain")
    public String SignUP(Person person) throws SQLException, ClassNotFoundException {


        UUID uuid = UUID.randomUUID();
        String randomUUIDString = uuid.toString();

        if(Accounts.CreateUser(person.getEmail(), person.getPassword() , randomUUIDString)){
            CreationNode.CreatePerson(person.getName(), person.getFirstname(), person.getEmail(), person.getAge(), randomUUIDString, driver);


            return person.getEmail();
        }
        else{
            return "mail error";
        }
    }

    @POST
    @Path("/signIn")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String SignIN(InfoAccount info) throws SQLException, ClassNotFoundException {


        String uuid = Accounts.SignIn(info.getMail(), info.getPassword());
        String id = "{\"id\":\""+ uuid + "\" }";
        return id;
    }

}
