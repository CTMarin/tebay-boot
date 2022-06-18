<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page import="es.uma.tebayboot.dto.Subasta" %>
<%@ page import="java.util.List" %>
<%@ page import="es.uma.tebayboot.dto.Categoria" %>
<%@ page import="es.uma.tebayboot.dto.Fav" %><%--
  Created by IntelliJ IDEA.
  User: carme
  Date: 09/06/2022
  Time: 12:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Tebay</title>
</head>
<style>
    .form-button{
        display:flex;
        justify-content: space-evenly;
    }

    .wrapper{
        margin:  auto;
        width:  50%;
        max-width: 100vh;
        min-width: 30vh;
    }

    .cell-content{
        text-align: center;
    }

    .table{
        table-layout: fixed;
    }
</style>
<body>
<main class="wrapper">
    <form action="/profile/">
        <input type="submit" value="Volver" />
    </form>
    <h2>Artículos Favoritos</h2>
    <table class="table">
        <tr>
            <th class="cell-content">ARTICULO</th>
            <th class="cell-content">CATEGORIAS</th>
            <th class="cell-content">VALOR INICIAL</th>
            <th class="cell-content">ÚLTIMA PUJA</th>
            <th class="cell-content">FECHA FIN SUBASTA</th>
            <th class="cell-content">ELIMINAR DE FAVS</th>
        </tr>
        <%
            List<Subasta> subastasFav = (List<Subasta>) request.getAttribute("subastasFav");
            for(Subasta subasta : subastasFav) {
                Fav fav = subasta.getFav();
        %>
        <tr>
            <td class="cell-content">
                <a href="/product/<%=subasta.getArticulo().getIdArticulo()%>"><%=subasta.getArticulo().getTitulo()%></a>
            </td>
            <td class="cell-content">
                <%
                    for(Categoria categoria : subasta.getArticulo().getCategoriaList()) {
                %>
                <span><%=categoria.getTitulo()%></span>
                <%
                    }
                %>
            </td>
            <td class="cell-content">
                <%=subasta.getValorInicial()%>
            </td class="cell-content">
            <td class="cell-content">
                <%=subasta.getPuja()%>
            </td>
            <td class="cell-content">
                <%=subasta.getFechaLimite()%>
            </td>
            <td class="cell-content">
                <form method="get" action="/product/fav">
                    <input type="hidden" name="id" value="<%=subasta.getIdSubasta()%>">
                    <input type="hidden" name="fav" value=<%=true%>>
                    <input type="submit" value="Eliminar">
                </form>
            </td>
        </tr>
        <%
            }
        %>
    </table>
</main>

</body>
</html>
