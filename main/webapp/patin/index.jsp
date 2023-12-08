<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html; charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/patin/assets/css/base.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/patin/assets/css/home.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/patin/assets/fontawesome/css/all.min.css">
    <title>Trang Chủ</title>
</head>
<body>
    <header>
        <div class="container">
<%--            <img src="${pageContext.request.contextPath}/patin/assets/images/logo.PNG" alt="" class="logo">--%>
            <img src="/patin_shop/patin/assets/images${li.get(0).getUrl()}" alt="" class="logo">
            <nav>
                <ul class="menu">
                    <li><a href="#">TRANG CHỦ</a></li>
                    <li>
                        <a href="./sanPham.html">SẢN PHẨM</a>
                        <ul class="sub_menu list-category">
                            <c:forEach var="i" items="${category}">
                                <li><a href="./danhMuc.html">${i.getName()}</a></li>
                            </c:forEach>
                        </ul>
                    </li>
                    <li><a href=./lienHe.html>LIÊN HỆ</a></li>
                </ul>
            </nav>
            <div class="user">
                <ul>
                    <li>
                        <a href="login.html">
                            ĐĂNG NHẬP
                        </a>
                    </li>
                    <li>
                        <a href="register.html">
                            ĐĂNG KÝ
                        </a>
                    </li>
                    <li><a href="./yeuThich.html"><i class="fa-solid fa-heart"></i></a></li>
                    <li><a href="./gioHang.html"><i class="fa-solid fa-cart-shopping"></i></a></li>
                </ul>
            </div>
        </div>
    </header>

    <div id="category-search">
        <div class="container">

            <div class="category-title" id="categoryAll">
                <div class="category">
                    <span>Danh Mục</span>
                </div>
                <ul id="list-cate" class="list list-category hideCategory">
                    <c:forEach var="i" items="${category}">
                        <li><a href="./danhMuc.html">${i.getName()}</a></li>
                    </c:forEach>
                </ul>
            </div>
            <div class="search">
                <input type="text" placeholder="Nhập vào sản phẩm" id="search" name="search">
                <button id="searchBtn">Tìm Kiếm</button>
                <ul>

                </ul>
            </div>
        </div>
    </div>

    <div id="image">
        <div class="container-img">
            <img src="${pageContext.request.contextPath}/patin/assets/images/patin.jpg" alt="">
            <a href="sanPham-servlet" class="shop">Xem sản phẩm</a>
        </div>
    </div>

    <div id="content">
        <div class="container">
            <div class="top">
                <h3>Sản phẩm bán chạy</h3>
                <div class="wrapper">
                    <div class="carousel" id="carousel">
                        <c:forEach items="${hotProduct}" var="product">
                            <div class="product-item">
                                <a href="./ct_sanPham.html">
                                    <img src= ${product.getImage().getUrl()} >
                                    <h4 class="name"> ${product.getName()} </h4>
                                    <span class="price-section"> ${product.getSalePrice()}
                                        <h5 class="price"> ${product.getOriginPrice()} </h5>
                                    </span>
                                    <ul>
                                        <li><i class="fa-solid fa-heart like"></i></li>
                                        <li><i class="fa-solid fa-cart-shopping cart"></i></li>
                                    </ul>
                                </a>
                            </div>
                        </c:forEach>

                    </div>
                    <i class="fa-regular fa-circle-right selection" id="next"></i>
                    <i class="fa-regular fa-circle-left selection" id="previous"></i>
                </div>
                <a href="./sanPham.html" class="more">
                    Xem Thêm
                    <i class="fa-solid fa-arrow-right"></i>
                </a>
            </div>

            <h3>Sản phẩm khác</h3>
            <div class="product-list" id="product-list">
                <c:forEach items="${products}" var="product">
                    <div class="product-item">
                        <a href="./ct_sanPham.html">
                        <img src= ${product.getImage().getUrl()} >
                        <h4 class="name"> ${product.getName()} </h4>
                        <span class="price-section"> ${product.getSalePrice()}
                            <h5 class="price"> ${product.getOriginPrice()} </h5>
                        </span>
                        <ul>
                            <li><i class="fa-solid fa-heart like"></i></li>
                            <li><i class="fa-solid fa-cart-shopping cart"></i></li>
                        </ul>
                        </a>
                    </div>
                </c:forEach>
            </div>
            <a href="sanPham-servlet" class="more">
                Xem Thêm
                <i class="fa-solid fa-arrow-right"></i>
            </a>
        </div>
    </div>

    <footer>
        <div class="container">
            <div class="info">
                <img src="${pageContext.request.contextPath}/patin/assets/images/logo.PNG" alt="">
                <p>
                    Địa chỉ: Trường Đại học Nông Lâm Thành Phố Hồ Chí Minh
                </p>
                <p>
                    Số điện thoại:
                    <a href="tel:+">+65 11.188.888</a>
                </p>

                <p>
                    Email:
                    <a href="mailto:">patin@gmail.com</a>
                </p>
            </div>
            <div class="subscribe">
                <p>Đăng ký để nhận tin tức về sản phẩm mới nhất</p>
                <div class="holder">
                    <input type="email" id="email" placeholder="Nhập vào email của bạn ">
                    <input type="submit" id="btn" value="Đăng Ký">
                </div>
                <div class="social-media">
                    <ul>
                        <li><a href="#"><i class="fa-brands fa-facebook-f"></i></a></li>
                        <li><a href="#"><i class="fa-brands fa-instagram"></i></a></li>
                        <li><a href="#"><i class="fa-brands fa-twitter"></i></a></li>
                        <li><a href="#"><i class="fa-brands fa-pinterest"></i></a></li>
                    </ul>
                </div>
            </div>
        </div>
    </footer>

    <script src="${pageContext.request.contextPath}/patin/assets/js/showDanhMuc.js"></script>
    <script src="${pageContext.request.contextPath}/patin/assets/js/timKiem.js"></script>
    <script src="${pageContext.request.contextPath}/patin/assets/js/home.js"></script>
</body>
</html>