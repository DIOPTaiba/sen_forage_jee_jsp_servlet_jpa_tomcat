<%--
  Created by IntelliJ IDEA.
  User: simplon
  Date: 17-10-2020
  Time: 19:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Client</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
    </head>
    <body>
        <pre>
            <form method="post" action="Client">

                <label>Nom de famille</label>
                <input type="text" name="nomFamille" />

                <label>Nom du village</label>
                <input type="text" name="village" />

                <label>Adresse</label>
                <input type="text" name="adresse" />

                <label>Numéro Téléphone</label>
                <input type="text" name="telephone" />

                <input type="submit" value="Envoyer"/>

            </form>
        </pre>
    </body>
</html>
