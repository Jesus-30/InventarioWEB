
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="bootstrap337/css/estilo-base.css" rel="stylesheet" type="text/css"/>
        <title>CONTROL DE INVENTARIO</title>
        <!--imcluimos l vita parcial la cual contiene las URL de las librerias correstondiemtes 
        a estilos y js-->
        <%@include file ="WEB-INF/Vistas-Parciales/css-js.jspf" %>
    </head>
    <body class="inicio">
       
        <!--Agregamos la vista de parcial del encabezado-->
        <%@include file = "WEB-INF/Vistas-Parciales/encabezado.jspf" %>
         <div class="jumbotron saludo">
            <h1 class="display-4">Hola, Usuario!</h1>
                <p class="lead">Bienvenido al inventario WEB, podras llevar mejor control sobre cualquier producto, un cotejamiento sobre lo que deseeas realizar puedes hacerlo justamente aquí</p>
                    <hr class="my-4">                  
                <center>       
                    <P>Regional de Zacatecoluca</P>
                <img src="bootstrap337/img/50Aniversario.png" class="inicioimg"> 
                </center>
         </div>
         <!--Vista parcial de pie de pagina-->
         <%@include file="WEB-INF/Vistas-Parciales/pie.jspf"%>
    </body>
</html>
