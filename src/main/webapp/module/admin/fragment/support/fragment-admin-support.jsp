<div ng-app="adminSupportApp" ng-controller="adminSupportCtrl">
    <div class="col-xs-6 col-sm-4 col-md-4 col-lg-2">
        <h3>Population</h3>
        <ul class="list-group">
            <a ng-repeat="population in populations"
               href="<%=request.getContextPath()%>/admin-support?idSupport={{population.id}}" class="list-group-item">
                {{population.name}}
            </a>
        </ul>
    </div>

    <div class="col-xs-6 col-sm-8 col-md-8 col-lg-10">
        <h3>Informations de support</h3>
        <div class="col-xs-12 col-sm-6 col-md-6 col-lg-4">
            <h5>Rôles</h5>
            <ul class="list-group">
                <li class="list-group-item">Dapibus ac facilisis in</li>
                <li class="list-group-item">Cras sit amet nibh libero</li>
                <li class="list-group-item">Porta ac consectetur ac</li>
                <li class="list-group-item">Vestibulum at eros</li>
            </ul>
        </div>
        <div class="col-xs-12 col-sm-6 col-md-6 col-lg-4">
            <h5>Prestation</h5>
            <ul class="list-group">
                <li class="list-group-item">Dapibus ac facilisis in</li>
                <li class="list-group-item">Cras sit amet nibh libero</li>
                <li class="list-group-item">Porta ac consectetur ac</li>
                <li class="list-group-item">Vestibulum at eros</li>
            </ul>
        </div>
        <div class="col-xs-12 col-sm-6 col-md-6 col-lg-4">
            <h5>Thèmes FAQ</h5>
            <ul class="list-group">
                <li class="list-group-item">Dapibus ac facilisis in</li>
                <li class="list-group-item">Cras sit amet nibh libero</li>
                <li class="list-group-item">Porta ac consectetur ac</li>
                <li class="list-group-item">Vestibulum at eros</li>
            </ul>
        </div>
    </div>
</div>

<script type="text/javascript" src="<%=request.getContextPath()%>/module/admin/fragment/support/admin-support.js"
        charset="utf-8"></script>