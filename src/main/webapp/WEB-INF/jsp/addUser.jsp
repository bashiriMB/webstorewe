<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.0.1/angular.min.js"></script>
    <script src="/webstore/resource/js/controllers.js"></script>
    <title>User</title>
</head>
<body>
<section>
    <div class="jumbotron">
        <div class="container">
            <h1>Users</h1>
        </div>
    </div>
</section>
<section class="container" ng-app="userApp">
    <div ng-controller="userCtrl" ng-init="initUserId('${userId}')">


        <table class="table table-hover">
            <tr>
                <th>Name</th>
                <th>Last Name</th>
                <th>UserName</th>
            </tr>
            <tr ng-repeat="item in user.userItems">
                <td>{{item.name}}</td>
                <td>{{item.lName}}</td>
                <td>{{item.userName}}</td>
                <td><a href="#" class="label label-danger" ngclick="
removeFromUser(item.id)"> <span
                        class="glyphicon glyphicon-remove" /></span> Remove
                </a>
                    <a href="#" class="label label-danger" ngclick="
updateFromUser(item.id)"> <span
                            class="glyphicon glyphicon-update" /></span> Edit
                    </a></td>updateFromUser
            </tr>
            <tr>
                <th></th>
            </tr>
        </table>
    </div>
</section>
</body>
</html>
