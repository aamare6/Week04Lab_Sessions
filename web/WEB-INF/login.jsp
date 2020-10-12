<%-- 
    Document   : MyLogin
    Created on : Oct 11, 2020, 6:23:39 PM
    Author     : 844817
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login </title>
    </head>
    <body>
        <h1>Login</h1>
        <form action="login" method="POST"> 
            <label>Username: </label>
            <input type="text" name="username" value="${username}">
            <br>
            <label>Password: </label>
            <input type="text" name="password" value="${password}"> 
            <input type="submit" name="logIn" value="Log in">
        </form>
            <div>${Message}</div>
            <div>${logOutMessage}</div>
    </body>
</html>
