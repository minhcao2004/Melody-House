
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>Register</title>
        <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="css/register.css">
    </head>
    <body>
        <div class="container">
            <div class="register form">
                <header>Register</header>
                <%-- Hiển thị thông báo lỗi nếu có --%>
                <% if (request.getAttribute("errorMessage") != null) { %>
                    <div class="error-message">
                        <%= request.getAttribute("errorMessage") %>
                    </div>
                <% } %>
                <%-- Hiển thị thông báo thành công nếu có --%>
                <% if (request.getAttribute("successMessage") != null) { %>
                    <div class="success-message">
                        <%= request.getAttribute("successMessage") %>
                    </div>
                <% } %>
                <form action="register" method="post" id="registerForm">
                    <input type="text" name="fullName" placeholder="Full name" required>
                    <input type="text" name="phone" placeholder="Phone number" required>
                    <input type="email" name="email" placeholder="Email" required>
                    <input type="text" name="username" placeholder="Username" required>
                    <input type="password" name="password" placeholder="Password" required>
                    <input type="password" name="confirmPassword" placeholder="Confirm password" required>
                    <input type="submit" class="button" value="Register">
                </form>
                <div class="login-link">
                    <span>Already have an account?
                        <a href="login.jsp">Login</a>
                    </span>
                </div>
            </div>
        </div>
        <script src="js/register.js"></script>
    </body>
</html>