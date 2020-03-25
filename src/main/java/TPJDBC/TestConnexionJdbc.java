package TPJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestConnexionJdbc {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		Class.forName("com.mysql.cj.jdbc.Driver");
		
		//créer la connexion a la bdd
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3308/compta","root","");
		
		//variable pour faire les requête
		Statement statement = connection.createStatement();
		
/**
        int nbLignesImpactées = statement.executeUpdate("insert into plat(nom,prix) values('super plat', 1500)");

        ResultSet resultSet = statement.executeQuery("select * from plat");

        
        while (resultSet.next()) {
            System.out.println(resultSet.getString("nom") + " " + resultSet.getInt("prix"));
        }

        // étape 5 => libération des ressources
        resultSet.close();
*/
		System.out.println(connection.getNetworkTimeout());
        statement.close();
        connection.close();

	}

}
