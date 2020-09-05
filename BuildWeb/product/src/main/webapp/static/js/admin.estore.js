$(document).ready(function() {
	$("#btn-send").click(function(){
		var id = $(this).closest("div").attr("data-id");
		$("#myModal #id").val(id);
	});
	$("#btn-sendTofriend").click(function(){
		var form = {
				 id:  $("#myModal #id").val(),
				 to: $("#myModal #email").val(),
				 body: $("#myModal #comment").val(),
				 from: $("#myModal #sender").val()
				 
		}
		$.ajax({
			  url:"/product/send-to-friend",
			  data:form,
			  success:function(response){
				  if(response){
					  $("[data-dismiss]").click();
					  alert( "gui thanh cong ");
				  }else{
					  alert( "loi mail");
                }
          }
      });
		
	
	});
	$( "#btn-star" ).click(function() {
		var id = $(this).closest("div").attr("data-id");
		  alert( "Handler for .click() called." +id);
		  $.ajax({
			  url:"/product/add-to-favo/"+id,
			  success:function(response){
				  if(response){
					  alert( "them thanh cong ");
				  }else{
					  alert( "da ton tai");
                  }
            }
        })
	});
	//cart
	$("#btn-add-to-cart").click(function(){
		var id = $(this).closest("div").attr("data-id");
		$.ajax({
			  url:"/cart/add/"+id,
			  success:function(response){
				 $("#cart-cnt").html(response[0]);
				 $("#cart-amt").html(response[1]);
				 //console.log("true");
              },
              error: function (error) {
				console.log("fasle");
              }
				
        });
		
		var img = $(this).closest(".thumbnail").find("a>img");	
		var options = {to:'#cart-img', className:'cart-fly'};
		var cart_css ='.cart-fly{background-image:url("'+img.attr("src")+'");background-size:100% 100% }';
		$("style#cart-css").html(cart_css);
		img.effect('transfer',options,1000);
    });
	$("#btn-clear").click(function() {
		$.ajax({
			url:"/cart/clear",
			success:function(response){
				$("#cart-cnt").html(0);
				$("#cart-amt").html(0);
				$("table>tbody").html("");
			  }
			})
		});
	$("#btn-cart-remove").click(function() {
		var id = $(this).closest("tr").attr("data-id");
		$.ajax({
			url:"/cart/remove/" +id,
			success:function(response){
				$("#cart-cnt").html(response[0]);
				$("#cart-amt").html(response[1]);
				
			  }
			});
			$(this).closest("tr").remove();
		});
	$("tr[data-id] input").on("input", function(){
		var id = $(this).closest("tr").attr("data-id");
		var price = $(this).closest("tr").attr("data-price");
		var discount = $(this).closest("tr").attr("data-discount");
		var qty = $(this).val();
		$.ajax({
			url:`/cart/update/${id}/${qty}`,
			success:function(response){
				$("#cart-cnt").html(response[0]);
				$("#cart-amt").html(response[1]);
				
			  }
			});
			var amt = qty*price*(1-discount);
			$(this).closest("tr").find("#amt").html(amt);
		});
	
});	