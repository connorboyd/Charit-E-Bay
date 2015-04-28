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
    img{
    	max-width: 100%;
    }
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
	          <li class="active"><a href="../browse">Browse</a></li>
	        </ul>
	        <ul class="nav navbar-nav navbar-right">
                <li><a href=${authToken ? "'profile'>My Profile" : "'login'>Sign In"}</a></a>
	        </ul>
	      </div>
	    </div>
    </nav>
    <div class="container">
    	<div class="col-md-4 col-md-offset-1">
		<img height="400px" width="300px" src= ${posting.getImage()} >
	</div>
	<div class="col-md-6">
		<div class="panel panel-default">
              		<div class="panel-heading">
                	<h3 class="panel-title"> Title: ${posting.getTitle()} </h3>
              		</div>
			<div class="panel-body">
			
			<p> <b>Current Bid:</b> ${posting.getHighestBid().getAmount()}
				<br><b>Highest Bidder:</b> ${posting.getHighestBidder().getUserName()}<br>
				<p><b>Beat the current bid:</b></p>

                <form action="/bid/${posting.getId()}" method="POST" name="Bid">
                    <div class="col-md-6">
                        <input class="form-control input-sm" name="amount" type="text" placeholder="Enter Bid">
                    </div>
                    <div class="col-md-6">
                        <input type="submit" name = "submit" class="btn btn-primary btn-md" value="Place Bid">
                    </div>
                </form>
                <br> <br>
                <p><b> Details:</b>  ${posting.getDescription()} </p>
                <p><b> Charity:</b> ${posting.getCharity().getName()} </p>
			
			</div>
		</div>
	</div>
    </div>
	</body>
</html>
