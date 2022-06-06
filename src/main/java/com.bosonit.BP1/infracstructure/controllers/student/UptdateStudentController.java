package com.bosonit.BP1.infracstructure.controllers.student;

import com.bosonit.BP1.application.ports.student.UpdateStudentPort;
import com.bosonit.BP1.infracstructure.dtos.student.StudentInputDTO;
import com.bosonit.BP1.infracstructure.dtos.student.StudentOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UptdateStudentController {

    @Autowired
    UpdateStudentPort updatePort;

    @PutMapping("/student/{id}")
    public ResponseEntity<StudentOutputDTO> updateStudent(@PathVariable("id") String id, @RequestBody StudentInputDTO studentDTO) {

        return updatePort.updateStudent(id, studentDTO);
    }

}
