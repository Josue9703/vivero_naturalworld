<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <title>Lista de productos</title>
    <jsp:include page="/WEB-INF/views/administrador/cabecera.jsp"/>
</head>

<body>

    <jsp:include page="/WEB-INF/views/administrador/menu.jsp"/>

    <div class="container">

        <div class="row">
            <h3>Lista de productos</h3>
        </div>

        <div class="row">

            <div class="col-md-10">

                <a class="btn btn-primary btn-md" href="<s:url value="/administrador/producto/create"/>"> Nuevo producto</a>

                <br><br>

                <table class="table table-striped table-bordered table-hover" id="tabla">

                    <thead>
                        <tr>
                            <th>Codigo del producto</th>
                            <th>Categoria</th>
                            <th>ruta de la foto</th>
                            <th>Nombre del producto</th>
                            <th>Descripcion</th>
                            <th>Precio</th>
                            <th>Existencias</th>
                            <th>Operaciones</th>
                        </tr>
                    </thead>

                    <tbody>

                    <c:forEach items="${listaProductos}" var="producto">

                        <tr>
                            <td>${producto.idProducto}</td>
                            <td>${producto.categoriasByIdCategoria.nombreCategoria}</td>
                            <td>${producto.foto}</td>
                            <td>${producto.nombreProducto}</td>
                            <td>${producto.descripcion}</td>
                            <td>${producto.precio}</td>
                            <td>${producto.existencias}</td>
                            <td>

                                <a class="btn btn-primary" href="<s:url value="/administrador/producto/edit/${producto.idProducto}"/> ">
                                    <span class="glyphicon glyphiconedit"></span>Editar</a>

                                <br><br>

                                <a class="btn btn-danger" href="javascript:eliminar('${producto.idProducto}')">
                                    <span class="glyphicon glyphicontrash"></span>Eliminar</a>

                            </td>
                        </tr>

                    </c:forEach>

                    </tbody>

                </table>

            </div>

        </div>

    </div>
    <jsp:include page="/WEB-INF/views/administrador/pie.jsp"/>
    <script>
        $(document).ready(function(){
            $('#tabla').dataTable( {
                "language": {
                    "url": "cdn.datatables.net/plug-ins/1.10.15/i18n/Spanish.json"
                }
            });
        });
        function eliminar(id){
            alertify.confirm("Realmente desea eliminar este producto?", function
                (e){
                if(e){
                    location.href="delete/"+id;
                }
            });
        }
    </script>
</body>
</html>

