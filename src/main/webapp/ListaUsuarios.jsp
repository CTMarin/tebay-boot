<%@ page import="es.uma.tebayboot.entity.Usuario" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: tapia
  Date: 30/05/2022
  Time: 9:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Listado de usuarios</title>
</head>
<body>
    <h1>Listado de usuarios</h1>
    <form method="post" action="listaUsuarios">
        Nombre: <input type="text" name="filtroNombre" value=""/>
        <input type="submit" value="Filtrar">
    </form>

    <%
        List<Usuario> usuarios = (List<Usuario>)request.getAttribute("usuarios");
        if(usuarios == null || usuarios.isEmpty())
        {
    %>
    <h2>No se encuentran usuarios</h2>
    <%
        }
        else
        {
    %>

    <table>
        <tr>
            <th>ID USUARIO</th>
            <th>EMAIL</th>
            <th>NOMBRE</th>
            <th>APELLIDOS</th>
            <th>EDAD</th>
            <th>SEXO</th>
            <th>PERMISO</th>
            <th>DOMICILIO</th>
        </tr>
        <%
            {
                for(Usuario usuario: usuarios) {


        %>
        <tr>
            <td><%= usuario.getIdUsuario()%></td>
            <td><%= usuario.getEmail()%></td>
            <td><%= usuario.getNombre()%></td>
            <td><%= usuario.getApellidos()%></td>
            <td><%= usuario.getEdad()%></td>
            <td><%= usuario.getSexo()%></td>
            <td><%= usuario.getPermiso()%></td>
            <td><%= usuario.getDomicilio().toString()%></td>
            <%--
            <td><a href="AdminBorrarServlet?id=<%= usuario.getIdUsuario()%>">Borrar</a></td>
            <td><a href="AdminCrearEditarServlet?id=<%= usuario.getIdUsuario()%>">Editar</a></td>
            --%>

        </tr>
        <%
            }
        %>
        <%
                }
            }
        %>
    </table>
    <%--
    <a href="AdminCrearEditarServlet">Crear nuevo usuario</a> <br/>

    <br/> <a href="ListaProductosServlet">Listado de productos</a>
    --%>
</body>
</html>
