var productList;
const productBoxes = document.querySelectorAll(".lst_event_box");
const leftProductListBox = productBoxes[0];
const rightProductListBox = productBoxes[1];


const fetchProductList = function(categoryId, start){
    let requestURL = "api/products";
    let parameterStr = "?catagoryId=:categoryId&start=:start";
    if(categoryId !== ""){
        parameterStr = parameterStr.replace(":categoryId",categoryId)
                                   .replace(":start",start);
        requestURL += parameterStr;
    }
    const httpMethod = "GET";
    const httpRequest = new XMLHttpRequest();
    httpRequest.onload = function(){
        let reqStatus = httpRequest.status;

        let idx = 0;
        if(200<=reqStatus && reqStatus < 300){
            productList = JSON.parse(httpRequest.responseText);
            productList.items.forEach((elt)=>{
                let itemTplHTML = document.querySelector("#itemList").innerHTML;
                // id , description , content ,placeName
                itemTplHTML = itemTplHTML.replace('{{id}}',elt.productId)
                .replace('{{id}}',elt.productId)
                .replace('{{description}}',elt.productDescription)
                .replace('{{description}}',elt.productDescription)
                .replace('{{productImageUrl}}',elt.productImageUrl)
                .replace('{{content}}',elt.productContent)
                .replace('{{placeName}}',elt.placeName);
                if(idx%2 == 0){
                    leftProductListBox.innerHTML += itemTplHTML;
                }else{
                    rightProductListBox.innerHTML += itemTplHTML;
                }
                console.log(idx + " " +itemTplHTML);
                idx++;
            });
        }
    };
    httpRequest.open(httpMethod,requestURL);
    httpRequest.send();
};



