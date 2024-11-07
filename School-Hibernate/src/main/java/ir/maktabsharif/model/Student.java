package ir.maktabsharif.model;


import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "students")
public class Student extends BaseModel {

    @Column(name = "first_name")
    public String firstname;
    @Column(name = "last_name")
    public String lastname;
    @Column(name = "national_code", unique = true)
    private String nationalCode;

    @ManyToMany
    @JoinTable(
            name = "j_student_exam",
            joinColumns = {@JoinColumn(name = "fk_student")},
            inverseJoinColumns = {@JoinColumn(name = "fk_exam")}
    )
    private List<Exam> exams = new ArrayList<>();


    @ManyToMany
    @JoinTable(
            name = "j_student_course"
            , joinColumns = {@JoinColumn(name = "fk_student")},
            inverseJoinColumns = {@JoinColumn(name = "fk_course")}
    )
    private List<Course> courses = new ArrayList<>();


}
