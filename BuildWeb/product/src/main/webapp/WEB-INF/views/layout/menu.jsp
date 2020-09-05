<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "s" uri = "http://www.springframework.org/tags" %>
<nav class="navbar navbar-inverse">
	<div class="container-fluid">
		<div class="navbar-header">
			<a class="navbar-brand" href="home/index">
			<s:message code="lyt.menu.home"/>
			</a>
		</div>
		<ul class="nav navbar-nav">
			<li><a href="/home/about">Home</a></li>
			<li><a href="/home/contact">Contact Us</a></li>
			<li><a href="/home/feedback">Feedback</a></li>
			<li><a href="/home/faq">FAQ</a></li>
			<li class="dropdown"><a class="dropdown-toggle"
				data-toggle="dropdown" href="#">Account <span class="caret"></span></a>
				<c:choose>
					<c:when test="${empty sessionScope.user}">
						<ul class="dropdown-menu">
							<li><a href="/account/login" >dang nhap</a></li>
							<li><a href="/account/register">dang ky</a></li>
							<li><a href="/account/forgot">quen mat khau</a></li>
						</ul>
					</c:when>
					<c:otherwise>
						<ul class="dropdown-menu">
							<li><a href="/account/logoff">dang xuat</a></li>
							<li><a href="/account/change">doi mat khau</a></li>
							<li><a href="/account/edit">cap nhap tai khoan</a></li>
							<li><a href="/order/list">don hang</a></li>
						</ul>
					</c:otherwise>
				</c:choose>
			</li>
		 </ul>

		<ul class="nav navbar-nav navbar-right">
			<li><a href="#" data-lang="vi">Tieng viet</a></li>
			<li><a href="#" data-lang="en">English</a></li>
		</ul>
	</div>
</nav>
<script>
$(function(){
	$('a[data-lang]').click(function(){
		var lang = $(this).attr("data-lang");
		$.ajax({
			url:'/home/language?lang='+lang,
			success: function(){
				location.reload(); 
			}		
		});
		return false;
	})
})
</script>



