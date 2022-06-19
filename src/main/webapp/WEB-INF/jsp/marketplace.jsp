<%@ page import="java.time.Instant" %>
<%@ page import="java.util.Date" %>
<%@ page import="es.uma.tebayboot.dto.Subasta" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%--
  Created by IntelliJ IDEA.
  User: carme
  Date: 30/05/2022
  Time: 8:58
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

    .input-text{
        width: 10vh;
    }

    .table{
        table-layout: fixed;
    }

    .col-25{
        width: 25vh;
    }
</style>
<body>
<jsp:include page="header.jsp" />
<main class="wrapper">
    <h1>MarketPlace</h1>

    <div class="form-button">
        <form action="/profile/">
            <input type="submit" value="Ir a mi perfil" />
        </form>
    </div>

    <h2>Subastas activas</h2>
    <table class="table">
        <tr>
            <th class="cell-content">ARTÍCULO</th>
            <th class="cell-content">VALOR INICIAL</th>
            <th class="cell-content">ÚLTIMA PUJA</th>
            <th class="cell-content">FECHA DE CIERRE</th>
            <th class="cell-content col-25">NUEVA PUJA</th>
            <th class="cell-content">FAV</th>
        </tr>
        <%
            List<Subasta> favoritos = (List<Subasta>) request.getAttribute("favoritos");
            List<Subasta> subastas = (List<Subasta>) request.getAttribute("subastas");
            for(Subasta subasta : subastas) {
                if(subasta.getFechaLimite().after(Date.from(Instant.now()))) {
        %>
        <tr>
            <td class="cell-content">
                <a href="/product/<%=subasta.getArticulo().getIdArticulo()%>"><%=subasta.getArticulo().getTitulo()%></a>
            </td>
            <td class="cell-content">
                <%=subasta.getValorInicial()%>
            </td>
            <td class="cell-content">
                <%=subasta.getPuja()%>
            </td>
            <td class="cell-content">
                <%=subasta.getFechaLimite().toString()%>
            </td>
            <td class="cell-content col-25">
                <form method="get" action="/product/pujar">
                    <input type="hidden" name="id" value="<%=subasta.getIdSubasta()%>">
                    <div class="input-text">
                        <input type="number" name="nueva-puja" value="">
                    </div>
                    <div>
                        <input type="submit" value="Pujar">
                    </div>
                </form>
            </td>
            <td class="cell-content">

                <form method="get" action="/product/fav">
                    <input type="hidden" name="id" value="<%=subasta.getIdSubasta()%>">
                    <%
                        String value;
                        if (favoritos.contains(subasta)){
                            value= "Unfav";
                    %>
                            <input type="hidden" name="fav" value=<%=true%>>
                    <%
                        } else {
                            value= "Fav";
                    %>
                            <input type="hidden" name="fav" value=<%=false%>>
                    <%
                        }
                    %>
                    <input type="submit" value=<%=value%>>
                </form>
            </td>
        </tr>
        <%
                }
            }
        %>
    </table>
</main>

</body>
</html>

