package ca.uqam.inf3005.h2015.bm_cg_gv.pizza_yolo.model.table;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ca.uqam.inf3005.h2015.bm_cg_gv.pizza_yolo.model.AbstractTable;
import ca.uqam.inf3005.h2015.bm_cg_gv.pizza_yolo.model.element.Pizza;
import ca.uqam.inf3005.h2015.bm_cg_gv.pizza_yolo.model.element.Pizza.Taille;

public class PizzaTable extends AbstractTable<Pizza> {

	private List<Pizza> pizzas = new ArrayList<Pizza>();
	
	
	public PizzaTable() {
		
		Pizza p;
		
		/*
		 * Les pizzas sont initialisés dans le code source, pour simplifier l'implémentation du site web.
		 * L'énoncé du projet n'impose rien concernant le stockage des données sur les pizzas
		 */

		p = new Pizza();
		p.setPhoto("");
		p.setNom("Pizza 4 fromages");
		p.addTaillePrix(Taille.PETIT, 4);
		p.addTaillePrix(Taille.MOYEN, 5.5);
		p.addTaillePrix(Taille.GRAND, 7);
		p.addTaillePrix(Taille.XXL, 10);
		p.setIngredients("Sauce tomate", "Mozzarella", "chèvre", "Emmental", "Fourme d'Ambert");
		pizzas.add(p);
		
		p = new Pizza();
		p.setPhoto("");
		p.setNom("La reine");
		p.addTaillePrix(Taille.PETIT, 4);
		p.addTaillePrix(Taille.MOYEN, 5.5);
		p.addTaillePrix(Taille.GRAND, 7);
		p.addTaillePrix(Taille.XXL, 10);
		p.setIngredients("Sauce tomate", "Mozzarella", "Champignon", "Jambon");
		pizzas.add(p);
		
		p = new Pizza();
		p.setPhoto("");
		p.setNom("Margherita");
		p.addTaillePrix(Taille.PETIT, 4);
		p.addTaillePrix(Taille.MOYEN, 5.5);
		p.addTaillePrix(Taille.GRAND, 7);
		p.addTaillePrix(Taille.XXL, 10);
		p.setIngredients("Sauce tomate", "Mozzarella");
		pizzas.add(p);
	}
	
	

	@Override
	public Map<Integer, Pizza> getAll() {
		Map<Integer, Pizza> ret = new HashMap<Integer, Pizza>();
		int i = 0;
		for (Pizza p : pizzas) {
			ret.put(i, p);
			i++;
		}
		return ret;
	}
	
	@Override
	public Pizza get(int index) {
		return pizzas.get(index);
	}


	
	
}
