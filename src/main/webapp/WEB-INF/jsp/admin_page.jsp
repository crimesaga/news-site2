<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<!-- Include Font Awesome. -->
<!--  <link href="${pageContext.servletContext.contextPath }/resources/dist/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css" />-->
<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.4.0/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
<!-- Include Editor style. -->
<link href="${pageContext.servletContext.contextPath }/resources/dist/vendor/froala-wysiwyg-editor/froala_editor.min.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.servletContext.contextPath }/resources/dist/vendor/froala-wysiwyg-editor/froala_style.min.css" rel="stylesheet" type="text/css" />

<!-- Custom CSS -->
<link href="${pageContext.servletContext.contextPath }/resources/css/style2.css" rel="stylesheet">

<!-- JQuery -->
<script type="text/javascript" src="${pageContext.servletContext.contextPath }/resources/dist/vendor/jquery/jquery.js"></script>

<!-- Include JS file. -->
<script type="text/javascript" src="${pageContext.servletContext.contextPath }/resources/dist/vendor/froala-wysiwyg-editor/froala_editor.min.js"></script>

<!-- Include Code Mirror. -->
<!--  <script type="text/javascript" src="${pageContext.servletContext.contextPath }/resources/dist/vendor/codemirror/js/codemirror.min.js"></script>
<script type="text/javascript" src="${pageContext.servletContext.contextPath }/resources/dist/vendor/codemirror/js/xml.min.js"></script>-->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/codemirror/5.3.0/codemirror.min.css">
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/codemirror/5.3.0/codemirror.min.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/codemirror/5.3.0/mode/xml/xml.min.js"></script>

<!-- Include Editor Plugins style. -->
<link rel="stylesheet" href="${pageContext.servletContext.contextPath }/resources/dist/vendor/froala-wysiwyg-editor/char_counter.min.css">
<link rel="stylesheet" href="${pageContext.servletContext.contextPath }/resources/dist/vendor/froala-wysiwyg-editor/code_view.min.css">
<link rel="stylesheet" href="${pageContext.servletContext.contextPath }/resources/dist/vendor/froala-wysiwyg-editor/colors.min.css">
<link rel="stylesheet" href="${pageContext.servletContext.contextPath }/resources/dist/vendor/froala-wysiwyg-editor/emoticons.min.css">
<link rel="stylesheet" href="${pageContext.servletContext.contextPath }/resources/dist/vendor/froala-wysiwyg-editor/file.min.css">
<link rel="stylesheet" href="${pageContext.servletContext.contextPath }/resources/dist/vendor/froala-wysiwyg-editor/fullscreen.min.css">
<link rel="stylesheet" href="${pageContext.servletContext.contextPath }/resources/dist/vendor/froala-wysiwyg-editor/image.min.css">
<link rel="stylesheet" href="${pageContext.servletContext.contextPath }/resources/dist/vendor/froala-wysiwyg-editor/image_manager.min.css">
<link rel="stylesheet" href="${pageContext.servletContext.contextPath }/resources/dist/vendor/froala-wysiwyg-editor/line_breaker.min.css">
<link rel="stylesheet" href="${pageContext.servletContext.contextPath }/resources/dist/vendor/froala-wysiwyg-editor/quick_insert.min.css">
<link rel="stylesheet" href="${pageContext.servletContext.contextPath }/resources/dist/vendor/froala-wysiwyg-editor/table.min.css">
<link rel="stylesheet" href="${pageContext.servletContext.contextPath }/resources/dist/vendor/froala-wysiwyg-editor/video.min.css">

<!-- Include theme -->
<link rel="stylesheet" href="${pageContext.servletContext.contextPath }/resources/dist/vendor/froala-wysiwyg-editor/css/themes/gray.css">

<!-- Include Plugins. -->
<script type="text/javascript" src="${pageContext.servletContext.contextPath }/resources/dist/vendor/froala-wysiwyg-editor/align.min.js"></script>
<script type="text/javascript" src="${pageContext.servletContext.contextPath }/resources/dist/vendor/froala-wysiwyg-editor/char_counter.min.js"></script>
<script type="text/javascript" src="${pageContext.servletContext.contextPath }/resources/dist/vendor/froala-wysiwyg-editor/code_beautifier.min.js"></script>
<script type="text/javascript" src="${pageContext.servletContext.contextPath }/resources/dist/vendor/froala-wysiwyg-editor/code_view.min.js"></script>
<script type="text/javascript" src="${pageContext.servletContext.contextPath }/resources/dist/vendor/froala-wysiwyg-editor/colors.min.js"></script>
<script type="text/javascript" src="${pageContext.servletContext.contextPath }/resources/dist/vendor/froala-wysiwyg-editor/emoticons.min.js"></script>
<script type="text/javascript" src="${pageContext.servletContext.contextPath }/resources/dist/vendor/froala-wysiwyg-editor/entities.min.js"></script>
<script type="text/javascript" src="${pageContext.servletContext.contextPath }/resources/dist/vendor/froala-wysiwyg-editor/file.min.js"></script>
<script type="text/javascript" src="${pageContext.servletContext.contextPath }/resources/dist/vendor/froala-wysiwyg-editor/font_family.min.js"></script>
<script type="text/javascript" src="${pageContext.servletContext.contextPath }/resources/dist/vendor/froala-wysiwyg-editor/font_size.min.js"></script>
<script type="text/javascript" src="${pageContext.servletContext.contextPath }/resources/dist/vendor/froala-wysiwyg-editor/fullscreen.min.js"></script>
<script type="text/javascript" src="${pageContext.servletContext.contextPath }/resources/dist/vendor/froala-wysiwyg-editor/image.min.js"></script>
<script type="text/javascript" src="${pageContext.servletContext.contextPath }/resources/dist/vendor/froala-wysiwyg-editor/image_manager.min.js"></script>
<script type="text/javascript" src="${pageContext.servletContext.contextPath }/resources/dist/vendor/froala-wysiwyg-editor/inline_style.min.js"></script>
<script type="text/javascript" src="${pageContext.servletContext.contextPath }/resources/dist/vendor/froala-wysiwyg-editor/line_breaker.min.js"></script>
<script type="text/javascript" src="${pageContext.servletContext.contextPath }/resources/dist/vendor/froala-wysiwyg-editor/link.min.js"></script>
<script type="text/javascript" src="${pageContext.servletContext.contextPath }/resources/dist/vendor/froala-wysiwyg-editor/lists.min.js"></script>
<script type="text/javascript" src="${pageContext.servletContext.contextPath }/resources/dist/vendor/froala-wysiwyg-editor/paragraph_format.min.js"></script>
<script type="text/javascript" src="${pageContext.servletContext.contextPath }/resources/dist/vendor/froala-wysiwyg-editor/paragraph_style.min.js"></script>
<script type="text/javascript" src="${pageContext.servletContext.contextPath }/resources/dist/vendor/froala-wysiwyg-editor/quick_insert.min.js"></script>
<script type="text/javascript" src="${pageContext.servletContext.contextPath }/resources/dist/vendor/froala-wysiwyg-editor/quote.min.js"></script>
<script type="text/javascript" src="${pageContext.servletContext.contextPath }/resources/dist/vendor/froala-wysiwyg-editor/table.min.js"></script>
<script type="text/javascript" src="${pageContext.servletContext.contextPath }/resources/dist/vendor/froala-wysiwyg-editor/save.min.js"></script>
<script type="text/javascript" src="${pageContext.servletContext.contextPath }/resources/dist/vendor/froala-wysiwyg-editor/url.min.js"></script>
<script type="text/javascript" src="${pageContext.servletContext.contextPath }/resources/dist/vendor/froala-wysiwyg-editor/video.min.js"></script>
<script type="text/javascript" src="${pageContext.servletContext.contextPath }/resources/dist/vendor/froala-wysiwyg-editor/save.min.js"></script>

<!-- Include the image manager plugin. -->
<script src="${pageContext.servletContext.contextPath }/resources/dist/vendor/froala-wysiwyg-editor/image_manager.min.js"></script>

<!-- Include Language file if we want to use it. -->
<script type="text/javascript" src="${pageContext.servletContext.contextPath }/resources/dist/vendor/froala-wysiwyg-editor/js/languages/ro.js"></script>

<!-- Inlcude Bootstrap -->
<link href="${pageContext.servletContext.contextPath }/resources/dist/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="${pageContext.servletContext.contextPath }/resources/dist/vendor/bootstrap/css/bootstrap-theme.min.css" rel="stylesheet">
<script src="${pageContext.servletContext.contextPath }/resources/dist/vendor/bootstrap/js/bootstrap.min.js"></script>

<!-- Include Nav Hover -->
<script src="${pageContext.servletContext.contextPath }/resources/js/nav-hover.js"></script>

<title>Insert title here</title>
</head>
<body ng-app="admin_app">
	<div id="" class="container-fluid">
		<nav class="navbar navbar-default"> <!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
			<ul class="nav nav-pills">
				<li class="dropdown"><a ng-href="#/list_article">Manage Articles</a></li>
				<li role="presentation"><a ng-href="#/list_category">Manage Categories</a></li>
			</ul>
		</div>
		<!-- /.navbar-collapse --> 
		</nav>
		<br>
		<div ng-view></div>
	</div>
	<!-- AngularJS -->
	<script src="${pageContext.servletContext.contextPath }/resources/dist/vendor/angular/angular.js"></script>
	<script src="${pageContext.servletContext.contextPath }/resources/dist/vendor/angular-route/angular-route.js"></script>
	<script src="${pageContext.servletContext.contextPath }/resources/dist/vendor/angular-resource/angular-resource.js"></script>
	<script src="${pageContext.servletContext.contextPath }/resources/dist/vendor/angular-messages/angular-messages.js"></script>
	<script src="${pageContext.servletContext.contextPath }/resources/dist/vendor/angular-bootstrap/ui-bootstrap-tpls.js"></script>
	<!-- Angular froala -->
	<script type="text/javascript" src="${pageContext.servletContext.contextPath }/resources/dist/vendor/angular-froala/js/angular-froala.js"></script>
	<script type="text/javascript" src="${pageContext.servletContext.contextPath }/resources/dist/vendor/angular-froala/js/froala-sanitize.js"></script>
	<!-- My lib -->
	<script src="${pageContext.servletContext.contextPath }/resources/scripts/admin_app.js"></script>
	<script src="${pageContext.servletContext.contextPath }/resources/scripts/common_app.js"></script>
	<script src="${pageContext.servletContext.contextPath }/resources/scripts/controllers/UserCtrl.js"></script>
	<script src="${pageContext.servletContext.contextPath }/resources/scripts/controllers/AddArticleCtrl.js"></script>
	<script src="${pageContext.servletContext.contextPath }/resources/scripts/controllers/ListCategoryCtrl.js"></script>
	<script src="${pageContext.servletContext.contextPath }/resources/scripts/controllers/AddCategoryCtrl.js"></script>
	<script src="${pageContext.servletContext.contextPath }/resources/scripts/controllers/EmptyModalCtrl.js"></script>
	<script src="${pageContext.servletContext.contextPath }/resources/scripts/services/UserService.js"></script>
	<script src="${pageContext.servletContext.contextPath }/resources/scripts/services/CommonService.js"></script>
</body>
</html>