<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="UTF-8">
    <title>TodoListMain</title>
    <link rel="stylesheet" href="resources/css/reset.css">


    <style>
        /*
html5doctor.com Reset Stylesheet
v1.6.1
Last Updated: 2010-09-17
Author: Richard Clark - http://richclarkdesign.com
Twitter: @rich_clark
*/

        html,
        body,
        div,
        span,
        object,
        iframe,
        h1,
        h2,
        h3,
        h4,
        h5,
        h6,
        p,
        blockquote,
        pre,
        abbr,
        address,
        cite,
        code,
        del,
        dfn,
        em,
        img,
        ins,
        kbd,
        q,
        samp,
        small,
        strong,
        sub,
        sup,
        var,
        b,
        i,
        dl,
        dt,
        dd,
        ol,
        ul,
        li,
        fieldset,
        form,
        label,
        legend,
        table,
        caption,
        tbody,
        tfoot,
        thead,
        tr,
        th,
        td,
        article,
        aside,
        canvas,
        details,
        figcaption,
        figure,
        footer,
        header,
        hgroup,
        menu,
        nav,
        section,
        summary,
        time,
        mark,
        audio,
        video {
            margin: 0;
            padding: 0;
            border: 0;
            outline: 0;
            font-size: 100%;
            vertical-align: baseline;
            background: transparent;
        }

        body {
            line-height: 1;
        }

        article,
        aside,
        details,
        figcaption,
        figure,
        footer,
        header,
        hgroup,
        menu,
        nav,
        section {
            display: block;
        }

        nav ul {
            list-style: none;
        }

        blockquote,
        q {
            quotes: none;
        }

        blockquote:before,
        blockquote:after,
        q:before,
        q:after {
            content: '';
            content: none;
        }

        a {
            margin: 0;
            padding: 0;
            font-size: 100%;
            vertical-align: baseline;
            background: transparent;
        }

        /* change colours to suit your needs */
        ins {
            background-color: #ff9;
            color: #000;
            text-decoration: none;
        }

        /* change colours to suit your needs */
        mark {
            background-color: #ff9;
            color: #000;
            font-style: italic;
            font-weight: bold;
        }

        del {
            text-decoration: line-through;
        }

        abbr[title],
        dfn[title] {
            border-bottom: 1px dotted;
            cursor: help;
        }

        table {
            border-collapse: collapse;
            border-spacing: 0;
        }

        /* change border colour to suit your needs */
        hr {
            display: block;
            height: 1px;
            border: 0;
            border-top: 1px solid #cccccc;
            margin: 1em 0;
            padding: 0;
        }

        input,
        select {
            vertical-align: middle;
        }
    </style>
    <style>
        header {
            position: relative;
        }

        header>h1 {
            font-size: 2rem;
            margin-top: 2rem;
            margin-left: 1rem;
            transform: skew(30deg, -30deg);
            display: inline-block;
            margin-left: 2rem;
            margin-top: 5rem;
        }

        header>button {
            line-height: 2rem;
            padding: 0.5rem 2rem 0.5rem 2rem;
            width: 15%;
            font-size: 1rem;
            position: absolute;
            top: 2rem;
            right: 1rem;
            background-color: burlywood;
            color: white;
        }

        .right__row {
            width: 100%;
            display: flex;
            justify-content: flex-end;
        }

        .section__list {
            width: 28%;
            margin-right: 1%;
            line-height: 3rem;
            list-style: none;
        }

        .h2__title {
            font-size: 2rem;
            background-color: brown;
            margin-bottom: 1rem;
            padding: 0.5rem 0 0.5rem 1.5rem;
            color: white;
        }

        .section__list>ul {
            list-style: none;
        }

        .section__list>ul>li {
            font-size: 1rem;
            margin-bottom: 1rem;
            padding: 0.5rem 0 0.5rem 1.5rem;
            background-color: orange;
        }

        .section__list>ul>li>h3 {
            font-size: 1.5rem;
        }

        .section__list>ul>li>p {
            display: inline-block;
            width: 85%;
        }

        .section__list>ul>li>button {
            display: inline-block;
            width: 10%;
            height: 2rem;
        }
    </style>
</head>

<body>
    <main>
        <header>
            <h1>
                나의 해야할 일들
            </h1>
            <button onclick="fowardAddform()">새로운 TODO 등록</button>
        </header>
        <article class="right__row">
            <section class="section__list">
                <h2 class="h2__title">TODO</h2>
                <ul id="todo-ul">
                    <c:forEach items="${todoList}" var="todo">
                        <li id="${todo.id}">
                            <h3>${todo.title}</h3>
                            <p>등록날짜 : ${todo.regDate} , ${todo.name}, 우선순위 ${todo.sequence}</p>
                            <button class="button__typechange" onclick="updateType(event,moveCard)">-></button>
                        </li>
                    </c:forEach>
                </ul>
            </section>
            <section class="section__list">
                <h2 class="h2__title">DOING</h2>
                <ul id="doing-ul">
                    <c:forEach items="${doingList}" var="todo">
                        <li id="${todo.id}">
                            <h3>${todo.title}</h3>
                            <p>등록날짜 : ${todo.regDate} , ${todo.name}, 우선순위 ${todo.sequence}</p><button
                                class="button__typechange" onclick="updateType(event,moveCard)">-></button>
                        </li>
                    </c:forEach>
                </ul>
            </section>
            <section class="section__list">
                <h2 class="h2__title">DONE</h2>
                <ul id="done-ul">
                    <c:forEach items="${doneList}" var="todo">
                        <li id="${todo.id}">
                            <h3>${todo.title}</h3>
                            <p>등록날짜 : ${todo.regDate} , ${todo.name}, 우선순위 ${todo.sequence}</p>
                        </li>
                    </c:forEach>
                </ul>
            </section>
        </article>
    </main>
</body>
<script>
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

</script>

</html>