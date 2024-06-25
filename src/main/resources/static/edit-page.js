console.log("initPreviewCard");
window.onload = function () {
    console.log("initPreviewCard");
    let itemName = document.getElementById("itemName");
    let itemDescription = document.getElementById("itemDescription");
    console.log(itemDescription);
    let itemPrice = document.getElementById("itemPrice");
    let cardNameShow = document.getElementById("item-name-show");
    let cardDescriptionShow = document.getElementById("item-description-show");
    console.log(cardDescriptionShow);
    let cardPriceShow = document.getElementById("item-price-show");
    cardNameShow.innerHTML = itemName.value;
    cardDescriptionShow.innerHTML = itemDescription.value;
    console.log(itemDescription.value);
    cardPriceShow.innerHTML = itemPrice.value;
};

let itemName = document.getElementById("itemName");
itemName.addEventListener("keyup", function () {
    let cardNameShow = document.getElementById("item-name-show");
    cardNameShow.innerHTML = itemName.value;
});

let itemDescription = document.getElementById("itemDescription");
itemDescription.addEventListener("keyup", function () {
    let cardDescriptionShow = document.getElementById("item-description-show");
    cardDescriptionShow.innerHTML = itemDescription.value;
});
let itemPrice = document.getElementById("itemPrice");
itemPrice.addEventListener("keyup", function () {
    let cardPriceShow = document.getElementById("item-price-show");
    cardPriceShow.innerHTML = itemPrice.value;
});

imgInput = document.getElementById("file");
imgInput.onchange = function () {
    const [file] = imgInput.files;
    if (file) {
        document.getElementById("imageShow").src = URL.createObjectURL(file);
    }
};
