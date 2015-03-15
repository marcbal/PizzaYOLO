package ca.uqam.inf3005.h2015.bm_cg_gv.pizza_yolo.core;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Cette classe est basée sur le MVC nommé MINI
 * Ce MVC existe seulement en PHP, mais sa
 * structure est très simple pour notre utilisation.
 * Elle est donc transposée en Java pour notre projet (et réadaptée selon nos besoin, aussi)
 * <p>
 * MVC MINI : http://www.php-mini.com/<br/>
 * Github : https://github.com/panique/mini/
 * </p>
 * Cette classe est instanciée pour chaque requête envoyée
 * 
 *
 */
public class RequestApplication {
	
	public final boolean isPost;
	
	public final String urlController;
	
	public final String urlAction;
	
	public final String[] urlParams;

	public final HttpServletRequest request;
	public final HttpServletResponse response;
	public final HttpServlet servlet;
	
	public final HttpSession session;
	
	
	
	public RequestApplication(boolean post, HttpServletRequest req, HttpServletResponse resp, HttpServlet svlet) {
		
		isPost = post;
		request = req;
		session = request.getSession();
		response = resp;
		servlet = svlet;
		
		// analyse de la requête
		String queryString = req.getQueryString();
		if (queryString == null) {
			urlController = ControllerManager.getInstance().defaultController;
			urlAction = "";
			urlParams = new String[0];
			return;
		}
		
		String[] values = queryString.split("/");
		
		if (values.length >= 1 && ControllerManager.getInstance().getController(values[0]) != null)
			urlController = values[0];
		else
			urlController = ControllerManager.getInstance().defaultController;
		
		if (values.length >= 2) {
			urlAction = values[1];
			urlParams = new String[values.length-2];
			
			for (int i=2;i<values.length; i++) {
				urlParams[i-2] = values[i];
			}
			
		}
		else {
			urlAction = ""; // appellera automatiquement l'action par défaut définie dans le contrôleur
			urlParams = new String[0];
			
		}
		
		
		
	}



	public void executeController() throws ServletException, IOException {
		
		

		request.setCharacterEncoding("UTF-8");
		
		ControllerManager.getInstance().getController(urlController).runAction(this, urlAction);
		
		
	}
	
	
	
	
	
	
}
