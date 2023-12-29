<%@ page import="java.text.NumberFormat" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/base.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/admin.css">
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
                            <i class="fa-solid fa-bars-progress"></i>
                            <span>Quản lý</span>
                            <ul class="sub_menu showSubMenu">
                                <li id="manageUser">
                                    <c:if test="${users != null}">
                                        <a href="showUserAdmin" class="activeAccountNav">
                                            Quản lý người dùng
                                        </a>
                                    </c:if>
                                    <c:if test="${users == null}">
                                        <a href="showUserAdmin">
                                            Quản lý người dùng
                                        </a>
                                    </c:if>
                                </li>
                                <li id="manageProduct">
                                    <c:if test="${products != null}">
                                        <a href="showProductAdmin" class="activeAccountNav">
                                            Quản lý sản phẩm
                                        </a>
                                    </c:if>
                                    <c:if test="${products == null}">
                                        <a href="showProductAdmin">
                                            Quản lý sản phẩm
                                        </a>
                                    </c:if>
                                </li>
                                <li id="manageBrand">
                                    <c:if test="${categories != null}">
                                        <a href="showCategoryAdmin" class="activeAccountNav">
                                            Quản lý danh mục
                                        </a>
                                    </c:if>
                                    <c:if test="${categories == null}">
                                        <a href="showCategoryAdmin">
                                            Quản lý danh mục
                                        </a>
                                    </c:if>
                                </li>
                                <li id="manageColor">
                                    <c:if test="${colors != null}">
                                        <a href="showColorAdmin" class="activeAccountNav">
                                            Quản lý màu sắc
                                        </a>
                                    </c:if>
                                    <c:if test="${colors == null}">
                                        <a href="showColorAdmin">
                                            Quản lý màu sắc
                                        </a>
                                    </c:if>
                                </li>
                                <li id="manageSize">
                                    <c:if test="${sizes != null}">
                                        <a href="showSizeAdmin" class="activeAccountNav">
                                            Quản lý kích thước
                                        </a>
                                    </c:if>
                                    <c:if test="${sizes == null}">
                                        <a href="showSizeAdmin">
                                            Quản lý kích thước
                                        </a>
                                    </c:if>
                                </li>
                            </ul>
                        </li>
                        <li id="manageReport">
                            <c:if test="${bills != null}">
                                <a href="showBillAdmin" class="activeAccountNav">
                                    <i class="fa-brands fa-wpforms"></i>
                                    <span>Báo cáo</span>
                                </a>
                            </c:if>
                            <c:if test="${bills == null}">
                                <a href="showBillAdmin">
                                    <i class="fa-brands fa-wpforms"></i>
                                    <span>Báo cáo</span>
                                </a>
                            </c:if>
                        </li>
                        <li id="manageAccount">
                            <i class="fa-solid fa-user"></i>
                            <span>Tài khoản</span>
                        </li>
                    </ul>
                </div>
            </div>

            <div class="right">
                <c:if test="${users != null}">
                    <div class="user section">
                        <div class="total">
                            <i class="fa-solid fa-users"></i>
                            <div class="text">
                                <h3>Tổng số tài khoản</h3>
                                <p class="totalUser">${allUser.size()}</p>
                            </div>
                        </div>
                        <div class="search">
                            <input type="text" placeholder="Nhập tìm kiếm">
                            <button class="search-btn">Tìm kiếm</button>
                            <div class="add">
                                Thêm người dùng
                            </div>
                        </div>
                        <div class="user-list">
                            <div class="title">
                                <h4>STT</h4>
                                <h4>Tên</h4>
                                <h4>Email</h4>
                                <h4>SĐT</h4>
                            </div>
                            <c:forEach var="user" items="${users}" varStatus="index">
                                <div class="user-item">
                                    <p class="index">${(currentPage - 1) * productPerPage + index.index + 1}</p>
                                    <p class="name">${user.getFullName()}</p>
                                    <p class="email">${user.getEmail()}</p>
                                    <p class="phone">${user.getPhone()}</p>
                                    <i class="fa-solid fa-clipboard detail"></i>
                                    <a href="deleteUserAdmin?id=${user.getId()}">
                                        <i class="fa-solid fa-xmark del"></i>
                                    </a>
                                </div>
                            </c:forEach>
                        </div>
                    </div>
                </c:if>

                <c:if test="${products != null}">
                    <div class="product section">
                        <div class="total">
                            <i class="fa-solid fa-shop"></i>
                            <div class="text">
                                <h3>Tổng số sản phẩm</h3>
                                <p class="totalProduct">${allProduct.size()}</p>
                            </div>
                        </div>
                        <div class="search">
                            <input type="text" placeholder="Nhập tìm kiếm">
                            <button class="search-btn">Tìm kiếm</button>
                            <div class="add">
                                Thêm sản phẩm
                            </div>
                        </div>
                        <div class="product-list">
                            <div class="title">
                                <h4>STT</h4>
                                <h4>Ảnh</h4>
                                <h4>Tên</h4>
                            </div>
                            <c:forEach var="product" items="${products}" varStatus="index">
                                <div class="product-item">
                                    <p class="index">${(currentPage - 1) * productPerPage + index.index + 1}</p>
                                    <img src="${product.getImg()}" alt="">
                                    <p class="name">${product.getName()}</p>
                                    <i class="fa-solid fa-clipboard detail"></i>
                                    <i class="fa-solid fa-xmark del"></i>
                                </div>
                            </c:forEach>
                        </div>

                    </div>
                </c:if>

                <c:if test="${categories != null}">
                    <div class="brand section">
                        <div class="title">
                            <div class="total">
                                <i class="fa-solid fa-layer-group"></i>
                                <div class="text">
                                    <h3>Tổng số danh mục</h3>
                                    <p class="totalBrand">${allCategory.size()}</p>
                                </div>
                            </div>
                            <div class="search">
                                <input type="text" placeholder="Nhập tìm kiếm">
                                <button class="search-btn">Tìm kiếm</button>
                                <div class="add">
                                    Thêm danh mục
                                </div>
                            </div>
                        </div>
                        <div class="brand-list">
                            <div class="brand-title">
                                <h4>STT</h4>
                                <h4>Tên</h4>
                            </div>
                            <c:forEach items="${categories}" var="category" varStatus="index">
                                <div class="brand-item">
                                    <p class="index">${(currentPage - 1) * productPerPage + index.index + 1}</p>
                                    <p class="name">${category.getName()}</p>
                                    <i class="fa-solid fa-clipboard detail"></i>
                                    <a href="deleteCategoryAdmin">
                                        <i class="fa-solid fa-xmark del"></i>
                                    </a>
                                </div>
                            </c:forEach>
                        </div>
                    </div>
                </c:if>

                <c:if test="${colors != null}">
                    <div class="color section">
                        <div class="title">
                            <div class="total">
                                <i class="fa-solid fa-palette"></i>
                                <div class="text">
                                    <h3>Tổng số màu sắc</h3>
                                    <p class="totalColor">${allColor.size()}</p>
                                </div>
                            </div>
                            <div class="search">
                                <input type="text" placeholder="Nhập tìm kiếm">
                                <button class="search-btn">Tìm kiếm</button>
                                <div class="add">
                                    Thêm màu sắc
                                </div>
                            </div>
                        </div>
                        <div class="color-list">
                            <div class="color-title">
                                <h4>STT</h4>
                                <h4>Tên</h4>
                            </div>
                            <c:forEach var="color" items="${colors}" varStatus="index">
                                <div class="color-item">
                                    <p class="index">${(currentPage - 1) * productPerPage + index.index + 1}</p>
                                    <p class="name">Màu ${color.getName()}</p>
                                    <i class="fa-solid fa-clipboard detail"></i>
                                    <a href="deleteColorAdmin">
                                        <i class="fa-solid fa-xmark del"></i>
                                    </a>
                                </div>
                            </c:forEach>
                        </div>
                    </div>
                </c:if>

                <c:if test="${sizes != null}">
                    <div class="size section">
                        <div class="title">
                            <div class="total">
                                <i class="fa-solid fa-rectangle-list"></i>
                                <div class="text">
                                    <h3>Tổng số kích thước</h3>
                                    <p class="totalSize">${allSize.size()}</p>
                                </div>
                            </div>
                            <div class="search">
                                <input type="text" placeholder="Nhập tìm kiếm">
                                <button class="search-btn">Tìm kiếm</button>
                                <div class="add">
                                    Thêm kích thước
                                </div>
                            </div>
                        </div>
                        <div class="size-list">
                            <div class="size-title">
                                <h4>STT</h4>
                                <h4>Tên</h4>
                            </div>
                            <c:forEach items="${sizes}" var="size" varStatus="index">
                                <div class="size-item">
                                    <p class="index">${(currentPage - 1) * productPerPage + index.index + 1}</p>
                                    <p class="name">Size ${size.getName()}</p>
                                    <i class="fa-solid fa-clipboard detail"></i>
                                    <a href="deleteSizeAdmin">
                                        <i class="fa-solid fa-xmark del"></i>
                                    </a>
                                </div>
                            </c:forEach>
                        </div>
                    </div>
                </c:if>

                <c:if test="${bills != null}">
                    <div class="report section">
                        <div class="tk_sale">
                            <div class="sale">
                                <i class="fa-solid fa-chart-line"></i>
                                <div class="text">
                                    <p>Doanh thu hôm nay</p>
                                    <h4 class="todaySale">0 VNĐ</h4>
                                </div>
                            </div>
                            <div class="sale">
                                <i class="fa-solid fa-chart-column"></i>
                                <div class="text">
                                    <p>Tổng doanh thu</p>
                                    <h4 class="totalSale">0 VNĐ</h4>
                                </div>
                            </div>
                        </div>
                        <div class="bill section">
                            <div class="search">
                                <input type="text" placeholder="Nhập tìm kiếm">
                                <button class="search-btn">Tìm kiếm</button>
                            </div>
                            <div class="bill-list">
                                <div class="title">
                                    <h4>STT</h4>
                                    <h4>Mã đơn hàng</h4>
                                    <h4>Số điện thoại</h4>
                                    <h4>Ngày đặt</h4>
                                    <h4>Tình trạng</h4>
                                </div>
                                <c:forEach var="bill" items="${bills}" varStatus="index">
                                    <div class="bill-item">
                                        <p class="index">${(currentPage - 1) * productPerPage + index.index + 1}</p>
                                        <p class="id">${bill.getName()}</p>
                                        <p class="phone">${bill.getUser().getPhone()}</p>
                                        <p class="date">
                                            ${bill.getDate().getDayOfMonth()}
                                                /
                                            ${bill.getDate().getMonthValue()}
                                                /
                                            ${bill.getDate().getYear()}
                                        </p>

                                        <p class="state">${bill.getStatus()}</p>
                                        <i class="fa-solid fa-clipboard detail"></i>
                                        <i class="fa-solid fa-xmark del"></i>
                                    </div>
                                </c:forEach>

                            </div>
                            <div class="pagination">
                                <ul>
                                    <li class="arrowPage previousPage"><a><i class="fa-solid fa-arrow-left"></i></a></li>
                                    <ul class="number-page">
                                        <!--<li class="numb"><a href="#">1</a></li>-->
                                    </ul>
                                    <li class="nextPage arrowPage arrowActive"><a><i class="fa-solid fa-arrow-right"></i></a></li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </c:if>

                <div class="pagination">
                    <h1>TotalPage: ${totalPage}</h1>
                    <h1>Current: ${currentPage}</h1>
                    <ul>
                        <c:if test="${currentPage == 1}">
                            <li id="previousPage" class="arrowPageLi"><a class="arrowPagea"><i class="fa-solid fa-angles-left"></i></a></li>
                        </c:if>
                        <c:if test="${currentPage != 1}">
                            <li id="previousPage"><a class="arrowActive" href="${href}&currentPage=1"><i class="fa-solid fa-angles-left"></i></a></li>
                        </c:if>

                        <c:if test="${currentPage == 1}">
                            <li id="previousPage" class="arrowPageLi"><a class="arrowPagea"><i class="fa-solid fa-chevron-left"></i></a></li>
                        </c:if>
                        <c:if test="${currentPage != 1}">
                            <li id="previousPage"><a class="arrowActive" href="${href}&currentPage=${currentPage-1}"><i class="fa-solid fa-chevron-left"></i></a></li>
                        </c:if>
                        <ul id="number-page">
                            <c:choose>
                                <c:when test="${totalPage >= 3}">
                                    <c:if test="${currentPage == 1}">
                                        <li class="numb"> <a class="pageNumberActive">
                                                ${currentPage}
                                        </a> </li>
                                        <li class="numb"> <a href="${href}&currentPage=${currentPage+1}">
                                                ${currentPage + 1}
                                        </a> </li>
                                        <li class="numb"> <a href="${href}&currentPage=${currentPage+2}">
                                                ${currentPage + 2}
                                        </a> </li>
                                    </c:if>
                                    <c:if test="${currentPage > 1 && currentPage < totalPage}">
                                        <li class="numb"> <a href="${href}&currentPage=${currentPage-1}">
                                                ${currentPage - 1}
                                        </a> </li>
                                        <li class="numb"> <a class="pageNumberActive">
                                                ${currentPage}
                                        </a> </li>
                                        <li class="numb"> <a href="${href}&currentPage=${currentPage+1}">
                                                ${currentPage + 1}
                                        </a> </li>
                                    </c:if>
                                    <c:if test="${currentPage == totalPage}">
                                        <li class="numb"> <a href="${href}&currentPage=${currentPage-2}">
                                                ${currentPage - 2}
                                        </a> </li>
                                        <li class="numb"> <a href="${href}&currentPage=${currentPage-1}">
                                                ${currentPage - 1}
                                        </a> </li>
                                        <li class="numb"> <a class="pageNumberActive">
                                                ${currentPage}
                                        </a> </li>
                                    </c:if>

                                </c:when>
                                <c:when test="${totalPage < 3}">
                                    <c:forEach begin="1" end="${totalPage}" varStatus="index">
                                        <c:if test="${index.count == currentPage}">
                                            <li class="numb"> <a class="pageNumberActive">
                                                    ${index.count}
                                            </a> </li>
                                        </c:if>
                                        <c:if test="${index.count != currentPage}">
                                            <li class="numb"> <a href="${href}&currentPage=${index.count}">
                                                    ${index.count}
                                            </a> </li>
                                        </c:if>
                                    </c:forEach>
                                </c:when>
                            </c:choose>

                        </ul>

                        <c:if test="${currentPage == totalPage}">
                            <li id="nextPage" class="arrowPageLi"><a class="arrowPagea"><i class="fa-solid fa-chevron-right"></i></a></li>
                        </c:if>
                        <c:if test="${currentPage != totalPage}">
                            <li id="nextPage"><a class="arrowActive" href="${href}&currentPage=${currentPage+1}"><i class="fa-solid fa-chevron-right"></i></a></li>
                        </c:if>

                        <c:if test="${currentPage == totalPage}">
                            <li id="nextPage" class="arrowPageLi"><a class="arrowPagea"><i class="fa-solid fa-angles-right"></i></a></li>
                        </c:if>
                        <c:if test="${currentPage != totalPage}">
                            <li id="nextPage"><a class="arrowActive" href="${href}&currentPage=${totalPage}"><i class="fa-solid fa-angles-right"></i></a></li>
                        </c:if>
                    </ul>
                </div>

<%--                <div class="order section">--%>
<%--                    <div class="total">--%>
<%--                        <i class="fa-solid fa-shop"></i>--%>
<%--                        <div class="text">--%>
<%--                            <h3>Tổng số đơn hàng</h3>--%>
<%--                            <p class="totalOrder">${allBills.size()}</p>--%>
<%--                        </div>--%>
<%--                    </div>--%>
<%--                    <div class="search">--%>
<%--                        <input type="text" placeholder="Nhập tìm kiếm">--%>
<%--                        <button class="search-btn">Tìm kiếm</button>--%>
<%--                    </div>--%>
<%--                    <div class="order-list">--%>
<%--                        <div class="title">--%>
<%--                            <h4>STT</h4>--%>
<%--                            <h4>Mã đơn hàng</h4>--%>
<%--                            <h4>Tên sản phẩm</h4>--%>
<%--                            <h4>Số điện thoại</h4>--%>
<%--                            <h4>Ngày đặt</h4>--%>
<%--                            <h4>Tình trạng</h4>--%>
<%--                        </div>--%>
<%--                        <div class="order-item">--%>
<%--                            <p class="index">1</p>--%>
<%--                            <p class="id">DH01</p>--%>
<%--                            <p class="name">Giày Patin Tốc Độ – Speed Flying Eagle PHANTOM</p>--%>
<%--                            <p class="phone">0839151003</p>--%>
<%--                            <p class="date">11/11/2023</p>--%>
<%--                            <p class="state">Đã giao</p>--%>
<%--                            <i class="fa-solid fa-clipboard detail"></i>--%>
<%--                            <i class="fa-solid fa-xmark del"></i>--%>
<%--                        </div>--%>

<%--                    </div>--%>
<%--                    <div class="pagination">--%>
<%--                        <ul>--%>
<%--                            <li class="arrowPage previousPage"><a><i class="fa-solid fa-arrow-left"></i></a></li>--%>
<%--                            <ul class="number-page">--%>
<%--                                <!--<li class="numb"><a href="#">1</a></li>-->--%>
<%--                            </ul>--%>
<%--                            <li class="nextPage arrowPage arrowActive"><a><i class="fa-solid fa-arrow-right"></i></a></li>--%>
<%--                        </ul>--%>
<%--                    </div>--%>
<%--                </div>--%>



                <div class="person section">
                    <div class="top">
                        <h3>Thông tin tài khoản</h3>
                        <div class="logout">Thoát</div>
                    </div>

                    <div class="info">
                        <div class="holder">
                            <label>Họ Tên</label>
                            <input type="text" >
                        </div>
                        <div class="holder">
                            <label>Email</label>
                            <input type="email">
                        </div>
                        <div class="holder">
                            <label>Mật khẩu</label>
                            <input type="password">
                        </div>

                        <div class="save">
                            Lưu
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <c:if test="${users != null}">
        <div class="modal modal-user">
            <div class="modal-container modalConUser modal-containerUser">
                <i class="fa-solid fa-xmark del"></i>
                <h3>Thêm người dùng</h3>
                <form action="addUserAdmin">
                    <div class="wrapper">
                        <div class="main">
                            <div class="hold">
                                <label>Tên</label>
                                <input type="text" name="fullname">
                            </div>

                            <div class="hold">
                                <label>Email</label>
                                <input type="email" name="email">
                            </div>
                            <div class="hold">
                                <label>Địa chỉ</label>
                                <input type="text" name="address">
                            </div>
                            <div class="hold">
                                <label>Mật khẩu</label>
                                <input type="password" name="password">
                            </div>

                        </div>
                        <div class="more">
                            <div class="hold">
                                <label>Số điện thoại</label>
                                <input type="tel" name="phone">
                            </div>
                            <div class="box">
                                <div class="gender">
                                    <label>Giới tính:</label>
                                    <div class="selectGender">
                                        <input type="radio" name="gender" checked = "true" value="Nam">
                                        <label>Nam</label>
                                        <input type="radio" name="gender" value="Nữ">
                                        <label>Nữ</label>
                                    </div>
                                </div>
                                <div class="role">
                                    <label>Vai trò:</label>
                                    <select name="role">
                                        <option value="0" selected>Khách hàng</option>
                                        <option value="1">Mod</option>
                                        <option value="2">Admin</option>
                                    </select>
                                </div>
                                <div class="verify">
                                    <label>Xác thực Email:</label>
                                    <select name="verify">
                                        <option value="0" selected>Chưa xác nhận</option>
                                        <option value="1">Đã xác nhận</option>
                                    </select>
                                </div>
                            </div>
                            <div class="dob">
                                <label>Ngày sinh:</label>
                                <div class="dob-input">
                                    <select class="day" name="day">
                                    </select>
                                    <select class="month" name="month">
                                    </select>
                                    <select class="year" name="year">
                                    </select>
                                </div>
                            </div>
                            <div>
                                <input type="file">
                            </div>

                        </div>
                    </div>
                    <button type="submit" class="add">Thêm</button>
                </form>
            </div>
        </div>
        <div class="modal modal-edit modal-Edituser">

            <div class="modal-container modalConUser modal-containerEditUser">
                <i class="fa-solid fa-xmark del"></i>
                <h3>Chi tiết</h3>
                <form action="updateUserAdmin">
                    <div class="wrapper">
                        <div class="main">
                            <div class="hold">
                                <label>Tên</label>
                                <input type="text" name="fullname">
                            </div>

                            <div class="hold">
                                <label>Email</label>
                                <input type="email" name="email">
                            </div>
                            <div class="hold">
                                <label>Địa chỉ</label>
                                <input type="text" name="phone">
                            </div>

                        </div>
                        <div class="more">
                            <div class="hold">
                                <label>Số điện thoại</label>
                                <input type="tel" name="phone">
                            </div>
                            <div class="gender">
                                <label>Giới tính:</label>
                                <div class="selectGender">
                                    <input type="radio" name="gender" checked = "true">
                                    <label>Nam</label>
                                    <input type="radio" name="gender">
                                    <label>Nữ</label>
                                </div>
                            </div>
                            <div class="dob">
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
                            <div>
                                <input type="file">
                            </div>

                        </div>
                    </div>
                    <button type="submit" class="add">Cập nhật</button>
                </form>
            </div>
        </div>
    </c:if>

    <c:if test="${products != null}">
        <div class="modal modal-product">
            <div class="modal-container modalConProduct modal-containerProduct">
                <i class="fa-solid fa-xmark del"></i>
                <h3>Thêm sản phẩm</h3>
                <form>
                    <div class="wrapper">
                        <div class="main">
                            <div class="hold">
                                <label>Tên sản phẩm</label>
                                <input type="text">
                            </div>
                            <div class="hold-2">
                                <div class="hold">
                                    <label>Giá gốc</label>
                                    <input type="text">
                                </div>
                                <div class="hold">
                                    <label>Giảm giá</label>
                                    <input type="text">
                                </div>
                            </div>
                            <div class="hold-2">
                                <div class="hold">
                                    <label>Màu sắc</label>
                                    <select name="color">
                                        <option>Trắng</option>
                                    </select>
                                </div>
                                <div class="hold">
                                    <label>Size</label>
                                    <select name="size">
                                        <option>27</option>
                                    </select>
                                </div>
                            </div>
                        </div>
                        <div class="more">
                            <div class="hold">
                                <label>Thông tin khác</label>
                                <textarea></textarea>
                            </div>
                            <div class="chooseImg">
                                <input type="file">
                                <input type="file">
                                <input type="file">
                                <input type="file">
                            </div>
                        </div>
                    </div>
                    <button class="add">Thêm</button>
                </form>
            </div>
        </div>
        <div class="modal modal-edit modal-Editproduct">

            <div class="modal-container modalConProduct modal-containerEditProduct">
                <i class="fa-solid fa-xmark del"></i>
                <h3>Thêm sản phẩm</h3>
                <form>
                    <div class="wrapper">
                        <div class="main">
                            <div class="hold">
                                <label>Tên sản phẩm</label>
                                <input type="text">
                            </div>
                            <div class="hold-2">
                                <div class="hold">
                                    <label>Giá gốc</label>
                                    <input type="text">
                                </div>
                                <div class="hold">
                                    <label>Giảm giá</label>
                                    <input type="text">
                                </div>
                            </div>
                            <div class="hold-2">
                                <div class="hold">
                                    <label>Màu sắc</label>
                                    <!--                                <input type="text">-->
                                    <select name="color">
                                        <option>Trắng</option>
                                    </select>
                                </div>
                                <div class="hold">
                                    <label>Size</label>
                                    <select name="size">
                                        <option>27</option>
                                    </select>
                                </div>
                            </div>
                        </div>
                        <div class="more">
                            <div class="hold">
                                <label>Thông tin khác</label>
                                <textarea></textarea>
                            </div>
                            <div class="chooseImg">
                                <input type="file">
                                <input type="file">
                                <input type="file">
                                <input type="file">
                            </div>
                        </div>
                    </div>
                    <button class="add">Thêm</button>
                </form>
            </div>
        </div>
    </c:if>



<%--    <div class="modal modal-EditOrder">--%>
<%--        <div class="modal-container modal-containerEditOrder">--%>
<%--            <i class="fa-solid fa-xmark del"></i>--%>
<%--            <h3>Sửa đơn hàng</h3>--%>
<%--            <form>--%>
<%--                <div class="wrapper">--%>
<%--                    <div class="main">--%>
<%--                        <div class="hold">--%>
<%--                            <label>Mã đơn hàng</label>--%>
<%--                            <input type="text">--%>
<%--                        </div>--%>
<%--                        <div class="hold">--%>
<%--                            <label>Tên sản phẩm</label>--%>
<%--                            <input type="text">--%>
<%--                        </div>--%>
<%--                        <div class="hold">--%>
<%--                            <label>Tình trạng</label>--%>
<%--                            <input type="text">--%>
<%--                        </div>--%>

<%--                    </div>--%>
<%--                    <div class="more">--%>
<%--                        <div class="hold">--%>
<%--                            <label>Ngày đặt</label>--%>
<%--                            <input type="date">--%>
<%--                        </div>--%>
<%--                        <div class="hold">--%>
<%--                            <label>Thông tin khác</label>--%>
<%--                            <textarea></textarea>--%>
<%--                        </div>--%>
<%--                    </div>--%>
<%--                </div>--%>
<%--                <button class="add">Sửa</button>--%>
<%--            </form>--%>
<%--        </div>--%>
<%--    </div>--%>

    <c:if test="${categories != null}">
        <div class="modal modal-brand">
            <div class="modal-container modal-containerBrand">
                <i class="fa-solid fa-xmark del"></i>
                <h3>Thêm danh mục</h3>
                <form action="addCategoryAdmin">
                    <input type="text" placeholder="Nhập tên danh mục" name="name">
                    <button type="submit" class="add">Thêm</button>
                </form>
            </div>
        </div>

        <div class="modal modal-edit modal-Editbrand">
            <div class="modal-container modal-containerEditBrand">
                <i class="fa-solid fa-xmark del"></i>
                <h3>Sửa danh mục</h3>
                <form action="updateCategoryAdmin">
                    <input type="text" placeholder="Nhập tên danh mục">
                    <button class="add">Sửa</button>
                </form>
            </div>
        </div>
    </c:if>

    <c:if test="${colors != null}">
        <div class="modal modal-color">
            <div class="modal-container modal-containerColor">
                <i class="fa-solid fa-xmark del"></i>
                <h3>Thêm màu</h3>
                <form action="addColorAdmin">
                    <input type="text" placeholder="Nhập tên màu sắc" name="name">
                    <button type="submit" class="add">Thêm</button>
                </form>
            </div>
        </div>

        <div class="modal modal-edit modal-Editcolor">
            <div class="modal-container modal-containerEditColor">
                <i class="fa-solid fa-xmark del"></i>
                <h3>Sửa tên màu sắc</h3>
                <form action="updateColorAdmin">
                    <input type="text" placeholder="Nhập tên màu sắc">
                    <button class="add">Sửa</button>
                </form>
            </div>
        </div>
    </c:if>

    <c:if test="${sizes != null}">
        <div class="modal modal-size">
            <div class="modal-container modal-containerSize">
                <i class="fa-solid fa-xmark del"></i>
                <h3>Thêm kích thước</h3>
                <form action="addSizeAdmin">
                    <input type="text" placeholder="Nhập số kích thước" name="name">
                    <button type="submit" class="add">Thêm</button>
                </form>
            </div>
        </div>

        <div class="modal modal-edit modal-Editsize">
            <div class="modal-container modal-containerEditSize">
                <i class="fa-solid fa-xmark del"></i>
                <h3>Sửa kích thước</h3>
                <form action="updateSizeAdmin">
                    <input type="text" placeholder="Nhập số kích thước">
                    <button class="add">Sửa</button>
                </form>
            </div>
        </div>
    </c:if>



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
    <script src="${pageContext.request.contextPath}/assets/js/admin.js"></script>
    <script src="${pageContext.request.contextPath}/assets/js/popupNotice.js"></script>
</body>
</html>