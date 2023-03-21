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
				<li class="current"><a
					href="${cpath}/myPage.do?user_id=${mvo.user_id}">My</a>
					<ul>
						<li><a href="${cpath}/myPage.do?user_id=${mvo.user_id}">내
								정보</a></li>
						<li><a href="myPage_correct.do">회원 정보 수정</a></li>
						<li><a href="myPage_voice.do">음성 정보</a></li>
						
					</ul></li>
				<li><a href="petPage.do">Pet</a>
					<ul>
						<li><a href="petPage.do">나의 반려동물</a></li>
						<li><a href="petPage_regi.do">반려동물 정보 등록</a></li>
						<li><a href="petPage_correct.do">반려동물 정보 수정</a></li>
					</ul></li>
				<li><a href="videoPage.do">Video</a>
					<ul>
						<li><a href="videoPage.html">실시간 영상</a></li>
						<li><a href="eventPage.html">위험물 접근 빈도</a></li>
						<li><a href="camPage.html">캠 정보</a></li>
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
							<section>
								<h2 class="major">
									<span>My</span>
								</h2>
								<ul class="divided">
									<li>
										<article class="box post-summary">
											<h3>
												<a href="${cpath}/myPage.do?user_id=${mvo.user_id}">내 정보</a>
											</h3>
										</article>
									</li>
									<li>
										<article class="box post-summary">
											<h3>
												<a href="myPage_correct.do">회원 정보 수정</a>
											</h3>
										</article>
									</li>
									<li>
										<article class="box post-summary">
											<h3>
												<a href="myPage_voice.do">음성 정보</a>
											</h3>
										</article>
									</li>
									
								</ul>
							</section>
						</div>
					</div>
					<div class="col-9 col-12-medium imp-medium">
						<div class="content">

							<article class="box page-content">

								<header>
									<h2>내 정보</h2>
								</header>

								<section>
									<h3>이름</h3>
									<p>${userInfo.user_name}</p>
								</section>

								<section>
									<h3>ID</h3>
									<p>${userInfo.user_id}</p>
								</section>

								<section>
									<h3>Phone Num</h3>
									<form action="${cpath}/pnumUpdate.do" method="post">
										<div class="pnum_Correct">
										<input type="hidden" name="user_id"
											value="${userInfo.user_id}"> <input id="pnum"
											type="text" name="user_pnum" value="${userInfo.user_pnum}">
										<button type="submit" onclick="javascript:alertUpdate()"
											style="width: 8em;">수정</button>
										</div>
									</form>
								</section>

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
	<script type="text/javascript">
		function alertUpdate() {
			pnum = document.getElementById('pnum').value;
			alert('전화번호가 ' + pnum + ' (으)로 수정되었습니다!');
		}
	</script>

</body>
</html>