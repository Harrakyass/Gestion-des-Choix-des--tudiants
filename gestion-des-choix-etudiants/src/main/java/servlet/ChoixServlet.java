package servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.*;

public class ChoixServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int domaineId = Integer.parseInt(request.getParameter("domaineId"));
        HttpSession session = request.getSession();
        model.User user = (model.User) session.getAttribute("user");

        String sql = "INSERT INTO choix (user_id, domaine_id) VALUES (?, ?)";

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestion_choix", "root", "");
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, user.getId());
            stmt.setInt(2, domaineId);
            stmt.executeUpdate();

            response.getWriter().println("Choice submitted successfully!");
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("Error submitting choice.");
        }
    }
}
