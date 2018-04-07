<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<spring:url var="css" value="/resources/css" />

<c:set var="contextRoot" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<!-- Bootstrap Core CSS -->
<link href="${css}/bootstrap.min.css" rel="stylesheet">

<!-- Bootstrap Readable Theme -->
<link href="${css}/theme-site.css" rel="stylesheet">

<!-- Custom CSS -->
<link href="${css}/shop-homepage.css" rel="stylesheet">


<title>Kamer-Shop Online - ${title}</title>

</head>

<body>

	<div class="wrapper">

		<nav
			class="navbar navbar-expand-lg navbar-dark bg-dark navbar fixed-top">
			<div class="container">
				<!-- Brand and toggle get grouped for better mobile display -->
				<a class="navbar-brand" href="${contextRoot}/accueil">Revenir</a>
				<button class="navbar-toggler" type="button" data-toggle="collapse"
					data-target="#navbarResponsive" aria-controls="navbarResponsive"
					aria-expanded="false" aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>
			</div>
		</nav>


		<div class="content">

			<div class="container">

				<div class="row">

					<div class="col-xs-12">


						<div class="jumbotron">

							<h1>${errorTitle}</h1>
							<hr />

							<blockquote style="word-wrap: break-word">

								${errorDescription}
							</blockquote>

						</div>


					</div>

				</div>

			</div>

		</div>


		<%@include file="./includes/footer.jsp"%>

	</div>


</body>


</html>