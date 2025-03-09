package servlet;

import dao.VoucherDAO;
import model.Voucher;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;

@WebServlet("/EditVoucherServlet")
public class EditVoucherServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            // Nhận dữ liệu từ form
            int id = Integer.parseInt(request.getParameter("id"));
            String description = request.getParameter("description");
            BigDecimal discount = new BigDecimal(request.getParameter("discount_percent"));
            String category = request.getParameter("category");
            String status = request.getParameter("status");

            System.out.println("📌 Đang cập nhật Voucher ID: " + id);
            System.out.println("📌 Description: " + description);
            System.out.println("📌 Discount: " + discount);
            System.out.println("📌 Category: " + category);
            System.out.println("📌 Status: " + status);

            // Tạo đối tượng Voucher
            Voucher voucher = new Voucher(id, "", description, discount, category, status);

            // Gửi dữ liệu cập nhật
            boolean success = VoucherDAO.updateVoucher(voucher);

            if (success) {
                System.out.println("✅ Cập nhật thành công!");
                response.sendRedirect("dashboard.jsp?msg=success");
            } else {
                System.out.println("❌ Cập nhật thất bại!");
                response.sendRedirect("editVoucher.jsp?id=" + id + "&msg=error");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("editVoucher.jsp?msg=error");
        }
    }
}
