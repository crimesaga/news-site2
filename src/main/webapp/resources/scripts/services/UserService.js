admin_app.factory("UserService", function($http) {
	return {
		findArticlesByUser : function(successCallback, failureCallback, userId) {
			$http({
				method : 'GET',
				isArray : true,
				url : "http://localhost:8080/SpringSecurity/user/findArticlesByUser?userId=" + userId
			}).then(successCallback, failureCallback);
		},
		
		findArticleById : function(successCallback, failureCallback, articleId) {
			$http({
				method : 'GET',
				url : "http://localhost:8080/SpringSecurity/user/findArticleById?articleId=" + articleId
			}).then(successCallback, failureCallback);
		},
		
		findAllCategoriesWithPermission : function(successCallback, failureCallback) {
		    $http({
                method : 'GET',
                url : "http://localhost:8080/SpringSecurity/user/findAllCategoriesWithPermission"
            }).then(successCallback, failureCallback);
		},
		
		saveCategory : function(successCallback, failureCallback, category) {
		    $http({
                method : 'POST',
                url : "http://localhost:8080/SpringSecurity/user/saveCategory",
                data : category
            }).then(successCallback, failureCallback);
		},
		
		deleteCategory : function(successCallback, failureCallback, categoryId) {
            $http({
                method : 'GET',
                url : "http://localhost:8080/SpringSecurity/user/deleteCategory?categoryId=" + categoryId
            }).then(successCallback, failureCallback);
        },
		
		saveArticle : function(successCallback, failureCallback, news) {
            $http({
                method : 'POST',
                url : "http://localhost:8080/SpringSecurity/user/saveArticle",
                data : news
            }).then(successCallback, failureCallback);
        }
        
	};
});