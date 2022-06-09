package com.bosonit.BP1.application.useCases.subject;

import com.bosonit.BP1.application.exceptions.exception404.CustomErrorRequest404;
import com.bosonit.BP1.application.exceptions.exception422.CustomErrorRequest422;
import com.bosonit.BP1.application.ports.subject.CreateSubjectPort;
import com.bosonit.BP1.domain.entities.Student;
import com.bosonit.BP1.domain.entities.Subject;
import com.bosonit.BP1.domain.repositories.StudentRepository;
import com.bosonit.BP1.domain.repositories.SubjectRepository;
import com.bosonit.BP1.infracstructure.dtos.subject.SubjectInputDTO;
import com.bosonit.BP1.infracstructure.dtos.subject.SubjectOutputDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class CreateSubjectUseCase implements CreateSubjectPort {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    SubjectRepository repository;

    @Autowired
    StudentRepository studentRepository;

    public SubjectOutputDTO addSubject(SubjectInputDTO subjectDTO){

        Optional<Student> student =  studentRepository.findById(subjectDTO.getId_student());
        Subject subject = modelMapper.map(subjectDTO, Subject.class);

        if (student.isEmpty()) throw new CustomErrorRequest404("STUDENT NOT FOUND");
        if (subject.getInitial_date() == null)
        throw new CustomErrorRequest422("UNPROCCESABLE_ENTITY");

        subject.setStudent(student.get());
        repository.save(subject);
        SubjectOutputDTO subjectOutputDTO = modelMapper.map(subjectDTO, SubjectOutputDTO.class);
        subjectOutputDTO.setId_subject(subject.getId_subject());

        return subjectOutputDTO;
    }
}
