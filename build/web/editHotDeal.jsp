<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="dao.HotDealDAO, model.HotDeal" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Chỉnh sửa Hot Deal</title>
    <style>
        body {
            font-family: 'Arial', sans-serif;
            background-color: orangered; /* Màu cam sáng cho background */
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
        input[type="date"],
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
        HotDeal hotDeal = HotDealDAO.getHotDealById(id); // Lấy đối tượng HotDeal từ DB
    %>

    <div class="container">
        <h2>Chỉnh sửa Hot Deal</h2>
        <form action="EditHotDealServlet" method="post">
            <input type="hidden" name="id" value="<%= hotDeal.getId() %>">

            <div class="form-group">
                <label for="deal_name">Tên Hot Deal:</label>
                <input type="text" id="deal_name" name="deal_name" value="<%= hotDeal.getName() %>" required>
            </div>

            <div class="form-group">
                <label for="description">Mô tả:</label>
                <input type="text" id="description" name="description" value="<%= hotDeal.getDescription() %>">
            </div>

            <div class="form-group">
                <label for="discount_amount">Số tiền giảm giá:</label>
                <input type="number" id="discount_amount" name="discount_amount" step="0.01" value="<%= hotDeal.getDiscount() %>" required>
            </div>

            <div class="form-group">
                <label for="category">Danh mục:</label>
                <input type="text" id="category" name="category" value="<%= hotDeal.getCategory() %>" required>
            </div>

            <div class="form-group">
                <label for="status">Trạng thái:</label>
                <select id="status" name="status">
                    <option value="Active" <%= hotDeal.getStatus().equals("Active") ? "selected" : "" %>>Active</option>
                    <option value="Inactive" <%= hotDeal.getStatus().equals("Inactive") ? "selected" : "" %>>Inactive</option>
                    <option value="Expired" <%= hotDeal.getStatus().equals("Expired") ? "selected" : "" %>>Expired</option>
                </select>
            </div>

            <div class="form-group">
                <label for="expiration_date">Ngày hết hạn:</label>
                <input type="date" id="expiration_date" name="expiration_date" value="<%= hotDeal.getExpirationDate() %>" required>
            </div>

            <input type="submit" value="Lưu thay đổi">
        </form>
        
        <a href="dashboard.jsp" class="back-btn">← Quay lại Dashboard</a>
    </div>
</body>
</html>
