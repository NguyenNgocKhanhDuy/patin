var paymentChecksShow = document.querySelectorAll(".payment .payment-item input.show");
var paymentChecksHide = document.querySelectorAll(".payment .payment-item input.hide");
var paymentMethod = ["cash", "momo", "zalopay", "bank"];

var index = 0;
function checkPayment() {
    for (let i = 0; i < paymentChecksHide.length; i++) {
        paymentChecksHide[i].addEventListener("click", function () {
           paymentChecksShow[i].checked = "true";
           index = i;
           localStorage.setItem("payment", paymentMethod[i]);
        });
    }
}

checkPayment();

var checkoutBtn = document.querySelector(".checkout .checkoutBtn");
checkoutBtn.addEventListener("click", function () {
    localStorage.clear();
   localStorage.setItem("payment", paymentMethod[index]);
});