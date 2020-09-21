$(document).ready(function() {
	// send-mail
	$(".btn-send").click(function() {
		var id = $(this).closest("div").attr("data-id");
		$("#myModal #id").val(id);
	});
	$(".btn-sendTofriend").click(function() {
		var form = {
			id : $("#myModal #id").val(),
			to : $("#myModal #email").val(),
			body : $("#myModal #comment").val(),
			from : $("#myModal #sender").val()

		}
		$.ajax({
			url : "/product/send-to-friend",
			data : form,
			success : function(response) {
				if (response) {
					$("[data-dismiss]").click();
					swal({
						// title: "successFully",
						text : "You send mail successFully",
						icon : "success",
						button : "ok",
					});
				} else {
					alert("err mail");
				}
			}
		});

	});
	// favorite
	$(".btn-star").click(function() {
		var id = $(this).closest("div").attr("data-id");
		// alert( "Handler for .click() called." +id);
		$.ajax({
			url : "/product/add-to-favo/" + id,
			success : function(response) {
				if (response) {
					alert("you add favorite successFully");
				} else {
					alert("already exist");
				}
			}
		})
	});
	// cart
	$(".add-to-cart").click(function() {
		var id = $(this).closest("div").attr("data-id");
		$.ajax({
			url : "/cart/add/" + id,
			success : function(response) {
				$("#cart-cnt").html(response[0]);
				if (response != null) {
					swal({
						// title: "successFully",
						text : "You add successFully",
						icon : "success",
						button : "ok",
					});
				}
				
			},
			error : function(error) {
				console.log("false");
			}

		});

	});
	$('select').on('change', function (e) {
		var size = $(this).val();
		var id = $(this).closest("tr").attr("data-id");
		console.log(id);
		$.ajax({
			url : `/cart/add-size/${id}/${size}`,
			success : function(response) {
				console.log("add size true");
			}

		});
	});
	$("tr[data-id] input").on("input", function() {
		var id = $(this).closest("tr").attr("data-id");
		var price = $(this).closest("tr").attr("data-price");
		var discont = $(this).closest("tr").attr("data-discount");
		var qty = $(this).val();

		$.ajax({
			url : `/cart/update/${id}/${qty}`,
			success : function(response) {
				$("#cart-cnt").html(response[0]);
				console.log("update true");
			}

		});
		var amt = qty * price * (1 - discont);
		$(this).closest("tr").find("#amt").html(amt);
	});
//	$("tr[data-id] td div select").on("click", "option", function() {
//		var id = $(this).closest("tr").attr("data-id");
//		var size = $(this).val();
//		var pricef = $(this).closest("tr").attr("data-price");
//		var ChangePrice = size * pricef;
//		var price = parseFloat(ChangePrice);
//		console.log(typeof price);
//		$.ajax({
//			url : `/cart/updatePrice/${id}/${price}`,
//			success : function(response) {
//				console.log("update true");
//			}
//		});
//		$(this).closest("tr").find("#chang-price").html(ChangePrice);
//	});
	$(".btn-cart-remove").click(function() {
		var id = $(this).closest("tr").attr("data-id");
		$.ajax({
			url : "/cart/remove/" + id,
			success : function(response) {
				$("#cart-cnt").html(response[0]);
				alert("you remove successFully");
			},
			error : function(error) {
				console.log("false");
			}
		});
		$(this).closest("tr").remove();
	});
	$("#btn-clear").click(function() {
		$.ajax({
			url : "/cart/clear",
			success : function(response) {
				$("#cart-cnt").html(0);
				$("table>tbody").html("");
			}
		})
	});
	//size
	


})
