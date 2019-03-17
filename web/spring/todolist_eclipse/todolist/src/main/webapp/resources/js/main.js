const updateType = function(btn,callback) {
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
    let nextTypeName = typeName === "todo" ? "doing" : "done";
    if (nextTypeName === "done") {
        let btnElement = li.querySelector(".btn__typechange");
        li.removeChild(btnElement);
    }
    ul.removeChild(li);
    document.querySelector("#" + nextTypeName).append(li);
}

const fowardAddform = function(){
    window.location.href = '/todolist/addform';
}



const addTodoBtn = document.querySelector("#addtodo-btn");
const typeChageBtnList = document.querySelectorAll(".btn__typechange");

addTodoBtn.addEventListener('click',fowardAddform,false);
typeChageBtnList.forEach((btn)=>{
	const updateTypeFunc = function(){updateType(btn,moveCard)};
	btn.addEventListener('click', updateTypeFunc, false);
});
