
var tenDanhMuc = ["1", "2"]
function renderCategory() {
    var html = "";
    for (let i = 0; i < tenDanhMuc.length; i++) {
        html += ` <li><a href="./danhMuc.html">${tenDanhMuc[i]}</a></li>`
    }

    var list = document.querySelectorAll(".list-category");
    for (let i = 0; i < list.length; i++) {
        list[i].innerHTML = html;
    }

}

renderCategory();

function showDanhMuc() {
    var t = document.querySelectorAll(".list-category li a");
    for (let i = 0; i < t.length; i++) {
        t[i].addEventListener("click", function () {
            var danhMuc = t[i].textContent;
            localStorage.clear();
            localStorage.setItem("danh muc", danhMuc);
        });
    }
}
showDanhMuc();