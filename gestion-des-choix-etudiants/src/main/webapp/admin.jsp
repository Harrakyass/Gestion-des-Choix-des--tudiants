<%@ page import="java.util.*, dao.AdminDao" %>
<%@ page session="true" %>
<%
    model.User user = (model.User) session.getAttribute("user");
    if (user == null || !"admin".equals(user.getRole())) {
        response.sendRedirect("login.jsp");
        return;
    }

    AdminDao dao = new AdminDao();
    List<Map<String, String>> choices = dao.getAllChoices();
%>
<!DOCTYPE html>
<html>
<head>
    <title>Admin Dashboard</title>
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="css/admin.css">
</head>
<body>
    <div class="admin-container">
        <h2>Liste des choix des étudiants</h2>
        <table class="admin-table">
            <tr>
                <th>Étudiant</th>
                <th>Email</th>
                <th>Domaine</th>
                <th>Statut</th>
                <th>Actions</th>
            </tr>
            <% for (Map<String, String> c : choices) { %>
                <tr>
                    <td><%= c.get("user_nom") %></td>
                    <td><%= c.get("email") %></td>
                    <td><%= c.get("domaine_nom") %></td>
                    <td>
                        <span class="status-badge 
                            <% if ("valide".equals(c.get("status"))) { %>status-valide<% }
                               else if ("rejete".equals(c.get("status"))) { %>status-rejete<% }
                               else { %>status-attente<% } %>">
                            <%= c.get("status") %>
                        </span>
                    </td>
                    <td>
                        <form method="post" action="valider" class="action-form">
                            <input type="hidden" name="choixId" value="<%= c.get("choix_id") %>">
                            <input type="submit" name="action" value="Valider">
                            <input type="submit" name="action" value="Rejeter">
                        </form>
                    </td>
                </tr>
            <% } %>
        </table>
    </div>
</body>
</html>
