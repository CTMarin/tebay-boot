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
<jsp:include page="register.jsp"/>
<h1>Datos del usuario</h1>

<form:form action="/admin/save" method="post" modelAttribute="usuario">
   <%-- <form:hidden path="idUsuario"/>--%>
    Email: <form:input path="email" size="30" /> <br/>
    Contraseña: <form:input path="password" size="30" /> <br/>
    Nombre: <form:input path="nombre" size="30" /> <br/>
    Apellidos: <form:input path="apellidos" size="30" /> <br/>
    Edad: <form:input path="edad" size="30" /> <br/>
    Sexo: <br/>
    Permiso: <br/>

   <%-- <h2>Domicilio</h2>
    Pais: <form:input path="domicilio"/> <br/>
    --%>

 <form:button>Enviar</form:button>
</form:form>
</body>
</html>
