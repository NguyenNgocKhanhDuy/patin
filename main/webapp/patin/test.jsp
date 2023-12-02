<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 12/2/2023
  Time: 2:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@ page isELIgnored="false" %>
<head>
    <title>Title</title>
</head>
<body>

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

</body>
</html>
