<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html ng-app="myapp">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script src="<c:url value='/resources/scripts/js/angular.js'/>"></script>
<script src="<c:url value='/resources/scripts/js/angular-route.js'/>"></script>
<script src="<c:url value='/resources/scripts/js/angular-resource.js'/>"></script>
<script src="<c:url value='/resources/scripts/js/angular-messages.js'/>"></script>
<script src="<c:url value='/resources/scripts/myapp.js'/>"></script>
<script src="<c:url value='/resources/scripts/controllers/UserCtrl.js'/>"></script>
<script src="<c:url value='/resources/scripts/services/UserService.js'/>"></script>
<script src="<c:url value='/resources/scripts/controllers/NewsCtrl.js'/>"></script>
<script src="<c:url value='/resources/scripts/services/NewsService.js'/>"></script>
</head>
<body ng-controller="UserCtrl">
<form action="">
<table>
<tr>
<th>Id</th>
<th>Title</th>
<th></th>
</tr>
 <tr ng-repeat="article in articles">
 <td>{{article.id}}</td>
 <td>{{article.title}}</td>
 </tr>
 </table>
 </form>
 

 
</body>
</html>