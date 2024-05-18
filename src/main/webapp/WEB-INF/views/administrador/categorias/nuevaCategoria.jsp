<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>

<head>
    <title>Nueva categoria</title>
    <jsp:include page="/WEB-INF/views/administrador/cabecera.jsp"/>
</head>

<body>

    <jsp:include page="/WEB-INF/views/administrador/menu.jsp"/>

    <div class="container">

        <div class="row">
            <h3>Nueva categoria</h3>
        </div>

        <div class="row">

            <div class=" col-md-7">

                <f:form action="create" method="POST" modelAttribute="categoria">

                    <div class="well well-sm"><strong><span class="glyphicon glyphicon-asterisk"></span>Campos requeridos</strong></div>

                    <div class="form-group">
                        <label for="idCategoria">Codigo de la categoria:</label>
                        <div class="input-group">
                            <f:input path="idCategoria" cssClass="form-control"/>
                            <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="nombreCategoria">Nombre de la categoria:</label>
                        <div class="input-group">
                            <f:input path="nombreCategoria" cssClass="form-control"/>
                            <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="descripcion">Descripcion:</label>
                        <div class="input-group">
                            <f:input path="descripcion" cssClass="form-control"/>
                            <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
                        </div>
                    </div>

                    <f:button class="btn btn-info">Guardar</f:button>

                    <a class="btn btn-danger" href="<s:url value="/administrador/categoria/list"/>">Cancelar</a>

                </f:form>

            </div>

        </div>

    </div>

    <jsp:include page="/WEB-INF/views/administrador/pie.jsp"/>

</body>
</html>