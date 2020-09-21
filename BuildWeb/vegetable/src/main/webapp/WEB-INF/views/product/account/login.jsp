<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>   
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>  
<section class="ftco-section">
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-xl-7 ftco-animate fadeInUp ftco-animated">
                <form action="/account/login" class="billing-form" method="post">
                    <h3 class="mb-4 billing-heading">Login</h3>
                    <h2>${message}</h2>
                    <c:if test="${isActivated != null}">
                    	<a href="${isActivated}">you click into lick to activated</a>
                    </c:if>
                    
                    <div class="row align-items-end">
                        <div class="col-md-12">
                            <div class="form-group">
                                <label for="firstname">Firt Name</label>
                                <input value="${uid}" name="id" class="form-control" placeholder="">
                            </div>
                        </div>
                        <div class="w-100"></div>
                        <div class="col-md-12">
                            <div class="form-group">
                                <label for="country">PassWord</label>
                                <input value="${pwd}" name="pw" class="form-control" placeholder="" >
                            </div>
                        </div>
                        <div class="w-100"></div>
                        <div class="col-md-12">
                            <div class="form-group">
                                <label for="country">Remember me?</label>
                                <input name="rm" type="checkbox" >
                            </div>
                        </div>
                        
                        <div class="w-100"></div>
                        <div class="col-md-10">
                            
                        </div>
                        <div class="col-md-2">
                            <div class="form-group">
                                <p><button class="btn btn-primary py-3 px-4" >Login</button></p>
                            </div>
                        </div>
                       
                    </div>
                </form><!-- END -->
            </div>
            
        </div>
    </div>
</section>