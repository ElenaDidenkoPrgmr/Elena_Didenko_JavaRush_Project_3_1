<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <link href="${pageContext.request.contextPath}/css/main.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">

    <title>Welcome</title>
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
        <h2>Статистика:</h2>
        <p>здесь будет статистика квеста</p>
    </div>

    <div id="content" class="container">

        <h1>Знакомство</h1>
        <p>
            Здесь будет знакомство. Это должен быть Maven проект с использованием таких технологий: сервлеты, jsp, jstl.
        </p>

        <form action="${pageContext.request.contextPath}/logic">
            <div class="form-group">
                <label for="usr">Введите имя:</label>
                <input type="text" class="form-control" id="usr" name="username">
            </div>

            <button type="submit" class="btn btn-primary" >Начать квест</button>
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
