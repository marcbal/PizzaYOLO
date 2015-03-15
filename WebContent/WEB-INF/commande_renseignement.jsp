<div class="formulaire">
	<form method="POST" action="?commande/confirmation">
		
		<div class="form-group">
		<label for="nom">Nom : </label>
		<input id="nom" name="nom" type="text" required /><br/>
		</div>
		
		<div class="form-group">
		<label for="prenom">Prénom : </label>
		<input id="prenom" name="prenom" type="text" required /><br/>
		</div>
		
		<div class="form-group">
		<label for="age">Age : </label>
		<input id="age" type="number" name="age" required /><br/>
		</div>
		
		<div class="form-group">
		<label for="adresse">Adresse : </label>
		<textarea id="adresse" name="adresse" required></textarea><br/>
		</div>
		
		<div class="form-group">
		<label for="num">Téléphone : </label>
		<input id="num" type="tel" name="tel" required pattern="^((\+\d{1,3}(-| )?\(?\d\)?(-| )?\d{1,5})|(\(?\d{2,6}\)?))(-| )?(\d{3,4})(-| )?(\d{4})(( x| ext)\d{1,5}){0,1}$"/><br/>
		</div>
		
		<input type="submit" value="Commander" />
	
	</form>

</div>
