<div class ="container">
	
	<!-- Breadcrumb -->
	<div class = "row">
		
		<div class ="col-xs-12">
			
			<ol class="breadcrumb">
				
				<li class="breadcrumb-item"><a href="${contextRoot}/accueil">Accueil</a></li>
				<li class="breadcrumb-item"><a href="${contextRoot}//voir/tous/produits">Produits</a></li>	
				<li class="breadcrumb-item active">${product.name}</li>	
				
			</ol>
		
		</div>
	
	</div>
	
	<div class="row">
		
		<!-- affiher l'image du peoduit -->
		<div class="col-xs-12 col-sm-4">
			
			<div class="thumbnail">
				
				<img src="${images}/${product.code}.jpg" class="img img-responsive"/>
				
			</div>
		
		</div>
		
		<!-- description du produit -->
		<div class="col-xs-12 col-sm-8">
			
			<h3>${product.name}</h3>
			<hr/>
			
			<p>${product.description}</p>
			<hr/>
			
			<h4>Prix: <strong>${product.unitPrice} FCFA</strong></h4>
			<hr/>
			
			<!-- Test de rupture de stock -->
			<c:choose>
				
				<c:when test="${product.quantity < 1}">
				
					<h6>Quantité en stock : <span style="color:red">En rupture de stock !</span></h6>
					
				</c:when>
				
				<c:otherwise>
				
					<h6>Quantité en stock : ${product.quantity}</h6>
					
				</c:otherwise>
			
			</c:choose>
			
			<!-- Test de rupture de stock : ajour au panier -->
			<c:choose>
				
				<c:when test="${product.quantity < 1}">
				
					<a href="javascript:void(0)" class="btn btn-success disabled">
					<strike><span class="glyphicon glyphicon-shopping-cart"></span> Ajouter au panier</strike></a>
					
				</c:when>
				
				<c:otherwise>
				
					<a href="${contextRoot}/panier/ajouter/${product.id}/produits" class="btn btn-success">
					<span class="glyphicon glyphicon-shopping-cart"></span> Ajouter au panier</a>
					
				</c:otherwise>
			
			</c:choose>
			
			
			
			
				
			<a href="${contextRoot}/voir/tous/produits" class="btn btn-primary">Revenir</a>
			 
		</div>
		
	</div>

</div> <br/><br/><br/><br/>