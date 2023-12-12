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
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/newPass.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/fontawesome/css/all.min.css">
    <title>Đăng ký</title>
</head>
<body>
    <div class="container">
        <form action="/patin_shop/newPass" class="wrapper">
            <h3>Mật khẩu</h3>
            <div class="code-container">
                <div class="holder">
                    <label>Mật khẩu mới</label>
                    <input class="code" type="password" name="pass" value="${pass != null ? pass : ""}">
                </div>
                <div class="holder">
                    <label>Nhập lại mật khẩu mới</label>
                    <input class="code" type="password" name="confirmPass" value="${confirmPass != null ? confirmPass : ""}">
                </div>
            </div>
            <button class="btn">Thay đổi</button>
        </form>
    </div>
    <script src="${pageContext.request.contextPath}/assets/js/newPass.js"></script>
</body>

</html>
