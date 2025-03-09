package dao;

import utils.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.HotDeal;

public class HotDealDAO {

    public static List<HotDeal> searchHotDeals(String category, String status) {
        List<HotDeal> hotDeals = new ArrayList<>();
        String sql = "SELECT * FROM tblHotDeals WHERE category LIKE ? AND status LIKE ?";

        try (Connection conn = DatabaseConnection.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, "%" + category + "%");
            ps.setString(2, "%" + status + "%");

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    hotDeals.add(new HotDeal(
                            rs.getInt("deal_id"),
                            rs.getString("deal_name"),
                            rs.getString("description"),
                            rs.getBigDecimal("discount_amount"),
                            rs.getString("category"),
                            rs.getString("status"),
                            rs.getDate("expiration_date")
                    ));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return hotDeals;
    }

    public static boolean addHotDeal(HotDeal hotDeal) {
        String sql = "INSERT INTO tblHotDeals (deal_name, description, discount_amount, category, status, expiration_date) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, hotDeal.getName());
            ps.setString(2, hotDeal.getDescription());
            ps.setBigDecimal(3, hotDeal.getDiscount());
            ps.setString(4, hotDeal.getCategory());
            ps.setString(5, hotDeal.getStatus());
            ps.setDate(6, new java.sql.Date(hotDeal.getExpirationDate().getTime()));

            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean updateHotDeal(HotDeal hotDeal) {
        String sql = "UPDATE tblHotDeals SET deal_name = ?, description = ?, discount_amount = ?, category = ?, status = ?, expiration_date = ? WHERE deal_id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, hotDeal.getName());
            ps.setString(2, hotDeal.getDescription());
            ps.setBigDecimal(3, hotDeal.getDiscount());
            ps.setString(4, hotDeal.getCategory());
            ps.setString(5, hotDeal.getStatus());
            ps.setDate(6, new java.sql.Date(hotDeal.getExpirationDate().getTime()));
            ps.setInt(7, hotDeal.getId());

            int rowsUpdated = ps.executeUpdate();

            System.out.println("🔍 Số dòng bị ảnh hưởng: " + rowsUpdated);

            return rowsUpdated > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean updateHotDealStatus(int dealId, String status) {
        String sql = "UPDATE tblHotDeals SET status = ? WHERE deal_id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, status);
            ps.setInt(2, dealId);

            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static HotDeal getHotDealById(int id) {
        String sql = "SELECT * FROM tblHotDeals WHERE deal_id = ?";
        HotDeal hotDeal = null;

        try (Connection conn = DatabaseConnection.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    hotDeal = new HotDeal(
                            rs.getInt("deal_id"),
                            rs.getString("deal_name"),
                            rs.getString("description"),
                            rs.getBigDecimal("discount_amount"),
                            rs.getString("category"),
                            rs.getString("status"),
                            rs.getDate("expiration_date")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return hotDeal;
    }

    public static boolean deleteHotDeal(int id) {
        String sql = "DELETE FROM tblHotDeals WHERE deal_id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            int rowsDeleted = ps.executeUpdate();

            System.out.println("🔍 Số dòng bị xóa: " + rowsDeleted);
            return rowsDeleted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

}
