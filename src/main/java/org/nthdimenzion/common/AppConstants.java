package org.nthdimenzion.common;

import org.joda.money.CurrencyUnit;

import java.util.Locale;

/**
 * Author: Nthdimenzion
 */

public interface AppConstants {

    CurrencyUnit DEFAULT_CURRENCY = CurrencyUnit.of(Locale.getDefault());

}
