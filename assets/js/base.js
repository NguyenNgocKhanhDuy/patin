var category = document.getElementById("categoryAll");
var listCategory = document.getElementById("list-cate");

// ẩn hiện danh mục
category.addEventListener("click", function (){
    if(listCategory.style.opacity == ""){
        listCategory.style.height = "fit-content";
        listCategory.style.opacity = "1";
    }else {
        listCategory.style.height = "0";
        listCategory.style.opacity = "";
    }
});