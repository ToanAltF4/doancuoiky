package servlet;

import dao.HotDealDAO;
import model.HotDeal;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/HotDealServlet")
public class HotDealServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String name = request.getParameter("deal_name");
            String description = request.getParameter("description");
            BigDecimal discount = new BigDecimal(request.getParameter("discount_amount"));
            String category = request.getParameter("category");
            String status = request.getParameter("status");
            Date expirationDate = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("expiration_date"));

            HotDeal hotDeal = new HotDeal(0, name, description, discount, category, status, expirationDate);
            
            boolean success;
            if (request.getParameter("action").equals("add")) {
                success = HotDealDAO.addHotDeal(hotDeal);
            } else {
                success = HotDealDAO.updateHotDeal(hotDeal);
            }

            if (success) {
                response.sendRedirect("dashboard.jsp?msg=success");
            } else {
                response.sendRedirect("hotdealForm.jsp?msg=error");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("hotdealForm.jsp?msg=error");
        }
    }
}
