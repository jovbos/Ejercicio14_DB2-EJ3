package com.bosonit.BP1.application.useCases.student;

import com.bosonit.BP1.application.exceptions.exception404.CustomErrorRequest404;
import com.bosonit.BP1.application.exceptions.exception422.CustomErrorRequest422;
import com.bosonit.BP1.application.ports.student.UpdateStudentPort;
import com.bosonit.BP1.domain.entities.Student;
import com.bosonit.BP1.domain.repositories.StudentRepository;
import com.bosonit.BP1.infracstructure.dtos.student.StudentInputDTO;
import com.bosonit.BP1.infracstructure.dtos.student.StudentOutputDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UpdateStudentUseCase implements UpdateStudentPort {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    StudentRepository repository;

    public ResponseEntity<StudentOutputDTO> updateStudent (String id, StudentInputDTO studentDTO) {

        if (repository.findById(id).isEmpty()) throw new CustomErrorRequest404("NOT_FOUND");
            else{
                Student student = modelMapper.map(studentDTO, Student.class);
                student.setId_student(id);

                if (student.getHours_per_week() == null || student.getBranch() == null)
                throw new CustomErrorRequest422("UNPROCCESABLE_ENTITY");
                repository.save(student);

                StudentOutputDTO studentOut = modelMapper.map(student, StudentOutputDTO.class);

            return ResponseEntity.ok().body(studentOut);
         }
    }
}
