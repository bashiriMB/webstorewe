var userApp = angular.module('userApp', []);

userApp.controller('userCtrl', function ($scope, $http) {
    $scope.refreshUser = function(id) {
        $http.get('/webstore/rest/user/'+$scope.id)
            .success(function(data) {
                $scope.user = data;
            });
    };
    $scope.initUserId = function(userId) {
        $scope.userId=userId;
        $scope.refreshUser($scope.userId);
    };
    $scope.addToUser = function(userId) {
        $http.post('/webstore/rest/user/add/'+userId)
            .success(function(data) {
                $scope.refreshUser($http.get('/webstore/rest/user/get/userId'));
            });
    };
    $scope.removeFromUser = function(userId) {
        $http.delete('/webstore/rest/user/remove/'+userId)
            .success(function(data) {
                $scope.refreshUser($http.get('/webstore/rest/user/get/userId'));
            });
    };
    $scope.updateFromUser = function(userId) {
        $http.put('/webstore/rest/user/update/'+userId)
            .success(function(data) {
                $scope.refreshUser($http.get('/webstore/rest/user/get/userId'));
            });
    };
});
