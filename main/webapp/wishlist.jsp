<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/base.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/wishlist.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/fontawesome/css/all.min.css">
    <title>Yêu Thích</title>
    <fmt:setLocale value="vi_VN"/>
</head>
<body>
    <header>
        <div class="container">
            <img src="${pageContext.request.contextPath}/assets/images/logo.PNG" alt="" class="logo">
            <nav>
                <ul class="menu">
                    <li><a href="index.jsp">TRANG CHỦ</a></li>
                    <li>
                        <a href="#">SẢN PHẨM</a>
                        <ul class="sub_menu list-category">

                        </ul>
                    </li>
                    <li><a href=contact.html>LIÊN HỆ</a></li>
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
                    <li><a href="wishlist.html"><i class="fa-solid fa-heart"></i></a></li>
                    <li><a href="cart.html"><i class="fa-solid fa-cart-shopping"></i></a></li>
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
            <img src="assets/images/patin.jpg" alt="">
            <p class="title">Sản phẩm yêu thích</p>
        </div>
    </div>

    <div id="content">
        <div class="container">
            <div class="product-list" id="product-list">
                <c:forEach items="${list}" var="product">
                    <div class="product-item">
                        <a href="productDetail?productID=${product.getId()}">
                            <img src= ${product.getImg()} >
                            <h4 class="name"> ${product.getName()} </h4>
                            <span class="price-section">
                                        <c:if test="${product.getMinPrice() == product.getMaxPrice()}">
                                            <c:if test="${product.getSalePercent() == 0}">
                                                <h5 class="price">
                                                    <fmt:formatNumber value="${product.getMinPrice()}" type="currency"/>
                                                </h5>
                                            </c:if>
                                            <c:if test="${product.getSalePercent() != 0}">
                                                <h5 class="origin">
                                                    <fmt:formatNumber value="${product.getMinPrice() / (1 - product.getSalePercent())}" type="currency"/>
                                                </h5>
                                                <h5 class="price">
                                                    <fmt:formatNumber value="${product.getMinPrice()}" type="currency"/>
                                                 </h5>
                                            </c:if>
                                        </c:if>
                                        <c:if test="${product.getMinPrice() != product.getMaxPrice()}">
                                        <h5 class="price">
                                            <fmt:formatNumber value="${product.getMinPrice()}" type="currency"/>
                                        </h5>
                                            -
                                            <h5 class="price">
                                            <fmt:formatNumber value="${product.getMaxPrice()}" type="currency"/>
                                        </h5>
                                        </c:if>
                            </span>

<%--                            <ul>--%>
<%--                                <li><i class="fa-solid fa-heart like"></i></li>--%>
<%--                            </ul>--%>
                        </a>
                        <c:if test="${product.getSalePercent() != 0}">
                            <div class="sale">
                                <p>
                                    <fmt:formatNumber value="${product.getSalePercent()}" type="percent"/>
                                </p>
                                <img class="tag" src="${pageContext.request.contextPath}/assets/images/tag.png" alt="">
                            </div>
                        </c:if>
                    </div>
                </c:forEach>
            </div>
            <div class="pagination">
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

    <script src="${pageContext.request.contextPath}/assets/js/showDanhMuc.js"></script>
    <script src="${pageContext.request.contextPath}/assets/js/category.js"></script>
    <script src="${pageContext.request.contextPath}/assets/js/search.js"></script>
    <script src="${pageContext.request.contextPath}/assets/js/product_detail.js"></script>
    </body>
</html>
