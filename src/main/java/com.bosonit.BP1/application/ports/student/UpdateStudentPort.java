package com.bosonit.BP1.application.ports.student;

import com.bosonit.BP1.infracstructure.dtos.student.StudentInputDTO;
import com.bosonit.BP1.infracstructure.dtos.student.StudentOutputDTO;
import org.springframework.http.ResponseEntity;

public interface UpdateStudentPort {

    public ResponseEntity<StudentOutputDTO> updateStudent (String id, StudentInputDTO studentDTO);
}
