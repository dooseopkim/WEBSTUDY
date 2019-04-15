var index = 0,
currTransl = [],
translationComplete = true,
moveOffset = 414,
width = 414,
activedTabIdx = 0;


const slideItemTemplate = "<img class='product_item' src='{productImageUrl}'></img>";

//탭 메뉴 클릭 시 .active class 추가. 기존에 있던 active 클래스 삭제

const next =  function(){

    var amount = document.querySelectorAll("#slide-container > ul > li").length;
    var moveToLastIndex = (index) % amount;
    index++;

    for (let i = 0; i < amount; i++) {
        let slide = document.querySelectorAll("#slide-container > ul > li")[i];
        slide.style.opacity = '1';
        currTransl[i] -= moveOffset;
        slide.style.transform = 'translateX(' + (currTransl[i]) + 'px)';
    }
    
    var outerSlide = document.querySelectorAll("#slide-container > ul > li")[moveToLastIndex];
    outerSlide.style.transform = 'translateX(' + (currTransl[moveToLastIndex] + (moveOffset * amount)) + 'px)';
    outerSlide.style.opacity = '0';
    currTransl[moveToLastIndex] = currTransl[moveToLastIndex] + moveOffset * (amount);

    
}

const toggleActive = function(idx){
    let itemList = document.querySelectorAll('.event_tab_lst > .item > a');
    itemList[activedTabIdx].classList.remove('active');
    itemList[idx].classList.add('active');
    activedTabIdx = idx;
}

const loadPromotionList = function(){
  // requestUrl : /reservation/api/promotions
  const httpRequest = new XMLHttpRequest();
  httpRequest.onload = function(){
      let reqStatus = httpRequest.status;
      if(200 <= reqStatus  && reqStatus < 300){
          let promotionData = JSON.parse(httpRequest.responseText);
          let promotionItemList = promotionData.items;
          document.querySelector('#slide-container > ul').style.width = (promotionItemList.length * moveOffset) + 'px';
          for(let i = 0; i<promotionItemList.length;i++){
            let imgTpl = "<img src = '${productImageUrl}'>";
            imgTpl = imgTpl.replace('${productImageUrl}',promotionItemList[i].productImageUrl);
            let elt = document.createElement('LI');
            elt.innerHTML = imgTpl;
            document.querySelector("#slide-container > ul").appendChild(elt);
          }
          amount = document.querySelectorAll("#slide-container > ul > li").length;
   
            moveOffset = width;
            for (let i = 0; i < amount; i++) {
                currTransl[i] = -moveOffset;
            }
            console.log(currTransl);
            //next();
            setInterval(next,1000);
      }
  };
  httpRequest.open('GET', 'api/promotions');
  httpRequest.send();
};


// const fetchProductList = function(categoryId, start){
//     let requestURL = "api/products";
//     let parameterStr = "?catagoryId=:categoryId&start=:start";
//     if(categoryId !== ""){
//         parameterStr = parameterStr.replace(":categoryId",categoryId)
//                                    .replace(":start",start);
//         requestURL += parameterStr;
//     }

//     const httpMethod = "GET";
//     const httpRequest = new XMLHttpRequest();
//     httpRequest.onload = function(){
//         let reqStatus = httpRequest.status;
//         if(200<=reqStatus && reqStatus < 300){
//             let productList = JSON.parse(httpRequest.responseText);
//             console.table(productList);
//         }
//     };
//     httpRequest.open(httpMethod,requestURL);
//     httpRequest.send();
// };






document.addEventListener("DOMContentLoaded", function (event) {
    loadPromotionList();
    // fetchProductList("",0);



    const eventTabLiList = document.querySelectorAll(".event_tab_lst > li");

    for(let i=0; i<eventTabLiList.length; i++){
        const toggleActiveAtIdx = function(){
            toggleActive(i);
        };
        eventTabLiList[i].addEventListener('click',toggleActiveAtIdx);
    }


});



