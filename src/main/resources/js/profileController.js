var profileApp = angular.module('profileApp', []);

profileApp.controller('profileCtrl', function ($scope, $http) {
    $scope.refreshProfile = function(id) {
        $http.get('/webstore/rest/profile/'+$scope.id)
            .success(function(data) {
                $scope.profile = data;
            });
    };
    $scope.initProfileId = function(profileId) {
        $scope.profileId=profileId;
        $scope.refreshProfile($scope.profileId);
    };
    $scope.addToProfile = function(profileId) {
        $http.post('/webstore/rest/profile/add/'+profileId)
            .success(function(data) {
                $scope.refreshProfile($http.get('/webstore/rest/profile/get/profileId'));
            });
    };
    $scope.removeFromProfile = function(profileId) {
        $http.delete('/webstore/rest/profile/remove/'+profileId)
            .success(function(data) {
                $scope.refreshProfile($http.get('/webstore/rest/profile/get/profileId'));
            });
    };
    $scope.updateFromProfile = function(profileId) {
        $http.put('/webstore/rest/profile/update/'+profileId)
            .success(function(data) {
                $scope.refreshProfile($http.get('/webstore/rest/profile/get/profileId'));
            });
    };
});
