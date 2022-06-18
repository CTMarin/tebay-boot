<%@ page import="es.uma.tebayboot.dto.form.KeyValueDTO" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: tapia
  Date: 17/06/2022
  Time: 23:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Usuario</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<h1>Datos del usuario</h1>
<%
    List<KeyValueDTO<String>> sexos = (List<KeyValueDTO<String>>) request.getAttribute("sexos");
%>
<form:form action="/admin/guardar" method="post" modelAttribute="usuarioEditar">

    Email: <form:input path="email" size="30" /> <br/>
    Contraseña: <form:input path="password" size="30" /> <br/>
    Nombre: <form:input path="nombre" size="30" /> <br/>
    Apellidos: <form:input path="apellidos" size="30" /> <br/>
    Edad: <form:input path="edad" size="30" /> <br/>
    Sexo:
    <form:select required="true" path="sexo">
    <form:options items="<%=sexos%>" itemValue="value" itemLabel="label"/>
    </form:select> <br/>
    Permiso: <br/>

   <h2>Domicilio</h2>
    Pais: <form:input path="pais"/> <br/>
    Ciudad: <form:input path="ciudad"/> <br/>
    Código postal: <form:input path="codigoPostal"/> <br/>
    Calle: <form:input path="calle"/> <br/>
    Número: <form:input path="numero"/> <br/>
    Bloque: <form:input path="bloque"/> <br/>
    Piso: <form:input path="piso"/> <br/>
    Puerta: <form:input path="puerta"/> <br/>


 <form:button>Enviar</form:button>
</form:form>
</body>
</html>
