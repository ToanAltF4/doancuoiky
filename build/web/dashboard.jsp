<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="javax.servlet.http.HttpSession, java.util.List, model.Voucher, model.HotDeal, dao.VoucherDAO, dao.HotDealDAO" %>
<!DOCTYPE html>
<html lang="vi">
    <head>
        <meta charset="UTF-8">
        <title>Dashboard</title>
        <style>
            body {
                font-family: 'Arial', sans-serif;
                background-color: orangered;
                margin: 0;
                padding: 20px;
            }
            .container {
                max-width: 1200px;
                margin: 0 auto;
                background: #fff;
                padding: 20px;
                border-radius: 8px;
                box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
                animation: fadeIn 1s ease-in-out;
            }
            @keyframes fadeIn {
                from { opacity: 0; transform: translateY(-20px); }
                to { opacity: 1; transform: translateY(0); }
            }
            h2, h3 {
                color: #333;
            }
            .logout-btn {
                display: inline-block;
                padding: 10px 15px;
                background-color: #ff4d4d;
                color: white;
                text-decoration: none;
                border-radius: 5px;
                float: right;
                transition: background-color 0.3s ease;
            }
            .logout-btn:hover {
                background-color: #cc0000;
                transform: scale(1.05);
            }
            .add-btn {
                display: inline-block;
                padding: 10px 15px;
                background-color: #28a745;
                color: white;
                text-decoration: none;
                border-radius: 5px;
                margin-bottom: 20px;
                transition: background-color 0.3s ease, transform 0.3s ease;
            }
            .add-btn:hover {
                background-color: #218838;
                transform: scale(1.05);
            }
            table {
                width: 100%;
                border-collapse: collapse;
                margin-bottom: 20px;
                animation: slideIn 1s ease-in-out;
            }
            @keyframes slideIn {
                from { opacity: 0; transform: translateX(-20px); }
                to { opacity: 1; transform: translateX(0); }
            }
            th, td {
                border: 1px solid #ddd;
                padding: 12px;
                text-align: left;
            }
            th {
                background-color: #f8f9fa;
                color: #333;
            }
            tr:nth-child(even) {
                background-color: #f9f9f9;
            }
            tr:hover {
                background-color: #f1f1f1;
                transform: scale(1.02);
                transition: transform 0.3s ease;
            }
            .edit-btn {
                background-color: #007bff;
                color: white;
                padding: 5px 10px;
                text-decoration: none;
                border-radius: 5px;
                transition: background-color 0.3s ease, transform 0.3s ease;
            }
            .edit-btn:hover {
                background-color: #0056b3;
                transform: scale(1.1);
            }
            .delete-btn {
                background-color: #dc3545;
                color: white;
                padding: 5px 10px;
                text-decoration: none;
                border-radius: 5px;
                border: none;
                cursor: pointer;
                transition: background-color 0.3s ease, transform 0.3s ease;
            }
            .delete-btn:hover {
                background-color: #c82333;
                transform: scale(1.1);
            }
            .search-form {
                margin-bottom: 20px;
                animation: slideIn 1s ease-in-out;
            }
            .search-form label {
                margin-right: 10px;
            }
            .search-form input[type="text"], .search-form select {
                padding: 8px;
                border-radius: 5px;
                border: 1px solid #ddd;
                margin-right: 10px;
                transition: border-color 0.3s ease;
            }
            .search-form input[type="text"]:focus, .search-form select:focus {
                border-color: #007bff;
                outline: none;
            }
            .search-form input[type="submit"] {
                padding: 8px 15px;
                background-color: #007bff;
                color: white;
                border: none;
                border-radius: 5px;
                cursor: pointer;
                transition: background-color 0.3s ease, transform 0.3s ease;
            }
            .search-form input[type="submit"]:hover {
                background-color: #0056b3;
                transform: scale(1.05);
            }
            .status-form {
                display: inline-block;
            }
            .status-form select {
                padding: 5px;
                border-radius: 5px;
                border: 1px solid #ddd;
                transition: border-color 0.3s ease;
            }
            .status-form select:focus {
                border-color: #007bff;
                outline: none;
            }
            .status-form input[type="submit"] {
                padding: 5px 10px;
                background-color: #28a745;
                color: white;
                border: none;
                border-radius: 5px;
                cursor: pointer;
                transition: background-color 0.3s ease, transform 0.3s ease;
            }
            .status-form input[type="submit"]:hover {
                background-color: #218838;
                transform: scale(1.05);
            }
        </style>
        <script>
            function confirmDelete() {
                return confirm("Bạn có chắc chắn muốn xóa không?");
            }
        </script>
    </head>
    <body>
        <div class="container">
            <%
                // Kiểm tra session
                HttpSession sess = request.getSession(false);
                String username = (sess != null) ? (String) sess.getAttribute("username") : null;
                String role = (sess != null) ? (String) sess.getAttribute("role") : null;

                if (username == null) {
                    response.sendRedirect("login.jsp");
                    return;
                }
            %>

            <h2>Chào mừng, <%= username%>!</h2>
            <p>Vai trò của bạn: <%= role%></p>

            <a href="LogoutServlet" class="logout-btn">Đăng xuất</a>

            <h3>Tìm kiếm Vouchers & Hot Deals</h3>
            <form action="SearchServlet" method="post" class="search-form">
                <label>Danh mục:</label>
                <input type="text" name="category" placeholder="Nhập danh mục">
                <label>Trạng thái:</label>
                <select name="status">
                    <option value="">-- Tất cả --</option>
                    <option value="Active">Active</option>
                    <option value="Inactive">Inactive</option>
                    <option value="Expired">Expired</option>
                </select>
                <input type="submit" value="Tìm kiếm">
            </form>

            <% if ("Customer".equals(role)) { %>
            <h3>Danh sách Vouchers</h3>
            <table>
                <tr>
                    <th>ID</th>
                    <th>Mã Voucher</th>
                    <th>Phần trăm giảm</th>
                    <th>Mô tả</th>
                    <th>Trạng thái</th>
                </tr>
                <%
                    List<Voucher> vouchers = VoucherDAO.searchVouchers("", "");
                    for (Voucher v : vouchers) {
                        if ("Active".equals(v.getStatus())) { // Chỉ hiển thị Voucher có trạng thái Active
%>
                <tr>
                    <td><%= v.getId()%></td>
                    <td><%= v.getCode()%></td>
                    <td><%= v.getDiscount()%>%</td>
                    <td><%= v.getDescription() %></td>
                    <td><%= v.getStatus()%></td>
                </tr>
                <% }
        } %>
            </table>

            <h3>Danh sách Hot Deals</h3>
            <table>
                <tr>
                    <th>ID</th>
                    <th>Tên Hot Deal</th>
                    <th>Giảm giá</th>
                    <th>Mô tả</th>
                    <th>Hết hạn</th>
                    <th>Trạng thái</th>
                </tr>
                <%
                    List<HotDeal> hotDeals = HotDealDAO.searchHotDeals("", "");
                    for (HotDeal h : hotDeals) {
                        if ("Active".equals(h.getStatus())) { // Chỉ hiển thị Hot Deal có trạng thái Active
%>
                <tr>
                    <td><%= h.getId()%></td>
                    <td><%= h.getName()%></td>
                    <td><%= h.getDiscount()%> VND</td>
                    <td><%= h.getDescription() %></td>
                    <td><%= h.getExpirationDate()%></td>
                    <td><%= h.getStatus()%></td>
                </tr>
                <% }
        } %>
            </table>
            <% } %>

            <% if ("Admin".equals(role)) { %>
            <h3>Danh sách Vouchers</h3>
            <a href="voucherForm.jsp" class="add-btn">+ Thêm Voucher</a>
            <table>
                <tr>
                    <th>ID</th>
                    <th>Mã Voucher</th>
                    <th>Phần trăm giảm</th>
                    <th>Trạng thái</th>
                    <th>Thay đổi trạng thái</th>
                    <th>Chỉnh sửa</th>
                    <th>Xóa</th>
                </tr>
                <%
                    List<Voucher> vouchers = VoucherDAO.searchVouchers("", "");
                    for (Voucher v : vouchers) {
                %>
                <tr>
                    <td><%= v.getId()%></td>
                    <td><%= v.getCode()%></td>
                    <td><%= v.getDiscount()%>%</td>
                    <td><%= v.getStatus()%></td>
                    <td>
                        <form action="ChangeStatusServlet" method="post" class="status-form">
                            <input type="hidden" name="type" value="voucher">
                            <input type="hidden" name="id" value="<%= v.getId()%>">
                            <select name="status">
                                <option value="Active" <%= v.getStatus().equals("Active") ? "selected" : ""%>>Active</option>
                                <option value="Inactive" <%= v.getStatus().equals("Inactive") ? "selected" : ""%>>Inactive</option>
                                <option value="Expired" <%= v.getStatus().equals("Expired") ? "selected" : ""%>>Expired</option>
                            </select>
                            <input type="submit" value="Cập nhật">
                        </form>
                    </td>
                    <td>
                        <a href="editVoucher.jsp?id=<%= v.getId()%>" class="edit-btn">Chỉnh sửa</a>
                    </td>
                    <td>
                        <form action="DeleteServlet" method="post" onsubmit="return confirmDelete();">
                            <input type="hidden" name="type" value="voucher">
                            <input type="hidden" name="id" value="<%= v.getId()%>">
                            <input type="submit" class="delete-btn" value="Xóa">
                        </form>
                    </td>
                </tr>
                <% } %>
            </table>

            <h3>Danh sách Hot Deals</h3>
            <a href="hotdealForm.jsp" class="add-btn">+ Thêm Hot Deal</a>
            <table>
                <tr>
                    <th>ID</th>
                    <th>Tên Hot Deal</th>
                    <th>Giảm giá</th>
                    <th>Hết hạn</th>
                    <th>Trạng thái</th>
                    <th>Thay đổi trạng thái</th>
                    <th>Chỉnh sửa</th>
                    <th>Xóa</th>
                </tr>
                <%
                    List<HotDeal> hotDeals = HotDealDAO.searchHotDeals("", "");
                    for (HotDeal h : hotDeals) {
                %>
                <tr>
                    <td><%= h.getId()%></td>
                    <td><%= h.getName()%></td>
                    <td><%= h.getDiscount()%> VND</td>
                    <td><%= h.getExpirationDate()%></td>
                    <td><%= h.getStatus()%></td>
                    <td>
                        <form action="ChangeStatusServlet" method="post" class="status-form">
                            <input type="hidden" name="type" value="hotdeal">
                            <input type="hidden" name="id" value="<%= h.getId()%>">
                            <select name="status">
                                <option value="Active" <%= h.getStatus().equals("Active") ? "selected" : ""%>>Active</option>
                                <option value="Inactive" <%= h.getStatus().equals("Inactive") ? "selected" : ""%>>Inactive</option>
                                <option value="Expired" <%= h.getStatus().equals("Expired") ? "selected" : ""%>>Expired</option>
                            </select>
                            <input type="submit" value="Cập nhật">
                        </form>
                    </td>
                    <td>
                        <a href="editHotDeal.jsp?id=<%= h.getId()%>" class="edit-btn">Chỉnh sửa</a>
                    </td>
                    <td>
                        <form action="DeleteServlet" method="post" onsubmit="return confirmDelete();">
                            <input type="hidden" name="type" value="hotdeal">
                            <input type="hidden" name="id" value="<%= h.getId()%>">
                            <input type="submit" class="delete-btn" value="Xóa">
                        </form>
                    </td>
                </tr>
                <% } %>
            </table>
            <% }%>
        </div>
    </body>
</html>