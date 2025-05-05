package dao;

import model.User;
import model.Domaine;

import java.sql.*;
import java.util.*;

public class AdminDao {
    private final String JDBC_URL = "jdbc:mysql://localhost:3306/gestion_choix";
    private final String DB_USER = "root";
    private final String DB_PASS = "";

    private Connection connect() throws SQLException {
        return DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);
    }

    public List<Map<String, String>> getAllChoices() {
        List<Map<String, String>> list = new ArrayList<>();
        String sql = "SELECT c.id, u.nom AS user_nom, u.email, d.nom AS domaine_nom, c.status " +
                     "FROM choix c " +
                     "JOIN users u ON c.user_id = u.id " +
                     "JOIN domaines d ON c.domaine_id = d.id";

        try (Connection conn = connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Map<String, String> entry = new HashMap<>();
                entry.put("choix_id", String.valueOf(rs.getInt("id")));
                entry.put("user_nom", rs.getString("user_nom"));
                entry.put("email", rs.getString("email"));
                entry.put("domaine_nom", rs.getString("domaine_nom"));
                entry.put("status", rs.getString("status"));
                list.add(entry);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    public void updateChoiceStatus(int choixId, String status) {
        String sql = "UPDATE choix SET status = ? WHERE id = ?";

        try (Connection conn = connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, status);
            stmt.setInt(2, choixId);
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
