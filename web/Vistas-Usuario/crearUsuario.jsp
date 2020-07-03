
<jsp:useBean id="usuario" scope="session" class="Model.Usuario" />
<%
    String id = "";
    String nombre = "";
    String apellido = "";
    String correo = "";
    String usu = "";
    String clave = "";
    String tipo = "";
    String estado = "";
    String pregunta = "";
    String respuesta = "";
    
    if(request.getParameter("sirens")!=null){
        id = request.getParameter("id_u");
        nombre = request.getParameter("nombre_u");
        apellido = request.getParameter("apellido_u");
        correo = request.getParameter("correo_u");
        usu = request.getParameter("usuario_u");
        clave = request.getParameter("clave_u");
        tipo = request.getParameter("tipo_u");
        estado = request.getParameter("estado_u");
        pregunta = request.getParameter("pregunta_u");
        respuesta = request.getParameter("respuesta_u");
    } else {
        id = String.valueOf(usuario.getId());
        nombre = usuario.getNombre();
        apellido = usuario.getApellido();
        correo = usuario.getCorreo();
        usu = usuario.getUsuario();
        clave = usuario.getClave();
        tipo = String.valueOf(usuario.getTipo());
        estado = String.valueOf(usuario.getEstado());
        pregunta = usuario.getPregunta();
        respuesta = usuario.getRepuesta();
    }
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
       <title>Registra Usuario</title>
        <%@include file="../WEB-INF/Vistas-Parciales/css-js.jspf" %>
        <script type="text/javascript">
            //Función para el botón regresar.
            function regresar(url){
                location.href = url;
            }
        </script>
    <body>
        <%@include file="../WEB-INF/Vistas-Parciales/encabezado.jspf" %>
        
        <div class="container">
            
        <h3>Registros de Usuarios</h3>
        <form id="cuadroeditar20" class="form-horizontal" id="frmUsuario" name="frmUsuario" action="<%= request.getContextPath() %>/usuario" method="post">
            <input type="hidden" name="id_usuario" value="<%= id %>" >
            
            <div class="form-group">
                <label for="txtNombre" class="col-sm-2 control-label">Nombre:</label>
                <div class="col-sm-6">
                    <input id="barra" type="text" class="form-control" name="txtNombre" value="<%= nombre %>">
                </div>
            </div>
            
            <div class="form-group">
                <label for="txtApellido" class="col-sm-2 control-label">Apellido:</label>
                <div class="col-sm-6">
                    <input id="barra" type="text" class="form-control" name="txtApellido" value="<%= apellido %>">
                </div>
            </div>
                
            <div class="form-group">
                <label for="txtCorreo" class="col-sm-2 control-label">Correo:</label>
                <div class="col-sm-6">
                    <input id="barra" type="text" class="form-control" name="txtCorreo" value="<%= correo %>">
                </div>
            </div>
                
            <div class="form-group">
                <label for="txtUsuario" class="col-sm-2 control-label">Usuario:</label>
                <div class="col-sm-6">
                    <input id="barra" type="text" class="form-control" name="txtUsuario" value="<%= usu %>">
                </div>
            </div>
                
            <div class="form-group">
                <label for="txtClave" class="col-sm-2 control-label">Clave:</label>
                <div class="col-sm-6">
                    <input id="barra" type="password" class="form-control" name="txtClave" value="<%= clave %>">
                </div>
            </div>
                
            <div class="form-group">
                <label for="txtTipo" class="col-sm-2 control-label">Tipo:</label>
                <div class="col-sm-6">
                    <input id="barra" type="text" class="form-control" name="txtTipo" value="<%= tipo %>">
                </div>
            </div>
                
            <div class="form-group">
                <label for="txtEstado" class="col-sm-2 control-label">Estado:</label>
                <div class="col-sm-6">
                    <input id="barra" type="text" class="form-control" name="txtEstado" value="<%= estado %>">
                </div>
            </div>
                
            <div class="form-group">
                <label for="txtPregunta" class="col-sm-2 control-label">Pregunta:</label>
                <div class="col-sm-6">
                    <input id="barra" type="text" class="form-control" name="txtPregunta" value="<%= pregunta %>">
                </div>
            </div>
                
            <div class="form-group">
                <label for="txtRespuesta" class="col-sm-2 control-label">Respuesta:</label>
                <div class="col-sm-6">
                    <input id="barra" type="text" class="form-control" name="txtRespuesta" value="<%= respuesta %>">
                </div>
            </div>
            
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <%
                        if(request.getParameter("sirens") != null){
                    %>
                    <input type="submit" class="btn btn-success" name="btnModificar" value="Actualizar" />
                    <%
                        } else{ 
                    %>
                    <input type="submit" class="btn btn-success btn-sm" name="btnGuardar" value="Guardar" >
                    <%
                        }
                    %>
                    <input type="button" class="btn btn-danger" onclick="regresar('<%= request.getContextPath()%>/usuario?opcion=listar')"
                                  name="btnRegresar" value="Regresar" />
                </div>
                </div>
        </form>
        </div>
    </body>
</html>
