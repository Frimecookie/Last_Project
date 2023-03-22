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
				<li><a href="${cpath}/myPage.do?user_id=${mvo.user_id}">My</a>
					<ul>
						<li><a href="${cpath}/myPage.do?user_id=${mvo.user_id}">내
								정보</a></li>
						
						<li><a href="myPage_voice.do">음성 정보</a></li>

					</ul></li>
				<li class="current"><a href="petPage.do">Pet</a>
					<ul>
						<li><a href="petPage.do">나의 반려동물</a></li>
						<li><a href="petPage_regi.do">반려동물 정보 등록</a></li>
						<li><a href="petPage_correct.do">반려동물 정보 수정</a></li>
					</ul></li>
				<li><a href="videoPage.do">Video</a>
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
									<span>Pet</span>
								</h2>
								<ul class="divided">
									<li>
										<article class="box post-summary">
											<h3>
												<a href="petPage.do">나의 반려동물</a>
											</h3>
										</article>
									</li>
									<li>
										<article class="box post-summary">
											<h3>
												<a href="petPage_regi.do">반려동물 정보 등록</a>
											</h3>
										</article>
									</li>
									<li>
										<article class="box post-summary">
											<h3>
												<a href="petPage_correct.do">반려동물 정보 수정</a>
											</h3>
										</article>
									</li>
								</ul>
							</section>


						</div>
					</div>
					<div class="col-9 col-12-medium imp-medium">
						<div class="content">
							<!-- Content -->
							<form id="correctForm" action="/petPage_correct_2_update1.do"
								method="GET">
								<input type="hidden" id="petNum" name="pet_num"
									value="${petData.pet_num}">
								<article class="box page-content" style="height: 500px;">
									<header>
										<h2>반려동물 정보 수정</h2>
									</header>
									<h3>
										<label for="pet_name">반려동물 이름</label>
									</h3>
									<input type="text" id="petName" name="pet_name"
										value="${petData.pet_name}" maxlength="11"
										placeholder="이름을 입력해주세요" required>
									<h3>
										<label for="pet_age">반려동물 출생연도</label>
									</h3>
									<input type="text" id="petYob" name="pet_age"
										value="${petData.pet_age}" maxlength="4" placeholder="YYYY"
										pattern="\d{4}">
									<h3>
										<label for="pet_cate">반려동물 구분</label>
									</h3>
									<c:if test="${petData.pet_cate==0}">
										<input type="radio" id="petCate" name="pet_cate" value="0"
											checked />강아지
												<input type="radio" id="petCate" name="pet_cate" value="1" />고양이
											</c:if>
									<c:if test="${petData.pet_cate==1}">
										<input type="radio" id="petCate" name="pet_cate" value="0" />강아지
												<input type="radio" id="petCate" name="pet_cate" value="1"
											checked />고양이
											</c:if>
									<h3>
										<label for="pet_gender">반려동물 성별</label>
									</h3>
									<c:if test="${petData.pet_gender==0}">
										<input type="radio" id="petGender" name="pet_gender" value="0"
											checked />수컷
												<input type="radio" id="petGender" name="pet_gender"
											value="1" />암컷
											</c:if>
									<c:if test="${petData.pet_gender==1}">
										<input type="radio" id="petGender" name="pet_gender" value="0" />수컷
												<input type="radio" id="petGender" name="pet_gender"
											value="1" checked />암컷
											</c:if>
								</article>

								<article class="box page-content">
									<span class="image featured" id="tempUploadImgWrap"> <img
										class="temp-upload-img" src="${petData.pet_picture}"
										style="margin: 0 auto;">
									</span> <input type="hidden" id="internalImgPath"
										name="INTERNAL_IMGPATH" value="${petData.INTERNAL_IMGPATH}">
									<input type="hidden" id="externalImgPath" name="pet_picture"
										value="${petData.pet_picture}"><br>

									<div class="filebox">
										<input class="upload-name" id="imgFileNm" placeholder="사진파일"
											disabled> <label for="petImg">파일찾기</label> <input
											type="file" id="petImg" name="PET_IMG" accept="image/*">
										<div style="text-align: center;">
											<button style="margin-top: 5%">등록하기</button>
										</div>
									</div>
								</article>
							</form>
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

	<script>
		$('#petImg')
				.change(
						function() {
							let formData = new FormData();
							let inputFiles = $("input[name='PET_IMG']")[0].files;
							const fileNm = inputFiles[0].name;
							$('#imgFileNm').val(fileNm);

							for (var i = 0; i < inputFiles.length; i++) {
								formData.append('PET_IMG', inputFiles[i]);
							}

							$
									.ajax({
										url : "/file/uploadImgFile.do",
										processData : false,
										contentType : false,
										data : formData,
										type : "POST",
										success : function(res) {
											console.log(res);
											const imgTag = '<img class="temp-upload-img" src="' + res.externalPath + '">';
											$('#tempUploadImgWrap').empty();
											$('#tempUploadImgWrap').append(
													imgTag);
											$('#internalImgPath').val(
													res.internalPath);
											$('#externalImgPath').val(
													res.externalPath);
										}
									})
						})
	</script>
</body>
</html>