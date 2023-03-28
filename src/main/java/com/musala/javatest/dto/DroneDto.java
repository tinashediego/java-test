package com.musala.javatest.dto;

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
    @NotNull private Long modelId;
    @NotNull private Long stateId;
    @NotNull private Integer batteryCapacity;
}
