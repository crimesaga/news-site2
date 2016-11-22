var admin_app = angular.module('admin_app', ['ngRoute', 'ngResource', 'ngMessages', 'froala', 'common_app', 'ui.bootstrap']);
admin_app.config(function($routeProvider) {
	$routeProvider.when('/add_article/:articleId', {
		controller: 'AddArticleCtrl',
		templateUrl: 'resources/views/add_article.html'
	}).when('/list_article', {
		controller: 'UserCtrl',
		templateUrl: 'resources/views/list_article.html'
	}).when('/list_category', {
	    controller: 'ListCategoryCtrl',
        templateUrl: 'resources/views/list_category.html'
	});
	$routeProvider.otherwise({
		redirectTo:'/list_article'
	});
})
.value('froalaConfig', {
	toolbarInline: false,
	placeholderText: 'Edit Your Content Here!'
});
