package com.pla.sample.presentation;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import org.joda.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
public class Person {

    private int id;
    private String name;
    private String branch;
    private String designation;
    private LocalDate joiningDate;
    private Money commission;
    private boolean status;

}

