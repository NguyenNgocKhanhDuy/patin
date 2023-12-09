var popup = document.querySelector(".popup");

var del = document.querySelector(".popup .del");


function hideError() {
    popup.classList.add("fadeOut")
}

if (popup.style.opacity != "0") {
    setTimeout(hideError, 3000);
}

del.addEventListener("click", hideError);

var statusSuccess = document.querySelector("form #statusSuccess");
if (statusSuccess.value == 'true') {
    setTimeout(fowardToLogin, 1000);
}

function fowardToLogin() {
    window.location.href = "/patin_shop/patin/login.jsp";
}