<h1 class="my-4">Catégories</h1>


<div class="list-group">

	<c:forEach items="${categories}" var="category">
		<a href="${contextRoot}/voir/categorie/${category.id}/produits" 
		class="list-group-item" 
		id="a_${category.name}">${category.name}</a>
	</c:forEach>

</div>  