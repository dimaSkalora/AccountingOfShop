package com.shop.of.accounting.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "alcohol", uniqueConstraints = {@UniqueConstraint(columnNames = {"user_id"}, name = "alcohols_unique_user_datetime_idx")})
public class Alcohol extends AbstractBaseEntity{
    @Column(name = "goodsReceiptDate", nullable = false)
    private LocalDate goodsReceiptDate;

    @Column(name = "category", nullable = false)
    private String category;

    @Column(name = "productName", nullable = false)
    private String productName;

    @Column(name = "liter", nullable = false)
    private Double liter;

    @Column(name = "balanceOnTheFirstDayOfTheMonth", nullable = false)
    private Integer balanceOnTheFirstDayOfTheMonth;

    @Column(name = "receivedForMonth", nullable = false)
    private Integer receivedForMonth;

    @Column(name = "soldForMonth", nullable = false)
    private Integer soldForMonth;

    @Column(name = "balanceOnTheLastDayOfTheMonth", nullable = false)
    private Integer balanceOnTheLastDayOfTheMonth;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public Alcohol() {
    }

    public Alcohol(LocalDate goodsReceiptDate, String category, String productName, Double liter, Integer balanceOnTheFirstDayOfTheMonth, Integer receivedForMonth, Integer soldForMonth, Integer balanceOnTheLastDayOfTheMonth) {
        this(null,goodsReceiptDate,category,productName,liter,balanceOnTheFirstDayOfTheMonth,receivedForMonth,soldForMonth,balanceOnTheLastDayOfTheMonth);
    }

    public Alcohol(Integer id, LocalDate goodsReceiptDate, String category, String productName, Double liter, Integer balanceOnTheFirstDayOfTheMonth, Integer receivedForMonth, Integer soldForMonth, Integer balanceOnTheLastDayOfTheMonth) {
        super(id);
        this.goodsReceiptDate = goodsReceiptDate;
        this.category = category;
        this.productName=productName;
        this.liter = liter;
        this.balanceOnTheFirstDayOfTheMonth = balanceOnTheFirstDayOfTheMonth;
        this.receivedForMonth = receivedForMonth;
        this.soldForMonth = soldForMonth;
        this.balanceOnTheLastDayOfTheMonth = balanceOnTheLastDayOfTheMonth;
    }

    public LocalDate getGoodsReceiptDate() {
        return goodsReceiptDate;
    }

    public void setGoodsReceiptDate(LocalDate goodsReceiptDate) {
        this.goodsReceiptDate = goodsReceiptDate;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Double getLiter() {
        return liter;
    }

    public void setLiter(Double liter) {
        this.liter = liter;
    }

    public Integer getBalanceOnTheFirstDayOfTheMonth() {
        return balanceOnTheFirstDayOfTheMonth;
    }

    public void setBalanceOnTheFirstDayOfTheMonth(Integer balanceOnTheFirstDayOfTheMonth) {
        this.balanceOnTheFirstDayOfTheMonth = balanceOnTheFirstDayOfTheMonth;
    }

    public Integer getReceivedForMonth() {
        return receivedForMonth;
    }

    public void setReceivedForMonth(Integer receivedForMonth) {
        this.receivedForMonth = receivedForMonth;
    }

    public Integer getSoldForMonth() {
        return soldForMonth;
    }

    public void setSoldForMonth(Integer soldForMonth) {
        this.soldForMonth = soldForMonth;
    }

    public Integer getBalanceOnTheLastDayOfTheMonth() {
        return balanceOnTheLastDayOfTheMonth;
    }

    public void setBalanceOnTheLastDayOfTheMonth(Integer balanceOnTheLastDayOfTheMonth) {
        this.balanceOnTheLastDayOfTheMonth = balanceOnTheLastDayOfTheMonth;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Alcohol{" +
                "goodsReceiptDate=" + goodsReceiptDate +
                ", category='" + category + '\'' +
                ", liter=" + liter +
                ", balanceOnTheFirstDayOfTheMonth=" + balanceOnTheFirstDayOfTheMonth +
                ", receivedForMonth=" + receivedForMonth +
                ", soldForMonth=" + soldForMonth +
                ", balanceOnTheLastDayOfTheMonth=" + balanceOnTheLastDayOfTheMonth +
                ", id=" + id +
                '}';
    }
}
