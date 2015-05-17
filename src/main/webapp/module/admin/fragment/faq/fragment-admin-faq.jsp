<div ng-app="adminFaqApp" ng-controller="adminFaqCtrl">
    <div class="col-xs-6 col-sm-4 col-md-4 col-lg-2">
        <h3>Thème</h3>
        <ul class="list-group">
            <a ng-repeat="category in categories" href="<%=request.getContextPath()%>/admin-faq?idCategory={{category.id}}" class="list-group-item">
                <span class="badge">{{category.suggestionsCount}}</span>
                {{category.name}}
            </a>
        </ul>
    </div>

    <div class="col-xs-6 col-sm-8 col-md-8 col-lg-10">
        <div class="pull-right">
            <button type="button" class="btn btn-success btn-block" data-toggle="modal" data-target="#adminFaqModal">Ajouter
                une suggestion
            </button>
        </div>
        <div>
            <h3>Suggestions</h3>
            <table class="table">
                <tr>
                    <th>id</th>
                    <th>Question</th>
                    <th>Réponse</th>
                    <th>Actions</th>
                </tr>
                <tr ng-repeat="suggestion in suggestions">
                    <td>{{suggestion.id}}</td>
                    <td>{{suggestion.question}}</td>
                    <td>{{suggestion.reponse}}</td>
                    <td>
                        <button type="button" class="btn btn-info">Editer</button>
                        <button type="button" class="btn btn-warning">Supprimer</button>
                    </td>
                </tr>
            </table>
        </div>
    </div>
</div>

<!-- Modal -->
<div class="modal fade" id="adminFaqModal" tabindex="-1" role="dialog" aria-labelledby="adminFaqModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                        aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="adminFaqModalLabel">Nouvelle suggestion</h4>
            </div>
            <div class="modal-body">
                    <div class="form-group">
                        <label for="objetdemande" class="control-label">Question</label>

                        <div>
                            <input type="text" id="objetdemande" class="form-control"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="descriptiondemande" class="control-label">Réponse</label>

                        <div>
                            <textarea rows="8*" id="descriptiondemande" class="form-control"></textarea>
                        </div>
                    </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                <button type="button" class="btn btn-primary">Save changes</button>
            </div>
        </div>
    </div>
</div>

<script type="text/javascript" src="<%=request.getContextPath()%>/module/admin/fragment/faq/admin-faq.js"
        charset="utf-8"></script>