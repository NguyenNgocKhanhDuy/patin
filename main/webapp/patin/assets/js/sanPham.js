

// tự chuyển động sale
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


var inputMin = document.getElementById("min");
var inputMax = document.getElementById("max");
var progress = document.getElementById("progress");
var textMin = document.getElementById("text-min");
var textMax = document.getElementById("text-max");

var priceGap = 0;

progress.style.left = (textMin.value / inputMin.max) * 100 + "%";
progress.style.right = 100 - (textMax.value / inputMax.max) * 100 + "%";

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

    if((maxValue - minValue >= priceGap) && maxValue <= 15000000) {
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

function colorCheck() {
    for (let i = 0; i < checkBoxs.length; i++) {
        if (checkBoxs[i].checked === true) {
            if(checkBoxs[i].id == "black" || checkBoxs[i].id == "red" || checkBoxs[i].id == "blue"){
                colorItems[i].style.color = "#f3f6fa";
            }
            colorItems[i].style.backgroundColor = checkBoxs[i].id
        }
    }
}
colorCheck();


var select = document.querySelector(".sort select");
var hiddenSort = document.querySelector("#hiddenSort");
select.addEventListener("change", function (){
    if (this.value == 1){
        hiddenSort.value = "";
    }else if (this.value == 2){
        hiddenSort.value = "asc";
    }else if (this.value == 3){
        hiddenSort.value = "desc"
    }
    document.querySelector(".filterBtn").click();
})
