package ca.uqam.inf3005.h2015.bm_cg_gv.pizza_yolo.model.element;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Pizza {
	
	private String nom;
	private String photo;
	private List<String> ingredients;
	
	private Map<Taille, Double> taillePrix = new HashMap<Taille, Double>();;
	
	
	public String getNom() {
		return nom;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	

	
	



	public List<String> getIngredients() {
		return ingredients;
	}

	public void setIngredients(List<String> ingredients) {
		this.ingredients = ingredients;
	}
	
	public void setIngredients(String... ingredients) {
		this.ingredients = Arrays.asList(ingredients);
	}





	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}


	
	



	public Map<Taille, Double> getTaillePrix() {
		return taillePrix;
	}

	public void setTaillePrix(Map<Taille, Double> taillePrix) {
		this.taillePrix = taillePrix;
	}

	public void addTaillePrix(Taille t, double p) {
		taillePrix.put(t, p);
	}





	public enum Taille {
		PETIT, MOYEN, GRAND
	}
}
