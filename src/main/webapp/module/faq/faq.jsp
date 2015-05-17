<%@ page contentType="text/html; charset=utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="fr" lang="fr">
<head>
    <!-- Html Title -->
    <title>Faq</title>

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
    <link rel="stylesheet" href="<%=request.getContextPath()%>/module/faq/faq.css"/>
    <script type="text/javascript" src="<%=request.getContextPath()%>/module/faq/faq.js" charset="utf-8"></script>
</head>
<body>

<div id="faq" class="container-fluid">
    <h1>FAQ</h1>

    <div class="panel-group" id="accordion" role="tablist" aria-multiselectable="true">
        <div class="panel panel-default">
            <div class="panel-heading" role="tab" id="headingOne">
                <h3 class="panel-title">
                    <a data-toggle="collapse" data-parent="#accordion" href="#collapseOne" aria-expanded="true"
                       aria-controls="collapseOne">A. Généralités</a>
                </h3>
            </div>
            <div id="collapseOne" class="panel-collapse collapse in" role="tabpanel"
                 aria-labelledby="headingOne">
                <div class="panel-body">
                    <ul>
                        <li>a. A quoi sert le portail des prestations en ligne ?</li>
                    </ul>
                </div>
            </div>
        </div>
        <div class="panel panel-default">
            <div class="panel-heading" role="tab" id="headingTwo">
                <h3 class="panel-title">
                    <a class="collapsed" data-toggle="collapse" data-parent="#accordion" href="#collapseTwo"
                       aria-expanded="false" aria-controls="collapseTwo">
                        B. Demander un compte professionnel IUP
                    </a>
                </h3>
            </div>
            <div id="collapseTwo" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingTwo">
                <div class="panel-body">
                    <ul>
                        <li>a. Je partage mon compte avec une collègue qui travaille à temps partiel et un apprenti qui
                            en a rarement
                            besoin. Dois-je vraiment leur faire ouvrir leurs propres comptes ?
                        </li>
                        <li>b. Je suis un nouvel employé de la commune, dois-je effectuer une demande d’un compte
                            professionnel IUP ?
                        </li>
                        <li>c. J’ai fait une demande de compte mais je n’ai pas reçu mon identifiant professionnel ou
                            mon mot de passe ?
                        </li>
                        <li>d. Quelle est la différence entre un compte professionnel IUP et un compte IAM ?</li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
