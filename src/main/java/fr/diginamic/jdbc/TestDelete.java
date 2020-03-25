package fr.diginamic.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class TestDelete {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		ResourceBundle db = ResourceBundle.getBundle("db");
        
		Class.forName(db.getString("db.driver"));
		
		//créer la connexion a la bdd
		Connection connection = DriverManager.getConnection(db.getString("db.url"), db.getString("db.user"), db.getString("db.pass"));
		
		//variable pour faire les requête
		Statement statement = connection.createStatement();

        //supprime le fournisseur
        int nbLignesImpactées = statement.executeUpdate("DELETE FROM fournisseur where fournisseur.id = 4;");
        
		System.out.println(connection +"\nnb ligne modif :"+nbLignesImpactées);
        statement.close();
        connection.close();

	}

}
