package servlet;

import dao.VoucherDAO;
import dao.HotDealDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String type = request.getParameter("type"); // "voucher" hoặc "hotdeal"
            int id = Integer.parseInt(request.getParameter("id"));

            boolean success = false;
            if ("voucher".equals(type)) {
                success = VoucherDAO.deleteVoucher(id);
            } else if ("hotdeal".equals(type)) {
                success = HotDealDAO.deleteHotDeal(id);
            }

            if (success) {
                response.sendRedirect("dashboard.jsp?msg=deleted");
            } else {
                response.sendRedirect("dashboard.jsp?msg=delete_error");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("dashboard.jsp?msg=delete_error");
        }
    }
}
