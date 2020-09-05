<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<c:forEach var="p" items="${list}">
 <div class="col-md-4">
    <div class="thumbnail">
      <a href="/product/detail/${p.id}">
        <img class="estore-prod" src="/static/images/products/${p.image}" alt="Lights" style="width:100%">
       </a>
        <div class="caption" >
         
          <div class="pull-right" data-id="${p.id}">
   			<button class="btn btn-sm btn-danger " id ="btn-add-to-cart">
   			<i class ="glyphicon glyphicon-shopping-cart"></i>
   			</button>
   			<button class="btn btn-sm btn-warning " id="btn-star">
   				<i class ="glyphicon glyphicon-star" ></i>
   			</button>
   			<button class="btn btn-sm btn-success" data-toggle="modal" data-target="#myModal" id="btn-send">
   				<i class ="glyphicon glyphicon-envelope"></i>
   			</button>
   		  </div>
   		   <p>${p.name}</p>
        </div>
   		
   		
    </div>
  </div>
</c:forEach> 

<jsp:include page="dialog.jsp"/>