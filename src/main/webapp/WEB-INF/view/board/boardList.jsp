<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>

<!-- beautify ignore:start -->
<html
  lang="en"
  class="light-style layout-menu-fixed"
  dir="ltr"
  data-theme="theme-default"
  data-assets-path="${pageContext.request.contextPath}/resources/assets/"
  data-template="vertical-menu-template-free"
>
  <head>
    <meta charset="utf-8" />
    <meta
      name="viewport"
      content="width=device-width, initial-scale=1.0, user-scalable=no, minimum-scale=1.0, maximum-scale=1.0"
    />

    <title>Home</title>

    <meta name="description" content="" />

    <!-- Favicon -->
    <link rel="icon" type="image/x-icon" href="${pageContext.request.contextPath}/resources/assets/img/favicon/favicon.ico" />

    <!-- Fonts -->
    <link rel="preconnect" href="https://fonts.googleapis.com" />
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
    <link
      href="https://fonts.googleapis.com/css2?family=Public+Sans:ital,wght@0,300;0,400;0,500;0,600;0,700;1,300;1,400;1,500;1,600;1,700&display=swap"
      rel="stylesheet"
    />

    <!-- Icons. Uncomment required icon fonts -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/assets/vendor/fonts/boxicons.css" />

	<!-- jQuery -->
	<!-- CDN 주소 추가 방식 -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>

    <!-- Core CSS -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/assets/vendor/css/core.css" class="template-customizer-core-css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/assets/vendor/css/theme-default.css" class="template-customizer-theme-css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/assets/css/demo.css" />

    <!-- Vendors CSS -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/assets/vendor/libs/perfect-scrollbar/perfect-scrollbar.css" />

    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/assets/vendor/libs/apex-charts/apex-charts.css" />

    <!-- Page CSS -->

    <!-- Helpers -->
    <script src="${pageContext.request.contextPath}/resources/assets/vendor/js/helpers.js"></script>

    <!--! Template customizer & Theme config files MUST be included after core stylesheets and helpers.js in the <head> section -->
    <!--? Config:  Mandatory theme config file contain global vars & default theme options, Set your preferred theme option in this file.  -->
	<script>
		$(document).ready(function() {
			$('#rowPerPage').change(function() {
				$('#pageForm').submit();
				alert('change');
			});
		});
		
	</script>
	
    <script src="${pageContext.request.contextPath}/resources/assets/js/config.js"></script>
    
    
    
    
  </head>

  <body>
    <!-- Layout wrapper -->
    <div class="layout-wrapper layout-content-navbar">
      <div class="layout-container">
        <!-- menu -->
			<div>
				<jsp:include page = "/WEB-INF/inc/menu.jsp"></jsp:include>
			</div>
				
        <!-- / menu -->

        <!-- Layout container -->
        <div class="layout-page">
          <!-- Navbar -->
				<div>
					<jsp:include page = "/WEB-INF/inc/navBar.jsp"></jsp:include>
				</div>
				
          <!-- / Navbar -->

          <!-- Content wrapper -->
          <div class="content-wrapper">
            <!-- Content -->
		            <div class="container-xxl flex-grow-1 container-p-y">
		              <div class="row">
		                <div class="col-lg-12 mb-4 order-0">
		                  <div class="card">
		                    <div class="d-flex align-items-start row">
		                      <div class="col-sm-12">
		                        <div class="card-body">
									<div class = "text-center">
										<h1><span class="fw-bold">게시판</span></h1>
									</div>
									<div class = "row">
										<div class = "col-lg-11 col-sm-10">
										</div>
										<div class = "col-lg-1 col-sm-2 align-items-end">
										<form method = "get" id = "pageForm" action = "${pageContext.request.contextPath }/board/boardList">
											<select name = "rowPerPage" id = "rowPerPage" class = "form-select form-select-sm">
												<c:if test="${rowPerPage == 10 }">
													<option value = "10" selected = "selected">10개씩</option>
													<option value = "20">20개씩</option>
													<option value = "30">30개씩</option>
												</c:if>
												<c:if test="${rowPerPage == 20 }">
													<option value = "10">10개씩</option>
													<option value = "20" selected = "selected">20개씩</option>
													<option value = "30">30개씩</option>
												</c:if>
												<c:if test="${rowPerPage == 30 }">
													<option value = "10">10개씩</option>
													<option value = "20">20개씩</option>
													<option value = "30" selected = "selected">30개씩</option>
												</c:if>
											</select>
										</form>
										</div>
									</div>
									
									<div>&nbsp;</div>
									
									<table class = "table mb-0">
										<tr>
											<th>boardNo</th>
											<th>boardTitle</th>
											<th>memberId</th>
											<th>createdate</th>
										</tr>
										<c:forEach var="b" items="${boardList }">
											<tr>
												<td>${b.boardNo }</td>
												<td>
													<a href = "${pageContext.request.contextPath }/board/boardOne?boardNo=${b.boardNo}">
														${b.boardTitle }
													</a>
												</td>
												<td>${b.memberId }</td>
												<td>${b.createdate }</td>
											</tr>
										</c:forEach>
									</table>
		                        
		                        	<div>&nbsp;</div>
		                        	
		                        	<div class = "text-end">
											<button type="button" class="btn btn-sm btn-outline-primary" onclick = "location.href = '${pageContext.request.contextPath }/board/addBoard';">
							                  <span class="tf-icons bx bx-edit-alt"></span>&nbsp; 글쓰기
							                </button>
		                        	</div>

										
			
			
		                        	<div>&nbsp;</div>
			
			
									<!-- 검색 -->
									<form method = "get" action = "${pageContext.request.contextPath }/board/boardList">
										<div>
											<select name = "searchCategory" id = "searchCategory">
												<c:if test="${param.searchCategory == null || param.searchCategory == 'board_title' }">
													<option value = "board_title" selected>boardTitle</option>
													<option value = "member_id">memberId</option>
													<option value = "board_content">boardContent</option>
												</c:if>
												
												<c:if test="${param.searchCategory == 'member_id' }">
													<option value = "board_title">boardTitle</option>
													<option value = "member_id" selected>memberId</option>
													<option value = "board_content">boardContent</option>
												</c:if>
												
												<c:if test="${param.searchCategory == 'board_content' }">
													<option value = "board_title">boardTitle</option>
													<option value = "member_id">memberId</option>
													<option value = "board_content" selected>boardContent</option>
												</c:if>
											</select>
									
											<input type = "text" name = "searchText" id = "searchText">
											<button type = "submit" >검색</button>
										</div>
									</form>
									
									
									
									<div>&nbsp;</div>
		                        
		                        	<!-- 게시판 페이징 처리 시작 -->
									<div>
										<ul class="pagination justify-content-center">
											
											<!-- 페이지 처음 -->
											<li class="page-item">
												<a class="page-link" href="${pageContext.request.contextPath }/board/boardList?searchText=${searchText }&rowPerPage=${rowPerPage }&currentPage=1">
													<span>처음</span>
												</a>
											</li>
											
											<!-- 페이지 이전(-10의 1페이지) -->
											<c:if test="${previousPage > 0}">
												<li class="page-item">
													<a class="page-link" href="${pageContext.request.contextPath }/board/boardList?searchText=${searchText }&rowPerPage=${rowPerPage }&currentPage=${previousPage}">
														<span>이전</span>
													</a>
												</li>
											</c:if>
									
											<!-- 페이지 1 ~ 10 -->
											<c:forEach var="i" items="${pageList }">
												<!-- 현재페이지 active 속성 부여 -->
												<c:choose>
													<c:when test="${currentPage == i}">
														<li class = "page-item active">
													</c:when >
													<c:otherwise>
														<li class = "page-item">
													</c:otherwise>
												</c:choose>
											
												<!-- 마지막 페이지 까지만 출력 -->
												<c:if test="${i <= lastPage }">
													<a class="page-link" href="${pageContext.request.contextPath }/board/boardList?searchText=${searchText }&rowPerPage=${rowPerPage }&currentPage=${i}">
														<span>${i }</span>
													</a>
												</c:if>
												
														</li>
												
											</c:forEach>
									
											<!-- 페이지 다음(+10의 1페이지) -->
											<c:if test="${nextPage <= lastPage }">
												<li class="page-item">
													<a class="page-link" href="${pageContext.request.contextPath }/board/boardList?searchText=${searchText }&rowPerPage=${rowPerPage }&currentPage=${nextPage}">
														<span>다음</span>
													</a>
												</li>
											</c:if>
									
											<!-- 페이지 마지막 -->
											<li class="page-item">
												<a class="page-link" href="${pageContext.request.contextPath }/board/boardList?searchText=${searchText }&rowPerPage=${rowPerPage }&currentPage=${lastPage}">
													<span>마지막</span>
												</a>
											</li>
										</ul>
									</div>
									<!-- 게시판 페이징 처리 끝 -->
		                        
		                        
		                        
		                        
		                        </div>
		                      </div>
		                    </div>
		                  </div>
		                </div>
		              </div>
		            </div>
            
            
            
            
            
            
            
            <!-- / Content -->

            <!-- Footer -->
            <footer class="content-footer footer bg-footer-theme">
              <div class="container-xxl d-flex flex-wrap justify-content-between py-2 flex-md-row flex-column">
                <div class="mb-2 mb-md-0">
                  ©
                  <script>
                    document.write(new Date().getFullYear());
                  </script>
                  , made with ❤️ by
                  <a href="https://themeselection.com" target="_blank" class="footer-link fw-bolder">ThemeSelection</a>
                </div>
                <div>
                  <a href="https://themeselection.com/license/" class="footer-link me-4" target="_blank">License</a>
                  <a href="https://themeselection.com/" target="_blank" class="footer-link me-4">More Themes</a>

                  <a
                    href="https://themeselection.com/demo/sneat-bootstrap-html-admin-template/documentation/"
                    target="_blank"
                    class="footer-link me-4"
                    >Documentation</a
                  >

                  <a
                    href="https://github.com/themeselection/sneat-html-admin-template-free/issues"
                    target="_blank"
                    class="footer-link me-4"
                    >Support</a
                  >
                </div>
              </div>
            </footer>
            <!-- / Footer -->

            <div class="content-backdrop fade"></div>
          </div>
          <!-- Content wrapper -->
        </div>
        <!-- / Layout page -->
      </div>

      <!-- Overlay -->
      <div class="layout-overlay layout-menu-toggle"></div>
    </div>
    <!-- / Layout wrapper -->


    <!-- Core JS -->
    <!-- build:js assets/vendor/js/core.js -->
    <script src="${pageContext.request.contextPath}/resources/assets/vendor/libs/jquery/jquery.js"></script>
    <script src="${pageContext.request.contextPath}/resources/assets/vendor/libs/popper/popper.js"></script>
    <script src="${pageContext.request.contextPath}/resources/assets/vendor/js/bootstrap.js"></script>
    <script src="${pageContext.request.contextPath}/resources/assets/vendor/libs/perfect-scrollbar/perfect-scrollbar.js"></script>

    <script src="${pageContext.request.contextPath}/resources/assets/vendor/js/menu.js"></script>
    <!-- endbuild -->

    <!-- Vendors JS -->
    <script src="${pageContext.request.contextPath}/resources/assets/vendor/libs/apex-charts/apexcharts.js"></script>

    <!-- Main JS -->
    <script src="${pageContext.request.contextPath}/resources/assets/js/main.js"></script>

    <!-- Page JS -->
    <script src="${pageContext.request.contextPath}/resources/assets/js/dashboards-analytics.js"></script>

    <!-- Place this tag in your head or just before your close body tag. -->
    <script async defer src="https://buttons.github.io/buttons.js"></script>
  </body>
</html>
