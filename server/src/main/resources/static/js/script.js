var isEmailRegistered;
var submit = document.getElementById("submit");

function checkPassword() {
    var password = document.getElementById("password").value;
    var confirm_password = document.getElementById("confirm_password").value;
    var message = document.getElementById("wrong_password");

    if (password !== confirm_password) {

        message.innerText = "Passwords are not matching!";
        message.setAttribute("style", "color: red; font-size: 1.25em");
        submit.setAttribute("disabled", "disabled");
        submit.setAttribute("style", "mouse: no-drop");
    } else {
        message.innerText = "Matching passwords!";
        message.setAttribute("style", "color: green; font-size: 1.25em");
        if (isEmailRegistered === false) {
            submit.removeAttribute("disabled");
        }
        submit.removeAttribute("style");

    }
}

function checkWorkplace() {
    var id = document.getElementById("id").value;
    var form_control = document.getElementById("form-control-null");
    var feedback = document.getElementById("feedback");
    var onFalse = document.getElementById("onFalse");

    if (form_control === null){
        form_control = document.getElementById("form-control");
    }

    var workplace = form_control.options[form_control.selectedIndex].value;

    $(document).ready(function () {
        var params = {
            id: id,
            workplace: workplace
        };

        $.post("checkWorkplace", $.param(params), function (boolean) {
            console.log(boolean);
            if (boolean === false){
                if (feedback != null){
                    onFalse.setAttribute("style", "color: red");
                    onFalse.removeAttribute("hidden");
                    feedback.setAttribute("disabled", "disabled");
                }
            } else {
                if (feedback != null){
                    onFalse.setAttribute("hidden", "hidden");
                    feedback.removeAttribute("disabled");
                }
            }
        })
    })
}


function checkEmail() {
    var email = document.getElementById("email").value;
    var message = document.getElementById("wrong_email");


    $(document).ready(function () {

        var params = {
            email: email
        };

        $.post("check", $.param(params), function (boolean) {
            console.log(boolean);

            if (boolean === true) {
                message.innerText = "This email is already registered!";
                message.setAttribute("style", "color: red; font-size: 1.25em");
                isEmailRegistered = true;
            } else {
                message.innerText = "This email is not registered yet!";
                message.setAttribute("style", "color: green; font-size: 1.25em");
                submit.removeAttribute("disabled");
                isEmailRegistered = false;
            }
        })
    })


}

function checkEmailExistence() {
    var email = document.getElementById("email").value;
    var password = document.getElementById("password").value;
    var message = document.getElementById("wrongLogin");

    $(document).ready(function () {
        var params = {
            email: email,
            password: password
        };

        $.post("check", $.param(params), function (response) {
            console.log(response);


            if (response === "true") {
                $.post("login", $.param(params), function (response2) {
                    console.log(response2);
                })
            } else {
                message.innerText("Wrong email and/or password");
                message.setAttribute("style", "color: red; font-size: 1.25em");
            }
        })
    });
}


function saveStudent() {
    var name = document.getElementById("name").value;
    var phone = document.getElementById("phone").value;
    var feedback = document.getElementById("feedback");
    var id = document.getElementById("id").value;
    var form_control = document.getElementById("form-control-null");

    if (form_control === null) {
        form_control = document.getElementById("form-control");
    }

    var workplace = form_control.options[form_control.selectedIndex].value;

    if (feedback != null) {
        feedback = feedback.value;
    }

    $(document).ready(function () {
        var params = {
            name: name,
            phone: phone,
            feedback: feedback,
            workplace: workplace,
            id: id
        };

        $.post("save", $.param(params), function (response) {
            console.log(response);
            if (response === "success") {
                window.location = "/student?id=" + id;
            } else {
                window.location = "/";
            }
        })
    });



}

function addActualJob() {
    var actualJobName = document.getElementById("actual_job_name");
    var actualJobDescription = document.getElementById("actual_job_description");
    var actualJobWorkplace = document.getElementById("actual_job_work_place");
    var selected = actualJobWorkplace.options[actualJobWorkplace.selectedIndex].value;
    var success = document.getElementById("successful");



    $(document).ready(function (){
        var params = {
            name : actualJobName.value,
            description : actualJobDescription.value,
            workplace : selected
        };
        $.post("admin/addActualjob", $.param(params), function (response) {
            if (response === true) {
                debugger;
                success.innerText = "Successfully added job";
                success.setAttribute("style", "color:green");
                actualJobName.value = "";
                actualJobDescription.value = "";
            } else {

            }
        })
    })
}


function addWorkplace() {
    var workPlaceName = document.getElementById("workplace_name");
    var workPlaceDescription = document.getElementById("workplace_description");
    var success = document.getElementById("successful");

    $(document).ready(function () {
        var params = {
            name: workPlaceName.value,
            description: workPlaceDescription.value
        };
        $.post("admin/addWorkplace", $.param(params), function (response) {
            debugger;
            if (response === true) {
                success.innerText = "Successfully added workplace";
                success.setAttribute("style", "color:green");
                workPlaceName.value = "";
                workPlaceDescription.value = ""
            } else {
                
            }
        })
    })

}





