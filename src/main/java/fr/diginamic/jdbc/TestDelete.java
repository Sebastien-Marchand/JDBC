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
		
		//cr�er la connexion a la bdd
		Connection connection = DriverManager.getConnection(db.getString("db.url"), db.getString("db.user"), db.getString("db.pass"));
		
		//variable pour faire les requ�te
		Statement statement = connection.createStatement();

        //supprime le fournisseur
        int nbLignesImpact�es = statement.executeUpdate("DELETE FROM fournisseur where fournisseur.id = 4;");
        
		System.out.println(connection +"\nnb ligne modif :"+nbLignesImpact�es);
        statement.close();
        connection.close();

	}

}
