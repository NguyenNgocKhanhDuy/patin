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


var userDetails = document.querySelectorAll(".user-item .detail");

function showDetailUser() {
    for (let i = 0; i < userDetails.length; i++) {
        userDetails[i].addEventListener("click", function () {

            var modalEditUser = document.querySelector(".modal-Edituser");

            var modalDelEditUser = document.querySelector(".modal-containerEditUser .del");

            var modalAddEditUser = document.querySelector(".modal-containerEditUser .add");
            modalEditUser.style.display = "flex";

            modalEditUser.addEventListener("click", function () {
                modalEditUser.style.display = "none";
            });

            modalDelEditUser.addEventListener("click", function () {
                modalEditUser.style.display = "none";
            });
            modalAddEditUser.addEventListener("click", function () {
                modalEditUser.style.display = "none";
            });
        });
    }
}

showDetailUser();


var modalUser = document.querySelector(".modal-user");

var modalDelUser = document.querySelector(".modal-containerUser .del");

var modalAddUser = document.querySelector(".modal-containerUser .add");

var addUser = document.querySelector(".user .add");

addUser.addEventListener("click", function () {
    modalUser.style.display = "flex";
});

modalUser.addEventListener("click", function () {
    modalUser.style.display = "none";
});

modalDelUser.addEventListener("click", function () {
    modalUser.style.display = "none";
});
modalAddUser.addEventListener("click", function () {
    modalUser.style.display = "none";
});



var productDetails = document.querySelectorAll(".product-item .detail");

function showDetailProduct() {
    for (let i = 0; i < productDetails.length; i++) {
        productDetails[i].addEventListener("click", function () {

            var modalEditProduct = document.querySelector(".modal-Editproduct");

            var modalDelEditProduct = document.querySelector(".modal-containerEditProduct .del");

            var modalAddEditProduct = document.querySelector(".modal-containerEditProduct .add");
            modalEditProduct.style.display = "flex";

            modalEditProduct.addEventListener("click", function () {
                modalEditProduct.style.display = "none";
            });

            modalDelEditProduct.addEventListener("click", function () {
                modalEditProduct.style.display = "none";
            });
            modalAddEditProduct.addEventListener("click", function () {
                modalEditProduct.style.display = "none";
            });
        });
    }
}

showDetailProduct();

var brandDetails = document.querySelectorAll(".brand-item .detail");

function showDetailBrand() {
    for (let i = 0; i < brandDetails.length; i++) {
        brandDetails[i].addEventListener("click", function () {

            var modalEditBrand = document.querySelector(".modal-Editbrand");

            var modalDelEditBrand = document.querySelector(".modal-containerEditBrand .del");

            var modalAddEditBrand = document.querySelector(".modal-containerEditBrand .add");
            modalEditBrand.style.display = "flex";

            modalEditBrand.addEventListener("click", function () {
                modalEditBrand.style.display = "none";
            });

            modalDelEditBrand.addEventListener("click", function () {
                modalEditBrand.style.display = "none";
            });
            modalAddEditBrand.addEventListener("click", function () {
                modalEditBrand.style.display = "none";
            });
        });
    }
}

showDetailBrand();


var orderDetails = document.querySelectorAll(".order-item .detail");

function showDetailOrder() {
    for (let i = 0; i < orderDetails.length; i++) {
        orderDetails[i].addEventListener("click", function () {

            var modalEditOrder = document.querySelector(".modal-EditOrder");

            var modalDelEditOrder = document.querySelector(".modal-containerEditOrder .del");

            var modalAddEditOrder = document.querySelector(".modal-containerEditOrder .add");
            modalEditOrder.style.display = "flex";

            modalEditOrder.addEventListener("click", function () {
                modalEditOrder.style.display = "none";
            });

            modalDelEditOrder.addEventListener("click", function () {
                modalEditOrder.style.display = "none";
            });
            modalAddEditOrder.addEventListener("click", function () {
                modalEditOrder.style.display = "none";
            });
        });
    }
}

showDetailOrder();




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