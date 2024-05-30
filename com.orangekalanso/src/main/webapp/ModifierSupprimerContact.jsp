<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Modifier Contact</title>
</head>
<body>
<h1>Modifier Contact</h1>
<form action="contacts" method="post">
    <input type="hidden" name="id" value="${contact.id}" />
    Nom: <input type="text" name="nom" value="${contact.nom}" /><br/><br/>
    Prénom: <input type="text" name="prenom" value="${contact.prenom}" /><br/><br/>
    Numéro: <input type="text" name="numero" value="${contact.numero}" /><br/><br/>
    Email: <input type="email" name="email" value="${contact.email}" /><br/><br/>
    Adresse: <input type="text" name="adresse" value="${contact.adresse}" /><br/><br/>
    <input type="submit" value="Modifier Contact" />
</form>
<a href="contacts">Annuler</a>
</body>
</html>
