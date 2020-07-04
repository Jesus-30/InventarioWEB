
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="bootstrap337/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="bootstrap337/css/estilo-base.css" rel="stylesheet" type="text/css"/>
        <title>Inicio de Sesión</title>
    </head>
    <style>
        body{
            background-image: url(bootstrap337/img/wallhaven-13zxr1_1600x768.png);
        }
        .Login{
    width: 600px;
    background: #ffc107;
    margin: auto;
    margin-top: 160px;
    padding: 5px 5px 30px 5px;
    border-radius: 50px;
}
h1{
    text-align: center;
    color: white
}
    </style>
    <body>
        <div class="Login">      
            <div>
                <h1>Inicio de Sesión</h1>
  <div class="card-body">
    <h5 class="card-title">Correo: </h5>
    <input type="text" class="form-control">
    <h5>Contraseña</h5>
    <input type="text" class="form-control">
    <br>
    <center>
    <a href="index.jsp" class="btn btn-danger">Ingresar</a>
    </center>
  </div>
                <center>
  <div class="card-footer text-muted">
    ¿Olvidaste la contraseña?
  </div>
                </center>
</div>
        </div>
    </body>
</html>
