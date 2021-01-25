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
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.UUID;

@Path("/hobbies")
public class HobbiesRest {
    Driver driver = GraphDatabase.driver("bolt://89.87.13.28:62015", AuthTokens.basic("neo4j", "1234"));

    @POST
    @Path("/CreateHobby")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String CreateHobby(JsonObject jsonObject){
        CreationNode.CreateHobby(jsonObject.getString("name"), driver);
        return "{ \"response\": \"" + jsonObject.getString("name") + "\"}";
    }

    @POST
    @Path("/{name}/CreateHobby")
    @Produces(MediaType.APPLICATION_JSON)
    public String CreateHobby(byte[] image, @PathParam("name") String name) throws IOException {
        CreationNode.CreateHobby(name, driver);

        File theDir = new File(System.getProperty("com.sun.aas.installRoot") + "/proximity");
        if (!theDir.exists()){
            theDir.mkdirs();
        }

        File theDir2 = new File(System.getProperty("com.sun.aas.installRoot") + "/proximity/images_hobbies");
        if (!theDir2.exists()){
            theDir2.mkdirs();
        }
        String filePath = System.getProperty("com.sun.aas.installRoot") + "/proximity/images_hobbies/" + name + "_pic.png";
        File file = new File(filePath);
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(image);
        fos.close();
        return "{ \"response\": \"" + name + "\"}";
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

    @POST
    @Path("/GetAllHobbies")
    @Produces(MediaType.APPLICATION_JSON)
    public Hobbies GetHobbies(){

        Hobbies hobbies = new Hobbies(RelationExperience.GetAllHobbies(driver));

        return hobbies;
    }



}
