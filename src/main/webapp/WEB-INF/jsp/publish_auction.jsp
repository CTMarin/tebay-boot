<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page import="java.util.List" %>
<%@ page import="es.uma.tebayboot.dto.Categoria" %>
<%--
  Created by IntelliJ IDEA.
  User: carlo
  Date: 19/04/2022
  Time: 16:49
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
        max-width: 60vh;
        min-width: 60vh;
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
</style>
<%
    String strError = (String) request.getAttribute("error");
    List<Categoria> categoriaList = (List<Categoria>) request.getAttribute("categoriaList");
    if(strError == null) strError = "";
%>
<body>
    <form:form method="post" action="/profile/publish-auction" cssClass="form" modelAttribute="subasta">
        <h1>
            Subasta un artículo
        </h1>
        <hr>
        <ul class="form-list">
            <li>
                <h2>Artículo</h2>
                <hr>
            </li>
            <li class="input-box">
                <div class="col-25 margin">
                        <%--@declare id="title"--%><label for="title">Título </label>
                </div>
                <div class="col-75 margin">
                    <form:input class="form-input" path="titulo"/>
                </div>
            </li>
            <li class="input-box">
                <div class="col-25 margin">
                        <%--@declare id="caption"--%><label for="caption">Descripción </label>
                </div>
                <div class="col-75 margin">
                    <form:input class="form-input" path="descripcion"/>
                </div>
            </li>
            <li class="input-box">
                <div class="col-25 margin">
                        <%--@declare id="url"--%><label for="url">URL Foto </label>
                </div>
                <div class="col-75 margin">
                    <form:input class="form-input" path="url_imagen"/>
                </div>
            </li>
            <li class="input-box">
                <div class="col-25 margin">
                        <%--@declare id="category"--%><label for="category">Categorías </label>
                </div>
                <div class="col-75 margin">
                    <form:checkboxes path="categorias" items="<%=categoriaList%>" itemLabel="titulo" itemValue="titulo"/>
                </div>
            </li>
            <li>
                <h2>Subasta</h2>
                <hr>
            </li>
            <li class="input-box">
                <div class="col-25 margin">
                        <%--@declare id="init-value"--%><label for="init-value">Valor Inicial </label>
                </div>
                <div class="col-75 margin">
                    <form:input class="form-input" path="valor_inicial"/>
                </div>
            </li>
            <li class="input-box">
                <div class="col-25 margin">
                        <%--@declare id="deadline"--%><label for="deadline">Fecha límite </label>
                </div>
                <div class="col-75 margin">
                    <form:input class="form-input" type="date" path="fecha_limite"/>
                </div>
            </li>
            <li>
                <input class="margin" type="submit" value="Publicar">
            </li>
        </ul>
    </form:form>
</body>
</html>
