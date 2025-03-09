package servlet;

import dao.VoucherDAO;
import dao.HotDealDAO;
import model.Voucher;
import model.HotDeal;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String category = request.getParameter("category");
        String status = request.getParameter("status");

        List<Voucher> vouchers = VoucherDAO.searchVouchers(category, status);
        List<HotDeal> hotDeals = HotDealDAO.searchHotDeals(category, status);

        request.setAttribute("vouchers", vouchers);
        request.setAttribute("hotDeals", hotDeals);
        request.getRequestDispatcher("search.jsp").forward(request, response);
    }
}
