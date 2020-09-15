<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %> 
<h2>Size Manager</h2>
<c:set var="base" value="/admin/size" scope="request"/>

<h4 class="label laber-success">${message}${param.message}</h4>

<ul class="nav nav-tabs">
    <li class="nav-item">
      <a class="nav-link active" href="#list">list</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="#edit">edit</a>
    </li>
  </ul>
  <div class="tab-content">
    <div id="list" class="container tab-pane active"><br>
    	<jsp:include page="table.jsp"/>
    </div>
    <div id="edit" class="container tab-pane fade"><br>
   		<jsp:include page="form.jsp"/>	
    </div>
  </div>
