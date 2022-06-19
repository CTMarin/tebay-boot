<%@ page import="es.uma.tebayboot.dto.Categoria" %>
<%@ page import="java.util.List" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="es.uma.tebayboot.dto.Subasta" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.time.Instant" %>
<%@ page import="es.uma.tebayboot.dto.Usuario" %><%--
  Created by IntelliJ IDEA.
  User: carme
  Date: 08/06/2022
  Time: 19:46
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
<main class="wrapper">
    <body>
    <form action="/profile/">
        <input type="submit" value="Volver" />
    </form>
    <h2>Búsqueda</h2>
    <form method="get" action="published-articles">
        <%--@declare id="searchbox"--%><label for="searchbox">Search: </label>
        <input type="search" name="searchbox">
        <input type="submit" value="Buscar">
    </form>
    <h2>Filtros</h2>
    <form method="get" action="published-articles">
        <%--@declare id="categoria_filter"--%><label for="categoria_filter">Categoria: </label>
        <%
            List<Categoria> categorias = (List<Categoria>) request.getAttribute("categorias");
            for(Categoria categoria : categorias) {
        %>
        <input type="checkbox" name="categoria_filter" value=<%=categoria.getTitulo()%>> <%=categoria.getTitulo()%>
        <%
            }
        %>
        <br>
        <%--@declare id="min_init_value"--%><label for="min_init_value">Min. Valor Inicial: </label>
        <input type="number" name="min_init_value">
        <br>
        <%--@declare id="max_init_value"--%><label for="max_init_value">Max. Valor Inicial: </label>
        <input type="number" name="max_init_value">
        <br>
        <%--@declare id="finish-date"--%><label for="finish-date">Max. fecha de fin: </label>
        <input type="date" name="finish-date">
        <input type="submit" value="Filtrar">
    </form>
    <h2>Subastas Publicadas</h2>
    <table class="table">
        <tr>
            <th class="cell-content">ARTICULO</th>
            <th class="cell-content">CATEGORIAS</th>
            <th class="cell-content">VALOR INICIAL</th>
            <th class="cell-content">PUJA</th>
            <th class="cell-content">FECHA DE CIERRE</th>
            <th class="cell-content">COMPRADOR</th>
            <th></th>
        </tr>
        <%
            SimpleDateFormat fecha = new SimpleDateFormat("dd/MM/yyyy");
            List<Subasta> subastas = (List<Subasta>) request.getAttribute("subastas");
            for(Subasta subasta : subastas) {
        %>
        <tr>
            <td class="cell-content">
                <a href="/product/<%= subasta.getArticulo().getIdArticulo() %>"><%=subasta.getArticulo().getTitulo()%></a>
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
            </td>
            <td class="cell-content">
                <%
                    Double puja = subasta.getPuja();
                    if (puja != null){
                %>
                <%=puja%>
                <%
                } else{
                %>
                Sin pujas aún
                <%
                    }
                %>
            </td>
            <td class="cell-content">
                <%=fecha.format(subasta.getFechaLimite())%>
            </td>
            <td class="cell-content">
                <%
                    String comprador;
                    Usuario ganador = subasta.getArticulo().getGanador();
                    if (ganador!=null){
                        comprador = ganador.getNombre()+" "+ganador.getApellidos();
                    }else{
                        comprador="";
                    }
                %>
                <%=comprador%>
            </td>
            <td>
                <%
                    if (ganador==null && subasta.getFechaLimite().before(Date.from(Instant.now()))){
                %>
                <form method="get" action="/product/asignar">
                    <input type="hidden" name="articuloId" value="<%=subasta.getArticulo().getIdArticulo()%>">
                    <input type="submit" value="Confirmar Ganador">
                </form>
                <%
                    }
                %>
            </td>
        </tr>
        <%
            }
        %>
    </table>
    </body>
</main>
</html>
