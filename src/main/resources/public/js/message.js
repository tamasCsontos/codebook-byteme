function getMessages() {
        $.getJSON(location.href.replace('message', 'messageupdate'), function (response) {
            var key = "messages";
            var obj = response[key];
            var dom = document.getElementById("message-container");
            dom.innerHTML = "";
            for (var i = 0; i < obj.length; i++) {
                dom.innerHTML += "<p>" + obj[i].sender + ": " + obj[i].text_message + "</p>";
            }
        });
    setTimeout(function update() {
        getMessages();
    }, 2000);
}

getMessages();