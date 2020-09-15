<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "s" uri = "http://www.springframework.org/tags" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<section class="ftco-section">
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-xl-7 ftco-animate fadeInUp ftco-animated">
                <form:form action="/account/register" method="post" modelAttribute="form" enctype="multipart/form-data">
                    <h3 class="mb-4 billing-heading">Register</h3>
                    <h2>${message}</h2>
                    <div class="row align-items-end">
                        <div class="col-md-12">
                            <div class="form-group">
                                <label for="firstname">id</label>
                                <form:input path ="id" class="form-control" readonly="true"/>
                                <form:errors path="id"/>
                            </div>
                        </div>
                        <div class="col-md-12">
                            <div class="form-group">
                                <label for="firstname">Firt Name</label>
                                <form:input path ="fullName" class="form-control"/>
                                <form:errors path="fullName"/>
                            </div>
                        </div>
                        <div class="w-100"></div>
                        <div class="col-md-12">
                            <div class="form-group">
                                <label for="country">PassWord</label>
                                <form:password path = "passWord" class="form-control"  />
                                <form:errors path="passWord"/>
                            </div>
                        </div>
                        <div class="w-100"></div>
                        <div class="col-md-12">
                            <div class="form-group">
                                <label for="country">Email address</label>
                                <form:input path = "email" class="form-control"  />
                                <form:errors path="email"/>
                            </div>
                        </div>
                        <div class="w-100"></div>
                        <div class="col-md-12">
                            <div class="form-group">
                                <label for="country">photo</label>
                                <input type="file" name = "photo_file">
                                <form:hidden path ="photo" class="form-control" />
            
                            </div>
                        </div>
                        <p><button class="btn btn-primary py-3 px-4" >Login</button></p>
                       
                    </div>
                </form:form><!-- END -->
            </div>
            <div class="col-xl-5">
                <div class="row mt-5 pt-3">
                    <div class="col-md-12 d-flex mb-5">
                        <div class="cart-detail cart-total p-3 p-md-4">
                            <h3 class="billing-heading mb-4">Cart Total</h3>
                            <p class="d-flex">
                                <span>Subtotal</span>
                                <span>$20.60</span>
                            </p>
                            <p class="d-flex">
                                <span>Delivery</span>
                                <span>$0.00</span>
                            </p>
                            <p class="d-flex">
                                <span>Discount</span>
                                <span>$3.00</span>
                            </p>
                            <hr>
                            <p class="d-flex total-price">
                                <span>Total</span>
                                <span>$17.60</span>
                            </p>
                        </div>
                    </div>
                    
                </div>
            </div> <!-- .col-md-8 -->
        </div>
    </div>
</section>