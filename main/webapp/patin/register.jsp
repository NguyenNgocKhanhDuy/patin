<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 12/8/2023
  Time: 3:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@ page isELIgnored="false" %>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/patin/assets/css/base.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/patin/assets/css/register.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/patin/assets/fontawesome/css/all.min.css">
    <title>Đăng ký</title>
</head>
<body>
<header>
    <div class="container">
        <img src="${pageContext.request.contextPath}/patin/assets/images/logo.PNG" alt="" class="logo">
        <nav>
            <ul class="menu">
                <li><a href="./index.html">TRANG CHỦ</a></li>
                <li>
                    <a href="./sanPham.html">SẢN PHẨM</a>
                    <ul class="sub_menu list-category">
                        <!--                                    <li><a href="#">Giày patin dành cho trẻ em</a></li>-->
                        <!--                                    <li><a href="#">Giày patin dành cho người lớn</a></li>-->
                        <!--                                    <li><a href="#">Giày patin hãng Centosy</a></li>-->
                        <!--                                    <li><a href="#">Giày patin hãng Flying Eagle</a></li>-->
                        <!--                                    <li><a href="#">Giày patin hãng Courgar</a></li>-->
                    </ul>
                </li>
                <li><a href=./lienHe.html>LIÊN HỆ</a></li>
            </ul>
        </nav>
        <div class="user">
            <ul>
                <li>
                    <a href="./dangNhap.html">
                        ĐĂNG NHẬP
                    </a>
                </li>
                <li>
                    <a href="#">
                        ĐĂNG KÝ
                    </a>
                </li>
                <li><a href="./yeuThich.html"><i class="fa-solid fa-heart"></i></a></li>
                <li><a href="./gioHang.html"><i class="fa-solid fa-cart-shopping"></i></a></li>
            </ul>
        </div>
    </div>
</header>

<div id="content">
    <div class="container">
        <div class="login">
            <h3>Đăng Ký</h3>
            <form action="/patin_shop/doRegister" class="wrapper" method="post">
                <div class="top">
                    <div class="left">
                        <div class="holder">
                            <label>Họ tên
                                <span class="red">
                                    (*)
                                </span>
                            </label>
                            <input id="name" type="text" name="fullname">
                        </div>
                        <div class="holder">
                            <label>Email
                                <span class="red">
                                    (*)
                                </span>
                            </label>
                            <input type="email" name="email">
                        </div>
                        <div class="holder">
                            <label>Mật khẩu</label>
                            <input type="password">
                        </div>
                    </div>
                    <div class="right">
                        <div class="holder">
                            <label>Số điện thoại
                                <span class="red">
                                    (*)
                                </span>
                            </label>
                            <input type="tel" name="phone">
                        </div>
                        <div class="holder">
                            <label>Địa chỉ</label>
                            <input type="text">
                        </div>
                    </div>
                </div>
                <button type="submit">Đăng Ký</button>
            </form>
        </div>
    </div>
    <div class="popup ${type != null ? type : "none"}">
        <c:if test="${type.equals(\"error\")}">
            <i class="fa-solid fa-ban fa-flip-horizontal icon"></i>
        </c:if>
        <c:if test="${type.equals(\"alert\")}">
            <i class="fa-solid fa-triangle-exclamation icon"></i>
        </c:if>
        <p>${errorInformation}</p>
        <i class="fa-solid fa-xmark del"></i>
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

<%--<script src="${pageContext.request.contextPath}/patin/assets/js/tenDanhMuc.js"></script>--%>
<script src="${pageContext.request.contextPath}/patin/assets/js/register.js"></script>
</body>
</html>