admin_app.controller("EmptyModalCtrl", function($uibModalInstance) {
    var $ctrl1 = this;
    $ctrl1.ok = function() {
        $uibModalInstance.close(null);
    };
    $ctrl1.cancel = function() {
        $uibModalInstance.dismiss('cancel');
    };

});
