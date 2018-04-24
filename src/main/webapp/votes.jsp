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

    <title>Paper trail</title>
</head>
<body>
	<%@ include file="includes/adminSideNav.jsp" %>
	<%@ include file="includes/adminNavBar.jsp" %>
	
	<div class="container-fluid"> <!-- div to hold all other divs -->
	
		<sql:setDataSource var = "data" driver = "com.mysql.jdbc.Driver"
		         url = "jdbc:mysql://bais.mysql.database.azure.com/db"
		         user = "voterapp@bais"  password = "P@$$w0rD"/>
		<sql:query dataSource = "${data}" var = "result">
		         select distinct candidateID from paper_trail order by candidateID;
		</sql:query>
		
		<div class="panel panel-defafult panel-table">
			<div class="panel-heading">
				<div class="row">
					<div class="col col-xs-6">
						<h1 class="panel-title">Paper Trail</h1>
					</div>
					<div class="col col-xs-6 text-right">
						<form method="post" action="/votes">
							Search by Candidate: <select name="choice">
								<c:forEach var = "row" items = "${result.rows}">
								    <option><c:out value = "${row.candidateID}"/></option>
								</c:forEach>
							</select>
							<input type="submit" value="Select" />
						</form>
					</div>
				</div>
			</div>
			<div class="panel-body">
				<table class="table table-striped table-bordered table-list">
					<thead>
						<tr>
							<th>paperTrailID</th>
							<th>electionID</th>
							<th>voterID</th>
							<th>Precinct</th>
							<th>candidateID</th>		
						</tr>
					</thead>
					<tbody>
						<sql:query dataSource = "${data}" var = "result">
				        	select paperTrailID, electionID, voterID, precinct, candidateID from paper_trail where candidateID ="${param.choice}" order by paperTrailID;
				    	</sql:query>
				    	<c:forEach var = "row" items = "${result.rows}">
							<tr>
								<td> <c:out value = "${row.paperTrailID}"/> </td>
								<td> <c:out value = "${row.electionID}"/> </td>
								<td> <c:out value = "${row.voterID}"/> </td>
								<td> <c:out value = "${row.precinct}"/> </td>
								<td> <c:out value = "${row.candidateID}"/> </td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</body>
</html>