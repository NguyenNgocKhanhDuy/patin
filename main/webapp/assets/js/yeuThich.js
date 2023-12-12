var products = [
    {id: 1, name: "Giày Patin Micro Delta X 2023", price: "", priceSale: "14,990,000₫" ,khuyenMai: "Tặng đồ bảo hộ, túi đựng", colors: ["pink", "blue"], sizes: ["27-29", "30-32", "33-35", "36-38"], images: ["https://xpatin.com/wp-content/uploads/2023/05/cau-tao-anh-2-380x380.jpg", "https://xpatin.com/wp-content/uploads/2023/05/cau-tao-anh-1-380x380.jpg", "https://xpatin.com/wp-content/uploads/2023/05/thiet-ke-hop-dung-giay-patin-micro-delta-x-2023-380x380.jpg", "https://xpatin.com/wp-content/uploads/2023/05/giay-patin-micro-delta-x-2023-mau-hong-380x380.jpg", "https://xpatin.com/wp-content/uploads/2023/05/giay-patin-micro-delta-x-2023-mau-xanh-anh-2-380x380.jpg"], info: ["Thương hiệu MICRO – Thụy Sĩ", "Màu sắc: Hồng, Xanh dương", "Kích cỡ: 27-29, 30-32, 33-35, 36-38", "Khả năng điều chỉnh: Thay đổi được 3 kích cỡ khác nhau, rộng hơn khi chân trẻ to ra!", "Khả năng trượt: Bánh xe 72mm, Bánh xe 76mm, Vòng bi Slalom PRO9", "Độ bám: Bánh xe cao su độ đàn hồi và bám đường tốt", "Khung càng - Frames: Kích thước 231mm, Nhôm nguyên khối CNC", "Phanh (thắng): Không", "Khóa cổ giày: khóa dán cao cấp, Khóa thân giày: khóa cài nhựa cao cấp"]},
    {id: 2, name: "Giày Patin Micro DELTA LIBERTY", price: "", priceSale: "12,290,000₫",  khuyenMai: "Tặng đồ bảo hộ, túi đựng", colors: ["gray"] , sizes: ["36-38", "39-40", "41-42", "43-44"], images: ["https://xpatin.com/wp-content/uploads/2022/01/525e5cf1ed-380x380.jpg", "https://xpatin.com/wp-content/uploads/2022/01/13664b915b-380x380.jpg", "https://xpatin.com/wp-content/uploads/2022/01/c057c9f26e-min-380x380.jpg", "https://xpatin.com/wp-content/uploads/2022/01/giay-patin-micro-delta-liberty-mau-bac-380x380.jpg", "https://xpatin.com/wp-content/uploads/2022/01/giay-patin-micro-delta-liberty-thuong-hieu-thuy-si-380x380.jpg"], info:["Thương hiệuMICRO – Thụy Sĩ", "Màu sắc: Bạc", "Kích cỡ: 36-38, 39-40, 41-42, 43-44", "Khả năng điều chỉnh: Size đơn (1 kích cỡ) không điều chỉnh, Size kép (2 kích cỡ)", "Độ bám: Bánh xe cao su độ đàn hồi và bám đường tốt", "Khả năng trượt: Bánh xe 64mm-68mm, Bánh xe 72mm, Bánh xe 76mm, Bánh xe 80mm, Độ cứng bánh xe 85A, Vòng bi Slalom PRO9", "Khung càng - Frames: Kích thước 231mm, Kích thước 243mm, Nhôm nguyên khối CNC", "Khóa cổ giày: khóa dán cao cấp, Khóa thân giày: khóa cài nhựa cao cấp", "Thân giày: Đế giày đúc full carbon, Vải & da cao cấp", "Phanh (thắng): Không"]},
    {id: 3, name: "Giày Patin Micro Delta Junior", price: "", priceSale: "10,990,000₫",  khuyenMai: "Tặng đồ bảo hộ, túi đựng", colors: ["pink", "blue"] , sizes: ["27-29", "30-32", "33-35", "36-38"], images: ["https://xpatin.com/wp-content/uploads/2021/12/duoc-tao-thanh-boi-cong-nghe-tot-nhat-380x380.jpg", "https://xpatin.com/wp-content/uploads/2021/12/delta-junior-la-mau-giay-truot-rat-nhay-380x380.jpg", "https://xpatin.com/wp-content/uploads/2021/12/co-giay-composite-380x380.jpg", "https://xpatin.com/wp-content/uploads/2021/12/giay-patin-micro-delta-junior-mau-hong-380x380.jpg", "https://xpatin.com/wp-content/uploads/2021/12/giay-patin-micro-delta-junior-mau-xanh-anh-2-380x380.jpg"], info:["Thương hiệu: MICRO – Thụy Sĩ", "Màu sắc: Hồng, Xanh dương", "Kích cỡ: 27-29, 30-32, 33-35, 36-38", "Khả năng điều chỉnh: Thay đổi được 3 kích cỡ khác nhau, rộng hơn khi chân trẻ to ra!", "Khả năng trượt: ABEC7 PRO, Bánh xe 72mm, Bánh xe 76mm", "Độ bám: Bánh xe cao su độ đàn hồi và bám đường tốt", "Khung càng - Frames: Kích thước 231mm, Nhôm nguyên khối CNC", "Khóa cổ giày: khóa dán cao cấp, Khóa thân giày: khóa cài nhựa cao cấp", "Thân giày: Đế giày đúc full carbon, Vải & da cao cấp"]}
]



// xử lý chuyển trang
var productPerPage = 8;
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
            html += `<a href="./ct_sanPham.html">`;
            html += `<img src= ${products[i].images[0]} >`;
            html += `<h4 class="name"> ${products[i].name} </h4>`;
            html += `<span class="price-section">` + products[i].priceSale;
            html += `<h5 class="price"> ${products[i].price} </h5>`;
            html += `</span>`;
            html += `<ul>`;
            html += `<li><i class="fa-solid fa-heart like"></i></li>`;
            html += `<li><i class="fa-solid fa-cart-shopping cart"></i></li>`;
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

    if (totalPage < 2) {
        html += `<li class="numb"> <a class="pageNumberActive"> ${current} </a> </li>`;
    }else {
        // Trang 1
        if (current == 1) {
            if (totalPage < 3){
                afterPage = 1;
            }
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
            var iStart = 0;
            if (current-2 < 1) {
                iStart = current-1;
            }else {
                iStart = current-2;
            }
            for(var i = iStart; i <= totalPage; i++) {
                if(i == current) {
                    html += `<li class="numb"> <a class="pageNumberActive"> ${i} </a> </li>`;
                }else {
                    html += `<li class="numb" onclick="pageNumber(${i})"> <a> ${i} </a> </li>`;
                }
            }
        }
    }


    document.getElementById("number-page").innerHTML = html;


    // Active nút next, previous
    if (totalPage < 2) {
        previousPage.classList.remove("arrowActive");
        nextPage.classList.remove("arrowActive");
    }else {
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
    }

    // gán vị trí trang hiện tại cho currentPage
    currentPage = current;

    getProductNumberCurrentPage(current);
    renderProduct();
    getProduct();
    showDetail(getProduct());

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
    getProduct();
    showDetail(getProduct())
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
    getProduct();
    showDetail(getProduct());
});

// Lấy dữ liệu sản phầm lưu vào local chuyển sang trang chi tiết sản phẩm

function getProduct() {
    var ty = document.querySelectorAll(".product-list .product-item");
    return ty;
}


function showDetail(t) {
    for (let i = 0; i < t.length; i++) {
        t[i].addEventListener("click", function () {
            var index = i;
            var product = JSON.stringify(products[start + index]);
            localStorage.clear();
            localStorage.setItem("san pham", product);
        })
    }
}

showDetail(getProduct());
