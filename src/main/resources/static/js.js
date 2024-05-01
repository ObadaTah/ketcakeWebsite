// console.log("Edit Item Page");
// function itemNameOnChange() {
//     var itemName = document.getElementById("itemName").value;
//     document.getElementById("card-title").innerHTML = itemName;
// }

let itemName = document.getElementById("itemName");
itemName.addEventListener("change", function () {
    console.log(itemName.value);
    let cardNameShow = document.getElementById("item-name-show");
    cardNameShow.innerHTML = itemName.value;
});

let itemDescription = document.getElementById("itemDescription");
itemDescription.addEventListener("change", function () {
    console.log(itemDescription.value);
    let cardDescriptionShow = document.getElementById("item-description-show");
    cardDescriptionShow.innerHTML = itemDescription.value;
});
