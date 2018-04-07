<div class="container">

	<div class="row">

		<!-- afficher la sidebar -->
		<div class="col-md-3">
			<%@include file="./includes/sidebar.jsp"%>

		</div>

		<!-- afficher les produits -->
		<div class="col-md-9">

			<!-- breadcrumb -->
			<div class="row">

				<div class="col-lg-12">

					<c:if test="${userClickAllProducts == true}">
					
						<script>
							window.categoryId = '';					
						</script>
						
						<ol class="breadcrumb">

							<li class="breadcrumb-item"><a href="${contextRoot}/accueil">Accueil</a></li>
							<li class="breadcrumb-item active">Tous les produits</li>

						</ol>
					</c:if>

					<c:if test="${userClickCategoryProducts == true}">
					
						<script>
							window.categoryId = '${category.id}';					
						</script>
						
						<ol class="breadcrumb">

							<li class="breadcrumb-item"><a href="${contextRoot}/accueil">Accueil</a></li>
							<li class="breadcrumb-item active">Categorie</li>
							<li class="breadcrumb-item active">${category.name}</li>


						</ol>
					</c:if>

				</div>

			</div>


			<div class="row">

				<div class="col-xs-12" class="table-responsive">

					<table id="productListTable" class="table table-striped">

						<thead>

							<tr>
								<th></th>
								<th>Nom</th>
								<th>Marque</th>
								<th>Prix</th>
								<th>Quantité en stock</th>
								<th></th>

							</tr>

						</thead>
						
						<tfoot>

							<tr>
								<th></th>
								<th>Nom</th>
								<th>Marque</th>
								<th>Prix</th>
								<th>Quantité en stock</th>
								<th></th>

							</tr>

						</tfoot>

					</table>

				</div>

			</div>
			
		</div>

	</div>
</div>
