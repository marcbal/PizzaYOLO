package ca.uqam.inf3005.h2015.bm_cg_gv.pizza_yolo.core;

import java.io.IOException;

import javax.servlet.ServletException;

import ca.uqam.inf3005.h2015.bm_cg_gv.pizza_yolo.beans.TemplateVars;

public abstract class AbstractController {
	
	
	
	public abstract void runAction(RequestApplication app, String action) throws ServletException, IOException;
	
	
	
	
	/**
	 * 
	 * @param vueName le nom du fichier JSP dans le dossier WEB-INF
	 * @param app l'instance de la classe Application en cours d'exécution
	 * @throws IOException 
	 * @throws ServletException 
	 */
	public void runVueJSP(String vueName, RequestApplication app) throws ServletException, IOException {
		app.servlet.getServletContext().getRequestDispatcher("/WEB-INF/"+vueName).include( app.request, app.response);
	}
	
	
	public void setContentTypeHTML(RequestApplication app) {
		app.response.setContentType("text/html;charset=UTF-8");
	}
	
	public void setTemplateVars(TemplateVars tplVars, RequestApplication app) {
		app.request.setAttribute("template", tplVars);
	}
	
}
