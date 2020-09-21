<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>  

<section class="ftco-section ftco-cart">
    <div class="container">
        <div class="row">
        	<h2>order lsit</h2>
            <div class="col-md-12 ftco-animate">
                <div class="cart-list">
                    <table class="table">
                        <thead class="thead-primary">
                            <tr class="text-center">
                                <th>Id</th>
							    <th>order Date</th>
							    <th>address</th>
							    <th>amont</th>
							    <th></th>
                            </tr>
                        </thead>
                        <tbody>
                           <c:forEach var="o" items="${orders}">
                                <tr class="text-center">                                   
                                    <td class="product-name">
                                        <h3>${o.id}</h3>									
                                    </td>                                   
                                  
                                    <td class="price" >${o.orderDate}</td>

                                    <td class="quantity">
                                       <h4>${o.address}</h4>
                                    </td>

                                    <td class="total">${o.amount}</td>
                                      <td class="product-size">
                                    	<a class="btn btn-sm btn-warning" href="/order/detail/${o.id}">Detail</a>
                                    </td>
                                </tr><!-- END TR-->
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</section>