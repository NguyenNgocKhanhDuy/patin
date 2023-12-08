var error = document.querySelector(".error");
var del = document.querySelector(".error .del");

function hideError() {
    error.classList.add("fadeOut")
}

if (error.style.opacity != "0") {
    setTimeout(hideError, 3000);
}

del.addEventListener("click", hideError);