package dev.patika.fourthhomeworkapplication.model;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = PermanentInstructor.class, name = "PermanentInstructor"),
        @JsonSubTypes.Type(value = VisitingResearcher.class, name = "VisitingResearcher")
})
@Inheritance(strategy = InheritanceType.JOINED)
public class Instructor extends BaseEntity {

    private String instructorName;
    private String address;
    private String phoneNumber;

    @OneToMany(mappedBy = "instructor")
    @JsonManagedReference
    private Set<Course> Courses = new HashSet<>();

}
