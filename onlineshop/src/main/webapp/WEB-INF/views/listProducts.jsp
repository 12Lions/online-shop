<div class="container">
	
	<div class="row">
		
		<!-- afficher la sidebar -->
		<div class="col-md-3">		
			<%@include file="./includes/sidebar.jsp" %>	
		
		</div>
		
		<!-- afficher les produits -->
		<div class="col-md-9">
			
			<!-- breadcrumb -->
			<div class="row">
				
				<div class="col-lg-12">
					
					<c:if test="${userClickAllProducts == true}">
						<ol class="breadcrumb">
							
							<li class="breadcrumb-item"><a href="${contextRoot}/accueil">Accueil</a></li>
							<li class="breadcrumb-item active">Tous les produits</li>
						
						</ol>
					</c:if>
					
					<c:if test="${userClickCategoryProducts == true}">
						<ol class="breadcrumb">
							
							<li class="breadcrumb-item"><a href="${contextRoot}/accueil">Accueil</a></li>
							<li class="breadcrumb-item active">Categorie</li>
						    <li class="breadcrumb-item active">${category.name}</li>
							
						
						</ol>
					</c:if>
					
				</div>
			
			</div>
			
		
		</div>
	
	</div>

</div>