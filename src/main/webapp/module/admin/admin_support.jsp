<%@ page contentType="text/html; charset=utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="fr" lang="fr">
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
    <!-- Support -->
    <link rel="stylesheet" href="<%=request.getContextPath()%>/module/admin/admin.css"/>
    <script type="text/javascript" src="<%=request.getContextPath()%>/module/support/admin.js" charset="utf-8"></script>
</head>
<body>

<div id="admin">
    <h1>Admin</h1>
    <nav class="navbar navbar-default">
        <div class="container-fluid">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#admin-navbar">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="#">Admin</a>
            </div>

            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="admin-navbar">
                <ul class="nav navbar-nav">
                    <li><a href="<%=request.getContextPath()%>/admin">Gestion FAQ</a></li>
                    <li class="active"><a href="<%=request.getContextPath()%>/admin-support">Gestion Support</a></li>
                </ul>
                <ul class="nav navbar-nav navbar-right">
                    <li><a href="<%=request.getContextPath()%>/support">Support</a></li>
                    <li><a href="<%=request.getContextPath()%>/faq">FAQ</a></li>
                </ul>
            </div><!-- /.navbar-collapse -->
        </div><!-- /.container-fluid -->
    </nav>
</div>

<jsp:include page="fragment/support/fragment-admin-support.jsp"/>
</body>
</html>
