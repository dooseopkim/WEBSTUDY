<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>TodoListInsert</title>
    <link rel="stylesheet" href="/resources/css/reset.css">
    <style>
    .center-row{
        width: 100%;
        text-align: center;
    }
    .center-row > h1{
        font-size: 2rem;
        line-height: 6rem;
    }
    .form__enrollment{
        text-align: left;
        padding-left: 30%;
        padding-right: 30%;
    }
    .form__enrollment > h2{
        font-size: 1.5rem;
        margin-bottom: 0.5rem;
        margin-top: 0.5rem;
        color: gray;
    }
    .form__enrollment > .input__title{
        width: 100%;
        line-height: 2rem;
        margin-bottom: 1.5rem;
        font-size: 1.5rem;
    }
    .form__enrollment > .input__name{
        width: 50%;
        line-height: 2.5rem;
        margin-bottom: 1.5rem;
        font-size: 1.5rem;
    }
    .button__radio{
        margin-bottom: 3rem;
    }
    .button__radio > label{
        margin-right: 4rem;
    }
    .button__radio > label > input{
        margin-right: 1rem;
    }
    .button__prev{
        background-color: white;
        border: 1px solid black;
        width : 20%;
        line-height: 2rem;
        margin-right: 30%;
        font-size: 1rem;
        text-decoration: underline;
    }
    .button__blue{
        background-color: skyblue;
        color: white;
        border: none;
        width: 20%;
        line-height: 2rem;
        margin-right:1%;
        font-size: 1rem;
    }
    </style>
</head>
<body>
    <main>
        <section class="center-row">
            <h1>할일 등록</h1>
            <form action="/todolist/todo" id="enroll-form" method="post" class="form__enrollment">
                <h2>어떤 일인가요?</h2>
                <input type="text" name="title" id="title" class="input__title" placeholder="swift 공부하기(24자까지)" pattern=".{1,24}" required>
                <h2>누가 할 일인가요?</h2>
                <input type="text" name="name" id="name" class="input__name" placeholder="홍길동" required>
                <h2>우선순위를 선택하세요</h2>
                <div class="button__radio">
                    <label><input class ="input__sequence" type="radio" name="sequence" value ="1" checked ="checked">1순위</label>
                    <label><input class ="input__sequence" type="radio" name="sequence" value ="2">2순위</label>
                    <label><input class ="input__sequence" type="radio" name="sequence" value ="3">3순위</label>
                </div>
                <input type="button" class="button__prev" value ="< 이전" onclick="history.back()">
                <input type="submit" class="button__blue" value ="제출">
                <input type="button" class="button__blue" value ="내용 지우기" onclick="removeAllContext()">
            </form>
        </section>
    </main>
</body>
<script>
    function removeAllContext(){
        let formElement = document.querySelector("#enroll-form");
        let title = formElement.querySelector("#title");
        let name = formElement.querySelector("#name");
        title.value="";
        name.value="";
        let sequenceBtns = formElement.querySelectorAll(".input__sequence");
        for(btn of sequenceBtns){
            btn.checked = false;
        }
        sequenceBtns[0].checked="checked";
    }
</script>
</html>