package dev.patika.fourthhomeworkapplication.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class InstructorDTO {

    @ApiModelProperty("VisitingResearcher")
    private String type;
    @ApiModelProperty(example = "Mustafa")
    private String instructorName;
    @ApiModelProperty(example = "Istanbul")
    private String address;
    @ApiModelProperty(example = "5554443312")
    private String phoneNumber;
    @ApiModelProperty(example = "2000")
    private double salary;


}
