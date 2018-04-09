<%--
  User: Heather Kemp
  Date: 3/8/2018
  Time: 10:10 AM
--%>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.Team12.CS5800.VotingApplication.model.SessionGrabber" %>
<%@ page import="com.Team12.CS5800.VotingApplication.model.EmailAuthGrabber" %>
<%@ page import="com.Team12.CS5800.VotingApplication.model.UserGrabber" %>
<%@ page import="com.Team12.CS5800.VotingApplication.model.User" %>
<%@ page import ="java.util.ArrayList" %>

<html>

<head>
    <meta charset="utf-8">
    <meta http-equiv="XA-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link rel="stylesheet" href="bootstrap-3.3.7-dist/css/bootstrap.min.css"/>
    <link rel="stylesheet" type="text/css" href="style.css"/>
    <link href="css/font-awesome.css" rel="stylesheet" type="text/css">
    
    <script src="https://use.fontawesome.com/07b0ce5d10.js"></script>
    

    <title>Welcome!</title>
</head>

<!-- div to hold all other divs -->

<% 



String sessionCode = ""; 
	Cookie[] cookies = null;
	
	cookies = request.getCookies();
	if ( cookies != null) {
		for (int i = 0; i < cookies.length; i++) {
			
			if (cookies[i].getName().equals("sessionID")) {
				sessionCode = cookies[i].getValue();
				
			}
		}
	}
	
	if (sessionCode.equals("")){ // Not logged in
		%>
		<%@ include file="includes/navBar.jsp" %>
		<div class="container-fluid"> 
    		<div class="row-fluid">
        		<div class="col-md-offset-2 col-md-8" id="box">
            		<h2>You aren't logged in! Did you perhaps land here by accident?</h2>
        		</div>
    		</div>
		
		
		<%
	} else {
		SessionGrabber sg = new SessionGrabber();
		String userStatus = sg.checkAdminStatus(sessionCode);
		String firstName = sg.getFirstName(sessionCode);
		pageContext.setAttribute("firstName", firstName);
		if (userStatus.equals("admin")){
			%>
			
			Admin
			
			<%
		}
		else if (userStatus.equals("manager")) {
			
			UserGrabber ug = new UserGrabber();
			String precinct = sg.getPrecinct(sessionCode);
			ArrayList<User> userList = ug.getAppliedUsersByPrecinct(precinct);
			
			
			ArrayList<ArrayList<String>> arrayList = new ArrayList();
			
			for(int i = 0; i < userList.size(); i++){
				User currentUser = userList.get(i);
				ArrayList<String> inner = new ArrayList();
				String id = Integer.toString(currentUser.getID());
				String name = currentUser.getFirstName() + " " + currentUser.getLastName();
				String ssn = currentUser.getSSN();
				inner.add(id);
				inner.add(name);
				inner.add(ssn);
				arrayList.add(inner);
				
			}
			

			
			%>
			
			<%@ include file="includes/managerSideNav.jsp" %> 
			 
			<%@ include file="includes/managerNavBar.jsp" %> 
			
			<br/>
			<h1 style="text-align:center"><%=precinct%> APPLICANTS</h1>
			<br/>

			 <script type = "application/javascript">
			 
			 function approve(e) {
				 	var e = e || window.event;
				  	var src = e.target || e.srcElement;
				    var userId = src.getAttribute('data-userid');
				    
				    var form = document.createElement("form");
				    var element1 = document.createElement("input"); 
				    var element2 = document.createElement("input");  
				    var element3 = document.createElement("input"); 

				    form.method = "POST";
				    form.action = "#";  
				    
				    element1.value=userId;
				    element1.name="userID";
				    element1.type="hidden";
				    form.appendChild(element1);  

				    element2.value="approve";
				    element2.name="command";
				    element2.type="hidden";
				    form.appendChild(element2);
				    
				    element3.value="<%=sessionCode%>";
				    element3.name="sessionID";
				    element3.type="hidden";
				    form.appendChild(element3);
				    
				    document.body.appendChild(form);

				    form.submit();
			        event.preventDefault();

				    
				}
			 
			 function decline(e) {
				 	var e = e || window.event;
				  	var src = e.target || e.srcElement;
				    var userId = src.getAttribute('data-userid');
				    
				    var form = document.createElement("form");
				    var element1 = document.createElement("input"); 
				    var element2 = document.createElement("input");  
				    var element3 = document.createElement("input"); 

				    form.method = "POST";
				    form.action = "#";  
				    
				    element1.value=userId;
				    element1.name="userID";
				    element1.type="hidden";
				    form.appendChild(element1);  

				    element2.value="decline";
				    element2.name="command";
				    element2.type="hidden";
				    form.appendChild(element2);
				    
				    element3.value="<%=sessionCode%>";
				    element3.name="sessionID";
				    element3.type="hidden";
				    form.appendChild(element3);
				    
				    document.body.appendChild(form);

				    form.submit();
			        event.preventDefault();
			        
				}
			 
			 function toJavascript(){
		          var array="<%=arrayList%>";

		          array=array.replace(/\[/g, "");
		          console.log(array);
		          array=array.split("],");
		          console.log(array);
		          for(var i = 0; i < array.length; i++){
		        	  	array[i] = array[i].replace(/\]/g, "");
		        	  	array[i] = array[i].split(",");
		          }
		          
		          return array;

		}
			 var myPeople = toJavascript();
			 
			 var sessionID = "Heyo";
			 
			 if(myPeople[0] != "") {
			 
			 var mytable = "<table align='center'><tbody><tr>";
			 
			 
			 

				 for (var i = 0; i < myPeople.length; i++) {
					 for(var j = 0; j < myPeople[i].length; j++){
						 if(j != 0) {
						 mytable += "<td>";
						 mytable += myPeople[i][j];
						 mytable += "</td>";
						 }
					 }
					 
	
					 mytable += "<td><button type='button' className='btn btn-default' onClick='approve()' data-userid=" + myPeople[i][0] + ">Approve</button></td>";
					 mytable += "<td><button type='button' className='btn btn-default' onClick='decline()' data-userid=" + myPeople[i][0] + ">Decline</button></td>";
					 
					 mytable += "</tr><tr>";
				 }
			 

			 mytable += "</tr></tbody></table>";
			 
			 document.write(mytable);
			 
			 }


			
			 
			 
			 </script>
			 
			 </div>
			 </div>
			
			<%
		}
		else { // user
			%>
			
			<h3>You shouldn't be here</h3>
			
			<% 
		}
	}
%>

<%




%>

</div><!-- close main div -->
<br><br><br><br><br><br>
<%@ include file="includes/footer.jsp" %>


<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js"
        crossorigin="anonymous"></script>
<script src="bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
</body>

</html>