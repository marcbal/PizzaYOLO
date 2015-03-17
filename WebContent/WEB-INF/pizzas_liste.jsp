<%@page import="ca.uqam.inf3005.h2015.bm_cg_gv.pizza_yolo.model.element.Pizza.Taille"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.Map.Entry"%>
<%@page import="ca.uqam.inf3005.h2015.bm_cg_gv.pizza_yolo.model.element.Pizza"%>
<%
Map<Integer, Pizza> pizzas = (Map<Integer, Pizza>) request.getAttribute("pizzas");

for (Entry<Integer, Pizza> pz : pizzas.entrySet()) {
	int index = pz.getKey();
	
	Pizza pizza = pz.getValue(); %>

<div class="pizza">
	<img src="<%= pizza.getPhoto() %>" class="photo_pizza"/>
	<div class="info_pizza">
		<h3><%= pizza.getNom().toUpperCase() %></h3>
		
		<div class="tailles">
			<form method="POST" action="?pizzas/details/<%= index %>/PETIT"><input type="submit"  class="bouton bouton_petit" value="Petite (25�) - <%= pizza.getTaillePrix().get(Taille.PETIT) %> $"/></form>
			<form method="POST" action="?pizzas/details/<%= index %>/MOYEN"><input type="submit"  class="bouton bouton_moyen" value="Normale (30�) - <%= pizza.getTaillePrix().get(Taille.MOYEN) %> $"/></form>
			<form method="POST" action="?pizzas/details/<%= index %>/GRAND"><input type="submit"  class="bouton bouton_grand" value="Grande (35�) - <%= pizza.getTaillePrix().get(Taille.GRAND) %> $"/></form>
			<form method="POST" action="?pizzas/details/<%= index %>/XXL"><input type="submit"  class="bouton bouton_xxl" value="XXL (45�) - <%= pizza.getTaillePrix().get(Taille.XXL) %> $"/></form>
		</div>
		
		<div class="ingredients">
			<%= pizza.getIngredientUserFriendly() %>
		</div>
	</div>
</div>
<% } %>