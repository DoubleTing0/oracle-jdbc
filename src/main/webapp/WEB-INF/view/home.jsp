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
			<c:choose>
				<%-- 로그인 상태 --%>
				<c:when test="${loginMember != null }">
		            <div class="container-xxl flex-grow-1 container-p-y">
		              <div class="row">
		                <div class="col-lg-12 mb-4 order-0">
		                  <div class="card">
		                    <div class="d-flex align-items-start row">
		                      <div class="col-sm-7">
		                        <div class="card-body">
		                          <h3 class="card-title text-primary"><span class="fw-bold">${loginMember.memberName }</span>&nbsp;님 어서오세요! 🎉</h3>
		                          <p class="mb-4">
		                            새로운 소식을 알아보세요!
		                          </p>
		                        </div>
		                      </div>
		                      <div class="col-sm-5 text-center text-sm-left">
		                        <div class="card-body pb-0 px-0 px-md-4">
		                          <img
		                            src="${pageContext.request.contextPath}/resources/assets/img/illustrations/man-with-laptop-light.png"
		                            height="400"
		                            alt="View Badge User"
		                            data-app-dark-img="illustrations/man-with-laptop-dark.png"
		                            data-app-light-img="illustrations/man-with-laptop-light.png"
		                          />
		                        </div>
		                      </div>
		                    </div>
		                  </div>
		                </div>
		              </div>
		            </div>
				</c:when>
            
            	<%-- 로그아웃 상태 --%>
            	<c:otherwise>
		            <div class="container-xxl flex-grow-1 container-p-y">
		              <div class="row">
		                <div class="col-lg-12 mb-4 order-0">
		                  <div class="card">
		                    <div class="d-flex align-items-start row">
		                      <div class="col-sm-7">
		                        <div class="card-body">
		                          <h3 class="card-title text-primary">로그인 하신 후 이용할 수 있습니다.</h3>
		                          <p class="mb-4">
		                            당신의 생각을 다른 사람과 공유하세요!
		                          </p>
		                        </div>
		                      </div>
		                      <div class="col-sm-5 text-center text-sm-left">
		                        <div class="card-body pb-0 px-0 px-md-4">
		                          <img
						            src="${pageContext.request.contextPath }/resources/assets/img/illustrations/girl-doing-yoga-light.png"
						            alt="girl-doing-yoga-light"
						            width="800"
						            class="img-fluid"
						            data-app-dark-img="illustrations/girl-doing-yoga-dark.png"
						            data-app-light-img="illustrations/girl-doing-yoga-light.png"
						          />
		                        </div>
		                      </div>
		                    </div>
		                  </div>
		                </div>
		              </div>
		            </div>
            	</c:otherwise>
            
			</c:choose>
            
            
            
            
            
            
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
