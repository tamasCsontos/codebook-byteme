function checkPassword() {
    var password = document.getElementById("password").value;
    var confirm_password = document.getElementById("confirm_password").value;
    var message = document.getElementById("message");
    var submit = document.getElementById("submit");

    if (password != confirm_password){
        message.innerText = "Passwords are not matching!";
        submit.setAttribute("disabled", "disabled");
        submit.setAttribute("style", "mouse: no-drop")
    } else {
        message.innerText = "Matching passwords!";
        submit.removeAttribute("disabled");
        submit.removeAttribute("style");
    }
}
