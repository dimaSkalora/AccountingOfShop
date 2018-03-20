package com.shop.of.accounting.util;

import com.shop.of.accounting.model.Product;
import com.shop.of.accounting.to.ProductWithBalanceNegative;

import java.util.Collection;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class ProductsUtil {
    public ProductsUtil() {
    }


    //Выводит остаток и проверяет его на положытельный
    public static List<ProductWithBalanceNegative> getBalanceNeagtive(Collection<Product> products){
        return products.stream()
                .map(product -> createlWithBalanceNegative(product,product.getBalanceOnTheLastDayOfTheMonth() < 0))
                .collect(toList());
    }

    public static ProductWithBalanceNegative createlWithBalanceNegative(Product product, boolean balanceNeagative){
        return new ProductWithBalanceNegative(product.getId(), product.getGoodsReceiptDate(), product.getCategory(),
                product.getProductName(), product.getAmount(), product.getBalanceOnTheFirstDayOfTheMonth(),
                product.getReceivedForMonth(), product.getSoldForMonth(),
                product.getBalanceOnTheLastDayOfTheMonth(), balanceNeagative);
    }
}
