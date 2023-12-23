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
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/product_detail.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/fontawesome/css/all.min.css">
    <title>Chi tiết sản phẩm</title>
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
                                <c:set var="location" value="productDetail?productID=${productID}" scope="session"/>
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

    <div id="content">
        <div class="container">
            <div class="product">
                <div class="left">
                    <img id="img-main" src="${product.getImg()}" alt="">

                    <div class="carousel" id="carousel">
                        <c:forEach var="img" items="${listImg}">
                            <c:if test="${img.getId() != 1}">
                                <img class="sub-img" src="${img.getUrl()}" alt="">
                            </c:if>
                        </c:forEach>
                    </div>

                </div>
                <div class="right">
                    <h2 id="name">${product.getName()}</h2>
                    <div class="rating-star">
                        <i class="fa-solid fa-star"></i>
                        <i class="fa-solid fa-star"></i>
                        <i class="fa-solid fa-star"></i>
                        <i class="fa-solid fa-star"></i>
                        <i class="fa-solid fa-star"></i>
                        <!--                        <span>(18 lượt đánh giá)</span>-->
                    </div>
                    <div class="price-section">
                        <p id="priceDetail">
                            <c:if test="${product.getMinPrice() != product.getMaxPrice()}">
                                <fmt:formatNumber value="${product.getMinPrice()}" type="currency"/>
                                -
                                <fmt:formatNumber value="${product.getMaxPrice()}" type="currency"/>
                            </c:if>

                            <c:if test="${product.getMinPrice() == product.getMaxPrice()}">
                                <fmt:formatNumber value="${product.getMinPrice()}" type="currency"/>
                            </c:if>
                        </p>
                    </div>
                    <form action="cartController">
                        <input type="hidden" id="idProduct" name="productID" value="${productID}">
                        <div class="colors">
                            <span>Màu sắc</span>
                            <div class="container-checkColor">
                                <c:forEach items="${colors}" var="color">
                                    <c:if test="${color.getId() == 1}">
                                        <div class="check-color">
                                            <input type="radio" value="white">
                                            <input type="hidden" value="${color.getId()}">
                                        </div>
                                    </c:if>
                                    <c:if test="${color.getId() == 2}">
                                        <div class="check-color">
                                            <input type="radio" value="black">
                                            <input type="hidden" value="${color.getId()}">
                                        </div>
                                    </c:if>
                                    <c:if test="${color.getId() == 3}">
                                        <div class="check-color">
                                            <input type="radio" value="pink">
                                            <input type="hidden" value="${color.getId()}">
                                        </div>
                                    </c:if>
                                    <c:if test="${color.getId() == 4}">
                                        <div class="check-color">
                                            <input type="radio" value="blue">
                                            <input type="hidden" value="${color.getId()}">
                                        </div>
                                    </c:if>
                                    <c:if test="${color.getId() == 5}">
                                        <div class="check-color">
                                            <input type="radio" value="green">
                                            <input type="hidden" value="${color.getId()}">
                                        </div>
                                    </c:if>
                                    <c:if test="${color.getId() == 6}">
                                        <div class="check-color">
                                            <input type="radio" value="yellow">
                                            <input type="hidden" value="${color.getId()}">
                                        </div>
                                    </c:if>
                                    <c:if test="${color.getId() == 7}">
                                        <div class="check-color">
                                            <input type="radio" value="brown">
                                            <input type="hidden" value="${color.getId()}">
                                        </div>
                                    </c:if>
                                    <c:if test="${color.getId() == 8}">
                                        <div class="check-color">
                                            <input type="radio" value="red">
                                            <input type="hidden" value="${color.getId()}">
                                        </div>
                                    </c:if>
                                </c:forEach>
                            </div>
                        </div>
                        <div class="sizes">
                            <span>Kích cỡ</span>
                            <div class="container-checkSize">
                                <c:forEach var="size" items="${sizes}">
                                    <div class="check-size">
                                        ${size.getName()}
                                        <input type="radio" name="size" value="${size.getId()}">
                                    </div>
                                </c:forEach>
                            </div>
                        </div>
                        <div class="quantityStore">
                            <p id="quantityDetail">
                                ${totalQuantity}
                            </p>
                            sản phẩm có sẵn
                        </div>
                        <div class="deselect">
                            <span>Bỏ Chọn</span>
                        </div>
                        <div class="buy">
                            <div class="quantity">
                                <i id="minus" class="fa-solid fa-minus"></i>
                                <input type="number" value="1"name="quantity">
                                <i id="plus" class="fa-solid fa-plus"></i>
                            </div>
                            <div class="addTocart">
                                <input class="btnAdd" type="submit" value="Thêm vào giỏ hàng">
                            </div>
                            <a href="addWishList?productID=${productID}">
                                <span id="addToLike">
                                    <i class="fa-regular fa-heart"></i>
                                </span>
                            </a>
                        </div>
                    </form>
                    <div class="moreInfo">
                        <c:if test="${product.getSalePercent() != 0}">
                            <p>
                            <span class="title">Khuyến mãi:</span>
                                <span class="sub-title khuyenMai">
                                    <fmt:formatNumber type="percent" value="${product.getSalePercent()}"/>
                                </span>
                            </p>
                        </c:if>
                        <p>
                            <span class="title">Tình trạng:</span>
                            <c:if test="${totalQuantity > 0}">
                                <span class="sub-title">Còn hàng</span>
                            </c:if>
                            <c:if test="${totalQuantity <= 0}">
                                <span class="sub-title">Hết hàng</span>
                            </c:if>
                        </p>
                        <p>
                            <span class="title">Giao hàng:</span>
                            <span class="sub-title">2 - 5 ngày</span>
                        </p>
                    </div>
                </div>
            </div>
            <div class="info">
                <div class="navigation">
                    <ul>
                        <li id="info"><a class="activeNav">Thông tin</a></li>
                        <li id="review"><a>Đánh giá</a></li>
                    </ul>
                </div>
                <div class="info-text">
                    <h3 class="title">Thông tin sản phẩm</h3>
                    <p class="product-info">
                        ${product.getInformation()}
                    </p>
                </div>
                <div class="review">
                    <div class="left">
                        <p>Chưa có đánh giá nào</p>
                    </div>
                    <div class="right">
                        <h3>Thêm đánh giá</h3>
                        <p>Đánh giá của bạn</p>
                        <div class="rating-star">
                            <i class="fa-solid fa-star"></i>
                            <i class="fa-solid fa-star"></i>
                            <i class="fa-solid fa-star"></i>
                            <i class="fa-solid fa-star"></i>
                            <i class="fa-solid fa-star"></i>
                        </div>
                        <p>Nhận xét của bạn</p>
                        <textarea></textarea>
                        <div class="send">Gửi đi</div>
                    </div>
                </div>
            </div>
            <div class="other-product">
                <h3>Sản phẩm khác</h3>
                <div class="product-list" id="product-list">
                    <c:forEach items="${orderProducts}" var="product">
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
                                                 <h5 class="price">
                                                    <fmt:formatNumber value="${product.getMinPrice()}" type="currency"/>
                                                 </h5>
                                                <h5 class="origin">
                                                    <fmt:formatNumber value="${product.getMinPrice() / (1 - product.getSalePercent())}" type="currency"/>
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
                                <ul>
                                    <li><i class="fa-solid fa-heart like"></i></li>
                                    <li><i class="fa-solid fa-cart-shopping cart"></i></li>
                                </ul>
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
            </div>
        </div>
        <div class="modal-img">
            <div class="modal-img-container">
                <i id="closeModalImg" class="fa-solid fa-x"></i>
                <i id="previousImg" class="fa-solid fa-left-long"></i>
                <i id="nextImg" class="fa-solid fa-right-long"></i>
                <img id="imageInModal" src="" alt="">
            </div>
        </div>
    </div>

    <div class="modal">
        <div class="modal-container">
            <i class="fa-solid fa-xmark del"></i>
            <h2>Chi tiết</h2>
            <div class="modal-detail">
                <div class="detail-info">
                    <div class="detail-section">
                        <h3 class="title">Màu sắc: </h3>
                        <span class="selected color">Xanh dương</span>
                    </div>
                    <div class="detail-section">
                        <h3 class="title">Kích thước: </h3>
                        <span class="selected size">34</span>
                    </div>
                    <div class="detail-section">
                        <h3 class="title">Số lượng: </h3>
                        <span class="selected quantity">1</span>
                    </div>
                    <div class="detail-section">
                        <h3 class="title">Tổng giá: </h3>
                        <span class="selected price">14,000,000đ</span>
                    </div>
                </div>
                <div class="detail-note">
                    <h3>Ghi chú</h3>
                    <textarea class="note-content"></textarea>
                </div>
            </div>
            <div class="complete">
                <span>Hoàn thành</span>
            </div>
        </div>
    </div>

    <div class="popup ${type != null ? type : "none"}">
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
    <script src="${pageContext.request.contextPath}/assets/js/category.js"></script>
    <script src="${pageContext.request.contextPath}/assets/js/search.js"></script>
    <script src="${pageContext.request.contextPath}/assets/js/product_detail.js"></script>
    </body>
</html>
