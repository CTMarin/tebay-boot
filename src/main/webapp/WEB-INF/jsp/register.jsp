<%@ page import="es.uma.tebayboot.dto.form.KeyValueDTO" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Carlos Marín Corbera
  Date: 14/04/2022
  Time: 8:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Tebay</title>
</head>
<style>
    .form {
        margin:  auto;
        width:  50%;
        max-width: 50vh;
        min-width: 45vh;
    }
    .form-input {
        width: 100%;
        resize: none;
    }
    .col-25 {
        float: left;
        width: 25%;
    }
    .col-75 {
        float: left;
        width: 75%;
    }
    .margin {
        margin-top: 1vh;
    }
    .form-list {
        list-style-type: none;
    }
    .error {
        color: red;
    }
    .input-box {
        display: flex;
        align-items: center;
        justify-content: center;
    }
</style>
<%
    String strError = (String) request.getAttribute("error");
    List<KeyValueDTO<String>> sexos = (List<KeyValueDTO<String>>) request.getAttribute("sexos");
    if(strError == null) strError = "";
%>
<body>
    <form:form action="register" method="post" modelAttribute="user" cssClass="form">
        <h1>
            Regístrate en Tebay
        </h1>
        <hr>
        <span class="error"><%= strError %></span>
        <ul class="form-list">
            <li class="input-box">
                <div class="col-25 margin">
                        <%--@declare id="email"--%><label for="email">Email </label>
                </div>
                <div class="col-75 margin">
                    <form:input required="true" class="form-input" type="email" path="email"/>
                </div>
            </li>
            <li class="input-box">
                <div class="col-25 margin">
                        <%--@declare id="passwd"--%><label for="passwd">Contraseña </label>
                </div>
                <div class="col-75 margin">
                    <form:password required="true" minlength="4" class="form-input" path="password"/>
                </div>
            </li>
            <li class="input-box">
                <div class="col-25 margin">
                        <%--@declare id="rep-passwd"--%><label for="rep-passwd">Repetir Contraseña </label>
                </div>
                <div class="col-75 margin">
                    <form:password required="true" minlength="4" class="form-input" path="rep_password"/>
                </div>
            </li>
            <li>
                <h2>Datos Personales</h2>
                <hr>
            </li>
            <li class="input-box">
                <div class="col-25 margin">
                        <%--@declare id="name"--%><label for="name">Nombre </label>
                </div>
                <div class="col-75 margin">
                    <form:input required="true" class="form-input" path="nombre"/>
                </div>
            </li>
            <li class="input-box">
                <div class="col-25 margin">
                        <%--@declare id="second-name"--%><label for="second-name">Apellidos </label>
                </div>
                <div class="col-75 margin">
                    <form:input required="true" class="form-input" path="apellidos"/>
                </div>
            </li>
            <li class="input-box">
                <div class="col-25 margin">
                        <%--@declare id="age"--%><label for="age">Edad </label>
                </div>
                <div class="col-75 margin">
                    <form:input required="true" min="0" step="1" class="form-input" type="number" path="edad"/>
                </div>
            </li>
            <li class="input-box">
                <div class="col-25 margin">
                        <%--@declare id="gender"--%><label for="gender">Sexo </label>
                </div>
                <div class="col-75 margin">
                    <form:select required="true" path="sexo">
                        <form:options items="<%=sexos%>" itemValue="value" itemLabel="label"/>
                    </form:select>
                </div>
            </li>
            <li>
                <h2>Domicilio</h2>
                <hr>
            </li>
            <li class="input-box">
                <div class="col-25 margin">
                        <%--@declare id="country"--%><label for="country">Pais </label>
                </div>
                <div class="col-75 margin">
                    <form:input required="true" class="form-input" path="pais"/>
                </div>
            </li>
            <li class="input-box">
                <div class="col-25 margin">
                        <%--@declare id="city"--%><label for="city">Ciudad </label>
                </div>
                <div class="col-75 margin">
                    <form:input required="true" class="form-input" path="ciudad"/>
                </div>
            </li>
            <li class="input-box">
                <div class="col-25 margin">
                        <%--@declare id="cp"--%><label for="cp">Código Postal </label>
                </div>
                <div class="col-75 margin">
                    <form:input required="true" min="0" step="1" class="form-input" type="number" path="codigo_postal"/>
                </div>
            </li>
            <li class="input-box">
                <div class="col-25 margin">
                        <%--@declare id="street"--%><label for="street">Calle </label>
                </div>
                <div class="col-75 margin">
                    <form:input required="true" class="form-input" path="calle"/>
                </div>
            </li>
            <li class="input-box">
                <div class="col-25 margin">
                        <%--@declare id="number"--%><label for="number">Número </label>
                </div>
                <div class="col-75 margin">
                    <form:input required="true" min="0" step="1" class="form-input" type="number" path="numero"/>
                </div>
            </li>
            <li class="input-box">
                <div class="col-25 margin">
                        <%--@declare id="block"--%><label for="block">Bloque </label>
                </div>
                <div class="col-75 margin">
                    <form:input class="form-input" type="text" path="bloque"/>
                </div>
            </li>
            <li class="input-box">
                <div class="col-25 margin">
                        <%--@declare id="floor"--%><label for="floor">Piso </label>
                </div>
                <div class="col-75 margin">
                    <form:input class="form-input" path="piso"/>
                </div>
            </li>
            <li class="input-box">
                <div class="col-25 margin">
                        <%--@declare id="door"--%><label for="door">Puerta </label>
                </div>
                <div class="col-75 margin">
                    <form:input class="form-input" path="puerta"/>
                </div>
            </li>
            <li>
                <input class="margin" type="submit" value="Enviar">
            </li>
        </ul>
        <p>¿Ya tienes una cuenta? <a href="/login">Inicia sesión aquí.</a></p>
    </form:form>
</body>
</html>

