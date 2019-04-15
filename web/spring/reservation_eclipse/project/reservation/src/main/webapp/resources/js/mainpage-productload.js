
const productBoxes = document.querySelectorAll(".lst_event_box");
const leftProductListBox = productBoxes[0];
const rightProductListBox = productBoxes[1];

const PRODUCTS_PER_CLICK = 4;

var productMaxCount = -1;
var exposedProductCount = 0;
var productItemsInfo;



const makeProductItemHTML = function(elt){
    let itemTemplate = document.querySelector("#itemList").innerHTML;
    itemTemplate =  itemTemplate.replace('{{id}}',elt.productId)
                                .replace('{{id}}',elt.productId)
                                .replace('{{description}}',elt.productDescription)
                                .replace('{{description}}',elt.productDescription)
                                .replace('{{productImageUrl}}',elt.productImageUrl)
                                .replace('{{content}}',elt.productContent)
                                .replace('{{placeName}}',elt.placeName);
    return itemTemplate;
};

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
            let productInfo = JSON.parse(httpRequest.responseText);
            productMaxCount = productInfo.totalCount;
            productItemsInfo = productInfo.items;

            for(let idx = 0; idx < PRODUCTS_PER_CLICK; idx++){
                let itemTplHTML = makeProductItemHTML(productItemsInfo[idx]);
                if(idx%2 == 0){
                    leftProductListBox.innerHTML += itemTplHTML;
                }else{
                    rightProductListBox.innerHTML += itemTplHTML;
                }
            }
            exposedProductCount += PRODUCTS_PER_CLICK;
        }
    };
    httpRequest.open(httpMethod,requestURL);
    httpRequest.send();
};

const moreViewEvent = function(){
    // exposedProductCount ~ exposedProductCount+4 까지 추가로 노출.
    // 만약 productMaxCount와 인덱스가 같아질 경우 더보기 버튼 삭제.
    let itemIdx;
    for(itemIdx = exposedProductCount; itemIdx < exposedProductCount+4 && itemIdx < productMaxCount; itemIdx++){
        let itemTplHTML = makeProductItemHTML(productItemsInfo[itemIdx]);
        if(itemIdx%2 == 0){
            leftProductListBox.innerHTML += itemTplHTML;
        }else{
            rightProductListBox.innerHTML += itemTplHTML;
        }
    }
    if(itemIdx == productMaxCount){
        //remove 더보기 버튼
        document.querySelector(".more").remove();
    }
    exposedProductCount += PRODUCTS_PER_CLICK;
}

fetchProductList("",0);
document.querySelector(".more").addEventListener('click',moreViewEvent);

