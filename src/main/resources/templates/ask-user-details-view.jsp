<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="UTF-8">
    <title>User Details Form</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            padding: 20px;
        }
        form {
            max-width: 400px;
            margin: 0 auto;
        }
        input[type="text"] {
            width: 100%;
            padding: 10px;
            margin: 5px 0 15px 0;
            display: inline-block;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
        }
        input[type="submit"] {
            background-color: #4CAF50;
            color: white;
            padding: 14px 20px;
            margin: 8px 0;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            width: 100%;
        }
        input[type="submit"]:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>

<h2>User Details Form</h2>

<form action="/showDetails" method="get" th:object="${user}">
    Name <input type="text" th:field="*{name}"/>
    <br><br>
    Last Name <input type="text" th:field="*{lastName}"/>
    <br><br>
    Department <input type="text" th:field="*{department}"/>
    <br><br>
    Salary <input type="text" th:field="*{salary}"/>
    <br><br>
    <input type="submit" value="OK"/>
</form>

</body>
</html>