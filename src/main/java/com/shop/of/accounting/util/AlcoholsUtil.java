package com.shop.of.accounting.util;

import com.shop.of.accounting.model.Alcohol;
import com.shop.of.accounting.to.AlcoholWithBalanceNegative;

import java.util.Collection;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class AlcoholsUtil {
    public AlcoholsUtil() {
    }

    //Выводит остаток и проверяет его на положытельный
    public static List<AlcoholWithBalanceNegative> getBalanceNegative(Collection<Alcohol> alcohols){
        return alcohols.stream()
                .map(alcohol->createWithBalanceNegative(alcohol,alcohol.getBalanceOnTheLastDayOfTheMonth()<0))
                .collect(toList());
    }

    public static AlcoholWithBalanceNegative createWithBalanceNegative(Alcohol alcohol, boolean balanceNegative){
        return new AlcoholWithBalanceNegative(alcohol.getId(), alcohol.getGoodsReceiptDate(), alcohol.getCategory(),
                alcohol.getProductName(), alcohol.getLiter(), alcohol.getBalanceOnTheFirstDayOfTheMonth(),
                alcohol.getReceivedForMonth(), alcohol.getSoldForMonth(),
                alcohol.getBalanceOnTheLastDayOfTheMonth(), balanceNegative);
    }
}
