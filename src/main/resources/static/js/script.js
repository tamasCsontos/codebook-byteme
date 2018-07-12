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


function checkEmail() {
    var email = document.getElementById("email").value;
    var message = document.getElementById("wrong_email");


    $(document).ready(function () {

        var params = {
            email: email
        };

        $.post("check", $.param(params), function (boolean) {
            console.log(boolean);
            debugger;
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
            debugger;

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

    if (form_control === null){
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





