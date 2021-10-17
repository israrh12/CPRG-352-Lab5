<%-- 
    Document   : home
    Created on : Oct 14, 2021, 4:06:35 PM
    Author     : owner-pc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
    </head>
    <body>
        <h1>Home Page</h1>
        <h4>Hey ${users.username}</h4>
        <a href="login?logoff">Log off</a>
    </body>
</html>
