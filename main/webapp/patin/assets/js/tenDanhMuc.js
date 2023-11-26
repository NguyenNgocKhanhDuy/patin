
function getCategory() {

    var xhttp = new XMLHttpRequest();
    xhttp.open("GET", "category-servlet", true)
    xhttp.send()
    xhttp.onreadystatechange = function () {
        if (xhttp.readyState = 4) {
           var tenDanhMuc = xhttp.responseText.split(",")
            tenDanhMuc = tenDanhMuc.filter(function (value) {
                return value.length > 0
            });
            var html = "";
            for (let i = 0; i < tenDanhMuc.length; i++) {
                html += ` <li><a href="./danhMuc.html">${tenDanhMuc[i]}</a></li>`
            }

            var list = document.querySelectorAll(".list-category");
            for (let i = 0; i < list.length; i++) {
                list[i].innerHTML = html;
            }
        }
    }
}

getCategory();
// function renderCategory() {
//     console.log(txt)
//     var html = "";
//     for (let i = 0; i < tenDanhMuc.length; i++) {
//         html += ` <li><a href="./danhMuc.html">${tenDanhMuc[i]}</a></li>`
//     }
//
//     var list = document.querySelectorAll(".list-category");
//     for (let i = 0; i < list.length; i++) {
//         list[i].innerHTML = html;
//     }
//
// }

// renderCategory();

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