package com.shrikant.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ParticipantDTO implements Serializable {

    private String employeeId;
    private String name;
    private int age;
    private String city;

}
