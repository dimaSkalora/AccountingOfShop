package com.shop.of.accounting;

import com.shop.of.accounting.model.Alcohol;

import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.List;

import static com.shop.of.accounting.model.AbstractBaseEntity.START_SEQ;
import static org.assertj.core.api.Assertions.assertThat;

public class AlcoholTestData {
    public static final int ALCOHOL_ID = START_SEQ + 2;
    public static final int ADMIN_ALCOHOL_ID = START_SEQ + 8;

    public static final Alcohol ALCOHOL1 = new Alcohol(ALCOHOL_ID, LocalDate.of(2018, Month.MARCH,13),
            "вино","вино1",0.5,1,10,3,7);
    public static final Alcohol ALCOHOL2 = new Alcohol(ALCOHOL_ID+1, LocalDate.of(2018, Month.MARCH,13),
            "вино","вино2",0.75,1,10,6,4);
    public static final Alcohol ALCOHOL3 = new Alcohol(ALCOHOL_ID+2, LocalDate.of(2018, Month.MARCH,13),
            "вино","вино3",1.5,2,10,7,3);
    public static final Alcohol ALCOHOL4 = new Alcohol(ALCOHOL_ID+3, LocalDate.of(2018, Month.MARCH,14),
            "пиво","пиво1",1.5,1,10,9,1);
    public static final Alcohol ALCOHOL5 = new Alcohol(ALCOHOL_ID+4, LocalDate.of(2018, Month.MARCH,14),
            "пиво","пиво2",0.5,2,10,3,7);
    public static final Alcohol ALCOHOL6 = new Alcohol(ALCOHOL_ID+5, LocalDate.of(2018, Month.MARCH,14),
            "пиво","пиво3",0.75,2,4,3,1);
    public static final Alcohol ADMIN_ALCOHOL1 = new Alcohol(ADMIN_ALCOHOL_ID, LocalDate.of(2018, Month.MARCH,13),
            "пиво","пиво1",0.5,2,4,3,1);
    public static final Alcohol ADMIN_ALCOHOL2 = new Alcohol(ADMIN_ALCOHOL_ID+1, LocalDate.of(2018, Month.MARCH,13),
            "пиво","пиво2",1.25,4,10,5,5);

    public static final List<Alcohol> ALCOHOLS = Arrays.asList(ALCOHOL6,ALCOHOL5,ALCOHOL4,ALCOHOL3,ALCOHOL2,ALCOHOL1);

    public static Alcohol getCreated(){
        return new Alcohol(null,LocalDate.of(2018,Month.MARCH, 14),"вино","вино5",
                0.5,5,10,8,2);
    }

    public static Alcohol getUpdated(){
        return new Alcohol(ALCOHOL_ID,ALCOHOL1.getGoodsReceiptDate(),"вино","вино5",
                0.5,5,10,8,2);
    }

    public static void assertMatch(Alcohol actual, Alcohol expected){
        assertThat(actual).isEqualToIgnoringGivenFields(expected, "user");
    }

    public static void assertMatch(Iterable<Alcohol> actual, Alcohol... expected){
        assertMatch(actual, Arrays.asList(expected));
    }

    public static void assertMatch(Iterable<Alcohol> actual, Iterable<Alcohol> expected){
        assertThat(actual).usingElementComparatorIgnoringFields("user").isEqualTo(expected);
    }

}
