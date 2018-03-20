package com.shop.of.accounting.to;

import java.time.LocalDate;

public class ProductWithBalanceNegative extends BaseTo{
    private LocalDate goodsReceiptDate;
    private String category;
    private String productName;
    private Integer amount;
    private Integer balanceOnTheFirstDayOfTheMonth;
    private Integer receivedForMonth;
    private Integer soldForMonth;
    private Integer balanceOnTheLastDayOfTheMonth;

    private boolean balanceNegative;

    public ProductWithBalanceNegative(Integer id, LocalDate goodsReceiptDate, String category, String productName, Integer amount, Integer balanceOnTheFirstDayOfTheMonth, Integer receivedForMonth, Integer soldForMonth, Integer balanceOnTheLastDayOfTheMonth, boolean balanceNegative) {
        super(id);
        this.goodsReceiptDate = goodsReceiptDate;
        this.category = category;
        this.productName = productName;
        this.amount = amount;
        this.balanceOnTheFirstDayOfTheMonth = balanceOnTheFirstDayOfTheMonth;
        this.receivedForMonth = receivedForMonth;
        this.soldForMonth = soldForMonth;
        this.balanceOnTheLastDayOfTheMonth = balanceOnTheLastDayOfTheMonth;
        this.balanceNegative = balanceNegative;
    }

    public LocalDate getGoodsReceiptDate() {
        return goodsReceiptDate;
    }

    public String getCategory() {
        return category;
    }

    public String getProductName() {
        return productName;
    }

    public Integer getAmount() {
        return amount;
    }

    public Integer getBalanceOnTheFirstDayOfTheMonth() {
        return balanceOnTheFirstDayOfTheMonth;
    }

    public Integer getReceivedForMonth() {
        return receivedForMonth;
    }

    public Integer getSoldForMonth() {
        return soldForMonth;
    }

    public Integer getBalanceOnTheLastDayOfTheMonth() {
        return balanceOnTheLastDayOfTheMonth;
    }

    public boolean isBalanceNegative() {
        return balanceNegative;
    }

    @Override
    public String toString() {
        return "ProductWithBalanceNegative{" +
                "goodsReceiptDate=" + goodsReceiptDate +
                ", category='" + category + '\'' +
                ", productName='" + productName + '\'' +
                ", amount=" + amount +
                ", balanceOnTheFirstDayOfTheMonth=" + balanceOnTheFirstDayOfTheMonth +
                ", receivedForMonth=" + receivedForMonth +
                ", soldForMonth=" + soldForMonth +
                ", balanceOnTheLastDayOfTheMonth=" + balanceOnTheLastDayOfTheMonth +
                ", balanceNegative=" + balanceNegative +
                ", id=" + id +
                '}';
    }
}
