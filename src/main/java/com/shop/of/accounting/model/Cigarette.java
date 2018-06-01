package com.shop.of.accounting.model;

import javax.persistence.*;
import java.time.LocalDate;

@NamedQueries({
    @NamedQuery(name = Cigarette.ALL_SORTED, query = "SELECT c FROM Cigarette c WHERE c.user.id=:userId order by c.goodsReceiptDate DESC "),
    @NamedQuery(name = Cigarette.DELETE, query = "DELETE FROM Cigarette c " +
            "WHERE c.id=:id AND c.user.id=:userId"),
    @NamedQuery(name = Cigarette.GET_CATEGORY, query = "SELECT c FROM Cigarette c " +
            "WHERE c.category=:category AND c.user.id=:userID"),
    @NamedQuery(name = Cigarette.GET_SEARCH_BY_PRODUCT_NAME, query = "SELECT c FROM Cigarette c WHERE c.catgeory=:category" +
            "AND c.productname=:productName  AND c.category=:category AND c.user.id=:userId ORDER BY c.goodsReceiptDate DESC"),
    @NamedQuery(name = Cigarette.GET_BETWEEN, query = "SELECT c FROM Cigarette c" +
            "WHERE  c.user.id=:userId  AND c.goodsReceiptDate BETWEEN :startDate AND :endDate ORDER BY c.goodsReceiptDate")
        
})
@Entity
@Table(name = "cigarette", uniqueConstraints = {@UniqueConstraint(columnNames = {"user_id"}, name = "cigarettes_unique_user_datetime_idx")})
public class Cigarette extends AbstractBaseEntity{

    public static final String ALL_SORTED = "Cigarette.getAll";
    public static final String DELETE = "Cigarette.delete";
    public static final String GET_CATEGORY = "Cigarette.getCategory";
    public static final String GET_SEARCH_BY_PRODUCT_NAME = "Cigarette.getSearchByProductName(";
    public static final String GET_BETWEEN = "Cigarette.getBetween";

    @Column(name = "goodsReceiptDate", nullable = false)
    private LocalDate goodsReceiptDate;

    @Column(name = "category", nullable = false)
    private String category;

    @Column(name = "productName", nullable = false)
    private String productName;

    @Column(name = "amount", nullable = false)
    private Integer amount;

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
