<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Quest</title>
    <link href="${pageContext.request.contextPath}/css/main.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">

</head>
<body id="body">
<div id="container">

    <div>
        <img src="${pageContext.request.contextPath}/img/header.png" alt="Header image" width=100% height="304">
    </div>
    <div id="header">

        <h2>Добро пожаловать в квест!</h2>
    </div>

    <div id="navigation">
        <h5>Блок навигации</h5>
    </div>

    <div id="sidebar">
        <%@include file="statistics.jsp" %>
    </div>

    <div id="content" class="p-4">
        <h2>Вопрос: ${currentQuestion.getText()}</h2>

        <form action="${pageContext.request.contextPath}/logic">

            <c:forEach var="answer" items="${currentQuestion.getAnswers()}">
                <div class="form-check">
                    <input class="form-check-input" type="radio" name="requestedQuestion" id="answers"
                           value="${answer.getNextQuestionId()}">
                    <label class="form-check-label" for="answers">${answer.getText()}</label>
                </div>
            </c:forEach>
            <input class="btn btn-primary" type="submit" value="Ответить">
        </form>
    </div>

    <div id="clear">

    </div>

    <div id="footer">
        <h2>footer (низ сайта)</h2>
    </div>
</div>
</body>
</html>
