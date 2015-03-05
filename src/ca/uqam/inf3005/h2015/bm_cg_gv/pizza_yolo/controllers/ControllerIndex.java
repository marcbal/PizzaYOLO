package ca.uqam.inf3005.h2015.bm_cg_gv.pizza_yolo.controllers;

import java.io.IOException;

import javax.servlet.ServletException;

import ca.uqam.inf3005.h2015.bm_cg_gv.pizza_yolo.beans.TemplateBean;
import ca.uqam.inf3005.h2015.bm_cg_gv.pizza_yolo.core.AbstractController;
import ca.uqam.inf3005.h2015.bm_cg_gv.pizza_yolo.core.RequestApplication;

public class ControllerIndex extends AbstractController {



	@Override
	public void runAction(RequestApplication app, String action) throws ServletException, IOException {
		/*
		if ("action".equals(action))
			action(app);
		else if ("action2".equals(action))
			action2(app);
		else
			defaultAction(app);
		
		 */
		
		defaultAction(app);
	}
	

	public void defaultAction(RequestApplication app) throws ServletException, IOException {
		setContentTypeHTML(app);
		setTemplateBean(new TemplateBean("Bienvenue"), app);
		

		runVueJSP("template_head.jsp", app);
		runVueJSP("index_index.jsp", app);
		runVueJSP("template_foot.jsp", app);
	}

}
