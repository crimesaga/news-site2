admin_app.controller("AddCategoryCtrl", function($uibModalInstance, selectedCategory, UserService, categories, $scope) {
    var $ctrl = this;
    $ctrl.categories = [];
    $ctrl.selectedCategory = null;
    $ctrl.selectedParent = null;
    findAllCategories = function(active) {
        $ctrl.categories = categories;
        $ctrl.selectedCategory = selectedCategory;
        $ctrl.categories.forEach(function(item, index) {
            if (item.id == $ctrl.selectedCategory.parentId) {
                $ctrl.selectedParent = item;
            }
        });
//        CommonService.getAllCategories(function(result) {
//            $ctrl.categories = result.data;
//            $ctrl.selectedCategory = selectedCategory;
//            $ctrl.categories.forEach(function(item, index) {
//                if (item.id == $ctrl.selectedCategory.parentId) {
//                    $ctrl.selectedParent = item;
//                }
//            });
//        }, function(error) {
//
//        }, active);
        $scope.$watch('$ctrl.selectedParent', function(newVal) {
            if (!$ctrl.isUndefinedOrNull(newVal)) {
                $ctrl.selectedCategory.parentId = newVal.id;
                $ctrl.selectedCategory.parentName = newVal.name;
            }
        });
    };

    $ctrl.isUndefinedOrNull = function(val) {
        return angular.isUndefined(val) || val === null;
    };

    attachParentName = function(category) {
        $ctrl.categories.forEach(function(item, index) {
            if (category.parentId == item.id) {
                item.parentName = item.name;
            }
        });
    };

    // $scope.items = items;
    // $scope.selected = {
    // item: $ctrl.items[0]
    // };

    $ctrl.ok = function() {
        var needToSavedData = {
            id : $ctrl.selectedCategory.id,
            name : $ctrl.selectedCategory.name,
            description : $ctrl.selectedCategory.description,
            position : $ctrl.selectedCategory.position,
            parentId : $ctrl.selectedCategory.parentId,
            enabled : $ctrl.selectedCategory.enabled
        };
        $uibModalInstance.close(needToSavedData);
    };

    $ctrl.cancel = function() {
        $uibModalInstance.dismiss('cancel');
    };

    findAllCategories(true);
});
