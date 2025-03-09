package dao;

import utils.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {
    public static String authenticateUser(String username, String password) {
        String role = null;
        String sql = "SELECT role FROM tblUsers WHERE username = ? AND password = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setString(1, username);
            ps.setString(2, password);
            
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    role = rs.getString("role");  // Lấy role nếu username/password đúng
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return role; // Trả về role nếu đúng, null nếu sai
    }
}
