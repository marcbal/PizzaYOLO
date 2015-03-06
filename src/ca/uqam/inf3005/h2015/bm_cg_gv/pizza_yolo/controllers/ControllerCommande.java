package ca.uqam.inf3005.h2015.bm_cg_gv.pizza_yolo.controllers;

import java.io.IOException;

import javax.servlet.ServletException;

import ca.uqam.inf3005.h2015.bm_cg_gv.pizza_yolo.beans.TemplateBean;
import ca.uqam.inf3005.h2015.bm_cg_gv.pizza_yolo.core.AbstractController;
import ca.uqam.inf3005.h2015.bm_cg_gv.pizza_yolo.core.RequestApplication;

public class ControllerCommande extends AbstractController {

	

	@Override
	public void runAction(RequestApplication app, String action) throws ServletException, IOException {
		
		if ("renseignements".equals(action))
			renseignements(app);
		else if ("confirmation".equals(action))
			confirmation(app);
		else if ("liste".equals(action))
			liste(app);
		else
			app.response.sendRedirect("./");
		
		 
		
		// defaultAction(app);
	}


	
	
	/*
	 * C'est sur cette page que l'utilisateur fourni ses renseignements personnels
	 * 
	 * Les détails de la commande seront affichés à l'écran
	 */
	public void renseignements(RequestApplication app) throws ServletException, IOException {
		setContentTypeHTML(app);
		setTemplateBean(new TemplateBean("Détails de la commande"), app);
		

		runVueJSP("template_head.jsp", app);
		runVueJSP("test_test.jsp", app);
		runVueJSP("template_foot.jsp", app);
	}
	
	
	/*
	 * Cette page effectue le traitement et l'enregistrement des données du formulaire
	 * précédent. Elle contient la pizza commandée avec les détails, ainsi que
	 * les informations personnelles de l'utilisateur.
	 */
	public void confirmation(RequestApplication app) throws ServletException, IOException {
		setContentTypeHTML(app);
		setTemplateBean(new TemplateBean("Confirmation"), app);
		

		runVueJSP("template_head.jsp", app);
		runVueJSP("test_test.jsp", app);
		runVueJSP("template_foot.jsp", app);
	}
	
	
	/*
	 * Liste les commandes passées par les utilisateurs
	 */
	public void liste(RequestApplication app) throws ServletException, IOException {
		setContentTypeHTML(app);
		setTemplateBean(new TemplateBean("Liste des commandes"), app);
		

		runVueJSP("template_head.jsp", app);
		runVueJSP("test_test.jsp", app);
		runVueJSP("template_foot.jsp", app);
	}

	

}
