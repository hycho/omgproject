<%@include file="/WEB-INF/views/common/common.jsp" %>

<html ng-app="mainApp">
<head>
<title>ChouHoo</title>
<link href="${resourcePath}/css/bootstrap/bootstrap.css" rel="stylesheet" type="text/css" />
<link href="${resourcePath}/css/chouHoo.css" rel="stylesheet" type="text/css" />
<!-- Custom Theme files -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!--webfont-->
<link href='http://fonts.googleapis.com/css?family=Montserrat:400,700' rel='stylesheet' type='text/css'>
<script src="${resourcePath}/js/plugins/jquery/jquery-2.1.3.min.js" type="text/javascript"></script>
<script src="${resourcePath}/js/plugins/easydropdown/jquery.easydropdown.js" type="text/javascript"></script>
<script src="${resourcePath}/js/plugins/angularjs/angular.min-1.3.8.js" type="text/javascript"></script>

<script src="${resourcePath}/js/app-main.js" type="text/javascript"></script>
<script src="${resourcePath}/js/album/albumController.js" type="text/javascript"></script>
<script src="${resourcePath}/js/common/asyncHttpModule.js" type="text/javascript"></script>

</head>
<body ng-controller="mainCtrl">
<div class="header">
	<div class="col-sm-8 header-left">
		<div class="logo">
			<a href="${contextPath}/main" class="logo">
        		<span class="logo-text">Chouve</span>
        	</a>	
	 	</div>
	 	<div class="menu">
			<a class="toggleMenu" href="#"><img src="${resourcePath}/img/nav.png" alt="" /></a>
		    	<ul class="nav" id="nav">
		    		<sec:authorize access="isAuthenticated()">
		    		<li  class="active"><a href="${contextPath}/myhome/main">MyHome</a></li>
		    		</sec:authorize>
		    		<li><a href="#">Music</a></li>
		    		<li><a href="living.html">Listen</a></li>
		    		<li><a href="education.html">Event</a></li>
		    		<li><a href="entertain.html">Charts</a></li>
					<div class="clearfix"></div>
				</ul>
				<script type="text/javascript" src="${resourcePath}/js/main/responsive-nav.js"></script>
    	</div>	
     	<!-- start search-->
      	<div class="search-box">
			<div id="sb-search" class="sb-search">
				<form>
					<input class="sb-search-input" placeholder="Enter your search contents..." type="search" name="search" id="search">
					<input class="sb-search-submit" type="submit" value="">
					<span class="sb-icon-search"> </span>
				</form>
			</div>
		</div>
		<!----search-scripts---->
		<script src="${resourcePath}/js/main/classie.js"></script>
		<script src="${resourcePath}/js/main/uisearch.js"></script>
		<script>
			new UISearch( document.getElementById( 'sb-search' ) );
		</script>
		<!----//search-scripts---->						
 		<div class="clearfix"></div>
	</div>
	<div class="col-sm-4 header_right">
		<div id="loginContainer">
		<sec:authorize access="!isAuthenticated()">
			<a id="loginButton" ng-click="flags.viewLogin = 'true'"><img src="${resourcePath}/img/login.png"><span>Login</span></a>
			<div id="loginBox" ng-show="flags.viewLogin == 'true'">
				<form name="loginForm" id="loginForm" method="POST" action="<c:url value='/j_spring_security_check' />">
					<fieldset id="body">
						<fieldset>
							<label for="email">User ID</label> 
							<input type="text" name="j_username" placeholder="UserId">
						</fieldset>
						<fieldset>
							<label for="password">Password</label> 
							<input type="password" name="j_password" id="password" placeholder="Password">
						</fieldset>
						<input type="submit" id="login" value="Login"> 
						<label for="checkbox"><input type="checkbox" id="checkbox">
						<i>Remember me</i></label>
					</fieldset>
					<span><a href="${contextPath}/regist">Regist your Account</a></span>
					<span><a>Sign up for Chouve</a></span>
				</form>
			</div>
		</sec:authorize>
		<sec:authorize access="isAuthenticated()">
			<a href="/mps/j_spring_security_logout" id="loginButton"><img src="${resourcePath}/img/login.png"><span>Logout</span></a>
		</sec:authorize>
		</div>
		<div class="clearfix"></div>
	</div>
	<div class="clearfix"></div>
</div>

<div class="banner">
	<div class="container_wrap">
		<h1>What are you looking for?</h1>
		<div class="dropdown-buttons">
			<div class="dropdown-button">
				<select class="dropdown" tabindex="9" data-settings='{"wrapperClass":"flat"}'>
					<option value="0">Music Album</option>
				</select>
			</div>
			<div class="dropdown-button">
				<select class="dropdown" tabindex="9" data-settings='{"wrapperClass":"flat"}'>
					<option value="0">Youtube</option>
				</select>
			</div>
		</div>
		<form>
			<input type="text" value="Keyword, name, date, ..." onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Keyword, name, date, ...';}" />
			<div class="contact_btn">
				<label class="btn1 btn-2 btn-2g">
				<input name="submit" type="submit" id="submit" value="Search">
				</label>
			</div>
		</form>
		<div class="clearfix"></div>
	</div>
</div>
<div class="content_top">
	<div class="container">
		<div class="col-md-4 bottom_nav">
			<div class="content_menu">
				<ul>
					<li class="active"><a href="#">Recommended</a></li>
					<li><a href="#">Latest</a></li>
					<li><a href="#">Highlights</a></li>
				</ul>
			</div>
		</div>
		<div class="col-md-4 content_dropdown1">
			<div class="content_dropdown">
				<select class="dropdown" tabindex="10" data-settings='{"wrapperClass":"metro"}'>
					<option value="0">Youtube</option>
				</select>
			</div>
			<div class="content_dropdown">
				<select class="dropdown" tabindex="10" data-settings='{"wrapperClass":"metro"}'>
					<option value="0">Roy</option>
				</select>
			</div>
		</div>
		<div class="col-md-4 filter_grid">
			<ul class="filter">
				<li class="fil">Filter :</li>
				<li><a href=""> <i class="icon1"> </i></a></li>
				<li><a href=""> <i class="icon2"> </i></a></li>
				<li><a href=""> <i class="icon3"> </i></a></li>
				<li><a href=""> <i class="icon4"> </i></a></li>
				<li><a href=""> <i class="icon5"> </i></a></li>
			</ul>
		</div>
	</div>
</div>
	
<div class="content_middle">
	<div class="container">
   		<div class="content_middle_box">
        	<!-- top 4 layout -->
        	<div class="top_grid">
        		<!-- top 4 layout item-->
	   			<div class="col-md-3" ng-repeat="album in publicMusicAlbum">
					<div class="grid1">
						<div class="view view-first">
							<div class="index_img1">
								<img src="${resourcePath}/img/pic6.jpg" class="img-responsive" alt="" />
							</div>
							<div class="mask" ng-click="clickAlbum(album.albumId)">
								<div class="info">
									<i class="search"> </i> Show More
								</div>
								<ul class="mask_img">
									<li class="star"><img src="${resourcePath}/img/star.png" alt="" /></li>
									<li class="set"><img src="${resourcePath}/img/set.png" alt="" /></li>
									<div class="clearfix"></div>
								</ul>
							</div>
						</div>
						<i class="home1"> </i>
						<div class="inner_wrap">
							<h3 class="ellipsis220" alt="{{album.title}}">{{album.title}}</h3>
							<ul class="star1">
								<h4 class="yellow">Youtube Album</h4>
								<li><a href="#"> <img src="${resourcePath}/img/star2.png" alt="">(136)</a></li>
							</ul>
						</div>
					</div>
				</div>
				<!-- top 4 layout item-->
   			<div class="clearfix"> </div>
   		</div>
   		<!-- top 4 layout -->
   	    <div class="middle_grid wow fadeInUp" data-wow-delay="0.4s">
   			<div class="col-md-6">
   			   <div class="grid1">
   			     <div class="index_img"><img src="${resourcePath}/img/pic4.jpg" class="img-responsive" alt=""/></div>
   				  <i class="m_home"> </i>
                  <ul class="vision">
                  	 <li>Vision Agency</li>
                  	 <li class="desc"><a href="#"> <img src="${resourcePath}/img/star1.png" alt="">(236)</a></li>
                  </ul>
   				  <div class="inner_wrap1">
   				 	<ul class="item_module">
   				 	 	<li class="module_left"><img src="${resourcePath}/img/m1.jpg" class="img-responsive" alt=""/></li>
   				 	 	<li class="module_right">
   				 	 		<img src="${resourcePath}/img/m_star.png" class="img-responsive" alt=""/>
   				 	 		<h5>Lucy-p</h5>
   				 	 		<p>"Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo consequat."</p>
   				 	 		<a href="#" class="content_btn">....read more</a>
   				 	 	</li>
   				 	 	<div class="clearfix"> </div>
   				 	 </ul>
   				  </div>
   			   </div>
   			</div>
   			<div class="col-md-6">
   			   <div class="grid1">
   			     <div class="index_img1"><img src="${resourcePath}/img/pic5.jpg" class="img-responsive" alt=""/></div>
   				  <i class="m_home1"> </i>
                  <ul class="vision">
                  	 <li>Vision Agency</li>
                  	 <li class="desc"><a href="#"> <img src="${resourcePath}/img/star2.png" alt="">(236)</a></li>
                  </ul>
   				  <div class="inner_wrap1">
   				 	<ul class="item_module">
   				 	 	<li class="module_left"><img src="${resourcePath}/img/m2.jpg" class="img-responsive" alt=""/></li>
   				 	 	<li class="module_right">
   				 	 		<img src="${resourcePath}/img/m_star1.png" class="img-responsive" alt=""/>
   				 	 		<h5>Lucy-p</h5>
   				 	 		<p>"Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo consequat."</p>
   				 	 		<a href="#" class="content_btn">....read more</a>
   				 	 	</li>
   				 	 	<div class="clearfix"> </div>
   				 	 </ul>
   				  </div>
   			   </div>
   			</div>
   			<div class="clearfix"> </div>
   		</div>
   		<div class="top_grid wow fadeInRight" data-wow-delay="0.4s">
   			<div class="col-md-3">
   			  <div class="grid1">
   				<div class="view view-first">
                  <div class="index_img"><img src="${resourcePath}/img/pic1.jpg" class="img-responsive" alt=""/></div>
   				     <div class="sale">$2.980</div>
   			          <div class="mask">
                       <div class="info"><i class="search"> </i> Show More</div>
                        <ul class="mask_img">
                        	<li class="star"><img src="${resourcePath}/img/star.png" alt=""/></li>
                        	<li class="set"><img src="${resourcePath}/img/set.png" alt=""/></li>
                        	<div class="clearfix"> </div>
                        </ul>
                        </div>
                    </div> 
                    <i class="home"></i>
   				 <div class="inner_wrap">
   				 	<h3>2 bedroom house for rent in Dubai</h3>
   				 	<ul class="star1">
   				 	  <h4 class="green">Vision Agency</h4>
   				 	  <li><a href="#"> <img src="${resourcePath}/img/star1.png" alt="">(236)</a></li>
   				 	</ul>
   				 </div>
   			   </div>
   			</div>
   			<div class="col-md-3">
   			  <div class="grid1">
   				<div class="view view-first">
                  <div class="index_img1"><img src="${resourcePath}/img/pic2.jpg" class="img-responsive" alt=""/></div>
   				     <div class="mask">
                        <div class="info"><i class="search"> </i> Show More</div>
                        <ul class="mask_img">
                        	<li class="star"><img src="${resourcePath}/img/star.png" alt=""/></li>
                        	<li class="set"><img src="${resourcePath}/img/set.png" alt=""/></li>
                        	<div class="clearfix"> </div>
                        </ul>
                      </div>
                  </div> 
                 <i class="home1"> </i>
   				 <div class="inner_wrap">
   				 	<h3>2 bedroom house for rent in Dubai</h3>
   				 	<ul class="star1">
   				 	  <h4 class="yellow">Vision Agency</h4>
   				 	  <li><a href="#"> <img src="${resourcePath}/img/star2.png" alt="">(136)</a></li>
   				 	</ul>
   				 </div>
   			   </div>
   			</div>
   			<div class="col-md-3">
   			  <div class="grid1">
   				<div class="view view-first">
                  <div class="index_img2"><img src="${resourcePath}/img/pic6.jpg" class="img-responsive" alt=""/></div>
   				     <div class="mask">
                        <div class="info"><i class="search"> </i> Show More</div>
                        <ul class="mask_img">
                        	<li class="star"><img src="${resourcePath}/img/star.png" alt=""/></li>
                        	<li class="set"><img src="${resourcePath}/img/set.png" alt=""/></li>
                        	<div class="clearfix"> </div>
                        </ul>
                      </div>
                  </div> 
                 <i class="home2"> </i>
   				 <div class="inner_wrap">
   				 	<h3>2 bedroom house for rent in Dubai</h3>
   				 	<ul class="star1">
   				 	  <h4 class="blue">Vision Agency</h4>
   				 	  <li><a href="#"> <img src="${resourcePath}/img/star2.png" alt="">(136)</a></li>
   				 	</ul>
   				 </div>
   			   </div>
   			</div>
   			<div class="col-md-3">
   			  <div class="grid1">
   				<div class="view view-first">
                  <div class="index_img"><img src="${resourcePath}/img/pic3.jpg" class="img-responsive" alt=""/></div>
   				     <div class="sale">$2.980</div>
   			          <div class="mask">
                      <div class="info"><i class="search"> </i> Show More</div>
                        <ul class="mask_img">
                        	<li class="star"><img src="${resourcePath}/img/star.png" alt=""/></li>
                        	<li class="set"><img src="${resourcePath}/img/set.png" alt=""/></li>
                        	<div class="clearfix"> </div>
                        </ul>
                      </div>
                  </div> 
                  <i class="home"></i>
   				  <div class="inner_wrap">
   				 	<h3>2 bedroom house for rent in Dubai</h3>
   				 	<ul class="star1">
   				 	  <h4 class="green">Vision Agency</h4>
   				 	  <li><a href="#"> <img src="${resourcePath}/img/star1.png" alt="">(236)</a></li>
   				 	</ul>
   				  </div>
   			   </div>
   			</div>
   			<div class="clearfix"> </div>
   		</div>
   		<div class="bottom_grid wow bounce" data-wow-delay="0.4s">
   		  <div class="col-md-6">
   			   <div class="grid1">
   			     <div class="index_img1"><img src="${resourcePath}/img/pic5.jpg" class="img-responsive" alt=""/></div>
   				  <i class="m_home1"> </i>
                  <ul class="vision">
                  	 <li>Vision Agency</li>
                  	 <li class="desc"><a href="#"> <img src="${resourcePath}/img/star2.png" alt="">(236)</a></li>
                  </ul>
   				  <div class="inner_wrap1">
   				 	<ul class="item_module">
   				 	 	<li class="module_left"><img src="${resourcePath}/img/m2.jpg" class="img-responsive" alt=""/></li>
   				 	 	<li class="module_right">
   				 	 		<img src="${resourcePath}/img/m_star.png" class="img-responsive" alt=""/>
   				 	 		<h5>Lucy-p</h5>
   				 	 		<p>"Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo consequat."</p>
   				 	 		<a href="#" class="content_btn">....read more</a>
   				 	 	</li>
   				 	 	<div class="clearfix"> </div>
   				 	 </ul>
   				  </div>
   			   </div>
   			</div>
   			<div class="col-md-3">
   			  <div class="grid1">
   				<div class="view view-first">
                  <div class="index_img"><img src="${resourcePath}/img/pic3.jpg" class="img-responsive" alt=""/></div>
   				     <div class="sale">$2.980</div>
   			          <div class="mask">
                      <div class="info"><i class="search"> </i> Show More</div>
                        <ul class="mask_img">
                        	<li class="star"><img src="${resourcePath}/img/star.png" alt=""/></li>
                        	<li class="set"><img src="${resourcePath}/img/set.png" alt=""/></li>
                        	<div class="clearfix"> </div>
                        </ul>
                      </div>
                  </div> 
                  <i class="b_home"></i>
   				  <div class="inner_wrap2">
   				 	<h3>2 bedroom house for rent in Dubai</h3>
   				 	<ul class="star1">
   				 	  <h4 class="green">Vision Agency</h4>
   				 	  <li><a href="#"> <img src="${resourcePath}/img/star1.png" alt="">(236)</a></li>
   				 	</ul>
   				  </div>
   			   </div>
   			</div>
   			<div class="col-md-3">
   			  <div class="grid1">
   				<div class="view view-first">
                  <div class="index_img1"><img src="${resourcePath}/img/pic2.jpg" class="img-responsive" alt=""/></div>
   				     <div class="mask">
                        <div class="info"><i class="search"> </i> Show More</div>
                        <ul class="mask_img">
                        	<li class="star"><img src="${resourcePath}/img/star.png" alt=""/></li>
                        	<li class="set"><img src="${resourcePath}/img/set.png" alt=""/></li>
                        	<div class="clearfix"> </div>
                        </ul>
                      </div>
                  </div> 
                 <i class="b_home1"> </i>
   				 <div class="inner_wrap2">
   				 	<h3>2 bedroom house for rent in Dubai</h3>
   				 	<ul class="star1">
   				 	  <h4 class="yellow">Vision Agency</h4>
   				 	  <li><a href="#"> <img src="${resourcePath}/img/star2.png" alt="">(136)</a></li>
   				 	</ul>
   				 </div>
   			   </div>
   			</div>
   			<div class="clearfix"></div>
   			</div>
   		  </div>
   		  <div class="offering">
   		  	  <h2>What can DuHoot offer to you ?</h2>
   		  	  <h3>Ut wisi enim ad minim veniam, quis</h3>
   		  	  <ul class="icons wow fadeInUp" data-wow-delay="0.4s">
   		  	  	 <li><i class="icon1"> </i><span class="one"> </span></li>
   		  	  	 <li><i class="icon2"> </i><span class="two"> </span></li>
   		  	  	 <li><i class="icon3"> </i><span class="three"> </span></li>
   		  	  	 <li><i class="icon4"> </i><span class="four"> </span></li>
   		  	  	 <li><i class="icon5"> </i></li>
   		  	  </ul>
   		  	  <div class="real">
   		  	  	<h4>Reality</h4>
   		  	  	<div class="col-sm-6">
   		  	  	  <ul class="service_grid">
   	   				<i class="s1"> </i>
   	   				 <li class="desc1 wow fadeInRight" data-wow-delay="0.4s">
   	   				   <p>Nam liber tempor cum soluta nobis eleifend option congue nihil imperdiet doming id quod mazim placerat facer possim assum. Typi non habent claritatem insitam; est usus legentis in iis qui facit eorum</p>
   	   				 </li>
   	   				 <div class="clearfix"> </div>
   	   			   </ul>
   	   			 </div>
   	   			 <div class="col-sm-6">
   		  	  	  <ul class="service_grid">
   	   				<i class="s2"> </i>
   	   				 <li class="desc1 wow fadeInRight" data-wow-delay="0.4s">
   	   				   <p>Nam liber tempor cum soluta nobis eleifend option congue nihil imperdiet doming id quod mazim placerat facer possim assum. Typi non habent claritatem insitam; est usus legentis in iis qui facit eorum</p>
   	   				 </li>
   	   				 <div class="clearfix"> </div>
   	   			   </ul>
   	   			 </div>
   	   			 <div class="clearfix"> </div>
   	   			 </div>
   		  	  </div>
   		  </div>
   	  </div>
   </div>
   <div class="footer">
   	<div class="container">
   	 <div class="footer_top">
   	   <h3>Subscribe to our newsletter</h3>
   	   <form>
		<span>
			<i><img src="${resourcePath}/img/mail.png" alt=""></i>
		    <input type="text" value="Enter your email" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Enter your email';}">
		    <label class="btn1 btn2 btn-2 btn-2g"> <input name="submit" type="submit" id="submit" value="Subscribe"> </label>
		    <div class="clearfix"> </div>
		</span>			 	    
	   </form>
	  </div>
	  <div class="footer_grids">
	     <div class="footer-grid">
			<h4>Ipsum Quis</h4>
			<ul class="list1">
				<li><a href="contact.html">Contact</a></li>
				<li><a href="#">Mirum est</a></li>
				<li><a href="#">placerat facer</a></li>
				<li><a href="#">claritatem</a></li>
				<li><a href="#">sollemnes </a></li>
			</ul>
		  </div>
		  <div class="footer-grid">
			<h4>Quis Ipsum</h4>
			<ul class="list1">
				<li><a href="#">placerat facer</a></li>
				<li><a href="#">claritatem</a></li>
				<li><a href="#">sollemnes </a></li>
				<li><a href="#">Claritas</a></li>
				<li><a href="#">Mirum est</a></li>
			</ul>
		  </div>
		  <div class="footer-grid last_grid">
			<h4>Follow Us</h4>
			<ul class="footer_social wow fadeInLeft" data-wow-delay="0.4s">
			  <li><a href=""> <i class="fb"> </i> </a></li>
			  <li><a href=""><i class="tw"> </i> </a></li>
			  <li><a href=""><i class="google"> </i> </a></li>
			  <li><a href=""><i class="u_tube"> </i> </a></li>
		 	</ul>
		 	<div class="copy wow fadeInRight" data-wow-delay="0.4s">
              <p>&copy; Template by <a href="http://w3layouts.com/" target="_blank">W3layouts</a> </p>
	        </div>
		  </div>
		  <div class="clearfix"> </div>
	   </div>
      </div>
   </div>
</body>
</html>