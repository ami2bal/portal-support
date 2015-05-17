var supportApp = angular.module('supportApp', []);

supportApp.controller('supportCtrl', function ($scope) {
    $scope.civilites = [
        {'value': 'mr', name: 'Monsieur'},
        {'value': 'mme', 'name': 'Madame'}
    ];

    $scope.concernes = [
        {'value': 'particulier', name: 'Un particulier'},
        {'value': 'commune', 'name': 'Une commune'},
        {'value': 'partenaire', name: 'Un partenaire'},
        {'value': 'entreprise', 'name': 'Une entreprise'}
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