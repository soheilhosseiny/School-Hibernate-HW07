package ir.maktabsharif.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Teacher extends BaseModel {

    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "national_code", unique = true)
    private String nationalCode;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @Embedded
    private Address address;
//    private Date dob;
//    private String country;
//    private String city;
//    private String street;
//    private String zipCode;

    @OneToOne
    @JoinColumn(name = "fk_course")
    private Course course;
}
