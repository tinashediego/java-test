package com.musala.javatest.entity;

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
@Entity
@NoArgsConstructor
@AllArgsConstructor

public class Medication {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull private Long id;
    private String name;
    private BigDecimal weight;
    private String code;
    private String imageUrl;
}
