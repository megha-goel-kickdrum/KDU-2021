const form = document.getElementById("addForm");
const itemList = document.getElementById("items");
const filter = document.getElementById("filter");
const formInput = document.getElementById("item");

form.addEventListener("submit", addItem);


// Add item
function addItem(e) {
  e.preventDefault();
  const itemValue = formInput.value ;
  const liElement = document.createElement("li");
  liElement.classList.add("list-group-item")
  var textNode = document.createTextNode(itemValue);
  liElement.addItem
  liElement.appendChild(textNode);
  itemList.appendChild(liElement);
}

form.addEventListener(onclick, removeItem)

// Remove item
function removeItem(e) {

    document.getElementById("ul").addEventListener("click",function(e) {
        var tgt = e.target;
        
          tgt.parentNode.removeChild(tgt); 
        
      });      

  //itemList.removeChild();
}

// Filter Items
function filterItems(e) {
 // TODO: write logic to filter the item in the list.

}
