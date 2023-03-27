package com.musala.javatest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class MedicationDto {

    private Long id;
    @NotNull private String name;
    @NotNull private BigDecimal weight;
    @NotNull private String code;
    @NotNull private String imageUrl;

}
