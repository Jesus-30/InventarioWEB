
<%@page import="Model.Usuario" %>
<jsp:useBean id="lista" scope="session" class="java.util.List"/>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
       <title>Usuarios Registrados</title>
        <%@include file="../WEB-INF/Vistas-Parciales/css-js.jspf" %>
    </head>
    <body>
        <%@include file="../WEB-INF/Vistas-Parciales/encabezado.jspf"%>
        
        
            <h3>Listado de Usuarios Registrados</h3>
            <div id="cuadrolistar0" class="shadow-lg p-3 mb-5 bg-white rounded">
                <table class="table table-striped">
               
                    <tr>
                        
                  <th>ID</th><th>Nombre</th><th>APELLIDO</th><th><center>CORREO</center></th><th>USUARIO</th><th>CLAVE</th><th>TIPO</th>
                  <th>ESTADO</th><th><center>PREGUNTA</center></th><th>RESPUESTA</th><th>FECHA</th><th>ACCIÓN</th>
                 
               </tr> 
              
                <%
                    for(int i = 0; i < lista.size(); i++){
                        Usuario usuario = new Usuario();
                        usuario = (Usuario)lista.get(i);
                    
                %>
                <tr>
                    <td><%= usuario.getId() %></td>
                    <td><%= usuario.getNombre() %></td>
                    <td><%= usuario.getApellido() %></td>
                    <td><%= usuario.getCorreo() %></td>
                    <td><center><%= usuario.getUsuario() %></center></td>
                    <td><center><%= usuario.getClave() %></center></td>
                    <td><center><%= usuario.getTipo() %></center></td>
                    <td><center><%= usuario.getEstado() %></center></td>
                    <td><%= usuario.getPregunta() %></td>
                    <td><center><%= usuario.getRepuesta() %></center></td>
                    <td><center><%= usuario.getFecha_registro() %></center></td>
                    <td>                        
                        <a href="<%= request.getContextPath() %>/usuario?opcion=modificar&&id_u=<%= usuario.getId() %>&&nombre_u=<%= usuario.getNombre() %>&&apellido_u=<%= usuario.getApellido() %>&&correo_u=<%= usuario.getCorreo() %>&&usuario_u=<%= usuario.getUsuario() %>&&clave_u=<%= usuario.getClave() %>&&tipo_u=<%= usuario.getTipo() %>&&estado_u=<%= usuario.getEstado() %>&&pregunta_u=<%= usuario.getPregunta() %>&&respuesta_u=<%= usuario.getRepuesta() %>" class="btn btn-info btn-sm glyphicon glyphicon-edit" role="button" name="btnModificar">Editar</a>
                        
                        <a href="<%= request.getContextPath() %>/usuario?opcion=eliminar&&id=<%= usuario.getId() %>" class="btn btn-danger btn-sm glyphicon glyphicon-remove" role="button">Eliminar</a>
                    </td>
                </tr>
                <%
                    }
                %>
            </table>
     <a id="crear" href="<%= request.getContextPath() %>/usuario?opcion=crear" class="btn btn-success" role="button"> Nuevo Usuario</a>            
  <a id="pdf" href="crearPDF" class="btn btn-warning">Imprimir PDF</a>
        </div>
    
        <%@include file="../WEB-INF/Vistas-Parciales/pie.jspf"%>
    </body>
</html>
