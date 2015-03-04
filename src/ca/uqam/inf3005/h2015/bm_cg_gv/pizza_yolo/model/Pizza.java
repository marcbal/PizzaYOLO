package ca.uqam.inf3005.h2015.bm_cg_gv.pizza_yolo.model;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Pizza {
	
	private String nom;
	private String photo;
	private List<String> ingredients;
	
	private Map<Taille, Double> taillePrix;
	
	
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





	public enum Taille {
		PETIT, MOYEN, GRAND
	}
}
