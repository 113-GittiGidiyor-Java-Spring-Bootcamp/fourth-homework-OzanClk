package dev.patika.fourthhomeworkapplication.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import dev.patika.fourthhomeworkapplication.model.enumeration.Gender;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.time.LocalDate;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDTO {

    @ApiModelProperty(example = "Mustafa")
    private String name;

    @ApiModelProperty(example = "Istanbul")
    private String address;

    @ApiModelProperty(required = true, example = "01-01-2016")
    @JsonFormat(pattern = "dd-MM-yyyy", shape = JsonFormat.Shape.STRING)
    private LocalDate birthDate;

    @Enumerated(EnumType.STRING)
    private Gender gender;


}
