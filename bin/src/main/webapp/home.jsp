<%--
  Created by IntelliJ IDEA.
  User: Anne Sun
  Date: 2/24/2018
  Time: 2:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Welcome</title>
</head>
<body>

<h1>Election System</h1>
<form action="loginRegister" method="post">
    <p>Hello, ${username}</p>
    <p style="color: green" ;>${successMessage}</p>
    <p>voter information status: ${noteMessage}</p>
    <% //if ((Integer) request.getAttribute("voterstatus") == 0) { %>
    <p><input type="submit" name="submit" value="become a voter"/></p>
    <% //} %>
    <p><input type="submit" name="submit" value="logout"/></p>
</form>
</body>
</html>
