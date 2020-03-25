package fr.diginamic.jdbc.entities;

public class Fournisseur {

	/**Getter
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**Getter
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}
	int id;
	String nom;
	public Fournisseur(int id, String nom) {
		super();
		this.id = id;
		this.nom = nom;
	}
}
