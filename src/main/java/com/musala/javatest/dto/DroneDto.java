package com.musala.javatest.dto;

import com.musala.javatest.entity.Model;
import com.musala.javatest.entity.State;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class DroneDto {
    private Long id;
    @NotNull
    private String serialNumber;
    @NotNull private BigDecimal weight;
    @NotNull private ModelDto model;
    @NotNull private StateDto state;
    @NotNull private Integer batteryCapacity;
}
