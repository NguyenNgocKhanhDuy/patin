var emailInput = document.querySelector(".login input[type='email']");
var passInput = document.querySelector(".login input[type='password']");
var submit = document.querySelector(".login button");

submit.addEventListener("click", function (){
    var email = emailInput.value;
    var pass = passInput.value;
    if (email.length <= 0) {
        alert("Email không được để trống");
        return;
    }else if (pass.length <= 0) {
        alert("Mật khẩu không được để trống");
        return;
    }else {
        if (email == "admin" && pass == "123"){
            location.href = "./admin.html";
        }else if (email == "user" && pass == "123") {
            location.href = "./index.jsp";
        }else{
            alert("Sai thông tin");
        }
    }
});