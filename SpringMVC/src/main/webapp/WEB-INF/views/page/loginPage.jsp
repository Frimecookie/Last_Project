<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%
String referer = request.getHeader( "REFERER");
%>
<c:set var="cpath" value="${pageContext.request.contextPath}" />
<!DOCTYPE HTML>
<html>
	<head>
		<title>Left Sidebar - TXT by HTML5 UP</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
		<link rel="stylesheet" href="/resources/css/main.css" />
		<style>
           header{
                display:flex;
                justify-content: left;
            }
          
            .input-box2{
                position:relative;
                margin:10px 0;
            }
            .input-box2 > input{
                background:transparent;
                border:none;
                border-bottom: solid 1px #ccc;
                padding:20px 0px 5px 0px;
                font-size:14pt;
                width:100%;
            }
            input::placeholder{
                color:transparent !important;
            }
            input:placeholder-shown + label{
                color:#aaa;
                font-size:14pt;
                top:15px;
            }
            input:focus + label, label{
                color:#8aa1a1;
                font-size:10pt;
                pointer-events: none ;
                position: absolute;
                left:0px;
                top:0px;
                transition: all 0.2s ease ;
                -webkit-transition: all 0.2s ease;
                -moz-transition: all 0.2s ease;
                -o-transition: all 0.2s ease;
            }
            input[type=submit]{
                background-color: #8aa1a1;
                border:none;
                color:white;
                border-radius: 5px;
                width:100%;
                height:60px;
                font-size: 14pt;
                margin-top:20px;
            }
            #forgot{
                text-align: right;
                font-size:12pt;
                color:rgb(164, 164, 164);
                margin:10px 0px;
            }
		</style>
	</head>
	
	<body class="is-preload">
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
					<li><a href="home.do">Home</a></li>
					<li>
						<a href="myPage.do">My</a>
						<ul>
							<li><a href="myPage.do">내 정보</a></li>
							<li><a href="myPage_correct.do">회원 정보 수정</a></li>
							<li><a href="myPage_voice.do">음성 정보</a></li>
							<li><a href="myPage_cam.do">캠 정보</a></li>
						</ul>
					</li>
					<li>
						<a href="petPage.do">Pet</a>
						<ul>
							<li><a href="petPage.do">나의 반려동물</a></li>
							<li><a href="petPage_regi.do">반려동물 정보 등록</a></li>
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
					<li class="current">
						<a href="loginPage.do">Login</a>
					</li>
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
												<h2 class="major"><span>Login</span></h2>
												<ul class="divided">
													<li>
														<article class="box post-summary">
															<h3><a href="loginPage.do">로그인</a></h3>
														</article>
													</li>
													<li>
														<article class="box post-summary">
															<h3><a href="loginPage_regi.do">회원가입</a></h3>
														</article>
													</li>
												</ul>
											</section>
								</div>
							</div>
							<div class="col-9 col-12-medium imp-medium">
								<!-- <div class="content"> -->
									<!-- Content -->
										<article class="box page-content">
											<header>
												<h2>로그인</h2>
											</header>
											<form action="${cpath}/login.do" method="POST">
												<input type="hidden" id="referer" name="referer" value="<%= referer%>">
												<c:if test="${empty mvo}">
													<div class="input-box2">
														<label for="USER_ID">ID</label>
														<input id="USER_ID" type="text" name="userId" placeholder="ID">
													</div>
													<div class="input-box2">
														<label for="USER_PW">PassWord</label>
														<input id="USER_PW" type="password" name="userPw" placeholder="PassWord">
													</div>
													<div id="forgot">비밀번호 찾기</div>
													<input type="submit" value="로그인">
													<input type="submit" value="kakao" style="background-color: #f1c40f;">
													<input type="submit" value="naver" style="background-color: #51c26f;">
												</c:if>
												<c:if test="${!empty mvo}">
													<alert>${mvo.USER_NAME}님 환영합니다.</alert>
												</c:if>
												<c:if test="${mvo==false}">
													<p style="color:red;">로그인 실패! 아이디와 비밀번호를 확인해주세요</p>
												</c:if>
											</form>
										</article>
								<!-- </div> -->
							</div>
						</div>
					</div>
					
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
		<script>
		function call(url, data, callback, async, cbObj, contentType){ // 서버데이터통신
			$.ajax({
				type : "POST",
				async : false,
				url : url,
				dataType : "json",
				timeout : 30000,
				cache : false,
				data : data,
				contentType : contentType?contentType:"application/x-www-form-urlencoded; charset=UTF-8",
				success : function(response, status, request) {
					var msgcd = response.msgcd;
					if(msgcd=="-1"){
						location.href = "/home.do";
						alert("세션이 만료되었습니다.");
					} else {
						callback(response, cbObj);
					}
				},
				error : function(request, status, error) {
				},
				beforeSend : function() {
				},
				complete : function() {
				}
			});
		}
		
		function doLogin() {
			var userId = $("#USER_ID").val();
			var userPw = $("#USER_PW").val();
			
			call("/login.do", "userId="+userId+"&userPw="+userPw, _doLogin, false);
		}
		
		function _doLogin(response) {
			var msgcd = response.msgcd;
			if(msgcd != null){
				if(msgcd == 0){
					setCookie("userId", $("#USER_ID").val(), 7);
					sessionStorage.setItem('userId', $("#USER_ID").val());
					location.href="/home.do";
				} else if(msgcd == 1){
					alert("사용자 아이디가 존재하지 않습니다.");
					$("#USER_ID").focus();
					return false;
				} else if(msgcd == 2){
					alert("비밀번호가 일치하지 않습니다.");
					$("#USER_ID").focus();
					return false;
				}
			}
		}
	</script>
</html>