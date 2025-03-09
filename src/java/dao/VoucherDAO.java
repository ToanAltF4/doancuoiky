package dao;

import utils.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Voucher;

public class VoucherDAO {

    public static List<Voucher> searchVouchers(String category, String status) {
        List<Voucher> vouchers = new ArrayList<>();
        String sql = "SELECT * FROM tblVouchers WHERE category LIKE ? AND status LIKE ?";

        try (Connection conn = DatabaseConnection.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, "%" + category + "%");
            ps.setString(2, "%" + status + "%");

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    vouchers.add(new Voucher(
                            rs.getInt("voucher_id"),
                            rs.getString("voucher_code"),
                            rs.getString("description"),
                            rs.getBigDecimal("discount_percent"),
                            rs.getString("category"),
                            rs.getString("status")
                    ));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vouchers;
    }

    public static boolean addVoucher(Voucher voucher) {
        String sql = "INSERT INTO tblVouchers (voucher_code, description, discount_percent, category, status) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, voucher.getCode());
            ps.setString(2, voucher.getDescription());
            ps.setBigDecimal(3, voucher.getDiscount());
            ps.setString(4, voucher.getCategory());
            ps.setString(5, voucher.getStatus());

            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean updateVoucher(Voucher voucher) {
        String sql = "UPDATE tblVouchers SET description = ?, discount_percent = ?, category = ?, status = ? WHERE voucher_id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, voucher.getDescription());
            ps.setBigDecimal(2, voucher.getDiscount());
            ps.setString(3, voucher.getCategory());
            ps.setString(4, voucher.getStatus());
            ps.setInt(5, voucher.getId());

            int rowsUpdated = ps.executeUpdate();

            System.out.println("🔍 Số dòng bị ảnh hưởng: " + rowsUpdated);

            return rowsUpdated > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean updateVoucherStatus(int voucherId, String status) {
        String sql = "UPDATE tblVouchers SET status = ? WHERE voucher_id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, status);
            ps.setInt(2, voucherId);

            int rowsUpdated = ps.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static Voucher getVoucherById(int id) {
        String sql = "SELECT * FROM tblVouchers WHERE voucher_id = ?";
        Voucher voucher = null;

        try (Connection conn = DatabaseConnection.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    voucher = new Voucher(
                            rs.getInt("voucher_id"),
                            rs.getString("voucher_code"),
                            rs.getString("description"),
                            rs.getBigDecimal("discount_percent"),
                            rs.getString("category"),
                            rs.getString("status")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return voucher;
    }

    public static boolean deleteVoucher(int id) {
        String sql = "DELETE FROM tblVouchers WHERE voucher_id = ?";

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
