package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.User;

public class UserDao {
    private final String JDBC_URL = "jdbc:mysql://localhost:3306/gestion_choix";
    private final String DB_USER = "root";  // replace if needed
    private final String DB_PASS = "";      // replace if needed

    private Connection connect() throws SQLException {
    	try {
    	    Class.forName("com.mysql.cj.jdbc.Driver");
    	} catch (ClassNotFoundException e) {
    	    e.printStackTrace();
    	}
        return DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);
    }

    public boolean registerUser(User user) {
        String sql = "INSERT INTO users (nom, email, password, role) VALUES (?, ?, ?, ?)";

        try (Connection conn = connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, user.getNom());
            stmt.setString(2, user.getEmail());
            stmt.setString(3, user.getPassword());
            stmt.setString(4, user.getRole());

            int rowsInserted = stmt.executeUpdate();
            System.out.println("User registered: " + rowsInserted);
            return rowsInserted > 0;

        } catch (SQLException e) {
            e.printStackTrace();  // This will print the exact DB error
            return false;
        }
    }


    public User loginUser(String email, String password) {
        String sql = "SELECT * FROM users WHERE email = ? AND password = ?";

        try (Connection conn = connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, email);
            stmt.setString(2, password);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setNom(rs.getString("nom"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                user.setRole(rs.getString("role"));
                return user;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
