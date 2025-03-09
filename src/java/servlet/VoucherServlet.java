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

@WebServlet("/VoucherServlet")
public class VoucherServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String code = request.getParameter("voucher_code");
        String description = request.getParameter("description");
        BigDecimal discount = new BigDecimal(request.getParameter("discount_percent"));
        String category = request.getParameter("category");
        String status = request.getParameter("status");

        Voucher voucher = new Voucher(0, code, description, discount, category, status);
        
        boolean success;
        if (request.getParameter("action").equals("add")) {
            success = VoucherDAO.addVoucher(voucher);
        } else {
            success = VoucherDAO.updateVoucher(voucher);
        }

        if (success) {
            response.sendRedirect("dashboard.jsp?msg=success");
        } else {
            response.sendRedirect("voucherForm.jsp?msg=error");
        }
    }
}
