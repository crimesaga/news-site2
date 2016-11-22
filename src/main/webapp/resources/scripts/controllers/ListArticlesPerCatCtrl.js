news_app.controller("ListArticlesPerCatCtrl", function(CommonService, NewsService, $scope, $routeParams) {
    $scope.articles = [];
    $scope.themeNews;
    pageSize = 10;
    pageNum = 0;
    $scope.pagination = {};
    $scope.fillDataForCategoryPage = function(categoryId) {
        NewsService.findArticleByCategory(function(result) {
            $scope.articles = result.data;
            if ($scope.articles[0]) {
                $scope.themeNews = $scope.articles[0];
            }
        }, function(error) {
            console.log(error);
        }, categoryId);
    };

    $scope.fillDataForCategoryPage($routeParams.categoryId)

});