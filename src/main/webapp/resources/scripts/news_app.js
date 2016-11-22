var news_app = angular.module('news_app', ['ngRoute', 'ngResource', 'ngMessages', 'ngSanitize', 'common_app', 'bootstrapSubmenu']);
news_app.config(function($routeProvider) {
    $routeProvider.when('/news_detail/:articleId', {
        controller: 'NewsDetailCtrl',
        templateUrl: 'resources/views/news_detail.html'
    }).when('/show_news', {
        controller: 'CategoryCtrl',
        templateUrl: 'resources/views/show_news.html'
    }).when('/show_article_per_cat/:categoryId', {
        controller: 'ListArticlesPerCatCtrl',
        templateUrl: 'resources/views/show_article_per_category.html'
    });
    $routeProvider.otherwise({
        redirectTo:'/show_news'
    });
});