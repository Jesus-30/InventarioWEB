
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@page import="Model.Producto"%> 
<jsp:useBean id= "listas" scope="session" class="java.util.List"/>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
       <title>CONTROL DE INVENTARIO</title>
        <%@include file="../WEB-INF/Vistas-Parciales/css-js.jspf" %>
    </head>
    <body>
        <%@include file="../WEB-INF/Vistas-Parciales/encabezado.jspf" %>
            <h3>Listado de Productos</h3>
       <div id="cuadrolistar0" class="shadow-lg p-3 mb-5 bg-white rounded">
            <table class="table table-striped">
                <tr>
             
                    <th>ID</th>
                    <th>NOMBRE PRODUCTO</th>
                    <th>STOCK</th>
                    <th>PRECIO</th>
                    <th><center>UNIDAD MEDIDA</center></th>
                    <th>ESTADO PRODUCTO</th>
                    <th>CATEGORIAS</th>
                    <th><center>DESCRIPCION PRODUCTO</center></th>
                    <th>FECHA DE ENTRADA</th>
                    <th><center>ACCIONES</center></th>
              
                   
                </tr>
                 
                <%
                    for(int i = 0; i < listas.size(); i ++){
                        Producto producto = new Producto ();
                        producto = (Producto)listas.get(i);
                    
                %>
                <tr>
                    <td><%=producto.getId_producto() %></td>
                    <td><%=producto.getNom_producto() %></td>
                    <td><%= producto.getStock() %></td>
                    <td><%= producto.getPrecio() %></td>
                    <td><center><%= producto.getUnidadMedida() %></center></td>
                    <td><center><%= producto.getEstado() %></center></td>
            <td><center><%= producto.getCategoria_id() %></center></td>
            <td><center><%= producto.getDes_producto() %></center></td> 
            <td><%=producto.getFecha_entrada() %></td>
                    <td >
  <a  href="<%= request.getContextPath() %>/productos?opcion=modificar&&id_prod=<%= producto.getId_producto() %>&&nombre_prod=<%= producto.getNom_producto() %>&&stock_prod=<%= producto.getStock() %>&&precio_prod=<%= producto.getPrecio() %>&&unidad_med=<%= producto.getUnidadMedida() %>&&estado_prod=<%= producto.getEstado() %>&&categoria_prod=<%= producto.getCategoria_id() %>&&desc_prod=<%= producto.getDes_producto() %>" class="btn btn-info btn-sm glyphicon glyphicon-edit" role="button" name="btnmodi">Editar</a>
  <a  href="<%= request.getContextPath() %>/productos?opcion=eliminar&&id=<%= producto.getId_producto() %>" class="btn btn-danger btn-sm glyphicon glyphicon-remove" role="button" >Borrar</a>
                    </td>
      
                </tr>
                
                <%
                    }
                %>
            </table>
           <a id="button" href="<%= request.getContextPath() %>/productos?opcion=crear" class="btn btn-success" role="button"> Nuevo Producto</a>
            <a id="pdf" href="crearPDF" class="btn btn-warning">Imprimir PDF</a>
        </div>
    </body>
     <%@include file="../WEB-INF/Vistas-Parciales/pie.jspf" %>
</html>
