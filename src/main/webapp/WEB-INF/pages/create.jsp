<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
  <head>
  	<title>Charit-E-Bay</title>

	  <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
	  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
	  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
     <style>
    html, body {
      height: 100%;
      width: 100%;
      padding: 0;
      margin: 0;
    }

    #bg-image {
      z-index: -999;
      min-height: 100%;
      min-width: 1024px;
      width: 100%;
      height: auto;
      position: fixed;
      top: 0;
      left: 0;
    }
    #nav {  
    background-image: linear-gradient(to top, black, #808080); 
    min-height: 40px;
    padding-left: 20px;
    padding-right: 20px;
    }
    #title {
      letter-spacing: 0.1em
    }
    </style>
	</head>
        <body style="background-color:#A7DBDB">
            <div align="center">
                <h1 style="color:#FA6900" id="title">Charit-E-Bay</h1>
            </div>
            <nav class="navbar navbar-inverse navbar-static-top" id="nav" role="navigation">
                <div class="container">
                    <div class="navbar-header">
                        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                            <span class="sr-only">Toggle navigation</span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                        </button>
                    </div>
                    <!-- Collect the nav links, forms, and other content for toggling -->
                    <div class="navbar-collapse collapse" id="bs-example-navbar-collapse-1">
                        <ul class="nav navbar-nav">
                            <li><a href="/">Home</a></li>
                            <li><a href="browse">Browse</a></li>
                        </ul>
                        <ul class="nav navbar-nav navbar-right">
                            <li><a href=${authToken!=null ? "'profile'>My Profile" : "'login'>Sign In"}</a></a>
                        </ul>
                    </div>
                </div>
            </nav>
            <div class="container">
                <div align="center">
                    <div class="row">
                        <div class="col-md-8 col-md-offset-2">
                            <h2 style="color:#FA6900">Create a new posting</h2>
                            <hr>
                            <h4>Posting title:</h4>
                            <form action="/post_item" method="POST" name="Posting" id="postform">
                                <input type="text" class="form-control" placeholder="Enter posting title" name="title">
                                <h4>Posting description:</h4>
                                <input type="text" class="form-control" id="description" placeholder="Enter item description" name="description">
                                <h4>Organization:</h4>
                                <select class="form-control" id="organization" name="organization" form="postform">
                                    <c:forEach items="${charities}" var="charity">
                                        <option value="${charity.getId()}">${charity.getName()}</option>
                                    </c:forEach>
                                </select>
                                <h4>Picture URL:</h4>
                                <input type="text" class="form-control" name="image" placeholder="Enter URL">
                                <input type="submit" class="btn btn-primary" value="Submit">
                            </form>
                        </div>
                    </div>
                </div>
                <br>
                <div align="center">
                </div>
		    </div>
		    <br> <br> <br>
	</body>
</html>
