<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<c:set var="resourcesPath" value="${pageContext.request.contextPath}/resources/mvss"/>

<html ng-app="mvss-drama-view-app">
<head>
<title>Home</title>
<link href='http://fonts.googleapis.com/css?family=Oswald' rel='stylesheet' type='text/css'>
<link rel="stylesheet" href="${resourcesPath}/css/bootstrap.css">
<link rel="stylesheet" href="${resourcesPath}/css/bootstrap-responsive.css">
<link rel="stylesheet" href="${resourcesPath}/css/prettyPhoto.css" />
<link rel="stylesheet" href="${resourcesPath}/css/flexslider.css" />
<link rel="stylesheet" href="${resourcesPath}/css/custom-styles.css">

</head>

<body class="home">
	<div class="main-black-shadow"></div>
    <div class="headline">
        <div class="main-headline" ng-controller="ViewSlideCtl">
            <div class="flexslider">
              <ul class="slides">
                <li>
                	<a href="gallery-single.htm">
                		<img src="http://img.ental.com/main/54743cc6787ab.jpg" alt="slider" />
                	</a>
                	<div class="flex-caption">
						<div class="caption-container">
							<div class="text-container caption-one">
								<h1 class="flex-caption-h1">불한당</h1>
								<p class="flex-caption-p1"><필살기></p>
								<p class="flex-caption-p2">피말리는 그녀와 나의 전투가 벌어진다.</p>
								<p class="flex-caption-p3">사랑했지만 싸울수 밖에 없는 운명.</p>
								<p class="flex-caption-p4">드디어 그 운명의 종착이 결정된다.</p>
								<p class="flex-caption-p5">
									<rating ng-model="rate" max="max" readonly="isReadonly"></rating>
								</p>
							</div>
						</div>
					</div>
                </li>
              </ul>
            </div>
        </div>
    </div>
    
    <div class="span7 navigation" style="position: absolute; top: 0; left: 0; width: 100%; min-width: 1170px; height: 70px; z-index:2; margin-top:10px;">
	   <div class="navbar hidden-phone">
	   <ul class="nav">
	   <li class="dropdown active">
	        <a class="dropdown-toggle" data-toggle="dropdown" href="index.htm">Home <b class="caret"></b></a>
	        <ul class="dropdown-menu">
	            <li><a href="index.htm">Full Page</a></li>
	            <li><a href="index-gallery.htm">Gallery Only</a></li>
	            <li><a href="index-slider.htm">Slider Only</a></li>
	        </ul>
	    </li>
	   <li><a href="features.htm">Features</a></li>
	   <li class="dropdown">
	        <a class="dropdown-toggle" data-toggle="dropdown" href="page-full-width.htm">Pages <b class="caret"></b></a>
	        <ul class="dropdown-menu">
	            <li><a href="page-full-width.htm">Full Width</a></li>
	            <li><a href="page-right-sidebar.htm">Right Sidebar</a></li>
	            <li><a href="page-left-sidebar.htm">Left Sidebar</a></li>
	            <li><a href="page-double-sidebar.htm">Double Sidebar</a></li>
	        </ul>
	    </li>
	    <li class="dropdown">
	        <a class="dropdown-toggle" data-toggle="dropdown" href="gallery-4col.htm">Gallery <b class="caret"></b></a>
	        <ul class="dropdown-menu">
	            <li><a href="gallery-3col.htm">Gallery 3 Column</a></li>
	            <li><a href="gallery-4col.htm">Gallery 4 Column</a></li>
	            <li><a href="gallery-6col.htm">Gallery 6 Column</a></li>
	            <li><a href="gallery-4col-circle.htm">Gallery 4 Round</a></li>
	            <li><a href="gallery-single.htm">Gallery Single</a></li>
	        </ul>
	    </li>
	    <li class="dropdown">
	        <a class="dropdown-toggle" data-toggle="dropdown" href="blog-style1.htm">Blog <b class="caret"></b></a>
	        <ul class="dropdown-menu">
	            <li><a href="blog-style1.htm">Blog Style 1</a></li>
	            <li><a href="blog-style2.htm">Blog Style 2</a></li>
	            <li><a href="blog-style3.htm">Blog Style 3</a></li>
	            <li><a href="blog-style4.htm">Blog Style 4</a></li>
	            <li><a href="blog-single.htm">Blog Single</a></li>
	        </ul>
	    </li>
	    <li><a href="page-contact.htm">Contact</a></li>
	    </ul>
	   
	    </div>
	
	    <!-- Mobile Nav
	    ================================================== -->
	    <form action="#" id="mobile-nav" class="visible-phone">
	        <div class="mobile-nav-select">
	        <select onchange="window.open(this.options[this.selectedIndex].value,'_top')">
	            <option value="">Navigate...</option>
	            <option value="index.htm">Home</option>
	                <option value="index.htm">- Full Page</option>
	                <option value="index-gallery.htm">- Gallery Only</option>
	                <option value="index-slider.htm">- Slider Only</option>
	            <option value="features.htm">Features</option>
	            <option value="page-full-width.htm">Pages</option>
	                <option value="page-full-width.htm">- Full Width</option>
	                <option value="page-right-sidebar.htm">- Right Sidebar</option>
	                <option value="page-left-sidebar.htm">- Left Sidebar</option>
	                <option value="page-double-sidebar.htm">- Double Sidebar</option>
	            <option value="gallery-4col.htm">Gallery</option>
	                <option value="gallery-3col.htm">- 3 Column</option>
	                <option value="gallery-4col.htm">- 4 Column</option>
	                <option value="gallery-6col.htm">- 6 Column</option>
	                <option value="gallery-4col-circle.htm">- Gallery 4 Col Round</option>
	                <option value="gallery-single.htm">- Gallery Single</option>
	            <option value="blog-style1.htm">Blog</option>
	                <option value="blog-style1.htm">- Blog Style 1</option>
	                <option value="blog-style2.htm">- Blog Style 2</option>
	                <option value="blog-style3.htm">- Blog Style 3</option>
	                <option value="blog-style4.htm">- Blog Style 4</option>
	                <option value="blog-single.htm">- Blog Single</option>
	            <option value="page-contact.htm">Contact</option>
	        </select>
	        </div>
		</form>
    </div>
        
    <div class="container">
    
    <div class="row">

        <!-- Gallery Items
        ================================================== --> 
        <div class="span12 gallery-single">

            <div class="row">
                <div class="span6">
                    <img src="${pageContext.request.contextPath}/resources/mvss/img/gallery/gallery-img-1-full.jpg" class="align-left thumbnail" alt="image">
                </div>
                <div class="span6">
                    <h2>Custom Illustration</h2>
                    <p class="lead">For an international ad campaign. Nulla iaculis mattis lorem, quis gravida nunc iaculis ac. Proin tristique tellus in est vulputate luctus</p>
                    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla iaculis mattis lorem, quis gravida nunc iaculis ac. Proin tristique tellus in est vulputate luctus fermentum ipsum molestie. Vivamus tincidunt sem eu magna varius elementum. Maecenas felis tellus, fermentum vitae laoreet vitae, volutpat et urna. Nulla faucibus ligula eget ante varius ac euismod odio placerat. Nam sit amet felis non lorem faucibus rhoncus vitae id dui.</p>

                    <ul class="project-info">
                        <li><h6>Date:</h6> 09/12/15</li>
                        <li><h6>Client:</h6> John Doe, Inc.</li>
                        <li><h6>Services:</h6> Design, Illustration</li>
                        <li><h6>Art Director:</h6> Jane Doe</li>
                        <li><h6>Designer:</h6> Jimmy Doe</li>
                    </ul>

                    <button class="btn btn-inverse pull-left" type="button">Visit Website</button>
                    <a href="#" class="pull-right"><i class="icon-arrow-left"></i>Back to Gallery</a>
                </div>
            </div>

        </div><!-- End gallery-single-->

    </div><!-- End container row -->
    
    <div class="row gallery-row"><!-- Begin Gallery Row --> 
      
    	<div class="span12">
            <h5 class="title-bg">[추천] 
                <small>드라마 인기차트 Best8 </small>
                <button class="btn btn-mini btn-inverse hidden-phone" type="button">더보기</button>
            </h5>
    	
        <!-- Gallery Thumbnails
        ================================================== -->

            <div class="row clearfix no-margin">
            <ul class="gallery-post-grid holder">

                    <!-- Gallery Item 1 -->
                    <li class="span3 gallery-item" data-id="id-1" data-type="illustration">
                        <span class="gallery-hover-4col hidden-phone hidden-tablet">
                            <span class="gallery-icons">
                                <a href="${resourcesPath}/img/gallery/gallery-img-1-full.jpg" class="item-zoom-link lightbox" title="Custom Illustration" data-rel="prettyPhoto"></a>
                                <a href="gallery-single.htm" class="item-details-link"></a>
                            </span>
                        </span>
                        <a href="gallery-single.htm"><img src="http://img.ental.com/resize_216x311/movie/04/61/74_p1.jpg" alt="Gallery" class="main-gallery-col4"></a>
                        <span class="project-details"><a href="gallery-single.htm">우리는 형제입니다.</a>티격대던 형제는 로또 복권에 같이 당첨되는데...</span>
                    </li>

                    <!-- Gallery Item 2 -->
                    <li class="span3 gallery-item" data-id="id-2" data-type="illustration">
                        <span class="gallery-hover-4col hidden-phone hidden-tablet">
                            <span class="gallery-icons">
                                <a href="${resourcesPath}/img/gallery/gallery-img-1-full.jpg" class="item-zoom-link lightbox" title="Custom Illustration" data-rel="prettyPhoto"></a>
                                <a href="gallery-single.htm" class="item-details-link"></a>
                            </span>
                        </span>
                        <a href="gallery-single.htm"><img src="http://img.ental.com/resize_216x311/movie/04/61/74_p1.jpg" alt="Gallery" class="main-gallery-col4"></a>
                        <span class="project-details"><a href="gallery-single.htm">3 Color Poster Design</a>For a regional festival event.</span>
                    </li>

                    <!-- Gallery Item 3 -->
                    <li class="span3 gallery-item" data-id="id-3" data-type="web">
                        <span class="gallery-hover-4col hidden-phone hidden-tablet">
                            <span class="gallery-icons">
                                <a href="${resourcesPath}/img/gallery/gallery-img-1-full.jpg" class="item-zoom-link lightbox" title="Custom Illustration" data-rel="prettyPhoto"></a>
                                <a href="#" class="item-details-link"></a>
                            </span>
                        </span>
                        <a href="gallery-single.htm"><img src="http://img.ental.com/resize_216x311/movie/04/61/74_p1.jpg" alt="Gallery" class="main-gallery-col4"></a>
                        <span class="project-details"><a href="gallery-single.htm">Ink Pen Illustration</a>Created for a best selling children's book.</span>
                    </li>

                    <!-- Gallery Item 4 -->
                    <li class="span3 gallery-item" data-id="id-4" data-type="video">
                        <span class="gallery-hover-4col hidden-phone hidden-tablet">
                            <span class="gallery-icons">
                                <a href="${resourcesPath}/img/gallery/gallery-img-1-full.jpg" class="item-zoom-link lightbox" title="Custom Illustration" data-rel="prettyPhoto"></a>
                                <a href="gallery-single.htm" class="item-details-link"></a>
                            </span>
                        </span>
                        <a href="gallery-single.htm"><img src="http://img.ental.com/resize_216x311/movie/04/61/74_p1.jpg" alt="Gallery" class="main-gallery-col4"></a>
                        <span class="project-details"><a href="gallery-single.htm">Custom Illustration</a>For an international add campaign.</span>
                    </li>

                    <!-- Gallery Item 5 -->
                    <li class="span3 gallery-item" data-id="id-5" data-type="web illustration">
                        <span class="gallery-hover-4col hidden-phone hidden-tablet">
                            <span class="gallery-icons">
                                <a href="${resourcesPath}/img/gallery/gallery-img-1-full.jpg" class="item-zoom-link lightbox" title="Custom Illustration" data-rel="prettyPhoto"></a>
                                <a href="gallery-single.htm" class="item-details-link"></a>
                            </span>
                        </span>
                        <a href="gallery-single.htm"><img src="http://img.ental.com/resize_216x311/movie/04/61/74_p1.jpg" alt="Gallery" class="main-gallery-col4"></a>
                        <span class="project-details"><a href="gallery-single.htm">Icon1 Design</a>Classic retro style illustration.</span>
                    </li>

                    <!-- Gallery Item 6 -->
                    <li class="span3 gallery-item" data-id="id-6" data-type="illustration design">
                        <span class="gallery-hover-4col hidden-phone hidden-tablet">
                            <span class="gallery-icons">
                                <a href="${resourcesPath}/img/gallery/gallery-img-1-full.jpg" class="item-zoom-link lightbox" title="Custom Illustration" data-rel="prettyPhoto"></a>
                                <a href="gallery-single.htm" class="item-details-link"></a>
                            </span>
                        </span>
                        <a href="gallery-single.htm"><img src="http://img.ental.com/resize_216x311/movie/04/61/74_p1.jpg" alt="Gallery" class="main-gallery-col4"></a>
                        <span class="project-details"><a href="gallery-single.htm">Animation Cell</a>Creative storyboard illustration</span>
                    </li>

                    <!-- Gallery Item 7 -->
                    <li class="span3 gallery-item" data-id="id-7" data-type="design">
                        <span class="gallery-hover-4col hidden-phone hidden-tablet">
                            <span class="gallery-icons">
                                <a href="${resourcesPath}/img/gallery/gallery-img-1-full.jpg" class="item-zoom-link lightbox" title="Custom Illustration" data-rel="prettyPhoto"></a>
                                <a href="gallery-single.htm" class="item-details-link"></a>
                            </span>
                        </span>
                        <a href="gallery-single.htm"><img src="http://img.ental.com/resize_216x311/movie/04/61/74_p1.jpg" alt="Gallery" class="main-gallery-col4"></a>
                        <span class="project-details"><a href="gallery-single.htm">Poster Ad Campaign</a>Regional ad for a local company.</span>
                    </li>

                    <!-- Gallery Item 8 -->
                    <li class="span3 gallery-item" data-id="id-8" data-type="web video">
                        <span class="gallery-hover-4col hidden-phone hidden-tablet">
                            <span class="gallery-icons">
                                <a href="${resourcesPath}/img/gallery/gallery-img-1-full.jpg" class="item-zoom-link lightbox" title="Custom Illustration" data-rel="prettyPhoto"></a>
                                <a href="gallery-single.htm" class="item-details-link"></a>
                            </span>
                        </span>
                        <a href="gallery-single.htm"><img src="http://img.ental.com/resize_216x311/movie/04/61/74_p1.jpg" alt="Gallery" class="main-gallery-col4"></a>
                        <span class="project-details"><a href="gallery-single.htm">Magazine Ad</a>For an international add campaign.</span>
                    </li>
                </ul>
                </div>
            </div>
 
    </div><!-- End Gallery Row -->
    
    <div class="row"><!-- Begin Bottom Section -->
    
    	<!-- Blog Preview
        ================================================== -->
    	<div class="span6">

            <h5 class="title-bg">From the Blog 
                <small>All the latest news</small>
                <button id="btn-blog-next" class="btn btn-inverse btn-mini" type="button">&raquo;</button>
                <button id="btn-blog-prev" class="btn btn-inverse btn-mini" type="button">&laquo;</button>
            </h5>

        <div id="blogCarousel" class="carousel slide ">
            <div class="carousel-inner">

                 <!-- Blog Item 1 -->
                <div class="active item">
                    <a href="blog-single.htm"><img src="${resourcesPath}/img/gallery/blog-med-img-1.jpg" alt="" class="align-left blog-thumb-preview" /></a>
                    <div class="post-info clearfix">
                        <h4><a href="blog-single.htm">A subject that is beautiful in itself</a></h4>
                        <ul class="blog-details-preview">
                            <li><i class="icon-calendar"></i><strong>Posted on:</strong> Sept 4, 2015<li>
                            <li><i class="icon-user"></i><strong>Posted by:</strong> <a href="#" title="Link">Admin</a><li>
                            <li><i class="icon-comment"></i><strong>Comments:</strong> <a href="#" title="Link">12</a><li>
                            <li><i class="icon-tags"></i> <a href="#">photoshop</a>, <a href="#">tutorials</a>, <a href="#">illustration</a>
                        </ul>
                    </div>
                    <p class="blog-summary">Lorem ipsum dolor sit amet, consectetur adipiscing elit. In interdum felis fermentum ipsum molestie sed porttitor ligula rutrum. Vestibulum lectus tellus, aliquet et iaculis sed, volutpat vel erat. <a href="#">Read more</a><p>
                </div>

                <!-- Blog Item 2 -->
                 <div class="item">
                    <a href="blog-single.htm"><img src="${resourcesPath}/img/gallery/blog-med-img-1.jpg" alt="" class="align-left blog-thumb-preview" /></a>
                    <div class="post-info clearfix">
                        <h4><a href="blog-single.htm">A great artist is always before his time</a></h4>
                        <ul class="blog-details-preview">
                            <li><i class="icon-calendar"></i><strong>Posted on:</strong> Sept 4, 2015<li>
                            <li><i class="icon-user"></i><strong>Posted by:</strong> <a href="#" title="Link">Admin</a><li>
                            <li><i class="icon-comment"></i><strong>Comments:</strong> <a href="#" title="Link">12</a><li>
                            <li><i class="icon-tags"></i> <a href="#">photoshop</a>, <a href="#">tutorials</a>, <a href="#">illustration</a>
                        </ul>
                    </div>
                    <p class="blog-summary">Lorem ipsum dolor sit amet, consectetur adipiscing elit. In interdum felis fermentum ipsum molestie sed porttitor ligula rutrum. Vestibulum lectus tellus, aliquet et iaculis sed, volutpat vel erat. <a href="#">Read more</a><p>
                </div>

                 <!-- Blog Item 3 -->
                 <div class="item">
                    <a href="blog-single.htm"><img src="${resourcesPath}/img/gallery/blog-med-img-1.jpg" alt="" class="align-left blog-thumb-preview" /></a>
                    <div class="post-info clearfix">
                        <h4><a href="blog-single.htm">Is art everything to anybody?</a></h4>
                        <ul class="blog-details-preview">
                            <li><i class="icon-calendar"></i><strong>Posted on:</strong> Sept 4, 2015<li>
                            <li><i class="icon-user"></i><strong>Posted by:</strong> <a href="#" title="Link">Admin</a><li>
                            <li><i class="icon-comment"></i><strong>Comments:</strong> <a href="#" title="Link">12</a><li>
                            <li><i class="icon-tags"></i> <a href="#">photoshop</a>, <a href="#">tutorials</a>, <a href="#">illustration</a>
                        </ul>
                    </div>
                    <p class="blog-summary">Lorem ipsum dolor sit amet, consectetur adipiscing elit. In interdum felis fermentum ipsum molestie sed porttitor ligula rutrum. Vestibulum lectus tellus, aliquet et iaculis sed, volutpat vel erat. <a href="#">Read more</a><p>
                </div>
                
            </div>
            </div> 	
        </div>
        
        <!-- Client Area
        ================================================== -->
        <div class="span6">

            <h5 class="title-bg">Recent Clients
                <small>That love us</small>
                <button id="btn-client-next" class="btn btn-inverse btn-mini" type="button">&raquo;</button>
                <button id="btn-client-prev" class="btn btn-inverse btn-mini" type="button">&laquo;</button>
            </h5>

            <!-- Client Testimonial Slider-->
            <div id="clientCarousel" class="carousel slide no-margin">
            <!-- Carousel items -->
            <div class="carousel-inner">

                <div class="active item">
                    <p class="quote-text">"Lorem ipsum dolor sit amet, consectetur adipiscing elit. In interdum felis fermentum ipsum molestie sed porttitor ligula rutrum. Morbi blandit ultricies ultrices. Vivamus nec lectus sed orci molestie molestie."<cite>- Client Name, Big Company</cite></p>
                </div>

                <div class="item">
                    <p class="quote-text">"Adipiscing elit. In interdum felis fermentum ipsum molestie sed porttitor ligula rutrum. Morbi blandit ultricies ultrices. Vivamus nec lectus sed orci molestie molestie."<cite>- Another Client Name, Company Name</cite></p>
                </div>

                <div class="item">
                    <p class="quote-text">"Mauris eget tellus sem. Cras sollicitudin sem eu elit aliquam quis condimentum nulla suscipit. Nam sed magna ante. Ut eget suscipit mauris."<cite>- On More Client, The Company</cite></p>
                </div>
                
            </div>
            </div>

            <!-- Client Logo Thumbs-->
            <ul class="client-logos">
                <li><a href="#" class="client-link"><img src="${resourcesPath}/img/gallery/client-img-1.png" alt="Client"></a></li>
                <li><a href="#" class="client-link"><img src="${resourcesPath}/img/gallery/client-img-2.png" alt="Client"></a></li>
                <li><a href="#" class="client-link"><img src="${resourcesPath}/img/gallery/client-img-3.png" alt="Client"></a></li>
                <li><a href="#" class="client-link"><img src="${resourcesPath}/img/gallery/client-img-4.png" alt="Client"></a></li>
                <li><a href="#" class="client-link"><img src="${resourcesPath}/img/gallery/client-img-5.png" alt="Client"></a></li>
            </ul>

        </div>
        
    </div><!-- End Bottom Section -->
    
    </div> <!-- End Container -->

    <!-- Footer Area
        ================================================== -->

	<div class="footer-container"><!-- Begin Footer -->
    	<div class="container">
        	<div class="row footer-row">
                <div class="span3 footer-col">
                    <h5>About Us</h5>
                   <img src="${resourcesPath}/img/piccolo-footer-logo.png" alt="Piccolo" /><br /><br />
                    <address>
                        <strong>Design Team</strong><br />
                        123 Main St, Suite 500<br />
                        New York, NY 12345<br />
                    </address>
                    <ul class="social-icons">
                        <li><a href="#" class="social-icon facebook"></a></li>
                        <li><a href="#" class="social-icon twitter"></a></li>
                        <li><a href="#" class="social-icon dribble"></a></li>
                        <li><a href="#" class="social-icon rss"></a></li>
                        <li><a href="#" class="social-icon forrst"></a></li>
                    </ul>
                </div>
                <div class="span3 footer-col">
                    <h5>Latest Tweets</h5>
                    <ul>
                        <li><a href="#">@room122</a> Lorem ipsum dolor sit amet, consectetur adipiscing elit.</li>
                        <li><a href="#">@room122</a> In interdum felis fermentum ipsum molestie sed porttitor ligula rutrum. Morbi blandit ultricies ultrices.</li>
                        <li><a href="#">@room122</a> Vivamus nec lectus sed orci molestie molestie. Etiam mattis neque eu orci rutrum aliquam.</li>
                    </ul>
                </div>
                <div class="span3 footer-col">
                    <h5>Latest Posts</h5>
                     <ul class="post-list">
                        <li><a href="#">Lorem ipsum dolor sit amet</a></li>
                        <li><a href="#">Consectetur adipiscing elit est lacus gravida</a></li>
                        <li><a href="#">Lectus sed orci molestie molestie etiam</a></li>
                        <li><a href="#">Mattis consectetur adipiscing elit est lacus</a></li>
                        <li><a href="#">Cras rutrum, massa non blandit convallis est</a></li>
                    </ul>
                </div>
                <div class="span3 footer-col">
                    <h5>Flickr Photos</h5>
                    <ul class="img-feed">
                        <li><a href="#"><img src="${resourcesPath}/img/gallery/flickr-img-1.jpg" alt="Image Feed"></a></li>
                        <li><a href="#"><img src="${resourcesPath}/img/gallery/flickr-img-1.jpg" alt="Image Feed"></a></li>
                        <li><a href="#"><img src="${resourcesPath}/img/gallery/flickr-img-1.jpg" alt="Image Feed"></a></li>
                        <li><a href="#"><img src="${resourcesPath}/img/gallery/flickr-img-1.jpg" alt="Image Feed"></a></li>
                        <li><a href="#"><img src="${resourcesPath}/img/gallery/flickr-img-1.jpg" alt="Image Feed"></a></li>
                        <li><a href="#"><img src="${resourcesPath}/img/gallery/flickr-img-1.jpg" alt="Image Feed"></a></li>
                        <li><a href="#"><img src="${resourcesPath}/img/gallery/flickr-img-1.jpg" alt="Image Feed"></a></li>
                        <li><a href="#"><img src="${resourcesPath}/img/gallery/flickr-img-1.jpg" alt="Image Feed"></a></li>
                        <li><a href="#"><img src="${resourcesPath}/img/gallery/flickr-img-1.jpg" alt="Image Feed"></a></li>
                        <li><a href="#"><img src="${resourcesPath}/img/gallery/flickr-img-1.jpg" alt="Image Feed"></a></li>
                        <li><a href="#"><img src="${resourcesPath}/img/gallery/flickr-img-1.jpg" alt="Image Feed"></a></li>
                        <li><a href="#"><img src="${resourcesPath}/img/gallery/flickr-img-1.jpg" alt="Image Feed"></a></li>
                    </ul>
                </div>
            </div>

            <div class="row"><!-- Begin Sub Footer -->
                <div class="span12 footer-col footer-sub">
                    <div class="row no-margin">
                        <div class="span6"><span class="left">Copyright 2012 Piccolo Theme. All rights reserved.</span></div>
                        <div class="span6">
                            <span class="right">
                            <a href="#">Home</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;<a href="#">Features</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;<a href="#">Gallery</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;<a href="#">Blog</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;<a href="#">Contact</a>
                            </span>
                        </div>
                    </div>
                </div>
            </div><!-- End Sub Footer -->

        </div>
    </div><!-- End Footer --> 
    
    <!-- Scroll to Top -->  
    <div id="toTop" class="hidden-phone hidden-tablet">Back to Top</div>

<script src="http://code.jquery.com/jquery-latest.js"></script>
<script src="${resourcesPath}/js/bootstrap.js"></script>
<script src="${resourcesPath}/js/jquery.prettyPhoto.js"></script>
<script src="${resourcesPath}/js/jquery.flexslider.js"></script>
<script src="${resourcesPath}/js/jquery.custom.js"></script>
<script src="${resourcesPath}/js/angular.min.js"></script>
<script src="${resourcesPath}/js/ui-bootstrap-tpls-0.12.0.min.js"></script>

<!-- mvss scripts -->
<script src="${resourcesPath}/angjs/mvss-drama.js"></script>

<script type="text/javascript">

$(document).ready(function () {
	$("#btn-blog-next").click(function () {
	  	$('#blogCarousel').carousel('next')
	});
	
  	$("#btn-blog-prev").click(function () {
    	$('#blogCarousel').carousel('prev')
  	});
  
  	$("#btn-client-next").click(function () {
    	$('#clientCarousel').carousel('next')
  	});
  
  	$("#btn-client-prev").click(function () {
      	$('#clientCarousel').carousel('prev')
  	});
});

$(window).load(function(){
	$('.flexslider').flexslider({
	  	animation: "slide",
	    animationSpeed: 1500,
	    start: function(slider){
	    	$('body').removeClass('loading');
	    }
    });  
});

</script>
</body>
</html>
