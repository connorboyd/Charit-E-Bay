<html>
    <body>
        <h1>${message}</h1>
        <h2>Login Form</h2>
        <form action="/login" method="POST" name="User">
            Email: <br>
            <input type="text" name="email">
            <br>
            Password: <br>
            <input type="password" name="passwordHash">
            <br>
            <input type="submit" value="Submit">
        </form>
    </body>
</html>