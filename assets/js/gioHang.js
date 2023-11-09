var quantityList = document.querySelectorAll(".product-item .quantity input");
var minusList = document.querySelectorAll(".product-item .quantity .minus");
var plusList = document.querySelectorAll(".product-item .quantity .plus");
var deleteList = document.querySelectorAll(".product-item .del");
var itemProductList = document.querySelectorAll(".product-list .product-item");
function quantity() {
    for (let i = 0; i < quantityList.length; i++) {
        minusList[i].addEventListener("click", function () {
            var value = quantityList[i].value;
            value--;
            if (value <= 0) {
                value = 1;
            }
            quantityList[i].value = value;
        });

        plusList[i].addEventListener("click", function () {
            var value = quantityList[i].value;
            value++;
            quantityList[i].value = value;
        });
    }
}

quantity();

function deleteProduct() {
    for (let i = 0; i < itemProductList.length; i++) {
        deleteList[i].addEventListener("click", function () {
           itemProductList[i].remove();
        });
    }
}

deleteProduct();