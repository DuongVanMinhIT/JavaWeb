<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %> >
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<section class="ftco-section ftco-cart">
    <div class="container">
        <div class="row">
            <div class="col-md-12 ftco-animate">
                <div class="cart-list">
                    <table class="table">
                        <thead class="thead-primary">
                            <tr class="text-center">
                                <th>&nbsp;</th>
                                <th>&nbsp;</th>
                                <th>Product name</th>
                                <th>Size</th>
                                <th>Price</th>
                                <th>Quantity</th>
                                <th>Total</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="p" items="${sessionScope['scopedTarget.cartService'].items}">
                                <tr class="text-center" data-id="${p.id}" data-price="${p.unitPrice}"
                                    data-discount="${p.discount}">
                                    <td class="product-remove">
                                        
                                    </td>
                                    <td class="image-prod">
                                        <div class="img" style="background-image:url(/static/product/images/${p.image});"></div>
                                    </td>

                                    <td class="product-name">
                                        <h3>${p.name}</h3>
									
                                    </td>
                                    
                                    <td class="product-size">
                                    	<c:forEach var="s" items="${sessionScope['scopedTarget.sizeService'].items}">
  										<c:if test = "${s.id == p.id}">
  											<h3>${s.sizes}</h3>
  										</c:if>
                                       </c:forEach> 
                                    </td>
                                    <td class="price" >${p.unitPrice}</td>

                                    <td class="quantity">
                                       <h4>${p.quantity}</h4>
                                    </td>

                                    <td class="total">${p.quantity * p.unitPrice *(1 - p.discount)}</td>
                                </tr><!-- END TR-->
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</section>
<section class="ftco-section">
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-xl-12 ftco-animate fadeInUp ftco-animated">
                <form:form action="/order/checkout" class="billing-form" method="post" modelAttribute="order">
                    <h2 class="mb-4 billing-heading">Oreder</h2>
                    <div class="row align-items-end">
                        <div class="col-md-12">
                            <div class="form-group">
                                <label for="firstname">Customer</label>
                                <form:input path="customer.id" class="form-control" />
                            </div>
                        </div>
                        <div class="w-100"></div>
                        <div class="col-md-12">
                            <div class="form-group">
                                <label for="country">Order Date</label>
                                <form:input path="orderDate" class="form-control" />
                            </div>
                        </div>
                        <div class="w-100"></div>
                        <div class="col-md-12">
                            <div class="form-group">
                                <label for="country">Shipping address</label>
                                <form:input path="address" class="form-control" />
                            </div>
                        </div>
                        <div class="w-100"></div>
                        <div class="col-md-12">
                            <div class="form-group">
                                <label for="country">Total Amount</label>
                                <form:input path="amount" class="form-control" />
                            </div>
                        </div>
                        <div class="w-100"></div>
                        <div class="col-md-12">
                            <div class="form-group">
                                <label for="country">Notes</label>
                                <form:textarea path="description" class="form-control" rows="3" />
                            </div>
                        </div>
                        <div class="w-100"></div>
                        <div class="col-md-10">
                        </div>
                        <div class="col-md-2">
                            <div class="form-group">
                                <p><button class="btn btn-primary py-3 px-4">Login</button></p>
                            </div>
                        </div>

                    </div>
                </form:form><!-- END -->
            </div>


        </div>
    </div>
</section>