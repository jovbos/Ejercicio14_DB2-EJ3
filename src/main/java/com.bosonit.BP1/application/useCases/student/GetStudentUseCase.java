package com.bosonit.BP1.application.useCases.student;

import com.bosonit.BP1.application.exceptions.exception404.CustomErrorRequest404;
import com.bosonit.BP1.application.ports.student.GetStudentPort;
import com.bosonit.BP1.domain.entities.Student;
import com.bosonit.BP1.domain.repositories.StudentRepository;
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
    StudentRepository repository;

    public ResponseEntity<StudentOutputDTO> getStudentId(String id, String outputType) throws Exception {

        StudentFullOutputDTO studentOutputDTO = new StudentFullOutputDTO();
        Student student = repository.findById(id).orElseThrow(() -> new Exception("Student not registered."));
        if (repository.findById(id).isEmpty()) throw new CustomErrorRequest404("NOT_FOUND");
        if (outputType.equals("full")){
            studentOutputDTO = modelMapper.map(student, StudentFullOutputDTO.class);

        } else {
            studentOutputDTO.setId_student(student.getId_student());
            studentOutputDTO.setBranch(student.getBranch());
            studentOutputDTO.setComments(student.getComments());
            studentOutputDTO.setProfessor(student.getProfessor());
            studentOutputDTO.setHours_per_week(student.getHours_per_week());
        }


        return ResponseEntity.ok().body(studentOutputDTO);

    }

//    public List<StudentOutputDTO> getStudentName(String name) {
//
//        List<StudentOutputDTO> listDTO = new ArrayList<>();
//        List<Student> StudentList = repository.findByName(name);
//        StudentList.forEach(p -> {
//            StudentOutputDTO StudentOutputDTO = modelMapper.map(p, StudentOutputDTO.class);
//            listDTO.add(StudentOutputDTO);
//        });
//
//        return listDTO;
//    }
    public List<StudentOutputDTO> getStudentAll() {

        List<StudentOutputDTO> listDTO = new ArrayList<>();
        List<Student> StudentList = repository.findAll();
        StudentList.forEach(p -> {
            StudentOutputDTO StudentOutputDTO = modelMapper.map(p, StudentOutputDTO.class);
            listDTO.add(StudentOutputDTO);
        });

        return listDTO;
    }


}
