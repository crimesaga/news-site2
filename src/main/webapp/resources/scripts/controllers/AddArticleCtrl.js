admin_app.controller("AddArticleCtrl", function(CommonService, UserService, $scope, $routeParams, $location) {
    $scope.articles = [];
    $scope.categories = [];
    $scope.needToBeSavedArticle;
    $scope.imageUrl;
    $scope.selectedCategory;
    uploadParams = {folderId : 0};
    findArticleById = function(articleId) {
        if (articleId != 0) {
            UserService.findArticleById(function(result) {
                $scope.needToBeSavedArticle = result.data;
                if ($scope.needToBeSavedArticle.imageUrl != null) {
                    $scope.imageUrl = '<p><img class="fr-dib fr-draggable" src="' + $scope.needToBeSavedArticle.imageUrl + '" style="width: 300px;"></p> ';
                }
                $scope.categories.forEach(function(item, index) {
                    if (item.id == $scope.needToBeSavedArticle.categoryId) {
                        $scope.selectedCategory = item;
                    }
                });
            }, function(error) {
                console.log(error);
            }, articleId);
        }
        $scope.$watch('selectedCategory', function(newVal) {
            if (!$scope.isUndefinedOrNull(newVal)) {
                $scope.needToBeSavedArticle.categoryId = newVal.id;
            }
        });
    };

    $scope.isUndefinedOrNull = function(val) {
        return angular.isUndefined(val) || val === null;
    };

    $scope.initImage = function() {
        // $scope.imageUrl = '<p><img class="fr-dib fr-draggable" src="'+
        // $scope.needToBeSavedArticle.imageUrl + '" style="width: 300px;"></p>
        // ';
    };

    findAllCategories = function(active) {
        CommonService.getAllCategories(function(result) {
            $scope.categories = result.data;
            findArticleById($routeParams.articleId);
        }, function(error) {
            console.log(error);
        }, active);
    };

    $scope.saveArticle = function(article) {
        $scope.needToBeSavedArticle.userId = 1;
        if ($routeParams.articleId == 0) {
            $scope.needToBeSavedArticle.posted = new Date().getTime();
        }
        UserService.saveArticle(function(result) {
            $scope.categories = [];
            $scope.selectedCategory = null;
            $scope.needToBeSavedArticle = null;
            $location.path('/list_article');
        }, function(error) {
            console.log(error);
        }, article);
    };

    $scope.cancel = function() {
        $location.path('/list_article');
    };
    findAllCategories(true);

    $scope.titleOptions = {

        imageUploadParam : 'image',

        // Set the image upload URL.
        imageUploadURL : 'http://localhost:8080/SpringSecurity/user/upload_image',

        // Additional upload params.
        imageUploadParams : function() {
            return uploadParams;
        },

        // Set request type.
        imageUploadMethod : 'POST',

        // Set max image size to 5MB.
        imageMaxSize : 5 * 1024 * 1024,

        // Allow to upload PNG and JPG.
        imageAllowedTypes : [ 'jpeg', 'jpg', 'png' ],
        charCounterCount : false,
        toolbarButtons : [ 'fullscreen', 'bold', 'italic', 'underline', 'strikeThrough', 'subscript', 'superscript', 'fontFamily', 'fontSize', '|', 'color',
                'emoticons', 'inlineStyle', 'paragraphStyle', '|', 'paragraphFormat', 'align', 'formatOL', 'formatUL', 'outdent', 'indent', '-', 'insertLink',
                'insertImage', 'insertVideo', 'insertFile', 'insertTable', '|', 'quote', 'insertHR', 'undo', 'redo', 'clearFormatting', 'selectAll', 'html',
                'save' ],
        events : {
            'froalaEditor.initialized' : function() {
            },
            'froalaEditor.image.uploaded' : function(e, editor, response) {
                var obj = JSON.parse(response);
                tmpStr = obj.link.substring(0, obj.link.lastIndexOf('/'));
                uploadParams.folderId = tmpStr.substring(tmpStr.lastIndexOf('/') + 1);
            },
            'froalaEditor.image.beforeUpload' : function(e, editor, images) {

            },
            'froalaEditor.image.removed' : function(e, editor, $img) {
                $.ajax({
                    url : "http://localhost:8080/SpringSecurity/user/delete_image?imageUrl=" + $img[0].src,
                    success : function(result) {
                    }
                });
            },

            'froalaEditor.image.beforePasteUpload' : function(e, editor, img) {
                $.ajax({
                    method : "POST",
                    url : "http://localhost:8080/SpringSecurity/user/upload_image",
                    data : {
                        folderId : 0,
                        image : img[0]
                    },
                    success : function(result) {
                    }
                });
            },
            'froalaEditor.image.inserted': function (e, editor, $img, response) {
                console.log("yallah");
                $.ajax({
                    method : "POST",
                    url : "http://localhost:8080/SpringSecurity/user/upload_image",
                    data : {
                        folderId : 0,
                        image : img[0]
                    },
                    success : function(result) {
                    }
                });
            }
        }
    };

    $scope.cardSetup = {
        imageUpload : true,

        width : 100,

        placeholderText : 'Add a Image',

        toolbarSticky : false,

        contenteditable : false,

        imageUploadParam : 'image',

        // Set the image upload URL.
        imageUploadURL : 'http://localhost:8080/SpringSecurity/user/upload_image',

        // Additional upload params.
        imageUploadParams : uploadParams,

        // Set request type.
        imageUploadMethod : 'POST',

        // Set max image size to 5MB.
        imageMaxSize : 5 * 1024 * 1024,

        // Allow to upload PNG and JPG.
        imageAllowedTypes : [ 'jpeg', 'jpg', 'png' ],
        charCounterCount : false,
        toolbarButtons : [ 'insertImage' ],
        events : {
            'froalaEditor.initialized' : function() {
            },
            'froalaEditor.image.uploaded' : function(e, editor, response) {
                var obj = JSON.parse(response);
                $scope.needToBeSavedArticle.imageUrl = obj.link;
            },
            'froalaEditor.image.beforeUpload' : function(e, editor, images) {
                editor.html.set('');
            },
            'froalaEditor.image.removed' : function(e, editor, $img) {
                $.ajax({
                    url : "http://localhost:8080/SpringSecurity/user/delete_image?imageUrl=" + $img[0].src,
                    success : function(result) {
                        $scope.needToBeSavedArticle.imageUrl = '';
                    }
                });
            }
        }
    };

    $scope.initialize = function(initControls) {
        $scope.initControls = initControls;
        $scope.deleteAll = function() {
            initControls.getEditor()('html.set', '');
            uploadParams.folderId = 0;

        };
    };
});