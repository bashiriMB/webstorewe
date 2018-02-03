<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.0.1/angular.min.js"></script>
    <script src="/webstore/resource/js/controllers.js"></script>
    <title>Profiles</title>
</head>
<body>
<section>
    <div class="jumbotron">
        <div class="container">
            <h1>Profiles</h1>
        </div>
    </div>
</section>
<section class="container" ng-app="profileApp">
    <div ng-controller="profileCtrl" ng-init="initProfileId('${profileId}')">
        <table class="table table-hover">
            <tr>
                <th>Mobile</th>
                <th>Email</th>
            </tr>
            <tr ng-repeat="item in profile.profileItems">
                <td>{{item.mobile}}</td>
                <td>{{item.email}}</td>
                <td><a href="#" class="label label-danger" ngclick="
removeFromProfile(item.id)"> <span
                        class="glyphicon glyphicon-remove" /></span> Remove
                </a>
                    <a href="#" class="label label-danger" ngclick="
updateFromProfil(item.id)"> <span
                            class="glyphicon glyphicon-update" /></span> Edit
                    </a></td>
            </tr>
            <tr>
                <th></th>
            </tr>
        </table>
    </div>
</section>
</body>
</html>
