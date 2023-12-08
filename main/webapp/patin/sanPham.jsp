<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 12/1/2023
  Time: 4:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/patin/assets/css/base.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/patin/assets/css/sanPham.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/patin/assets/fontawesome/css/all.min.css">
    <title>Sản Phẩm</title>
</head>
<body>
    <header>
        <div class="container">
            <img src="${pageContext.request.contextPath}/patin/assets/images/logo.PNG" alt="" class="logo">
            <nav>
                <ul class="menu">
                    <li><a href="index.jsp">TRANG CHỦ</a></li>
                    <li>
                        <a href="#">SẢN PHẨM</a>
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
                <input type="text" placeholder="Nhập vào sản phẩm" id="search">
                <button id="searchBtn">Tìm Kiếm</button>
                <ul>

                </ul>
            </div>
        </div>
    </div>

    <div id="image">
        <div class="container-img">
            <img src="${pageContext.request.contextPath}/patin/assets/images/patin.jpg" alt="">
            <p class="title">Sản phẩm</p>
        </div>
    </div>

    <div id="content">
        <div class="container">
            <div class="left">
                <div class="category">
                    <h3>Danh Mục</h3>
                    <ul class="list-category">
                        <c:forEach var="i" items="${category}">
                            <li><a href="./danhMuc.html">${i.getName()}</a></li>
                        </c:forEach>
                    </ul>
                </div>
                <form action="sanPham-servlet" class="filter">
                    <div class="price">
                        <h3>Giá bán (VNĐ)</h3>
                        <div class="price-input">
                            <div class="field">
                                <span>Min</span>
                                <input type="number" id="text-min" name="input-min" min="0" max="15000000" value="${min}" step="10000" oninput="rangeText()">
                            </div>
                            <div class="separator">-</div>
                            <div class="field">
                                <span>Max</span>
                                <input type="number" id="text-max" name="input-max" min="0" max="15000000" value="${max}" step="10000" oninput="rangeText()">
                            </div>
                        </div>
                        <div class="slider">
                            <div class="progress" id="progress"></div>
                        </div>
                        <div class="range-input">
                            <input type="range" id="min" class="range-min" min="0" max="15000000" value="${min}" oninput="rangeSlider()">
                            <input type="range" id="max" class="range-max" min="0" max="15000000" value="${max}" oninput="rangeSlider()">
                        </div>
                    </div>
                    <div class="color">
                        <h3>Màu sắc</h3>
                        <div class="color-box">
                            <div class="color-item">
                                <label>Đen</label>
                                <input type="checkbox" ${colors.contains("2") ? "checked":""} class="check-color" value="2" name="color" id="black" onchange="changeBG(this)">
                            </div>
                            <div class="color-item">
                                <label>Trắng</label>
                                <input type="checkbox" ${colors.contains("1") ? "checked":""} class="check-color" value="1" name="color" id="white" onchange="changeBG(this)">
                            </div>
                            <div class="color-item">
                                <label>Đỏ</label>
                                <input type="checkbox" ${colors.contains("8") ? "checked":""} class="check-color" value="8" name="color" id="red" onchange="changeBG(this)">
                            </div>
                            <div class="color-item">
                                <label>Hồng</label>
                                <input type="checkbox" ${colors.contains("3") ? "checked":""} class="check-color" value="3" name="color" id="pink" onchange="changeBG(this)">
                            </div>
                            <div class="color-item">
                                <label>Xanh dương</label>
                                <input type="checkbox" ${colors.contains("4") ? "checked":""} class="check-color" value="4" name="color" id="blue" onchange="changeBG(this)">
                            </div>
                            <div class="color-item">
                                <label>Vàng</label>
                                <input type="checkbox" ${colors.contains("6") ? "checked":""} class="check-color" value="6" name="color" id="yellow" onchange="changeBG(this)">
                            </div>
                        </div>
                    </div>
                    <input type="hidden" name="sort" id="hiddenSort">
                    <input type="submit" class="filterBtn" value="Lọc">
                </form>
            </div>
            <div class="right">
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
                </div>
                <div class="bottom">
                    <div class="sort">
                        <span>Sắp xếp</span>
                        <select>
                            <option value="1">Mặc định</option>
                            <option ${selectasc} value="2">Giá tăng dần</option>
                            <option ${selectdesc} value="3">Giá giảm dần</option>
                        </select>
                    </div>
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
                </div>
                <div class="pagination">
                    <ul>
                        <c:if test="${currentPage == 1}">
                            <li id="previousPage" class="arrowPage"><a><i class="fa-solid fa-arrow-left"></i></a></li>
                        </c:if>
                        <c:if test="${currentPage != 1}">
                            <li id="previousPage" class="arrowActive arrowPage"><a href="${href}&currentPage=${currentPage-1}"><i class="fa-solid fa-arrow-left"></i></a></li>
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
                                    <c:forEach begin="1" end="${totalPage+1}" varStatus="index">
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

                        <c:if test="${currentPage == totalPage+1}">
                            <li id="nextPage" class="arrowPage"><a><i class="fa-solid fa-arrow-right"></i></a></li>
                        </c:if>
                        <c:if test="${currentPage != totalPage+1}">
                            <li id="nextPage" class="arrowPage arrowActive"><a href="${href}&currentPage=${currentPage+1}"><i class="fa-solid fa-arrow-right"></i></a></li>
                        </c:if>
                    </ul>
                </div>
            </div>
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
    <script src="${pageContext.request.contextPath}/patin/assets/js/sanPham.js"></script>
    </body>
</html>
