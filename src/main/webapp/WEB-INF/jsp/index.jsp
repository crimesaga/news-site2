<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html ng-app="news_app">
<head>
<meta http-equiv="Content-Type" content="text/html;charset=utf-8">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<title>Bootstrap 101 Template</title>

<!-- Bootstrap -->
<link href="${pageContext.servletContext.contextPath }/resources/dist/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

<link href="${pageContext.servletContext.contextPath }/resources/css/style2.css" rel="stylesheet">
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script type="text/javascript" src="${pageContext.servletContext.contextPath }/resources/dist/vendor/jquery/jquery.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<link href="${pageContext.servletContext.contextPath }/resources/dist/vendor/bootstrap/css/bootstrap-theme.min.css" rel="stylesheet">
<script src="${pageContext.servletContext.contextPath }/resources/dist/vendor/bootstrap/js/bootstrap.min.js"></script>
<script src="${pageContext.servletContext.contextPath }/resources/dist/vendor/angular/angular.js"></script>
<script src="${pageContext.servletContext.contextPath }/resources/dist/vendor/angular-route/angular-route.js"></script>
<script src="${pageContext.servletContext.contextPath }/resources/dist/vendor/angular-resource/angular-resource.js"></script>
<script src="${pageContext.servletContext.contextPath }/resources/dist/vendor/angular-messages/angular-messages.js"></script>
<script src="${pageContext.servletContext.contextPath }/resources/dist/vendor/angular-sanitize/angular-sanitize.js"></script>
<!-- <script src="${pageContext.servletContext.contextPath }/resources/dist/vendor/bootstrap-submenu/js/bootstrap-submenu.min.js"></script> -->
<script src="${pageContext.servletContext.contextPath }/resources/dist/vendor/ng-bootstrap-submenu/js/ng-bootstrap-submenu.min.js"></script>
<!--  <link href="${pageContext.servletContext.contextPath }/resources/dist/vendor/ng-bootstrap-submenu/css/ng-bootstrap-submenu.min.css" rel="stylesheet">-->
<script src="${pageContext.servletContext.contextPath }/resources/scripts/news_app.js"></script>
<script src="${pageContext.servletContext.contextPath }/resources/scripts/common_app.js"></script>
<script src="${pageContext.servletContext.contextPath }/resources/scripts/controllers/NewsCtrl.js"></script>
<script src="${pageContext.servletContext.contextPath }/resources/scripts/controllers/CategoryCtrl.js"></script>
<script src="${pageContext.servletContext.contextPath }/resources/scripts/controllers/NewsDetailCtrl.js"></script>
<script src="${pageContext.servletContext.contextPath }/resources/scripts/controllers/ListArticlesPerCatCtrl.js"></script>
<script src="${pageContext.servletContext.contextPath }/resources/scripts/services/NewsService.js"></script>
<script src="${pageContext.servletContext.contextPath }/resources/scripts/services/CategoryService.js"></script>
<script src="${pageContext.servletContext.contextPath }/resources/scripts/services/CommonService.js"></script>

<!-- Include Nav Hover -->
<script src="${pageContext.servletContext.contextPath }/resources/js/nav-hover.js"></script>
<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body ng-controller="CategoryCtrl">

	<div id="wrapper">
		<div id="primary-nav"></div>
		<div id="header"></div>
		<div id="secondary-nav"></div>
		<div id="main"></div>
		<div id="" class="container-fluid">
			<nav class="navbar navbar-default"> <!-- Collect the nav links, forms, and other content for toggling -->
			<div class="navbar-header">
				<a class="navbar-brand" href="#">Home</a>
			</div>
			<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
				<form class="navbar-form navbar-right">
					<div class="form-group">
						<input type="text" class="form-control" placeholder="Search">
					</div>
					<div class="form-group">
					<button type="submit" class="btn btn-default">Submit</button>
					</div>
				</form>
			</div>

			<!-- /.navbar-collapse --> </nav>

			<div class="page-header">
				<!-- Header -->
				<div class="row">
					<div class="col-xs-6 col-md-3">
						<a href="#" class="img-thumbnail"> <img src="${pageContext.servletContext.contextPath }/resources/images/ads.jpg" alt="..."> </a>
					</div>
				</div>
				<!-- End Header -->
			</div>
			<nav class="navbar navbar-default"> <!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">

				<ul class="nav navbar-nav" data-hover="dropdown">
					<bootstrap-submenu ng-repeat="item in categoryTree" menu-item="item"> </bootstrap-submenu>
				</ul>
			</div>
			<!-- ><ul class="nav nav-pills">
						<li class="dropdown"><a href="#">Home</a>
							<ul class="dropdown-menu">
								<li role="presentation"><a href="#">Profile</a>
								</li>
								<li role="presentation"><a href="#">Messages</a>
								</li>
							</ul></li>
						<li role="presentation"><a href="#">Profile</a>
						</li>
						<li role="presentation"><a href="#">Messages</a>
						</li>
					</ul> --
				</div>
				<!-- /.navbar-collapse --> </nav>
			<div class="row row-offcanvas row-offcanvas-right">
				<div class="col-xs-12 col-sm-8">
					<!-- ng-view -->
					<div ng-view></div>
					<!--/. ng-view -->
				</div>
				<!--/.col-xs-12.col-sm-9-->

				<div class="col-xs-6 col-sm-4 sidebar-offcanvas" id="sidebar">
					<div class="list-group">
						<a href="#" class="list-group-item active">Link</a> <a href="#" class="list-group-item">Link</a> <a href="#" class="list-group-item">Link</a> <a href="#"
							class="list-group-item">Link</a> <a href="#" class="list-group-item">Link</a> <a href="#" class="list-group-item">Link</a> <a href="#"
							class="list-group-item">Link</a> <a href="#" class="list-group-item">Link</a> <a href="#" class="list-group-item">Link</a> <a href="#"
							class="list-group-item">Link</a>
					</div>
				</div>
				<!--/.sidebar-offcanvas-->
			</div>
			<!--/row-->

			<hr>

			<footer>
			<p>&copy; 2015 Company, Inc.</p>
			</footer>

		</div>
		<!--/.container-->

	</div>
	<!-- wrapper -->
</body>
</html>