package serveurNeo4j.accounts;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Accounts {


    /* Connexion à la base de données */
    public static String URL = "jdbc:mariadb://127.0.0.1:3306/proximity";
    public static String USER = "root";
    public static String PASSWORD = "vivelinfocom2020";

    public static void CreateUser(String email, String password){

        Connection connexion = null;
        try {
            connexion = DriverManager.getConnection( URL, USER, PASSWORD );

            /* Création de l'objet gérant les requêtes */
            Statement statement = connexion.createStatement();

            int statut = statement.executeUpdate( "INSERT INTO users (email, password) "+
                    "SELECT '"+ email + "','" + password + "' FROM dual " +
                    "WHERE NOT EXISTS (SELECT * FROM users WHERE email = '"+ email + "');");

            if(statut == 0) {
                System.out.println("LOG : tentative de creation de compte avec un email deja existant");

                //TODO retour client fail
            }
            else {
                System.out.println("LOG : compte crée avec l'email :" + email);
                //TODO retour client succeed
            }



        } catch ( SQLException e ) {
            System.out.println("error sql");
        } finally {
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


    public static void DeleteUser(String email, String password){

        Connection connexion = null;
        try {
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
        } finally {
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
}
