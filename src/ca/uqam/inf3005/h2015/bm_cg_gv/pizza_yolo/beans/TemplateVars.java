package ca.uqam.inf3005.h2015.bm_cg_gv.pizza_yolo.beans;

/**
 * Représente les données qui doivent être envoyés aux templates JSP pour affichage,
 * qui sont communes à toutes les pages.
 *
 */
public class TemplateVars {
	
	private String headTitle;
	
	private String pageTitle;
	
	
	public TemplateVars() {
		this("Default title");
	}
	
	public TemplateVars(String headT, String pageT) {
		setHeadTitle(headT);
		setPageTitle(pageT);
	}
	
	public TemplateVars(String t) {
		setTitles(t);
	}
	
	

	public String getHeadTitle() {
		return headTitle;
	}

	public void setHeadTitle(String headTitle) {
		this.headTitle = headTitle;
	}

	public String getPageTitle() {
		return pageTitle;
	}

	public void setPageTitle(String pageTitle) {
		this.pageTitle = pageTitle;
	}
	
	
	
	public void setTitles(String title) {
		setHeadTitle(title);
		setPageTitle(title);
	}
	
	
	
}
