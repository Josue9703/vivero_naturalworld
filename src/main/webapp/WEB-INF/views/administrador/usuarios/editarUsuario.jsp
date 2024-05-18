<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <title>Editar usuario</title>
    <jsp:include page="/WEB-INF/views/administrador/cabecera.jsp"/>
</head>

<body>

    <jsp:include page="/WEB-INF/views/administrador/menu.jsp"/>

    <div class="container">

        <div class="row">
            <h3>Editar usuario</h3>
        </div>

        <div class="row">

            <div class=" col-md-7">

                <f:form action="${action}" method="POST" modelAttribute="usuario">

                <div class="well well-sm"><strong><span class="glyphicon glyphicon-asterisk"></span>Campos requeridos</strong></div>

                <div class="form-group">
                    <label for="idUsuario">Codigo del usuario:</label>
                    <div class="input-group">
                        <f:input path="idUsuario" cssClass="form-control" readonly="true"/>
                        <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
                    </div>
                </div>

                <div class="form-group">
                    <label for="rolByIdRol.idRol">Rol del usuario:</label>
                    <div class="input-group">
                        <f:select path="rolByIdRol.idRol" cssClass="form-control">
                            <c:forEach items="${roles}" var="roles">
                                <f:option value="${roles.idRol}">${roles.nombreRol}</f:option>
                            </c:forEach>
                        </f:select>
                        <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
                    </div>
                </div>

                <div class="form-group">
                    <label for="nombreUsuario">Nombre:</label>
                    <div class="input-group">
                        <f:input path="nombreUsuario" cssClass="form-control"/>
                        <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
                    </div>
                </div>

                <div class="form-group">
                    <label for="email">Email:</label>
                    <div class="input-group">
                            <f:input path="email" cssClass="form-control"/>
                        <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
                    </div>
                </div>

                <div class="form-group">
                    <label for="contraseña">Contraseña:</label>
                    <div class="input-group">
                        <f:input path="contraseña" cssClass="form-control"/>
                        <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
                    </div>
                </div>

                    <f:button class="btn btn-info">Guardar</f:button>

                    <a class="btn btn-danger" href="<s:url value="/administrador/usuario/list"/>">Cancelar</a>

                </f:form>

            </div>

        </div>

    </div>

    <jsp:include page="/WEB-INF/views/administrador/pie.jsp"/>

</body>
</html>
