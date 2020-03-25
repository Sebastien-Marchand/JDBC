package TPJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class TestConnexionJdbc {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

        ResourceBundle db = ResourceBundle.getBundle("db");
        
        ResourceBundle db2 = ResourceBundle.getBundle("BDDCloud");
		Class.forName(db2.getString("db.driver"));
		
		//cr�er la connexion a la bdd
		Connection connection = DriverManager.getConnection(db2.getString("db.url"), db2.getString("db.user"), db2.getString("db.pass"));
		
		//variable pour faire les requ�te
		Statement statement = connection.createStatement();
/**
        int nbLignesImpact�es = statement.executeUpdate("insert into plat(nom,prix) values('super plat', 1500)");

        ResultSet resultSet = statement.executeQuery("select * from plat");

        
        while (resultSet.next()) {
            System.out.println(resultSet.getString("nom") + " " + resultSet.getInt("prix"));
        }

        // �tape 5 => lib�ration des ressources
        resultSet.close();
*/
		System.out.println(connection);
        statement.close();
        connection.close();

	}

}
