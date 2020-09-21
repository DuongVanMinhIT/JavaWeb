<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
                                        <button class="button-remove btn-cart-remove"><span
                                                class="ion-ios-close"></span></button></td>
                                    <td class="image-prod">
                                        <div class="img"
                                            style="background-image:url(/static/product/images/${p.image});"></div>
                                    </td>
                                    <td class="product-name">
                                        <h3>${p.name}</h3>
                                    </td>
                                    <td class="size">
                                        <select class="form-control" >
                                            <c:forEach var="s" items="${listDao}">
                                                <option value="${s.id}" id="add-size">${s.name}</option>
                                            </c:forEach>
                                        </select>
                                        
                                    </td>
                                    <td class="price" id="chang-price">${p.unitPrice}</td>

                                    <td class="quantity">
                                        <div class="input-group mb-3">
                                            <input type="text" name="quantity"
                                                class="quantity form-control input-number" value="${p.quantity}" min="1"
                                                max="100">
                                        </div>
                                    </td>

                                    <td class="total" id="amt">${p.quantity * p.unitPrice *(1 - p.discount)}</td>
                                </tr><!-- END TR-->
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
        <div class="row justify-content-end">
            <div class="col-lg-4 mt-5 cart-wrap ftco-animate">
                <p><button class="btn btn-primary py-3 px-4" id="btn-clear">Clear Cart</button></p>
            </div>
            <div class="col-lg-4 mt-5 cart-wrap ftco-animate">

            </div>
            <div class="col-lg-4 mt-5 cart-wrap ftco-animate">
                <p><a href="/order/checkout" class="btn btn-primary py-3 px-4">Proceed to Checkout</a></p>
            </div>
        </div>
    </div>
</section>