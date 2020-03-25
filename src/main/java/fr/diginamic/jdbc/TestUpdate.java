package fr.diginamic.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class TestUpdate {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		ResourceBundle db = ResourceBundle.getBundle("db");
        
		Class.forName(db.getString("db.driver"));
		
		//créer la connexion a la bdd
		Connection connection = DriverManager.getConnection(db.getString("db.url"), db.getString("db.user"), db.getString("db.pass"));
		
		//variable pour faire les requête
		Statement statement = connection.createStatement();

        //update le nom du fournisseur
        int nbLignesImpactées = statement.executeUpdate("UPDATE fournisseur set fournisseur.nom = 'La Maison des Peinture' where fournisseur.id = 4;");
        
		System.out.println(connection +"\nnb ligne modif :"+nbLignesImpactées);
        statement.close();
        connection.close();

	}

}
