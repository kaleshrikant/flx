package com.shrikant.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;


@Builder
@Data
@AllArgsConstructor
@Entity
@Table(name = "participant", schema = "flx_rb")
public class Participant {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String employeeId;

    private String name;
    private int age;
    private String city;
}