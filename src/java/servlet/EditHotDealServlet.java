package servlet;

import dao.HotDealDAO;
import model.HotDeal;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/EditHotDealServlet")
public class EditHotDealServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            String name = request.getParameter("deal_name");
            String description = request.getParameter("description");
            BigDecimal discount = new BigDecimal(request.getParameter("discount_amount"));
            String category = request.getParameter("category");
            String status = request.getParameter("status");
            Date expirationDate = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("expiration_date"));

            System.out.println("📌 Đang cập nhật Hot Deal ID: " + id);
            System.out.println("📌 Name: " + name);
            System.out.println("📌 Description: " + description);
            System.out.println("📌 Discount: " + discount);
            System.out.println("📌 Category: " + category);
            System.out.println("📌 Status: " + status);
            System.out.println("📌 Expiration Date: " + expirationDate);

            HotDeal hotDeal = new HotDeal(id, name, description, discount, category, status, expirationDate);

            boolean success = HotDealDAO.updateHotDeal(hotDeal);

            if (success) {
                System.out.println("✅ Cập nhật thành công!");
                response.sendRedirect("dashboard.jsp?msg=success");
            } else {
                System.out.println("❌ Cập nhật thất bại!");
                response.sendRedirect("editHotDeal.jsp?id=" + id + "&msg=error");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("editHotDeal.jsp?msg=error");
        }
    }
}
