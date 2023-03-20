<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="cpath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="en">
<head>
<title>Bootstrap Example</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="${cpath}/resources/css/main.css" />
<!-- <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css"> -->
<!-- <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.2/font/bootstrap-icons.css"> -->
<!-- <script src="https://code.jquery.com/jquery-3.6.3.min.js"></script> -->
<!-- <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script> -->
<!-- <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script> -->
</head>

<body class="homepage is-preload">
		<div id="page-wrapper">

			<!-- Header -->
				<header id="header">
					<div class="logo container">
						<div>
							<h1><a href="home.do" id="logo">멍하냥</a></h1>
							<p>위험 물체 감지 알림 서비스</p>
						</div>
					</div>
				</header>

			<!-- Nav -->
				<nav id="nav">
					<ul>
						<li class="current"><a href="home.do">Home</a></li>
						<li>
							<a href="${cpath}/myPage.do?user_id=${mvo.user_id}">My</a>
							<ul>
								<li><a href="${cpath}/myPage.do?user_id=${mvo.user_id}">내 정보</a></li>
								<li><a href="myPage_correct.do">회원 정보 수정</a></li>
								<li><a href="myPage_voice.do">음성 정보</a></li>
								<li><a href="myPage_cam.do">캠 정보</a></li>
							</ul>
						</li>
						<li>
							<a href="petPage.do">Pet</a>
							<ul>
								<li><a href="petPage.do">나의 반려동물</a></li>
								<c:if test="${!empty mvo}">
									<li><a href="petPage_regi.do">반려동물 정보 등록</a></li>
								</c:if>
								<c:if test="${empty mvo}">
									<li><a href="loginPage.do">반려동물 정보 등록</a></li>
								</c:if>
								<li><a href="petPage_correct.do">반려동물 정보 수정</a></li>
							</ul>
						</li>
						<li>
							<a href="videoPage.do">Video</a>
							<ul>
								<li><a href="videoPage.do">실시간 영상</a></li>
								<li><a href="eventPage.do">이벤트 영상</a></li>
							</ul>
						</li>
						<li>
							<a href="qaPage.do">Q&A</a>
							<ul>
								<li><a href="qaPage.do">나의 문의 목록</a></li>
							</ul>
						</li>
						<li>
							<c:if test="${empty mvo}">
								<a href="loginPage.do">Login</a>
							</c:if>
							<c:if test="${!empty mvo}">
								<a href="logout.do">Logout</a>
							</c:if>
						</li>
					</ul>
				</nav>

			<!-- Banner -->
				<section id="banner">
					<div class="content">
						<h2>멍하냥</h2>
						<p>위험 물체 감지 알림 서비스</p>
						<a href="#main" class="button scrolly">알아보기</a>
					</div>
				</section>

			<!-- Main -->
				<section id="main">
					<div class="container">
						<div class="row gtr-200">
							<div class="col-12">

								<!-- Highlight -->
									<section class="box highlight">
										<ul class="special">
											<li><a href="#" class="icon solid fa-video"><span class="label">Video</span></a></li>
											<li><a href="#" class="icon solid fa-search"><span class="label">Search</span></a></li>
											<li><a href="#" class="icon solid fa-tablet-alt"><span class="label">Tablet</span></a></li>
											<li><a href="#" class="icon solid fa-envelope"><span class="label">Envelope</span></a></li>
										</ul>
										<header>
											<h2>위험 물체 감지 알림 서비스</h2><br>
											
											<p>
												실시간 영상 / 위험 감지 / 메세지로 알림<br><br>
											</p>
										</header>
										
									</section>
							</div>
						</div>
					</div>
				<section id="main2">
					<section id="banner2">
						<div class="content">
							<h2>지켜줄개</h2>
							<p>위험 물체 감지 알림 서비스</p>
							<a href="#main" class="button scrolly">알아보기</a>
						</div>
					</section>
				</section>
					
					<!-- <input type="button" value="맨위로" onClick="javascript:window.scrollTo(0,0)" /> -->
					<input type="image" src="/resources/images/top.png" onClick="javascript:window.scrollTo(0,0)" alt="맨위로" 
							style="height: 50px; width: 50px; float: right; margin-right: 30px;"/>
				
				</section>

			<!-- Footer -->
				<footer id="footer">
					<div class="container">
						<div class="row gtr-200">
							<div class="col-12">
								<!-- About -->
								<section>
										<h2 class="major"><span>멍하냥의 새 소식과 공지를 뉴스레터로 받아보세요</span></h2>
									<div class="info">
										<div id="info__id">
											<input type="text" placeholder="이메일을 입력해주세요" style="width:800px;height:50px;font-size:20px;" />
											
											<button>구독하기</button>
										</div>	
									</div>
								</section>
							</div>
									
									
									

							<div class="col-12">

								<!-- Contact -->
									<section>
										<h2 class="major"><span>Get in touch</span></h2>
										<ul class="contact">
											<li><a class="icon brands fa-facebook" href="#"><span class="label">Facebook</span></a></li>
											<li><a class="icon brands fa-twitter" href="#"><span class="label">Twitter</span></a></li>
											<li><a class="icon brands fa-instagram" href="#"><span class="label">Instagram</span></a></li>
											<li><a class="icon brands fa-dribbble" href="#"><span class="label">Dribbble</span></a></li>
											<li><a class="icon brands fa-linkedin" href="#"><span class="label">LinkedIn</span></a></li>
										</ul>
									</section>

							</div>
						</div>

						<!-- Copyright -->
							<div id="copyright">
								<ul class="menu">
									<li>&copy; 2023 멍하냥 All Rights Reserved</li><li>Team: <a href="http://html5up.net">dbdbDeep</a></li>
								</ul>
							</div>

					</div>
				</footer>

		</div>

		<!-- Scripts -->
			<script src="/resources/js/jquery.min.js"></script>
			<script src="/resources/js/jquery.dropotron.min.js"></script>
			<script src="/resources/js/jquery.scrolly.min.js"></script>
			<script src="/resources/js/browser.min.js"></script>
			<script src="/resources/js/breakpoints.min.js"></script>
			<script src="/resources/js/util.js"></script>
			<script src="/resources/js/main.js"></script>

	</body>
</html>