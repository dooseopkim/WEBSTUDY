const removeAllContext = function(){
    let formElement = document.querySelector("#enroll-form");
    let title = formElement.querySelector("#title-input");
    let name = formElement.querySelector("#name-input");
    title.value="";
    name.value="";
    let sequenceBtns = formElement.querySelectorAll(".input__sequence");
    for(btn of sequenceBtns){
        btn.checked = false;
    }
    sequenceBtns[0].checked="checked";
}

const removeAllContextBtn = document.querySelector("#removeAllContext-btn");
removeAllContextBtn.addEventListener('click',removeAllContext);