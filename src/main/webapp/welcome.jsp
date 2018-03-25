<%--
  User: Heather Kemp
  Date: 3/8/2018
  Time: 10:10 AM
--%>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <meta charset="utf-8">
    <meta http-equiv="XA-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link rel="stylesheet" href="bootstrap-3.3.7-dist/css/bootstrap.min.css"/>
    <link rel="stylesheet" type="text/css" href="style.css"/>

    <title>Welcome!</title>
</head>

<h1>Election System</h1>

<div class="container-fluid"> <!-- div to hold all other divs -->

<%  
if (request.getAttribute("customer") == null && request.getAttribute("admin") == null){ %>
	<%@ include file="includes/navBar.jsp" %>
    <div class="row-fluid">
        <div class="col-md-offset-2 col-md-8" id="box">
            <h2>Welcome to our voting service! Please register or login!</h2>
        </div>
    </div>
<% }
    else if (request.getAttribute("customer") == null) { %>
    		<h2>Customer welcome!</h2>
    	<% } else { %>
    		<h2>Admin Welcome!</h2>
    	<% } %>
    

</div><!-- close main div -->
<br><br><br><br><br><br>
<%@ include file="includes/footer.jsp" %>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js"
        crossorigin="anonymous"></script>
<script src="bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
</body>

</html>