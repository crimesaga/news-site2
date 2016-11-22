news_app.controller("NewsCtrl", function(NewsService, $scope) {
	$scope.featuredNews;
	$scope.recentNews = [];
	fillDataForHomePage = function() {
		//featuredNews = NewsService.getFeaturedNews();
		NewsService.getRecentNews(function(result) {
			$scope.recentNews = result.data;
		}, function(error) {
			console.log(error);
		});
	};
	
	fillDataForHomePage();
});
news_app.controller("NewsCtrl", function(NewsService, CategoryService, $scope) {
	//featured news of all categories(should separate the best one?
	$scope.featuredNews;
	$scope.recentNews = [];
	$scope.needToBeSavedArticle;
	$scope.categories = [];
	$scope.articlesByUser;
	fillDataForHomePage = function() {
		//featuredNews = NewsService.getFeaturedNews();
		NewsService.getRecentNews(function(result) {
			$scope.recentNews = result.data;
		}, function(error) {
			console.log(error);
		});
		
		CategoryService.getAllCategories(function(result) {
			$scope.categories = result;
		}, function(error) {
			console.log(error);
		}, true);
	};
	
	$scope.saveNews = function(news) {
		$scope.needToBeSavedArticle.posted = new Date();
		$scope.needToBeSavedArticle.userId = 1;
		NewsService.saveNews(news);
	};
	
	//active=1:only find active news,0: find all, 2:find only inactive news
	findRecentNewsByCategories = function(categoryIds, active, numOfNews) {
		
	};
	//active=1:only find active news,0: find all, 2:find only inactive news
	//numOfNews=0:get all
	//numOfCategories=0:get all
	getAllCategoriesWithNews = function(active, numOfNews, numOfCategories) {
		
	};
	
	findCategoriesById = function(active, numOfNews, categoryIds) {
		
	};
	
	findFeaturedNewsByCategories = function(categoryIds, numOfCategories) {
		
	};
	
	findFeaturedNewsByCategories = function(categoryIds, numOfCategory) {
		
	};
	
	//numOfNews=0:get all
	getHotNews = function(numOfNews) {
		
	};
	
	getAds = function() {
		
	};
	
	findArticlesByUser = function(userId) {
		NewsService.findArticlesByUser(function(data){
			$scope.articlesByUser = data;
		}, function(error) {
			
		}, userId);
	};
});