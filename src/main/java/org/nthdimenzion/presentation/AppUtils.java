package org.nthdimenzion.presentation;

import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.math.BigDecimal;
import java.util.Locale;

import static org.nthdimenzion.common.AppConstants.DEFAULT_CURRENCY;

/**
 * Author: Nthdimenzion
 */

public class AppUtils {

    public static String StripCurrencyUnit(String money){
        return money.substring(3);
    }

    public static String PrependCurrencyUnit(String money){
        return CurrencyUnit.getInstance(Locale.getDefault()).getCurrencyCode() + money;
    }

    public static DateTimeFormatter GetDateTimeFormat(){
        String patternEnglish = DateTimeFormat.patternForStyle("S-", Locale.getDefault());
        patternEnglish = patternEnglish.replace("yy", "yyyy");
        return DateTimeFormat.forPattern(patternEnglish);
    }

    public static LocalDate ToLocalDate(String date){
        return GetDateTimeFormat().parseLocalDate(date);
    }

    public static Money ToMoney(String money){
        return Money.of(DEFAULT_CURRENCY, new BigDecimal(money));
    }

}

