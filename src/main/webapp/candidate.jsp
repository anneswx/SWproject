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

    <title>Add a Candidate</title>
</head>
<body>
<%@ include file="includes/adminSideNav.jsp" %>
<%@ include file="includes/adminNavBar.jsp" %>
<div class="login">
        <div class="container">
            <div class="col-lg-6 col-lg-offset-3">
                <div class="inner-form">
                    <h2>Add a Candidate</h2> 
                    <hr>
               
                <div class="panel-body">
                    <form method="post" action="/candidate">
                    		<div class="row">
                            <div class="col-xs-6 col-sm-6 col-md-6">
                    				<div class ="form-group">
                    					<label>candidateName</label>
                    					<input type="text" name="candidateName" id="candidateName" class="form-control input-sm" placeholder="candidateName" autofocus="autofocus" required/>
                    				</div>
                    			</div>
                    			<div class="col-xs-6 col-sm-6 col-md-6">
                    				<div class ="form-group">
                    					<label>electionID</label>
                    					<input type="text" name="electionID" id="electionID" class="form-control input-sm" placeholder="electionID" required/>
                    				</div>
                    			</div>
                    		</div>
                    		
                    		<div class = "form-group">
                    			<label>Party</label>
                    			<input type="text" name="party" id="party" class="form-control input-sm" placeholder="party" required/>
                    		</div>                			                
                    		
                        <input type="submit" name ="submit" value="Add" class="btn btn-success btn-block">
                        
                    </form>
                    </div>
                </div>
            </div>
        </div>
    </div>

</body>
</html>