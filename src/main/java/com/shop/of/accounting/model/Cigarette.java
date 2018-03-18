package com.shop.of.accounting.model;

import java.time.LocalDate;

public class Cigarette extends AbstractBaseEntity{
    private LocalDate goodsReceiptDate;
    private String category;
    private String productName;
    private Integer amount;
    private Integer balanceOnTheFirstDayOfTheMonth;
    private Integer receivedForMonth;
    private Integer soldForMonth;
    private Integer balanceOnTheLastDayOfTheMonth;

    private User user;

    public Cigarette() {
    }

    public Cigarette(LocalDate goodsReceiptDate, String category, String productName, Integer amount, Integer balanceOnTheFirstDayOfTheMonth, Integer receivedForMonth, Integer soldForMonth, Integer balanceOnTheLastDayOfTheMonth) {
        this(null, goodsReceiptDate, category, productName, amount, balanceOnTheFirstDayOfTheMonth, receivedForMonth, soldForMonth, balanceOnTheLastDayOfTheMonth);
    }

    public Cigarette(Integer id, LocalDate goodsReceiptDate, String category, String productName, Integer amount, Integer balanceOnTheFirstDayOfTheMonth, Integer receivedForMonth, Integer soldForMonth, Integer balanceOnTheLastDayOfTheMonth) {
        super(id);
        this.goodsReceiptDate = goodsReceiptDate;
        this.category = category;
        this.productName = productName;
        this.amount = amount;
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

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
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
        return "Cigarette{" +
                "goodsReceiptDate=" + goodsReceiptDate +
                ", category='" + category + '\'' +
                ", productName='" + productName + '\'' +
                ", amount=" + amount +
                ", balanceOnTheFirstDayOfTheMonth=" + balanceOnTheFirstDayOfTheMonth +
                ", receivedForMonth=" + receivedForMonth +
                ", soldForMonth=" + soldForMonth +
                ", balanceOnTheLastDayOfTheMonth=" + balanceOnTheLastDayOfTheMonth +
                ", id=" + id +
                '}';
    }
}
