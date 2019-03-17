const updateType = function(event,callback) {
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
            let completeUpdate = JSON.parse(this.responseText).completeUpdate;
            if(completeUpdate==='success'){
                callback(ul,li);
            }else{
                alert('TodoData insert error!');
            }
        } else {
            console.log('The request failed!');
        }
    };
    httpRequest.open('PUT', '/todolist/todo/type/'+todoId);
    httpRequest.setRequestHeader('Content-Type', 'application/json;charset=utf-8');
    httpRequest.send(JSON.stringify(data));
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

