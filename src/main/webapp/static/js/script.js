var isEmailRegistered;
var submit = document.getElementById("submit");

function checkPassword() {
    var password = document.getElementById("password").value;
    var confirm_password = document.getElementById("confirm_password").value;
    var message = document.getElementById("wrong_password");

    if (password != confirm_password){

        message.innerText = "Passwords are not matching!";
        message.setAttribute("style", "color: red; font-size: 1.5em");
        submit.setAttribute("disabled", "disabled");
        submit.setAttribute("style", "mouse: no-drop");
    } else {
        message.innerText = "Matching passwords!";
        message.setAttribute("style", "color: green; font-size: 1.5em");
        if (isEmailRegistered === false) {
            submit.removeAttribute("disabled");
        }
        submit.removeAttribute("style");

    }
}


function checkEmail(){
    var email = document.getElementById("email").value;
    var message = document.getElementById("wrong_email");



    $(document).ready(function () {

        var params = {
            email: email
        };

        $.post("check", $.param(params), function (response) {
            console.log(response);
            debugger;
            if (response === "true"){
                message.innerText = "This email is already registered!";
                message.setAttribute("style", "color: red; font-size: 1.5em");
                isEmailRegistered = true;
            } else {
                message.innerText = "This email is not registered yet!";
                message.setAttribute("style", "color: green; font-size: 1.5em");
                submit.removeAttribute("disabled");
                isEmailRegistered = false;
            }
        })
    })


}

