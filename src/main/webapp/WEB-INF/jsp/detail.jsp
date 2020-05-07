<%@ page contentType="text/html; charset=UTF-8" %>
<%@ include file="header.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div class="container">
    <h2>Détail de la commune ${commune.codeInsee}, ${commune.nom}</h2>
    <div class="row">
        <form id="saveForm" action="" method="post">
            <div class="col-sm-12 col-lg-6">
                <div class="form-group">
                    <label class="form-control-label" for="codeInsee">Code INSEE</label>
                    <input type="text" value="${commune.codeInsee}" class="form-control" name="codeInsee" id="codeInsee">

                    <label class="form-control-label" for="nom">Nom</label>
                    <input type="text" value="${commune.nom}" class="form-control" name="nom" id="nom">

                    <label class="form-control-label" for="codePostal">Code postal</label>
                    <input type="text" value="${commune.codePostal}" class="form-control" name="codePostal" id="codePostal">

                    <label class="form-control-label" for="libelleAcheminement">Libellé acheminement</label>
                    <input type="text" value="${commune.libelleAcheminement}" class="form-control" name="libelleAcheminement"
                           id="libelleAcheminement">

                    <label class="form-control-label" for="ligne5">Ligne 5</label>
                    <input type="text" value="${commune.ligne5}" class="form-control" name="ligne5"
                           id="ligne5">

                    <label class="form-control-label" for="latitude">Latitude</label>
                    <input type="text" value="${commune.latitude}" class="form-control" name="latitude"
                           id="latitude">

                    <label class="form-control-label" for="longitude">Longitude</label>
                    <input type="text" value="${commune.longitude}" class="form-control" name="longitude"
                           id="longitude">
                </div>
            </div>
        </form>
            <div class="col-lg-6">
                <iframe width="650" height="450" frameborder="0" scrolling="no" marginheight="0" marginwidth="0" src="https://www.openstreetmap.org/export/embed.html?bbox=${commune.longitude-0.10}%2C${commune.latitude-0.5}%2C${commune.longitude+0.10}%2C${commune.latitude+0.5}&amp;layer=mapnik&amp;marker=${commune.latitude}%2C${commune.longitude}" style="border: 1px solid black"></iframe>

            </div>
        <div class="col-sm-12">
            <h3>Communes dans un périmètre de ${perimetre} km</h3>
            <ul class="list-group">
                <c:forEach items="${communesProches}" var="communeProche">
                    <c:if test="${communeProche.nom != commune.nom}">
                        <li class="list-group-item"><a href="/communes/${communeProche.id}">${communeProche.nom}  <span class="badge">${communeProche.getDistance(commune.latitude, commune.longitude)} km</span></a></li>
                    </c:if>
                </c:forEach>
            </ul>
        </div>
        <div class="col-sm-12">
            <input form="saveForm" class="btn btn-primary" type="submit" value="Enregistrer"/>
            <a href="" class="btn btn-danger">Supprimer</a>
        </div>
    </div>
</div>

<%@ include file="footer.jsp" %>
