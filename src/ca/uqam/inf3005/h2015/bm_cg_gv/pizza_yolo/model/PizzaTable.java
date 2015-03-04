package ca.uqam.inf3005.h2015.bm_cg_gv.pizza_yolo.model;

import java.util.ArrayList;
import java.util.List;

public class PizzaTable {

	private List<Pizza> pizzas = new ArrayList<Pizza>();
	
	
	public PizzaTable() {
		
		Pizza p;
		
		/*
		 * Les pizzas sont initialisés dans le code source, pour simplifier l'implémentation du site web.
		 * L'énoncé du projet n'impose rien concernant le stockage des données sur les pizzas
		 */
		
		p = new Pizza();
		p.setNom("Pizza 4 fromages");
		p.setIngredients("Sauce tomate", "Mozzarella", "chèvre", "Emmental", "Fourme d'Ambert");
		pizzas.add(p);
	}
	
}
