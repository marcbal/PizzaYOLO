package ca.uqam.inf3005.h2015.bm_cg_gv.pizza_yolo.model;

import java.util.HashMap;
import java.util.Map;

import ca.uqam.inf3005.h2015.bm_cg_gv.pizza_yolo.model.table.PizzaTable;

public class TableManager {
	private static TableManager instance;
	
	/**
	 * Retourne l'unique instance de la classe. Si elle n'existe pas, on tente de créer
	 * @return L'unique instance de la classe
	 */
	public synchronized static TableManager getInstance() {
		if (instance == null)
			loadNewInstance();
		return instance;
	}
	
	public synchronized static void loadNewInstance() {
		instance = new TableManager();
	}
	
	
	
	
	

	
	private Map<String, AbstractTable> tables;
	
	
	private TableManager() {
		tables = new HashMap<String, AbstractTable>();
		
		/*
		 * Toutes les collections de données persistances sont rangées dans des instance
		 * de sous-classes de AbstractTable
		 */
		tables.put("pizzax", new PizzaTable());
	}
	
	
	

	
	public AbstractTable getTable(String name) {
		return tables.get(name);
	}

}
