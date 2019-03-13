<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="UTF-8">
    <title>TodoListMain</title>
    
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/reset.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/main-style.css">
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

<script src="./resources/js/main-js.js"></script>
</html>