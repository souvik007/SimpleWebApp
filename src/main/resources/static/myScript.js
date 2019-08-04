$(function() {
	console.log("loaded");
	var user;
	var tokeng;
	$.ajax({
        url: "checkloginexist",
        type:"POST",
        dataType: 'json',
        contentType: "application/json; charset=utf-8",
        cache: false,
        timeout: 500000,
        success: function(data) {
//        	console.log(data.id);
//        	console.log(data.status);
        	
        	$("#logInDiv").hide();
        	$("#userDetailsDiv").show();
        	$("#searchDiv").toggle();
        	$("label#id").text(":   "+data.id);
        	$("label#name").text(":   "+data.name);
        	$("label#email").text(":   "+data.email);
        	$("label#phoneNumber").text(":   "+data.phoneNumber);
        	$("label#department").text(":   "+data.department);
        	
        },
        error: function(e){
        	$("#logInDiv").show();
        	console.log("not logged in");
        }
    });
	
	$("#login").click(function() {
		var uN= $("#username").val();
		var pD = $("#password").val();
		console.log(uN);
		var userInfo = JSON.stringify({
				username: uN,
				password: pD
		});
		$("#details").empty();
		$(".error").empty();
		//console.log(userInfo);
		$.ajax({
            url: "login",
            type:"POST",
            dataType: 'json',
            contentType: "application/json; charset=utf-8",
            data: userInfo,
            cache: false,
            timeout: 500000,
            success: function(data) {
//            	console.log(data.id);
//            	console.log(data.status);
            	
            	$("#logInDiv").toggle();
            	$("#searchDiv").toggle();
            	$("#userDetailsDiv").toggle();
            	$("label#id").text(":   "+data.id);
            	$("label#name").text(":   "+data.name);
            	$("label#email").text(":   "+data.email);
            	$("label#phoneNumber").text(":   "+data.phoneNumber);
            	$("label#department").text(":   "+data.department);
            	
            	
            },
            error: function(e){
            	console.log(e.responseJSON.id);
            	if(e.responseJSON.id=="not"){
            		console.log("Wrong Username");
            		
            		$("#errorUsernameLogin").html("<b style='color:red;'>"+"wrong username"+"</b><br>");
            	}
            	else if (e.responseJSON.id=="Wrong Password"){
            		console.log("Wrong Password");
            		$("#errorPasswordLogin").html("<b style='color:red;'>"+"wrong password"+"</b><br>");
            	}
            }
        });
		
	});
	
	
	
	
	$("#signup").click(function() {
		$("#signUpDiv").toggle();
		$("#logInDiv").toggle();
	});
	
	$("#backToLogin").click(function() {
		$(".error").empty();
		$("#signUpDiv").toggle();
		$("#logInDiv").toggle();
	});
	
	$("#register").click(function() {
		var uId= $("#id").val();
		var uName = $("#name").val();
		var uEmail= $("#email").val();
		var uPass= $("#passwordSign").val();
		var uPhoneNumber= $("#phoneNumber").val();
		var uSQues= $("#sQues").children("option").filter(":selected").val();
		var uSAns= $("#sAnswer").val();
		var udepartment= $("#department").val();
		var userInfo = JSON.stringify({
			id: uId,
			name: uName,
			email: uEmail,
			password: uPass,
			phoneNumber: uPhoneNumber,
			sQues: uSQues,
			sAns: uSAns,
			department: udepartment
			
		});
		console.log(userInfo);
		$.ajax({
            url: "signup",
            type:"POST",
            dataType: 'json',
            contentType: "application/json; charset=utf-8",
            data: userInfo,
            cache: false,
            timeout: 500000,
            success: function(data) {
            	if(data.status=="pass"){
            		$("#signUpDiv").toggle();
            		$("#logInDiv").toggle();
            	}
            	else{
            		var errorList = data.errors;
            		$(".error").empty();
            		$.each(errorList, function(key , value){
            			
            			console.log(key+":  "+value);
            			$("#"+key).html("<b style='color:red;'>"+value+"</b><br>");
            		});
            	}
            }
        });
		
	});
	
	
	
	
	$("#editDetails").click(function() {
		$(".error").empty();
		$.ajax({
            url: "checkloginexist",
            type:"POST",
            cache: false,
            timeout: 500000,
            success: function(data) {
            	console.log(data);    	
            	$("#userDetailsEditDiv").toggle();
            	$("#searchDiv").toggle();
            	$("#userDetailsDiv").toggle();
            	
            	$("#idEdit").val(data.id);
            	$("#nameEdit").val(data.name);
            	$("#emailEdit").val(data.email);
            	$("#phoneNumberEdit").val(data.phoneNumber);
            	$("#departmentEdit").val(data.department);           	
            	
            }
        });
		
	});
	
	$("#backToUserSetails").click(function() {
		$("#userDetailsEditDiv").toggle();
		$("#searchDiv").toggle();
		$("#userDetailsDiv").toggle();
	});
	
	
	$("#saveUserDetails").click(function() {
		var uId= $("#idEdit").val();
		var uName = $("#nameEdit").val();
		var uEmail= $("#emailEdit").val();
		var uPhoneNumber= $("#phoneNumberEdit").val();
		var udepartment= $("#departmentEdit").val();
		var userInfo = JSON.stringify({
			id: uId,
			name: uName,
			email: uEmail,		
			phoneNumber: uPhoneNumber,
			department: udepartment			
		});
		console.log(userInfo);
		$.ajax({
            url: "userdetailsedit",
            type:"POST",
            dataType: 'json',
            contentType: "application/json; charset=utf-8",
            data: userInfo,
            cache: false,
            timeout: 500000,
            success: function(data) {
            	console.log(data);
            	if(data.status=="pass"){
            		$("#updateUserStatus").html("Succesfully updated")
            	}
            	else{
            		var errorList = data.errors;
            		$(".error").empty();
            		$.each(errorList, function(key , value){
            			
            			console.log(key+":  "+value);
            			$("#"+key).html("<b style='color:red;'>"+value+"</b>");
            		});
            	}
            }
        });
		
	});
	
	$("#search").click(function() {
		var usearchQuery= $("#searchBar").val();
		var usearchCriteria= $("#searchSelect").children("option").filter(":selected").val();
		var searchData = JSON.stringify({
			searchQuery: usearchQuery,
			searchCriteria: usearchCriteria
		});
		console.log(searchData);
		$.ajax({
            url: "search",
            type:"POST",
            dataType: 'json',
            contentType: "application/json; charset=utf-8",
            data: searchData,
            cache: false,
            timeout: 500000,
            success: function(data) {
            	console.log(JSON.stringify(data));
            	$("#searchResult").empty();
            	$.each(data, function(index, value){
            		console.log(value);
            		
            		var i=index+1;
            		$("#searchResult").append("<p>"+i+". Id : "+value.id+" Name : "+value.name+" Email : " + value.email+ " Department : "+value.department+"Phone Number: "+value.phoneNumber+"</p>");
            	});
            	
            }
        });		
	});
	
	$("#searchClear").click(function(){
		$("#searchResult").empty();
	});
	
	
	$("#logOut").click(function() {
		$.ajax({
            url: "logout",
            type:"POST",
            cache: false,
            timeout: 500000,
            success: function(data) {
            	console.log(data);    	
            	$("#logInDiv").toggle();
            	$("#searchDiv").toggle();
            	$("#userDetailsDiv").toggle();
            	
            }
        });
		
	});
	
	$("#forgetPassword").click(function() {
		$("#logInDiv").toggle();
		
		$("#forgetPasswordDiv").toggle();
	});
	
	$("#forgetPasswordToLogin").click(function() {
		
		$("#logInDiv").toggle();
		$("#forgetPasswordDiv").toggle();
	});
	
	$("#changePassword").click(function() {
		$("#userDetailsDiv").toggle();
		$("#changePasswordDiv").toggle();
    	$("#searchDiv").toggle();

	});
	$("#changePasswordToUserDetails").click(function() {
		$("#searchDiv").toggle();
		$("#userDetailsDiv").toggle();
		$("#changePasswordDiv").toggle();
    	

	});
	$("#submitF").click(function() {
		var uN= $("#usernameF").val();
		var uSQues= $("#sQuesF").children("option").filter(":selected").val();
		var uSAns= $("#sAnsF").val();
		
		var userInfo = JSON.stringify({
			username: uN,
			sQues: uSQues,
			sAns: uSAns,
		});
		$.ajax({
            url: "forgetpassword",
            type:"POST",
            dataType: 'json',
            contentType: "application/json; charset=utf-8",
            data: userInfo,
            cache: false,
            timeout: 500000,
            success: function(data) {
            	console.log(data.message);
            	if(data.message=="next"){
            		tokeng=data.token;
            		$("#forgetPasswordDiv").toggle();
            		$("#generateNewPasswordDiv").toggle();
            	}
            	else if(data.message=="no user exist"){
            		console.log(data.message);
            		
            	}
            	else{
            		console.log(data.message); 
            	}
            	
            }
        });
	});
	
	$("#submitGen").click(function() {
		var passwordN= $("#passwordN").val();
		var passwordNC= $("#passwordNC").val();
		$(".error").empty();
		if(passwordN==passwordNC){
			var userInfo = JSON.stringify({
				token: tokeng,
				password: passwordN
			});
				
				$.ajax({
		            url: "updatepass",
		            type:"POST",
		            dataType: 'json',
		            contentType: "application/json; charset=utf-8",
		            data: userInfo,
		            cache: false,
		            timeout: 500000,
		            success: function(data) {
		            	if(data=="wrong format"){
		            		$("#errorPasswordGen").html("<b style='color:red;'>"+" password must include uppercase, lowercase, number, special symbol and 6 to 12 character "+"</b><br>");
		            	}
		            	else{
		            		$("#generateNewPasswordDiv").toggle();
		            		$("#logInDiv").toggle();
		            		$("#details").empty();
		            		$("#details").html("<b style='color:green;'>"+"Password changed successfully"+"</b><br>");
		            	}
		            	
		            	
		            }
		        });
		}
		else{
    		$("#errorPasswordGenConf").html("<b style='color:red;'>"+" both paswword should match "+"</b><br>");

		}
		
	});
	$("#submitChangePass").click(function() {
		var uoldPass= $("#passwordOld").val();
		var passwordC= $("#passwordChange").val();
		var passwordNC= $("#passwordCangeConfirm").val();

		$(".error").empty();
		if(passwordC==passwordNC){
			var userInfo = JSON.stringify({
				oldPass: uoldPass,
				newPass: passwordC
			});
				
				$.ajax({
		            url: "changepass",
		            type:"POST",
		            dataType: 'json',
		            contentType: "application/json; charset=utf-8",
		            data: userInfo,
		            cache: false,
		            timeout: 500000,
		            success: function(data) {
		            	console.log(data);
		            	if(data=="wrong format"){
		            		$("#errorPasswordChanege").html("<b style='color:red;'>"+" password must include uppercase,lowercase,number,special symbol and 6 to 12 character "+"</b><br>");
		            	}
		            	else{
		            		$("#changePasswordDiv").toggle();
		            		$("#logInDiv").toggle();
		            		$("#details").empty();
		            		$("#details").html("<p style='color:green;'>"+"Password changed successfully"+"</p><br>");
		            	}
		            	}
		        });
		}
		else{
    		$("#errorPasswordChanegeConf").html("<b style='color:red;'>"+" both paswword should match "+"</b><br>");

		}
	});
	//var json = $("userLog");
	//console.log(json);
});
