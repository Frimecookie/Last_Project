<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="cpath" value="${pageContext.request.contextPath}" />
<!DOCTYPE HTML>
<html>
<head>
<title>멍하냥 by dbdbDeep</title>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, user-scalable=no" />
<link rel="stylesheet" href="${cpath}/resources/css/main.css" />
<style>
/* Dropdown Button */
.dropbtn {
	background-color: #698cbf;
	color: white;
	padding: 16px;
	font-size: 16px;
	border: none;
}

/* The container <div> - needed to position the dropdown content */
.dropdown {
	position: relative;
	display: inline-block;
}

/* Dropdown Content (Hidden by Default) */
.dropdown-content {
	display: none;
	position: absolute;
	background-color: #f1f1f1;
	min-width: 160px;
	box-shadow: 0px 8px 16px 0px rgba(0, 0, 0, 0.2);
	z-index: 1;
}

/* Links inside the dropdown */
.dropdown-content a {
	color: black;
	padding: 12px 16px;
	text-decoration: none;
	display: block;
}

.dropdown-content a:hover {
	background-color: #ddd;
}

.dropdown:hover .dropdown-content {
	display: block;
}

.dropdown:hover .dropbtn {
	background-color: #9bb2e5;
}
</style>
</head>
<body class="is-preload">
	<div id="page-wrapper">

		<!-- Header -->
		<header id="header">
			<div class="logo container">
				<div>
					<h1>
						<a href="home.do" id="logo">멍하냥</a>
					</h1>
					<p>위험 물체 감지 알림 서비스</p>
				</div>
			</div>
		</header>

		<!-- Nav -->
		<nav id="nav">
			<ul>
				<li><a href="home.do">Home</a></li>
				<li><a href="${cpath}/myPage.do?user_id=${mvo.user_id}">My</a>
					<ul>
						<li><a href="${cpath}/myPage.do?user_id=${mvo.user_id}">내
								정보</a></li>
						
						<li><a href="myPage_voice.do">음성 정보</a></li>
						
					</ul></li>
				<li><a href="petPage.do">Pet</a>
					<ul>
						<li><a href="petPage.do">나의 반려동물</a></li>
						<li><a href="petPage_regi.do">반려동물 정보 등록</a></li>
						<li><a href="petPage_correct.do">반려동물 정보 수정</a></li>
					</ul></li>
				<li class="current"><a href="videoPage.do">Video</a>
					<ul>
						<li><a href="videoPage.do">실시간 영상</a></li>
						<li><a href="eventPage.do">위험물 접근 빈도</a></li>
						<li><a href="myPage_cam.do">캠 정보</a></li>
					</ul></li>
				<li><a href="qaPage.do">Q&A</a>
					<ul>
						<li><a href="qaPage.do">나의 문의 목록</a></li>
					</ul></li>
				<li><c:if test="${empty mvo}">
						<a href="loginPage.do">Login</a>
					</c:if> <c:if test="${!empty mvo}">
						<a href="logout.do">Logout</a>
					</c:if></li>
			</ul>
		</nav>

		<!-- Main -->
		<section id="main">
			<div class="container">
				<div class="row">
					<div class="col-3 col-12-medium">
						<div class="sidebar">

							<!-- Sidebar -->

							<!-- Recent Posts -->
							<section>
								<h2 class="major">
									<span>Video</span>
								</h2>
								<ul class="divided">
									<li>
										<article class="box post-summary">
											<h3>
												<a href="videoPage.do">실시간 영상</a>
											</h3>
										</article>
									</li>
									<li>
										<article class="box post-summary">
											<h3>
												<a href="eventPage.do">위험물 접근 빈도</a>
											</h3>
										</article>
									</li>
									<li>
										<article class="box post-summary">
											<h3>
												<a href="myPage_cam.do">캠 정보</a>
											</h3>
										</article>
									</li>
									<li>
										<article class="box post-summary">
											<div class="dropdown">
												<button class="dropbtn">캠 선택하기</button>
												<div class="dropdown-content">
													<a href="#">Cam 1</a> <a href="#">Cam 2</a> <a href="#">Cam
														3</a>
												</div>
											</div>
										</article>
									</li>


								</ul>
							</section>
						</div>
					</div>
					<div class="col-9 col-12-medium imp-medium">
						<div class="content">

							<!-- Content -->

							<article class="box page-content">

								<header>
									<h2>위험물 접근 빈도</h2>
								</header>
								<canvas id="Chart" style="width: 600px; height: 400px;"></canvas>
							</article>


						</div>
					</div>
				</div>
			</div>
			<!-- <input type="button" value="맨위로" onClick="javascript:window.scrollTo(0,0)" /> -->
			<div id="goTop">
				<input type="image" src="../../resources/images/goTop.jpg"
					onClick="javascript:window.scrollTo(0,0)" alt="맨위로" />
			</div>
		</section>




		<!-- Footer -->
		<footer id="footer">
			<div class="container">
				<div class="row gtr-200">
					<div class="col-12">
						<!-- About -->
						<section>
							<h2 class="major">
								<span>멍하냥의 새 소식과 공지를 뉴스레터로 받아보세요</span>
							</h2>
							<div class="info">
								<div id="info__id">
									<input type="text" placeholder="이메일을 입력해주세요" />

									<button>구독하기</button>
								</div>
							</div>
						</section>
					</div>

					<div class="col-12">

						<!-- Contact -->
						<section>
							<h2 class="major">
								<span>Get in touch</span>
							</h2>
							<ul class="contact">
								<li><a class="icon brands fa-facebook" href="#"><span
										class="label">Facebook</span></a></li>
								<li><a class="icon brands fa-twitter" href="#"><span
										class="label">Twitter</span></a></li>
								<li><a class="icon brands fa-instagram" href="#"><span
										class="label">Instagram</span></a></li>
								<li><a class="icon brands fa-dribbble" href="#"><span
										class="label">Dribbble</span></a></li>
								<li><a class="icon brands fa-linkedin" href="#"><span
										class="label">LinkedIn</span></a></li>
							</ul>
						</section>

					</div>
				</div>

				<!-- Copyright -->
				<div id="copyright">
					<ul class="menu">
						<li>&copy; 2023 멍하냥 All Rights Reserved</li>
						<li>Team: <a href="#">dbdbDeep</a></li>
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
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.4.0/Chart.min.js"></script>
	<script type="text/javascript">
		//json 가져와서	
		var jsonData = ${json}
		// String 객체로 바꾸고
		var jsonObject = JSON.stringify(jsonData);
		// String 객체를 Json 객체로 바꾸고
		var jData = JSON.parse(jsonObject);

		var labelList = new Array();
		var valueList = new Array();
		var colorList = new Array();

		for (var i = 0; i < jData.length; i++) {
			var d = jData[i];
			labelList.push(d.rec_object);
			valueList.push(d.rec_freq);
			colorList.push(colorize());
		}

		var data = {
			labels : labelList,
			datasets : [ {
				backgroundColor : colorList,
				data : valueList
			} ],
			options : {
				title : {
					display : true,
					text : '접근 횟수'
				}
			}
		};

		var ctx1 = document.getElementById('Chart').getContext('2d');
		new Chart(ctx1, {
			type : 'bar',
			data : data
		});

		function colorize() {
			var r = Math.floor(Math.random() * 200);
			var g = Math.floor(Math.random() * 200);
			var b = Math.floor(Math.random() * 200);
			var color = 'rgba(' + r + ', ' + g + ', ' + b + ', 0.7)';
			return color;
		}
	</script>


</body>
</html>