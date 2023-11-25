var emailInput = document.querySelector(".login input[type='email']");
var passInput = document.querySelector(".login input[type='password']");
var submit = document.querySelector(".login button");
var nameInput = document.getElementById("name");
var phone = document.querySelector(".login input[type='tel']");

submit.addEventListener("click", function (){
    var email = emailInput.value;
    var pass = passInput.value;
    var name = nameInput.value;
    if (email.length <= 0) {
        alert("Email không được để trống");
    }else if (pass.length <= 0) {
        alert("Mật khẩu không được để trống");
    }else if(name.length <= 0) {
        alert("Tên không được để trống");
    }
    checkPhone();
    location.href = "./dangNhap.html";

});

function checkPhone() {
    var phoneInput = phone.value;

    var charPhone = phoneInput.split("");
    if (charPhone.length >= 9 && charPhone.length <= 10) {
        for(var i = 0; i < charPhone.length; i++) {
            if(!(charPhone[i] >= '0' && charPhone[i] <= '9')){
                alert("Số điện thoại không hợp lệ");
                return;
            }
        }
    }else if(charPhone.length == 0){
        alert("Số điện thoại không được để trống");
    }else {
        alert("Số điện thoại không hợp lệ");
    }
}