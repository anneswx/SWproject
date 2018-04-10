<%@ page import = "java.io.*,java.util.*,java.sql.*"%>
<%@ page import = "javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/sql" prefix = "sql"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<sql:setDataSource var = "data" driver = "com.mysql.jdbc.Driver"
         url = "jdbc:mysql://bais.mysql.database.azure.com/db"
         user = "voterapp@bais"  password = "P@$$w0rD"/>
<sql:query dataSource = "${data}" var = "result">
         select distinct precinct from user_info where voter_status = 2 order by precinct;
</sql:query>
<h1>Voters</h1>
<form method="post" action="voterlist.jsp">
Search by Precinct: <select name="choice">
<c:forEach var = "row" items = "${result.rows}">
    <option><c:out value = "${row.precinct}"/></option>
</c:forEach>
</select>
<input type="submit" value="Select" />
</form>
<table>
	<tr>
		<th>UserId</th>
		<th>First Name</th>
		<th>Last Name</th>
		<th>SSN</th>
		<th>Address</th>
		<th>City</th>
		<th>State</th>
		<th>Zipcode</th>
		<th>Precinct</th>
		<th>Gender</th>
		<th>Age</th>
		<th>Education</th>
				
	</tr>
	
	<sql:query dataSource = "${data}" var = "result">
         select id, first_name,last_name, ssn, address, city, 
         state, zipcode, precinct, gender, age, education from user_info where voter_status = 2 and precinct ="${param.choice}" order by id;
    </sql:query>
	<c:forEach var = "row" items = "${result.rows}">
		<tr>
			<td> <c:out value = "${row.id}"/> </td>
			<td> <c:out value = "${row.first_name}"/> </td>
			<td> <c:out value = "${row.last_Name}"/> </td>
			<td> <c:out value = "${row.ssn}"/> </td>
			<td> <c:out value = "${row.address}"/> </td>
			<td> <c:out value = "${row.city}"/> </td>
			<td> <c:out value = "${row.state}"/> </td>
			<td> <c:out value = "${row.zipcode}"/> </td>
			<td> <c:out value = "${row.precinct}"/> </td>
			<td> <c:out value = "${row.gender}"/> </td>
			<td> <c:out value = "${row.age}"/> </td>
			<td> <c:out value = "${row.education}"/> </td>
		</tr>
	</c:forEach>	
</table>



</body>
</html>