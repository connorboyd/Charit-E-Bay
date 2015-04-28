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
