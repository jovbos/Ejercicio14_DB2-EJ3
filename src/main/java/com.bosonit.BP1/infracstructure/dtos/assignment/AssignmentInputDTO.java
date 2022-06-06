package com.bosonit.BP1.infracstructure.dtos.assignment;

import lombok.Data;

import java.util.Date;

@Data
public class AssignmentInputDTO {

    private Integer id;

//    @NotNull
    private String usuario;

//    @NotNull
    private String password;

//    @NotNull
    private String name;

    private String surname;

//    @NotNull
    private String company_email;

//    @NotNull
    private String personal_email;

//    @NotNull
    private String city;

//    @NotNull
    private Boolean active;

//    @NotNull
    private Date created_date;

    private String image_url;

    private Date termination_date;

}
