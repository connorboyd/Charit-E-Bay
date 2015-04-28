<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
  <head>
  	<title>Charit-E-Bay</title>
      <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
      <!-- Bootstrap -->
      <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
      <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
    <style>
    html, body {
      height: 100%;
      width: 100%;
      padding: 0;
      margin: 0;
    }

    #body{
      background-color: #A7DBDB;
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
    .welcome{
      color:#FA6900;
      letter-spacing: 0.1em
    }
    #title {
      letter-spacing: 0.1em
    }
    </style>
	</head>
	<body id="body">
    <!-- <img alt="full screen background image" src="http://walls-world.com/wp-content/uploads/2013/08/3D-White-Wallpaper.jpeg" id="bg-image" /> --> 

    <div id="wrapper">
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
	          <li class="active"><a href="/">Home</a></li>
              <li><a href="/post_item">Post Item</a></li>
	        </ul>
	        <ul class="nav navbar-nav navbar-right">
                <c:if test="${authToken == null}">
                    <li><a href="login">Sign In</a></li>
                </c:if>
	        </ul>
	      </div>
	    </div>
    </nav>
    <div class="container">
    	<div align="center">
        <div class="row">
          <div class="col-md-2"></div>
          <div class="col-md-8">
        <div class="well well-sm" id="well" style="background-color:#E0E4CC">
    		<h2 class="welcome"><b>Welcome to Charit-E-Bay!</b></h2>
    		<p class="welcome"><b>Where you can sell and bid on items to raise money for charitable organizations</b></p>
        </div>
      </div>
    	</div>
    </div>
    <hr>
    <div align="center">
      <div class="row">
        <div class="col-md-4"></div>
        <div class="col-md-4">
    	  <h2 class="welcome"><b>Current Items:</b></h2>
    </div>
    </div>
    <div class="row">
      <div class="col-md-1"></div>
      <div class="col-md-10">
        <table class="table table-hover">
          <thead>
            <tr>
              <th>Picture:</th>
              <th>Title:</th>
              <th>Charity:</th>
              <th>Current Bid:</th>
              <th>Details & Bidding:</th>
            </tr>
          </thead>
          <tbody>
            <c:forEach items="${postings}" var="posting">
                <tr>
                  <td><img src="${posting.getImage()}" height="100px" width="100px"></td>
                  <td>${posting.getTitle()}</td>
                  <td>${posting.getCharity().getName()}</td>
                  <td>${posting.getHighestBid().getAmount()}</td>
                  <td><a href="details/${posting.getId()}">See More</a></td>
                </tr>
            </c:forEach>
          </tbody>
        </table>
      </div>
    </div>
	</body>
</html>
