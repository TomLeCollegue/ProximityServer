package rest;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.awt.*;
import java.io.File;
import java.io.FileOutputStream;
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
        java.nio.file.Path path = Paths.get("C:\\Users\\Tom\\Desktop\\Proximity\\ProximityServer\\RestFullTEST\\images\\" + _fileName);

        byte[] _array = Files.readAllBytes(path);
        return _array;
    }


    @POST
    @Path("/{email}/upload")
    @Produces("text/plain")
    public String Upload(byte[] image, @PathParam("email") String email) throws Exception{
        String filePath = "C:\\Users\\Tom\\Desktop\\Proximity\\ProximityServer\\RestFullTEST\\images\\" + email + "_pic.jpg";
        File file = new File(filePath);
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(image);
        fos.close();

        return "email";
    }



}
