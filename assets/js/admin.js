var subMenu = document.querySelector(".account ul li:first-child .sub_menu");

var contentSections = document.querySelectorAll(".right > div");
var manageList = document.querySelectorAll(".account .menu li");

function showContent() {
    var index = 0;
    for (let i = 0; i < manageList.length; i++) {
        manageList[i].addEventListener("click", function () {
            if (i == 0) {
                subMenu.classList.replace("hideSubMenu", "showSubMenu");
            }
           if (i > 0) {
               for (let j = 0; j < manageList.length; j++) {
                   manageList[j].classList.remove("activeAccountNav");
               }
               for (let j = 0; j < contentSections.length; j++) {
                   contentSections[j].style.display = "none";
               }
               manageList[i].classList.add("activeAccountNav");
               contentSections[i-1].style.display = "block";
               if (i > 4) {
                   subMenu.classList.replace("showSubMenu", "hideSubMenu");
               }
           }
        });
    }
}
showContent();


var modalProduct = document.querySelector(".modal-product");
var modalBrand = document.querySelector(".modal-brand");
var modalContainer = document.querySelector(".modal-container");

var modalDelProduct = document.querySelector(".modal-containerProduct .del");
var modalDelBrand = document.querySelector(".modal-containerBrand .del");
var modalAddProduct = document.querySelector(".modal-containerProduct .add");
var modalAddBrand = document.querySelector(".modal-containerBrand .add");

var addProduct = document.querySelector(".product .add");

addProduct.addEventListener("click", function () {
    modalProduct.style.display = "flex";
});

var addBrand = document.querySelector(".brand .add");
addBrand.addEventListener("click", function () {
    modalBrand.style.display = "flex";
});

modalProduct.addEventListener("click", function () {
    modalProduct.style.display = "none";
});

modalBrand.addEventListener("click", function () {
    modalBrand.style.display = "none";
});

modalDelProduct.addEventListener("click", function () {
    modalProduct.style.display = "none";
});

modalDelBrand.addEventListener("click", function () {
    modalBrand.style.display = "none";
});

modalAddProduct.addEventListener("click", function () {
    modalProduct.style.display = "none";
});

modalAddBrand.addEventListener("click", function () {
    modalBrand.style.display = "none";
});

modalContainer.addEventListener("click", function () {
    event.stopPropagation();
});