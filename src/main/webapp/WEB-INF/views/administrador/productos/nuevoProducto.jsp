<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <title>Nuevo Producto</title>
    <jsp:include page="/WEB-INF/views/administrador/cabecera.jsp"/>
</head>

<body>

    <jsp:include page="/WEB-INF/views/administrador/menu.jsp"/>

    <div class="container">

        <div class="row">
            <h3>Nuevo producto</h3>
        </div>

        <div class="row">

            <div class=" col-md-7">

                <f:form action="create" method="POST" modelAttribute="producto">

                    <div class="well well-sm"><strong><span class="glyphicon glyphicon-asterisk"></span>Campos requeridos</strong></div>

                    <div class="form-group">
                        <label for="idProducto">Codigo del producto:</label>
                        <div class="input-group">
                            <f:input path="idProducto" cssClass="form-control"/>
                            <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="categoriasByIdCategoria.idCategoria">Categoria:</label>
                        <div class="input-group">
                            <f:select path="categoriasByIdCategoria.idCategoria" cssClass="form-control">
                                <c:forEach items="${categorias}" var="categorias">
                                    <f:option value="${categorias.idCategoria}">${categorias.nombreCategoria}</f:option>
                                </c:forEach>
                            </f:select>
                            <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
                        </div>
                    </div>


                    <div class="form-group">
                        <label for="foto">Ruta de la foto:</label>
                        <div class="input-group">
                            <f:input path="foto" cssClass="form-control"/>
                            <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="nombreProducto">Nombre del Producto:</label>
                        <div class="input-group">
                            <f:input path="nombreProducto" cssClass="form-control"/>
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

                    <div class="form-group">
                        <label for="precio">Precio:</label>
                        <div class="input-group">
                            <f:input path="precio" cssClass="form-control"/>
                            <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="existencias">Existencias:</label>
                        <div class="input-group">
                            <f:input path="existencias" cssClass="form-control"/>
                            <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
                        </div>
                    </div>

                    <f:button class="btn btn-info">Guardar</f:button>

                    <a class="btn btn-danger" href="<s:url value="/administrador/producto/list"/>">Cancelar</a>

                </f:form>

            </div>

        </div>

    </div>
    <jsp:include page="/WEB-INF/views/administrador/pie.jsp"/>
    <br><br>
</body>
</html>

