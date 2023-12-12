var showBox = document.querySelector("#category-search .search ul")
var searchInput = document.querySelector("#category-search .search input");
var body = document.querySelector("body")
var btnSearch = document.getElementById("searchBtn");

function renderValue(arrayValue) {
    var html = "";
    var maxLength = 0;
    if (arrayValue.length > 3) {
        maxLength = 3;
    }else {
        maxLength = arrayValue.length;
    }
    for (let i = 0; i < maxLength; i++) {
        html += `<li>
                    <a href="./ct_sanPham.html">
                        <span class="item">
                            <img src="${arrayValue[i].images[0]}" alt="">
                            <p class="name">${arrayValue[i].name}</p>
                        </span>
                    </a>
                 </li>`;
    }
    showBox.innerHTML = html;
    showBox.style.boxShadow = "0px 4px 6px 2px #ccc";
}


function search() {
    var xhttp = new XMLHttpRequest();
    xhttp.open("GET", "search?search="+searchInput.value, true);
    xhttp.responseType = 'json'
    xhttp.send();
    xhttp.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
            if (searchInput.value.length == 0) {
                showBox.innerHTML = "";
            }else {
                var c= {}
                c = xhttp.response
                addInSearchHtml(c)
            }
        }
    };
}

function addInSearchHtml(c) {
    var html = "";
    for (let i = 0; i < c.length; i++) {
        html += `<li>  
                     <a href="">  
                         <span class="item"> 
                             <img src="${c[i].img}" alt=""/>
                             <p class="name">${c[i].name}</p>
                         </span> 
                     </a> 
                 </li>`
    }
    showBox.innerHTML = html;
}

btnSearch.addEventListener("click", search);
searchInput.addEventListener("input", search);
searchInput.addEventListener("click", search);
body.addEventListener("click", function (){
    showBox.innerHTML = ""
})

searchInput.addEventListener("click", function () {
    event.stopPropagation();
});

showBox.addEventListener("click", function () {
    event.stopPropagation();
});

