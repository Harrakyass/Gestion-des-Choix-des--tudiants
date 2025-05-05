<%@ page contentType="text/html;charset=UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
    <div class="card">
        <div class="decoration"></div>
        <h2>User Login</h2>
        <form method="post" action="login">
            <label>Email:</label>
            <input type="email" name="email" required>

            <label>Password:</label>
            <input type="password" name="password" required>

            <input type="submit" value="Login">
        </form>

        <p class="link">Don't have an account? <a href="register.jsp">Register here</a></p>

        <% if (request.getParameter("error") != null) { %>
            <p class="error-message">Invalid login. Try again.</p>
        <% } %>
    </div>
</body>
</html>