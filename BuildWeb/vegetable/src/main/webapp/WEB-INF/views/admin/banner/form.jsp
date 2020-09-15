<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<div class="panel panel-default">
    <div class="panel-body"> 
        <form:form action="${base}/index" modelAttribute="entity" enctype="multipart/form-data">
            <div class="row">
                <div class="form-group col-sm-6">
                    <label>id</label>
                    <form:input path="id" class="form-control" readonly="true" placeholder="Auto Number" />
                </div>
                <div class="form-group col-sm-6">
                    <label>Name</label>
                    <form:input path="name" class="form-control" />
                </div>
            </div>
            
            <div class="row">
                <div class="form-group col-sm-6">
                    <label>Ordering</label>
                    <div class="form-controll">
                        <form:input path="ordering" class="form-control"/>
                    </div>
                </div>
                <div class="form-group col-sm-6">
                    <label>Status</label>
                    <div class="form-controll">
                        <form:radiobutton path="status" value="true" label="Yes" />
                        <form:radiobutton path="status" value="false" label="No" />
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="form-group col-sm-12">
                    <label>Image</label> <input type="file" name="image_banner" class="form-control">
                    <form:hidden path="linkImage" />
                </div>
                <div class="form-group col-sm-12">
                    <button class="btn btn-primary" formaction="${base}/create">Create</button>
                    <button class="btn btn-warning" formaction="${base}/update">Update</button>
                    <button class="btn btn-danger" formaction="${base}/delete">Delete</button>
                    <a class="btn btn-default" href="${base}/index">Reset</a>
                </div>
                
            </div>
            
        </form:form>
    </div>
</div>