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
			<a href="?pizzas/details/<%= index %>/PETIT" class="btn">Petite (25ø) - <%= pizza.getTaillePrix().get(Taille.PETIT) %> $</a><br/>
			<a href="?pizzas/details/<%= index %>/MOYEN" class="btn2">Normale (30ø) - <%= pizza.getTaillePrix().get(Taille.MOYEN) %> $</a><br/>
			<a href="?pizzas/details/<%= index %>/GRAND" class="btn3">Grande (35ø) - <%= pizza.getTaillePrix().get(Taille.GRAND) %> $</a><br/>
			<a href="?pizzas/details/<%= index %>/XXL" class="btn4">XXL (45ø) - <%= pizza.getTaillePrix().get(Taille.XXL) %> $</a><br/>
		</div>
		
		<div class="ingredients">
			<%= pizza.getIngredientUserFriendly() %>
		</div>
	</div>
</div>
<% } %>