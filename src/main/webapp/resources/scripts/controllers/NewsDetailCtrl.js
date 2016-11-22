news_app.controller("NewsDetailCtrl", function(CommonService, CategoryService, $scope, $routeParams) {
    $scope.selectedNews = [];
    findNewsById = function(articleId) {
        CommonService.findArticleById(function(result) {
            $scope.selectedNews = result.data;
        }, function (error) {
            
        }, articleId);
    };
    $scope.selectedNews = findNewsById($routeParams.articleId);
});