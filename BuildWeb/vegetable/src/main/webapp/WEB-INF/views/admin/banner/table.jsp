<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<table class="table table-striped">
    <thead>
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Image</th>
            <th>Status</th>
            <th></th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="e" items="${list}">
            <tr>
                <td>${e.id}</td>
                <td>${e.name}</td>
                <td><img src="/static/product/image/${e.linkImage}" class="rounded" alt="Cinque Terre" style="width: 200px;"></td>
                <td>${e.status}</td>
                <td>
                    <a class="btn btn-sm btn-info" href="${base}/edit/${e.id}#edit">edit</a>
                    <a class="btn btn-sm btn-danger" href="${base}/delete/${e.id}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </tbody>
</table>