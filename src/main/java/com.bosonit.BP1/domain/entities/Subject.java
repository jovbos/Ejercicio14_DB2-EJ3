package com.bosonit.BP1.domain.entities;

import com.bosonit.BP1.application.stringgenerator.StringPrefixedSequenceIdGenerator;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.ws.rs.ext.ParamConverter;
import java.util.Date;

@Entity
@Table(name = "Subjects")
@Data
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "subjectIdGen")
    @GenericGenerator(
            name = "subjectIdGen",
            strategy = "com.bosonit.BP1.application.stringgenerator.StringPrefixedSequenceIdGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "1"),
                    @org.hibernate.annotations.Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value =
                            "AUS"),
                    @org.hibernate.annotations.Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value =
                            "%08d")
            })
    @Column(name = "Id_subject")
    private String id_subject;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Id_student")
    private Student student;

    @Column(name = "Name_subject")
    private String name;

    @Column(name = "Comments")
    private String comments;

    @Column(name = "Initial_ate")
    private Date initial_date;

    @Column(name = "Finish_date")
    private Date finish_date;

}
