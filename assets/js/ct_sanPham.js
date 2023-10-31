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


// khởi tạo khi lấy dữ liệu từ local
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

// nhấn vào ảnh lớn
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

// rating star
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

// hiên thị sản phẩm liên quan
var relatedProducts = [
    {id: 1, name: "Giày Patin Micro Delta X 2023", price: "", priceSale: "14,990,000₫" ,colors: ["pink", "blue"], sizes: ["27-29", "30-32", "33-35", "36-38"], images: ["https://xpatin.com/wp-content/uploads/2023/05/cau-tao-anh-2-380x380.jpg", "https://xpatin.com/wp-content/uploads/2023/05/cau-tao-anh-1-380x380.jpg", "https://xpatin.com/wp-content/uploads/2023/05/thiet-ke-hop-dung-giay-patin-micro-delta-x-2023-380x380.jpg", "https://xpatin.com/wp-content/uploads/2023/05/giay-patin-micro-delta-x-2023-mau-hong-380x380.jpg", "https://xpatin.com/wp-content/uploads/2023/05/giay-patin-micro-delta-x-2023-mau-xanh-anh-2-380x380.jpg"], info: ["Thương hiệu MICRO – Thụy Sĩ", "Màu sắc: Hồng, Xanh dương", "Kích cỡ: 27-29, 30-32, 33-35, 36-38", "Khả năng điều chỉnh: Thay đổi được 3 kích cỡ khác nhau, rộng hơn khi chân trẻ to ra!", "Khả năng trượt: Bánh xe 72mm, Bánh xe 76mm, Vòng bi Slalom PRO9", "Độ bám: Bánh xe cao su độ đàn hồi và bám đường tốt", "Khung càng - Frames: Kích thước 231mm, Nhôm nguyên khối CNC", "Phanh (thắng): Không", "Khóa cổ giày: khóa dán cao cấp, Khóa thân giày: khóa cài nhựa cao cấp"]},
    {id: 2, name: "Giày Patin Micro DELTA LIBERTY", price: "", priceSale: "12,290,000₫",  colors: ["gray"] , sizes: ["36-38", "39-40", "41-42", "43-44"], images: ["https://xpatin.com/wp-content/uploads/2022/01/525e5cf1ed-380x380.jpg", "https://xpatin.com/wp-content/uploads/2022/01/13664b915b-380x380.jpg", "https://xpatin.com/wp-content/uploads/2022/01/c057c9f26e-min-380x380.jpg", "https://xpatin.com/wp-content/uploads/2022/01/giay-patin-micro-delta-liberty-mau-bac-380x380.jpg", "https://xpatin.com/wp-content/uploads/2022/01/giay-patin-micro-delta-liberty-thuong-hieu-thuy-si-380x380.jpg"], info:["Thương hiệuMICRO – Thụy Sĩ", "Màu sắc: Bạc", "Kích cỡ: 36-38, 39-40, 41-42, 43-44", "Khả năng điều chỉnh: Size đơn (1 kích cỡ) không điều chỉnh, Size kép (2 kích cỡ)", "Độ bám: Bánh xe cao su độ đàn hồi và bám đường tốt", "Khả năng trượt: Bánh xe 64mm-68mm, Bánh xe 72mm, Bánh xe 76mm, Bánh xe 80mm, Độ cứng bánh xe 85A, Vòng bi Slalom PRO9", "Khung càng - Frames: Kích thước 231mm, Kích thước 243mm, Nhôm nguyên khối CNC", "Khóa cổ giày: khóa dán cao cấp, Khóa thân giày: khóa cài nhựa cao cấp", "Thân giày: Đế giày đúc full carbon, Vải & da cao cấp", "Phanh (thắng): Không"]},
    {id: 3, name: "Giày Patin Micro Delta Junior", price: "", priceSale: "10,990,000₫",  colors: ["pink", "blue"] , sizes: ["27-29", "30-32", "33-35", "36-38"], images: ["https://xpatin.com/wp-content/uploads/2021/12/duoc-tao-thanh-boi-cong-nghe-tot-nhat-380x380.jpg", "https://xpatin.com/wp-content/uploads/2021/12/delta-junior-la-mau-giay-truot-rat-nhay-380x380.jpg", "https://xpatin.com/wp-content/uploads/2021/12/co-giay-composite-380x380.jpg", "https://xpatin.com/wp-content/uploads/2021/12/giay-patin-micro-delta-junior-mau-hong-380x380.jpg", "https://xpatin.com/wp-content/uploads/2021/12/giay-patin-micro-delta-junior-mau-xanh-anh-2-380x380.jpg"], info:["Thương hiệu: MICRO – Thụy Sĩ", "Màu sắc: Hồng, Xanh dương", "Kích cỡ: 27-29, 30-32, 33-35, 36-38", "Khả năng điều chỉnh: Thay đổi được 3 kích cỡ khác nhau, rộng hơn khi chân trẻ to ra!", "Khả năng trượt: ABEC7 PRO, Bánh xe 72mm, Bánh xe 76mm", "Độ bám: Bánh xe cao su độ đàn hồi và bám đường tốt", "Khung càng - Frames: Kích thước 231mm, Nhôm nguyên khối CNC", "Khóa cổ giày: khóa dán cao cấp, Khóa thân giày: khóa cài nhựa cao cấp", "Thân giày: Đế giày đúc full carbon, Vải & da cao cấp"]},
    {id: 4, name: "Giày Patin Micro DELTA X", price: "", priceSale: "10,990,000₫",  colors: ["pink", "blue"] , sizes: ["27-29", "30-32", "33-35", "36-38"], images: ["https://xpatin.com/wp-content/uploads/2019/10/Giày-Patin-Micro-DELTA-X-Hồng-380x380.jpg", "https://xpatin.com/wp-content/uploads/2019/10/Giày-Patin-Micro-DELTA-X-380x380.jpg", "https://xpatin.com/wp-content/uploads/2022/01/giay-patin-micro-delta-liberty-380x380.jpg", "https://xpatin.com/wp-content/uploads/2023/05/giay-patin-micro-delta-force-ii-silver-380x380.jpg", "https://xpatin.com/wp-content/uploads/2022/07/giay-patin-dynamic-speed-thuong-hieu-thuy-si-380x380.jpg"], info:["Thương hiệu: MICRO – Thụy Sĩ ", "Màu sắc: Hồng, Xanh dương", "Kích cỡ: 27-29, 30-32, 33-35, 36-38", "Khả năng điều chỉnh: Thay đổi được 3 kích cỡ khác nhau, rộng hơn khi chân trẻ to ra!", "Khả năng trượt: Bánh xe 72mm, Bánh xe 76mm, Vòng bi ABEC9", "Độ bám: Bánh xe cao su độ đàn hồi và bám đường tốt", "Khung càng - Frames: Kích thước 231mm, Nhôm nguyên khối CNC", "Khóa giày: Khóa cổ giày: khóa dán cao cấp, Khóa thân giày: khóa cài nhựa cao cấp", "Thân giày: Đế giày đúc full carbon, Vải & da cao cấp"]}
]

function renderRelatedProduct() {
    var html = "";
    for(var i = 0; i < relatedProducts.length; i++) {
            html += `<div class="product-item">`;
            html += `<a href="./ct_sanPham.html">`;
            html += `<img src= ${relatedProducts[i].images[0]} >`;
            html += `<h4 class="name"> ${relatedProducts[i].name} </h4>`;
            html += `<span class="price-section">` + relatedProducts[i].priceSale;
            html += `<h5 class="price"> ${relatedProducts[i].price} </h5>`;
            html += `</span>`;
            html += `<ul>`;
            html += `<li><i class="fa-solid fa-heart"></i></li>`;
            html += `<li><i class="fa-solid fa-cart-shopping"></i></li>`;
            html += `</ul>`;
            html += `</a>`;
            html += `</div>`;
    }

    document.querySelector(".related-product .product-list").innerHTML = html;
}

renderRelatedProduct();


function showDetail(t) {
    var t = document.querySelectorAll(".related-product .product-item");
    for (let i = 0; i < t.length; i++) {
        t[i].addEventListener("click", function () {
            console.log(t[i]);
            var index = i;
            var product = JSON.stringify(relatedProducts[index]);
            console.log(product)
            localStorage.clear();
            localStorage.setItem("san pham", product);
        })
    }
}

showDetail();


