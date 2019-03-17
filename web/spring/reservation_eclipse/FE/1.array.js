//배열의 선언 [] , push
const defineArrEx = function(){
    let a = [1,2,3,4,5];
    a.push(6,7); //이렇게 한번에 2개의 원소를 추가할 수도 있음..
    console.log(a.length);
    a[1000]=1000;
    console.log(a[500]); //undefined
};
//배열의 메서드들 indexOf / join / concat
const usefulMethodList = function(){
    console.log([1,2,3,4].indexOf(3));
    console.log([1,2,3,4].indexOf(5)); //-1
    console.log([1,2,3,4].join(':'));
    console.log([1,2,3,4].concat(2,3,4));
};
//배열 탐색 forEach
const forEachEx = function(){
    let arr = [1,3,2,5,7,6];
    arr.forEach(function(value,index){
        console.log('index : '+ index +' value : '+value);
    });
};
//Map은 기존 배열을 이용해서, 새로운 배열을 만들 때 사용.
const mapEx = function(){
    let arr = ["apple","tomato","javscript","c++",'java'];
    let newArr = arr.map(function(value,index){
        return index + "번째 원소는 " + value +" 입니다.!";
    });
    newArr.forEach(function(value, index){
        console.log(value);
    });
};

//defineArrEx();
//usefulMethodList();
//forEachEx();
//mapEx();

/**
 *
 * References
 * [Array]
 * https://developer.mozilla.org/ko/docs/Web/JavaScript/Reference/Global_Objects/Array
 * https://www.w3schools.com/jsref/jsref_obj_array.asp
 * 
 * 
 */