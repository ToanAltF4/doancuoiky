<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="dao.VoucherDAO, model.Voucher" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Chỉnh sửa Voucher</title>
    <style>
        body {
            font-family: 'Arial', sans-serif;
            background-color: orangered ; /* Màu cam sáng cho background */
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            color: white;
        }

        .container {
            background-color: rgba(255, 255, 255, 0.9); /* Nền trắng nhẹ cho form */
            padding: 30px;
            border-radius: 10px;
            width: 80%;
            max-width: 600px;
            box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
        }

        h2 {
            text-align: center;
            color: #333;
            margin-bottom: 20px;
        }

        label {
            font-weight: bold;
            display: block;
            margin-bottom: 8px;
            color: #333;
        }

        input[type="text"],
        input[type="number"],
        select {
            width: 100%;
            padding: 12px;
            margin: 10px 0;
            border: 1px solid #ccc;
            border-radius: 5px;
            font-size: 16px;
            box-sizing: border-box;
        }

        input[type="submit"] {
            background-color: #3498db;
            color: white;
            border: none;
            padding: 12px;
            width: 100%;
            font-size: 18px;
            border-radius: 5px;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }

        input[type="submit"]:hover {
            background-color: #2980b9;
        }

        .back-btn {
            display: inline-block;
            padding: 10px 20px;
            background-color: #2c3e50;
            color: white;
            text-decoration: none;
            border-radius: 5px;
            margin-top: 20px;
            text-align: center;
        }

        .back-btn:hover {
            background-color: #34495e;
        }

        .form-group {
            margin-bottom: 20px;
        }

        /* Responsive Design */
        @media screen and (max-width: 768px) {
            .container {
                width: 90%;
                padding: 20px;
            }

            input[type="submit"] {
                font-size: 16px;
            }
        }
    </style>
</head>
<body>
    <%
        int id = Integer.parseInt(request.getParameter("id"));
        Voucher voucher = VoucherDAO.getVoucherById(id); // Lấy đối tượng Voucher từ DB
    %>

    <div class="container">
        <h2>Chỉnh sửa Voucher</h2>
        <form action="EditVoucherServlet" method="post">
            <input type="hidden" name="id" value="<%= voucher.getId() %>">

            <div class="form-group">
                <label for="voucher_code">Mã Voucher:</label>
                <input type="text" id="voucher_code" name="voucher_code" value="<%= voucher.getCode() %>" readonly>
            </div>

            <div class="form-group">
                <label for="description">Mô tả:</label>
                <input type="text" id="description" name="description" value="<%= voucher.getDescription() %>">
            </div>

            <div class="form-group">
                <label for="discount_percent">Phần trăm giảm giá:</label>
                <input type="number" id="discount_percent" name="discount_percent" step="0.01" value="<%= voucher.getDiscount() %>">
            </div>

            <div class="form-group">
                <label for="category">Danh mục:</label>
                <input type="text" id="category" name="category" value="<%= voucher.getCategory() %>">
            </div>

            <div class="form-group">
                <label for="status">Trạng thái:</label>
                <select id="status" name="status">
                    <option value="Active" <%= voucher.getStatus().equals("Active") ? "selected" : "" %>>Active</option>
                    <option value="Inactive" <%= voucher.getStatus().equals("Inactive") ? "selected" : "" %>>Inactive</option>
                    <option value="Expired" <%= voucher.getStatus().equals("Expired") ? "selected" : "" %>>Expired</option>
                </select>
            </div>

            <input type="submit" value="Lưu thay đổi">
        </form>

        <a href="dashboard.jsp" class="back-btn">← Quay lại Dashboard</a>
    </div>
</body>
</html>
