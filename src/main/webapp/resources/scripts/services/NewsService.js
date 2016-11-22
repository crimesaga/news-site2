news_app.factory("NewsService", function($http) {
	return {
		getRecentNews : function(successCallback, failureCallback) {
			$http({
				method : 'GET',
				isArray : true,
				url : "json/news.json"
			}).then(successCallback, failureCallback);
		},
	
//		saveArticle : function(successCallback, failureCallback, news) {
//			$http({
//				method : 'POST',
//				url : "http://localhost:8080/SpringSecurity/saveArticle",
//				data : news
//			}).then(successCallback, failureCallback);
//		},
		
		findArticlesByUser : function(successCallback, failureCallback, userId) {
			$http({
				method : 'GET',
				url : "http://localhost:8080/SpringSecurity/findArticlesByUser",
				data : {'userId' : userId}
			}).then(successCallback, failureCallback);
		},
		
		findArticleById : function(successCallback, failureCallback, articleId) {
            $http({
                method : 'GET',
                url : "http://localhost:8080/SpringSecurity/findArticleById2?articleId=" + articleId
            }).then(successCallback, failureCallback);
        },
		
        findArticleByCategory : function(successCallback, failureCallback, categoryId) {
            $http({
                method : 'GET',
                url : "http://localhost:8080/SpringSecurity/findArticleByCategory?categoryId=" + categoryId
            }).then(successCallback, failureCallback);
        }
	};
});