package serveurNeo4j;

import serveurNeo4j.Person.Person;
import serveurNeo4j.accounts.Accounts;

import javax.json.Json;
import javax.ws.rs.*;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;

@Path("/account")
public class AccountRest {


    @POST
    @Path("/signUP")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces("text/plain")
    public String SignUP(Person person){

        if(Accounts.CreateUser(person.getEmail(), "1234")){
            return person.getEmail();
        }
        else{
            return "mail error";
        }
    }
}
