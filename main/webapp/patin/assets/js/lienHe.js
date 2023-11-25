var email = document.querySelector(".messageInput input[type = 'email']");
var sendBtn = document.querySelector(".message input[type = 'submit']");
sendBtn.addEventListener("click", function () {
    var inputValue = email.value;
    if (inputValue.length <= 0){
        alert("Không được để trống email");
    }
});