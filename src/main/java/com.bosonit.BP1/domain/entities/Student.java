package com.bosonit.BP1.domain.entities;

import org.hibernate.annotations.Parameter;
import com.bosonit.BP1.application.stringgenerator.StringPrefixedSequenceIdGenerator;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name="Students")
@Data
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "studentIdGen")
    @GenericGenerator(
            name = "studentIdGen",
            strategy = "com.bosonit.BP1.application.stringgenerator.StringPrefixedSequenceIdGenerator",
            parameters = {
                    @Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "1"),
                    @Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value =
                            "AUS"),
                    @Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value =
                            "%08d")
            })
    @Column(name = "Id_student")
    private String id_student;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Id_assignment")
    private Assignment assignment;

    @Column(name = "Hours_per_week")
    private Integer hours_per_week;

    @Column(name = "Coments")
    private String comments;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Id_professor")
    private Professor professor;

    @Column(name = "rama")
    private String branch;

//    @OneToMany
//    private List<Subject> subjects;
}
