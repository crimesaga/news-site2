news_app.factory("CategoryService", function($http) {
    return {
        getAllCategoryWithRecentNewsWithPaging : function(successCallback, failureCallback, active, numOfNews, pageNumber, limit) {
            $http({
                method : 'GET',
                isArray : true,
                url : "json/category.json"
            }).then(successCallback, failureCallback);
        },

        getAllCategoriesWithRecentArticle : function(successCallback, failureCallback, numOfCategories, numOfNews) {
            $http({
                method : 'GET',
                isArray : true,
                url : "http://localhost:8080/SpringSecurity/articlesPerCategory?numOfCategories=" + numOfCategories + "&numOfArticles=" + numOfNews
            }).then(successCallback, failureCallback);
        },

        getAllCategories : function(successCallback, failureCallback, active) {
            $http({
                method : 'GET',
                isArray : true,
                params : {
                    'active' : true
                },
                url : "http://localhost:8080/SpringSecurity/getAllCategories?active=" + active
            }).then(successCallback, failureCallback);
        }
    };
});