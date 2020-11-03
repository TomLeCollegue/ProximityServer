package rest;


import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.stream.ImageOutputStream;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.rmi.RemoteException;
import java.util.Iterator;

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
        java.nio.file.Path path = Paths.get("C:\\Users\\Tom\\Desktop\\Proximity\\ProximityServer\\RestFullTEST\\images_users\\" + _fileName);

        byte[] _array = Files.readAllBytes(path);
        return _array;
    }

    @GET
    @Path("/{email}/downloadLow")
    @Produces("text/plain")
    public byte[] downloadLow(@PathParam("email") String email) throws IOException {
        String fileName = email + "_pic.jpg";
        return getLow(fileName);

    }

    //compressImagesBeforeSending
    public byte[] getLow(String _fileName) throws RemoteException, IOException, OutOfMemoryError{

        java.nio.file.Path pathCompressed = Paths.get("C:\\Users\\Tom\\Desktop\\Proximity\\ProximityServer\\RestFullTEST\\images_users\\compressed_" + _fileName);
        byte[] _array = Files.readAllBytes(pathCompressed);

        return _array;
    }

    //compressImagesBeforeSending
    public void CompressImage(String _fileName) throws RemoteException, IOException, OutOfMemoryError{
        java.nio.file.Path path = Paths.get("C:\\Users\\Tom\\Desktop\\Proximity\\ProximityServer\\RestFullTEST\\images_users\\" + _fileName);

        File input = new File(String.valueOf(path));
        BufferedImage image;
        image = ImageIO.read(input);

        File compressedImageFile = new File("C:\\Users\\Tom\\Desktop\\Proximity\\ProximityServer\\RestFullTEST\\images_users\\compressed_" + _fileName);
        OutputStream os = new FileOutputStream(compressedImageFile);

        Iterator<ImageWriter> writers = ImageIO.getImageWritersByFormatName("jpg");
        ImageWriter writer = (ImageWriter) writers.next();

        ImageOutputStream ios = ImageIO.createImageOutputStream(os);
        writer.setOutput(ios);

        ImageWriteParam param = writer.getDefaultWriteParam();

        param.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
        param.setCompressionQuality(0.005f);  // Change the quality value you prefer
        writer.write(null, new IIOImage(image, null, null), param);

        os.close();
        ios.close();
        writer.dispose();
    }



    @POST
    @Path("/{email}/upload")
    @Produces("text/plain")
    public String Upload(byte[] image, @PathParam("email") String email) throws Exception{
        String filePath = "C:\\Users\\Tom\\Desktop\\Proximity\\ProximityServer\\RestFullTEST\\images_users\\" + email + "_pic.jpg";
        File file = new File(filePath);
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(image);
        fos.close();
        CompressImage(email +"_pic.jpg");

        return "email";
    }


    @GET
    @Path("/{name}/downloadPicHobby")
    @Produces("text/plain")
    public byte[] downloadPicHobby(@PathParam("name") String name) throws IOException {
        String fileName = name + "_pic.png";
        return getPicHobby(fileName);

    }

    public static byte[] getPicHobby(String _fileName) throws RemoteException, IOException, OutOfMemoryError{
        java.nio.file.Path path = Paths.get("C:\\Users\\Tom\\Desktop\\Proximity\\ProximityServer\\RestFullTEST\\images_hobbies\\" + _fileName);

        byte[] _array = Files.readAllBytes(path);
        return _array;
    }




}
