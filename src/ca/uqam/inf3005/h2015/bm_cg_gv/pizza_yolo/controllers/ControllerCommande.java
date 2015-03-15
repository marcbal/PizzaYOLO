package ca.uqam.inf3005.h2015.bm_cg_gv.pizza_yolo.controllers;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;

import ca.uqam.inf3005.h2015.bm_cg_gv.pizza_yolo.beans.TemplateBean;
import ca.uqam.inf3005.h2015.bm_cg_gv.pizza_yolo.core.AbstractController;
import ca.uqam.inf3005.h2015.bm_cg_gv.pizza_yolo.core.RequestApplication;
import ca.uqam.inf3005.h2015.bm_cg_gv.pizza_yolo.model.TableManager;
import ca.uqam.inf3005.h2015.bm_cg_gv.pizza_yolo.model.element.Pizza;
import ca.uqam.inf3005.h2015.bm_cg_gv.pizza_yolo.model.element.Pizza.Taille;

public class ControllerCommande extends AbstractController {

	
	private File dossier = new File("./commandes");
	
	public ControllerCommande() {
		dossier.mkdir();
	}
	
	
	
	

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
	 * Cette page traite en même temps les données du formulaire sur la sélection des ingrédients
	 * 
	 * Les détails de la commande seront affichés à l'écran
	 */
	public void renseignements(RequestApplication app) throws ServletException, IOException {
		setContentTypeHTML(app);
		setTemplateBean(new TemplateBean("Détails de la commande"), app);
		
		
		if (!app.isPost)
			throw new ServletException("Veuillez resélectionner une pizza à la page d'accueil");
		
		Pizza p = (Pizza) TableManager.getInstance().getTable("pizza").get((int) app.session.getAttribute("selectedPizza"));
		
		List<String> ingredients = p.getIngredients();
		
		List<String> selectedIngredients = new ArrayList<String>();
		
		for (int i=0; i<ingredients.size(); i++) {
			if (app.request.getParameter(String.valueOf(i)) == null)
				continue;
			
			String val = app.request.getParameter(String.valueOf(i));
			
			System.out.println(val+" ");
			
			if ("on".equalsIgnoreCase(val)) {
				selectedIngredients.add(ingredients.get(i));
			}
			
		}
		
		
		app.session.setAttribute("selectedIngredients", selectedIngredients);
		
		runVueJSP("template_head.jsp", app);
		runVueJSP("commande_renseignement.jsp", app);
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

		if (!app.isPost)
			throw new ServletException("Retournez à la page précédente pour valider le formulaire");
		
		// traitement du formulaire 
		
		String nom = app.request.getParameter("nom");
		String prenom = app.request.getParameter("prenom");
		String age = app.request.getParameter("age");
		String adresse = app.request.getParameter("adresse");
		String tel = app.request.getParameter("tel");
		
		if (nom == null || prenom == null || age == null || adresse == null || tel == null)
			throw new ServletException("Un des champs du formulaire est vide");

		nom = nom.replace("\n", "").replace("\r", "").trim();
		prenom = prenom.replace("\n", "").replace("\r", "").trim();
		age = age.replace("\n", "").replace("\r", "").trim();
		adresse = adresse.trim();
		tel = tel.replace("\n", "").replace("\r", "").trim();
		
		if (nom.isEmpty() || prenom.isEmpty() || age.isEmpty() || tel.isEmpty() || adresse.isEmpty())
			throw new ServletException("Un des champs du formulaire est vide");
		
		// nom, prenom et adresse OK
		int ageInt = 0;
		
		try {
			ageInt = Integer.parseInt(age);
		} catch(NumberFormatException e) {
			throw new ServletException("L'age indiqué n'est pas valide. Ça doit être un nombre");
		}
		
		if (!tel.matches("^((\\+\\d{1,3}(-| )?\\(?\\d\\)?(-| )?\\d{1,5})|(\\(?\\d{2,6}\\)?))(-| )?(\\d{3,4})(-| )?(\\d{4})(( x| ext)\\d{1,5}){0,1}$"))
			throw new ServletException("Le numéro de téléphone indiqué n'est pas valide.");
		
		
		
		/*
		 * Données à sauvegarder :
		 * - ID pizza
		 * - Taille
		 * - Ingrédients sélectionnés (liste String)
		 * 
		 * - Nom, Prénom client
		 * - Adresse client
		 * - Tel client
		 * - Age client
		 * 
		 */
		
		// on récupère les données de session pour les stoquer dans le fichier de commande

		Object idPizza = app.session.getAttribute("selectedPizza");
		Object taillePizza = app.session.getAttribute("selectedSize");
		if (idPizza == null || taillePizza == null) {
			throw new ServletException("Vous n'avez pas choisi votre pizza à l'accueil");
		}

		Object selectedIngredients = app.session.getAttribute("selectedIngredients");
		if (selectedIngredients == null) {
			throw new ServletException("Une erreur est survenu lors de la validation de la commande. Veuillez retourner à la page d'accueil");
		}
		
		
		int idPizzaInt = (int) idPizza;
		String taillePizzaStr = (String) taillePizza;
		List<String> selectedIngredientsList = (List<String>) selectedIngredients;
		
		
		
		
		File commandFile = new File(dossier, ""+System.currentTimeMillis());
		if (commandFile.exists())
			throw new ServletException("Commande impossible à enregistrer");
		
		commandFile.createNewFile();
		
		BufferedWriter bw = new BufferedWriter(new FileWriter(commandFile));

		bw.append(idPizzaInt+";"+taillePizzaStr+"\n");
		
		StringBuilder sb = new StringBuilder();
		
		for (String ing : selectedIngredientsList) {
			sb.append(ing+";");
		}
		
		bw.append(sb.toString().substring(0, sb.length()-1)+"\n");
		bw.append(nom+"\n"+prenom+"\n"+age+"\n"+tel+"\n"+adresse);
		bw.flush();
		
		bw.close();
		
		
		System.out.println(commandFile.getAbsolutePath());
		
		
		
		
		// envoi des données aux JSP
		
		runVueJSP("template_head.jsp", app);
		runVueJSP("commande_confirmation.jsp", app);
		runVueJSP("template_foot.jsp", app);
	}
	
	
	/*
	 * Liste les commandes passées par les utilisateurs
	 */
	public void liste(RequestApplication app) throws ServletException, IOException {
		setContentTypeHTML(app);
		setTemplateBean(new TemplateBean("Liste des commandes"), app);
		

		runVueJSP("template_head.jsp", app);
		runVueJSP("commande_liste.jsp", app);
		runVueJSP("template_foot.jsp", app);
	}

	

}
