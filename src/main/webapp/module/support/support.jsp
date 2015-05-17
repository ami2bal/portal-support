<%@ page contentType="text/html; charset=utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="fr" lang="fr" ng-app="supportApp">
<head>
    <!-- Html Title -->
    <title>Support</title>

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
    <link rel="stylesheet" href="<%=request.getContextPath()%>/module/support/support.css"/>
    <script type="text/javascript" src="<%=request.getContextPath()%>/module/support//support.js"
            charset="utf-8"></script>
</head>
<body ng-controller="SupportCtrl">

<div id="support" class="container-fluid">
    <h1>Contact</h1>

    <ul>
        <li>Vous avez une question ou rencontrez une difficulté à l'utilisation de ce site, vous pouvez consulter la
            liste des <a href="https://www.portail.vd.ch/prestations/web/guest/faq">« questions fréquentes »</a> ou le
            film <a href="https://www.portail.vd.ch/prestations/web/guest/decouvrir-le-portail">« découvrir le portail
                »</a>.
        </li>
        <li>Si vous ne trouvez pas la réponse à votre question, vous pouvez renseigner le formulaire de contact et
            l'envoyer à l'assistance « courriel » du guichet.
        </li>
        <li>Des suggestions de questions/réponses peuvent vous être proposées lors de la selection du thème, nous vous
            invitons à vérifier si celles-ci correspondent à votre demande.
        </li>
        <li>Les champs suivis d'une (*) sont obligatoires.</li>
    </ul>

    <div class="form-horizontal">
        <fieldset>
            <legend>Votre identité</legend>

            <div class="form-group">
                <label for="civilite" class="col-xs-6 col-sm-6 col-md-3 col-lg-2 control-label">Civilité *</label>

                <div class="col-xs-6 col-sm-4 col-md-4 col-lg-2">
                    <select id="civilite" class="form-control">
                        <option ng-repeat="civilite in civilites" value="{{civilite.value}}">{{civilite.name}}</option>
                    </select>
                </div>
            </div>
            <div class="form-group">
                <label for="nomprenom" class="col-xs-6 col-sm-6 col-md-3 col-lg-2 control-label">Nom - Prénom *</label>

                <div class="col-xs-6 col-sm-4 col-md-4 col-lg-2">
                    <input type="text" id="nomprenom" class="form-control"/>
                </div>
            </div>
            <div class="form-group">
                <label for="email" class="col-xs-6 col-sm-6 col-md-3 col-lg-2 control-label">Adresse email *</label>

                <div class="col-xs-6 col-sm-4 col-md-4 col-lg-2">
                    <input type="text" id="email" class="form-control"/>
                </div>
            </div>
            <div class="form-group">
                <label for="telephone" class="col-xs-6 col-sm-6 col-md-3 col-lg-2 control-label">Téléphone</label>

                <div class="col-xs-6 col-sm-4 col-md-4 col-lg-2">
                    <input type="text" id="telephone" class="form-control"/>
                </div>
            </div>
        </fieldset>
    </div>


    <div class="form-horizontal">
        <fieldset>
            <legend>Type de demande</legend>
            <div class="form-group">
                <label for="concerne" class="col-xs-6 col-sm-6 col-md-3 col-lg-2 control-label">Concerne *</label>

                <div class="col-xs-6 col-sm-4 col-md-4 col-lg-2">
                    <select id="concerne" class="form-control">
                        <option ng-repeat="concerne in concernes" value="{{concerne.value}}">{{concerne.name}}</option>
                    </select>
                </div>
            </div>
            <div class="form-group">
                <label for="nomcommune" class="col-xs-6 col-sm-6 col-md-3 col-lg-2 control-label">Nom commune</label>

                <div class="col-xs-6 col-sm-4 col-md-3 col-lg-2">
                    <input type="text" id="nomcommune" class="form-control"/>
                </div>

                <label for="noofs" class="col-xs-6 col-sm-6 col-md-3 col-lg-2 control-label">N° Ofs</label>

                <div class="col-xs-4 col-sm-4 col-md-3 col-lg-2">
                    <input type="text" readonly="readonly" id="noofs" class="form-control"/>
                </div>
            </div>
            <div class="form-group">
                <label for="role" class="col-xs-6 col-sm-6 col-md-3 col-lg-2 control-label">Rôle</label>

                <div class="col-xs-6 col-sm-4 col-md-4 col-lg-2">
                    <select id="role" class="form-control">
                        <option ng-repeat="role in roles" value="{{role.value}}">{{role.name}}</option>
                    </select>
                </div>
            </div>
            <div class="form-group">
                <label for="theme" class="col-xs-6 col-sm-6 col-md-3 col-lg-2 control-label">Thème *</label>

                <div class="col-xs-6 col-sm-4 col-md-4 col-lg-2">
                    <select id="theme" class="form-control">
                        <option ng-repeat="theme in themes" value="{{theme.value}}">{{theme.name}}</option>
                    </select>
                </div>
            </div>
            <div class="form-group">
                <label for="prestation" class="col-xs-6 col-sm-6 col-md-3 col-lg-2 control-label">Prestation</label>

                <div class="col-xs-6 col-sm-4 col-md-4 col-lg-2">
                    <select id="prestation" class="form-control">
                        <option ng-repeat="prestation in prestations" value="{{prestation.code}}">{{prestation.name}}
                        </option>
                    </select>
                </div>
            </div>
        </fieldset>
    </div>

    <div class="form-horizontal">
        <fieldset>
            <legend>Suggestions</legend>
            <div class="panel-group" id="accordion" role="tablist" aria-multiselectable="true">
                <div class="panel panel-default">
                    <div class="panel-heading" role="tab" id="headingOne">
                        <h3 class="panel-title">
                            <a data-toggle="collapse" data-parent="#accordion" href="#collapseOne" aria-expanded="true"
                               aria-controls="collapseOne">
                                Avec l’ouverture du portail, doit-on se recréer un compte IAM?
                            </a>
                        </h3>
                    </div>
                    <div id="collapseOne" class="panel-collapse collapse in" role="tabpanel"
                         aria-labelledby="headingOne">
                        <div class="panel-body">
                            Non. Vous pouvez migrer votre compte actuel pour le rendre compatible avec le portail des
                            communes.
                        </div>
                    </div>
                </div>
                <div class="panel panel-default">
                    <div class="panel-heading" role="tab" id="headingTwo">
                        <h3 class="panel-title">
                            <a class="collapsed" data-toggle="collapse" data-parent="#accordion" href="#collapseTwo"
                               aria-expanded="false" aria-controls="collapseTwo">
                                Est-ce qu'il faudra redemander les accès à toutes les applications à l'ouverture du
                                portail?
                            </a>
                        </h3>
                    </div>
                    <div id="collapseTwo" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingTwo">
                        <div class="panel-body">
                            Oui, en cas de demande d’un nouveau compte professionnel. Dans ce cas, les demandes de
                            prestations pourront être effectuées en même temps que la demande de compte.

                            Non, en cas de migration de votre compte IAM. Dans ce cas, le système présentera la liste
                            des prestations actuellement associées à votre compte IAM, et vous demandera de préciser
                            pour chacune d’elle la liste des communes dans laquelle vous l’utilisez. Vous ne pourrez par
                            contre migrer qu’un seul compte. Si vous en possédez plusieurs, nous vous conseillons de
                            migrer le compte vous donnant actuellement le plus de droits, et de redemander, au titre du
                            compte migré, les accès affectés à vos autres comptes.
                        </div>
                    </div>
                </div>
            </div>
        </fieldset>
    </div>

    <div class="form-horizontal">
        <fieldset>
            <legend>Détails</legend>
            <div class="form-group">
                <label for="objetdemande" class="col-xs-6 col-sm-6 col-md-3 col-lg-2 control-label">Objet de la
                    demande</label>

                <div class="col-xs-6 col-sm-4 col-md-4 col-lg-2">
                    <input type="text" id="objetdemande" class="form-control"/>
                </div>
            </div>
            <div class="form-group">
                <label for="descriptiondemande" class="col-xs-6 col-sm-6 col-md-3 col-lg-2 control-label">Description de
                    votre demande</label>

                <div class="col-xs-6 col-sm-6 col-md-6 col-lg-4">
                    <textarea rows="8*" id="descriptiondemande" class="form-control"></textarea>
                </div>
            </div>
        </fieldset>
    </div>
    <div class="row">
        <div class="col-xs-6 col-sm-6 col-md-3 col-lg-2">
        </div>
        <div class="col-xs-6 col-sm-6 col-md-6 col-lg-4">
            <button type="button" class="btn btn-default">Annuler</button>
            <button type="button" class="btn btn-success">Envoyer la demande</button>
        </div>
    </div>

</div>
</body>
</html>
