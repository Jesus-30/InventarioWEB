
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="bootstrap337/css/font-awesome.min.css" rel="stylesheet" type="text/css"/>
        <link href="bootstrap337/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="bootstrap337/css/estilo-base.css" rel="stylesheet" type="text/css"/>
        <title>Acerca de</title>
    </head>
    <body>
         <%@include file = "WEB-INF/Vistas-Parciales/encabezado.jspf" %>
         <div class="container">
	    <div class="row">
		<div class="col-lg-12 text-center">
	            <div class="row">
                        <!--Tarjeta número uno-->
                        <div class="col-lg-4 col-md-12 mb-4">
                            <div class="card-section border rounded ml-4 mr-4" style="margin-top: 80px;">
                                <div class="card-header card-header-second rounded">
                                     <img src="bootstrap337/img/usuario.png" height="200px" class="rounded-circle">
		                     <h2 class="card-header-title mb-3 mt-1 text-white">Estefany Linares</h2>
		                </div>
		                <div class="card-body text-center" style="background-color: #ffc107">
		                    <p class="card-text">Backend</p>
                                    <br>
                                     <ul id="icon">                                         
                                         <a href="#"><li id="icon" class="fa fa-facebook-official fa-3x"></li></a>                                        
                                         <a href="#"><li id="icon" class="fa fa-instagram fa-3x"></li></a>
                                         <a href="#"><li id="icon" class="fa fa-github fa-3x"></li></a>                             
                                     </ul>                                                                                                          
		                </div>
	                    </div>
	                </div>
                    <!--tarjeta 2-->
	                <div class="col-lg-4 col-md-12 mb-4">
		            <div class="card-section border rounded ml-4 mr-4" id="carta01" style="margin-top: 80px;">
		                <div class="card-header card-header-second rounded">
                                     <img src="bootstrap337/img/usuario.png" height="200px" class="rounded-circle">
		                     <h2 class="card-header-title mb-3 mt-1 text-white">Jesús Henríquez</h2>
		                </div>
		                <div class="card-body text-center" style="background-color: #ffc107">
		                    <p class="card-text">Scrum Master</p>
		                     <br>    
                                    <ul id="icon">                                         
                                         <a href="#"><li id="icon" class="fa fa-facebook-official fa-3x"></li></a>                                        
                                         <a href="#"><li id="icon" class="fa fa-instagram fa-3x"></li></a>
                                         <a href="#"><li id="icon" class="fa fa-github fa-3x"></li></a>                             
                                     </ul> 
		                </div>
	                    </div>
	                </div>
                    <!--tarjeta 3-->
	                <div class="col-lg-4 col-md-12 mb-4">
                            <div class="card-section border rounded ml-4 mr-4" style="margin-top: 80px;">
		                <div class="card-header card-header-second rounded">
                                     <img src="bootstrap337/img/usuario.png" height="200px" class="rounded-circle">
		                     <h2 class="card-header-title mb-3 mt-1 text-white">Jorge Ernesto</h2>
		                </div>
		                <div class="card-body text-center" style="background-color: #ffc107">
		                    <p class="card-text">Frontend</p>
		                     <br>    
                                    <ul id="icon">                                         
                                         <a href="#"><li id="icon" class="fa fa-facebook-official fa-3x"></li></a>                                        
                                         <a href="#"><li id="icon" class="fa fa-instagram fa-3x"></li></a>
                                         <a href="#"><li id="icon" class="fa fa-github fa-3x"></li></a>                             
                                     </ul> 
		                </div>
	                    </div>
	                </div>
	            </div>
	        </div>
	    </div>
	</div>
         <%@include file="WEB-INF/Vistas-Parciales/pie.jspf"%>
    </body>
</html>
