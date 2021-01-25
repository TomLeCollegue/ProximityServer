package serveurNeo4j.accounts;
import java.sql.*;
import java.util.UUID;

public class Accounts {


    /* Connexion à la base de données */
    public static String URL = "jdbc:mariadb://89.87.13.28:3306/proximity";
    public static String USER = "root";
    public static String PASSWORD = "1234";

    public static void DeleteUser(String email, String password){

        Connection connexion = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connexion = DriverManager.getConnection( URL, USER, PASSWORD );

            /* Création de l'objet gérant les requêtes */
            Statement statement = connexion.createStatement();

            int statut = statement.executeUpdate( "DELETE FROM users "+
                    "WHERE email = '"+ email + "' AND password = '"+ password + "';");

            //int statut = statement.executeUpdate( "INSERT INTO users (email, password) "+
            //        "VALUES ( '"+ email + "','" + password + "');");

            if(statut == 0) {
                System.out.println("LOG : tentative de suppresion de compte fail");

                //TODO retour client fail
            }
            else {
                System.out.println("LOG : compte supprimé avec l'email :" + email);
                //TODO retour client succeed
            }


        } catch ( SQLException e ) {
            System.out.println("error sql");
            e.printStackTrace();
        }
        catch ( Exception e ) {
            e.printStackTrace();
        }

        finally {
            if ( connexion != null )
                try {
                    /* Fermeture de la connexion */
                    connexion.close();
                } catch ( SQLException ignore ) {
                    /* Si une erreur survient lors de la fermeture, il suffit de l'ignorer. */
                    System.out.println("error closing connection");
                }
        }
    }

    public static String SignIn(String email, String password) throws ClassNotFoundException, SQLException {
        String id = "0";

        Class.forName("org.mariadb.jdbc.Driver");

        // create our mysql database connection
        Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);

        // our SQL SELECT query.
        // if you only need a few columns, specify them by name instead of using "*"
        String query = "SELECT * FROM users WHERE email = '" + email + "' AND  password = '" + password + "'";

        // create the java statement
        Statement st = conn.createStatement();

        // execute the query, and get a java resultset
        ResultSet rs = st.executeQuery(query);

        // iterate through the java resultset
        while (rs.next())
        {
            id = rs.getString("uuid");


            // print the results

        }
        st.close();
        return id;
    }

    public static boolean CreateUser(String email, String password, String randomUUIDString) throws ClassNotFoundException, SQLException {
        Class.forName("org.mariadb.jdbc.Driver");

        // create our mysql database connection
        Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);

        // our SQL SELECT query.
        // if you only need a few columns, specify them by name instead of using "*"
        String query = "INSERT INTO users (email, password, uuid) " +
        "SELECT '" + email + "','" + password + "','" + randomUUIDString + "' FROM dual " +
                "WHERE NOT EXISTS (SELECT * FROM users WHERE email = '" + email + "')";

        // create the java statement
        Statement st = conn.createStatement();

        // execute the query, and get a java resultset
        int statut = st.executeUpdate(query);

        // iterate through the java resultset
        if (statut == 0) {
            System.out.println("LOG : tentative de creation de compte avec un email deja existant");
            return false;
        } else {
            System.out.println("LOG : compte crée avec l'email :" + email);
            return true;
        }

    }


}

