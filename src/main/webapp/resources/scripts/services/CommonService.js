common_app.factory("CommonService", function($http) {
    return {
        findArticleById : function(successCallback, failureCallback, articleId) {
            $http({
                method : 'GET',
                url : "http://localhost:8080/SpringSecurity/findArticleById2?articleId=" + articleId
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