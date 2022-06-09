<%@ page import="es.uma.tebayboot.dto.Articulo" %>
<%@ page import="java.util.List" %>
<%@ page import="es.uma.tebayboot.dto.Categoria" %><%--
  Created by IntelliJ IDEA.
  User: carme
  Date: 09/06/2022
  Time: 11:46
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
  <h2>Subastas Ganadas</h2>
  <table class="table">
    <tr>
      <th class="cell-content">ARTICULO</th>
      <th class="cell-content">CATEGORIAS</th>
      <th class="cell-content">DESCRIPCION</th>
    </tr>
    <%
      List<Articulo> articulos = (List<Articulo>) request.getAttribute("articulos");
      for(Articulo articulo : articulos) {
    %>
    <tr>
      <td class="cell-content">
        <a href="/product/<%=articulo.getIdArticulo()%>"><%=articulo.getTitulo()%></a>
      </td>
      <td class="cell-content">
        <%
          for(Categoria categoria : articulo.getCategoriaList()) {
        %>
        <span><%=categoria.getTitulo()%></span>
        <%
          }
        %>
      </td>
      <td class="cell-content">
        <%=articulo.getDescripcion()%>
      </td>
    </tr>
    <%
      }
    %>
  </table>
</main>
</body>
</html>
