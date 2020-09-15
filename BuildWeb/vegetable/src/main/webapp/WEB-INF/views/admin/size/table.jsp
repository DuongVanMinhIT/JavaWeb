<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<div class="panel panel-default">
    <div class="panel-heading">
        <table class="table table-striped">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>NameVn</th>
                    <th></th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="item" items="${list}">
                    <tr>
                        <td>${item.id}</td>
                        <td>${item.name}</td>
                        <td>${item.nameVN}</td>
                        <td>
                            <a class="btn btn-sm btn-info" href="${base}/edit/${item.id}#edit">edit</a>
                            <a class="btn btn-sm btn-danger" href="${base}/delete/${item.id}">Delete</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>

</div>