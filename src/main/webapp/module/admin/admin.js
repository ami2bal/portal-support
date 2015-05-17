var adminApp = angular.module('adminApp', ['ngRoute', 'adminFaqModule','adminSupportModule']);

adminApp.config(['$routeProvider',
    function($routeProvider) {
        $routeProvider.
            when('/faq', {
                templateUrl: 'module/admin/faq/admin-faq.html'
            }).
            when('/faq/:idCategory', {
                templateUrl: 'module/admin/faq/admin-faq.html'
            }).
            when('/support', {
                templateUrl: 'module/admin/support/admin-support.html'
            }).
            otherwise({
                redirectTo: '/faq'
            });
    }]);

adminApp.controller('adminCtrl', ['$scope', '$timeout', function($scope, $timeout){
    $timeout(function(){
        console.log($scope);
    }, 1000);


}]);
