<%-- 
    Document   : agecalculator
    Created on : Sep 25, 2020, 11:15:47 PM
    Author     : 710429
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Age Calculator</title>
    </head>
    <body>
        <h1>Age Calculator</h1>
        <form method="post" action="age">
            Enter your age: <input type="text" name="age"><br>
            <input type="submit" value="Age Next birthday"><br>
            ${message}<br>
            <a href="arithmetic">Arithmetic Calculator</a>
        </form>
    </body>
</html>
