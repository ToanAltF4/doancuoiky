package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.http.HttpSession;
import java.util.List;
import model.Voucher;
import model.HotDeal;
import dao.VoucherDAO;
import dao.HotDealDAO;

public final class dashboard_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"vi\">\n");
      out.write("    <head>\n");
      out.write("        <meta charset=\"UTF-8\">\n");
      out.write("        <title>Dashboard</title>\n");
      out.write("        <style>\n");
      out.write("            body {\n");
      out.write("                font-family: 'Arial', sans-serif;\n");
      out.write("                background-color: orangered;\n");
      out.write("                margin: 0;\n");
      out.write("                padding: 20px;\n");
      out.write("            }\n");
      out.write("            .container {\n");
      out.write("                max-width: 1200px;\n");
      out.write("                margin: 0 auto;\n");
      out.write("                background: #fff;\n");
      out.write("                padding: 20px;\n");
      out.write("                border-radius: 8px;\n");
      out.write("                box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);\n");
      out.write("                animation: fadeIn 1s ease-in-out;\n");
      out.write("            }\n");
      out.write("            @keyframes fadeIn {\n");
      out.write("                from { opacity: 0; transform: translateY(-20px); }\n");
      out.write("                to { opacity: 1; transform: translateY(0); }\n");
      out.write("            }\n");
      out.write("            h2, h3 {\n");
      out.write("                color: #333;\n");
      out.write("            }\n");
      out.write("            .logout-btn {\n");
      out.write("                display: inline-block;\n");
      out.write("                padding: 10px 15px;\n");
      out.write("                background-color: #ff4d4d;\n");
      out.write("                color: white;\n");
      out.write("                text-decoration: none;\n");
      out.write("                border-radius: 5px;\n");
      out.write("                float: right;\n");
      out.write("                transition: background-color 0.3s ease;\n");
      out.write("            }\n");
      out.write("            .logout-btn:hover {\n");
      out.write("                background-color: #cc0000;\n");
      out.write("                transform: scale(1.05);\n");
      out.write("            }\n");
      out.write("            .add-btn {\n");
      out.write("                display: inline-block;\n");
      out.write("                padding: 10px 15px;\n");
      out.write("                background-color: #28a745;\n");
      out.write("                color: white;\n");
      out.write("                text-decoration: none;\n");
      out.write("                border-radius: 5px;\n");
      out.write("                margin-bottom: 20px;\n");
      out.write("                transition: background-color 0.3s ease, transform 0.3s ease;\n");
      out.write("            }\n");
      out.write("            .add-btn:hover {\n");
      out.write("                background-color: #218838;\n");
      out.write("                transform: scale(1.05);\n");
      out.write("            }\n");
      out.write("            table {\n");
      out.write("                width: 100%;\n");
      out.write("                border-collapse: collapse;\n");
      out.write("                margin-bottom: 20px;\n");
      out.write("                animation: slideIn 1s ease-in-out;\n");
      out.write("            }\n");
      out.write("            @keyframes slideIn {\n");
      out.write("                from { opacity: 0; transform: translateX(-20px); }\n");
      out.write("                to { opacity: 1; transform: translateX(0); }\n");
      out.write("            }\n");
      out.write("            th, td {\n");
      out.write("                border: 1px solid #ddd;\n");
      out.write("                padding: 12px;\n");
      out.write("                text-align: left;\n");
      out.write("            }\n");
      out.write("            th {\n");
      out.write("                background-color: #f8f9fa;\n");
      out.write("                color: #333;\n");
      out.write("            }\n");
      out.write("            tr:nth-child(even) {\n");
      out.write("                background-color: #f9f9f9;\n");
      out.write("            }\n");
      out.write("            tr:hover {\n");
      out.write("                background-color: #f1f1f1;\n");
      out.write("                transform: scale(1.02);\n");
      out.write("                transition: transform 0.3s ease;\n");
      out.write("            }\n");
      out.write("            .edit-btn {\n");
      out.write("                background-color: #007bff;\n");
      out.write("                color: white;\n");
      out.write("                padding: 5px 10px;\n");
      out.write("                text-decoration: none;\n");
      out.write("                border-radius: 5px;\n");
      out.write("                transition: background-color 0.3s ease, transform 0.3s ease;\n");
      out.write("            }\n");
      out.write("            .edit-btn:hover {\n");
      out.write("                background-color: #0056b3;\n");
      out.write("                transform: scale(1.1);\n");
      out.write("            }\n");
      out.write("            .delete-btn {\n");
      out.write("                background-color: #dc3545;\n");
      out.write("                color: white;\n");
      out.write("                padding: 5px 10px;\n");
      out.write("                text-decoration: none;\n");
      out.write("                border-radius: 5px;\n");
      out.write("                border: none;\n");
      out.write("                cursor: pointer;\n");
      out.write("                transition: background-color 0.3s ease, transform 0.3s ease;\n");
      out.write("            }\n");
      out.write("            .delete-btn:hover {\n");
      out.write("                background-color: #c82333;\n");
      out.write("                transform: scale(1.1);\n");
      out.write("            }\n");
      out.write("            .search-form {\n");
      out.write("                margin-bottom: 20px;\n");
      out.write("                animation: slideIn 1s ease-in-out;\n");
      out.write("            }\n");
      out.write("            .search-form label {\n");
      out.write("                margin-right: 10px;\n");
      out.write("            }\n");
      out.write("            .search-form input[type=\"text\"], .search-form select {\n");
      out.write("                padding: 8px;\n");
      out.write("                border-radius: 5px;\n");
      out.write("                border: 1px solid #ddd;\n");
      out.write("                margin-right: 10px;\n");
      out.write("                transition: border-color 0.3s ease;\n");
      out.write("            }\n");
      out.write("            .search-form input[type=\"text\"]:focus, .search-form select:focus {\n");
      out.write("                border-color: #007bff;\n");
      out.write("                outline: none;\n");
      out.write("            }\n");
      out.write("            .search-form input[type=\"submit\"] {\n");
      out.write("                padding: 8px 15px;\n");
      out.write("                background-color: #007bff;\n");
      out.write("                color: white;\n");
      out.write("                border: none;\n");
      out.write("                border-radius: 5px;\n");
      out.write("                cursor: pointer;\n");
      out.write("                transition: background-color 0.3s ease, transform 0.3s ease;\n");
      out.write("            }\n");
      out.write("            .search-form input[type=\"submit\"]:hover {\n");
      out.write("                background-color: #0056b3;\n");
      out.write("                transform: scale(1.05);\n");
      out.write("            }\n");
      out.write("            .status-form {\n");
      out.write("                display: inline-block;\n");
      out.write("            }\n");
      out.write("            .status-form select {\n");
      out.write("                padding: 5px;\n");
      out.write("                border-radius: 5px;\n");
      out.write("                border: 1px solid #ddd;\n");
      out.write("                transition: border-color 0.3s ease;\n");
      out.write("            }\n");
      out.write("            .status-form select:focus {\n");
      out.write("                border-color: #007bff;\n");
      out.write("                outline: none;\n");
      out.write("            }\n");
      out.write("            .status-form input[type=\"submit\"] {\n");
      out.write("                padding: 5px 10px;\n");
      out.write("                background-color: #28a745;\n");
      out.write("                color: white;\n");
      out.write("                border: none;\n");
      out.write("                border-radius: 5px;\n");
      out.write("                cursor: pointer;\n");
      out.write("                transition: background-color 0.3s ease, transform 0.3s ease;\n");
      out.write("            }\n");
      out.write("            .status-form input[type=\"submit\"]:hover {\n");
      out.write("                background-color: #218838;\n");
      out.write("                transform: scale(1.05);\n");
      out.write("            }\n");
      out.write("        </style>\n");
      out.write("        <script>\n");
      out.write("            function confirmDelete() {\n");
      out.write("                return confirm(\"Bạn có chắc chắn muốn xóa không?\");\n");
      out.write("            }\n");
      out.write("        </script>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div class=\"container\">\n");
      out.write("            ");

                // Kiểm tra session
                HttpSession sess = request.getSession(false);
                String username = (sess != null) ? (String) sess.getAttribute("username") : null;
                String role = (sess != null) ? (String) sess.getAttribute("role") : null;

                if (username == null) {
                    response.sendRedirect("login.jsp");
                    return;
                }
            
      out.write("\n");
      out.write("\n");
      out.write("            <h2>Chào mừng, ");
      out.print( username);
      out.write("!</h2>\n");
      out.write("            <p>Vai trò của bạn: ");
      out.print( role);
      out.write("</p>\n");
      out.write("\n");
      out.write("            <a href=\"LogoutServlet\" class=\"logout-btn\">Đăng xuất</a>\n");
      out.write("\n");
      out.write("            <h3>Tìm kiếm Vouchers & Hot Deals</h3>\n");
      out.write("            <form action=\"SearchServlet\" method=\"post\" class=\"search-form\">\n");
      out.write("                <label>Danh mục:</label>\n");
      out.write("                <input type=\"text\" name=\"category\" placeholder=\"Nhập danh mục\">\n");
      out.write("                <label>Trạng thái:</label>\n");
      out.write("                <select name=\"status\">\n");
      out.write("                    <option value=\"\">-- Tất cả --</option>\n");
      out.write("                    <option value=\"Active\">Active</option>\n");
      out.write("                    <option value=\"Inactive\">Inactive</option>\n");
      out.write("                    <option value=\"Expired\">Expired</option>\n");
      out.write("                </select>\n");
      out.write("                <input type=\"submit\" value=\"Tìm kiếm\">\n");
      out.write("            </form>\n");
      out.write("\n");
      out.write("            ");
 if ("Customer".equals(role)) { 
      out.write("\n");
      out.write("            <h3>Danh sách Vouchers</h3>\n");
      out.write("            <table>\n");
      out.write("                <tr>\n");
      out.write("                    <th>ID</th>\n");
      out.write("                    <th>Mã Voucher</th>\n");
      out.write("                    <th>Phần trăm giảm</th>\n");
      out.write("                    <th>Mô tả</th>\n");
      out.write("                    <th>Trạng thái</th>\n");
      out.write("                </tr>\n");
      out.write("                ");

                    List<Voucher> vouchers = VoucherDAO.searchVouchers("", "");
                    for (Voucher v : vouchers) {
                        if ("Active".equals(v.getStatus())) { // Chỉ hiển thị Voucher có trạng thái Active

      out.write("\n");
      out.write("                <tr>\n");
      out.write("                    <td>");
      out.print( v.getId());
      out.write("</td>\n");
      out.write("                    <td>");
      out.print( v.getCode());
      out.write("</td>\n");
      out.write("                    <td>");
      out.print( v.getDiscount());
      out.write("%</td>\n");
      out.write("                    <td>");
      out.print( v.getDescription() );
      out.write("</td>\n");
      out.write("                    <td>");
      out.print( v.getStatus());
      out.write("</td>\n");
      out.write("                </tr>\n");
      out.write("                ");
 }
        } 
      out.write("\n");
      out.write("            </table>\n");
      out.write("\n");
      out.write("            <h3>Danh sách Hot Deals</h3>\n");
      out.write("            <table>\n");
      out.write("                <tr>\n");
      out.write("                    <th>ID</th>\n");
      out.write("                    <th>Tên Hot Deal</th>\n");
      out.write("                    <th>Giảm giá</th>\n");
      out.write("                    <th>Mô tả</th>\n");
      out.write("                    <th>Hết hạn</th>\n");
      out.write("                    <th>Trạng thái</th>\n");
      out.write("                </tr>\n");
      out.write("                ");

                    List<HotDeal> hotDeals = HotDealDAO.searchHotDeals("", "");
                    for (HotDeal h : hotDeals) {
                        if ("Active".equals(h.getStatus())) { // Chỉ hiển thị Hot Deal có trạng thái Active

      out.write("\n");
      out.write("                <tr>\n");
      out.write("                    <td>");
      out.print( h.getId());
      out.write("</td>\n");
      out.write("                    <td>");
      out.print( h.getName());
      out.write("</td>\n");
      out.write("                    <td>");
      out.print( h.getDiscount());
      out.write(" VND</td>\n");
      out.write("                    <td>");
      out.print( h.getDescription() );
      out.write("</td>\n");
      out.write("                    <td>");
      out.print( h.getExpirationDate());
      out.write("</td>\n");
      out.write("                    <td>");
      out.print( h.getStatus());
      out.write("</td>\n");
      out.write("                </tr>\n");
      out.write("                ");
 }
        } 
      out.write("\n");
      out.write("            </table>\n");
      out.write("            ");
 } 
      out.write("\n");
      out.write("\n");
      out.write("            ");
 if ("Admin".equals(role)) { 
      out.write("\n");
      out.write("            <h3>Danh sách Vouchers</h3>\n");
      out.write("            <a href=\"voucherForm.jsp\" class=\"add-btn\">+ Thêm Voucher</a>\n");
      out.write("            <table>\n");
      out.write("                <tr>\n");
      out.write("                    <th>ID</th>\n");
      out.write("                    <th>Mã Voucher</th>\n");
      out.write("                    <th>Phần trăm giảm</th>\n");
      out.write("                    <th>Trạng thái</th>\n");
      out.write("                    <th>Thay đổi trạng thái</th>\n");
      out.write("                    <th>Chỉnh sửa</th>\n");
      out.write("                    <th>Xóa</th>\n");
      out.write("                </tr>\n");
      out.write("                ");

                    List<Voucher> vouchers = VoucherDAO.searchVouchers("", "");
                    for (Voucher v : vouchers) {
                
      out.write("\n");
      out.write("                <tr>\n");
      out.write("                    <td>");
      out.print( v.getId());
      out.write("</td>\n");
      out.write("                    <td>");
      out.print( v.getCode());
      out.write("</td>\n");
      out.write("                    <td>");
      out.print( v.getDiscount());
      out.write("%</td>\n");
      out.write("                    <td>");
      out.print( v.getStatus());
      out.write("</td>\n");
      out.write("                    <td>\n");
      out.write("                        <form action=\"ChangeStatusServlet\" method=\"post\" class=\"status-form\">\n");
      out.write("                            <input type=\"hidden\" name=\"type\" value=\"voucher\">\n");
      out.write("                            <input type=\"hidden\" name=\"id\" value=\"");
      out.print( v.getId());
      out.write("\">\n");
      out.write("                            <select name=\"status\">\n");
      out.write("                                <option value=\"Active\" ");
      out.print( v.getStatus().equals("Active") ? "selected" : "");
      out.write(">Active</option>\n");
      out.write("                                <option value=\"Inactive\" ");
      out.print( v.getStatus().equals("Inactive") ? "selected" : "");
      out.write(">Inactive</option>\n");
      out.write("                                <option value=\"Expired\" ");
      out.print( v.getStatus().equals("Expired") ? "selected" : "");
      out.write(">Expired</option>\n");
      out.write("                            </select>\n");
      out.write("                            <input type=\"submit\" value=\"Cập nhật\">\n");
      out.write("                        </form>\n");
      out.write("                    </td>\n");
      out.write("                    <td>\n");
      out.write("                        <a href=\"editVoucher.jsp?id=");
      out.print( v.getId());
      out.write("\" class=\"edit-btn\">Chỉnh sửa</a>\n");
      out.write("                    </td>\n");
      out.write("                    <td>\n");
      out.write("                        <form action=\"DeleteServlet\" method=\"post\" onsubmit=\"return confirmDelete();\">\n");
      out.write("                            <input type=\"hidden\" name=\"type\" value=\"voucher\">\n");
      out.write("                            <input type=\"hidden\" name=\"id\" value=\"");
      out.print( v.getId());
      out.write("\">\n");
      out.write("                            <input type=\"submit\" class=\"delete-btn\" value=\"Xóa\">\n");
      out.write("                        </form>\n");
      out.write("                    </td>\n");
      out.write("                </tr>\n");
      out.write("                ");
 } 
      out.write("\n");
      out.write("            </table>\n");
      out.write("\n");
      out.write("            <h3>Danh sách Hot Deals</h3>\n");
      out.write("            <a href=\"hotdealForm.jsp\" class=\"add-btn\">+ Thêm Hot Deal</a>\n");
      out.write("            <table>\n");
      out.write("                <tr>\n");
      out.write("                    <th>ID</th>\n");
      out.write("                    <th>Tên Hot Deal</th>\n");
      out.write("                    <th>Giảm giá</th>\n");
      out.write("                    <th>Hết hạn</th>\n");
      out.write("                    <th>Trạng thái</th>\n");
      out.write("                    <th>Thay đổi trạng thái</th>\n");
      out.write("                    <th>Chỉnh sửa</th>\n");
      out.write("                    <th>Xóa</th>\n");
      out.write("                </tr>\n");
      out.write("                ");

                    List<HotDeal> hotDeals = HotDealDAO.searchHotDeals("", "");
                    for (HotDeal h : hotDeals) {
                
      out.write("\n");
      out.write("                <tr>\n");
      out.write("                    <td>");
      out.print( h.getId());
      out.write("</td>\n");
      out.write("                    <td>");
      out.print( h.getName());
      out.write("</td>\n");
      out.write("                    <td>");
      out.print( h.getDiscount());
      out.write(" VND</td>\n");
      out.write("                    <td>");
      out.print( h.getExpirationDate());
      out.write("</td>\n");
      out.write("                    <td>");
      out.print( h.getStatus());
      out.write("</td>\n");
      out.write("                    <td>\n");
      out.write("                        <form action=\"ChangeStatusServlet\" method=\"post\" class=\"status-form\">\n");
      out.write("                            <input type=\"hidden\" name=\"type\" value=\"hotdeal\">\n");
      out.write("                            <input type=\"hidden\" name=\"id\" value=\"");
      out.print( h.getId());
      out.write("\">\n");
      out.write("                            <select name=\"status\">\n");
      out.write("                                <option value=\"Active\" ");
      out.print( h.getStatus().equals("Active") ? "selected" : "");
      out.write(">Active</option>\n");
      out.write("                                <option value=\"Inactive\" ");
      out.print( h.getStatus().equals("Inactive") ? "selected" : "");
      out.write(">Inactive</option>\n");
      out.write("                                <option value=\"Expired\" ");
      out.print( h.getStatus().equals("Expired") ? "selected" : "");
      out.write(">Expired</option>\n");
      out.write("                            </select>\n");
      out.write("                            <input type=\"submit\" value=\"Cập nhật\">\n");
      out.write("                        </form>\n");
      out.write("                    </td>\n");
      out.write("                    <td>\n");
      out.write("                        <a href=\"editHotDeal.jsp?id=");
      out.print( h.getId());
      out.write("\" class=\"edit-btn\">Chỉnh sửa</a>\n");
      out.write("                    </td>\n");
      out.write("                    <td>\n");
      out.write("                        <form action=\"DeleteServlet\" method=\"post\" onsubmit=\"return confirmDelete();\">\n");
      out.write("                            <input type=\"hidden\" name=\"type\" value=\"hotdeal\">\n");
      out.write("                            <input type=\"hidden\" name=\"id\" value=\"");
      out.print( h.getId());
      out.write("\">\n");
      out.write("                            <input type=\"submit\" class=\"delete-btn\" value=\"Xóa\">\n");
      out.write("                        </form>\n");
      out.write("                    </td>\n");
      out.write("                </tr>\n");
      out.write("                ");
 } 
      out.write("\n");
      out.write("            </table>\n");
      out.write("            ");
 }
      out.write("\n");
      out.write("        </div>\n");
      out.write("    </body>\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
