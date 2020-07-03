<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="Factory.ConexionDB"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:useBean id="producto" scope="session" class="Model.Producto" />
<%
    String id = "";
    String nombre = "";
    String stock = "";
    String precio = "";
    String unidadMedia = "";
    String estado = "";
    String categoria = "";
    String descripcion = "";
    
    if(request.getParameter("RadioV") != null){
        id = request.getParameter("id_prod");
        nombre = request.getParameter("nombre_prod");
        stock = request.getParameter("stock_prod");
        precio = request.getParameter("precio_prod");
        unidadMedia = request.getParameter("unidad_med");
        estado = request.getParameter("estado_prod");
        categoria = request.getParameter("categoria_prod");
        descripcion = request.getParameter("desc_prod");
    } else {
        id = String.valueOf(producto.getId_producto());
        nombre = producto.getNom_producto();
        stock = String.valueOf(producto.getStock());
        precio = String.valueOf(producto.getPrecio());
        unidadMedia = producto.getUnidadMedida();
        estado = String.valueOf(producto.getEstado());
        categoria = producto.getCategoria_id();
        descripcion = producto.getDes_producto();
    }
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link href="bootstrap337/css/font-awesome.min.css" rel="stylesheet" type="text/css"/>
        <link href="../bootstrap337/css/estilo-base.css" rel="stylesheet" type="text/css"/> 
        <%@include file="../WEB-INF/Vistas-Parciales/css-js.jspf" %>
         
        <script type="text/javascript">
            //Función para el botón regresar.
            function regresar(url){
                location.href = url;
            }
        </script>
    </head>
    <body>
        <%@include file="../WEB-INF/Vistas-Parciales/encabezado.jspf" %>
      
        <div class="container">
            <center>    <h1>Registros de Productos</h1></center>
        <form id="cuadroeditar" class="form-horizontal shadow-lg p-3 mb-5 bg-white rounded" id="frmProducto" name="frmProducto" action="<%= request.getContextPath() %>/productos" method="post">
            <input type="hidden" name="id_producto" value="<%= id %>" >
            
            <div class="form-group">
                <label for="txtNombre" class="col-sm-2 control-label">Nombre:</label>
                <div class="col-sm-6">
                    <input id="barra" type="text" class="form-control" name="txtNombre" value="<%= nombre %>">
                </div>
            </div>
            
            <div class="form-group">
                <label for="txtStock" class="col-sm-2 control-label">Stock:</label>
                <div class="col-sm-6">
                    <input id="barra" type="text" class="form-control" name="txtStock" value="<%= stock %>">
                </div>
            </div>
                
            <div class="form-group">
                <label for="txtPrecio" class="col-sm-2 control-label">Precio:</label>
                <div class="col-sm-6">
                    <input id="barra" type="text" class="form-control" name="txtPrecio" value="<%= precio %>">
                </div>
            </div>
                
            <div class="form-group">
                <label for="txtUnidaMedida" class="col-sm-2 control-label">Unidad de Medida:</label>
                <div class="col-sm-6">
                    <input id="barra" type="text" class="form-control" name="txtUnidaMedida" value="<%= unidadMedia %>">
                </div>
            </div>
                
            <div class="form-group">
                <label for="txtEstado" class="col-sm-2 control-label">Estado:</label>
                <div class="col-sm-6">
                    <input id="barra" type="text" class="form-control" name="txtEstado" value="<%= estado %>">
                </div>
            </div>
                
            <div class="form-group">
                <label for="txtCategoria" class="col-sm-2 control-label">Categoria</label>
                <div class="col-sm-6">
                    <!--input id="barra" type="text" class="form-control" name="txtCategoria" value="<%= categoria %>"-->
               
                    <select class="form-control" name="txtCategoria" >
                        <%
                            try{
                                String miQuery = "SELECT * FROM tb_categoria";
                                Class.forName("com.mysql.jdbc.Driver").newInstance();
                                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bd_inventario","root", "");
                                Statement stm = conn.createStatement();
                                ResultSet rs = stm.executeQuery(miQuery);
                                while(rs.next())
                                {  
                                    %>
                                       <option value="<%=rs.getString("id_categoria")%>"><%=rs.getString("nom_categoria")%></option>
                                    <%
                                }
                                conn.close();
                            } catch(Exception ex){
                                ex.printStackTrace();
                            }
                        %>
                    </select>
                </div>
            </div>
                        
                
            <div class="form-group">
                <label for="txtDescripcion" class="col-sm-2 control-label">Descripcion</label>
                <div class="col-sm-6">
                    <input id="barra" type="text" class="form-control" name="txtDescripcion" value="<%= descripcion %>">
                </div>
            </div>
            
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <%
                        if(request.getParameter("RadioV") != null){
                    %>
                    <input type="submit" class="btn btn-success btn-sm"  name="btnModificar" value="Actualizar" />
                    <%
                        } else{ 
                    %>
                    <input type="submit" class="btn btn-success btn-sm" name="btnGuardar" value="Guardar" >
                    <%
                        }
                    %>
                    <input type="button" class="btn btn-danger btn-sm" onclick="regresar('<%= request.getContextPath() %>/productos?opcion=listar')" name="btnRegresar" value="Regresar">
               
                
                </div>
            </div>
            
        </form>
        </div>
  
        <%@include file="../WEB-INF/Vistas-Parciales/pie.jspf" %>
    </body>
</html>
