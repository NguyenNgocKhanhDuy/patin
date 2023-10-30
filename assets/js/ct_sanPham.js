// Hiển thị sản phẩm
var product = JSON.parse(localStorage.getItem("san pham"));
console.log(product)

var imgMain = document.getElementById("img-main");
var listImg = document.getElementsByClassName("sub-img");

var productName = document.getElementById("name");

var productPrice = document.querySelector(".product .price-section");

var containerColor = document.querySelector(".container-checkColor");
var containerSize = document.querySelector(".container-checkSize");

var info = document.getElementById("info");
var review = document.getElementById("review");
var infoText = document.querySelector(".info-text");
var reviewText = document.querySelector(".review");


function initProduct() {
    imgMain.src = product.images[0];
    for (let i = 0; i < listImg.length; i++) {
        listImg[i].src = product.images[i];
    }

    productName.innerText = product.name;

    productPrice.innerHTML = `${product.priceSale}
            <h5 class="price">${product.price}</h5>`;

    var htmlColor = "";
    for (let i = 0; i < product.colors.length; i++) {
        htmlColor +=  `<div class="check-color"> <input type="radio" name="color"> </div>`;
    }
    containerColor.innerHTML = htmlColor;

    var htmlSize = "";
    for (let i = 0; i < product.sizes.length; i++) {
        htmlSize +=  `<div class="check-size"> ${product.sizes[i]} <input type="radio" name="size"> </div>`;
    }
    containerSize.innerHTML = htmlSize;


    for (let i = 0; i < product.colors.length; i++) {
        document.querySelectorAll(".check-color")[i].style.backgroundColor = product.colors[i];
    }

    var htmlInfo = `<h3 class="title">Thông tin sản phẩm</h3> <p class="product-info">`;
    for (let i = 0; i < product.info.length; i++) {
        htmlInfo += `${product.info[i]} </br>`;
    }
    htmlInfo += `</p>`;
    infoText.innerHTML = htmlInfo;

}

initProduct();


var imgModal = document.getElementById("imageInModal");
var modalImgClick = document.querySelector(".modal-img");
var closeModalImg = document.getElementById("closeModalImg");
var modalImgContainer = document.querySelector(".modal-img-container");
var nextImg = document.getElementById("nextImg");
var previousImg = document.getElementById("previousImg");

function changeImgMain() {
    for(var i = 0; i < listImg.length; i++) {
        listImg[i].addEventListener("click", function () {
           imgMain.src = this.src;
        });
    }
}

changeImgMain();

imgMain.addEventListener("click", function () {
    imgModal.src = this.src;
    modalImgClick.style.display = "flex";
});

closeModalImg.addEventListener("click", function () {
    modalImgClick.style.display = "none";
});

modalImgClick.addEventListener("click", function () {
    modalImgClick.style.display = "none";
});

modalImgContainer.addEventListener("click", function () {
   event.stopPropagation();
});

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

// Bỏ chọn
var deselectBtn = document.querySelector(".deselect");

// Chọn màu và size
var boxColor = document.querySelectorAll(".check-color");
var colorChecks = document.querySelectorAll(".check-color input");
var boxSizes = document.querySelectorAll(".check-size");
var sizeChecks = document.querySelectorAll(".check-size input");
var countColor = 0;
var countSize = 0;


function select() {
    for(let i  = 0; i < colorChecks.length; i++){
        colorChecks[i].addEventListener("click", function () {
            for(let j = 0; j < boxColor.length; j++) {
                boxColor[j].classList.remove("selectActive");
            }
            countColor = 1;
            boxColor[i].classList.add("selectActive");
            deselectBtn.style.visibility = "visible";
        });

        deselectBtn.addEventListener("click", function (){
            countColor = 0;
            countSize = 0;
            boxColor[i].classList.remove("selectActive");
            boxSizes[i].classList.remove("selectActive");
            deselectBtn.style.visibility = "hidden";
        });
    }

    for (let i = 0; i < sizeChecks.length; i++) {
        sizeChecks[i].addEventListener("click", function () {
            for (let j = 0; j < boxSizes.length; j++) {
                boxSizes[j].classList.remove("selectActive");
            }
            countSize = 1;
            boxSizes[i].classList.add("selectActive");
            deselectBtn.style.visibility = "visible";
        });



        deselectBtn.addEventListener("click", function (){
            countColor = 0;
            countSize = 0;
            boxColor[i].classList.remove("selectActive");
            boxSizes[i].classList.remove("selectActive");
            deselectBtn.style.visibility = "hidden";
        });
    }

}
select();

var minus = document.getElementById("minus");
var plus = document.getElementById("plus");
var inputQuantity = document.querySelector(".quantity input");

minus.addEventListener("click", function () {
   var value = parseInt(inputQuantity.value);
   if (value > 1) {
       value--;
   }
   inputQuantity.value = value;
});

plus.addEventListener("click", function () {
   var value = parseInt(inputQuantity.value);
   value++;
   inputQuantity.value = value;
});


var addToCart = document.querySelector(".addTocart");

addToCart.addEventListener("click", function () {
    var value = parseInt(inputQuantity.value);
    if(countSize > 0 && countColor > 0){
        if (value > 0) {
            alert("Thêm vào giỏ hàng thành công");
        }else {
            alert("Số lượng phải lớn hơn hoặc bằng 1");
        }
    }else {
        alert("Chọn màu và kích cỡ");
    }
});



var addToLike = document.getElementById("addToLike");
var iconHeart = document.querySelector("#addToLike i");
var checklike = 0;
addToLike.addEventListener("click", function () {
    if (checklike == 0) {
        iconHeart.classList.replace("fa-regular", "fa-solid");
        addToLike.classList.add("heartActive");
        checklike = 1;
        alert("Thêm vào danh sách yêu thích thành công")
    }else {
        iconHeart.classList.replace("fa-solid", "fa-regular");
        addToLike.classList.remove("heartActive");
        checklike = 0;
        alert("Loại bỏ khỏi danh sách yêu thích thành công")
    }
});


info.addEventListener("click", function (){
    infoText.style.display = "block";
    reviewText.style.display = "none";
})

review.addEventListener("click", function (){
    reviewText.style.display = "flex";
    infoText.style.display = "none";
})

var stars = document.querySelectorAll(".rating-star i");
for (let i = 0; i < stars.length; i++) {
    stars[i].addEventListener("click", function () {
        for (let j = 0; j < stars.length; j++) {
            if(i >= j) {
                stars[j].classList.add("starActive");
            }else {
                stars[j].classList.remove("starActive");
            }
        } 
    });
}