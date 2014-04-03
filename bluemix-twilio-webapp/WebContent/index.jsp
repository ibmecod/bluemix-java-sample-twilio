<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>Bluemix Twilio Demo</title>
	<meta charset="utf8">  
  	<meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- Bootstrap  xxy -->
   <link href="bootstrap.min.css" rel="stylesheet" media="screen">
   <link href="bootstrap-responsive.css" rel="stylesheet">
   <link href="bootstrap.css" rel="stylesheet">

  <style type="text/css">
	body {
		padding-top: 60px; /* 60px to make the container go all the way to the bottom of the topbar */
	}
	
	/* Custom container */
    .container-narrow {
        margin: 0 auto;
        max-width: 900px;
		border-style: solid;
		border-color: transparent;
		background-color: #D8D8D8;
		z-index: 9;
		height : 100%;
		-moz-border-radius: 15px;
		border-radius: 15px;
    }
    .container-narrow > hr {
      	margin: 30px 0;
    }

	.sidebar-nav {
        padding: 20px 0;
    }

    @media (max-width: 980px) {
	    /* Enable use of floated navbar text */
	    .navbar-text.pull-right {
			float: none;
			padding-left: 5px;
			padding-right: 5px;
	    }
	}
  </style>
  

</head>
<body>
  

  <div class="navbar navbar-inverse navbar-fixed-top">
      <div class="navbar-inner">
        <div class="container">
          
          <a class="brand pull-left" href="/index.html"><em>BlueMix Twilio SMS Demo&nbsp;</em><small>v1.0.0.1</small></a>
	  
          <div class="nav-collapse collapse">
           
          </div><!--/.nav-collapse -->
        </div>
      </div>
    </div>  <!-- end of div for nav bar-->
  
  <div class="container">
  <!-- <table class="table table-hover">
  <tr> -->
  <div class="hero-unit">
  <div \>
  <h2 class="text-center"><em>BlueMix Twilio SMS Demo</em><h2>
  </div>
  <br/>
  
  <form id="search" action="sms" method="POST" class="form-search">
  <p style="text-align: center"> 
  <input id="phoneNumber" type="text" name="to" value="" placeholder="Enter phone number" class="input-large"/>
 </p>
 <p style="text-align: center">
  <textarea id="smsbody" name="body" placeholder="Enter text message" class="input-large"></textarea>
  </p>
  <p style="text-align: center">
  <input id="sendsms" type="submit" value="Send SMS" class="btn btn-info" />
  
  </p>
  </form>
  
  
 
  </div> <!-- end of the hero-unit-->
  </div> <!-- end of the container-->
</body>
</html>