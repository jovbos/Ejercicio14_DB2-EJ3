package com.bosonit.BP1.application.useCases.student;

import com.bosonit.BP1.application.exceptions.exception422.CustomErrorRequest422;
import com.bosonit.BP1.application.ports.student.CreateStudentPort;
import com.bosonit.BP1.domain.entities.Student;
import com.bosonit.BP1.domain.repositories.StudentRepository;
import com.bosonit.BP1.infracstructure.dtos.student.StudentFullOutputDTO;
import com.bosonit.BP1.infracstructure.dtos.student.StudentInputDTO;
import com.bosonit.BP1.infracstructure.dtos.student.StudentOutputDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CreateStudentUseCase implements CreateStudentPort {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    StudentRepository repository;

    public StudentFullOutputDTO addStudent(StudentInputDTO studentDTO){

        Student student = modelMapper.map(studentDTO, Student.class);

        if (student.getHours_per_week() == null || student.getBranch() == null)
        throw new CustomErrorRequest422("UNPROCCESABLE_ENTITY");
        repository.save(student);

        return modelMapper.map(student, StudentFullOutputDTO.class);
    }
}
