
function getCategory() {

    var xhttp = new XMLHttpRequest();
    xhttp.open("GET", "showCategory", true)
    xhttp.responseType = 'json'
    xhttp.send()
    xhttp.onreadystatechange = function () {
        if (xhttp.readyState = 4) {
            var c = {
            }
            c = xhttp.response
            show(c);
        }
    }
}

getCategory();

function show(c) {
    var html = '';
    for (let i = 0; i < c.length; i++) {
        html += "<li><a href=\"./danhMuc.html\">"+c[i].name+"</a></li>"
    }
    var list = document.querySelectorAll(".list-category");
    for (let i = 0; i < list.length; i++) {
        list[i].innerHTML = html;
    }
}

