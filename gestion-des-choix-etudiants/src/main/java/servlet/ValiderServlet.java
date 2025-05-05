package servlet;

import dao.AdminDao;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class ValiderServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int choixId = Integer.parseInt(request.getParameter("choixId"));
        String action = request.getParameter("action");  // "Valider" or "Rejeter"

        String status = action.equals("Valider") ? "valide" : "rejete";

        AdminDao dao = new AdminDao();
        dao.updateChoiceStatus(choixId, status);

        response.sendRedirect("admin.jsp");
    }
}
