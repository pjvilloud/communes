<%@ page contentType="text/html; charset=UTF-8" %>

<html lang="en" >
<head>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/webjars/bootstrap/3.3.7/css/bootstrap.min.css" />
</head>
<body>

<nav class="navbar navbar-default">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a href="/" class="navbar-brand">Gestion des communes</a>
        </div>

        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">

            <form class="navbar-form navbar-right" role="search" action="/communes" method="GET">
                <div class="form-group">
                    <input name="nom" id="nom" class="form-control" placeholder="Rechercher par nom" type="text">
                </div>
                <button type="submit" class="btn btn-default">Rechercher</button>
            </form>
        </div>
    </div>
</nav>
