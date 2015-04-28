<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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

    }
    #nav {  
    background-image: linear-gradient(to top, black, #808080); 
    min-height: 40px;
    padding-left: 20px;
    padding-right: 20px;
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
              <li><a href="/post_item">Post Item</a></li>
	        </ul>
	        <ul class="nav navbar-nav navbar-right">
	        	<li class="active"><a href="login">Sign In</a></li>
	        </ul> 
	      </div>
	    </div>
    </nav>
  <div class = "row">
	  <div class="col-md-6">
	  	<div align="center">
	  		<h2 style="color:#FA6900">Don't have an account?</h2>
	  		<br> <br> <br>
	  		<a href="register"><button class="btn btn-lg btn-primary">Register Today!</button></a>
	  	</div>
	  </div>
	  <div class = "col-md-6">
	  	<div align="center">
	  		<h2 style="color:#FA6900">Sign In:</h2>
	  	</div>
	  	<br>
		<form role="form" action="/login" method="POST" name="User">
		  <div class="form-group">
		  	<div class="row">
		  		<div class="col-md-5 col-md-offset-4">
					<label for="email">Email:</label>
				    <input type="text" class="form-control" name="email" id="email" placeholder="Enter email">
				    <br>
					<label for="passwordHash">Password:</label>
				    <input type="password" class="form-control" name="passwordHash" id="passwordHash" placeholder="Enter password">
				</div>
		    </div>
		    <br>
		    <div align="center">
		    	<input type="submit" id="submit" class="btn btn-primary" value="Submit">
		    </div>
		  </div>
	    </form>
	  </div>
	</div>
	</body>
</html>
