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
    <title>Login</title>
</head>
<body>

<h1>welcome, please login:</h1>

<form action="loginRegister" method="post">
    <table style="background-color: skyblue; margin-left: 20px; margin-left:20px;">
        <tr>
            <td><h3 style="color: red;">Login Page</h3></td>
        </tr>
        <tr>
            <td>login-name:</td>
            <td><input type="text" name="username" width="30"/></td>
        </tr>
        <tr>
            <td> password:</td>
            <td><input type="password" name="password" width="10"/></td>
        </tr>
        <tr>
            <td><input type="submit" name="submit" value="login"/></td>
            <td><a href="register.jsp"> Registration</a></td>
        </tr>
    </table>
</form>

<p style="color:red;">${message}</p>
<p style="color:green;">${successMessage}</p>

</body>
</html>
