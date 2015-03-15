<%@page import="java.util.List"%>
<%@page import="ca.uqam.inf3005.h2015.bm_cg_gv.pizza_yolo.model.element.Pizza"%>
<%@page import="ca.uqam.inf3005.h2015.bm_cg_gv.pizza_yolo.model.element.Pizza.Taille"%>
<%
Taille taille = (Taille) request.getAttribute("size");
Pizza pizza = (Pizza) request.getAttribute("pizza");



List<String> ingredients = pizza.getIngredients();


%>

<div class="pizza">
	<img src="${pizza.photo}" class="photo_pizza"/>
	<div class="info_pizza">
		<h3>${pizza.nom}</h3>
		
		<div class="tailles">
			<%
				if (taille == Taille.PETIT) {
					%>
						<input type="submit"  class="btn" value="Petite (25ø) - <%= pizza.getTaillePrix().get(taille) %> $"/>
					<%
				} else if (taille == Taille.MOYEN) {
					%>
						<input type="submit"  class="btn2" value="Normale (30ø) - <%= pizza.getTaillePrix().get(taille) %> $"/>
					<%
				} else if (taille == Taille.GRAND) {
					%>
						<input type="submit"  class="btn3" value="Grande (35ø) - <%= pizza.getTaillePrix().get(taille) %> $"/>
					<%
				} else if (taille == Taille.XXL) {
					%>
						<input type="submit"  class="btn4" value="XXL (45ø) - <%= pizza.getTaillePrix().get(taille) %> $"/>
					<%
				}
			%>
		</div>
		
		<form class="ingredients" method="POST" action="?commande/renseignements">
			<p>
				<%
					int i=0;
					for (String ing : ingredients) {
						%>
						<input type="checkbox" name="<%= i %>" id="ing<%= i %>" checked/> <label for="ing<%= i %>"><%= ing %></label><br/>
						<%
						i++;
					}
				%>
				<input type="submit" value="Valider"/>
			</p>
		</form>
	</div>
</div>