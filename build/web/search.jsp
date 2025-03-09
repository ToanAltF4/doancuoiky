<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List, model.Voucher, model.HotDeal" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Kết quả tìm kiếm</title>
    <style>
        body {
            font-family: 'Arial', sans-serif;
            background-color: #f4f7f6;
            color: #333;
            margin: 0;
            padding: 20px;
        }

        h2 {
            color: #2c3e50;
            text-align: center;
        }

        .container {
            width: 80%;
            margin: 0 auto;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-bottom: 30px;
            background-color: #fff;
            box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
        }

        th, td {
            border: 1px solid #ddd;
            padding: 12px;
            text-align: left;
            font-size: 16px;
        }

        th {
            background-color: #3498db;
            color: white;
        }

        tr:hover {
            background-color: #f1f1f1;
        }

        .back-btn {
            display: inline-block;
            padding: 10px 20px;
            background-color: #3498db;
            color: white;
            text-decoration: none;
            border-radius: 5px;
            font-size: 16px;
            margin-top: 20px;
            transition: background-color 0.3s ease;
        }

        .back-btn:hover {
            background-color: #2980b9;
        }

        .message {
            color: #e74c3c;
            font-size: 18px;
            text-align: center;
        }

        h3 {
            color: #34495e;
            margin-top: 30px;
            font-size: 20px;
        }

        /* Responsive Design */
        @media screen and (max-width: 768px) {
            .container {
                width: 95%;
            }

            table {
                font-size: 14px;
            }

            .back-btn {
                padding: 8px 15px;
                font-size: 14px;
            }
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>Kết quả tìm kiếm</h2>

        <h3>Danh sách Vouchers:</h3>
        <table>
            <tr>
                <th>Mã Voucher</th>
                <th>Phần trăm giảm</th>
                <th>Danh mục</th>
                <th>Trạng thái</th>
            </tr>
            <%
                List<Voucher> vouchers = (List<Voucher>) request.getAttribute("vouchers");
                if (vouchers != null && !vouchers.isEmpty()) {
                    for (Voucher v : vouchers) { %>
                        <tr>
                            <td><%= v.getCode() %></td>
                            <td><%= v.getDiscount() %>%</td>
                            <td><%= v.getCategory() %></td>
                            <td><%= v.getStatus() %></td>
                        </tr>
            <%      }
                } else { %>
                <tr><td colspan="4" class="message">Không tìm thấy Voucher nào.</td></tr>
            <% } %>
        </table>

        <h3>Danh sách Hot Deals:</h3>
        <table>
            <tr>
                <th>Tên Hot Deal</th>
                <th>Giảm giá</th>
                <th>Danh mục</th>
                <th>Trạng thái</th>
            </tr>
            <%
                List<HotDeal> hotDeals = (List<HotDeal>) request.getAttribute("hotDeals");
                if (hotDeals != null && !hotDeals.isEmpty()) {
                    for (HotDeal h : hotDeals) { %>
                        <tr>
                            <td><%= h.getName() %></td>
                            <td><%= h.getDiscount() %> VND</td>
                            <td><%= h.getCategory() %></td>
                            <td><%= h.getStatus() %></td>
                        </tr>
            <%      }
                } else { %>
                <tr><td colspan="4" class="message">Không tìm thấy Hot Deal nào.</td></tr>
            <% } %>
        </table>

        <a href="dashboard.jsp" class="back-btn">← Quay lại Dashboard</a>
    </div>
</body>
</html>
