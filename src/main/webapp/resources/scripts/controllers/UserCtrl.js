admin_app.controller("UserCtrl", function(UserService, $scope) {
$scope.articles = [];
$scope.needToBeSavedArticle;
findArticlesByUser = function(userId) {
	UserService.findArticlesByUser(function(result){
		$scope.articles = result.data;
	}, function(error) {
		console.log(error);
	}, userId);
};

findArticleById = function(articleId) {
	UserService.findArticleById(function(result){
		$scope.needToBeSavedArticle = result.data;
	}, function(error) {
		
	}, articleId);
};
findArticlesByUser(1);

});