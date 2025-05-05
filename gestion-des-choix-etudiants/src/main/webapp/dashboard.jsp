<%@ page import="java.util.*, model.*, dao.*" %>
<%@ page session="true" %>
<%
    model.User user = (model.User) session.getAttribute("user");
    if (user == null || !"etudiant".equals(user.getRole())) {
        response.sendRedirect("login.jsp");
        return;
    }

    DomaineDao dao = new DomaineDao();
    List<Domaine> domaines = dao.getAllDomaines();
%>
<!DOCTYPE html>
<html>
<head>
    <title>Dashboard</title>
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="css/dashboard.css">
</head>
<body>
    <div class="dashboard-container">
        <h2>Choisir un domaine</h2>
        <form method="post" action="choisir">
            <select name="domaineId">
                <% for (Domaine d : domaines) { %>
                    <option value="<%= d.getId() %>"><%= d.getNom() %></option>
                <% } %>
            </select>
            <input type="submit" value="Soumettre">
        </form>
    </div>
</body>
</html>
