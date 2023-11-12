var products = [
    {id: 1, name: "Giày Patin Micro Delta X 2023", price: "", priceSale: "14,990,000₫" ,khuyenMai: "Tặng đồ bảo hộ, túi đựng", colors: ["pink", "blue"], sizes: ["27-29", "30-32", "33-35", "36-38"], images: ["https://xpatin.com/wp-content/uploads/2023/05/cau-tao-anh-2-380x380.jpg", "https://xpatin.com/wp-content/uploads/2023/05/cau-tao-anh-1-380x380.jpg", "https://xpatin.com/wp-content/uploads/2023/05/thiet-ke-hop-dung-giay-patin-micro-delta-x-2023-380x380.jpg", "https://xpatin.com/wp-content/uploads/2023/05/giay-patin-micro-delta-x-2023-mau-hong-380x380.jpg", "https://xpatin.com/wp-content/uploads/2023/05/giay-patin-micro-delta-x-2023-mau-xanh-anh-2-380x380.jpg"], info: ["Thương hiệu MICRO – Thụy Sĩ", "Màu sắc: Hồng, Xanh dương", "Kích cỡ: 27-29, 30-32, 33-35, 36-38", "Khả năng điều chỉnh: Thay đổi được 3 kích cỡ khác nhau, rộng hơn khi chân trẻ to ra!", "Khả năng trượt: Bánh xe 72mm, Bánh xe 76mm, Vòng bi Slalom PRO9", "Độ bám: Bánh xe cao su độ đàn hồi và bám đường tốt", "Khung càng - Frames: Kích thước 231mm, Nhôm nguyên khối CNC", "Phanh (thắng): Không", "Khóa cổ giày: khóa dán cao cấp, Khóa thân giày: khóa cài nhựa cao cấp"]},
    {id: 2, name: "Giày Patin Micro DELTA LIBERTY", price: "", priceSale: "12,290,000₫",  khuyenMai: "Tặng đồ bảo hộ, túi đựng", colors: ["gray"] , sizes: ["36-38", "39-40", "41-42", "43-44"], images: ["https://xpatin.com/wp-content/uploads/2022/01/525e5cf1ed-380x380.jpg", "https://xpatin.com/wp-content/uploads/2022/01/13664b915b-380x380.jpg", "https://xpatin.com/wp-content/uploads/2022/01/c057c9f26e-min-380x380.jpg", "https://xpatin.com/wp-content/uploads/2022/01/giay-patin-micro-delta-liberty-mau-bac-380x380.jpg", "https://xpatin.com/wp-content/uploads/2022/01/giay-patin-micro-delta-liberty-thuong-hieu-thuy-si-380x380.jpg"], info:["Thương hiệuMICRO – Thụy Sĩ", "Màu sắc: Bạc", "Kích cỡ: 36-38, 39-40, 41-42, 43-44", "Khả năng điều chỉnh: Size đơn (1 kích cỡ) không điều chỉnh, Size kép (2 kích cỡ)", "Độ bám: Bánh xe cao su độ đàn hồi và bám đường tốt", "Khả năng trượt: Bánh xe 64mm-68mm, Bánh xe 72mm, Bánh xe 76mm, Bánh xe 80mm, Độ cứng bánh xe 85A, Vòng bi Slalom PRO9", "Khung càng - Frames: Kích thước 231mm, Kích thước 243mm, Nhôm nguyên khối CNC", "Khóa cổ giày: khóa dán cao cấp, Khóa thân giày: khóa cài nhựa cao cấp", "Thân giày: Đế giày đúc full carbon, Vải & da cao cấp", "Phanh (thắng): Không"]},
    {id: 3, name: "Giày Patin Micro Delta Junior", price: "", priceSale: "10,990,000₫",  khuyenMai: "Tặng đồ bảo hộ, túi đựng", colors: ["pink", "blue"] , sizes: ["27-29", "30-32", "33-35", "36-38"], images: ["https://xpatin.com/wp-content/uploads/2021/12/duoc-tao-thanh-boi-cong-nghe-tot-nhat-380x380.jpg", "https://xpatin.com/wp-content/uploads/2021/12/delta-junior-la-mau-giay-truot-rat-nhay-380x380.jpg", "https://xpatin.com/wp-content/uploads/2021/12/co-giay-composite-380x380.jpg", "https://xpatin.com/wp-content/uploads/2021/12/giay-patin-micro-delta-junior-mau-hong-380x380.jpg", "https://xpatin.com/wp-content/uploads/2021/12/giay-patin-micro-delta-junior-mau-xanh-anh-2-380x380.jpg"], info:["Thương hiệu: MICRO – Thụy Sĩ", "Màu sắc: Hồng, Xanh dương", "Kích cỡ: 27-29, 30-32, 33-35, 36-38", "Khả năng điều chỉnh: Thay đổi được 3 kích cỡ khác nhau, rộng hơn khi chân trẻ to ra!", "Khả năng trượt: ABEC7 PRO, Bánh xe 72mm, Bánh xe 76mm", "Độ bám: Bánh xe cao su độ đàn hồi và bám đường tốt", "Khung càng - Frames: Kích thước 231mm, Nhôm nguyên khối CNC", "Khóa cổ giày: khóa dán cao cấp, Khóa thân giày: khóa cài nhựa cao cấp", "Thân giày: Đế giày đúc full carbon, Vải & da cao cấp"]},
    {id: 4, name: "Giày Patin Micro DELTA X", price: "", priceSale: "10,990,000₫",  khuyenMai: "Tặng đồ bảo hộ, túi đựng", colors: ["pink", "blue"] , sizes: ["27-29", "30-32", "33-35", "36-38"], images: ["https://xpatin.com/wp-content/uploads/2019/10/Giày-Patin-Micro-DELTA-X-Hồng-380x380.jpg", "https://xpatin.com/wp-content/uploads/2019/10/Giày-Patin-Micro-DELTA-X-380x380.jpg", "https://xpatin.com/wp-content/uploads/2022/01/giay-patin-micro-delta-liberty-380x380.jpg", "https://xpatin.com/wp-content/uploads/2023/05/giay-patin-micro-delta-force-ii-silver-380x380.jpg", "https://xpatin.com/wp-content/uploads/2022/07/giay-patin-dynamic-speed-thuong-hieu-thuy-si-380x380.jpg"], info:["Thương hiệu: MICRO – Thụy Sĩ ", "Màu sắc: Hồng, Xanh dương", "Kích cỡ: 27-29, 30-32, 33-35, 36-38", "Khả năng điều chỉnh: Thay đổi được 3 kích cỡ khác nhau, rộng hơn khi chân trẻ to ra!", "Khả năng trượt: Bánh xe 72mm, Bánh xe 76mm, Vòng bi ABEC9", "Độ bám: Bánh xe cao su độ đàn hồi và bám đường tốt", "Khung càng - Frames: Kích thước 231mm, Nhôm nguyên khối CNC", "Khóa giày: Khóa cổ giày: khóa dán cao cấp, Khóa thân giày: khóa cài nhựa cao cấp", "Thân giày: Đế giày đúc full carbon, Vải & da cao cấp"]},
    {id: 5, name: "Giày Patin tốc độ Micro Dynamic Speed Junior (3 bánh)", price: "", priceSale: "8,950,000₫",  khuyenMai: "Tặng đồ bảo hộ, túi đựng", colors: ["pink ", "blue"] , sizes: ["27-29", "30-32"], images: ["https://xpatin.com/wp-content/uploads/2022/07/giay-patin-toc-do-micro-dynamic-speed-junior-3-banh-mau-xanh-anh-2-380x380.jpg", "https://xpatin.com/wp-content/uploads/2022/07/giay-patin-toc-do-micro-dynamic-speed-junior-3-banh-380x380.jpg", "https://xpatin.com/wp-content/uploads/2022/07/giay-patin-toc-do-micro-dynamic-speed-junior-mau-hong-380x380.jpg", "https://xpatin.com/wp-content/uploads/2022/07/giay-patin-toc-do-micro-dynamic-speed-junior-3-banh-mau-hong.jpg", "https://xpatin.com/wp-content/uploads/2022/07/giay-patin-toc-do-micro-dynamic-speed-junior-3-banh-mau-xanh-anh-2-380x380.jpg"], info:["Thương hiệu MICRO – Thụy Sĩ" ,"Màu sắc: Hồng, Xanh dương" ,"Kích cỡ: 27-29, 30-32" ,"Khả năng điều chỉnh: Thay đổi được 3 kích cỡ khác nhau, rộng hơn khi chân trẻ to ra!" ,"Độ bám: Bánh xe cao su độ đàn hồi và bám đường tốt" ,"Khả năng trượt: Bánh xe 100mm, Twincam ILQ-9 Pro" ,"Khung càng - Frames: Nhôm nguyên khối CNC" ,"Khóa thân giày: khóa cài nhựa cao cấp" ,"Thân giày: Đế giày đúc full carbon, Vải & da cao cấp"]},
    {id: 6, name: "Giày Patin tốc độ Micro Dynamic Speed Junior (4 bánh)", price: "", priceSale: "8,950,000₫",  khuyenMai: "", colors: ["pink", "blue"] , sizes: ["27-29", "30-32", "33-35", "36-38"], images: ["https://xpatin.com/wp-content/uploads/2022/07/giay-patin-toc-do-micro-dynamic-speed-junior-4-banh-mau-hong.jpg", "https://xpatin.com/wp-content/uploads/2022/07/giay-patin-toc-do-micro-dynamic-speed-junior-mau-hong-380x380.jpg", "https://xpatin.com/wp-content/uploads/2022/07/giay-patin-dynamic-speed-thuong-hieu-thuy-si-380x380.jpg", "https://xpatin.com/wp-content/uploads/2023/05/giay-patin-micro-delta-x-2023-mau-xanh-380x380.jpg", "https://xpatin.com/wp-content/uploads/2019/09/Giày-Patin-Micro-LE-Xanh-380x380.jpg"], info:["Thương hiệu: MICRO – Thụy Sĩ" ,"Màu sắc: Hồng, Xanh dương","Kích cỡ: 27-29, 30-32, 33-35, 36-38","Khả năng điều chỉnh: Thay đổi được 3 kích cỡ khác nhau, rộng hơn khi chân trẻ to ra!","Độ bám: Bánh xe cao su độ đàn hồi và bám đường tốt","Khả năng trượt: Bánh xe 100mm, Bánh xe 90mm, Twincam ILQ-9 Pro","Khung càng - Frames: Nhôm nguyên khối CNC","Khóa thân giày: khóa cài nhựa cao cấp", "Thân giày: Đế giày đúc full carbon, Vải & da cao cấp"]},
    {id: 7, name: "Flying Eagle Drift Junior", price: "", priceSale: "8,900,000₫",  khuyenMai: "Tặng đồ bảo hộ, túi đựng", colors: ["pink", "yellow", "blue"] , sizes: ["28/29", "30/31", "32/33", "34/35", "36/37"], images: ["https://xpatin.com/wp-content/uploads/2019/12/drift-junior-blue-380x380.jpg", "https://xpatin.com/wp-content/uploads/2019/12/drift-junior-gorl-380x380.jpg", "https://xpatin.com/wp-content/uploads/2019/12/giay-patin-flying-eagle-f6-380x380.jpg", "https://xpatin.com/wp-content/uploads/2019/12/giay-patin-toc-do-speed-flying-eagle-leader-anh-2-380x380.jpg", "https://xpatin.com/wp-content/uploads/2019/12/giay-patin-flying-eagle-s6-2-380x380.jpg"], info:["Thương hiệu: FLYING EAGLE", "Màu sắc: Hồng, Vàng, Xanh dương", "Kích cỡ: 28/29, 30/31, 32/33, 34/35, 36/37", "Khả năng điều chỉnh: Size kép (2 kích cỡ)", "Khung càng - Frames: Nhôm nguyên khối CNC","Khả năng trượt: Bánh xe 68mm-70mm, Bánh xe 70mm-72mm, Vòng bi FLYING EAGLE PRO"]},
    {id: 8, name: "Giày Patin Micro INFINITE CE", price: "", priceSale: "3, 790,000₫", khuyenMai: "", colors: ["pink", "Green", "blue"], sizes: ["S(29 - 32)", "M(33 - 36)", "L(37 - 40)"], images: ["https://xpatin.com/wp-content/uploads/2022/07/giay-patin-micro-infinite-ce-mau-xanh-duong-380x380.jpg", "https://xpatin.com/wp-content/uploads/2022/07/giay-patin-micro-infinite-ce-mau-hong-380x380.jpg", "https://xpatin.com/wp-content/uploads/2022/07/giay-patin-toc-do-micro-dynamic-speed-junior-3-banh-mau-xanh.jpg", "https://xpatin.com/wp-content/uploads/2020/05/giay-micro-duality-mau-do-380x380.jpg", "https://xpatin.com/wp-content/uploads/2019/11/giay-patin-micro-sr-red-380x380.jpg"], info:["Thương hiệu :MICRO – Thụy Sĩ","Màu sắc: Hồng, Green, Xanh dương","Kích cỡ: S (29-32), M (33-36), L (37-40)","Khả năng điều chỉnh: Điều chỉnh được 4 cỡ. Có thể nới rộng giày Trượt khi chân trẻ to ra!","Khả năng trượt: Bánh xe 64mm-68mm, Bánh xe 68mm-70mm, Bánh xe 70mm-72mm, Vòng bi ABEC7","Khóa cổ giày: khóa đóng nhựa dẻo cao cấp, Khóa thân giày: khóa cài nhựa cao cấp"]},
    {id: 9, name: "Giày Patin Micro INFINITE SE", price: "", priceSale: "3,650,000₫",  khuyenMai: "", colors: ["pink", "blue"] , sizes: ["S (29-32)", "M (33-36)", "L (37-40)"], images: ["https://xpatin.com/wp-content/uploads/2022/07/giay-patin-micro-infinite-se-thuong-hieu-thuy-si-380x380.jpg", "https://xpatin.com/wp-content/uploads/2022/07/khoa-ban-tu-dong-tinh-te-de-dang-thao-tac-380x380.jpg", "https://xpatin.com/wp-content/uploads/2022/07/liner-lot-trong-giay-em-ai-thoang-khi-co-the-thao-roi-ve-sinh-380x380.jpg", "https://xpatin.com/wp-content/uploads/2022/07/giay-patin-micro-infinite-se-mau-hong-380x380.jpg", "https://xpatin.com/wp-content/uploads/2022/07/giay-patin-micro-infinite-se-mau-xanh-380x380.jpg"], info:["Thương hiệu: MICRO – Thụy Sĩ","Màu sắc: Hồng, Xanh dương","Kích cỡ: S (29-32), M (33-36), L (37-40)","Khả năng điều chỉnh: Điều chỉnh được 4 cỡ. Có thể nới rộng giày Trượt khi chân trẻ to ra!","Khả năng trượt: Bánh xe 64mm-68mm, Bánh xe 68mm-70mm, Bánh xe 70mm-72mm, Vòng bi ABEC7","Khóa cổ giày: khóa đóng nhựa dẻo cao cấp, Khóa thân giày: khóa cài nhựa cao cấp"]},
    {id: 10, name: "Giày Patin Micro INFINITE", price: "", priceSale: "3,650,000₫",  khuyenMai: "", colors: ["black", "white", "yellow"] , sizes: ["S (29-32)", "M (33-36)", "L (37-40)"], images: ["https://xpatin.com/wp-content/uploads/2021/10/giay-patin-micro-infiniti-mau-vang-380x380.jpg", "https://xpatin.com/wp-content/uploads/2021/10/giay-patin-micro-infiniti-mau-trang-380x380.jpg", "https://xpatin.com/wp-content/uploads/2019/09/Giày-Patin-Micro-Discovery-Đen-380x380.jpg", "https://xpatin.com/wp-content/uploads/2022/07/giay-patin-toc-do-micro-dynamic-speed-junior-3-banh-mau-xanh.jpg", "https://xpatin.com/wp-content/uploads/2023/03/giay-patin-micro-delta-plus-co-carbon-380x380.jpg"], info:["Thương hiệu :MICRO – Thụy Sĩ" ,"Màu sắc: Đen đỏ, Trắng, Vàng","Kích cỡ: S (29-32), M (33-36), L (37-40)","Khả năng điều chỉnh: Điều chỉnh được 4 cỡ. Có thể nới rộng giày Trượt khi chân trẻ to ra!","Khả năng trượt: Bánh xe 64mm-68mm, Bánh xe 68mm-70mm, Bánh xe 70mm-72mm, Vòng bi ABEC7","Khóa cổ giày: khóa đóng nhựa dẻo cao cấp, Khóa thân giày: khóa cài nhựa cao cấp"]},
    {id: 11, name: "Giày Patin Micro DUALITY", price: "", priceSale: "3,520,000₫",  khuyenMai: "", colors: ["red", "blue", "green"] , sizes: ["S (29-32)", "M (33-36)", "L (37-40)"], images: ["https://xpatin.com/wp-content/uploads/2020/05/giay-micro-duality-mau-luc-380x380.jpg", "https://xpatin.com/wp-content/uploads/2020/05/giay-micro-duality-mau-xanh.jpg", "https://xpatin.com/wp-content/uploads/2019/10/Micro-DELTA-Pro-1-380x380.jpg", "https://xpatin.com/wp-content/uploads/2023/03/giay-patin-micro-delta-plus-co-carbon-380x380.jpg", "https://xpatin.com/wp-content/uploads/2022/07/giay-patin-micro-infinite-se-hai-mau-380x380.jpg"], info:["Thương hiệu:MICRO – Thụy Sĩ","Màu sắc: Đỏ, Xanh dương, Xanh lá","Kích cỡ: S (29-32), M (33-36), L (37-40)","Khóa cổ giày: khóa đóng nhựa dẻo, Khóa thân giày: khóa dán","Phanh (thắng): Chất liệu nhựa, Có ở chân giày phải","Khả năng trượt: Vòng bi ABEC5"]},
    {id: 12, name: "Giày Patin Micro LE", price:"", priceSale: "3,290,000₫",  khuyenMai: "", colors: ["pink", "blue"] , sizes: ["S (29-32)", "M (33-36)", "L (37-40)"], images: ["https://xpatin.com/wp-content/uploads/2019/09/khoa-giay-de-dang-thao-tac-va-om-chan-380x333.jpg", "https://xpatin.com/wp-content/uploads/2019/09/khung-nhom-banh-xe-chat-luong-cao-xpatin-380x333.jpg", "https://xpatin.com/wp-content/uploads/2019/09/mau-sac-noi-bat-thu-hut-xpatin-380x380.jpg", "https://xpatin.com/wp-content/uploads/2019/09/Giày-Patin-Micro-LE-Hồng-380x380.jpg", "https://xpatin.com/wp-content/uploads/2019/09/chan-chong-tray-bao-ve-than-giay-xpatin-380x333.jpg"], info:["Thương hiệu:MICRO – Thụy Sĩ","Màu sắc: Hồng, Xanh dương","Kích cỡ: S (29-32), M (33-36), L (37-40)","Khả năng điều chỉnh: Điều chỉnh được 4 cỡ. Có thể nới rộng giày Trượt khi chân trẻ to ra!","Khả năng trượt:Bánh xe 64mm-68mm, Bánh xe 68mm-70mm, Bánh xe 70mm-72mm, Vòng bi ABEC7","Khóa cổ giày: khóa đóng nhựa dẻo cao cấp, Khóa thân giày: khóa cài nhựa cao cấp"]},
]

var carousel = document.getElementById("carousel");


// hiển thị sản phẩm sale
function renderProductSale() {
    var html = "";
    for(var i = 6; i < 11; i++) {
        html += `<div class="product-item">
                    <a href="./ct_sanPham.html">
                        <img src= ${products[i].images[0]} >
                        <h4 class="name"> ${products[i].name} </h4>
                        <span class="price-section"> ${products[i].priceSale}
                            <h5 class="price"> ${products[i].price} </h5>
                        </span> 
                        <ul>
                            <li><i class="fa-solid fa-heart like"></i></li>
                            <li><i class="fa-solid fa-cart-shopping cart"></i></li>
                        </ul>
                    </a>
                  </div>`;
    }
    document.getElementById("carousel").innerHTML = html;
    showDetailSale();

}
renderProductSale();

// Chi tiết sản phẩm của phần sale
function showDetailSale() {
    var t = document.querySelectorAll(".carousel .product-item");
    for (let i = 0; i < t.length; i++) {
        t[i].addEventListener("click", function () {
            var index = 10 + i;
            var product = JSON.stringify(products[index]);
            localStorage.clear();
            localStorage.setItem("san pham", product);
        })
    }
}


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





// Hàm hiển thị sản phẩm
function renderProduct() {
    var html = "";
    for(var i = 0; i < products.length; i++) {
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

    document.getElementById("product-list").innerHTML = html;
    showDetail();
}

renderProduct();

function showDetail() {
    var t = document.querySelectorAll(".product-list .product-item");
    for (let i = 0; i < t.length; i++) {
        t[i].addEventListener("click", function () {
            var index = i;
            var product = JSON.stringify(products[index]);
            localStorage.clear();
            localStorage.setItem("san pham", product);
        })
    }
}
