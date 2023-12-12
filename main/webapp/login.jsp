<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 12/8/2023
  Time: 1:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@ page isELIgnored="false" %>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/base.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/login.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/fontawesome/css/all.min.css">
    <title>Đăng Nhập</title>
</head>
<body>
    <header>
        <div class="container">
            <img src="${pageContext.request.contextPath}/assets/images/logo.PNG" alt="" class="logo">
            <nav>
                <ul class="menu">
                    <li><a href="./index.html">TRANG CHỦ</a></li>
                    <li>
                        <a href="sanPham.html">SẢN PHẨM</a>
                        <ul class="sub_menu list-category">

                        </ul>
                    </li>
                    <li><a href=lienHe.html>LIÊN HỆ</a></li>
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
                    <li><a href="yeuThich.html"><i class="fa-solid fa-heart"></i></a></li>
                    <li><a href="gioHang.html"><i class="fa-solid fa-cart-shopping"></i></a></li>
                </ul>
            </div>
        </div>
    </header>
    
    <div id="content">
        <div class="container">
            <div class="login">
                <h3>Đăng Nhập</h3>
                <form action="/patin_shop/doLogin" method="post">
                    <div class="holder">
                        <label>Email</label>
                        <input type="email" name="email" placeholder="Email..." value="${email != null ? email : ""}">
                    </div>
                    <div class="holder">
                        <label>Mật khẩu</label>
                        <input type="password" name="password" placeholder="Mật khẩu...">
                    </div>
                    <button type="submit">Đăng Nhập</button>
                    <div class="more">
                        <a href="/register.jsp">Tạo tài khoản</a>
                        <a id="forgetPass">Quên mật khẩu</a>
                    </div>
                </form>
            </div>
        </div>
        <div class="popup ${type != null ? type : "none"}">
            <c:if test="${type.equals(\"success\")}">
                <i class="fa-solid fa-check icon"></i>
            </c:if>
            <c:if test="${type.equals(\"error\")}">
                <i class="fa-solid fa-ban fa-flip-horizontal icon"></i>
            </c:if>
            <c:if test="${type.equals(\"alert\")}">
                <i class="fa-solid fa-triangle-exclamation icon"></i>
            </c:if>
            <p>${information}</p>
            <i class="fa-solid fa-xmark del"></i>
        </div>
    </div>

    <div class="modal">
        <div class="modal-container">
            <i class="fa-solid fa-xmark del"></i>
            <h3>Quên mật khẩu</h3>
            <form action="/patin_shop/forgerPass">
                <label>Nhập email của bạn dể chúng tôi có thể hỗ trợ bạn về mật khẩu</label>
                <input type="email" name="emailPass" placeholder="Email...">
                <input type="submit" value="Gửi">
            </form>
        </div>
    </div>

    
    <footer>
        <div class="container">
            <div class="info">
                <img src="${pageContext.request.contextPath}/assets/images/logo.PNG" alt="">
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
    
    <script src="${pageContext.request.contextPath}/assets/js/category.js"></script>
    <script src="${pageContext.request.contextPath}/assets/js/login1.js"></script>
</body>
</html>