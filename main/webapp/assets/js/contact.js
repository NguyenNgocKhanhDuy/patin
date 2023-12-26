// var email = document.querySelector(".messageInput input[type = 'email']");
// var sendBtn = document.querySelector(".message input[type = 'submit']");
// sendBtn.addEventListener("click", function () {
//     var inputValue = email.value;
//     if (inputValue.length <= 0){
//         alert("Không được để trống email");
//     }
// });

var popup = document.querySelector(".popup");

var del = document.querySelector(".popup .del");


function hideError() {
    popup.classList.add("fadeOut")
    setTimeout(hide, 500);
}

if (popup.style.opacity != "0") {
    setTimeout(hideError, 3000);
}

function hide() {
    popup.classList.remove("error", "alert", "success")
    popup.classList.add("none")
}

del.addEventListener("click", hideError);