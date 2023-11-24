package connect;
import java.sql.*;

public class Connect
{ 
    public Connect(){
    }
    public Connection getConnectionPsql()throws Exception{
        Connection connection;
        //étape 1: charger la classe de driver
        Class.forName("org.postgresql.Driver");
        //étape 2: créer l'objet de connexion
        connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/stock","postgres","motmirado");
        return connection;
    } 
    public Connection getConnectionMysql() throws Exception {
        Connection connection;
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "");
        return connection;
    }

    // public Connection getConnectionMysql()throws Exception{
    //     String url = "jdbc:mysql://localhost:3306/votre_base_de_donnees";
    //     String user = "root";
    //     String password = "";
    //     // public static Connection getConnection() {
    //     //     try {
    //     //         Class.forName("com.mysql.cj.jdbc.Driver");
    //     //         return DriverManager.getConnection(URL, USER, PASSWORD);
    //     //     } catch (ClassNotFoundException | SQLException e) {
    //     //         e.printStackTrace();
    //     //         throw new RuntimeException("Erreur lors de la connexion à la base de données.");
    //     //     }
    //     // }





    //     //String url = "jdbc:mysql://localhost:3306/votre_base_de_donnees";
    //     String utilisateur = "votre_utilisateur";
    //     String motDePasse = "votre_mot_de_passe";
    //     // Étape 4 : Établir la connexion
    //     Connection connexion = DriverManager.getConnection(url, utilisateur, motDePasse);

    // }
    
}