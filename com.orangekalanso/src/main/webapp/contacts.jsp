<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Liste des Contacts</title>
</head>
<body>
<h1>Liste des Contacts</h1>
<form action="contacts" method="post">
    Nom: <input type="text" name="nom" required/><br/><br/>
    Prénom: <input type="text" name="prenom" required/><br/><br/>
    Numéro: <input type="text" name="numero" required /><br/><br/>
    Email: <input type="email" name="email" required/><br/><br/>
    Adresse: <input type="text" name="adresse" required/><br/><br/>
    <input type="submit" value="Ajouter Contact" />
</form>
<ul>
    <c:forEach var="contact" items="${contacts}">
        <li>
            ${contact.nom} ${contact.prenom} - ${contact.numero} - ${contact.email} - ${contact.adresse}
            <form action="contacts" method="post" style="display:inline;">
                <input type="hidden" name="id" value="${contact.id}" />
                <input type="hidden" name="_method" value="DELETE" />
                <input type="submit" value="Supprimer" />
            </form>
            <form action="contacts" method="get" style="display:inline;">
                <input type="hidden" name="id" value="${contact.id}" />
                <input type="submit" value="Modifier" />
            </form>
        </li>
    </c:forEach>
</ul>
<a href="index.jsp">Retour à l'accueil</a>
</body>
</html>
