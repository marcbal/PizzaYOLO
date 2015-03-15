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
			<form method="POST" action="?pizzas/details/<%= index %>/PETIT"><input type="submit"  class="btn" value="Petite (25ø) - <%= pizza.getTaillePrix().get(Taille.PETIT) %> $"/></form>
			<form method="POST" action="?pizzas/details/<%= index %>/MOYEN"><input type="submit"  class="btn2" value="Normale (30ø) - <%= pizza.getTaillePrix().get(Taille.MOYEN) %> $"/></form>
			<form method="POST" action="?pizzas/details/<%= index %>/GRAND"><input type="submit"  class="btn3" value="Grande (35ø) - <%= pizza.getTaillePrix().get(Taille.GRAND) %> $"/></form>
			<form method="POST" action="?pizzas/details/<%= index %>/XXL"><input type="submit"  class="btn4" value="XXL (45ø) - <%= pizza.getTaillePrix().get(Taille.XXL) %> $"/></form>
		</div>
		
		<div class="ingredients">
			<%= pizza.getIngredientUserFriendly() %>
		</div>
	</div>
</div>
<% } %>