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

var detail = document.querySelector(".product-item .detail");

var modal = document.querySelector(".modal");
var modalContainer = document.querySelector(".modal-container");
var modalDel = document.querySelector(".modal-container .del");
var modalComplete = document.querySelector(".modal-container .complete");

var note = document.querySelector(".detail-note .note-content");


detail.addEventListener("click", function () {
  modal.style.display = "flex";
});

modal.addEventListener("click", function () {
   modal.style.display = "none";
});

modalDel.addEventListener("click", function () {
    modal.style.display = "none";
});

modalComplete.addEventListener("click", function () {
    modal.style.display = "none";
});

modalContainer.addEventListener("click", function () {
   event.stopPropagation();
});


