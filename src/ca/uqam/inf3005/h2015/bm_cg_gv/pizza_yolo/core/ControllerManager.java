/**
 * 
 */
package ca.uqam.inf3005.h2015.bm_cg_gv.pizza_yolo.core;

import java.util.HashMap;
import java.util.Map;

import ca.uqam.inf3005.h2015.bm_cg_gv.pizza_yolo.controllers.ControllerIndex;

/**
 * Classe gérant les Controleurs. Le système de réflexion de java étant plus compliqués,
 * nous préférons utiliser une classe qui recense tout les contrôleurs plutot que
 * de les appeler via la réfexion Java.
 * 
 */
public class ControllerManager {
	
	private static ControllerManager instance;
	
	/**
	 * Retourne l'unique instance de la classe. Si elle n'existe pas, on tente de créer
	 * @return L'unique instance de la classe
	 */
	public synchronized static ControllerManager getInstance() {
		if (instance == null)
			loadNewInstance();
		return instance;
	}
	
	public synchronized static void loadNewInstance() {
		instance = new ControllerManager();
	}
	
	
	
	
	private Map<String, AbstractController> controllers;
	public final String defaultController;
	
	
	private ControllerManager() {
		controllers = new HashMap<String, AbstractController>();
		
		controllers.put("index", new ControllerIndex());
		
		defaultController = "index";
	}
	
	
	
	public AbstractController getController(String name) {
		return controllers.get(name);
	}
	

}
