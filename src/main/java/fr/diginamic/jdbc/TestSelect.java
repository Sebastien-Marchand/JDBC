package fr.diginamic.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import fr.diginamic.jdbc.entities.Fournisseur;

public class TestSelect {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		List<Fournisseur> listeFournisseur = new ArrayList<Fournisseur>();
		ResourceBundle db = ResourceBundle.getBundle("db");
        
		Class.forName(db.getString("db.driver"));
		
		//créer la connexion a la bdd
		Connection connection = DriverManager.getConnection(db.getString("db.url"), db.getString("db.user"), db.getString("db.pass"));
		
		//variable pour faire les requête
		Statement statement = connection.createStatement();

        //Rajoute le fournisseur
		ResultSet resultSet = statement.executeQuery("SELECT * FROM `fournisseur`");
        
		while (resultSet.next())
		{
            listeFournisseur.add(new Fournisseur(resultSet.getInt("id") , resultSet.getString("nom")));
        }
		
		for(Fournisseur leFournisseur : listeFournisseur)
		{
			System.out.println("\tID : " + leFournisseur.getId() + "\tNom : " + leFournisseur.getNom());
		}
        statement.close();
        connection.close();

	}

}
