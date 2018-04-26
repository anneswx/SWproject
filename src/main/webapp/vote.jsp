<%@ page import = "java.io.*,java.util.*,java.sql.*"%>
<%@ page import = "javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/sql" prefix = "sql"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="XA-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link rel="stylesheet" href="bootstrap-3.3.7-dist/css/bootstrap.min.css"/>
    <link rel="stylesheet" type="text/css" href="style.css" />
    <link href="css/font-awesome.css" rel="stylesheet" type="text/css">
    
    <script src="https://use.fontawesome.com/07b0ce5d10.js"></script>

    <title>vote</title>
</head>
<body>


<%@ include file="includes/userNavBar.jsp" %>
<div class="container-fluid"> <!-- div to hold all other divs -->

	
<sql:setDataSource var = "data" driver = "com.mysql.jdbc.Driver"
         url = "jdbc:mysql://bais.mysql.database.azure.com/db"
         user = "voterapp@bais"  password = "P@$$w0rD"/>
<sql:query dataSource = "${data}" var = "result">
         select distinct electionID from candidate_info order by electionID;
</sql:query>
<h1>Candidate List</h1>
<form method="post" action="/vote">
Search by Election number: <select name="choice">
<c:forEach var = "row" items = "${result.rows}">
    <option><c:out value = "${row.electionID}"/></option>
</c:forEach>
</select>
<input type="submit" value="Select" />
</form>
<table>
	<tr>
		<th>electionID</th>
		<th>Candidate Name</th>	
		<th>Party</th>	
		<th>Select</th>		
	</tr>
	
	<sql:query dataSource = "${data}" var = "result">
         select electionID, candidateName, party from candidate_info where electionID ="${param.choice}" order by candidateName;
    </sql:query>
	<c:forEach var = "row" items = "${result.rows}">
		<tr>
			<td> <c:out value = "${row.electionID}"/> </td>
			<td> <c:out value = "${row.candidateName}"/> </td>
			<td> <c:out value = "${row.party}"/> </td>
			<td> <input type="checkbox" name="choice" ></td>
		</tr>
	</c:forEach>
	
</table>
<input type="submit" name ="submit" value="vote" class="btn btn-success btn-block">	

    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js" crossorigin="anonymous"></script>
    <script src="bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
    <script src="js/jquery-3.1.1.js"></script>
    <script src="js/bootstrap.js"></script>
</div>

</body>
</html>