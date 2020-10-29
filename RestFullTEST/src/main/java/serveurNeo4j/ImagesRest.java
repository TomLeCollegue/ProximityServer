package serveurNeo4j;

import javax.ws.rs.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.rmi.RemoteException;

@Path("/images")
public class ImagesRest {

    @GET
    @Path("/{email}/download")
    @Produces("text/plain")
    public byte[] download(@PathParam("email") String email) throws IOException {
        String fileName = email + "_pic.jpg";
        return get(fileName);

    }

    public static byte[] get(String _fileName) throws RemoteException, IOException, OutOfMemoryError{
        java.nio.file.Path path = Paths.get("C:\\Users\\tomku\\Desktop\\Serveur Proximity\\ProximityServer\\RestFullTEST\\images\\" + _fileName);

        byte[] _array = Files.readAllBytes(path);
        return _array;
    }


}
