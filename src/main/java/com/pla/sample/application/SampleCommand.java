package com.pla.sample.application;

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

    private List<Boolean> choices;

    private String gender="F";

    private LocalDate dateOfBirth;




}
