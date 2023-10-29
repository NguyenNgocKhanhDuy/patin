
var carousel = document.getElementById("carousel");

var productsSale = [
    {id: 1, image: "./assets/images/product/calary-C9-den-banchay.jpg", name: "Giày Patin Calary C9", priceSale: "1,490,000₫", price: "---", colors: ["Trắng", "Xanh dương"], sizes: ["38", "39", "40", "41", "42", "43", "44"]},
    {id: 2, image: "./assets/images/product/fe-bkbk8-den-banchay.jpg", name: "Giày Patin Flying Eagle BKB K8", priceSale: "1,550,000₫", price: "---"},
    {id: 3, image: "./assets/images/product/fe-f1s-hong-banchay.jpg", name: "Giày Patin Flying Eagle F1S", priceSale: "1,440,000₫", price: "---"},
    {id: 4, image: "./assets/images/product/fe-s5s+-xanh-banchay.jpg", name: "Giày Patin Flying Eagle S5S+", priceSale: "1,800,000₫", price: "---"},
    {id: 5, image: "./assets/images/product/fe-s6s+-den-banchay.jpg", name: "Giày Patin Flying Eagle S6S+", priceSale: "1,940,000₫", price: "---"},
]


// hiển thị sản phẩm sale
function renderProductSale() {
    var html = "";
    for(var i = 0; i < productsSale.length; i++) {

        html += `<div class="product-item">
                    <a>
                        <img src= ${productsSale[i].image} >
                        <h4 class="name"> ${productsSale[i].name} </h4>
                        <span class="price-section"> ${productsSale[i].priceSale}
                            <h5 class="price"> ${productsSale[i].price} </h5>
                        </span> 
                        <ul>
                            <li><i class="fa-solid fa-heart"></i></li>
                            <li><i class="fa-solid fa-cart-shopping"></i></li>
                        </ul>
                    </a>
                  </div>`;


    }

    document.getElementById("carousel").innerHTML = html;
}
renderProductSale();


// Lấy dữ liệu sản phầm lưu vào local chuyển sang trang chi tiết sản phẩm
function showDetail() {
    var ty = document.querySelectorAll(".product-item");
    for (let i = 0; i < ty.length; i++) {
        ty[i].addEventListener("click", function () {
            var index = i;
            var product = JSON.stringify(productsSale[index]);
            localStorage.clear();
            localStorage.setItem("san pham", product);
        })
    }
}

showDetail();


var items = document.getElementsByClassName("product-item");
var next = document.getElementById("next");
var previous = document.getElementById("previous");

// kích thước 1 item
var itemWidth = items[0].clientWidth + 30;

var step = itemWidth;

var countMax = (items.length*itemWidth)/step;

var count = 0;
var direct = "next";

// Nhấn next
next.addEventListener("click", function (){
    carousel.scrollLeft += step;
    count++;
    if (count == (countMax-2)){
        count = 1;
        direct = "previous";
    }
});

// Nhấn previous
previous.addEventListener("click", function () {
    carousel.scrollLeft -= step;
    count++;
    if (count == (countMax-2)){
        count = 1;
        direct = "next";
    }
});


// Tự lướt
setInterval(function (){
    count++;
    if (count == (countMax-2)){
        count = 1;
        if (direct == "next"){
            direct = "previous";
        }else if(direct == "previous"){
            direct = "next";
        }
    }

    if (direct == "next"){
        carousel.scrollLeft += step;
    }else {
        carousel.scrollLeft -= step;
    }
}, 3000);


// PRICE RANGE
var inputMin = document.getElementById("min");
var inputMax = document.getElementById("max");
var progress = document.getElementById("progress");
var textMin = document.getElementById("text-min");
var textMax = document.getElementById("text-max");

var priceGap = 0;

// Kéo chuột range
function rangeSlider() {
    var minValue = parseInt(inputMin.value);

    var maxValue = parseInt(inputMax.value);

    if(maxValue - minValue < priceGap) {
        if (event.target.id === "min"){
            inputMin.value = maxValue - priceGap;
        }else {
            inputMax.value = minValue + priceGap;
        }
    }else {
        // Thiết lập thanh màu
        progress.style.left = (minValue / inputMin.max) * 100 + "%";
        progress.style.right = 100 - (maxValue / inputMax.max) * 100 + "%";
    }
    // gán giá trị vào ô input
    textMin.value = inputMin.value;
    textMax.value = inputMax.value;
}


// Nhập ô input
function rangeText() {
    var minValue = parseInt(textMin.value);
    var maxValue = parseInt(textMax.value);

    if((maxValue - minValue >= priceGap) && maxValue <= 10000) {
        if (event.target.id === "text-min"){
            inputMin.value = minValue;
            progress.style.left = (minValue / inputMin.max) * 100 + "%";
        }else {
            inputMax.value = maxValue;
            progress.style.right = 100 - (maxValue / inputMax.max) * 100 + "%";
        }
    }
}

// COLOR
var colorItems = document.getElementsByClassName("color-item");
var checkBoxs = document.getElementsByClassName("check-color");

// Đổi màu nền
function changeBG(input) {
    for(var i = 0; i < checkBoxs.length; i++) {
        if(checkBoxs[i] === input){
            if(input.checked === true){
                if(input.id == "black" || input.id == "red" || input.id == "blue"){
                    colorItems[i].style.color = "#f3f6fa";
                }
                colorItems[i].style.backgroundColor = input.id;
                return;
            }else{
                if(input.id == "black" || input.id == "red" || input.id == "blue"){
                    colorItems[i].style.color = "black";
                }
                colorItems[i].style.backgroundColor = "#f3f6fa";
            }
        }
    }
}

// List Sản phẩm
var products = [
    {id: 1, image: "./assets/images/product/soft-a1/soft-a1-xanh.jpg", name: "Giày Patin SOFT A1", priceSale: "850,000₫", price: "1,065,000₫", color: ["Đen", "Hồng", "Xanh dương"]},
    {id: 2, image: "./assets/images/product/soft-a1/soft-a1-xanh.jpg", name: "2", priceSale: "850,000₫", price: "1,065,000₫"},
    {id: 3, image: "./assets/images/product/soft-a1/soft-a1-xanh.jpg", name: "3", priceSale: "850,000₫", price: "1,065,000₫"},
    {id: 4, image: "./assets/images/product/soft-a1/soft-a1-xanh.jpg", name: "4", priceSale: "850,000₫", price: "1,065,000₫"},
    {id: 5, image: "./assets/images/product/soft-a1/soft-a1-xanh.jpg", name: "5", priceSale: "850,000₫", price: "1,065,000₫"},
    {id: 6, image: "./assets/images/product/soft-a1/soft-a1-xanh.jpg", name: "5", priceSale: "850,000₫", price: "1,065,000₫"},
    {id: 7, image: "./assets/images/product/soft-a1/soft-a1-xanh.jpg", name: "7", priceSale: "850,000₫", price: "1,065,000₫"}
]



var productPerPage = 2;
var currentPage = 1;
var start = 0;
var end = productPerPage;

var totalPage = Math.ceil(products.length / productPerPage);

var previousPage = document.getElementById("previousPage");
var nextPage = document.getElementById("nextPage");




// Hàm hiển thị sản phẩm
function renderProduct() {
    var html = "";
    for(var i = 0; i < products.length; i++) {
        if(i >= start && i < end) {
            html += `<div class="product-item">`;
            html += `<a href="#">`;
            html += `<img src= ${products[i].image} >`;
            html += `<h4 class="name"> ${products[i].name} </h4>`;
            html += `<span class="price-section">` + products[i].priceSale;
            html += `<h5 class="price"> ${products[i].price} </h5>`;
            html += `</span>`;
            html += `<ul>`;
            html += `<li><i class="fa-solid fa-heart"></i></li>`;
            html += `<li><i class="fa-solid fa-cart-shopping"></i></li>`;
            html += `</ul>`;
            html += `</a>`;
            html += `</div>`;
        }
    }

    document.getElementById("product-list").innerHTML = html;
}

renderProduct();


// Hàm xác định sản phẩm từ mấy tới mấy
function getProductNumberCurrentPage(currentPage) {
    start = (currentPage - 1) * productPerPage;
    end = currentPage * productPerPage;
}


// Hàm hiển thị số trang (3 trang)
function pageNumber(current) {
    var beforePage = current - 1;
    var afterPage = current + 1;
    var html = "";

    // Trang 1
    if (current == 1) {
        for(var i = current; i <= afterPage+1; i++) {
            if (i == current) {
                html += `<li class="numb"> <a class="pageNumberActive"> ${i} </a> </li>`;
            }else {
                html += `<li class="numb" onclick="pageNumber(${i})"> <a> ${i} </a> </li>`;
            }
        }
    }

    if(current > 1 && current < totalPage) {
        for (var i = beforePage; i <= afterPage; i++) {
            if(i == current) {
                html += `<li class="numb"> <a class="pageNumberActive"> ${i} </a> </li>`;
            }else {
                html += `<li class="numb" onclick="pageNumber(${i})"> <a> ${i} </a> </li>`;
            }
        }
    }

    // Trang cuối
    if(current == totalPage) {
        for(var i = current-2; i <= totalPage; i++) {
            if(i == current) {
                html += `<li class="numb"> <a class="pageNumberActive"> ${i} </a> </li>`;
            }else {
                html += `<li class="numb" onclick="pageNumber(${i})"> <a> ${i} </a> </li>`;
            }
        }
    }

    document.getElementById("number-page").innerHTML = html;


    // Active nút next, previous
    if(current > 1 && current < totalPage){
        nextPage.classList.add("arrowActive");
        previousPage.classList.add("arrowActive");
    }
    if (current === 1){
        nextPage.classList.add("arrowActive");
        previousPage.classList.remove("arrowActive");
    }
    if(current === totalPage){
        nextPage.classList.remove("arrowActive");
        previousPage.classList.add("arrowActive");
    }

    // gán vị trí trang hiện tại cho currentPage
    currentPage = current;

    getProductNumberCurrentPage(current);
    renderProduct();

}

pageNumber(currentPage);


// Nhấn next
nextPage.addEventListener("click", function (){
    currentPage++;
    if(currentPage >= totalPage){
        currentPage = totalPage;
        nextPage.classList.remove("arrowActive");

    }

    previousPage.classList.add("arrowActive");

    pageNumber(currentPage);
    getProductNumberCurrentPage(currentPage);
    renderProduct();
});


// Nhấn previous
previousPage.addEventListener("click", function (){
    currentPage--;

    if(currentPage <= 1){
        currentPage = 1;
        previousPage.classList.remove("arrowActive");

    }

    nextPage.classList.add("arrowActive");

    pageNumber(currentPage);
    getProductNumberCurrentPage(currentPage);
    renderProduct();
});