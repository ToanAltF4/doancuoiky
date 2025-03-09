package servlet;

import dao.VoucherDAO;
import dao.HotDealDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ChangeStatusServlet")
public class ChangeStatusServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String type = request.getParameter("type"); // "voucher" hoặc "hotdeal"
            int id = Integer.parseInt(request.getParameter("id"));
            String status = request.getParameter("status"); // "Active" hoặc "Inactive"

            boolean success = false;

            if ("voucher".equals(type)) {
                success = VoucherDAO.updateVoucherStatus(id, status);
            } else if ("hotdeal".equals(type)) {
                success = HotDealDAO.updateHotDealStatus(id, status);
            }

            if (success) {
                response.sendRedirect("dashboard.jsp?msg=success");
            } else {
                response.sendRedirect("dashboard.jsp?msg=error");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("dashboard.jsp?msg=error");
        }
    }
}
