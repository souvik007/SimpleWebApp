$(function() {
	alert("loaded");
	var user;
	
	$.ajax({
        url: "checkloginexist",
        type:"POST",
        dataType: 'json',
        contentType: "application/json; charset=utf-8",
        cache: false,
        timeout: 500000,
        success: function(data) {
//        	alert(data.id);
//        	alert(data.status);
        	
        	$("#logInDiv").hide();
        	$("#userDetailsDiv").show();
        	$("label#id").text(":   "+data.id);
        	$("label#name").text(":   "+data.name);
        	$("label#email").text(":   "+data.email);
        	
        },
        error: function(e){
        	$("#logInDiv").show();
        	alert("not logged in");
        }
    });
	
	$("#login").click(function() {
		var uN= $("#userName").val();
		var pD = $("#passWord").val();
		alert(uN);
		var userInfo = JSON.stringify({
				username: uN,
				password: pD
		});
		//alert(userInfo);
		$.ajax({
            url: "login",
            type:"POST",
            dataType: 'json',
            contentType: "application/json; charset=utf-8",
            data: userInfo,
            cache: false,
            timeout: 500000,
            success: function(data) {
//            	alert(data.id);
//            	alert(data.status);
            	
            	$("#logInDiv").toggle();
            	$("#userDetailsDiv").toggle();
            	$("label#id").text(":   "+data.id);
            	$("label#name").text(":   "+data.name);
            	$("label#email").text(":   "+data.email);
            	
            },
            error: function(e){
            	alert(e.responseJSON.id);
            	if(e.responseJSON.id=="not"){
            		alert("Wrong Username");
            	}
            	else if (e.responseJSON.id=="Wrong Password"){
            		alert("Wrong Password");
            	}
            }
        });
		
	});
	
	
	$("#signup").click(function() {
		$("#signUpDiv").toggle();
		$("#logInDiv").toggle();
	});
	
	
	$("#register").click(function() {
		var uId= $("#Id").val();
		var uName = $("#Name").val();
		var uEmail= $("#Email").val();
		var uPass= $("#PasswordSign").val();
		var uSQues= $("#SQues").children("option").filter(":selected").val();
		var uSAns= $("#SAnswer").val();
		var userInfo = JSON.stringify({
			id: uId,
			name: uName,
			email: uEmail,
			password: uPass,
			sQues: uSQues,
			sAns: uSAns
		});
		alert(userInfo);
		$.ajax({
            url: "signup",
            type:"POST",
            dataType: 'json',
            contentType: "application/json; charset=utf-8",
            data: userInfo,
            cache: false,
            timeout: 500000,
            success: function(data) {
            	alert(data);
            	
            }
        });
		$("#signUpDiv").toggle();
		$("#logInDiv").toggle();
	});
	
	
	$("#forgetPassword").click(function() {
		$("#logInDiv").toggle();
		$("#forgetPasswordDiv").toggle();
	});
	
	
	//var json = $("userLog");
	//alert(json);
});
