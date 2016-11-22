var common_app = angular.module('common_app', []);
common_app.constant('config', {
   uploadImageUrl: 'http://localhost:8080/SpringSecurity/user/upload_image',
   deleteImageUrl: 'http://localhost:8080/SpringSecurity/user/delete_image?imageUrl='
   
});

