package ca.uqam.inf3005.h2015.bm_cg_gv.pizza_yolo.controllers;

import java.io.IOException;

import javax.servlet.ServletException;

import ca.uqam.inf3005.h2015.bm_cg_gv.pizza_yolo.beans.TemplateBean;
import ca.uqam.inf3005.h2015.bm_cg_gv.pizza_yolo.core.AbstractController;
import ca.uqam.inf3005.h2015.bm_cg_gv.pizza_yolo.core.RequestApplication;
import ca.uqam.inf3005.h2015.bm_cg_gv.pizza_yolo.model.TableManager;

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
		

		runVueJSP("template_head.jsp", app);
		runVueJSP("test_test.jsp", app);
		runVueJSP("template_foot.jsp", app);
	}
	
	
	
	
	
	
}
