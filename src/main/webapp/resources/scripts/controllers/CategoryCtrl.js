news_app.controller("CategoryCtrl", function(CommonService, CategoryService, $scope) {
    $scope.categoryWithNews = [];
    $scope.recentNews = [];
    $scope.featuredNews = [];
    $scope.firstLatestNews = [];
    $scope.themeNews = [];
    $scope.menuItems = [];
    categories = [];
    $scope.categoryTree = [];
    numOfCategories = 6;
    numOfNews = 4;
    $scope.fillDataForHomePage = function() {
        // featuredNews = NewsService.getFeaturedNews();
        CategoryService.getAllCategoriesWithRecentArticle(function(result) {
            $scope.categoryWithNews = result.data;
            $scope.featuredNews = findLatestNews(5, 1);
            findLatestNews1($scope.themeNews, $scope.featuredNews, 1);
        }, function(error) {
            console.log(error);
        }, numOfCategories, numOfNews);
    };

    findLatestNews = function(numOfCategories, numOfNews) {
        var count = 0;
        var result = [];
        $scope.categoryWithNews.forEach(function(item, index) {
            if (count >= numOfCategories) {
                return;
            }
            tmpArr = item.articles.slice(0, numOfNews);
            tmpArr.forEach(function(item, index) {
                result.push(item);
            });
            count++;

        });
        return result;
    };

    // findLatestNews = function(numOfCategories) {
    // var count = 0;
    // $scope.featuredNews = [];
    // $scope.categoryWithNews.forEach(function(item, index) {
    // findLatestNews2($scope.featuredNews, item.news, 2);
    // count ++;
    // if (count == numOfCategories) {
    // return;
    // }
    // });
    // };

    // Find theme news
    findLatestNews1 = function(latestNews, newsOfCategory, numOfNews) {
        var newestDate = findNewestDate(newsOfCategory, numOfNews);
        newsOfCategory.forEach(function(item, index) {
            if (newestDate.indexOf(item.posted) != -1) {
                latestNews[latestNews.length] = item;
            }
        });
    };

    // Find a list of newest date
    findNewestDate = function(newsOfCategory, numOfNews) {
        var dateList = [];
        var newestDate = [];
        newsOfCategory.forEach(function(item, index) {
            dateList[index] = item.posted;
        });
        for (i = 0; i < numOfNews; i++) {
            // Why?
            // Remove the max after that
            newestDate[i] = Math.max.apply(null, dateList);
            dateList.splice(dateList.indexOf(newestDate[i]), 1);
        }
        return newestDate;
    };

    // Find latest news by category
    $scope.findLatestNewsByCategory = function(categoryId, numOfNews) {
        var latestNews = [];
        $scope.categoryWithNews.forEach(function(item) {
            if (item.id === categoryId) {
                latestNews = item.articles.slice(0, numOfNews);
                // findLatestNews1(latestNews, item.articles, numOfNews);
            }
        });
        return latestNews;
    };

    $scope.findNewsByCategory = function(categoryId, numOfNews) {
        $scope.categoryWithNews.forEach(function(item) {
            if (item.id === categoryId) {
                return item.news;
            }
        });
        return null;
    };
    getCategoryTree = function(categories) {
        tmpArr = categories;
        var results = [];
        count = 0;
        categories.forEach(function(item, index) {
            if (item.parentId == 0) {
                parent = clone(item);
                results.push(parent);
                count++;
                // toBeRemovedIndex = [];
                // children = findChildCategories(item.id, categories,
                // toBeRemovedIndex);
                // cloneChildren = cloneArr(children);
                // parent.children = cloneChildren;
                getCategoryTree1(categories, parent);
                
            }
        });
        return results;
    };
    getCategoryTree1 = function(categories, parent) {
        tmpArr = categories;
        toBeRemovedIndex = [];
        var children = findChildCategories(parent.id, categories, toBeRemovedIndex);
        if (children.length != 0) {
            var clones = cloneArr(children);
            parent.children = clones;
            for (i = 0; i < parent.children.length; i++) {
                getCategoryTree1(categories, parent.children[i]);
            }
        } else {
            return;
        }
    };

    clone = function(cloneObj) {
//        var obj = new Object();
//        obj.id = cloneObj.id,
//        obj.name = cloneObj.name,
//        obj.parentId = cloneObj.parentId,
//        obj.children = [];
        var obj = {
        id : cloneObj.id,
        name : cloneObj.name,
        display : cloneObj.name,
        href: '#/show_article_per_cat/' + cloneObj.id,
        parentId : cloneObj.parentId,
        children : []
        };
        return obj;
    };
    cloneArr = function(cloneObjs) {
        var results = [];
        cloneObjs.forEach(function(item, index) {
            obj = clone(item);
            results.push(obj);
        });
        return results;
    };
    findChildCategories = function(parentId, categories, toBeRemovedIndex) {
        children = [];
        categories.forEach(function(item, index) {
            if (item.parentId == parentId) {
                children.push(item);
                toBeRemovedIndex.push(index);
            }
        });
        return children;
    };
    findAllCategories = function(active) {
        CommonService.getAllCategories(function(result) {
            categories = result.data;
            $scope.categoryTree = getCategoryTree(categories);
        }, function(error) {
            console.log(error);
        }, active);
    };
    $scope.fillDataForHomePage();
    findAllCategories(true);
});
news_app.directive('dropdownMenu', function () {
    return {
      link: function (scope, elem) {
        elem.dropdownHover();
        // if you want it to work on click, too:
        //elem.dropdown();
      }
    };  
  });