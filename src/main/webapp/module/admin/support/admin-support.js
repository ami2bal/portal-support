var adminSupportModule = angular.module('adminSupportModule', []);

adminSupportModule.controller('adminSupportCtrl', function ($scope) {

    $scope.populations = [
        {'id': 'particulier', name: 'Un particulier'},
        {'id': 'commune', 'name': 'Une commune'},
        {'id': 'partenaire', name: 'Un partenaire'},
        {'id': 'entreprise', 'name': 'Une entreprise'}
    ];

    $scope.roles = [
        {'value': 'responsableprestation', name: 'Responsable de prestation'},
        {'value': 'referentcommunal', 'name': 'Référent communal'},
        {'value': 'tiersconfiance', name: 'Tiers de confiance'},
        {'value': 'tiersconfiancesuppleant', 'name': 'Tiers de confiance suppléant'},
        {'value': 'utilisateur', 'name': 'Utilisateur'}
    ];

    $scope.themes = [
        {'value': 'theme1', name: 'Nom thème 1'},
        {'value': 'theme2', 'name': 'Nom thème 2'},
        {'value': 'theme3', name: 'Nom thème 3'},
        {'value': 'theme4', 'name': 'Nom thème 4'}
    ];

    $scope.prestations = [
        {'value': 'amenagementcommunal', name: 'Aménagement communal'},
        {'value': 'registrefiscal', 'name': 'Registre fiscal'}
    ];
});

var injector = angular.injector(['ng', 'adminSupportModule']);