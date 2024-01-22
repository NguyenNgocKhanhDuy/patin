

function showHide() {
    var mainMenuLi = document.querySelectorAll(".account ul.menu > li");
    // var session = document.querySelectorAll(".right > div");
    for (let i = 0; i < mainMenuLi.length; i++) {
        mainMenuLi[i].addEventListener("click", function () {
            for (let j = 0; j < mainMenuLi.length; j++) {
                // session[j].style.display = "none";
                mainMenuLi[j].classList.remove("activeAccountNav");
            }
            // session[i].style.display = "block";
            mainMenuLi[i].classList.add("activeAccountNav");
        })
    }
}
showHide();

function initDoB(day, month, year) {
    var daySelect = document.querySelectorAll("select.day");
    var monthSelect = document.querySelectorAll("select.month");
    var yearSelect = document.querySelectorAll("select.year");
    var htmlDay = "";
    for (let i = 1; i <= 31; i++) {
        if (i == day) {
            htmlDay += `<option selected>${i}</option>`;
        }else {
            htmlDay += `<option>${i}</option>`;
        }
    }
    for (let i = 0; i < daySelect.length; i++) {
        daySelect[i].innerHTML = htmlDay;
    }

    var htmlMonth = "";
    for (let i = 1; i <= 12; i++) {
        if (i == month) {
            htmlMonth += `<option selected>${i}</option>`;
        } else {
            htmlMonth += `<option>${i}</option>`;
        }
    }
    for (let i = 0; i < monthSelect.length; i++) {
        monthSelect[i].innerHTML = htmlMonth;
    }

    var htmlYear = "";
    for (let i = 1920; i <= new Date().getFullYear(); i++) {
        if (i == year) {
            htmlYear += `<option selected>${i}</option>`;
        }else {
            htmlYear += `<option>${i}</option>`;
        }
    }
    for (let i = 0; i < yearSelect.length; i++) {
        yearSelect[i].innerHTML = htmlYear;
    }
}
initDoB(new Date().getDate(), new Date().getMonth()+1, new Date().getFullYear())

