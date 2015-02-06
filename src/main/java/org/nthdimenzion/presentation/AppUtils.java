package org.nthdimenzion.presentation;

import org.joda.money.CurrencyUnit;

import java.util.Locale;

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
}
