package com.bosonit.BP1.infracstructure.dtos.student;

import com.bosonit.BP1.domain.entities.Person;
import com.bosonit.BP1.domain.entities.Professor;
import com.bosonit.BP1.infracstructure.dtos.person.PersonOutputDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
public class StudentFullOutputDTO extends StudentOutputDTO{

    private PersonOutputDTO personOutputDTO;


}
