package co.edu.unbosque.wsresttutorial.resources;

import co.edu.unbosque.wsresttutorial.dtos.*;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;
import jakarta.servlet.ServletContext;

import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;



@Path("/users")
public class UsersResource {
    String JDBC_DRIVER = "org.postgresql.Driver";
    private Connection conn;
    @Context
    ServletContext context;

    @GET
    @Path("/verUsuarios")
    @Produces(MediaType.APPLICATION_JSON)
    public Response list(Userdb userx) {


        String contextPath = context.getRealPath("") + File.separator;
        Statement stmt = null;
        String DB_URL = "jdbc:postgresql://localhost/proyectofinal";
        String USER = "postgres";
        String PASS = "123";


        try {

            List<Userdb> userApps = new ArrayList<Userdb>();


            Class.forName(JDBC_DRIVER);
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            String sql = "SELECT*FROM userapp";
            ResultSet rs = stmt.executeQuery(sql);


            while (rs.next()) {
                // Extracting row values by column name
                String email= rs.getString("email");
                String password = rs.getString("password");
                String name = rs.getString("name");
                String role = rs.getString("role");
                System.out.println(email);
                userApps.add(new Userdb(email, password,name,role));
            }


            return Response.ok()
                    .entity(userApps)
                    .build();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }



    @GET
    @Path("/verObras")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listObras(Userdb userx) {


        String contextPath = context.getRealPath("") + File.separator;
        Statement stmt = null;
        String DB_URL = "jdbc:postgresql://localhost/proyectofinal";
        String USER = "postgres";
        String PASS = "123";


        try {

            List<Obra> userApps = new ArrayList<Obra>();


            Class.forName(JDBC_DRIVER);
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            String sql = "SELECT*FROM art";
            System.out.println("comando enviado "+sql);

            ResultSet rs = stmt.executeQuery(sql);


            while (rs.next()) {
                // Extracting row values by column name

                int id= rs.getInt("id");
                String name=rs.getString("name");
                Float price=rs.getFloat("price");
                String imagepath=rs.getString("imagepath");
                boolean forsale=rs.getBoolean("forsale");
                int collection=rs.getInt("collection");


                userApps.add(new Obra(id,name,price,imagepath,forsale,collection));
            }


            return Response.ok()
                    .entity(userApps)
                    .build();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }


    @POST
    @Path("/crearColeccion")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createObra(Coleccion coleccion) {

        String contextPath = context.getRealPath("") + File.separator;
        Statement stmt = null;
        String DB_URL = "jdbc:postgresql://localhost/proyectofinal";
        String USER = "postgres";
        String PASS = "123";


        try {

            Class.forName(JDBC_DRIVER);
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            // Executing a SQL query
            System.out.println("El nombre de la coleccion es  " + coleccion.getName());
            System.out.println("La descripcion es " + coleccion.getDescripcion());
            System.out.println("La categoria es " + coleccion.getCategory());



            stmt = conn.createStatement();
            String sql = "INSERT INTO collection (name,description,category)" +
                    "values " + "('" + coleccion.getName() + "','" + coleccion.getDescripcion() + "','" + coleccion.getCategory() + "')";

            System.out.println("comando para insertar obra ->  "+sql);

            ResultSet rs = stmt.executeQuery(sql);

            rs.close();
            stmt.close();

            return Response.created(UriBuilder.fromResource(UsersResource.class).path(coleccion.getName()).build())
                    .entity(coleccion)
                    .build();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }




    @POST
    @Path("/CrearObra")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createObra(Obra obra) {

        String contextPath = context.getRealPath("") + File.separator;
        Statement stmt = null;
        String DB_URL = "jdbc:postgresql://localhost/proyectofinal";
        String USER = "postgres";
        String PASS = "123";


        try {

            Class.forName(JDBC_DRIVER);
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            // Executing a SQL query
            System.out.println("El id de la obra es " + obra.getId());
            System.out.println("El nombre de la obra es " + obra.getName());
            System.out.println("El precio de la obra es " + obra.getPrice());
            System.out.println("La url de la imagen es  " + obra.getImagepath());
            System.out.println("Se encuentra a la venta?  " + obra.getForsale());
            System.out.println("Le coleccion es  :  " + obra.getCollection());


            stmt = conn.createStatement();
            String sql = "INSERT INTO art (name,price,imagepath)" +
                    "values " + "('" + obra.getName() + "'," + obra.getPrice() + "," + obra.getImagepath() + ")";

            System.out.println("comando para insertar obra ->  "+sql);

            ResultSet rs = stmt.executeQuery(sql);

            rs.close();
            stmt.close();

            return Response.created(UriBuilder.fromResource(UsersResource.class).path(obra.getName()).build())
                    .entity(obra)
                    .build();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @POST
    @Path("/UpdatePrecio")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public void updatePrecio(Obra obra) {



        // Object for handling SQL statement
        PreparedStatement stmt = null;

        try {

            // Executing a SQL query
            System.out.println("=> Updating Precio...");
            stmt = this.conn.prepareStatement("UPDATE Obra SET price = ? WHERE id = ?");
            stmt.setString(1, String.valueOf(obra.getPrice()));
            stmt.setInt(2, obra.getId());
            int rowsUpdated = stmt.executeUpdate(); // executeUpdate is also used for inserting records

            // Printing results
            System.out.println("Rows updated: " + rowsUpdated + "\n");

            // Closing resources
            stmt.close();
        } catch (SQLException se) {
            se.printStackTrace(); // Handling errors from database
        } finally {
            // Cleaning-up environment
            try {
                if (stmt != null) stmt.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }


    @POST
    @Path("/recargar")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response recargar(Persona user) {

        String contextPath = context.getRealPath("") + File.separator;
        Statement stmt = null;
        String DB_URL = "jdbc:postgresql://localhost/proyectofinal";
        String USER = "postgres";
        String PASS = "123";

        try {
            //  user = new UserService().createUser(user.getUsername(),user.getPassword(), user.getRole(), contextPath);

            Class.forName(JDBC_DRIVER);
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();

            String sql = "UPDATE  persona SET fcoins ="+user.getfcoins() +" WHERE name =" +user.getNombre();

            ResultSet rs = stmt.executeQuery(sql);

            rs.close();

            stmt.close();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);

        }
    return null;

    }



    @POST
    @Path("/CrearUsuario")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createUser(User user) {

        String contextPath = context.getRealPath("") + File.separator;
        Statement stmt = null;
        String DB_URL = "jdbc:postgresql://localhost/proyectofinal";
        String USER = "postgres";
        String PASS = "123";

        try {

            Class.forName(JDBC_DRIVER);
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            // Executing a SQL query

            stmt = conn.createStatement();
            String sql = "INSERT INTO  userapp (email,password,name,role) values " + "('" + user.getEmail()+ "','" + user.getPassword() + "','" + user.getName() + "','" + user.getRole()+"')";
            ResultSet rs = stmt.executeQuery(sql);
            rs.close();
            stmt.close();

            return Response.created(UriBuilder.fromResource(UsersResource.class).path(user.getName()).build())
                    .entity(user)
                    .build();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


    @POST
    @Path("/autenticar")
    @Produces(MediaType.APPLICATION_JSON)
    public Response autenticar(Userdb userx) {

        String contextPath = context.getRealPath("") + File.separator;
        Statement stmt = null;
        String DB_URL = "jdbc:postgresql://localhost/proyectofinal";
        String USER = "postgres";
        String PASS = "123";


        try {
           // List<User> users = new UserService().getUsers();
            List<Userdb> userApps = new ArrayList<Userdb>();

            Class.forName(JDBC_DRIVER);
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            String sql = "SELECT*FROM userapp";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                // Extracting row values by column name

                String email = rs.getString("email");
                String password = rs.getString("password");
                String name = rs.getString("name");
                String role = rs.getString("role");

                System.out.println(email);
                System.out.println(role);
                userApps.add(new Userdb(email, password,name, role));
            }

            String email = userx.getEmail();
            String password = userx.getPassword();


            Userdb user = userApps.stream()

                    .filter(u -> u.getEmail().equals(email) && u.getPassword().equals(password))
                    .findFirst()
                    .orElse(null);

            if (user != null) {

                return Response.status(200)
                        .entity(user)
                        .build();


            } else {

                return Response.status(404)
                        .entity(new ExceptionMessage(404, "Credenciales incorrectas"))
                        .build();
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }


    @GET
    @Path("/{username}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getobras(@PathParam("username") String email) {

        List<Userdb> userApps = new ArrayList<Userdb>();


        Userdb user = userApps.stream()
                .filter(u -> u.getEmail().equals(email))
                .findFirst()
                .orElse(null);

        if (user != null) {
            return Response.ok()
                    .entity(user)
                    .build();
        } else {
            return Response.status(404)
                    .entity(new ExceptionMessage(404, "User not found"))
                    .build();
        }
    }


    @POST
    @Path("/form")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response createForm(
            @FormParam("username") String username,
            @FormParam("password") String password,
            @FormParam("role") int role
    ) {
        String contextPath = context.getRealPath("") + File.separator;


   return null;

    }
}
