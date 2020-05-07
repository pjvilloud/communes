<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ include  file="header.jsp" %>

<div class="container">
    <div class="jumbotron">
        <h1>Bienvenue dans l'interface de gestion des <span>${nbEmployes}</span> communes !</h1>
    </div>
        ${requestScope['javax.servlet.forward.request_uri']}

    <% out.print(request.getQueryString()); %>
    <div>
        <table class="table table-hover table-striped">
            <thead>
            <tr>
                <th scope="col">
                    Code Insee
                </th>
                <th scope="col">
                    Nom
                </th>
                <th scope="col">
                   Code postal
                </th>
                <th scope="col">
                    Ligne 5
                </th>
                <th scope="col"></th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${communes.content}" var="commune">
                <tr>
                    <th scope="row">${commune.codeInsee}</th>
                    <td>${commune.nom}</td>
                    <td>${commune.codePostal}</td>
                    <td>${commune.ligne5}</td>
                    <td><a href="/communes/${commune.id}">Détail</a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <div class="row">
            <div class="col-lg-6">
                <p>
                    Affichage des communes ${communes.number*communes.size+1} à ${communes.number*communes.size+communes.content.size()} sur un total de ${communes.totalElements}</p>
            </div>
            <div class="col-lg-6">
                <ul class="pagination">
                    <% if(request.getParameter("page") == null || request.getParameter("page").equals("0")) {%>
                    <li class="disabled"><a href="">&laquo;</a></li>
                    <% } else { %>
                    <li><a href="/communes?page=${param.page-1}&size=${param.size}&sortProperty=${param.sortProperty}&sortDirection=${param.sortDirection}">&laquo;</a></li>
                    <% } %>
                    <li><a href="#">Page ${param.page+1}/${communes.totalPages}</a></li>
                    <c:choose>
                        <c:when test="${param.page+1 == employes.totalPages}">
                            <li class="disabled"><a href="">&raquo;</a></li>
                        </c:when>
                        <c:otherwise>
                            <li><a href="/communes?page=${param.page+1}&size=${param.size}&sortProperty=${param.sortProperty}&sortDirection=${param.sortDirection}">&raquo;</a></li>
                        </c:otherwise>
                    </c:choose>
                </ul>
            </div>
        </div>
    </div>
</div>

<%@ include  file="footer.jsp" %>

