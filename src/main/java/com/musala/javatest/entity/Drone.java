package com.musala.javatest.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Drone {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String serialNumber;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "model_id")
    Model model;
    private BigDecimal weight;
    private Integer batteryCapacity;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "state_id")
    State state;
}
