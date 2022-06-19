<%@ page import="es.uma.tebayboot.dto.Articulo" %>
<%@ page import="es.uma.tebayboot.dto.Subasta" %>
<%@ page import="es.uma.tebayboot.dto.Categoria" %>
<%@ page import="es.uma.tebayboot.dto.Usuario" %><%--
  Created by IntelliJ IDEA.
  User: Carmen González Ortega
  Date: 09/06/2022
  Time: 17:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Tebay</title>
</head>
<style>
    .wrapper {
        margin:  auto;
        width:  50%;
        max-width: 50vh;
        min-width: 45vh;
        display: flex;
        flex-direction: column;
        justify-content: center;
        align-items: center;
    }
    .articulo-img{
        width:50vh;
    }
    .margin {
        margin-top: 1vh;
    }
    .form-list {
        list-style-type: none;
    }
</style>
<%
    Articulo articulo = (Articulo) request.getAttribute("articulo");
    Subasta subasta = (Subasta) request.getAttribute("subasta");
    if(articulo != null) {
%>
<body>
<main class="wrapper">
    <h2><%=articulo.getTitulo()%></h2>
    <ul class="form-list">
        <li>
            <div class="margin">
                <img class="articulo-img" src="<%=articulo.getUrlArticulo()%>">
            </div>
        </li>
        <li>
            <div class="margin">
                Descripción: <%=articulo.getDescripcion() %>
            </div>
        </li>
        <li>
            <div class="margin">
                Categorías:
                <%
                    for(Categoria categoria : articulo.getCategoriaList()) {
                %>
                <span><%=categoria.getTitulo()%></span>
                <%
                    }
                %>
            </div>
        </li>
        <li>
            <div class="margin">
                Límite: <%=subasta.getFechaLimite()%>
            </div>
        </li>
        <li>
            <div class="margin">
                <%
                    Usuario ganador = (Usuario) request.getAttribute("ganador");
                    //UsuarioDTO ganador = articulo.getGanador();
                    if (ganador != null){
                %>
                Ganador: <%=ganador.getNombre()+ganador.getApellidos()%>
                <% } else { %>
                Aún activa
                <% } %>
            </div>
        </li>
        <li>
            <div class="margin">
                Valor inicial: <%=subasta.getValorInicial()%>
            </div>
        </li>
        <li>
            <div class="margin">
                Última puja:
                <%
                    Double puja = subasta.getPuja();
                    if (puja != null){
                %>
                <%=puja.doubleValue()%>
                <%
                } else{
                %>
                Sin pujas aún
                <%
                    }
                %>
            </div>
        </li>
    </ul>
    <%
        }
    %>

</main>

</body>
</html>
