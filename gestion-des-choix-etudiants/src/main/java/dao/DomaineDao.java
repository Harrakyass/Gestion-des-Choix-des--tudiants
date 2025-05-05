package dao;

import model.Domaine;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DomaineDao {
    private final String JDBC_URL = "jdbc:mysql://localhost:3306/gestion_choix";
    private final String DB_USER = "root";
    private final String DB_PASS = "";

    private Connection connect() throws SQLException {
        return DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);
    }

    public List<Domaine> getAllDomaines() {
        List<Domaine> list = new ArrayList<>();
        String sql = "SELECT * FROM domaines";

        try (Connection conn = connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                list.add(new Domaine(rs.getInt("id"), rs.getString("nom")));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }
}
