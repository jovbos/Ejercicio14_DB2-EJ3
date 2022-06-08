package com.bosonit.BP1.application.useCases.student;

import com.bosonit.BP1.application.exceptions.exception404.CustomErrorRequest404;
import com.bosonit.BP1.application.ports.student.GetStudentPort;
import com.bosonit.BP1.domain.entities.Person;
import com.bosonit.BP1.domain.entities.Student;
import com.bosonit.BP1.domain.repositories.PersonRepository;
import com.bosonit.BP1.domain.repositories.StudentRepository;
import com.bosonit.BP1.infracstructure.dtos.person.PersonOutputDTO;
import com.bosonit.BP1.infracstructure.dtos.student.StudentFullOutputDTO;
import com.bosonit.BP1.infracstructure.dtos.student.StudentOutputDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GetStudentUseCase implements GetStudentPort {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    StudentRepository studentRepository;

    public ResponseEntity<StudentOutputDTO> getStudentId(String id, String outputType) throws Exception {

        StudentOutputDTO studentOutputDTO;
        Student student = studentRepository.findById(id).orElseThrow(() -> new CustomErrorRequest404("STUDENT NOT REGISTERED"));
        if (outputType.equals("full")){
            StudentFullOutputDTO studentFullOutputDTO = modelMapper.map(student, StudentFullOutputDTO.class);
            studentFullOutputDTO.setId_person(student.getPerson().getId());
            studentFullOutputDTO.setPersonOutputDTO(modelMapper.map(student.getPerson(), PersonOutputDTO.class));


            return ResponseEntity.ok().body(studentFullOutputDTO);

        } else {
            studentOutputDTO = modelMapper.map(student, StudentOutputDTO.class);

            return ResponseEntity.ok().body(studentOutputDTO);
        }
    }

    public List<StudentOutputDTO> getStudentAll() {

        List<StudentOutputDTO> listDTO = new ArrayList<>();
        List<Student> StudentList = studentRepository.findAll();
        StudentList.forEach(p -> {
            StudentOutputDTO StudentOutputDTO = modelMapper.map(p, StudentOutputDTO.class);
            listDTO.add(StudentOutputDTO);
        });

        return listDTO;
    }


}
