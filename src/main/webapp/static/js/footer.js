$( document ).ready(function(){
    $(".backToHome").click(function () {
        $.get("/", function (response) {
            console.log(response);
            window.location = "/";
        })
    })
});