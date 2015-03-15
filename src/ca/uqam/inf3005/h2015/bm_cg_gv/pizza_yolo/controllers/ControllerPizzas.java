package ca.uqam.inf3005.h2015.bm_cg_gv.pizza_yolo.controllers;

import java.io.IOException;

import javax.servlet.ServletException;

import ca.uqam.inf3005.h2015.bm_cg_gv.pizza_yolo.beans.TemplateBean;
import ca.uqam.inf3005.h2015.bm_cg_gv.pizza_yolo.core.AbstractController;
import ca.uqam.inf3005.h2015.bm_cg_gv.pizza_yolo.core.RequestApplication;
import ca.uqam.inf3005.h2015.bm_cg_gv.pizza_yolo.model.TableManager;
import ca.uqam.inf3005.h2015.bm_cg_gv.pizza_yolo.model.element.Pizza;

public class ControllerPizzas extends AbstractController {



	@Override
	public void runAction(RequestApplication app, String action) throws ServletException, IOException {
		
		if ("liste".equals(action))
			liste(app);
		else if ("details".equals(action))
			details(app);
		else
			liste(app);
		
		 
		
		// defaultAction(app);
	}


	
	
	/*
	 * Page d'accueil du site. Fait la liste des type de pizza en donnant certains détails
	 */
	public void liste(RequestApplication app) throws ServletException, IOException {
		setContentTypeHTML(app);
		setTemplateBean(new TemplateBean("Liste des pizzas"), app);
		
		app.request.setAttribute("pizzas", TableManager.getInstance().getTable("pizza").getAll());

		runVueJSP("template_head.jsp", app);
		runVueJSP("pizzas_liste.jsp", app);
		runVueJSP("template_foot.jsp", app);
	}

	
	
	
	
	/*
	 * Page affiché lorsque l'utilisateur a choisi le type de pizza et la taille.
	 * Un premier formulaire lui sera présenté lui permettant de donner des détails sur la pizza.
	 */
	public void details(RequestApplication app) throws ServletException, IOException {
		setContentTypeHTML(app);
		setTemplateBean(new TemplateBean("Commander une pizza"), app);
		
		if (app.urlParams.length < 2)
			throw new IllegalArgumentException("Le contrôleur nécessite deux paramètres");
		
		Pizza p = null;
		int pizza_id = -1;
		try {
			pizza_id = Integer.parseInt(app.urlParams[0]);
			p = (Pizza) TableManager.getInstance().getTable("pizza").get(pizza_id);
		} catch(Exception e) {
			throw new IllegalArgumentException("Le premier paramètre du contrôleur est invalide", e);
		}
		
		
		Pizza.Taille taille = null;
		try {
			taille = Pizza.Taille.valueOf(app.urlParams[1]);
		} catch(Exception e) {
			throw new IllegalArgumentException("Le deuximème paramètre du contrôleur est invalide", e);
		}
		
		if (p.getTaillePrix().get(taille) == null)
			throw new IllegalArgumentException("La pizza sélectionnée n'a pas cette taille");
		

		app.session.setAttribute("selectedPizza", pizza_id);
		app.session.setAttribute("selectedSize", taille.toString());

		app.request.setAttribute("pizza", p);
		app.request.setAttribute("size", taille);
		
		runVueJSP("template_head.jsp", app);
		runVueJSP("pizzas_details.jsp", app);
		runVueJSP("template_foot.jsp", app);
		
	}
	
	
	
	
	
	
}
