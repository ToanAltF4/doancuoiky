package model;

import java.math.BigDecimal;

public class Voucher {
    private int id;
    private String code;
    private String description;
    private BigDecimal discount;
    private String category;
    private String status;

    public Voucher(int id, String code, String description, BigDecimal discount, String category, String status) {
        this.id = id;
        this.code = code;
        this.description = description;
        this.discount = discount;
        this.category = category;
        this.status = status;
    }

    public int getId() { return id; }
    public String getCode() { return code; }
    public String getDescription() { return description; }
    public BigDecimal getDiscount() { return discount; }
    public String getCategory() { return category; }
    public String getStatus() { return status; }
}
