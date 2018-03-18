package com.shop.of.accounting.util;

import com.shop.of.accounting.model.Cigarette;
import com.shop.of.accounting.to.CigarettelWithBalanceNegative;

import java.util.List;
import java.util.Collection;

import static java.util.stream.Collectors.toList;

public class CigarettesUtil {
    public CigarettesUtil() {
    }

    //Выводит остаток и проверяет его на положытельный
    public static List<CigarettelWithBalanceNegative> getBalanceNeagtive(Collection<Cigarette> cigarettes){
        return cigarettes.stream()
                .map(cigarette -> createlWithBalanceNegative(cigarette,cigarette.getBalanceOnTheLastDayOfTheMonth() < 0))
                .collect(toList());
    }

    public static CigarettelWithBalanceNegative createlWithBalanceNegative(Cigarette cigarette, boolean balanceNeagative){
        return new CigarettelWithBalanceNegative(cigarette.getId(), cigarette.getGoodsReceiptDate(), cigarette.getCategory(),
                cigarette.getProductName(), cigarette.getAmount(), cigarette.getBalanceOnTheFirstDayOfTheMonth(),
                cigarette.getReceivedForMonth(), cigarette.getSoldForMonth(),
                cigarette.getBalanceOnTheLastDayOfTheMonth(), balanceNeagative);
    }
}
