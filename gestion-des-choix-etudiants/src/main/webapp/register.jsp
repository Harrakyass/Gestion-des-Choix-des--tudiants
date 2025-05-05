<%@ page contentType="text/html;charset=UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <title>Register</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
    <div class="card">
        <div class="decoration"></div>
        <h2>User Registration</h2>
        <form method="post" action="register">
            <label>Nom:</label>
            <input type="text" name="nom" required>

            <label>Email:</label>
            <input type="email" name="email" required>

            <label>Password:</label>
            <input type="password" name="password" required>

            <input type="submit" value="Register">
        </form>

        <p class="link">Already have an account? <a href="login.jsp">Login here</a></p>

        <% if (request.getParameter("error") != null) { %>
            <p class="error-message">Registration failed. Try again.</p>
        <% } %>
    </div>
</body>
</html>