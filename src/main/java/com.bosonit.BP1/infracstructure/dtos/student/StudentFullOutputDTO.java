package com.bosonit.BP1.infracstructure.dtos.student;

import com.bosonit.BP1.infracstructure.dtos.person.PersonOutputDTO;
import lombok.Data;

@Data
public class StudentFullOutputDTO extends StudentOutputDTO{

    private PersonOutputDTO person;


}
