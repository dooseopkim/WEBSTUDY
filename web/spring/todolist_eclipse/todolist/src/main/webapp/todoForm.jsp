<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>TodoListInsert</title>
    <link rel="stylesheet" href="./resources/css/reset.css">
    <link rel="stylesheet" href="./resources/css/todoForm.css">
    <style>


    </style>
</head>
<body>
    <main>
        <section class="row__center">
            <h1>할일 등록</h1>
            <form action="/todolist/todo" id="enroll-form" method="post" class="form__enrollment">
                <h2>어떤 일인가요?</h2>
                <input type="text" name="title" id="title-input" class="input__title" placeholder="swift 공부하기(24자까지)" pattern=".{1,24}" required>
                <h2>누가 할 일인가요?</h2>
                <input type="text" name="name" id="name-input" class="input__name" placeholder="홍길동" required>
                <h2>우선순위를 선택하세요</h2>
                <div class="button__radio">
                    <label><input class ="input__sequence" type="radio" name="sequence" value ="1" checked ="checked">1순위</label>
                    <label><input class ="input__sequence" type="radio" name="sequence" value ="2">2순위</label>
                    <label><input class ="input__sequence" type="radio" name="sequence" value ="3">3순위</label>
                </div>
                <input type="button" class="button__prev" value ="< 이전" onclick="history.back()">
                <input type="submit" class="button__blue" value ="제출">
                <input type="button" class="button__blue" id = "removeAllContext-btn" value ="내용 지우기">
            </form>
        </section>
    </main>
</body>
<script src="./resources/js/todoForm.js"></script>
</html>