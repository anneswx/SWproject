<%--
  Created by IntelliJ IDEA.
  User: Anne Sun
  Date: 2/24/2018
  Time: 5:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Hello, please register:</h1>

<form action="loginRegister" method="post">
    <table style="background-color: lightgreen; margin-left: 20px; margin-left:20px;">
        <tr>
            <td><h3 style="color: red;">Registration Page</h3></td>
        </tr>
        <tr>
            <td>username:</td>
            <td><input type="text" name="username" width="30"/></td>
        </tr>
        <tr>
            <td> password:</td>
            <td><input type="password" name="password" width="10"/></td>
        </tr>
        <tr>
            <td> Re-Type password:</td>
            <td><input type="password" name="password2" width="10"/></td>
        </tr>
        <tr>
            <td><input type="submit" name="submit" value="register"/></td>
        </tr>
    </table>
</form>
</body>
</html>
