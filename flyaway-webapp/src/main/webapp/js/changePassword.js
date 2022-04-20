var password1, password2;

function changePassword() {
	password1 = $("#password1").val();
	password2 = $("#password2").val();
	if (validate() === false) {
		swal("Access Denied", "Please enter both password", "error");

	}
	else {
		var data = { password1: password1, password2: password2 };
		var xhr = $.post("changePasswordController", data, processResponse);
		xhr.fail(handleError);
	}
}
function processResponse(responseText) {
	if (responseText.trim() === "error") {
		swal("Access Denied", "password could not be changed !", "error");
	}
	else if (responseText.trim().indexOf("jsessionid") !== -1) {
		swal("success", "password was changed successfully", "success").then(function() {
			window.location = responseText.trim();
		});
	}
	else {
		swal("Denied", "Some problem occurred ", "error");
	}
}
function handleError(xhr) {
	swal("Error", "Problem in server communication:" + xhr.statusText, "error");
}
function validate() {
	if (password1 === "" || password2 === "") {
		swal("Error!", "All fields are mandatory", "error");
		return false;
	}
	else if (!password1 === password2) {
		swal("Error!", "Password does not Match !", "error");
		return false;
	}
	return true;
}