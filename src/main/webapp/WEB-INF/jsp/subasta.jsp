<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page import="java.util.List" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="es.uma.tebayboot.dto.Subasta" %>
<%--

--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="header.jsp"/>
<html>
<head>
  <title>Nueva subasta</title>
</head>
<%

  SimpleDateFormat fecha = new SimpleDateFormat("dd/MM/yyyy");
%>
<body>
<h1>Datos de la subasta</h1>
<form:form action="/admin/subasta/guardar" method="post" modelAttribute="subasta">
<form:hidden path="idSubasta"></form:hidden>
  Titulo: <form:input path="titulo" size="30"/> <br/>
  Descripción: <form:input path="descripcion" size="90"/> <br/>
  URL Foto: <form:input path="url_imagen" size="30"/> <br/>
  Valor inicial: <form:input path="valor_inicial" size="5"/> <br/>
  Fecha límite: <form:input path="fecha_limite"/> <br/>
  <form:button>Enviar</form:button>
</form:form>

</body>
</html>
