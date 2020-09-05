<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %> 
<table class="table">
<thead>
  <tr>
    <th>Id</th>
    <th>fullname</th>
    <th>email</th>
    <th>activated</th>
    <th>admin<th>
    <th></th>  
  </tr>
</thead>  
<tbody id="tbody">  
</tbody>	
</table>
<ul class="pager">
  <li><a href="#"><i class="glyphicon glyphicon-hand-up"></i></a></li>
  <li><a href="#"><i class="glyphicon glyphicon-hand-left"></i></a></li>
  <li><a href="#"><span id ="info">5/15</span></a></li>
  <li><a href="#"><i class="glyphicon glyphicon-hand-right"></i></a></li>
  <li><a href="#"><i class="glyphicon glyphicon-hand-down"></i></a></li>
</ul>
<script>
	$(function(){
		var pageNo = 0;
		var pageCount = 0;
		var pageSize = 10;
		
		$.ajax({
			url:'/pager/customer/page-count',
			success: function(response){
				pageCount = response;
				$(".pager a:eq(0)").click();
			}
		})
		$(".pager a:eq(0)").click(function(){
			pageNo = 0;
			$.ajax({
				url:'/pager/customer/page/'+pageNo,
				success: getPage
			}) 
			console.log("ok");
			return false;
		});
		
		$(".pager a:eq(1)").click(function(){
			if(pageNo >0){
				pageNo--;
				$.ajax({
					url:'/pager/customer/page/'+pageNo,
					success: getPage
				}) 
			}
			
			return false;
		});
		$(".pager a:eq(3)").click(function(){
			if(pageNo < pageCount -1){
				pageNo++;
				$.ajax({
					url:'/pager/customer/page/'+pageNo,
					success: getPage
				}) 
			}
			
			return false;
		});
		$(".pager a:eq(4)").click(function(){
			pageNo = pageCount - 1;
			$.ajax({
				url:'/pager/customer/page/'+pageNo,
				success: getPage
			}) 
			return false;
		});
        function getPage(response){
			$(response).each(function(index, user){
				$("#tbody").html("");
				var tr = $("<tr/>");
				 $("<td>").html(user.id).appendTo(tr);
				 $("<td>").html(user.fullname).appendTo(tr);
				 $("<td>").html(user.email).appendTo(tr);
				 $("<td>").html(user.activated ? 'Yes':'No').appendTo(tr);
				 $("<td>").html(user.admin ? 'admin' : 'user').appendTo(tr);
				 var s = `<td>
				     		<a class="btn btn-sm btn-info" href="${base}/edit/`+user.id+`">edit</a>
				     		<a class="btn btn-sm btn-danger" href="${base}/delete/`+user.id+`">Delete</a>
				     	 </td>`;
				 $(s).appendTo(tr);
				 tr.appendTo("#tbody")
				 $("#info").html((pageNo + 1) + '/' + pageCount);
			})
			console.log(response);
		}
	})
</script>

