<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<c:choose>
	<c:when test="${loginMember != null }">

		<!-- Navbar -->
		
		<nav
		  class="layout-navbar container-xxl navbar navbar-expand-xl navbar-detached align-items-center bg-navbar-theme"
		  id="layout-navbar"
		>
		  <div class="layout-menu-toggle navbar-nav align-items-xl-center me-3 me-xl-0 d-xl-none">
		    <a class="nav-item nav-link px-0 me-xl-4" href="javascript:void(0)">
		      <i class="bx bx-menu bx-sm"></i>
		    </a>
		  </div>
		
		  <div class="navbar-nav-right d-flex align-items-center" id="navbar-collapse">
		
		    <ul class="navbar-nav flex-row align-items-center ms-auto">
		      <!-- User -->
		      <li class="nav-item navbar-dropdown dropdown-user dropdown">
		        <a class="nav-link dropdown-toggle hide-arrow" href="javascript:void(0);" data-bs-toggle="dropdown">
		          <div class="avatar avatar-online">
		            <img src="${pageContext.request.contextPath}/resources/assets/img/avatars/1.png" alt class="w-px-40 h-auto rounded-circle" />
		          </div>
		        </a>
		        <ul class="dropdown-menu dropdown-menu-end">
		          <li>
		            <a class="dropdown-item" href="#">
		              <div class="d-flex">
		                <div class="flex-shrink-0 me-3">
		                  <div class="avatar avatar-online">
		                    <img src="${pageContext.request.contextPath}/resources/assets/img/avatars/1.png" alt class="w-px-40 h-auto rounded-circle" />
		                  </div>
		                </div>
		                <div class="flex-grow-1">
		                  <span class="fw-semibold d-block">ID : ${loginMember.memberId }</span>
		                  <small class="text-muted">Name : ${loginMember.memberName }</small>
		                </div>
		              </div>
		            </a>
		          </li>
		          <li>
		            <div class="dropdown-divider"></div>
		          </li>
		          <li>
		            <a class="dropdown-item" href="${pageContext.request.contextPath }/member/checkPassword?targetUrl=/member/modifyMember">
		              <i class="bx bx-user me-2"></i>
		              <span class="align-middle">회원 정보 수정</span>
		            </a>
		          </li>
		          <li>
		            <a class="dropdown-item" href="${pageContext.request.contextPath }/member/checkPassword?targetUrl=/member/removeMember">
		              <i class="bx bx-user-x me-2"></i>
		              <span class="align-middle">회원 탈퇴</span>
		            </a>
		          </li>
		          <li>
		            <div class="dropdown-divider"></div>
		          </li>
		          <li>
		            <a class="dropdown-item" href="${pageContext.request.contextPath }/member/logout">
		              <i class="bx bx-power-off me-2"></i>
		              <span class="align-middle">로그아웃</span>
		            </a>
		          </li>
		        </ul>
		      </li>
		      <!--/ User -->
		    </ul>
		  </div>
		</nav>
		
		<!-- / Navbar -->

	</c:when>



	<c:otherwise>

		<!-- Navbar -->
		
		<nav
		  class="layout-navbar container-xxl navbar navbar-expand-xl navbar-detached align-items-center bg-navbar-theme"
		  id="layout-navbar"
		>
		  <div class="layout-menu-toggle navbar-nav align-items-xl-center me-3 me-xl-0 d-xl-none">
		    <a class="nav-item nav-link px-0 me-xl-4" href="javascript:void(0)">
		      <i class="bx bx-menu bx-sm"></i>
		    </a>
		  </div>
		
		  <div class="navbar-nav-right d-flex align-items-center" id="navbar-collapse">
		
		    <ul class="navbar-nav flex-row align-items-center ms-auto">
		    	<button type="button" class="btn btn-outline-primary" onclick = "location.href = '${pageContext.request.contextPath}/member/login';">
                  <span class="tf-icons bx bx-log-in-circle"></span>&nbsp; 로그인
                </button>
		    </ul>
		  </div>
		</nav>
		
		<!-- / Navbar -->


	</c:otherwise>























</c:choose>