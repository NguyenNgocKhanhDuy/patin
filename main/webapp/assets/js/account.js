

function showHide() {
    var mainMenuLi = document.querySelectorAll(".account ul.menu > li");
    var session = document.querySelectorAll(".right > div");
    for (let i = 0; i < mainMenuLi.length; i++) {
        mainMenuLi[i].addEventListener("click", function () {
            for (let j = 0; j < mainMenuLi.length; j++) {
                session[j].style.display = "none";
                mainMenuLi[j].classList.remove("activeAccountNav");
            }
            session[i].style.display = "block";
            mainMenuLi[i].classList.add("activeAccountNav");
        })
    }
}
showHide();