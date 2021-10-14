<%-- 
    Document   : login
    Created on : Oct 14, 2021, 4:06:57 PM
    Author     : owner-pc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <h1>Login Page</h1>
        <form method="POST" action="login">
            <label>Username</label>
            <input type="text" name="user" value="${username}">
            <label>Password</label>
            <input type="password" name="pass" value="${password}">
            <input type="submit" value="Log on">
        </form>
            <p>${error}</p>
            <p>${logout}</p>
    </body>
</html>
