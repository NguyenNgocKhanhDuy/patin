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
    }else {
        inputMin.value = 0;
        progress.style.left = 0+"%";
        inputMax.value = 15000000;
        progress.style.right = 0+"%";
        textMax.value = 15000000;
        textMin.value = 0;
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


var select = document.querySelector(".sort select");
select.addEventListener("change", function (){
    if (this.value == 1) {
        window.location.href = "sanPham-servlet?input-min="+textMin.value+"&input-max="+textMax.value
    }else if(this.value == 2){
        window.location.href = "sanPham-servlet?sort=asc&input-min="+textMin.value+"&input-max="+textMax.value
    }else if(this.value == 3) {
        window.location.href = "sanPham-servlet?sort=desc&input-min="+textMin.value+"&input-max="+textMax.value
    }
})
