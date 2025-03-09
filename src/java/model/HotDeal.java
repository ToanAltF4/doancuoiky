package model;

import java.math.BigDecimal;
import java.util.Date;

public class HotDeal {
    private int id;
    private String name;
    private String description;
    private BigDecimal discount;
    private String category;
    private String status;
    private Date expirationDate;

    public HotDeal(int id, String name, String description, BigDecimal discount, String category, String status, Date expirationDate) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.discount = discount;
        this.category = category;
        this.status = status;
        this.expirationDate = expirationDate;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getDescription() { return description; }
    public BigDecimal getDiscount() { return discount; }
    public String getCategory() { return category; }
    public String getStatus() { return status; }
    public Date getExpirationDate() { return expirationDate; }
}
