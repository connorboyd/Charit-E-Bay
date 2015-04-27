<%--
  Created by IntelliJ IDEA.
  User: connorboyd
  Date: 4/26/15
  Time: 6:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>New Account - Charit-E-Bay</title>
    </head>
    <body>
        <form action="/register" method="POST" name="User">
            Email:    <input type="text"     name="email">            <br>
            Username: <input type="text"     name="userName">         <br>
            Password: <input type="password" name="passwordHash">     <br>
                      <input type="submit"   value="Submit">
        </form>
    </body>
</html>
