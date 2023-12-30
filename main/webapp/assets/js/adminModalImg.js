
var listImg = document.querySelectorAll(".product_detail .img img");
var imgModal = document.getElementById("imageInModal");
var modalImg = document.querySelector(".modal-img");
var closeModalImg = document.getElementById("closeModalImg");
var modalImgContainer = document.querySelector(".modal-img-container");
var nextImg = document.getElementById("nextImg");
var previousImg = document.getElementById("previousImg");


closeModalImg.addEventListener("click", function () {
    modalImg.style.display = "none";
});

modalImg.addEventListener("click", function () {
    modalImg.style.display = "none";
});

modalImgContainer.addEventListener("click", function () {
    event.stopPropagation();
});

function clickImg() {
    for (let i = 0; i < listImg.length; i++) {
        listImg[i].addEventListener('click', function () {
            modalImg.style.display = "flex"
            imgModal.src = listImg[i].src
        })
    }
}
clickImg();

function chageImg() {
    var index = 0;
    for(var i = 0; i < listImg.length; i++) {
        if (imgModal.src == listImg[i].src){
            index = i;
        }
    }

    if (event.target.id == "nextImg") {
        if(index == listImg.length-1) {
            index = 0;
        }else {
            index++;
        }
        imgModal.src = listImg[index].src;
    }

    if (event.target.id == "previousImg") {
        if(index == 0) {
            index = listImg.length-1;
        }else {
            index--;
        }
        imgModal.src = listImg[index].src;
    }
}

nextImg.addEventListener("click", chageImg);
previousImg.addEventListener("click", chageImg);

var detail = document.querySelector(".product_detail .general .detail");

detail.addEventListener("click", function () {
    modalGeneral.style.display = "flex"
})

var modalGeneral = document.querySelector(".modal-general");
var modalGeneralContainer = document.querySelector(".modal-general .modal-container");
var modalGeneralDel = document.querySelector(".modal-general .del");

modalGeneral.addEventListener("click", function () {
    modalGeneral.style.display = "none"
})
modalGeneralDel.addEventListener("click", function () {
    modalGeneral.style.display = "none"
})
modalGeneralContainer.addEventListener("click", function () {
    event.stopPropagation();
})

var addDetail = document.querySelector(".product_detail .add");
var modalAddDetail = document.querySelector(".modalAddDetail");
var modalAddDetailCon = document.querySelector(".modalAddDetail .modal-container");
var modalAddDetailDel = document.querySelector(".modalAddDetail .modal-container .del");

addDetail.addEventListener("click", function () {
    modalAddDetail.style.display = "flex"
})
modalAddDetail.addEventListener("click", function () {
    modalAddDetail.style.display = "none"
})
modalAddDetailDel.addEventListener("click", function () {
    modalAddDetail.style.display = "none"
})
modalAddDetailCon.addEventListener("click", function () {
    event.stopPropagation();
})


function modalDetail(id, size, color, select) {

    var xhttp = new XMLHttpRequest();
    xhttp.open("GET", `showModalAdmin?id=${id}&select=${select}&size=${size}&color=${color}`, true)
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



var productDetails = document.querySelectorAll(".product_detail .product-item .detail");

function showDetailProduct() {
    for (let i = 0; i < productDetails.length; i++) {
        productDetails[i].addEventListener("click", function () {
            modalDetail(document.querySelectorAll(".product_detail .id")[i].value,
                document.querySelectorAll(".product_detail .size")[i].textContent,
                document.querySelectorAll(".product_detail .color")[i].textContent, "product");
            modalEditDetail.style.display = "flex"
        });
    }
}

showDetailProduct();

var modalEditDetail = document.querySelector(".modalEditDetail")
var modalEditDetailContainer = document.querySelector(".modalEditDetail .modal-container")
var modalEditDetailDel = document.querySelector(".modalEditDetail .modal-container .del")

modalEditDetail.addEventListener("click", function () {
    modalEditDetail.style.display = "none"
})
modalEditDetailDel.addEventListener("click", function () {
    modalEditDetail.style.display = "none"
})
modalEditDetailContainer.addEventListener("click", function () {
    event.stopPropagation()
})

function addInModal(product) {
    var html =
                    `<div class="wrapper">
                        <div class="main">
                            <div class="hold">
                                <label>Tên sản phẩm</label>
                                <input type="text" name="name" value="${product.name}">
                            </div>
                            <div class="hold-2">
                                <div class="hold">
                                    <label>Giá gốc</label>
                                    <input type="text" name="price" value="${product.minPrice}">
                                </div>
                                <div class="hold">
                                    <label>Số lượng</label>
                                    <input type="number" name="quantity" value="${product.quantity}">
                                </div>
                            </div>
                        </div>
                        <div class="more">
                            <div class="hold-2">
                                <div class="hold">
                                    <label>Màu sắc</label>
                                    <select class="color" name="color">
                                      
                                    </select>
                                </div>
                                <div class="hold">
                                    <label>Size</label>
                                    <select class="size" name="size">
                                        
                                    </select>
                                </div>
                            </div>
                        </div>
                    </div>
                    <button type="submit" class="add">Cập nhật</button>`
    document.querySelector(".modalEditDetail form").innerHTML = html;
    getColorDB(product.color)
    getSizeDB(product.size)
}

function getColorDB(color) {
    var xhttp = new XMLHttpRequest();
    xhttp.open("GET", `showColor`, true)
    xhttp.responseType = 'json'
    xhttp.send()
    xhttp.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
            var c = {}
            c = xhttp.response
            console.log(c)
            addInColor(c, color)
        }
    };
}
function getSizeDB(size) {
    var xhttp = new XMLHttpRequest();
    xhttp.open("GET", `showSize`, true)
    xhttp.responseType = 'json'
    xhttp.send()
    xhttp.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
            var c = {}
            c = xhttp.response
            console.log(c)
            addInSize(c, size)
        }
    };
}

function addInColor(c, color) {
    var html = "";
    for (let i = 0; i < c.length; i++) {
        if (c[i].name == color){
            html += `<option selected value="${c[i].id}">${c[i].name}</option>`
        }else {
            html += `<option value="${c[i].id}">${c[i].name}</option>`
        }
    }
    document.querySelector(".modalEditDetail select.color").innerHTML = html
}
function addInSize(c, size) {
    var html = "";
    for (let i = 0; i < c.length; i++) {
        if (c[i].name == size){
            html += `<option selected value="${c[i].id}">${c[i].name}</option>`
        }else {
            html += `<option value="${c[i].id}">${c[i].name}</option>`
        }
    }
    document.querySelector(".modalEditDetail select.size").innerHTML = html
}
