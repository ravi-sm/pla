package com.pla.sample.presentation;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
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
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate joiningDate;
    @NumberFormat(style= NumberFormat.Style.CURRENCY)
    private BigDecimal commission;
    private boolean status;

}
