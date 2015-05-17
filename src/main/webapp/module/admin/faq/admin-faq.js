var adminFaqModule = angular.module('adminFaqModule', ['editCategoryModule','editSuggestionModule']);

adminFaqModule.controller('adminFaqCtrl', ['$scope', '$http', function ($scope, $http) {

    $scope.categories = [];

    $http.get('category/getCategories').success(function (data) {
        $scope.categories = data;
    });
}]);

adminFaqModule.controller('adminSuggestionsCtrl', ['$scope', '$routeParams', '$http', function ($scope, $routeParams, $http) {

    $scope.idCategory = parseInt($routeParams.idCategory);

    $scope.suggestions = [];

    $http.get('suggestion/getSuggestions?idCategory='+$scope.idCategory).success(function (data) {
        $scope.suggestions = data;
    });
}]);
