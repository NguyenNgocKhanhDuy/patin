
var carousel = document.getElementById("carousel");

// List Sản phẩm
var products = [
    {id: 1, name: "Giày Patin Micro Delta X 2023", price: "", priceSale: "14,990,000₫" ,colors: ["pink", "blue"], sizes: ["27-29", "30-32", "33-35", "36-38"], images: ["https://xpatin.com/wp-content/uploads/2023/05/cau-tao-anh-2-380x380.jpg", "https://xpatin.com/wp-content/uploads/2023/05/cau-tao-anh-1-380x380.jpg", "https://xpatin.com/wp-content/uploads/2023/05/thiet-ke-hop-dung-giay-patin-micro-delta-x-2023-380x380.jpg", "https://xpatin.com/wp-content/uploads/2023/05/giay-patin-micro-delta-x-2023-mau-hong-380x380.jpg", "https://xpatin.com/wp-content/uploads/2023/05/giay-patin-micro-delta-x-2023-mau-xanh-anh-2-380x380.jpg"], info: ["Thương hiệu MICRO – Thụy Sĩ", "Màu sắc: Hồng, Xanh dương", "Kích cỡ: 27-29, 30-32, 33-35, 36-38", "Khả năng điều chỉnh: Thay đổi được 3 kích cỡ khác nhau, rộng hơn khi chân trẻ to ra!", "Khả năng trượt: Bánh xe 72mm, Bánh xe 76mm, Vòng bi Slalom PRO9", "Độ bám: Bánh xe cao su độ đàn hồi và bám đường tốt", "Khung càng - Frames: Kích thước 231mm, Nhôm nguyên khối CNC", "Phanh (thắng): Không", "Khóa cổ giày: khóa dán cao cấp, Khóa thân giày: khóa cài nhựa cao cấp"]},
    {id: 2, name: "Giày Patin Micro DELTA LIBERTY", price: "", priceSale: "12,290,000₫",  colors: ["gray"] , sizes: ["36-38", "39-40", "41-42", "43-44"], images: ["https://xpatin.com/wp-content/uploads/2022/01/525e5cf1ed-380x380.jpg", "https://xpatin.com/wp-content/uploads/2022/01/13664b915b-380x380.jpg", "https://xpatin.com/wp-content/uploads/2022/01/c057c9f26e-min-380x380.jpg", "https://xpatin.com/wp-content/uploads/2022/01/giay-patin-micro-delta-liberty-mau-bac-380x380.jpg", "https://xpatin.com/wp-content/uploads/2022/01/giay-patin-micro-delta-liberty-thuong-hieu-thuy-si-380x380.jpg"], info:["Thương hiệuMICRO – Thụy Sĩ", "Màu sắc: Bạc", "Kích cỡ: 36-38, 39-40, 41-42, 43-44", "Khả năng điều chỉnh: Size đơn (1 kích cỡ) không điều chỉnh, Size kép (2 kích cỡ)", "Độ bám: Bánh xe cao su độ đàn hồi và bám đường tốt", "Khả năng trượt: Bánh xe 64mm-68mm, Bánh xe 72mm, Bánh xe 76mm, Bánh xe 80mm, Độ cứng bánh xe 85A, Vòng bi Slalom PRO9", "Khung càng - Frames: Kích thước 231mm, Kích thước 243mm, Nhôm nguyên khối CNC", "Khóa cổ giày: khóa dán cao cấp, Khóa thân giày: khóa cài nhựa cao cấp", "Thân giày: Đế giày đúc full carbon, Vải & da cao cấp", "Phanh (thắng): Không"]},
    {id: 3, name: "Giày Patin Micro Delta Junior", price: "", priceSale: "10,990,000₫",  colors: ["pink", "blue"] , sizes: ["27-29", "30-32", "33-35", "36-38"], images: ["https://xpatin.com/wp-content/uploads/2021/12/duoc-tao-thanh-boi-cong-nghe-tot-nhat-380x380.jpg", "https://xpatin.com/wp-content/uploads/2021/12/delta-junior-la-mau-giay-truot-rat-nhay-380x380.jpg", "https://xpatin.com/wp-content/uploads/2021/12/co-giay-composite-380x380.jpg", "https://xpatin.com/wp-content/uploads/2021/12/giay-patin-micro-delta-junior-mau-hong-380x380.jpg", "https://xpatin.com/wp-content/uploads/2021/12/giay-patin-micro-delta-junior-mau-xanh-anh-2-380x380.jpg"], info:["Thương hiệu: MICRO – Thụy Sĩ", "Màu sắc: Hồng, Xanh dương", "Kích cỡ: 27-29, 30-32, 33-35, 36-38", "Khả năng điều chỉnh: Thay đổi được 3 kích cỡ khác nhau, rộng hơn khi chân trẻ to ra!", "Khả năng trượt: ABEC7 PRO, Bánh xe 72mm, Bánh xe 76mm", "Độ bám: Bánh xe cao su độ đàn hồi và bám đường tốt", "Khung càng - Frames: Kích thước 231mm, Nhôm nguyên khối CNC", "Khóa cổ giày: khóa dán cao cấp, Khóa thân giày: khóa cài nhựa cao cấp", "Thân giày: Đế giày đúc full carbon, Vải & da cao cấp"]},
    {id: 4, name: "Giày Patin Micro DELTA X", price: "", priceSale: "10,990,000₫",  colors: ["pink", "blue"] , sizes: ["27-29", "30-32", "33-35", "36-38"], images: ["https://xpatin.com/wp-content/uploads/2019/10/Giày-Patin-Micro-DELTA-X-Hồng-380x380.jpg", "https://xpatin.com/wp-content/uploads/2019/10/Giày-Patin-Micro-DELTA-X-380x380.jpg", "https://xpatin.com/wp-content/uploads/2022/01/giay-patin-micro-delta-liberty-380x380.jpg", "https://xpatin.com/wp-content/uploads/2023/05/giay-patin-micro-delta-force-ii-silver-380x380.jpg", "https://xpatin.com/wp-content/uploads/2022/07/giay-patin-dynamic-speed-thuong-hieu-thuy-si-380x380.jpg"], info:["Thương hiệu: MICRO – Thụy Sĩ ", "Màu sắc: Hồng, Xanh dương", "Kích cỡ: 27-29, 30-32, 33-35, 36-38", "Khả năng điều chỉnh: Thay đổi được 3 kích cỡ khác nhau, rộng hơn khi chân trẻ to ra!", "Khả năng trượt: Bánh xe 72mm, Bánh xe 76mm, Vòng bi ABEC9", "Độ bám: Bánh xe cao su độ đàn hồi và bám đường tốt", "Khung càng - Frames: Kích thước 231mm, Nhôm nguyên khối CNC", "Khóa giày: Khóa cổ giày: khóa dán cao cấp, Khóa thân giày: khóa cài nhựa cao cấp", "Thân giày: Đế giày đúc full carbon, Vải & da cao cấp"]},
    {id: 5, name: "Giày Patin tốc độ Micro Dynamic Speed Junior (3 bánh)", price: "", priceSale: "8,950,000₫",  colors: ["pink ", "blue"] , sizes: ["27-29", "30-32"], images: ["https://xpatin.com/wp-content/uploads/2022/07/giay-patin-toc-do-micro-dynamic-speed-junior-3-banh-mau-xanh-anh-2-380x380.jpg", "https://xpatin.com/wp-content/uploads/2022/07/giay-patin-toc-do-micro-dynamic-speed-junior-3-banh-380x380.jpg", "https://xpatin.com/wp-content/uploads/2022/07/giay-patin-toc-do-micro-dynamic-speed-junior-mau-hong-380x380.jpg", "https://xpatin.com/wp-content/uploads/2022/07/giay-patin-toc-do-micro-dynamic-speed-junior-3-banh-mau-hong.jpg", "https://xpatin.com/wp-content/uploads/2022/07/giay-patin-toc-do-micro-dynamic-speed-junior-3-banh-mau-xanh-anh-2-380x380.jpg"], info:["Thương hiệu MICRO – Thụy Sĩ" ,"Màu sắc: Hồng, Xanh dương" ,"Kích cỡ: 27-29, 30-32" ,"Khả năng điều chỉnh: Thay đổi được 3 kích cỡ khác nhau, rộng hơn khi chân trẻ to ra!" ,"Độ bám: Bánh xe cao su độ đàn hồi và bám đường tốt" ,"Khả năng trượt: Bánh xe 100mm, Twincam ILQ-9 Pro" ,"Khung càng - Frames: Nhôm nguyên khối CNC" ,"Khóa thân giày: khóa cài nhựa cao cấp" ,"Thân giày: Đế giày đúc full carbon, Vải & da cao cấp"]},
    {id: 6, name: "Giày Patin tốc độ Micro Dynamic Speed Junior (4 bánh)", price: "", priceSale: "8,950,000₫",  colors: ["pink", "blue"] , sizes: ["27-29", "30-32", "33-35", "36-38"], images: ["https://xpatin.com/wp-content/uploads/2022/07/giay-patin-toc-do-micro-dynamic-speed-junior-4-banh-mau-hong.jpg", "https://xpatin.com/wp-content/uploads/2022/07/giay-patin-toc-do-micro-dynamic-speed-junior-mau-hong-380x380.jpg", "https://xpatin.com/wp-content/uploads/2022/07/giay-patin-dynamic-speed-thuong-hieu-thuy-si-380x380.jpg", "https://xpatin.com/wp-content/uploads/2023/05/giay-patin-micro-delta-x-2023-mau-xanh-380x380.jpg", "https://xpatin.com/wp-content/uploads/2019/09/Giày-Patin-Micro-LE-Xanh-380x380.jpg"], info:["Thương hiệu: MICRO – Thụy Sĩ" ,"Màu sắc: Hồng, Xanh dương","Kích cỡ: 27-29, 30-32, 33-35, 36-38","Khả năng điều chỉnh: Thay đổi được 3 kích cỡ khác nhau, rộng hơn khi chân trẻ to ra!","Độ bám: Bánh xe cao su độ đàn hồi và bám đường tốt","Khả năng trượt: Bánh xe 100mm, Bánh xe 90mm, Twincam ILQ-9 Pro","Khung càng - Frames: Nhôm nguyên khối CNC","Khóa thân giày: khóa cài nhựa cao cấp", "Thân giày: Đế giày đúc full carbon, Vải & da cao cấp"]},
    {id: 7, name: "Flying Eagle Drift Junior", price: "", priceSale: "8,900,000₫",  colors: ["pink", "yellow", "blue"] , sizes: ["28/29", "30/31", "32/33", "34/35", "36/37"], images: ["https://xpatin.com/wp-content/uploads/2019/12/drift-junior-blue-380x380.jpg", "https://xpatin.com/wp-content/uploads/2019/12/drift-junior-gorl-380x380.jpg", "https://xpatin.com/wp-content/uploads/2019/12/giay-patin-flying-eagle-f6-380x380.jpg", "https://xpatin.com/wp-content/uploads/2019/12/giay-patin-toc-do-speed-flying-eagle-leader-anh-2-380x380.jpg", "https://xpatin.com/wp-content/uploads/2019/12/giay-patin-flying-eagle-s6-2-380x380.jpg"], info:["Thương hiệu: FLYING EAGLE", "Màu sắc: Hồng, Vàng, Xanh dương", "Kích cỡ: 28/29, 30/31, 32/33, 34/35, 36/37", "Khả năng điều chỉnh: Size kép (2 kích cỡ)", "Khung càng - Frames: Nhôm nguyên khối CNC","Khả năng trượt: Bánh xe 68mm-70mm, Bánh xe 70mm-72mm, Vòng bi FLYING EAGLE PRO"]},
    {id: 8, name: "Giày Patin Micro INFINITE CE", price: "", priceSale: "3, 790,000₫", colors: ["pink", "Green", "blue"], sizes: ["S(29 - 32)", "M(33 - 36)", "L(37 - 40)"], images: ["https://xpatin.com/wp-content/uploads/2022/07/giay-patin-micro-infinite-ce-mau-xanh-duong-380x380.jpg", "https://xpatin.com/wp-content/uploads/2022/07/giay-patin-micro-infinite-ce-mau-hong-380x380.jpg", "https://xpatin.com/wp-content/uploads/2022/07/giay-patin-toc-do-micro-dynamic-speed-junior-3-banh-mau-xanh.jpg", "https://xpatin.com/wp-content/uploads/2020/05/giay-micro-duality-mau-do-380x380.jpg", "https://xpatin.com/wp-content/uploads/2019/11/giay-patin-micro-sr-red-380x380.jpg"], info:["Thương hiệu :MICRO – Thụy Sĩ","Màu sắc: Hồng, Green, Xanh dương","Kích cỡ: S (29-32), M (33-36), L (37-40)","Khả năng điều chỉnh: Điều chỉnh được 4 cỡ. Có thể nới rộng giày Trượt khi chân trẻ to ra!","Khả năng trượt: Bánh xe 64mm-68mm, Bánh xe 68mm-70mm, Bánh xe 70mm-72mm, Vòng bi ABEC7","Khóa cổ giày: khóa đóng nhựa dẻo cao cấp, Khóa thân giày: khóa cài nhựa cao cấp"]},
    {id: 9, name: "Giày Patin Micro INFINITE SE", price: "", priceSale: "3,650,000₫",  colors: ["pink", "blue"] , sizes: ["S (29-32)", "M (33-36)", "L (37-40)"], images: ["https://xpatin.com/wp-content/uploads/2022/07/giay-patin-micro-infinite-se-thuong-hieu-thuy-si-380x380.jpg", "https://xpatin.com/wp-content/uploads/2022/07/khoa-ban-tu-dong-tinh-te-de-dang-thao-tac-380x380.jpg", "https://xpatin.com/wp-content/uploads/2022/07/liner-lot-trong-giay-em-ai-thoang-khi-co-the-thao-roi-ve-sinh-380x380.jpg", "https://xpatin.com/wp-content/uploads/2022/07/giay-patin-micro-infinite-se-mau-hong-380x380.jpg", "https://xpatin.com/wp-content/uploads/2022/07/giay-patin-micro-infinite-se-mau-xanh-380x380.jpg"], info:["Thương hiệu: MICRO – Thụy Sĩ","Màu sắc: Hồng, Xanh dương","Kích cỡ: S (29-32), M (33-36), L (37-40)","Khả năng điều chỉnh: Điều chỉnh được 4 cỡ. Có thể nới rộng giày Trượt khi chân trẻ to ra!","Khả năng trượt: Bánh xe 64mm-68mm, Bánh xe 68mm-70mm, Bánh xe 70mm-72mm, Vòng bi ABEC7","Khóa cổ giày: khóa đóng nhựa dẻo cao cấp, Khóa thân giày: khóa cài nhựa cao cấp"]},
    {id: 10, name: "Giày Patin Micro INFINITE", price: "", priceSale: "3,650,000₫",  colors: ["black", "white", "yellow"] , sizes: ["S (29-32)", "M (33-36)", "L (37-40)"], images: ["https://xpatin.com/wp-content/uploads/2021/10/giay-patin-micro-infiniti-mau-vang-380x380.jpg", "https://xpatin.com/wp-content/uploads/2021/10/giay-patin-micro-infiniti-mau-trang-380x380.jpg", "https://xpatin.com/wp-content/uploads/2019/09/Giày-Patin-Micro-Discovery-Đen-380x380.jpg", "https://xpatin.com/wp-content/uploads/2022/07/giay-patin-toc-do-micro-dynamic-speed-junior-3-banh-mau-xanh.jpg", "https://xpatin.com/wp-content/uploads/2023/03/giay-patin-micro-delta-plus-co-carbon-380x380.jpg"], info:["Thương hiệu :MICRO – Thụy Sĩ" ,"Màu sắc: Đen đỏ, Trắng, Vàng","Kích cỡ: S (29-32), M (33-36), L (37-40)","Khả năng điều chỉnh: Điều chỉnh được 4 cỡ. Có thể nới rộng giày Trượt khi chân trẻ to ra!","Khả năng trượt: Bánh xe 64mm-68mm, Bánh xe 68mm-70mm, Bánh xe 70mm-72mm, Vòng bi ABEC7","Khóa cổ giày: khóa đóng nhựa dẻo cao cấp, Khóa thân giày: khóa cài nhựa cao cấp"]},
    {id: 11, name: "Giày Patin Micro DUALITY", price: "", priceSale: "3,520,000₫",  colors: ["red", "blue", "green"] , sizes: ["S (29-32)", "M (33-36)", "L (37-40)"], images: ["https://xpatin.com/wp-content/uploads/2020/05/giay-micro-duality-mau-luc-380x380.jpg", "https://xpatin.com/wp-content/uploads/2020/05/giay-micro-duality-mau-xanh.jpg", "https://xpatin.com/wp-content/uploads/2019/10/Micro-DELTA-Pro-1-380x380.jpg", "https://xpatin.com/wp-content/uploads/2023/03/giay-patin-micro-delta-plus-co-carbon-380x380.jpg", "https://xpatin.com/wp-content/uploads/2022/07/giay-patin-micro-infinite-se-hai-mau-380x380.jpg"], info:["Thương hiệu:MICRO – Thụy Sĩ","Màu sắc: Đỏ, Xanh dương, Xanh lá","Kích cỡ: S (29-32), M (33-36), L (37-40)","Khóa cổ giày: khóa đóng nhựa dẻo, Khóa thân giày: khóa dán","Phanh (thắng): Chất liệu nhựa, Có ở chân giày phải","Khả năng trượt: Vòng bi ABEC5"]},
    {id: 12, name: "Giày Patin Micro LE", price:"", priceSale: "3,290,000₫",  colors: ["pink", "blue"] , sizes: ["S (29-32)", "M (33-36)", "L (37-40)"], images: ["https://xpatin.com/wp-content/uploads/2019/09/khoa-giay-de-dang-thao-tac-va-om-chan-380x333.jpg", "https://xpatin.com/wp-content/uploads/2019/09/khung-nhom-banh-xe-chat-luong-cao-xpatin-380x333.jpg", "https://xpatin.com/wp-content/uploads/2019/09/mau-sac-noi-bat-thu-hut-xpatin-380x380.jpg", "https://xpatin.com/wp-content/uploads/2019/09/Giày-Patin-Micro-LE-Hồng-380x380.jpg", "https://xpatin.com/wp-content/uploads/2019/09/chan-chong-tray-bao-ve-than-giay-xpatin-380x333.jpg"], info:["Thương hiệu:MICRO – Thụy Sĩ","Màu sắc: Hồng, Xanh dương","Kích cỡ: S (29-32), M (33-36), L (37-40)","Khả năng điều chỉnh: Điều chỉnh được 4 cỡ. Có thể nới rộng giày Trượt khi chân trẻ to ra!","Khả năng trượt:Bánh xe 64mm-68mm, Bánh xe 68mm-70mm, Bánh xe 70mm-72mm, Vòng bi ABEC7","Khóa cổ giày: khóa đóng nhựa dẻo cao cấp, Khóa thân giày: khóa cài nhựa cao cấp"]},
    {id: 13, name: "Giày Patin Flying Eagle S6S Speed", price: "", priceSale: "3,195,000₫",  colors: ["Đen"] , sizes: ["S (28-32)", "M (33-37)", "L (38-42)"], images: ["https://xpatin.com/wp-content/uploads/2019/12/giay-patin-flying-eagle-f3-380x380.jpg", "https://xpatin.com/wp-content/uploads/2019/12/giay-patin-flying-eagle-k7-den-380x380.jpg", "https://xpatin.com/wp-content/uploads/2019/09/Giày-Patin-Flying-Eagle-F110H-380x380.jpg", "https://xpatin.com/wp-content/uploads/2019/09/Giầy-Patin-Flying-Eagle-S5S-Xanh-380x380.jpg", "https://xpatin.com/wp-content/uploads/2019/09/Giày-Patin-Flying-Eagle-F3S-Đen-380x380.jpg"], info:["Thương hiệu: FLYING EAGLE","Màu sắc: Đen","Kích cỡ: S (28-32), M (33-37), L (38-42)","Khả năng điều chỉnh: Điều chỉnh được 5 cỡ. Có thể nới rộng giày Trượt khi chân trẻ to ra!","Khả năng trượt: Bánh xe 100mm, Vòng bi FLYING EAGLE PRO","Khóa cổ giày: khóa đóng nhựa dẻo, Khóa thân giày: khóa cài nhựa dẻo"]},
    {id: 14, name: "Giày Patin TheX ELITE", price: "", priceSale: "2,980,000₫",  colors: ["pink", "blue"] , sizes: ["S (28-31)", "M (32-35)", "L (36-39)"], images: ["https://xpatin.com/wp-content/uploads/2021/06/giay-patin-thex-elite-mau-hong-380x380.jpg", "https://xpatin.com/wp-content/uploads/2021/06/giay-patin-thex-elite-mau-xanh-380x380.jpg", "https://xpatin.com/wp-content/uploads/2019/09/Giày-Patin-Flying-Eagle-S6S-Speed-Đen-380x380.jpg", "https://xpatin.com/wp-content/uploads/2020/09/giay-patin-iskate-fb22-xanh-380x380.png", "https://xpatin.com/wp-content/uploads/2019/09/Giày-Patin-Micro-Discovery-Đen-380x380.jpg"], info:["Thương hiệu: THEX","Màu sắc: Hồng, Xanh dương","Kích cỡ: S (28-31), M (32-35), L (36-39)","Khả năng điều chỉnh: Điều chỉnh được 4 cỡ. Có thể nới rộng giày Trượt khi chân trẻ to ra!","Khả năng trượt: Bánh xe 64mm-68mm, Bánh xe 68mm-70mm","Khóa cổ giày: khóa đóng nhựa dẻo cao cấp, Khóa thân giày: khóa cài nhựa cao cấp"]},
    {id: 15, name: "Giày Patin Micro Discovery", price: "", priceSale: "2,950,000₫",  colors: ["black", "pink", "blue"] , sizes: ["S (29-32)", "M (33-36)", "L (37-40)"], images: ["https://xpatin.com/wp-content/uploads/2019/09/khoa-co-giay-patin-micro-discovery-380x380.jpg", "https://xpatin.com/wp-content/uploads/2019/09/phanh-thang-giay-patin-micro-discovery-380x380.jpg", "https://xpatin.com/wp-content/uploads/2019/09/than-giay-patin-micro-discovery-380x380.jpg", "https://xpatin.com/wp-content/uploads/2019/09/Giày-Patin-Micro-Discovery-Hồng-380x380.jpg", "https://xpatin.com/wp-content/uploads/2019/09/Giày-Patin-Micro-Discovery-Xanh-380x380.jpg"], info:["Thương hiệu: MICRO – Thụy Sĩ","Màu sắc: Đen, Hồng, Xanh dương","Kích cỡ: S (29-32), M (33-36), L (37-40)","Khả năng điều chỉnh: Điều chỉnh được 4 cỡ. Có thể nới rộng giày Trượt khi chân trẻ to ra!","Khả năng trượt: Bánh xe 64mm-68mm, Bánh xe 68mm-70mm, Bánh xe 70mm-72mm"]},

    {id: 16, name: "Giày patin Flying Eagle S7", price: "", priceSale: "2,800,000₫",  colors: ["black", "pink", "blue"] , sizes: ["L (37-41)", "M (32-36)", "S (27-31)"], images: ["https://xpatin.com/wp-content/uploads/2022/07/giay-patin-flying-eagle-s7-mau-hong-380x380.jpg", "https://xpatin.com/wp-content/uploads/2022/07/giay-patin-flying-eagle-s7-mau-den-380x380.jpg", "https://xpatin.com/wp-content/uploads/2019/12/giay-patin-flying-eagle-f3-380x380.jpg", "https://xpatin.com/wp-content/uploads/2019/12/giay-patin-flying-eagle-f6-380x380.jpg", "https://xpatin.com/wp-content/uploads/2019/09/Giầy-Patin-Flying-Eagle-S6S-Xanh-380x380.jpg"], info:["Màu sắc: Đen, Hồng, Xanh dương","Kích cỡ: L (37-41), M (32-36), S (27-31)"]},
    {id: 17, name: "Giày Patin TheX ATOM", price: "", priceSale: "2,780,000₫",  colors: ["Đen"] , sizes: ["S (28-31)", "M (32-35)", "L (36-39)"], images: ["https://xpatin.com/wp-content/uploads/2019/09/Giày-Patin-Flying-Eagle-NT-Combo-Xanh-380x380.jpg", "https://xpatin.com/wp-content/uploads/2021/05/giay-patin-flying-eagle-s5s-new-380x380.jpg", "https://xpatin.com/wp-content/uploads/2019/09/Giày-Patin-SOFT-A1-Xanh-380x380.jpg", "https://xpatin.com/wp-content/uploads/2020/10/giay-patin-flying-eagle-k8-den-380x380.jpg", "https://xpatin.com/wp-content/uploads/2020/01/giay-patin-flying-eagle-s6t-s6-tripple-380x380.jpg"], info:["Thương hiệu:THEX","Màu sắc: Đen","Kích cỡ: S (28-31), M (32-35), L (36-39)","Khả năng điều chỉnh: Điều chỉnh được 4 cỡ. Có thể nới rộng giày Trượt khi chân trẻ to ra!","Khả năng trượt: Bánh xe 64mm-68mm, Bánh xe 68mm-70mm"]},
    {id: 18, name: "Giày Patin Micro SHAPER", price: "", priceSale: "2,750,000₫",  colors: ["red", "blue"] , sizes: ["S (29-32)", "M (33-36)", "L (37-40)"], images: ["https://xpatin.com/wp-content/uploads/2019/11/giay-patin-micro-sr-red-380x380.jpg", "https://xpatin.com/wp-content/uploads/2021/12/giay-patin-micro-hml-380x380.jpg", "https://xpatin.com/wp-content/uploads/2022/07/giay-patin-micro-infinite-ce-mau-xanh-la-380x380.jpg", "https://xpatin.com/wp-content/uploads/2022/07/giay-patin-micro-infinite-se-hai-mau-380x380.jpg", "https://xpatin.com/wp-content/uploads/2021/10/giay-patin-micro-infiniti-mau-den-380x380.jpg"], info:["Thương hiệu: MICRO – Thụy Sĩ","Màu sắc:Đỏ, Xanh dương","Kích cỡ: S (29-32), M (33-36), L (37-40)","Khả năng điều chỉnh: Điều chỉnh được 4 cỡ. Có thể nới rộng giày Trượt khi chân trẻ to ra!","Khả năng trượt: Vòng bi ABEC5"]},
    {id: 19, name: "Giày Patin Micro MJ", price: "", priceSale: "2,650,000₫",  colors: ["pink", "yellow", "blue"] , sizes: ["S (29-32)", "M (33-36)", "L (37-40)"], images: ["https://xpatin.com/wp-content/uploads/2020/05/giay-micro-mj-mau-vang.jpg", "https://xpatin.com/wp-content/uploads/2020/05/giay-micro-mj-mau-hong.jpg", "https://xpatin.com/wp-content/uploads/2020/05/giay-micro-mj-mau-xanh.jpg", "https://xpatin.com/wp-content/uploads/2020/05/giay-micro-mj-mau-vang.jpg", "https://xpatin.com/wp-content/uploads/2020/05/giay-micro-mj-mau-hong.jpg"], info:["Thương hiệu: MICRO – Thụy Sĩ","Màu sắc: Hồng, Vàng, Xanh dương","Kích cỡ: S (29-32), M (33-36), L (37-40)","Khả năng trượt: Vòng bi ABEC5","Khả năng điều chỉnh: Điều chỉnh được 4 cỡ."]},
    {id: 20, name: "Giày patin Flying Eagle S8", price: "", priceSale: "2,540,000₫",  colors: ["black", "pink", "blue"] , sizes: ["L (37-41)", "M (32-36)", "S (27-31)"], images: ["https://xpatin.com/wp-content/uploads/2021/09/khoa-than-ket-hop-khoa-ban-tu-dong-va-khoa-dan-tien-loi-380x380.jpg", "https://xpatin.com/wp-content/uploads/2021/09/ti-mi-tren-tung-chi-tiet-nho-cau-tao-380x380.jpg", "https://xpatin.com/wp-content/uploads/2021/09/giay-truot-patin-flying-eagle-s8-mau-hong-anh-2-380x380.jpg", "https://xpatin.com/wp-content/uploads/2021/09/giay-truot-patin-flying-eagle-s8-mau-hong-380x380.jpg", "https://xpatin.com/wp-content/uploads/2021/09/thiet-ke-sang-trong-hien-dai-380x380.jpg"], info:["Màu sắc :Đen, Hồng, Xanh dương", "Kích cỡ: L (37-41), M (32-36), S (27-31)"]},
    {id: 21, name: "Giày patin Flying Eagle L8 Firefly (full 8 bánh đèn)", price: "", priceSale: "2,500,000₫",  colors: ["black", "pink", "blue"] , sizes: ["L (37-41)", "M (32-36)", "S (27-31)"], images: ["https://xpatin.com/wp-content/uploads/2023/03/giay-patin-flying-eagle-l8-mau-xanh-duong-380x380.jpg", "https://xpatin.com/wp-content/uploads/2023/03/giay-patin-flying-eagle-l8-mau-hong-380x380.jpg", "https://xpatin.com/wp-content/uploads/2019/12/giay-patin-flying-eagle-f2-380x380.jpg", "https://xpatin.com/wp-content/uploads/2019/12/giay-patin-flying-eagle-s6-2-380x380.jpg", "https://xpatin.com/wp-content/uploads/2019/12/giay-patin-flying-eagle-f5s-eclipse-xpatin-380x380.jpg"], info:["Màu sắc: Đen, Hồng, Xanh dương", "Kích cỡ: L (37-41), M (32-36), S (27-31)"]},
    {id: 22, name: "Giày Patin Flying Eagle S9 Dynamo", price: "", priceSale: "2,450,000₫",  colors: ["red", "pink", "blue"] , sizes: ["S (28-32)", "M (33-37)", "L (38-42)"], images: ["https://xpatin.com/wp-content/uploads/2022/02/giay-patin-flying-eagle-s9-mau-xanh-380x380.jpg", "https://xpatin.com/wp-content/uploads/2022/02/giay-patin-flying-eagle-s9-mau-do-380x380.jpg", "https://xpatin.com/wp-content/uploads/2020/10/giay-patin-flying-eagle-k8-den-380x380.jpg", "https://xpatin.com/wp-content/uploads/2020/01/giay-patin-flying-eagle-s6t-s6-tripple-380x380.jpg", "https://xpatin.com/wp-content/uploads/2019/12/giay-patin-flying-eagle-k7-den-380x380.jpg"], info:["Thương hiệu: FLYING EAGLE","Màu sắc: Đỏ, Hồng, Xanh dương","Kích cỡ: S (28-32), M (33-37), L (38-42)","Khả năng điều chỉnh: Điều chỉnh được 5 cỡ. Có thể nới rộng giày Trượt khi chân trẻ to ra!","Khả năng trượt: Bánh xe 68mm-70mm, Bánh xe 70mm-72mm, Vòng bi ABEC7"]},
    {id: 23, name: "Giày Patin Flying Eagle NT Combo", price: "", priceSale: "2,290,000₫",  colors: ["pink", "blue"] , sizes: ["S (28-31)"," M (32-35)", "L (36-39)"], images: ["https://xpatin.com/wp-content/uploads/2019/09/giay-truot-patin-flying-eagle-nt-combo-mau-hong-xpatin6-380x380.jpg", "https://xpatin.com/wp-content/uploads/2019/09/giay-truot-patin-flying-eagle-nt-combo-mau-hong-xpatin7-380x380.jpg", "https://xpatin.com/wp-content/uploads/2019/09/giay-truot-patin-flying-eagle-nt-combo-mau-hong-xpatin8-380x380.jpg", "https://xpatin.com/wp-content/uploads/2019/09/Giày-Patin-Flying-Eagle-NT-Combo-Xanh-380x380.jpg", "https://xpatin.com/wp-content/uploads/2019/09/Giày-Patin-Flying-Eagle-NT-Combo-Hồng-380x380.jpg"], info:["Thương hiệu: FLYING EAGLE","Màu sắc: Hồng, Xanh dương","Kích cỡ: S (28-31), M (32-35), L (36-39)","Khả năng điều chỉnh: Điều chỉnh được 4 cỡ. Có thể nới rộng giày Trượt khi chân trẻ to ra!","Khả năng trượt: Bánh xe 64mm-68mm, Bánh xe 68mm-70mm, Bánh xe 70mm-72mm, Vòng bi ABEC7"]},
    {id: 24, name: "Giày Patin Flying Eagle S6T (mẫu mới 2020)", price: "", priceSale: "1,990,000₫",  colors: ["black", "pink", "blue"] , sizes: ["S (28-32)", "M (33-37)", "L (38-42)"], images: ["https://xpatin.com/wp-content/uploads/2019/09/Giày-Patin-Flying-Eagle-F3S-Đen-380x380.jpg", "https://xpatin.com/wp-content/uploads/2019/12/giay-patin-flying-eagle-f2-380x380.jpg", "https://xpatin.com/wp-content/uploads/2019/09/Giày-Patin-Flying-Eagle-F4-Tím-380x380.jpg", "https://xpatin.com/wp-content/uploads/2019/09/Giầy-Patin-Flying-Eagle-F2S-Đen-380x380.jpg", "https://xpatin.com/wp-content/uploads/2019/11/giay-patin-flying-eagle-s5s-mau-xanh-380x380.jpg"], info:["Thương hiệu: FLYING EAGLE","Màu sắc: Đen, Hồng, Xanh dương","Kích cỡ: S (28-32), M (33-37), L (38-42)","Khả năng điều chỉnh: Điều chỉnh được 5 cỡ. Có thể nới rộng giày Trượt khi chân trẻ to ra!","Khả năng trượt: Bánh xe 64mm-68mm, Bánh xe 68mm-70mm, Bánh xe 70mm-72mm, Bánh xe 72mm-76mm, Vòng bi ABEC7"]},
    {id: 25, name: "Giày Patin Flying Eagle S6S+ (mẫu mới)", price: "", priceSale: "1,940,000₫",  colors: ["black", "pink", "blue"] , sizes: ["S (28-32)", "M (33-37)", "L (38-42)"], images: ["https://xpatin.com/wp-content/uploads/2021/07/giay-truot-patin-flying-eagle-s6s-mau-hong-380x380.jpg", "https://xpatin.com/wp-content/uploads/2021/07/giay-truot-patin-flying-eagle-s6s-mau-den-380x380.jpg", "https://xpatin.com/wp-content/uploads/2019/09/Giày-Patin-Flying-Eagle-F3S-Đen-380x380.jpg", "https://xpatin.com/wp-content/uploads/2019/09/Giày-Patin-Flying-Eagle-NT-Combo-Xanh-380x380.jpg", "https://xpatin.com/wp-content/uploads/2019/12/giay-patin-flying-eagle-f5s-eclipse-xpatin-380x380.jpg"], info:["Thương hiệu: FLYING EAGLE","Màu sắc: Đen, Hồng, Xanh dương","Kích cỡ: S (28-32), M (33-37), L (38-42)","Khả năng điều chỉnh: Điều chỉnh được 5 cỡ. Có thể nới rộng giày Trượt khi chân trẻ to ra!","Khả năng trượt: Bánh xe 68mm-70mm, Bánh xe 70mm-72mm, Vòng bi ABEC7"]},
    {id: 26, name: "Giày Patin Flying Eagle S5S+ New", price: "", priceSale: "1,800,000₫",  colors: ["black", "pink", "blue"] , sizes: ["S (28-32)"," M (33-37)", "L (38-42)"], images: ["https://xpatin.com/wp-content/uploads/2021/05/giay-patin-flying-eagle-s5s-new-mau-xanh-1-380x380.jpg", "https://xpatin.com/wp-content/uploads/2021/05/giay-patin-flying-eagle-s5s-new-mau-hong-1-380x380.jpg", "https://xpatin.com/wp-content/uploads/2021/05/giay-patin-flying-eagle-s5s-new-mau-den-1-380x380.jpg", "https://xpatin.com/wp-content/uploads/2021/05/giay-patin-flying-eagle-s5s-new-mau-xanh-1-380x380.jpg", "https://xpatin.com/wp-content/uploads/2021/05/giay-patin-flying-eagle-s5s-new-mau-hong-1-380x380.jpg"], info:["Thương hiệu: FLYING EAGLE" ,"Màu sắc: Đen, Hồng, Xanh dương","Kích cỡ: S (28-32), M (33-37), L (38-42)","Khả năng điều chỉnh: Điều chỉnh được 5 cỡ. Có thể nới rộng giày Trượt khi chân trẻ to ra!","Khả năng trượt:Bánh xe 68mm-70mm, Bánh xe 70mm-72mm, Vòng bi ABEC7"]},
    {id: 27, name: "Giày Patin Lakoko", price: "1,850,000₫", priceSale: "1,650,000₫",  colors: ["red", "pink"] , sizes: ["S (29-33)", "M (34-38)"], images: ["https://xpatin.com/wp-content/uploads/2019/12/giay-patin-papaison-tre-em-380x380.jpg", "https://xpatin.com/wp-content/uploads/2019/09/Giày-Patin-SOFT-C2-Xanh-380x380.jpg", "https://xpatin.com/wp-content/uploads/2020/10/giay-patin-iskate-arrow-do-380x380.jpg", "https://xpatin.com/wp-content/uploads/2019/09/Giày-Patin-Flying-Eagle-S6S-Speed-Đen-380x380.jpg", "https://xpatin.com/wp-content/uploads/2019/12/giay-iskate-ichi-den-380x380.jpg"], info:["Màu sắc: Đỏ, Hồng","Kích cỡ: S (29-33), M (34-38)","Khả năng điều chỉnh: Điều chỉnh được 4 cỡ","Khả năng trượt: Vòng bi ABEC7"]},
    {id: 28, name: "Giày Patin Flying Eagle S6S (hàng ngưng sản xuất)", price: "", priceSale: "1,650,000₫",  colors: ["black", "pink", "blue"] , sizes: ["S (28-32)", "M (33-37)", "L (38-42)"], images: ["https://xpatin.com/wp-content/uploads/2019/09/Giầy-Patin-Flying-Eagle-S6S-Xanh-380x380.jpg", "https://xpatin.com/wp-content/uploads/2019/09/Giầy-Patin-Flying-Eagle-S6S-Hồng-380x380.jpg", "https://xpatin.com/wp-content/uploads/2019/09/Giầy-Patin-Flying-Eagle-S6S-Đen-380x380.jpg", "https://xpatin.com/wp-content/uploads/2019/09/Giầy-Patin-Flying-Eagle-S6S-Xanh-380x380.jpg", "https://xpatin.com/wp-content/uploads/2019/09/Giầy-Patin-Flying-Eagle-S6S-Hồng-380x380.jpg"], info:["Thương hiệu: FLYING EAGLE","Màu sắc: Đen, Hồng, Xanh dương","Kích cỡ: S(28 - 32), M(33 - 37), L(38 - 42)","Khả năng điều chỉnh: Điều chỉnh được 5 cỡ.","Khả năng trượt: Bánh xe 64mm-68mm, Bánh xe 68mm-70mm, Bánh xe 70mm-72mm, Bánh xe 76mm, Vòng bi ABEC7"]},
    {id: 29, name: "Giày Patin Flying Eagle BKB K8 (Mẫu mới)", price: "1,550,000₫", priceSale: "",  colors: ["black", "pink", "blue"] , sizes: ["S (28-31)", "M (32-35)", "L (36-39)"], images: ["https://xpatin.com/wp-content/uploads/2020/10/giay-patin-flying-eagle-k8-den-2-380x380.jpg", "https://xpatin.com/wp-content/uploads/2020/10/giay-patin-flying-eagle-k8-xanh-2.jpg", "https://xpatin.com/wp-content/uploads/2020/10/giay-patin-flying-eagle-k8-hong-4-380x380.jpg", "https://xpatin.com/wp-content/uploads/2020/10/giay-patin-flying-eagle-k8-hong-380x380.jpg", "https://xpatin.com/wp-content/uploads/2020/10/giay-patin-flying-eagle-k8-xanh-380x380.jpg"], info:["Thương hiệu: FLYING EAGLE","Màu sắc: Đen, Hồng, Xanh dương","Kích cỡ: S (28-31), M (32-35), L (36-39)","Khả năng điều chỉnh: Điều chỉnh được 4 cỡ. Có thể nới rộng giày Trượt khi chân trẻ to ra!","Khả năng trượt: Bánh xe 64mm-68mm, Bánh xe 70mm-72mm, Bánh xe 72mm-76mm, Vòng bi ABEC7"]},
    {id: 30, name: "Giày Patin Flying Eagle S5S", price: "", priceSale: "1,550,000₫",  colors: ["pink", "black", "blue"] , sizes: ["S (28-32)", "M (33-37)", "L (38-42)"], images: ["https://xpatin.com/wp-content/uploads/2019/09/Giầy-Patin-Flying-Eagle-S5S-Đen-Đỏ-380x380.jpg", "https://xpatin.com/wp-content/uploads/2019/09/Giầy-Patin-Flying-Eagle-S5S-Hồng-380x380.jpg", "https://xpatin.com/wp-content/uploads/2019/09/giay-patin-flying-eagle-f5s-eclipse-380x380.jpg", "https://xpatin.com/wp-content/uploads/2019/12/giay-patin-flying-eagle-f2-380x380.jpg", "https://xpatin.com/wp-content/uploads/2019/09/Giày-Patin-Flying-Eagle-F7-380x380.jpg"], info:["Thương hiệu: FLYING EAGLE","Màu sắc: Hồng, Đen, Xanh dương","Kích cỡ: S (28-32), M (33-37), L (38-42)","Khả năng điều chỉnh: Điều chỉnh được 5 cỡ. Có thể nới rộng giày Trượt khi chân trẻ to ra!","Khả năng trượt: Bánh xe 64mm-68mm, Bánh xe 68mm-70mm, Bánh xe 70mm-72mm, Vòng bi ABEC7"]},


    {id: 31, name: "Giày Patin PAPAYA SK2 (2 màu)", price: "1,990,000₫", priceSale: "1,490,000₫",  colors: ["pink", "blue"] , sizes: ["M (34-37)", "S (30-33)"], images: ["https://xpatin.com/wp-content/uploads/2021/04/giay-patin-sk-2-xanh-anh-3-380x380.jpg", "https://xpatin.com/wp-content/uploads/2021/04/giay-patin-papaya-sk2-new-mau-xanh-380x380.jpg", "https://xpatin.com/wp-content/uploads/2021/04/giay-patin-papaya-sk2-new-mau-hong-380x380.jpg", "https://xpatin.com/wp-content/uploads/2021/04/giay-patin-sk-2-xanh-380x380.jpg", "https://xpatin.com/wp-content/uploads/2021/04/giay-patin-sk-2-hong-anh-2-380x380.jpg"], info:["Kích cỡ: M (34-37), S (30-33)","Màu sắc: Hồng, Xanh dương","Khả năng điều chỉnh: Điều chỉnh được 4 cỡ. Có thể nới rộng giày Trượt khi chân trẻ to ra!","Khả năng trượt: Vòng bi ABEC7"]},
    {id: 32, name: "Giày Patin Flying Eagle K7", price: "", priceSale: "1,490,000₫",  colors: ["black","pink", "blue"] , sizes: ["S (28-31)", "M (32-35)", "L (36-39)"], images: ["https://xpatin.com/wp-content/uploads/2019/12/giay-patin-flying-eagle-k7-hong-380x380.jpg", "https://xpatin.com/wp-content/uploads/2019/12/giay-patin-flying-eagle-k7-xanh-duong-380x380.jpg", "https://xpatin.com/wp-content/uploads/2019/09/Giầy-Patin-Flying-Eagle-F2S-Đen-380x380.jpg", "https://xpatin.com/wp-content/uploads/2019/10/giay-patin-flying-eagle-drift-2-380x380.jpg", "https://xpatin.com/wp-content/uploads/2019/12/giay-patin-flying-eagle-f5-380x380.jpg"], info:["Thương hiệu: FLYING EAGLE","Màu sắc: Đen, Hồng, Xanh dương","Kích cỡ: S(28 - 31), M(32 - 35), L(36 - 39)","Khả năng điều chỉnh: Điều chỉnh được 5 cỡ.Có thể nới rộng giày Trượt khi chân trẻ to ra!","Khả năng trượt: Vòng bi ABEC7"]},
    {id: 33, name: "Giày Patin SOFT C3", price: "1,790,000₫", priceSale: "1,490,000₫",  colors: ["black", "pink"] , sizes: ["S (28-31)", "M (32-35)", "L (36-39)"], images: ["https://xpatin.com/wp-content/uploads/2019/09/Giày-Patin-SOFT-A1-Xanh-380x380.jpg", "https://xpatin.com/wp-content/uploads/2021/06/giay-patin-thex-elite-mau-cam-380x380.jpg", "https://xpatin.com/wp-content/uploads/2019/09/Giày-Patin-SOFT-C2-Xanh-380x380.jpg", "https://xpatin.com/wp-content/uploads/2020/10/giay-patin-flying-eagle-k8-den-380x380.jpg", "https://xpatin.com/wp-content/uploads/2019/12/giay-patin-flying-eagle-k7-den-380x380.jpg"], info:["Thương hiệu: SOFT","Màu sắc: Đen, Hồng","Kích cỡ: S(28 - 31), M(32 - 35), L(36 - 39)","Khả năng điều chỉnh: Điều chỉnh được 4 cỡ. Có thể nới rộng giày Trượt khi chân trẻ to ra!","Khả năng trượt: Bánh xe 64mm-68mm, Bánh xe 68mm-70mm, Bánh xe 70mm-72mm, Vòng bi ABEC7"]},
    {id: 34, name: "Giày Patin iSkate FB22", price: "", priceSale: "1,380,000₫",  colors: ["pink", "blue"] , sizes: ["L (38-41), M (34-37)"], images: ["https://xpatin.com/wp-content/uploads/2020/09/giay-patin-iskate-fb22-hong-anh-2-380x380.jpg", "https://xpatin.com/wp-content/uploads/2020/09/giay-patin-iskate-fb22-hong-380x380.jpg", "https://xpatin.com/wp-content/uploads/2020/09/giay-patin-iskate-fb22-xanh-380x380.png", "https://xpatin.com/wp-content/uploads/2020/09/giay-patin-iskate-fb22-hong-anh-2-380x380.jpg", "https://xpatin.com/wp-content/uploads/2020/09/giay-patin-iskate-fb22-hong-380x380.jpg"], info:["Màu sắc: Hồng, Xanh dương","Kích cỡ: L (38-41), M (34-37)","Khả năng điều chỉnh: Điều chỉnh được 4 cỡ.Có thể nới rộng giày Trượt khi chân trẻ to ra!","Khả năng trượt: Bánh xe 70mm - 72mm, Bánh xe 72mm - 76mm, Vòng bi ABEC7"]},
    {id: 35, name: "Giày Patin SOFT C2", price: "1,500,000₫", priceSale: "1,260,000₫",  colors: ["pink", "blue"] , sizes: ["S (28-31)", "M (32-35)", "L (36-39)"], images: ["https://xpatin.com/wp-content/uploads/2020/05/giay-micro-shaper-xanh-duong-380x380.jpg", "https://xpatin.com/wp-content/uploads/2021/04/giay-patin-kf-1-xanh-anh-2-380x380.jpg", "https://xpatin.com/wp-content/uploads/2019/09/Giầy-Patin-Flying-Eagle-S5S-Xanh-380x380.jpg", "https://xpatin.com/wp-content/uploads/2020/05/giay-micro-mj-mau-xanh-dam.jpg", "https://xpatin.com/wp-content/uploads/2019/09/Giày-Patin-Flying-Eagle-S6S-Speed-Đen-380x380.jpg"], info:["Thương hiệu: SOFT","Màu sắc: Hồng, Xanh dương","Kích cỡ: S (28-31), M (32-35), L (36-39)","Khả năng điều chỉnh: Điều chỉnh được 4 cỡ. Có thể nới rộng giày Trượt khi chân trẻ to ra!","Khả năng trượt: Bánh xe 64mm-68mm, Bánh xe 68mm-70mm, Bánh xe 70mm-72mm, Vòng bi ABEC7"]},
    {id: 36, name: "Giày Patin iSkate ICHI", price: "", priceSale: "1,165,000₫",  colors: ["black", "pink", "Xanh dương"] , sizes: ["S (31-34)", "M (35-38)"], images: ["https://xpatin.com/wp-content/uploads/2019/12/giay-truot-patin-iskate-ichi-mau-xanh-xpatin5-380x380.jpg", "https://xpatin.com/wp-content/uploads/2019/12/giay-truot-patin-iskate-ichi-mau-xanh-xpatin6-380x380.jpg", "https://xpatin.com/wp-content/uploads/2019/12/giay-truot-patin-iskate-ichi-mau-xanh-xpatin7-380x380.jpg", "https://xpatin.com/wp-content/uploads/2019/12/giay-patin-tre-em-iskate-ichi-mau-hong-380x380.jpg", "https://xpatin.com/wp-content/uploads/2019/12/giay-iskate-ichi-xanh-380x380.jpg"], info:["Màu sắc: Đen, Hồng, Xanh dương","Kích cỡ: S (31-34), M (35-38)","Khả năng điều chỉnh: Điều chỉnh được 4 cỡ. Có thể nới rộng giày Trượt khi chân trẻ to ra!","Khả năng trượt: Bánh xe 64mm-68mm, Bánh xe 68mm-70mm"]},
    {id: 37, name: "Giày Patin CHAMTPION KF-1 (2 màu)", price: "2,200,000₫", priceSale: "1,012,000₫",  colors: ["pink", "blue"] , sizes: ["M (34-37)", "S (30-33)"], images: ["https://xpatin.com/wp-content/uploads/2021/04/giay-patin-kf-1-xanh-anh-4-380x380.jpg", "https://xpatin.com/wp-content/uploads/2021/04/giay-patin-kf-1-hong-anh-2-380x380.jpg", "https://xpatin.com/wp-content/uploads/2021/04/giay-patin-kf-1-hong-anh-3-380x380.jpg", "https://xpatin.com/wp-content/uploads/2021/04/giay-patin-kf-1-hong-380x380.jpg", "https://xpatin.com/wp-content/uploads/2021/04/giay-patin-kf-1-xanh-380x380.jpg"], info:["Màu sắc: Hồng, Xanh dương","Kích cỡ: M (34-37), S (30-33)","Khả năng điều chỉnh: Thay đổi được 3 kích cỡ khác nhau, rộng hơn khi chân trẻ to ra!","Khả năng trượt: Vòng bi ABEC7"]},
    {id: 38, name: "Giày Patin iSkate ARROW (mẫu mới)", price: "", priceSale: "990,000₫",  colors: ["red", "black", "pink"] , sizes: ["M (35-38), L (39-42)"], images: ["https://xpatin.com/wp-content/uploads/2020/10/giay-patin-iskate-arrow-do-380x380.jpg", "https://xpatin.com/wp-content/uploads/2020/10/giay-patin-iskate-arrow-do-2-380x380.jpg", "https://xpatin.com/wp-content/uploads/2020/10/giay-patin-iskate-arrow-hong-2-380x380.jpg", "https://xpatin.com/wp-content/uploads/2020/10/giay-patin-iskate-arrow-den-380x380.jpg", "https://xpatin.com/wp-content/uploads/2020/10/giay-patin-iskate-arrow-hong-380x380.jpg"], info:["Màu sắc: Đỏ, Đen, Hồng","Kích cỡ: M (35-38), L (39-42)","Khả năng điều chỉnhL: Điều chỉnh được 4 cỡ. Có thể nới rộng giày Trượt khi chân trẻ to ra!"]},
    {id: 39, name: "Giày Patin Papaison", price: "1,150,000₫", priceSale: "950,000₫",  colors: ["red", "black"] , sizes: ["S (31-34)", "M (35-38)", "L (39-42)"], images: ["https://xpatin.com/wp-content/uploads/2019/12/giay-truot-patin-papaison-chat-luong-tot-380x380.jpg", "https://xpatin.com/wp-content/uploads/2019/12/giay-truot-patin-papaison-chac-chan-380x380.jpg", "https://xpatin.com/wp-content/uploads/2019/12/giay-patin-papaison-do-anh-2-380x380.jpg", "https://xpatin.com/wp-content/uploads/2019/12/giay-truot-patin-papaison-mau-den-380x380.jpg", "https://xpatin.com/wp-content/uploads/2019/12/giay-truot-patin-papaison-tre-em-gia-re-380x380.jpg"], info:["Màu sắc: Đỏ, Đen","Kích cỡ: S (31-34), M (35-38), L (39-42)","Khả năng điều chỉnh: Điều chỉnh được 4 cỡ. Có thể nới rộng giày Trượt khi chân trẻ to ra!","Khả năng trượt: Vòng bi ABEC7"]},
    {id: 40, name: "Giày Patin SOFT A1", price: "1,065,000₫", priceSale: "850,000₫",  colors: ["black","pink", "blue"] , sizes: ["S (31-34)", "M (35-38)", "L (39-42)"], images: ["https://xpatin.com/wp-content/uploads/2019/09/Giày-Patin-SOFT-A1-Hồng-380x380.jpg", "https://xpatin.com/wp-content/uploads/2019/09/Giày-Patin-SOFT-A1-Đen-380x380.jpg", "https://xpatin.com/wp-content/uploads/2019/12/drift-junior-pink-380x380.jpg", "https://xpatin.com/wp-content/uploads/2020/09/giay-patin-iskate-fb22-xanh-380x380.png", "https://xpatin.com/wp-content/uploads/2019/12/giay-patin-flying-eagle-k7-den-380x380.jpg"], info:["Thương hiệu: SOFT","Màu sắc: Đen, Hồng, Xanh dương","Kích cỡ: S (31-34), M (35-38), L (39-42)","Khả năng điều chỉnh: Điều chỉnh được 4 cỡ. Có thể nới rộng giày Trượt khi chân trẻ to ra!","Khả năng trượt: Bánh xe 64mm-68mm, Bánh xe 68mm-70mm, Bánh xe 70mm-72mm, Vòng bi ABEC7"]},
    {id: 41, name: "Giày Patin Flying Eagle S5S+", price: "", priceSale: "1,650,000₫", colors: ["black", "pink", "blue"] , sizes: ["S (28-32)", "M (33-37)", "L (38-42)"], images: ["https://xpatin.com/wp-content/uploads/2019/11/giay-patin-flying-eagle-s5s-xpatin4-380x380.jpg", "https://xpatin.com/wp-content/uploads/2019/11/giay-patin-flying-eagle-s5s-xpatin5-380x380.jpg", "https://xpatin.com/wp-content/uploads/2019/11/giay-patin-flying-eagle-s5s-xpatin6-380x380.jpg", "https://xpatin.com/wp-content/uploads/2019/11/giay-patin-flying-eagle-s5s-mau-xanh-380x380.jpg", "https://xpatin.com/wp-content/uploads/2019/11/giay-patin-flying-eagle-s5s-mau-hong-380x380.jpg"], info:["Thương hiệu: FLYING EAGLE", "Màu sắc: Đen, Hồng, Xanh dương"]},
    {id: 42, name: "Giày Patin Micro D3LTA", price: "", priceSale: "22,750,000₫",  colors: ["black"] , sizes: ["40", "41", "42", "43", "44"], images: ["https://xpatin.com/wp-content/uploads/2019/10/Giày-Patin-Micro-DELTA-F-anh6-2-380x380.jpg", "https://xpatin.com/wp-content/uploads/2020/05/giay-micro-mj-mau-xanh-dam.jpg", "https://xpatin.com/wp-content/uploads/2022/01/giay-patin-micro-delta-liberty-380x380.jpg", "https://xpatin.com/wp-content/uploads/2019/09/giay-patin-micro-mt-plus-mau-vang-380x380.jpg", "https://xpatin.com/wp-content/uploads/2019/09/Giày-Patin-Micro-Discovery-Đen-380x380.jpg"], info:["Thương hiệu: MICRO – Thụy Sĩ","Màu sắc: Đen","Kích cỡ: 40, 41, 42, 43, 44","Khả năng điều chỉnh: Size đơn (1 kích cỡ) không điều chỉnh","Khả năng trượt: Bánh xe 72mm, Bánh xe 76mm, Bánh xe 80mm, Vòng bi Slalom PRO9"]},
    {id: 43, name: "Giày Patin Micro Delta Force II", price: "", priceSale: "19,990,000₫",  colors: ["black", "white"] , sizes: ["40", "41", "42", "43", "44"], images: ["https://xpatin.com/wp-content/uploads/2023/05/43afffd7e4-min-380x380.jpg", "https://xpatin.com/wp-content/uploads/2023/05/658bb9935b-min-380x380.jpg", "https://xpatin.com/wp-content/uploads/2023/05/825694f3fd-min-380x380.jpg", "https://xpatin.com/wp-content/uploads/2023/05/giay-patin-micro-delta-force-ii-black-380x380.jpg", "https://xpatin.com/wp-content/uploads/2023/05/b68eaf1962-min-380x380.jpg"], info:["Thương hiệu: MICRO – Thụy Sĩ","Màu sắc: Đen, Trắng","Kích cỡ: 40, 41, 42, 43, 44","Khả năng điều chỉnh: Size đơn (1 kích cỡ) không điều chỉnh","Khả năng trượt: Bánh xe 72mm, Bánh xe 76mm, Bánh xe 80mm, Vòng bi Slalom PRO9"]},


    {id: 11, name: "Giày Patin Micro DUALITY", price: "", priceSale: "3,520,000₫",  colors: ["Đỏ", "Xanh dương", "Xanh lá"] , sizes: ["S (29-32)", "M (33-36)", "L (37-40)"], images: ["https://xpatin.com/wp-content/uploads/2020/05/giay-micro-duality-mau-luc-380x380.jpg", "https://xpatin.com/wp-content/uploads/2020/05/giay-micro-duality-mau-xanh.jpg", "https://xpatin.com/wp-content/uploads/2019/10/Micro-DELTA-Pro-1-380x380.jpg", "https://xpatin.com/wp-content/uploads/2023/03/giay-patin-micro-delta-plus-co-carbon-380x380.jpg", "https://xpatin.com/wp-content/uploads/2022/07/giay-patin-micro-infinite-se-hai-mau-380x380.jpg"], info:["Thương hiệu:MICRO – Thụy Sĩ","Màu sắc: Đỏ, Xanh dương, Xanh lá","Kích cỡ: S (29-32), M (33-36), L (37-40)","Khóa cổ giày: khóa đóng nhựa dẻo, Khóa thân giày: khóa dán","Phanh (thắng): Chất liệu nhựa, Có ở chân giày phải","Khả năng trượt: Vòng bi ABEC5"]},
    {id: 11, name: "Giày Patin Micro DUALITY", price: "", priceSale: "3,520,000₫",  colors: ["Đỏ", "Xanh dương", "Xanh lá"] , sizes: ["S (29-32)", "M (33-36)", "L (37-40)"], images: ["https://xpatin.com/wp-content/uploads/2020/05/giay-micro-duality-mau-luc-380x380.jpg", "https://xpatin.com/wp-content/uploads/2020/05/giay-micro-duality-mau-xanh.jpg", "https://xpatin.com/wp-content/uploads/2019/10/Micro-DELTA-Pro-1-380x380.jpg", "https://xpatin.com/wp-content/uploads/2023/03/giay-patin-micro-delta-plus-co-carbon-380x380.jpg", "https://xpatin.com/wp-content/uploads/2022/07/giay-patin-micro-infinite-se-hai-mau-380x380.jpg"], info:["Thương hiệu:MICRO – Thụy Sĩ","Màu sắc: Đỏ, Xanh dương, Xanh lá","Kích cỡ: S (29-32), M (33-36), L (37-40)","Khóa cổ giày: khóa đóng nhựa dẻo, Khóa thân giày: khóa dán","Phanh (thắng): Chất liệu nhựa, Có ở chân giày phải","Khả năng trượt: Vòng bi ABEC5"]},
    {id: 11, name: "Giày Patin Micro DUALITY", price: "", priceSale: "3,520,000₫",  colors: ["Đỏ", "Xanh dương", "Xanh lá"] , sizes: ["S (29-32)", "M (33-36)", "L (37-40)"], images: ["https://xpatin.com/wp-content/uploads/2020/05/giay-micro-duality-mau-luc-380x380.jpg", "https://xpatin.com/wp-content/uploads/2020/05/giay-micro-duality-mau-xanh.jpg", "https://xpatin.com/wp-content/uploads/2019/10/Micro-DELTA-Pro-1-380x380.jpg", "https://xpatin.com/wp-content/uploads/2023/03/giay-patin-micro-delta-plus-co-carbon-380x380.jpg", "https://xpatin.com/wp-content/uploads/2022/07/giay-patin-micro-infinite-se-hai-mau-380x380.jpg"], info:["Thương hiệu:MICRO – Thụy Sĩ","Màu sắc: Đỏ, Xanh dương, Xanh lá","Kích cỡ: S (29-32), M (33-36), L (37-40)","Khóa cổ giày: khóa đóng nhựa dẻo, Khóa thân giày: khóa dán","Phanh (thắng): Chất liệu nhựa, Có ở chân giày phải","Khả năng trượt: Vòng bi ABEC5"]},
    {id: 11, name: "Giày Patin Micro DUALITY", price: "", priceSale: "3,520,000₫",  colors: ["Đỏ", "Xanh dương", "Xanh lá"] , sizes: ["S (29-32)", "M (33-36)", "L (37-40)"], images: ["https://xpatin.com/wp-content/uploads/2020/05/giay-micro-duality-mau-luc-380x380.jpg", "https://xpatin.com/wp-content/uploads/2020/05/giay-micro-duality-mau-xanh.jpg", "https://xpatin.com/wp-content/uploads/2019/10/Micro-DELTA-Pro-1-380x380.jpg", "https://xpatin.com/wp-content/uploads/2023/03/giay-patin-micro-delta-plus-co-carbon-380x380.jpg", "https://xpatin.com/wp-content/uploads/2022/07/giay-patin-micro-infinite-se-hai-mau-380x380.jpg"], info:["Thương hiệu:MICRO – Thụy Sĩ","Màu sắc: Đỏ, Xanh dương, Xanh lá","Kích cỡ: S (29-32), M (33-36), L (37-40)","Khóa cổ giày: khóa đóng nhựa dẻo, Khóa thân giày: khóa dán","Phanh (thắng): Chất liệu nhựa, Có ở chân giày phải","Khả năng trượt: Vòng bi ABEC5"]},
    {id: 11, name: "Giày Patin Micro DUALITY", price: "", priceSale: "3,520,000₫",  colors: ["Đỏ", "Xanh dương", "Xanh lá"] , sizes: ["S (29-32)", "M (33-36)", "L (37-40)"], images: ["https://xpatin.com/wp-content/uploads/2020/05/giay-micro-duality-mau-luc-380x380.jpg", "https://xpatin.com/wp-content/uploads/2020/05/giay-micro-duality-mau-xanh.jpg", "https://xpatin.com/wp-content/uploads/2019/10/Micro-DELTA-Pro-1-380x380.jpg", "https://xpatin.com/wp-content/uploads/2023/03/giay-patin-micro-delta-plus-co-carbon-380x380.jpg", "https://xpatin.com/wp-content/uploads/2022/07/giay-patin-micro-infinite-se-hai-mau-380x380.jpg"], info:["Thương hiệu:MICRO – Thụy Sĩ","Màu sắc: Đỏ, Xanh dương, Xanh lá","Kích cỡ: S (29-32), M (33-36), L (37-40)","Khóa cổ giày: khóa đóng nhựa dẻo, Khóa thân giày: khóa dán","Phanh (thắng): Chất liệu nhựa, Có ở chân giày phải","Khả năng trượt: Vòng bi ABEC5"]},
    {id: 11, name: "Giày Patin Micro DUALITY", price: "", priceSale: "3,520,000₫",  colors: ["Đỏ", "Xanh dương", "Xanh lá"] , sizes: ["S (29-32)", "M (33-36)", "L (37-40)"], images: ["https://xpatin.com/wp-content/uploads/2020/05/giay-micro-duality-mau-luc-380x380.jpg", "https://xpatin.com/wp-content/uploads/2020/05/giay-micro-duality-mau-xanh.jpg", "https://xpatin.com/wp-content/uploads/2019/10/Micro-DELTA-Pro-1-380x380.jpg", "https://xpatin.com/wp-content/uploads/2023/03/giay-patin-micro-delta-plus-co-carbon-380x380.jpg", "https://xpatin.com/wp-content/uploads/2022/07/giay-patin-micro-infinite-se-hai-mau-380x380.jpg"], info:["Thương hiệu:MICRO – Thụy Sĩ","Màu sắc: Đỏ, Xanh dương, Xanh lá","Kích cỡ: S (29-32), M (33-36), L (37-40)","Khóa cổ giày: khóa đóng nhựa dẻo, Khóa thân giày: khóa dán","Phanh (thắng): Chất liệu nhựa, Có ở chân giày phải","Khả năng trượt: Vòng bi ABEC5"]},
    {id: 11, name: "Giày Patin Micro DUALITY", price: "", priceSale: "3,520,000₫",  colors: ["Đỏ", "Xanh dương", "Xanh lá"] , sizes: ["S (29-32)", "M (33-36)", "L (37-40)"], images: ["https://xpatin.com/wp-content/uploads/2020/05/giay-micro-duality-mau-luc-380x380.jpg", "https://xpatin.com/wp-content/uploads/2020/05/giay-micro-duality-mau-xanh.jpg", "https://xpatin.com/wp-content/uploads/2019/10/Micro-DELTA-Pro-1-380x380.jpg", "https://xpatin.com/wp-content/uploads/2023/03/giay-patin-micro-delta-plus-co-carbon-380x380.jpg", "https://xpatin.com/wp-content/uploads/2022/07/giay-patin-micro-infinite-se-hai-mau-380x380.jpg"], info:["Thương hiệu:MICRO – Thụy Sĩ","Màu sắc: Đỏ, Xanh dương, Xanh lá","Kích cỡ: S (29-32), M (33-36), L (37-40)","Khóa cổ giày: khóa đóng nhựa dẻo, Khóa thân giày: khóa dán","Phanh (thắng): Chất liệu nhựa, Có ở chân giày phải","Khả năng trượt: Vòng bi ABEC5"]},
    {id: 11, name: "Giày Patin Micro DUALITY", price: "", priceSale: "3,520,000₫",  colors: ["Đỏ", "Xanh dương", "Xanh lá"] , sizes: ["S (29-32)", "M (33-36)", "L (37-40)"], images: ["https://xpatin.com/wp-content/uploads/2020/05/giay-micro-duality-mau-luc-380x380.jpg", "https://xpatin.com/wp-content/uploads/2020/05/giay-micro-duality-mau-xanh.jpg", "https://xpatin.com/wp-content/uploads/2019/10/Micro-DELTA-Pro-1-380x380.jpg", "https://xpatin.com/wp-content/uploads/2023/03/giay-patin-micro-delta-plus-co-carbon-380x380.jpg", "https://xpatin.com/wp-content/uploads/2022/07/giay-patin-micro-infinite-se-hai-mau-380x380.jpg"], info:["Thương hiệu:MICRO – Thụy Sĩ","Màu sắc: Đỏ, Xanh dương, Xanh lá","Kích cỡ: S (29-32), M (33-36), L (37-40)","Khóa cổ giày: khóa đóng nhựa dẻo, Khóa thân giày: khóa dán","Phanh (thắng): Chất liệu nhựa, Có ở chân giày phải","Khả năng trượt: Vòng bi ABEC5"]},
    {id: 11, name: "Giày Patin Micro DUALITY", price: "", priceSale: "3,520,000₫",  colors: ["Đỏ", "Xanh dương", "Xanh lá"] , sizes: ["S (29-32)", "M (33-36)", "L (37-40)"], images: ["https://xpatin.com/wp-content/uploads/2020/05/giay-micro-duality-mau-luc-380x380.jpg", "https://xpatin.com/wp-content/uploads/2020/05/giay-micro-duality-mau-xanh.jpg", "https://xpatin.com/wp-content/uploads/2019/10/Micro-DELTA-Pro-1-380x380.jpg", "https://xpatin.com/wp-content/uploads/2023/03/giay-patin-micro-delta-plus-co-carbon-380x380.jpg", "https://xpatin.com/wp-content/uploads/2022/07/giay-patin-micro-infinite-se-hai-mau-380x380.jpg"], info:["Thương hiệu:MICRO – Thụy Sĩ","Màu sắc: Đỏ, Xanh dương, Xanh lá","Kích cỡ: S (29-32), M (33-36), L (37-40)","Khóa cổ giày: khóa đóng nhựa dẻo, Khóa thân giày: khóa dán","Phanh (thắng): Chất liệu nhựa, Có ở chân giày phải","Khả năng trượt: Vòng bi ABEC5"]},
    {id: 11, name: "Giày Patin Micro DUALITY", price: "", priceSale: "3,520,000₫",  colors: ["Đỏ", "Xanh dương", "Xanh lá"] , sizes: ["S (29-32)", "M (33-36)", "L (37-40)"], images: ["https://xpatin.com/wp-content/uploads/2020/05/giay-micro-duality-mau-luc-380x380.jpg", "https://xpatin.com/wp-content/uploads/2020/05/giay-micro-duality-mau-xanh.jpg", "https://xpatin.com/wp-content/uploads/2019/10/Micro-DELTA-Pro-1-380x380.jpg", "https://xpatin.com/wp-content/uploads/2023/03/giay-patin-micro-delta-plus-co-carbon-380x380.jpg", "https://xpatin.com/wp-content/uploads/2022/07/giay-patin-micro-infinite-se-hai-mau-380x380.jpg"], info:["Thương hiệu:MICRO – Thụy Sĩ","Màu sắc: Đỏ, Xanh dương, Xanh lá","Kích cỡ: S (29-32), M (33-36), L (37-40)","Khóa cổ giày: khóa đóng nhựa dẻo, Khóa thân giày: khóa dán","Phanh (thắng): Chất liệu nhựa, Có ở chân giày phải","Khả năng trượt: Vòng bi ABEC5"]},
    {id: 11, name: "Giày Patin Micro DUALITY", price: "", priceSale: "3,520,000₫",  colors: ["Đỏ", "Xanh dương", "Xanh lá"] , sizes: ["S (29-32)", "M (33-36)", "L (37-40)"], images: ["https://xpatin.com/wp-content/uploads/2020/05/giay-micro-duality-mau-luc-380x380.jpg", "https://xpatin.com/wp-content/uploads/2020/05/giay-micro-duality-mau-xanh.jpg", "https://xpatin.com/wp-content/uploads/2019/10/Micro-DELTA-Pro-1-380x380.jpg", "https://xpatin.com/wp-content/uploads/2023/03/giay-patin-micro-delta-plus-co-carbon-380x380.jpg", "https://xpatin.com/wp-content/uploads/2022/07/giay-patin-micro-infinite-se-hai-mau-380x380.jpg"], info:["Thương hiệu:MICRO – Thụy Sĩ","Màu sắc: Đỏ, Xanh dương, Xanh lá","Kích cỡ: S (29-32), M (33-36), L (37-40)","Khóa cổ giày: khóa đóng nhựa dẻo, Khóa thân giày: khóa dán","Phanh (thắng): Chất liệu nhựa, Có ở chân giày phải","Khả năng trượt: Vòng bi ABEC5"]},
    {id: 11, name: "Giày Patin Micro DUALITY", price: "", priceSale: "3,520,000₫",  colors: ["Đỏ", "Xanh dương", "Xanh lá"] , sizes: ["S (29-32)", "M (33-36)", "L (37-40)"], images: ["https://xpatin.com/wp-content/uploads/2020/05/giay-micro-duality-mau-luc-380x380.jpg", "https://xpatin.com/wp-content/uploads/2020/05/giay-micro-duality-mau-xanh.jpg", "https://xpatin.com/wp-content/uploads/2019/10/Micro-DELTA-Pro-1-380x380.jpg", "https://xpatin.com/wp-content/uploads/2023/03/giay-patin-micro-delta-plus-co-carbon-380x380.jpg", "https://xpatin.com/wp-content/uploads/2022/07/giay-patin-micro-infinite-se-hai-mau-380x380.jpg"], info:["Thương hiệu:MICRO – Thụy Sĩ","Màu sắc: Đỏ, Xanh dương, Xanh lá","Kích cỡ: S (29-32), M (33-36), L (37-40)","Khóa cổ giày: khóa đóng nhựa dẻo, Khóa thân giày: khóa dán","Phanh (thắng): Chất liệu nhựa, Có ở chân giày phải","Khả năng trượt: Vòng bi ABEC5"]},
    {id: 11, name: "Giày Patin Micro DUALITY", price: "", priceSale: "3,520,000₫",  colors: ["Đỏ", "Xanh dương", "Xanh lá"] , sizes: ["S (29-32)", "M (33-36)", "L (37-40)"], images: ["https://xpatin.com/wp-content/uploads/2020/05/giay-micro-duality-mau-luc-380x380.jpg", "https://xpatin.com/wp-content/uploads/2020/05/giay-micro-duality-mau-xanh.jpg", "https://xpatin.com/wp-content/uploads/2019/10/Micro-DELTA-Pro-1-380x380.jpg", "https://xpatin.com/wp-content/uploads/2023/03/giay-patin-micro-delta-plus-co-carbon-380x380.jpg", "https://xpatin.com/wp-content/uploads/2022/07/giay-patin-micro-infinite-se-hai-mau-380x380.jpg"], info:["Thương hiệu:MICRO – Thụy Sĩ","Màu sắc: Đỏ, Xanh dương, Xanh lá","Kích cỡ: S (29-32), M (33-36), L (37-40)","Khóa cổ giày: khóa đóng nhựa dẻo, Khóa thân giày: khóa dán","Phanh (thắng): Chất liệu nhựa, Có ở chân giày phải","Khả năng trượt: Vòng bi ABEC5"]},
    {id: 11, name: "Giày Patin Micro DUALITY", price: "", priceSale: "3,520,000₫",  colors: ["Đỏ", "Xanh dương", "Xanh lá"] , sizes: ["S (29-32)", "M (33-36)", "L (37-40)"], images: ["https://xpatin.com/wp-content/uploads/2020/05/giay-micro-duality-mau-luc-380x380.jpg", "https://xpatin.com/wp-content/uploads/2020/05/giay-micro-duality-mau-xanh.jpg", "https://xpatin.com/wp-content/uploads/2019/10/Micro-DELTA-Pro-1-380x380.jpg", "https://xpatin.com/wp-content/uploads/2023/03/giay-patin-micro-delta-plus-co-carbon-380x380.jpg", "https://xpatin.com/wp-content/uploads/2022/07/giay-patin-micro-infinite-se-hai-mau-380x380.jpg"], info:["Thương hiệu:MICRO – Thụy Sĩ","Màu sắc: Đỏ, Xanh dương, Xanh lá","Kích cỡ: S (29-32), M (33-36), L (37-40)","Khóa cổ giày: khóa đóng nhựa dẻo, Khóa thân giày: khóa dán","Phanh (thắng): Chất liệu nhựa, Có ở chân giày phải","Khả năng trượt: Vòng bi ABEC5"]},
    {id: 11, name: "Giày Patin Micro DUALITY", price: "", priceSale: "3,520,000₫",  colors: ["Đỏ", "Xanh dương", "Xanh lá"] , sizes: ["S (29-32)", "M (33-36)", "L (37-40)"], images: ["https://xpatin.com/wp-content/uploads/2020/05/giay-micro-duality-mau-luc-380x380.jpg", "https://xpatin.com/wp-content/uploads/2020/05/giay-micro-duality-mau-xanh.jpg", "https://xpatin.com/wp-content/uploads/2019/10/Micro-DELTA-Pro-1-380x380.jpg", "https://xpatin.com/wp-content/uploads/2023/03/giay-patin-micro-delta-plus-co-carbon-380x380.jpg", "https://xpatin.com/wp-content/uploads/2022/07/giay-patin-micro-infinite-se-hai-mau-380x380.jpg"], info:["Thương hiệu:MICRO – Thụy Sĩ","Màu sắc: Đỏ, Xanh dương, Xanh lá","Kích cỡ: S (29-32), M (33-36), L (37-40)","Khóa cổ giày: khóa đóng nhựa dẻo, Khóa thân giày: khóa dán","Phanh (thắng): Chất liệu nhựa, Có ở chân giày phải","Khả năng trượt: Vòng bi ABEC5"]},
    {id: 11, name: "Giày Patin Micro DUALITY", price: "", priceSale: "3,520,000₫",  colors: ["Đỏ", "Xanh dương", "Xanh lá"] , sizes: ["S (29-32)", "M (33-36)", "L (37-40)"], images: ["https://xpatin.com/wp-content/uploads/2020/05/giay-micro-duality-mau-luc-380x380.jpg", "https://xpatin.com/wp-content/uploads/2020/05/giay-micro-duality-mau-xanh.jpg", "https://xpatin.com/wp-content/uploads/2019/10/Micro-DELTA-Pro-1-380x380.jpg", "https://xpatin.com/wp-content/uploads/2023/03/giay-patin-micro-delta-plus-co-carbon-380x380.jpg", "https://xpatin.com/wp-content/uploads/2022/07/giay-patin-micro-infinite-se-hai-mau-380x380.jpg"], info:["Thương hiệu:MICRO – Thụy Sĩ","Màu sắc: Đỏ, Xanh dương, Xanh lá","Kích cỡ: S (29-32), M (33-36), L (37-40)","Khóa cổ giày: khóa đóng nhựa dẻo, Khóa thân giày: khóa dán","Phanh (thắng): Chất liệu nhựa, Có ở chân giày phải","Khả năng trượt: Vòng bi ABEC5"]},
]

// hiển thị sản phẩm sale
function renderProductSale() {
    var html = "";
    for(var i = 10; i < 15; i++) {
        html += `<div class="product-item">
                    <a href="./ct_sanPham.html">
                        <img src= ${products[i].images[0]} >
                        <h4 class="name"> ${products[i].name} </h4>
                        <span class="price-section"> ${products[i].priceSale}
                            <h5 class="price"> ${products[i].price} </h5>
                        </span> 
                        <ul>
                            <li><i class="fa-solid fa-heart"></i></li>
                            <li><i class="fa-solid fa-cart-shopping"></i></li>
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


// xử lý chuyển trang
var productPerPage = 15;
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