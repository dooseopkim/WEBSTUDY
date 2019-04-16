const categoryTable = {'전체리스트' : '','전시':1,'뮤지컬':'2','콘서트':3,'클래식':4,'연극':5};
let paramCategoryId = 1;
let paramStart = 0;
let exposedProductCount = 0;
let productTotalCount = 0;
let exposureUnit = 4;

const getProductData = function(categoryId,start){
    let requestURL = "api/products";
    if(categoryId ===""){
        requestURL = requestURL.concat("?start=")
                               .concat(start);
    }else{
        requestURL = requestURL.concat("?categoryId=")
                               .concat(categoryId)
                               .concat("&start=")
                               .concat(start);
    }

    const httpMethod = 'GET';
    const httpRequest = new XMLHttpRequest();
    httpRequest.onload = function(){
        let reqStatus = httpRequest.status;
        if(200<=reqStatus && reqStatus < 300){
            let productData = JSON.parse(httpRequest.responseText);
            let totalCount = productData.totalCount;
            let items = productData.items;
            updateTotalCount(totalCount);
            appendProductData(items);
            exposureUnit+=4;
        }
    };
    httpRequest.open(httpMethod,requestURL);
    httpRequest.send();
};

const updateTotalCount = function(totalCount){
    productTotalCount = totalCount;
    let prdTotalCountElt = document.querySelector("#prd-total-count");
    prdTotalCountElt.innerHTML = (totalCount+"개");
};

const appendProductData = function(items){
    let prdEventBox = document.querySelectorAll(".lst_event_box");
    let leftBox = prdEventBox[0];
    let rightBox = prdEventBox[1];
    items.forEach(function(elt, idx){
        let itemHTML = makeProductItemHTML(elt);
        if(idx%2==0){
            leftBox.innerHTML+=itemHTML;
            exposedProductCount++;
        }else{
            rightBox.innerHTML+=itemHTML;
            exposedProductCount++;
        }
        if(exposedProductCount == productTotalCount){
            hideMoreButton();
        }
    });
};

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

const showMoreButton = function(){
    let moreBtn = document.querySelector("#more-btn");
    moreBtn.style.visibility = 'visible';
}

const hideMoreButton = function(){
    let moreBtn = document.querySelector("#more-btn");
    moreBtn.style.visibility = 'hidden';
};







const moreBtnClick = function(){
    getProductData();
    showProductData();
};



// const tabMenuClick = function(categoryName){
//     let categoryId = categoryTable(categoryName);
//     start = 0;
//     exposedProductCount = 0;
//     activeTabMenu();
//     getProductData(categoryId,start);
// };
// const activeTabMenu = function(){

// }