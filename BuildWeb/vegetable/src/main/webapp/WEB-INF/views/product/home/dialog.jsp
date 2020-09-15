<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://java.sun.com/jstl/fmt_rt" prefix = "f"%>


<!-- Modal -->
<div id="myModal" class="modal fade" role="dialog">
  <div class="modal-dialog">

    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header">
        
        <h4 class="modal-title">Send to friend</h4>
      </div>
      <div class="modal-body">
       <div>
      		<div class="form-group">
  				<label for="sender">Sender Email</label>
  				<input type="text" class="form-control" id="sender" >
			</div>
			<div class="form-group">
  				<label for="Email">Email</label>
  				<input type="text" class="form-control" id="email" name="email">
			</div>
			<div class="form-group">
  				<label for="comment">Comment:</label>
 				 <textarea class="form-control" rows="5" id="comment" name="comment"></textarea>
			</div>
     	 </div>
      	<input id ="id" type="hidden">
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default btn-sendTofriend">Send</button>
      	<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
      </div>
    </div>

  </div>
</div>




