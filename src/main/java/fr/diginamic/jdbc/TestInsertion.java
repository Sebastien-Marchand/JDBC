package fr.diginamic.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class TestInsertion {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		ResourceBundle db = ResourceBundle.getBundle("db");
        
		Class.forName(db.getString("db.driver"));
		
		//créer la connexion a la bdd
		Connection connection = DriverManager.getConnection(db.getString("db.url"), db.getString("db.user"), db.getString("db.pass"));
		
		//variable pour faire les requête
		Statement statement = connection.createStatement();

        //Rajoute le fournisseur
        int nbLignesImpactées = statement.executeUpdate("insert into fournisseur(id,nom) values('4', 'La Maison de la Peinture')");
        
		System.out.println(connection +"\n"+nbLignesImpactées);
        statement.close();
        connection.close();
        
	}

}
