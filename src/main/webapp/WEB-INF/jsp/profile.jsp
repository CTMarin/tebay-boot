<%--
  Created by IntelliJ IDEA.
  User: carme
  Date: 08/06/2022
  Time: 19:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Tebay</title>
</head>
<style>
    .form-buttons{
        display:flex;
        justify-content: space-evenly;
    }

    .wrapper{
        margin:  auto;
        width:  50%;
        max-width: 50vh;
        min-width: 45vh;
    }
</style>
<body>
<main class="wrapper">
    <h1>Profile</h1>
    <div class="form-buttons">
        <form action="/marketplace/">
            <input type="submit" value="Marketplace" />
        </form>
        <form action="publish-auction">
            <input type="submit" value="Publicar una subasta" />
        </form>
    </div>

    <div class="form-buttons">
        <form action="/profile/published-articles">
            <input type="submit" value="Subastas Publicadas" />
        </form>
        <form action="/profile/won-auctions">
            <input type="submit" value="Subastas Ganadas" />
        </form>
        <form action="/profile/fav-articles">
            <input type="submit" value="Artículos Favoritos" />
        </form>
    </div>
</main>
</body>
</html>
