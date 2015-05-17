var editSuggestionModule = angular.module('editSuggestionModule',[]);

editSuggestionModule.controller('editSuggestionCtrl', ['$scope', '$http', '$routeParams', function ($scope, $http, $routeParams) {

    $scope.suggestion = $routeParams.suggestion;
}]);
