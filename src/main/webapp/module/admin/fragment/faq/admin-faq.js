var adminFaqApp = angular.module('adminFaqApp', []);

adminFaqApp.controller('adminFaqCtrl', function ($scope) {
    $scope.suggestions = [
        {'id': 'id1','question': 'mr', reponse: 'Monsieur','idCategory':'idCate1'},
        {'id': 'id2','question': 'c. Peut-on faire une demande groupée pour plusieurs prestations?', 'reponse': 'Oui. Dans ce cas, les demandes de prestations seront soumises en parallèle pour validation à chaque responsable de prestation concerné.','idCategory':'idCate2'}
    ];

    $scope.populations = [
        {'id': 'particulier', name: 'Un particulier'},
        {'id': 'commune', 'name': 'Une commune'},
        {'id': 'partenaire', name: 'Un partenaire'},
        {'id': 'entreprise', 'name': 'Une entreprise'}
    ];

    $scope.categories = [
        {'id': '1', name: 'Nom thème 1', 'suggestionsCount':'2'},
        {'id': '2', 'name': 'Nom thème 2', 'suggestionsCount':'2'},
        {'id': '3', name: 'Nom thème 3', 'suggestionsCount':'2'},
        {'id': '4', 'name': 'Nom thème 4', 'suggestionsCount':'2'}
    ];
});

var injector = angular.injector(['ng', 'adminFaqApp']);