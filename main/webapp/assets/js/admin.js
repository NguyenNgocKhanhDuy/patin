var subMenu = document.querySelector(".account ul li:first-child .sub_menu");

var contentSections = document.querySelectorAll(".right > div");
var manageList = document.querySelectorAll(".account .menu li");

var isShow = false;

function showManage() {
    manageList[0].addEventListener("click", function () {
        if (isShow == false){
            subMenu.classList.replace("hideSubMenu", "showSubMenu");
            isShow = true;
        }else {
            subMenu.classList.replace("hideSubMenu", "showSubMenu");
            isShow = false;
        }
    });
}
showManage();

function showContent() {

    for (let i = 0; i < manageList.length; i++) {
        manageList[i].addEventListener("click", function () {
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
                   manageList[0].classList.remove("activeAccountNav")
               }else {
                   manageList[0].classList.add("activeAccountNav")
               }
           }
        });
    }
}
showContent();

function modalDetail(userID) {
    var xhttp = new XMLHttpRequest();
    xhttp.open("GET", "showModalAdmin?userID="+userID, true)
    xhttp.responseType = 'json'
    xhttp.send()
    xhttp.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
           var c = {}
            c = xhttp.response
            console.log(c)
            addInModal(c)
        }
    };
}
function addInModal(user) {
    var html = '';
    var date = new Date(user.dob)

    html += `<div class="wrapper">
        <div class="main">
            <div class="hold">
                <label>Tên</label>
                <input type="text" value="${user.fullName}">
            </div>

            <div class="hold">
                <label>Email</label>
                <input type="email" value="${user.email}">
            </div>
            <div class="hold">
                <label>Địa chỉ</label>
                <input type="tel" value="${user.address}">
            </div>

        </div>
        <div class="more">
            <div class="hold">
                <label>Số điện thoại</label>
                <input type="tel" value="${user.phone}">
            </div>
            <div class="gender">
                <label>Giới tính:</label>
                <div class="selectGender">`

                if(user.sex == "Nam"){
                    html += `
                    <input type="radio" name="gender" checked = "true">
                    <label>Nam</label>
                    <input type="radio" name="gender">
                    <label>Nữ</label>`
                }else {
                    html += `
                    <input type="radio" name="gender">
                    <label>Nam</label>
                    <input type="radio" name="gender" checked = "true">
                    <label>Nữ</label>`
                }
                html +=
            `</div>
            </div>
            <div class="dob">
                <label>Ngày sinh:</label>
                <div class="dob-input">
                    <select class="day" name="day">
                        
                    </select>
                    <select class="month" name="month">
                        
                    </select>
                    <select class="year" name="year">
                        
                    </select>
                </div>
            </div>
            <div>
                <input type="file">
            </div>
        </div>
    </div>
    <button class="add">Cập nhật</button>`
    document.querySelector(".modal-containerEditUser form").innerHTML = html;
    initDoB(date.getDate(), date.getMonth() + 1, date.getFullYear());
}



function initDoB(day, month, year) {
    var daySelect = document.querySelectorAll("select.day");
    var monthSelect = document.querySelectorAll("select.month");
    var yearSelect = document.querySelectorAll("select.year");
    var htmlDay = "";
    for (let i = 1; i <= 31; i++) {
        if (i == day) {
            console.log("D"+i)
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
            console.log("M"+i)
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
            console.log("Y"+i)
            htmlYear += `<option selected>${i}</option>`;
        }else {
            htmlYear += `<option>${i}</option>`;
        }
    }
    for (let i = 0; i < yearSelect.length; i++) {
        yearSelect[i].innerHTML = htmlYear;
    }
}



var userDetails = document.querySelectorAll(".user-item .detail");


function showDetailUser() {
    for (let i = 0; i < userDetails.length; i++) {
        userDetails[i].addEventListener("click", function () {
            modalDetail(document.querySelectorAll(".user-item .index")[i].textContent)

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


var colorDetails = document.querySelectorAll(".color-item .detail");

function showDetailColor() {
    for (let i = 0; i < colorDetails.length; i++) {
        colorDetails[i].addEventListener("click", function () {

            var modalEditColor = document.querySelector(".modal-Editcolor");

            var modalDelEditColor = document.querySelector(".modal-containerEditColor .del");

            var modalAddEditColor = document.querySelector(".modal-containerEditColor .add");
            modalEditColor.style.display = "flex";

            modalEditColor.addEventListener("click", function () {
                modalEditColor.style.display = "none";
            });

            modalDelEditColor.addEventListener("click", function () {
                modalEditColor.style.display = "none";
            });
            modalAddEditColor.addEventListener("click", function () {
                modalEditColor.style.display = "none";
            });
        });
    }
}

showDetailColor();


var sizeDetails = document.querySelectorAll(".size-item .detail");

function showDetailSize() {
    for (let i = 0; i < sizeDetails.length; i++) {
        sizeDetails[i].addEventListener("click", function () {

            var modalEditSize = document.querySelector(".modal-Editsize");

            var modalDelEditSize = document.querySelector(".modal-containerEditSize .del");

            var modalAddEditSize = document.querySelector(".modal-containerEditSize .add");
            modalEditSize.style.display = "flex";

            modalEditSize.addEventListener("click", function () {
                modalEditSize.style.display = "none";
            });

            modalDelEditSize.addEventListener("click", function () {
                modalEditSize.style.display = "none";
            });
            modalAddEditSize.addEventListener("click", function () {
                modalEditSize.style.display = "none";
            });
        });
    }
}

showDetailSize();


// var orderDetails = document.querySelectorAll(".order-item .detail");
//
// function showDetailOrder() {
//     for (let i = 0; i < orderDetails.length; i++) {
//         orderDetails[i].addEventListener("click", function () {
//
//             var modalEditOrder = document.querySelector(".modal-EditOrder");
//
//             var modalDelEditOrder = document.querySelector(".modal-containerEditOrder .del");
//
//             var modalAddEditOrder = document.querySelector(".modal-containerEditOrder .add");
//             modalEditOrder.style.display = "flex";
//
//             modalEditOrder.addEventListener("click", function () {
//                 modalEditOrder.style.display = "none";
//             });
//
//             modalDelEditOrder.addEventListener("click", function () {
//                 modalEditOrder.style.display = "none";
//             });
//             modalAddEditOrder.addEventListener("click", function () {
//                 modalEditOrder.style.display = "none";
//             });
//         });
//     }
// }
//
// showDetailOrder();




var modalProduct = document.querySelector(".modal-product");
var modalBrand = document.querySelector(".modal-brand");
var modalColor = document.querySelector(".modal-color");
var modalSize = document.querySelector(".modal-size");

var modalDelProduct = document.querySelector(".modal-containerProduct .del");
var modalDelBrand = document.querySelector(".modal-containerBrand .del");
var modalDelColor = document.querySelector(".modal-containerColor .del");
var modalDelSize = document.querySelector(".modal-containerSize .del");
var modalAddProduct = document.querySelector(".modal-containerProduct .add");
var modalAddBrand = document.querySelector(".modal-containerBrand .add");
var modalAddColor = document.querySelector(".modal-containerColor .add");
var modalAddSize = document.querySelector(".modal-containerSize .add");

var addProduct = document.querySelector(".product .add");

addProduct.addEventListener("click", function () {
    modalProduct.style.display = "flex";
});

var addBrand = document.querySelector(".brand .add");
addBrand.addEventListener("click", function () {
    modalBrand.style.display = "flex";
});

var addColor = document.querySelector(".color .add");
addColor.addEventListener("click", function () {
    modalColor.style.display = "flex";
});
var addSize = document.querySelector(".size .add");
addSize.addEventListener("click", function () {
    modalSize.style.display = "flex";
});

modalProduct.addEventListener("click", function () {
    modalProduct.style.display = "none";
});

modalBrand.addEventListener("click", function () {
    modalBrand.style.display = "none";
});

modalColor.addEventListener("click", function () {
    modalColor.style.display = "none";
});

modalSize.addEventListener("click", function () {
    modalSize.style.display = "none";
});

modalDelProduct.addEventListener("click", function () {
    modalProduct.style.display = "none";
});

modalDelBrand.addEventListener("click", function () {
    modalBrand.style.display = "none";
});
modalDelColor.addEventListener("click", function () {
    modalColor.style.display = "none";
});
modalDelSize.addEventListener("click", function () {
    modalSize.style.display = "none";
});

modalAddProduct.addEventListener("click", function () {
    modalProduct.style.display = "none";
});

modalAddBrand.addEventListener("click", function () {
    modalBrand.style.display = "none";
});
modalAddColor.addEventListener("click", function () {
    modalColor.style.display = "none";
});
modalAddSize.addEventListener("click", function () {
    modalSize.style.display = "none";
});

var modalContainerUser = document.querySelector(".modalConUser");

modalContainerUser.addEventListener("click", function () {
    event.stopPropagation();
});

var modalContainerProduct = document.querySelector(".modalConProduct");

modalContainerProduct.addEventListener("click", function () {
    event.stopPropagation();
});

var modalContainerBrand = document.querySelector(".modal-containerEditBrand");

modalContainerBrand.addEventListener("click", function () {
    event.stopPropagation();
});

var modalContainerColor = document.querySelector(".modal-containerColor");

modalContainerColor.addEventListener("click", function () {
    event.stopPropagation();
});
var modalContainerSize = document.querySelector(".modal-containerSize");

modalContainerSize.addEventListener("click", function () {
    event.stopPropagation();
});

var modalContainerEditUser = document.querySelector(".modal-containerEditUser");

modalContainerEditUser.addEventListener("click", function () {
    event.stopPropagation();
});

var modalContainerEditProduct = document.querySelector(".modal-containerEditProduct");

modalContainerEditProduct.addEventListener("click", function () {
    event.stopPropagation();
});

var modalContainerEditBrand = document.querySelector(".modal-containerEditBrand");

modalContainerEditBrand.addEventListener("click", function () {
    event.stopPropagation();
});

var modalContainerEditColor = document.querySelector(".modal-containerEditColor");

modalContainerEditColor.addEventListener("click", function () {
    event.stopPropagation();
});

var modalContainerEditSize = document.querySelector(".modal-containerEditSize");

modalContainerEditSize.addEventListener("click", function () {
    event.stopPropagation();
});
