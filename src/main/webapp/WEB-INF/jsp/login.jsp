<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: carlo
  Date: 14/04/2022
  Time: 8:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Tebay</title>
</head>
<style>
    .form {
        margin:  auto;
        width:  50%;
        max-width: 50vh;
        min-width: 45vh;
    }
    .form-input {
        width: 100%;
        resize: none;
    }
    .col-25 {
        float: left;
        width: 25%;
    }
    .col-75 {
        float: left;
        width: 75%;
    }
    .margin {
        margin-top: 1vh;
    }
    .form-list {
        list-style-type: none;

    }
    .error {
        color: red;
    }
</style>
<%
    String strError = (String) request.getAttribute("error");
    if(strError == null) strError = "";
%>
<body>
<form:form method="post" action="/auth" modelAttribute="user" cssClass="form">
    <h1>
        Bienvenido a Tebay
    </h1>
    <hr>
    <span class="error"><%= strError %></span>
    <ul class="form-list">
        <li>
            <div class="col-25 margin">
                    <%--@declare id="email"--%><label for="email">Email </label>
            </div>
            <div class="col-75 margin">
                <form:input class="form-input" type="email" path="email"/>
            </div>
        </li>
        <li>
            <div class="col-25 margin">
                    <%--@declare id="passwd"--%><label for="passwd">Contraseña </label>
            </div>
            <div class="col-75 margin">
                <form:input class="form-input" type="password" path="password"/>
            </div>
        </li>
        <li>
            <input class="margin" type="submit" value="Enviar">
        </li>
    </ul>
    <p>¿No tienes cuenta? <a href="/register">Registrate aquí.</a></p>
</form:form>
</body>
</html>
