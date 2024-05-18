<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <title>Lista de usuarios</title>
    <jsp:include page="/WEB-INF/views/administrador/cabecera.jsp"/>
</head>

<body>

    <jsp:include page="/WEB-INF/views/administrador/menu.jsp"/>

    <div class="container">

        <div class="row">
            <h3>Lista de usuarios</h3>
        </div>

        <div class="row">

            <div class="col-md-10">

                <a class="btn btn-primary btn-md" href="<s:url value="/administrador/usuario/create"/>"> Nuevo usuario</a>

                <br><br>

                <table class="table table-striped table-bordered table-hover" id="tabla">

                    <thead>
                        <tr>
                            <th>Codigo del usuario</th>
                            <th>Rol del usuario</th>
                            <th>Nombre</th>
                            <th>Email</th>
                            <th>Contraseña</th>
                            <th>Operaciones</th>
                        </tr>
                    </thead>

                    <tbody>

                    <c:forEach items="${listaUsuarios}" var="usuario">

                        <tr>
                            <td>${usuario.idUsuario}</td>
                            <td>${usuario.rolByIdRol.nombreRol}</td>
                            <td>${usuario.nombreUsuario}</td>
                            <td>${usuario.email}</td>
                            <td>${usuario.contraseña}</td>
                            <td>

                                <a class="btn btn-primary" href="<s:url value="/administrador/usuario/edit/${usuario.idUsuario}"/> ">
                                    <span class="glyphicon glyphiconedit"></span>Editar</a>

                                <br><br>

                                <a class="btn btn-danger" href="javascript:eliminar('${usuario.idUsuario}')">
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
            alertify.confirm("Realmente desea eliminar este usuario?", function
                (e){
                if(e){
                    location.href="delete/"+id;
                }
            });
        }
    </script>
</body>
</html>

