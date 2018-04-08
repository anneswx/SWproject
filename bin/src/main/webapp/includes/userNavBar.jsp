<%-- 
    Document   : userNavBar
    Created on : Mar 8, 2018, 9:54:55 AM
    Author     : kate
--%>
<nav class="navbar navbar-inverse top-navbar" id="top-nav">
    <div class="container-fluid">
        <div class="navbar-header">      
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