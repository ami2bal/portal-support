<%@ page contentType="text/html; charset=utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="fr" lang="fr" ng-app="adminApp">
<head>
    <!-- Html Title -->
    <title>Admin</title>

    <!-- Bootstrap -->
    <link rel="stylesheet"
          href="<%=request.getContextPath()%>/lib/bower_components/bootstrap/dist/css/bootstrap.min.css"/>
    <!-- Theme boostrap -->
    <link rel="stylesheet"
          href="<%=request.getContextPath()%>/lib/bower_components/bootstrap/dist/css/bootstrap-theme.min.css"/>
    <!-- Font awesome -->
    <link rel="stylesheet"
          href="<%=request.getContextPath()%>/lib/bower_components/font-awesome/css/font-awesome.min.css"/>
    <!-- JQuery -->
    <script type="text/javascript" src="<%=request.getContextPath()%>/lib/bower_components/jquery/dist/jquery.min.js"
            charset="utf-8"></script>
    <!-- Bootstrap & plugins -->
    <script type="text/javascript"
            src="<%=request.getContextPath()%>/lib/bower_components/bootstrap/dist/js/bootstrap.min.js"
            charset="utf-8"></script>
    <!-- Angular -->
    <script type="text/javascript" src="<%=request.getContextPath()%>/lib/bower_components/angular/angular.js"
            charset="utf-8"></script>
    <!-- Angular -->
    <script type="text/javascript"
            src="<%=request.getContextPath()%>/lib/bower_components/angular-route/angular-route.min.js"
            charset="utf-8"></script>
    <!-- Admin -->
    <link rel="stylesheet" href="<%=request.getContextPath()%>/module/admin/admin.css"/>
    <script type="text/javascript" src="<%=request.getContextPath()%>/module/admin/admin.js"
            charset="utf-8"></script>
    <!-- Admin modules -->
    <script type="text/javascript" src="<%=request.getContextPath()%>/module/admin/support/admin-support.js"
            charset="utf-8"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/module/admin/faq/admin-faq.js"
            charset="utf-8"></script>
    <!-- Admin faq modules -->
    <script type="text/javascript" src="<%=request.getContextPath()%>/module/admin/faq/category/editCategory.js"
            charset="utf-8"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/module/admin/faq/suggestion/editSuggestion.js"
            charset="utf-8"></script>
</head>
<body ng-controller="adminCtrl">

<div id="admin">
    <h1>Admin</h1>

    <!-- Navbar -->
    <ng-include src="'module/admin/navbar/navbar.html'"></ng-include>

    <!-- Content -->
    <div id="admin-content" ng-view></div>
</div>

</body>
</html>
