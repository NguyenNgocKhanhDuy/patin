var imgMain = document.getElementById("img-main");
var listImg = document.getElementsByClassName("sub-img");
var imgModal = document.getElementById("imageInModal");
var modalImgClick = document.querySelector(".modal-img");
var closeModalImg = document.getElementById("closeModalImg");
var modalImgContainer = document.querySelector(".modal-img-container");
var nextImg = document.getElementById("nextImg");
var previousImg = document.getElementById("previousImg");

function changeImgMain() {
    for(var i = 0; i < listImg.length; i++) {
        listImg[i].addEventListener("click", function () {
           imgMain.src = this.src;
        });
    }
}

changeImgMain();

imgMain.addEventListener("click", function () {
    imgModal.src = this.src;
    modalImgClick.style.display = "flex";
});

closeModalImg.addEventListener("click", function () {
    modalImgClick.style.display = "none";
});

modalImgClick.addEventListener("click", function () {
    modalImgClick.style.display = "none";
});

modalImgContainer.addEventListener("click", function () {
   event.stopPropagation();
});

function chageImg() {
    var index = 0;
    for(var i = 0; i < listImg.length; i++) {
        if (imgModal.src == listImg[i].src){
            index = i;
        }
    }

    if (event.target.id == "nextImg") {
        if(index == listImg.length-1) {
            index = 0;
        }else {
            index++;
        }
        imgModal.src = listImg[index].src;
    }

    if (event.target.id == "previousImg") {
        if(index == 0) {
            index = listImg.length-1;
        }else {
            index--;
        }
        imgModal.src = listImg[index].src;
    }
}

nextImg.addEventListener("click", chageImg);
previousImg.addEventListener("click", chageImg);