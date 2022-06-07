package co.edu.unbosque.wsresttutorial.resources;

import jakarta.servlet.ServletContext;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.MultivaluedMap;
import jakarta.ws.rs.core.Response;

import org.jboss.resteasy.plugins.providers.multipart.InputPart;
import org.jboss.resteasy.plugins.providers.multipart.MultipartFormDataInput;

import java.io.*;
import java.util.List;
import java.util.Map;

@Path("/users/{username}/avatars")
public class AvatarsResource {

    @Context
    ServletContext context;

    private final String UPLOAD_DIRECTORY = "/Obras/";

    @POST
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces(MediaType.TEXT_PLAIN)
    public Response uploadFile(@PathParam("username") String username, MultipartFormDataInput input) {
        String fileName = "";

        try {
            // Getting the file from form input
            Map<String, List<InputPart>> formParts = input.getFormDataMap();

            // Extracting text by input name
            if (formParts.get("filename") != null) {
                fileName = formParts.get("filename").get(0).getBodyAsString();
            }

            // Extracting multipart by input name
            List<InputPart> inputParts = formParts.get("avatar");

            for (InputPart inputPart : inputParts) {
                // If file name is not specified as input, use default file name
                if (fileName.equals("") || fileName == null) {
                    // Retrieving headers and reading the Content-Disposition header to file name
                    MultivaluedMap<String, String> headers = inputPart.getHeaders();
                    fileName = parseFileName(headers);
                }

                // Handling the body of the part with an InputStream
                InputStream istream = inputPart.getBody(InputStream.class,null);

                // Saving the file on disk
                saveFile(istream, fileName, context);
            }

            return Response.status(201)
                    .entity("Obra subida correctamente " + username)
                    .build();
        } catch (IOException e) {
            return Response.serverError().build();
        }
    }

    // Parse Content-Disposition header to get the file name
    private String parseFileName(MultivaluedMap<String, String> headers) {
        String[] contentDispositionHeader = headers.getFirst("Content-Disposition").split(";");

        for (String name : contentDispositionHeader) {
            if ((name.trim().startsWith("filename"))) {
                String[] tmp = name.split("=");
                String fileName = tmp[1].trim().replaceAll("\"","");
                return fileName;
            }
        }

        return "unknown";
    }

    // Save uploaded file to a defined location on the server
    private void saveFile(InputStream uploadedInputStream, String fileName, ServletContext context) {
        int read = 0;
        byte[] bytes = new byte[1024];

        try {


            // Complementing servlet path with the relative path on the server
            String uploadPath = context.getRealPath("/assets/img/")+UPLOAD_DIRECTORY;


            System.out.println(uploadPath);
            // Creating the upload folder, if not exist
            File uploadDir = new File(uploadPath);


            if (!uploadDir.exists()) uploadDir.mkdir();

            // Persisting the file by output stream
            OutputStream outpuStream = new FileOutputStream(uploadPath + fileName+".jpg");


            while ((read = uploadedInputStream.read(bytes)) != -1) {
                outpuStream.write(bytes, 0, read);
            }

            outpuStream.flush();
            outpuStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}