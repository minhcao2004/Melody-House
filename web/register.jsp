
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
                    <%
                    if (request.getAttribute("error")!= null){
                        String er=(String)request.getAttribute("error");
                    %>
                <h4 style="color: red"><%= er %></h3>
                    <%
                        }                 
                    %>
                    <form action="register" method="post" id="registerForm">
                        <input type="text" name="fullName" placeholder="Full name" required>
                        <input type="date" name="dob" required max="<%= java.time.LocalDate.now() %>">
                        <input type="email" name="email" placeholder="Email" required>

                        <div class="role-container">
                            <div class="role-option">
                                <input type="radio" id="teacher" name="role" value="2" required>
                                <label for="teacher">Teacher</label>
                            </div>
                            <div class="role-option">
                                <input type="radio" id="student" name="role" value="1" required>
                                <label for="student">Student</label>
                            </div>
                            <div class="role-option">
                                <input type="radio" id="parent" name="role" value="3" required>
                                <label for="parent">Parent</label>
                            </div>
                        </div>

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