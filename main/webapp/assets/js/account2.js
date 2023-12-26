var subMenu = document.querySelector(".account ul li:first-child .sub_menu");

var mainMenuLi = document.querySelectorAll(".account ul.menu > li");

var isShowSubMenu = "false";
function showInfoAccount() {
    for (let i = 0; i < mainMenuLi.length; i++) {
        mainMenuLi[i].addEventListener("click", function () {
            if (i == 0) {
                if (isShowSubMenu == "false") {
                    subMenu.classList.replace("hideSubMenu", "showSubMenu");
                    isShowSubMenu = "true";
                }else {
                    subMenu.classList.replace("showSubMenu", "hideSubMenu");
                    isShowSubMenu = "false";
                }
            }else{
                subMenu.classList.replace("showSubMenu", "hideSubMenu");
            }
        });
    }
}

showInfoAccount();

var information = document.querySelector(".account #information");
var address = document.querySelector(".account #address");
var informationSection = document.querySelector(".infomation");
var addressSection = document.querySelector(".address");

var avatar = document.querySelector(".avatar img");
var inputAvatar = document.querySelector(".avatar input");

inputAvatar.addEventListener("change", function () {
    avatar.src = URL.createObjectURL(inputAvatar.files[0]);
});

var orderSection = document.querySelector(".order");
var noticeSection = document.querySelector(".notice");

var allAccountNav = document.querySelectorAll(".account li");

var allSection = [informationSection, addressSection, orderSection, noticeSection];

function showContent() {
    for (let i = 0; i < allAccountNav.length; i++) {
        if (i > 0) {
            allAccountNav[i].addEventListener("click", function () {
                for (let j = 0; j < allAccountNav.length; j++) {
                    allAccountNav[j].classList.remove("activeAccountNav");
                }
                for (let j = 0; j < allSection.length; j++) {
                    allSection[j].style.display = "none";
                }
                if (i == 1 || i == 2) {
                    isShowSubMenu = "false";
                    allAccountNav[0].classList.add("activeAccountNav");
                }
                allAccountNav[i].classList.add("activeAccountNav");
                allSection[i-1].style.display = "block";
                console.log(allAccountNav[i])
            });
        }
    }
}
showContent();



var modal = document.querySelector(".modal");
var modalContainer = document.querySelector(".modal .modal-container");
var closeModal = document.querySelector(".modal .closeModal");
var modalInput = document.querySelector(".modal-container input");
var modalSave = document.querySelector(".modal .modal-save");


modalSave.addEventListener("click", function () {
   var value = modalInput.value;
   if (value.length <= 0) {
       alert("Không được để trống");
   }
});

closeModal.addEventListener("click", function () {
    modal.classList.remove("showModal");
});

modal.addEventListener("click", function () {
    modal.classList.remove("showModal");
});

modalContainer.addEventListener("click", function () {
   event.stopPropagation();
});

var inputList = document.querySelectorAll(".part input");

function checkName() {
    var value = inputList[0].value;
    if (value.length <= 0) {
        alert("Tên không được để trống");
    }
}
function checkMail() {
    var value = inputList[1].value;
    if (value.length <= 0) {
        alert("Email không được để trống");
    }
}

function checkPhone() {
    var phoneInput = inputList[2].value;

    var charPhone = phoneInput.split("");
    if (charPhone.length >= 9 && charPhone.length <= 10) {
        for(var i = 0; i < charPhone.length; i++) {
            if(!(charPhone[i] >= '0' && charPhone[i] <= '9')){
                alert("Số điện thoại không hợp lệ");
                return;
            }
        }
    }else if(charPhone.length == 0){
        alert("Số điện thoại không được để trống");
    }else {
        alert("Số điện thoại không hợp lệ");
    }
}


var daySelect = document.querySelector(".dob-input .day");
var monthSelect = document.querySelector(".dob-input .month");
var yearSelect = document.querySelector(".dob-input .year");
function initDoB() {
    var htmlDay = "";
    for (let i = 1; i <= 31; i++) {
        htmlDay += `<option>${i}</option>`;
    }
    daySelect.innerHTML = htmlDay;

    var htmlMonth = "";
    for (let i = 1; i <= 12; i++) {
        htmlMonth += `<option>${i}</option>`;
    }
    monthSelect.innerHTML = htmlMonth;

    var htmlYear = "";
    for (let i = 1920; i <= new Date().getFullYear(); i++) {
        htmlYear += `<option>${i}</option>`;
    }
    yearSelect.innerHTML = htmlYear;
}
initDoB();

function namNhuan(yearIn) {
    if((yearIn % 400 === 0 && yearIn % 100 === 0 ) || (yearIn % 4 === 0 && yearIn % 100 !== 0)){
        return true;
    }
    return false;
}

function checkDoB() {
    var day = daySelect.value;
    var month = monthSelect.value;
    var year = yearSelect.value;
    var maxDay = 0;
    switch (month) {
        case "1":
        case "3":
        case "5":
        case "7":
        case "8":
        case "10":
        case "12":
            maxDay = 31;
            break;
        case "4":
        case "6":
        case "9":
        case "11":
            maxDay = 30;
            break;
        case "2":
            maxDay = namNhuan(year) ? 29:28;
            break;
    }
    if (day > maxDay) {
        alert("Không hợp lệ");
    }

}

var saveAccountInfo = document.querySelector(".infomation .save");
saveAccountInfo.addEventListener("click", function () {
    checkName();
    checkMail();
    checkPhone();
   checkDoB();
});



var btnAddress = document.querySelector(".address .btn-address");
btnAddress.addEventListener("click", function () {
    modal.classList.add("showModal");
});

var orderNavs = document.querySelectorAll(".order .nav li");
var orderShows = document.querySelectorAll(".order .orderShow");
function showOrderNavs() {
    for (let i = 0; i < orderNavs.length; i++) {
        orderNavs[i].addEventListener("click", function () {
            for (let j = 0; j < orderNavs.length; j++) {
                orderNavs[j].classList.remove("activeOrderNav");
                orderShows[j].style.display = "none";
            }
            orderShows[i].style.display= "block";
           orderNavs[i].classList.add("activeOrderNav");
        });
    }
}
showOrderNavs();

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