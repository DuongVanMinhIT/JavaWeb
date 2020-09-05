<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %> 
<h2 class="alert alert-info">Customer Manager</h2>

<c:set var="base" value="/admin/Order" scope="request"/>

<h4 class="label laber-success">${message}${param.message}</h4>



<ul class="nav nav-tabs">
  <li class="active"><a data-toggle="tab" href="#tab1">list</a></li>
  <li><a data-toggle="tab" href="#tab2">edit</a></li>
</ul>

<div class="tab-content">
  <div id="tab1" class="tab-pane fade in active">
 	<jsp:include page="table.jsp"/>
  </div>
  <div id="tab2" class="tab-pane fade">
		<jsp:include page="form.jsp"/>
  </div>
</div>