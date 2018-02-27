<%--
  Created by IntelliJ IDEA.
  User: Anne Sun
  Date: 2/24/2018
  Time: 1:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="XA-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link rel="stylesheet" href="bootstrap-3.3.7-dist/css/bootstrap.min.css"/>
    <link rel="stylesheet" type="text/css" href="style.css" />

    <title>Login</title>
</head>
<body>
<div class="container-fluid"> <!-- div to hold all other divs -->
    <%@ include file="includes/navBar.jsp" %>
    <div class="row-fluid">
        <div class="col-md-offset-4 col-md-4" id="box">
            <h2>Please Login</h2>
            <hr>
            <form action="loginRegister" method="post" class="form-horizontal" id="contact_form">
                <fieldset>
                    <div class="form-group">
                        <div class="col-md-12">
                            <div class="input-group">
                                <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                                <input name="username" placeholder="Username" class="form-control" type="text" autofocus="autofocus">
                            </div>
                        </div>
                    </div>

                    <div class="form-group">
                        <div class="col-md-12">
                            <div class="input-group">
                                <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
                                <input name="password" placeholder="Password" class="form-control" type="password">
                            </div>
                        </div>
                    </div>

                    <div class="form-group">
                        <div class="col-md-12">
                            <div class="input-group">
                                <button type="submit" class="btn btn-md btn-success pull-right">Login </button>
                            </div>
                        </div>
                    </div>
                </fieldset>
            </form>
        </div>
    </div>
<p style="color:red;">${message}</p>
<p style="color:green;">${successMessage}</p>
ssss</div><!-- close main div -->
<br><br><br><br><br><br>
<%@ include file="includes/footer.jsp" %>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js" crossorigin="anonymous"></script>
<script src="bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
</body>
</html>
