<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<spring:url var="css" value="/resources/css" />
<spring:url var="js" value="/resources/js" />
<spring:url var="images" value="/resources/images" />

<c:set var="contextRoot" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>Kamer-Shop Online - ${title}</title>

<script>
	window.menu = '${title}';
	window.contextRoot = '${contextRoot}';
</script>

<!-- Bootstrap core CSS -->
<link href="${css}/bootstrap.min.css" rel="stylesheet">

<!-- Bootstrap Pulse Theme -->
<link href="${css}/theme-site.css" rel="stylesheet">

<!-- Bootstrap dataTable CSS -->
<link href="${css}/dataTables.bootstrap.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="${css}/shop-homepage.css" rel="stylesheet">

</head>

<body>

	<div class="wrapper">
	
		<!-- Navigation -->
		<%@include file="./includes/navbar.jsp"%>

		<!-- Page Content -->
		<div class="content">
			
			<!-- Loading le home -->
			<c:if test="${userClickHome == true}">
				<%@include file="home.jsp"%>
			</c:if>


			<!-- Chargement si l'utilisateur clique sur A Propos -->
			<c:if test="${userClickAbout == true}">
				<%@include file="about.jsp"%>
			</c:if>

			<!-- Chargement si l'utilisateur clique sur Contact -->
			<c:if test="${userClickContact == true}">
				<%@include file="contact.jsp"%>
			</c:if>
			
			<!-- Chargement si l'utilisateur clique sur voir tous les produits ou sur une categorie de produits -->
			<c:if test="${userClickAllProducts == true or userClickCategoryProducts == true}">
				<%@include file="listProducts.jsp"%>
			</c:if>
			
			<!-- Chargement si l'utilisateur clique sur voir la description d'un produit -->
			<c:if test="${userClickShowProduct == true}">
				<%@include file="singleProduct.jsp"%>
			</c:if>	
			
		</div>


		<!-- Footer -->
		<%@include file="./includes/footer.jsp"%>

		<!-- jQuery  -->
		<script src="${js}/jquery.js"></script>

		<!-- Bootstrap core JavaScript -->
		<script src="${js}/bootstrap.min.js"></script>
		
		<!-- jquery.dataTables -->
		<script src="${js}/jquery.dataTables.js"></script>
		
		<!-- Bootstrap dataTables -->
		<script src="${js}/dataTables.bootstrap.js"></script>

		<!-- My custom js file -->
		<script src="${js}/myapp.js"></script>
		
	</div>


</body>

</html>
