admin_app.controller("ListCategoryCtrl", function($uibModal, UserService, $scope, CommonService) {
    $scope.categories = [];
    $scope.nameIdPairs = [];
    $scope.selectedCategory = null;
    findAllCategories = function() {
        UserService.findAllCategoriesWithPermission(function(result) {
            $scope.categories = result.data;
            attachParentNames($scope.categories);
        }, function(error) {

        });
    };

    attachParentNames = function(categories) {
        $scope.categories.forEach(function(item, index) {
            $scope.attachParentName(item);
        });
    };
    
    $scope.attachParentName = function(category) {
        $scope.categories.forEach(function(item, childIndex) {
            if (category.parentId == item.id) {
                category.parentName = item.name;
            }
        });
    };
    $scope.setClickedRow = function(index) {
        $scope.selectedRow = index;
        // $scope.selectedCategory = $scope.categories[index];
        // $scope.openModal("lg");
    };

    $scope.openModal = function(index) {
        $scope.selectedRow = index;
        // $scope.setClickedRow(index);
        if (index >= 0) {
            $scope.selectedCategory = $scope.categories[index];
        } else {
            $scope.selectedCategory = {};
        }

        // var parentElem = parentSelector ?
        // angular.element($document[0].querySelector('.modal ' +
        // parentSelector)) : undefined;
        var modalInstance = $uibModal.open({
            animation : $scope.animationsEnabled,
            ariaLabelledBy : 'modal-title',
            ariaDescribedBy : 'modal-body',
            templateUrl : 'editModalContent.html',
            controller : 'AddCategoryCtrl',
            controllerAs : '$ctrl',
            size : "lg",
            // appendTo: parentElem,
            resolve : {
                items : function() {
                    return $scope.selectedCategory;
                },
                selectedCategory : function() {
                    return $scope.selectedCategory;
                },
                UserService : UserService,
                categories : function() {
                    return $scope.categories;
                }
            }
        });
        modalInstance.result.then(function(selectedItem) {
            var savedData = null;
            UserService.saveCategory(function(result) {
                savedData = result.data;
                if(angular.isUndefined(index)) {
                    $scope.attachParentName(savedData);
                    $scope.categories.push(savedData);
                }
            }, function(error) {
                console.log(error);
            }, selectedItem);
            $scope.selectedCategory = {};
            $scope.selectedRow = undefined;
        }, function() {
            $scope.selectedCategory = {};
            $scope.selectedRow = undefined;
        });
    };

    $scope.deleteCategory = function(index) {
        var modalInstance = $uibModal.open({
            animation : $scope.animationsEnabled,
            ariaLabelledBy : 'modal-title',
            ariaDescribedBy : 'modal-body',
            templateUrl : 'deleteModalContent.html',
            controller : 'EmptyModalCtrl',
            controllerAs : '$ctrl1',
            size : "sm"
        });
        modalInstance.result.then(function(selectedItem) {
            var needToBeDeletedCategory = $scope.categories[index];
            UserService.deleteCategory(function(result) {
                $scope.categories.splice(index, 1);
            }, function(error) {

            }, needToBeDeletedCategory.id);
            $scope.selectedRow = undefined;
        }, function() {
            $scope.selectedRow = undefined;
        });

    };
    findAllCategories();
});
