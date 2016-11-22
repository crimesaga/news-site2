var myapp = angular.module('myapp', ['ngRoute', 'ngResource', 'ngMessages']);
myapp.config(function($routeProvider){
	
	$routeProvider.when('/user/user-page', {
		controller: 'UserCtrl',
		templateUrl: 'user-page.html'
	});
	
	$routeProvider.otherwise({
		redirectTo:'/'
	});
});
