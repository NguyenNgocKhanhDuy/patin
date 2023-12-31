<%@ page import="java.text.NumberFormat" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html; charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/base.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/account.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/fontawesome/css/all.min.css">
    <title>Giỏ hàng</title>
    <fmt:setLocale value="vi_VN"/>
</head>
<body>
    <header>
        <div class="container">
            <img src="${pageContext.request.contextPath}/assets/images/logo.PNG" alt="" class="logo">
            <nav>
                <ul class="menu">
                    <li><a href="home">TRANG CHỦ</a></li>
                    <li>
                        <a href="listProduct">SẢN PHẨM</a>
                        <ul class="sub_menu list-category">

                        </ul>
                    </li>
                    <li><a href=lienHe.jsp>LIÊN HỆ</a></li>
                </ul>
            </nav>
            <div class="user">
                <ul>
                    <c:if test="${sessionScope.auth != null}">
                        <li>
                            <a href="">
                                    ${sessionScope.auth.getFullName()}
                            </a>
                        </li>
                    </c:if>
                    <c:if test="${sessionScope.auth == null}">
                        <li>
                            <a href="login.jsp">
                                ĐĂNG NHẬP
                            </a>
                        </li>
                        <li>
                            <a href="register.jsp">
                                ĐĂNG KÝ
                            </a>
                        </li>
                    </c:if>

                    <li><a href="wishlist.jsp"><i class="fa-solid fa-heart"></i></a></li>
                    <li class="cartLink">
                        <a href="showCart"><i class="fa-solid fa-cart-shopping"></i></a>
                        <c:if test="${sessionScope.cart != null && sessionScope.cart.getData().size() > 0}">
                            <span class="amount">${sessionScope.cart.getData().size()}</span>
                        </c:if>
                    </li>
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
                        <li><a href="product_category.html">${i.getName()}</a></li>
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
            <img src="${pageContext.request.contextPath}/assets/images/patin.jpg" alt="">
        </div>
    </div>

    <div id="content">
        <div class="container">
            <div class="left">
                <div class="account">
                    <ul class="menu">
                        <li class="activeAccountNav">
                            <i class="fa-regular fa-user"></i>
                            <span>Tài khoản của tôi</span>
<%--                            <ul class="sub_menu showSubMenu">--%>
<%--                                <li id="information" class="activeAccountNav">Thông tin</li>--%>
<%--                                <li id="address">Địa chỉ</li>--%>
<%--                            </ul>--%>
                        </li>
                        <li>
                            <i class="fa-regular fa-clipboard"></i>
                            <span>Đơn hàng</span>
                        </li>
                        <li>
                            <i class="fa-regular fa-bell"></i>
                            <span>Đổi mật khẩu</span>
                        </li>
                    </ul>
                </div>
            </div>

            <div class="right">
                <div class="infomation">
                    <h3>Thông tin</h3>
                    <div class="wrapper">
                        <form action="userInformation" class="info">
                            <div class="part name">
                                <label>Tên:</label>
                                <input type="text" name="fullname" value="${sessionScope.auth.getFullName()}">
                            </div>
                            <div class="part email">
                                <label>Email: </label>
                                <input type="email" value="${sessionScope.auth.getEmail()}">
                            </div>
                            <div class="part phone">
                                <label>Số điện thoại: </label>
                                <input type="tel" name="phone" value="${sessionScope.auth.getPhone()}">
                            </div>
                            <div class="part">
                                <label>Địa chỉ: </label>
                                <input type="tel" name="text" value="${sessionScope.auth.getAddress()}">
                            </div>
                            <div class="part gender">
                                <label>Giới tính:</label>
                                <div class="selectGender">
                                    <input type="radio" name="gender" checked = "true">
                                    <label>Nam</label>
                                    <input type="radio" name="gender">
                                    <label>Nữ</label>
                                </div>
                            </div>
                            <div class="part dob">
                                <label>Ngày sinh:</label>
                                <div class="dob-input">
                                    <select class="day" name="day">
                                        <option>31</option>
                                    </select>
                                    <select class="month" name="month">
                                        <option>12</option>
                                    </select>
                                    <select class="year" name="year">
                                        <option>1900</option>
                                    </select>
                                </div>
                            </div>
                            <input type="submit" class="save" value="Lưu Thông Tin">
                        </form>
                        <div class="avatar">
                            <img src="assets/images/logo.PNG" alt="">
                            <div class="selectImg">
                                <input type="file" accept="image/*">
                                <input type="submit" value="Lựa chọn ảnh">
                            </div>
                        </div>
                    </div>
                </div>

<%--                <div class="address">--%>
<%--                    <div class="top">--%>
<%--                        <h3>Địa chỉ của tôi</h3>--%>
<%--                        <button class="btn-address">Thêm địa chỉ</button>--%>
<%--                    </div>--%>
<%--                    <div class="bottom">--%>
<%--                        <p>Bạn chưa có địa chỉ</p>--%>
<%--                    </div>--%>
<%--                </div>--%>

                <div class="order">
                    <div class="nav">
                        <ul>
                            <li class="activeOrderNav">Tất cả</li>
                            <li>Vận chuyển</li>
                            <li>Hoàn thành</li>
                        </ul>
                    </div>
                    <div class="search">
                        <input type="text" placeholder="Nhập đơn hàng">
                        <button class="search-btn">Tìm kiếm</button>
                    </div>
                    <div class="all-order orderShow">
                        <p>Bạn chưa có đơn hàng all</p>
                    </div>
                    <div class="ship-order orderShow">
                        <p>Bạn chưa có đơn hàng ship</p>
                    </div>
                    <div class="complete-order orderShow">
                        <p>Bạn chưa có đơn hàng complete</p>
                    </div>
                </div>

                <div class="notice">
                    <h3>Thay đổi mật khẩu</h3>
                    <form action="changePass">
                        <div class="holder">
                            <label>Mật khẩu cũ</label>
                            <input type="password" name="oldPass">
                        </div>
                        <div class="holder">
                            <label>Mật khẩu mới</label>
                            <input type="password" name="newPass">
                        </div>
                        <div class="holder">
                            <label>Nhập lại mật khẩu mới</label>
                            <input type="password" name="confirmPass">
                        </div>
                        <input type="submit" value="Xác nhận">
                    </form>
                </div>
            </div>
        </div>
        <div class="modal">
            <div class="modal-container">
                <i class="fa-solid fa-x closeModal"></i>
                <h3 class="title">Thêm địa chỉ</h3>
                <form>
                    <input type="text" placeholder="Nhập địa chỉ của bạn">
                    <button class="modal-save">Thêm</button>
                </form>
            </div>
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

    <script src="${pageContext.request.contextPath}/assets/js/showDanhMuc.js"></script>
    <script src="${pageContext.request.contextPath}/assets/js/search.js"></script>
    <script src="${pageContext.request.contextPath}/assets/js/category.js"></script>
    <script src="${pageContext.request.contextPath}/assets/js/account.js"></script>
</body>
</html>