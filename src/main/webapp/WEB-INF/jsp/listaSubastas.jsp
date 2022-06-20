<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
/*
    Álvaro J. Tapia Muñoz: 100%
 */
--%>

<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="es.uma.tebayboot.dto.Subasta" %>
<%@ page import="es.uma.tebayboot.dto.Categoria" %>
<jsp:include page="header.jsp"/>
<html>
<head>
    <title>Listado de subastas</title>
</head>
<body>

<h1>Listado de subastas</h1> <a href="/admin/listaUsuarios">Volver</a> <br/>


<form method="post" action="/admin/filtrarSubastas">
    Nombre:<input type="text" name="filtro" value=""/>
    <input type="submit" value="Filtrar"/>
</form>

<%
    List<Subasta> subastas = (List<Subasta>)request.getAttribute("subastas");
    SimpleDateFormat fecha = new SimpleDateFormat("dd/MM/yyyy");

    if(subastas == null || subastas.isEmpty())
    {
%>
<h2>No se encuentran subastas</h2>
<%
}
else
{
    for(Subasta subasta: subastas)
    {
%>
<b>Título:</b> <%= subasta.getArticulo().getTitulo()%> <br/>
<b>Descripción:</b> <%= subasta.getArticulo().getDescripcion()%> <br/>
<b>Valor inicial:</b> <%= subasta.getValorInicial()%> <br/>
<b>Puja actual:</b> <%= subasta.getPuja()%> <br/>
<b>Fecha límite: </b> <%= fecha.format(subasta.getFechaLimite())%> <br/>
<b>Categorias: </b>
<%
    List<Categoria> categorias = subasta.getArticulo().getCategoriaList();
    for(Categoria categoria : categorias)
    {
%>
<%= categoria.getTitulo()%> <br/>
<%
    }
%>
<br/>
<b>Foto:</b> <br/> <img src="<%= subasta.getArticulo().getUrlArticulo()%>" width="500" height="300"> <br/>
<a href="/admin/subasta/<%= subasta.getIdSubasta()%>/borrar">Borrar</a>
<a href="/admin/subasta/<%= subasta.getIdSubasta()%>/edit">Editar</a> <br/>
<br/>
<br/>



<%
    }
%>
<%
    }
%>

</body>
</html>

