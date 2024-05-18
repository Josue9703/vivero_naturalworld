<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <title>Lista de roles</title>
    <jsp:include page="/WEB-INF/views/administrador/cabecera.jsp"/>
</head>

<body>

    <jsp:include page="/WEB-INF/views/administrador/menu.jsp"/>

    <div class="container">

        <div class="row">
            <h3>Lista de roles</h3>
        </div>

        <div class="row">

            <div class="col-md-10">

                <!--<br><br>-->

                <table class="table table-striped table-bordered table-hover" id="tabla">

                    <thead>
                    <tr>
                        <th>Codigo del rol</th>
                        <th>Nombre del rol</th>
                    </tr>
                    </thead>

                    <tbody>

                    <c:forEach items="${listaRoles}" var="rol">

                        <tr>
                            <td>${rol.idRol}</td>
                            <td>${rol.nombreRol}</td>
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
            alertify.confirm("Realmente desea eliminar este rol?", function
                (e){
                if(e){
                    location.href="delete/"+id;
                }
            });
        }
    </script>
</body>
</html>

