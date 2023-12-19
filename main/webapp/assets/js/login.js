var popup = document.querySelector(".popup");

var del = document.querySelector(".popup .del");


function hideError() {
    popup.classList.add("fadeOut")
}

if (popup.style.opacity != "0") {
    setTimeout(hideError, 3000);
}

del.addEventListener("click", hideError);

var forgetPass = document.querySelector("#forgetPass");
var modal = document.querySelector(".modal")
var modalContainer = document.querySelector(".modal-container")
var modalDel = document.querySelector(".modal .del");

function showModal() {
    modal.style.display = "flex";
}
function hideModal() {
    modal.style.display = "none";
}

forgetPass.addEventListener("click", showModal);
modalDel.addEventListener("click", hideModal);
modal.addEventListener("click", hideModal);
modalContainer.addEventListener("click", function () {
    event.stopPropagation();
})