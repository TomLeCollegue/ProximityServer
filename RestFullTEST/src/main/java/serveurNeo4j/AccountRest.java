package serveurNeo4j;

import serveurNeo4j.Person.InfoAccount;
import serveurNeo4j.Person.Person;
import serveurNeo4j.accounts.Accounts;

import javax.json.Json;
import javax.ws.rs.*;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import java.sql.SQLException;

@Path("/account")
public class AccountRest {


    @POST
    @Path("/signUP")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces("text/plain")
    public String SignUP(Person person) throws SQLException, ClassNotFoundException {

        if(Accounts.CreateUser(person.getEmail(), "1234")){
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
