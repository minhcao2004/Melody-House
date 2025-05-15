<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>Login</title>
        <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="css/login.css">
    </head>
    <body>
        <div class="container">
            <div class="login form">
                <header>Login</header>               
                <form action="login" method="post">
                    <input type="text" name="username" placeholder="Enter your username" required>
                    <input type="password" name="password" placeholder="Enter your password" required>
                    <a href="resetPassword.jsp">Forgot password?</a>
                    <input type="submit" class="button" value="Login">
                </form>
                <div class="signup">
                    <span>Don't have an account?
                        <a href="register.jsp">Register</a>
                    </span>
                </div>
            </div>
        </div>
    </body>
</html>