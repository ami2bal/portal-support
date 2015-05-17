var editCategoryModule = angular.module('editCategoryModule',[]);

editCategoryModule.controller('editCategoryCtrl', ['$scope', '$http', '$routeParams', function ($scope, $http, $routeParams) {

    $scope.category = $routeParams.category;
}]);
