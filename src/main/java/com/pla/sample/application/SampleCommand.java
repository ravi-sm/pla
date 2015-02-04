package com.pla.sample.application;

import com.google.common.collect.Lists;
import lombok.Data;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.LocalDate;

import java.util.List;

/**
 * Author: Nthdimenzion
 */

@Data
public class SampleCommand {

    @Email(message = "{invalidEmail}")
    private String email="sudarshan89@gmail.com";

    private String password;

    private Boolean active;

    //private List<Boolean> choices;

    private String gender="F";

    private LocalDate dateOfBirth;

    private  List<String> choicesList = Lists.newArrayList("choiceOne","choiceTwo","choiceThree");

    private  List<String> countries = Lists.newArrayList("India","Pakistan","Nepal","Bangladesh");

    private  List<String> selectedList = Lists.newArrayList();

    private  String selectedCountry;

}
