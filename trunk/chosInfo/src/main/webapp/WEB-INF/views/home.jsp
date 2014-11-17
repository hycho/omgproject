<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>


<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<c:set var="resourcesPath" value="${pageContext.request.contextPath}/resources"/>
<!doctype html>
<!--[if IE 7 ]>    <html lang="en-gb" class="isie ie7 oldie no-js"> <![endif]-->
<!--[if IE 8 ]>    <html lang="en-gb" class="isie ie8 oldie no-js"> <![endif]-->
<!--[if IE 9 ]>    <html lang="en-gb" class="isie ie9 no-js"> <![endif]-->
<!--[if (gt IE 9)|!(IE)]><!-->
<html class="no-js">
<!--<![endif]-->
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <!--[if lt IE 9]> 
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <![endif]-->
    <title>Cho's Profile - Developer</title>
    <meta name="description" content="">
    <meta name="author" content="WebThemez">
    <!--[if lt IE 9]>
        <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->
    <!--[if lte IE 8]>
		<script type="text/javascript" src="http://explorercanvas.googlecode.com/svn/trunk/excanvas.js"></script>
	<![endif]-->
    <link rel="stylesheet" href="${resourcesPath}/css/bootstrap.min.css" />
    <link rel="stylesheet" type="text/css" href="${resourcesPath}/css/isotope.css" media="screen" />
    <link rel="stylesheet" href="${resourcesPath}/js/fancybox/jquery.fancybox.css" type="text/css" media="screen" />
    <link rel="stylesheet" type="text/css" href="${resourcesPath}/css/da-slider.css" />
    <!-- Owl Carousel Assets -->
    <link href="${resourcesPath}/js/owl-carousel/owl.carousel.css" rel="stylesheet">
    <link rel="stylesheet" href="${resourcesPath}/css/styles.css" />
    <!-- Font Awesome -->
    <link href="${resourcesPath}/font/css/font-awesome.min.css" rel="stylesheet">
</head>

<body>
    <header class="header">
        <div class="container">
            <nav class="navbar navbar-inverse" role="navigation">
                <div class="navbar-header">
                    <button type="button" id="nav-toggle" class="navbar-toggle" data-toggle="collapse" data-target="#main-nav">
                        <span class="sr-only"><spring:message code="message.text.Tn" text="" /></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a href="#" class="navbar-brand scroll-top logo"><b><spring:message code="message.text.myprofile" text="" /></b></a>
                </div>
                <!--/.navbar-header-->
                <div id="main-nav" class="collapse navbar-collapse">
                    <ul class="nav navbar-nav" id="mainNav">
                        <li class="active"><a href="#home" class="scroll-link"><spring:message code="message.text.home" text="" /></a></li>
                        <li><a href="#aboutUs" class="scroll-link"><spring:message code="message.text.aboutUs" text="" /></a></li>
                        <li><a href="#skills" class="scroll-link"><spring:message code="message.text.skills" text="" /></a></li>
                        <li><a href="#experience" class="scroll-link"><spring:message code="message.text.experience" text="" /></a></li>
                        <li><a href="#portfolio" class="scroll-link"><spring:message code="message.text.portfolio" text="" /></a></li>
                        <li><a href="#contactUs" class="scroll-link"><spring:message code="message.text.contactUs" text="" /></a></li>
                    </ul>
                </div>
                <!--/.navbar-collapse-->
            </nav>
            <!--/.navbar-->
        </div>
        <!--/.container-->
    </header>
    <!--/.header-->
    <div id="#top"></div>
    <section id="home">
        <div class="banner-container">
            <img src="${resourcesPath}/images/banner-bg.jpg" alt="banner" />
            <div class="container banner-content">
                <div id="da-slider" class="da-slider">
                    <div class="da-slide">
                        <h2><spring:message code="message.text.javaDeveloper" text="" /></h2>
                        <p><spring:message code="message.text.javaDeveloperSen" text="" /></p>
                        <div class="da-img"></div>
                    </div>
                    <div class="da-slide">
                        <h2><spring:message code="message.text.serverEngineer" text="" /></h2>
                        <p><spring:message code="message.text.serverEngineerSen" text="" /></p>
                        <div class="da-img"></div>
                    </div>
                    <div class="da-slide">
                        <h2><spring:message code="message.text.webDeveloper" text="" /></h2>
                        <p><spring:message code="message.text.webDeveloperSen" text="" /></p>
                        <div class="da-img"></div>
                    </div>
                    <div class="da-slide">
                        <h2><spring:message code="message.text.systemArchitecture" text="" /></h2>
                        <p><spring:message code="message.text.systemArchitectureSen" text="" /></p>
                        <div class="da-img"></div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <section id="introText">
        <div class="container">
            <div class="text-center">
            <h1><spring:message code="message.text.introText.intro" text="" /></h1>
              <p><spring:message code="message.text.introText.introSen" text="" /></p>
            </div>
        </div>

    </section>
    <!--About-->
    <section id="aboutUs" class="secPad">
        <div class="container">
            <div class="heading text-center">
                <!-- Heading -->
                <h2><spring:message code="message.text.aboutUs.intro" text="" /></h2>
                <p><spring:message code="message.text.aboutUs.introSen" text="" /></p>
            </div>
            <div class="row">
                <!-- item -->
                <div class="col-md-4 text-center tileBox">
                   <div class="txtHead"> <i class="fa fa-desktop"></i>
                    <h3><spring:message code="message.text.java" text="" /> <span class="id-color"><spring:message code="message.text.language" text="" /></span></h3></div>
                    <p><spring:message code="message.text.languageSen" text="" /></p>
                </div>
                <!-- end: -->

                <!-- item -->
                <div class="col-md-4 text-center tileBox">
                    <div class="txtHead"><i class="fa fa-css3"></i>
                    <h3>HTML5/Javascript <span class="id-color">Dev</span></h3></div>
                    <p>Html5, Javascript, Jquery, AngularJs등 관련 기술을 통해서 동적인 아름다운 화면을 구현하는 것을 해왔으며 현재도 누구든지 생각하고 존재하지만 색다른 것을 구현하기 위해 열심히 달려가는 중입니다.</p>
                </div>
                <!-- end: -->

                <!-- item -->
                <div class="col-md-4 text-center tileBox">
                    <div class="txtHead"><i class="fa fa-lightbulb-o"></i>
                    <h3>Oracle/MySql <span class="id-color">DataBase</span></h3></div>
                    <p>주 DataBase는 Oracle이며 Mysql도 사용할 수 있습니다, 특정 서비스에 따른 모델링도 직접하며 검색에 관한 Index를 생성하고 퍼포먼스 있는 환경을 구성합니다.</p>
                </div>
                <!-- end: -->
            </div>
        </div>
    </section>
    <!--Quote-->
    <section id="quote" class="bg-parlex">
        <div class="parlex-back">
            <div class="container secPad text-center">
				<h2>If I asked people what they wanted, they would have said ‘Faster Horses’.</h2><h3>-Henry Ford</h3>
            </div>
            <!--/.container-->
        </div>
    </section>
    
    <!--Skills-->
    <section id="skills" class="secPad white">
    	<div class="container">
        <div class="heading text-center">
                <!-- Heading -->
                <h2>My Skills</h2>
                <p>Lorem ipsum dolor sit amet, consectetur adipiscing</p>
            </div>
        	<div class="row">
                <div class="col-sm-6">
                    <h2>Programming <strong>Skills</strong></h2>
                    <p class="mrgBtm20">
                        It takes knowledge, smart work, and dedication to make great ideas come to life. I have been helping make great ideas happen for the past 7 years and am always ready for new challenges.
                
                    </p>
                    <div class="row">
                        <div class="col-md-2 skilltitle">HTML5</div>
                        <div class="col-md-8">
                            <div class="progress">
                                <div class="progress-bar" role="progressbar" aria-valuenow="90" aria-valuemin="0" aria-valuemax="100" style="width: 90%;">
                                    <span class="sr-only">90% Complete</span>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-2 skilltitle">CSS/CC3</div>
                        <div class="col-md-8">
                            <div class="progress">
                                <div class="progress-bar" role="progressbar" aria-valuenow="90" aria-valuemin="0" aria-valuemax="100" style="width: 90%;">
                                    <span class="sr-only">90% Complete</span>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-2 skilltitle">JavaScript</div>
                        <div class="col-md-8">
                            <div class="progress">
                                <div class="progress-bar" role="progressbar" aria-valuenow="80" aria-valuemin="0" aria-valuemax="100" style="width: 80%;">
                                    <span class="sr-only">80% Complete</span>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-2 skilltitle">jQuery/Ajax</div>
                        <div class="col-md-8">
                            <div class="progress">
                                <div class="progress-bar" role="progressbar" aria-valuenow="90" aria-valuemin="0" aria-valuemax="100" style="width: 90%;">
                                    <span class="sr-only">90% Complete</span>
                                </div>
                            </div>
                        </div>
                    </div>      
                </div>
                <div class="col-sm-6">
                    <h2>Designing <strong>Skills</strong></h2>
                    <p class="mrgBtm20">
                        Problem solving is not always about sitting in a board room talking about the way things should be done. I have a strong background in UI design which allows me to think on my feet and act upon it.
                
                    </p>
                    <div class="row">
                        <div class="col-md-2 skilltitle">Photoshop</div>
                        <div class="col-md-8">
                            <div class="progress">
                                <div class="progress-bar" role="progressbar" aria-valuenow="90" aria-valuemin="0" aria-valuemax="100" style="width: 90%;">
                                    <span class="sr-only">90% Complete</span>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-2 skilltitle">Illustrator</div>
                        <div class="col-md-8">
                            <div class="progress">
                                <div class="progress-bar" role="progressbar" aria-valuenow="80" aria-valuemin="0" aria-valuemax="100" style="width: 80%;">
                                    <span class="sr-only">80% Complete</span>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-2 skilltitle">Indesign</div>
                        <div class="col-md-8">
                            <div class="progress">
                                <div class="progress-bar" role="progressbar" aria-valuenow="75" aria-valuemin="0" aria-valuemax="100" style="width: 75%;">
                                    <span class="sr-only">75% Complete</span>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>        
    </section>
    
    <!--Experience-->
    <section id="experience" class="secPad">
    	<div class="container">     
           <div class="heading text-center">
                <!-- Heading -->
                <h2>Professional Experience</h2>
                <p>Lorem ipsum dolor sit amet, consectetur adipiscing</p>
            </div>
        <div id="timeline"><div class="row timeline-movement timeline-movement-top">
        <div class="timeline-badge timeline-future-movement">
            <a href="#">
                <span class="glyphicon glyphicon-plus"></span>
            </a>
        </div>
        <div class="timeline-badge timeline-filter-movement">
            <a href="#">
                <span class="glyphicon glyphicon-time"></span>
            </a>
        </div>
    
    </div>
    <div class="row timeline-movement">
    
        <div class="timeline-badge">
            <span class="timeline-balloon-date-day">Feb</span>
            <span class="timeline-balloon-date-month">2014</span>
        </div>
    
    
        <div class="col-sm-6  timeline-item">
            <div class="row">
                <div class="col-sm-11">
                    <div class="timeline-panel credits">
                        <ul class="timeline-panel-ul">
                            <li><span class="importo">Mussum ipsum cacilds</span></li>
                            <li><span class="causale">Lorem ipsum dolor sit amet, consectetur adipiscing elit. </span> </li>
                            <li><p><small class="text-muted"> 18/02/2014 - Present</small></p> </li>
                        </ul>
                    </div>
    
                </div>
            </div>
        </div>
    
        <div class="col-sm-6  timeline-item">
            <div class="row">
                <div class="col-sm-offset-1 col-sm-11">
                    <div class="timeline-panel debits">
                        <ul class="timeline-panel-ul">
                            <li><span class="importo">Mussum ipsum cacilds</span></li>
                            <li><span class="causale">Lorem ipsum dolor sit amet, consectetur adipiscing elit. </span> </li>
                            <li><p><small class="text-muted"> 18/02/2014 - Present</small></p> </li>
                        </ul>
                    </div>
    
                </div>
            </div>
        </div>
    </div>
    
    <!--due -->
    
    <div class="row timeline-movement">
    
    
        <div class="timeline-badge">
            <span class="timeline-balloon-date-day">Mar</span>
            <span class="timeline-balloon-date-month">2013</span>
        </div>
    
        <div class="col-sm-offset-6 col-sm-6  timeline-item">
            <div class="row">
                <div class="col-sm-offset-1 col-sm-11">
                    <div class="timeline-panel debits">
                        <ul class="timeline-panel-ul">
                            <li><span class="importo">Mussum ipsum cacilds</span></li>
                            <li><span class="causale">Lorem ipsum dolor sit amet, consectetur adipiscing elit. </span> </li>
                            <li><p><small class="text-muted"> 10/03/2013 - 18/02/2014</small></p> </li>
                        </ul>
                    </div>
    
                </div>
            </div>
        </div>
    
        <div class="col-sm-6  timeline-item">
            <div class="row">
                <div class="col-sm-11">
                    <div class="timeline-panel credits">
                        <ul class="timeline-panel-ul">
                            <li><span class="importo">Mussum ipsum cacilds</span></li>
                            <li><span class="causale">Lorem ipsum dolor sit amet, consectetur adipiscing elit. </span> </li>
                            <li><p><small class="text-muted"> 10/03/2013 - 18/02/2014</small></p> </li>
                        </ul>
                    </div>
    
                </div>
            </div>
        </div>
    
    
    </div>
    <div class="row timeline-movement">
    
    
        <div class="timeline-badge">
            <span class="timeline-balloon-date-day">Jan</span>
            <span class="timeline-balloon-date-month">2010</span>
        </div>
    
        <div class="col-sm-offset-6 col-sm-6  timeline-item">
            <div class="row">
                <div class="col-sm-offset-1 col-sm-11">
                    <div class="timeline-panel debits">
                        <ul class="timeline-panel-ul">
                            <li><span class="importo">Mussum ipsum cacilds</span></li>
                            <li><span class="causale">Lorem ipsum dolor sit amet, consectetur adipiscing elit. </span> </li>
                            <li><p><small class="text-muted"> 11/01/2010 - 10/03/2013</small></p> </li>
                        </ul>
                    </div>
    
                </div>
            </div>
        </div>
    
        <div class="col-sm-6  timeline-item">
            <div class="row">
                <div class="col-sm-11">
                    <div class="timeline-panel credits">
                        <ul class="timeline-panel-ul">
                            <li><span class="importo">Mussum ipsum cacilds</span></li>
                            <li><span class="causale">Lorem ipsum dolor sit amet, consectetur adipiscing elit. </span> </li>
                            <li><p><small class="text-muted"> 11/01/2010 - 10/03/2013</small></p> </li>
                        </ul>
                    </div>
    
                </div>
            </div>
        </div>
    
    
    </div>
    </div>
    </div>
    
    </section>
    
  
   <!--Portfolio-->
    <section id="portfolio" class="page-section section appear clearfix secPad">
        <div class="container">

            <div class="heading text-center">
                <!-- Heading -->
                <h2>Portfolio</h2>
                <p>At lorem Ipsum available, but the majority have suffered alteration in some form by injected humour.</p>
            </div>

            <div class="row">
                <nav id="filter" class="col-md-12 text-center">
                    <ul>
                        <li><a href="#" class="current btn-theme btn-small" data-filter="*">All</a></li>
                        <li><a href="#" class="btn-theme btn-small" data-filter=".webdesign">Web Design</a></li>
                        <li><a href="#" class="btn-theme btn-small" data-filter=".photography">Photography</a></li>
                        <li><a href="#" class="btn-theme btn-small" data-filter=".print">Print</a></li>
                    </ul>
                </nav>
                <div class="col-md-12">
                    <div class="row">
                        <div class="portfolio-items isotopeWrapper clearfix" id="3">

                            <article class="col-sm-4 isotopeItem webdesign">
                                <div class="portfolio-item">
                                    <img src="${resourcesPath}/images/portfolio/img1.jpg" alt="" />
                                    <div class="portfolio-desc align-center">
                                        <div class="folio-info">
                                            <a href="${resourcesPath}/images/portfolio/img1.jpg" class="fancybox">
                                                <h5>Project Name</h5>
                                                <i class="fa fa-arrows-alt fa-2x"></i></a>
                                        </div>
                                    </div>
                                </div>
                            </article>

                            <article class="col-sm-4 isotopeItem photography">
                                <div class="portfolio-item">
                                    <img src="${resourcesPath}/images/portfolio/img2.jpg" alt="" />
                                    <div class="portfolio-desc align-center">
                                        <div class="folio-info">
                                            <a href="${resourcesPath}/images/portfolio/img2.jpg" class="fancybox">
                                                <h5>Project Name</h5>
                                                <i class="fa fa-arrows-alt fa-2x"></i></a>
                                        </div>
                                    </div>
                                </div>
                            </article>


                            <article class="col-sm-4 isotopeItem photography">
                                <div class="portfolio-item">
                                    <img src="${resourcesPath}/images/portfolio/img3.jpg" alt="" />
                                    <div class="portfolio-desc align-center">
                                        <div class="folio-info">
                                            <a href="${resourcesPath}/images/portfolio/img3.jpg" class="fancybox">
                                                <h5>Project Name</h5>
                                                <i class="fa fa-arrows-alt fa-2x"></i></a>
                                        </div>
                                    </div>
                                </div>
                            </article>

                            <article class="col-sm-4 isotopeItem print">
                                <div class="portfolio-item">
                                    <img src="${resourcesPath}/images/portfolio/img4.jpg" alt="" />
                                    <div class="portfolio-desc align-center">
                                        <div class="folio-info">
                                            <a href="${resourcesPath}/images/portfolio/img4.jpg" class="fancybox">
                                                <h5>Project Name</h5>
                                                <i class="fa fa-arrows-alt fa-2x"></i></a>
                                        </div>
                                    </div>
                                </div>
                            </article>

                            <article class="col-sm-4 isotopeItem photography">
                                <div class="portfolio-item">
                                    <img src="${resourcesPath}/images/portfolio/img5.jpg" alt="" />
                                    <div class="portfolio-desc align-center">
                                        <div class="folio-info">
                                            <a href="${resourcesPath}/images/portfolio/img5.jpg" class="fancybox">
                                                <h5>Project Name</h5>
                                                <i class="fa fa-arrows-alt fa-2x"></i></a>
                                        </div>
                                    </div>
                                </div>
                            </article>

                            <article class="col-sm-4 isotopeItem webdesign">
                                <div class="portfolio-item">
                                    <img src="${resourcesPath}/images/portfolio/img6.jpg" alt="" />
                                    <div class="portfolio-desc align-center">
                                        <div class="folio-info">
                                            <a href="${resourcesPath}/images/portfolio/img6.jpg" class="fancybox">
                                                <h5>Project Name</h5>
                                                <i class="fa fa-arrows-alt fa-2x"></i></a>
                                        </div>
                                    </div>
                                </div>
                            </article>

                            <article class="col-sm-4 isotopeItem print">
                                <div class="portfolio-item">
                                    <img src="${resourcesPath}/images/portfolio/img7.jpg" alt="" />
                                    <div class="portfolio-desc align-center">
                                        <div class="folio-info">
                                            <a href="${resourcesPath}/images/portfolio/img7.jpg" class="fancybox">
                                                <h5>Project Name</h5>
                                                <i class="fa fa-arrows-alt fa-2x"></i></a>
                                        </div>
                                    </div>
                                </div>
                            </article>

                            <article class="col-sm-4 isotopeItem photography">
                                <div class="portfolio-item">
                                    <img src="${resourcesPath}/images/portfolio/img8.jpg" alt="" />
                                    <div class="portfolio-desc align-center">
                                        <div class="folio-info">
                                            <a href="${resourcesPath}/images/portfolio/img8.jpg" class="fancybox">
                                                <h5>Project Name</h5>
                                                <i class="fa fa-arrows-alt fa-2x"></i></a>
                                        </div>
                                    </div>
                                </div>
                            </article>

                            <article class="col-sm-4 isotopeItem print">
                                <div class="portfolio-item">
                                    <img src="${resourcesPath}/images/portfolio/img9.jpg" alt="" />
                                    <div class="portfolio-desc align-center">
                                        <div class="folio-info">
                                            <a href="${resourcesPath}/images/portfolio/img9.jpg" class="fancybox">
                                                <h5>Project Name</h5>
                                                <i class="fa fa-arrows-alt fa-2x"></i></a>
                                        </div>
                                    </div>
                                </div>
                            </article>
                        </div>

                    </div>


                </div>
            </div>

        </div>
    </section>

	<!--Contact -->
    <section id="contactUs" class="page-section secPad">
        <div class="container">

            <div class="row">
                <div class="heading text-center">
                    <!-- Heading -->
                    <h2>Let's Keep In Touch!</h2>
                    <p>Thank you for visiting out my profile. If you would like to get into contact with me, please fill out the form below.</p>
                </div>
            </div>

            <div class="row mrgn30">

                <form method="post" action="" id="contactfrm" role="form">

                    <div class="col-sm-4">
                        <div class="form-group">
                            <label for="name">Name</label>
                            <input type="text" class="form-control" name="name" id="name" placeholder="Enter name" title="Please enter your name (at least 2 characters)">
                        </div>
                        <div class="form-group">
                            <label for="email">Email</label>
                            <input type="email" class="form-control" name="email" id="email" placeholder="Enter email" title="Please enter a valid email address">
                        </div>
                    </div>
                    <div class="col-sm-4">
                        <div class="form-group">
                            <label for="comments">Comments</label>
                            <textarea name="comment" class="form-control" id="comments" cols="3" rows="5" placeholder="Enter your message…" title="Please enter your message (at least 10 characters)"></textarea>
                        </div>
                        <button name="submit" type="submit" class="btn btn-lg btn-primary" id="submit">Submit</button>
                        <div class="result"></div>
                    </div>
                </form>
                <div class="col-sm-4">
                    <h4>Address:</h4>
                    <address>
                        WebThemez Company<br>
                        134 Stilla. Tae., 414515<br>
                        Leorislon, SA 02434-34534 USA
                        <br>
                    </address>
                    <h4>Phone:</h4>
                    <address>
                        12345-49589-2<br>
                    </address>
                </div>
            </div>
        </div>
        <!--/.container-->
    </section>
    <footer>
        <div class="container">
            <div class="social text-center">
                <a href="#"><i class="fa fa-twitter"></i></a>
                <a href="#"><i class="fa fa-facebook"></i></a>
                <a href="#"><i class="fa fa-dribbble"></i></a>
                <a href="#"><i class="fa fa-flickr"></i></a>
                <a href="#"><i class="fa fa-github"></i></a>
            </div>

            <div class="clear"></div>
            <!--CLEAR FLOATS-->
        </div>
    </footer>
    <!--/.page-section-->
    <section class="copyright">
        <div class="container">
            <div class="row">
                <div class="col-sm-12 text-center">
                    Copyright 2014 | All Rights Reserved  -- Template by <a href="http://webThemez.com">WebThemez.com</a>
                </div>
            </div>
            <!-- / .row -->
        </div>
    </section>
    <a href="#top" class="topHome"><i class="fa fa-chevron-up fa-2x"></i></a>

    <!--[if lte IE 8]><script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script><![endif]-->
    <script src="${resourcesPath}/js/modernizr-latest.js"></script>
    <script src="${resourcesPath}/js/jquery-1.8.2.min.js" type="text/javascript"></script>
    <script src="${resourcesPath}/js/bootstrap.min.js" type="text/javascript"></script>
    <script src="${resourcesPath}/js/jquery.isotope.min.js" type="text/javascript"></script>
    <script src="${resourcesPath}/js/fancybox/jquery.fancybox.pack.js" type="text/javascript"></script>
    <script src="${resourcesPath}/js/jquery.nav.js" type="text/javascript"></script>
    <script src="${resourcesPath}/js/jquery.cslider.js" type="text/javascript"></script>
    <script src="${resourcesPath}/js/custom.js" type="text/javascript"></script>
    <script src="${resourcesPath}/js/owl-carousel/owl.carousel.js"></script>
</body>
</html>
