var userid, password;

function connectAdmin() {
	email = $("#email").val();
	password = $("#password").val();
	if (validate() === false) {
		swal("Access Denied", "Please enter email and password", "error");

	}
	else {
		var data = { email: email, password: password };
		var xhr = $.post("loginController",data,processResponse);
		xhr.fail(handleError);
	}
}
function processResponse(responseText) {
	if (responseText.trim() === "error") {
		swal("Access Denied", "Invalid userid or password", "error");
	}
	else if (responseText.trim().indexOf("jsessionid") !== -1) {
		swal("success", "Login successful", "success").then(function() {
			window.location = responseText.trim();
		});
	}
	else {
		swal("Access Denied", "Some problem occurred:" + responseText, "error");
	}
}
function handleError(xhr) {
	swal("Error", "Problem in server communication:" + xhr.statusText, "error");
}
function validate() {
	if (userid === "" || password === "") {
		swal("Error!", "All fields are mandatory", "error");
		return false;
	}
	return true;
}