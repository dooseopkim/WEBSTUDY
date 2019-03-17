/**
 * js 객체는 key & value로 이루어진 dictionary 자료구조.
 */

//객체 = JSON!!
//객체 선언

const defineObject = function(){
    let obj = {name : "jihwan",age : 29};
    console.log(obj["name"]);
    console.log(obj["age"]);
};

//객체의 추가 , 삭제
const newAndDeleteEx =function(){
    //추가
    const myFriend ={key : "value", key2 : "value"};
    console.log(myFriend);
    myFriend["name"] = "jihwan";
    console.log(myFriend["name"]);
    console.log(myFriend.name); //추가하는 방법은 . notation을 더 선호함.
    myFriend.age = 29;
    console.log(myFriend.age);

    //삭제
    delete myFriend.key;
    delete myFriend.key2;
    console.log(myFriend);
};

//객체의 탐색
const objSearchEx = function(){
    let obj = {"name":"gooditeas",age:29,data:[1,2,3,4,5]};
    for(value in obj){
        console.log(value);
    }
    console.log('\n');
    // keys + forEach
    Object.keys(obj).forEach(function(key){
        console.log(obj[key]);
    });
};
//

//defineObject();
//newAndDeleteEx();
//objSearchEx();

//실습 1

//실습 2