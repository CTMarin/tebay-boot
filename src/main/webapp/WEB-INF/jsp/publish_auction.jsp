<%@ page import="java.util.List" %>
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
    if(strError == null) strError = "";
%>
<body>
    <form method="POST" action="publish-auction" class="form">
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
                    <input class="form-input" type="text" name="title" value="">
                </div>
            </li>
            <li class="input-box">
                <div class="col-25 margin">
                    <%--@declare id="caption"--%><label for="caption">Descripción </label>
                </div>
                <div class="col-75 margin">
                    <input class="form-input" type="text" name="caption" value="">
                </div>
            </li>
            <li class="input-box">
                <div class="col-25 margin">
                    <%--@declare id="url"--%><label for="url">URL Foto </label>
                </div>
                <div class="col-75 margin">
                    <input class="form-input" type="text" name="url" value="">
                </div>
            </li>
            <li class="input-box">
                <div class="col-25 margin">
                    <%--@declare id="category"--%><label for="category">Categorías </label>
                </div>
                <div class="col-75 margin">
                    <%
                        List<CategoriaDTO> categorias = (List) request.getAttribute("categorias");
                        for(CategoriaDTO categoria : categorias) {
                    %>
                    <input type="checkbox" id="<%=categoria.getIdCategoria()%>" value="<%=categoria.getTitulo()%>" name="categories">
                    <label for="<%=categoria.getIdCategoria()%>"><%= categoria.getTitulo()%></label><br>
                    <%
                        }
                    %>
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
                    <input class="form-input" type="text" name="init-value" value="">
                </div>
            </li>
            <li class="input-box">
                <div class="col-25 margin">
                    <%--@declare id="deadline"--%><label for="deadline">Fecha límite </label>
                </div>
                <div class="col-75 margin">
                    <input class="form-input" type="date" name="deadline" value="">
                </div>
            </li>
            <li>
                <input class="margin" type="submit" value="Publicar">
            </li>
        </ul>
    </form>
</body>
</html>
