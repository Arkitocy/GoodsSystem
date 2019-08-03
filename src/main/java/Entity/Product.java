package Entity;

import java.math.BigDecimal;
import java.util.Date;

public class Product {
    private int id;
    private String name;
    private String category;
    private Date productiondate;
    private Date outdate;
    private BigDecimal price;
    private int amount;

    public Product(String name, String category, Date productiondate, Date outdate, BigDecimal price, int amount) {
        this.name = name;
        this.category = category;
        this.productiondate = productiondate;
        this.outdate = outdate;
        this.price = price;
        this.amount = amount;
    }

    public Product() {
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Date getProductiondate() {
        return productiondate;
    }

    public void setProductiondate(Date productiondate) {
        this.productiondate = productiondate;
    }

    public Date getOutdate() {
        return outdate;
    }

    public void setOutdate(Date outdate) {
        this.outdate = outdate;
    }

    public void show() {
        System.out.println("产品ID：" + this.getId());
        System.out.print("产品名：" + this.getName());
        System.out.print("  产品分类：" + this.getCategory());
        System.out.print("  生产日期：" + this.getProductiondate());
        System.out.println("    保质期：" + this.getOutdate());
    }
}
