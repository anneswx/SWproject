<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">

    </head>
    <body>



        <div class="wrapper">
            <!-- Sidebar Holder -->
            <nav id="sidebar">
                <div class="sidebar-header">
                    <h3>Management Portal</h3>
                    <img class="img-circle" src="https://www.jamf.com/jamf-nation/img/default-avatars/generic-user-purple.png" alt="manager user" height="75" width="75">
            <p class="welcome"><i class="fa fa-key"></i> Logged in as</p>
                <span class="last-name">Name </span>
                <a href="/logout"><i class="fa fa-sign-out"></i></a>      
                </div>

                <ul class="list-unstyled components">
                    <li class="nav-search">
			            <form class="navbar-form">
			                <div class="input-group">
			                    <input type="text" class="form-control" placeholder="Search">
			                    <div class="input-group-btn">
			                        <button class="btn btn-default" type="submit">
			                            <i class="glyphicon glyphicon-search"></i>
			                        </button>
			                    </div>
			                </div>
			            </form>
			        </li>
			        <li>
                        <a href="#"><i class="fa fa-dashboard"></i> Dashboard</a>
                    </li>
                    <li>
                    		
                        <a href="#usersSubmenu" data-toggle="collapse" aria-expanded="false"><i class="fa fa-users"></i> Users <i class="fa fa-caret-down pull-right"></i></a>
                        <ul class="collapse list-unstyled" id="usersSubmenu">
                            <li><a href="#"><i class="fa fa-angle-double-right"></i> Voters</a></li>
                            <li><a href="#"><i class="fa fa-angle-double-right"></i> Managers</a></li>
                        </ul>
                    </li>
                    <li>
                        <a href="#analyticsSubmenu" data-toggle="collapse" aria-expanded="false"><i class="fa fa-bar-chart-o"></i> Analytics <i class="fa fa-caret-down pull-right"></i></a>
                        <ul class="collapse list-unstyled" id="analyticsSubmenu">
                            <li><a href="#"><i class="fa fa-angle-double-right"></i> Create a Report</a></li>
                            <li><a href="#"><i class="fa fa-angle-double-right"></i> Review Reports</a></li>
                        </ul>
                    </li>
                    <li>
                        <a href="#calendarSubmenu" data-toggle="collapse" aria-expanded="false"><i class="fa fa-calendar"></i> Calendar <i class="fa fa-caret-down pull-right"></i></a>
                        <ul class="collapse list-unstyled" id="calendarSubmenu">
                            <li><a href="#"><i class="fa fa-angle-double-right"></i> Upcoming Events</a></li>
                            <li><a href="#"><i class="fa fa-angle-double-right"></i> All Events</a></li>
                        </ul>
                    </li>
                    <li>
                        <a href="#pollsSubmenu" data-toggle="collapse" aria-expanded="false"><i class="fa fa-edit"></i> Polls <i class="fa fa-caret-down pull-right"></i></a>
                        <ul class="collapse list-unstyled" id="pollsSubmenu">
                            <li><a href="#"><i class="fa fa-angle-double-right"></i> Add a Poll</a></li>
                            <li><a href="#"><i class="fa fa-angle-double-right"></i> Update a Poll</a></li>
                            <li><a href="#"><i class="fa fa-angle-double-right"></i> Delete a Poll</a></li>
                            <li><a href="#"><i class="fa fa-angle-double-right"></i> View All Polls</a></li>
                        </ul>
                    </li>
                    <li>
                        <a href="#"><i class="fa fa-map-marker"></i> Precincts</a>
                    </li>
                </ul>
            </nav>

            <!-- Page Content Holder -->
            <div id="content">
				
				<nav class="navbar navbar-inverse top-navbar" id="top-nav">
				    <div class="container-fluid" style="width: 90%">
				        <div class="navbar-header">      
				        		<div class="navbar-header">
				                            <button type="button" id="sidebarCollapse" class="navbar-btn">
				                                <span></span>
				                                <span></span>
				                                <span></span>
				                            </button>
				             </div>
				            <a class="navbar-brand" href="/">Voter Application</a>
				
				        </div>  
				        <ul class="social-icon pull-right list-inline">
				            <li class="dropdown">
				                <a class="alerts-link dropdown-toggle" data-toggle="dropdown" href="#"><span class="glyphicon glyphicon-bell"></span>
				                    <span class="number">0</span>
				                    <span class="caret"></span>
				                </a>
				                <ul class="dropdown-menu">
				                    <li><a href="#">Notification 1</a></li>
				                    <li><a href="#">Notification 2</a></li>
				                    <li><a href="#">Notification 3</a></li>
				                </ul>
				            </li> 
				            <li class="dropdown">
				                <a class="user-link dropdown-toggle" data-toggle="dropdown" href="#"><span class="glyphicon glyphicon-user"></span>             
				                    <span class="caret"></span>
				                </a>
				                <ul class="dropdown-menu">
				                    <li><a href="#">Profile</a></li>
				                    <li><a href="/logout">Logout</a></li>
				                </ul>
				            </li>
				            <li class="dropdown">
				                <a class="tasks-link dropdown-toggle" data-toggle="dropdown" href="#"><span class="glyphicon glyphicon-cog"></span> 
				                    <span class="caret"></span>
				                </a>
				                <ul class="dropdown-menu">
				                    <li><a href="#">Settings</a></li>
				                    <li><a href="#">Help</a></li>
				                </ul>
				            </li>
				        </ul>       
				    </div>  
				</nav>
				
				<div class="container-fluid"> 
		    			<div class="row-fluid">
		        			<div class="col-md-offset-2 col-md-8" id="box">
		            			<h2>Welcome, ${firstName}! </h2>
		        			</div>
		    			</div>
    				</div>
    				
    				<%@ include file="footer.jsp" %>
    				
    			</div>
    		</div>




        <!-- jQuery CDN -->
         <script src="https://code.jquery.com/jquery-1.12.0.min.js"></script>

         <script type="text/javascript">
             $(document).ready(function () {
                 $('#sidebarCollapse').on('click', function () {
                     $('#sidebar').toggleClass('active');
                     $(this).toggleClass('active');
                 });
             });
         </script>
    </body>
</html>
