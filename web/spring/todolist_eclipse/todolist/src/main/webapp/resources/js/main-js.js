/*
-> 버튼(class : type-convert-btn) 클릭 시 [리스너 필]
TodoTypeServlet으로 자신의 Id를 전송하여 type을 변경하고 (todo->doing->done) [aJax + DOM]
성공 시 , ui 에서 현재 자신을 제거하고 새롭게 업데이트된 결과를 append한다. [aJax + DOM]
*/
//aJax 먼저 할 것.
const updateType = function(event,callback) {
    /*
    1. /todo/update 에 PUT 요청으로 id를 보낸다.
    2. TodoTypeServlet에서 해당 요청을 받아서 update 한 뒤 completeUpdate란 결과값을 보낸다.
    3. 해당 결과값이 true 면 moveCard false면 alert
    */
    let btn = event.target;
    let li = btn.parentElement;
    let ul = li.parentElement;
    let typeName = ul.id;
    let todoId = li.id;
    let data = {};
    data.type = typeName;

    let httpRequest = new XMLHttpRequest();
    httpRequest.onload = function () {
        if (httpRequest.status >= 200 && httpRequest.status < 300) {
            // What do when the request is successful
            let completeUpdate = JSON.parse(this.responseText).completeUpdate;
            if(completeUpdate==='success'){
                console.log('completeUpdate : '+completeUpdate);
                callback(ul,li);
            }else{
                alert('fail!');
            }
        } else {
            // What do when the request fails
            console.log('The request failed!');
        }
    };
    httpRequest.open('PUT', '/todolist/todo/type/'+todoId);
    httpRequest.setRequestHeader('Content-Type', 'application/json;charset=utf-8');
    httpRequest.send(JSON.stringify(data));

    //httpRequest.send(encodeURI("id="+todoId+"&type="+typeName));
}
const moveCard = function(ul, li) {
    let typeName = ul.id;
    let nextTypeName = typeName === "todo-ul" ? "doing-ul" : "done-ul";
    if (nextTypeName === "done-ul") {
        let btnElement = li.querySelector(".button__typechange");
        li.removeChild(btnElement);
    }
    ul.removeChild(li);
    document.querySelector("#" + nextTypeName).append(li);
}

const fowardAddform = function(){
    window.location.href = '/todolist/addform';
}
