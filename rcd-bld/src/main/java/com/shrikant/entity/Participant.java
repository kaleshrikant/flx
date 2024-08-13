package com.shrikant.entity;

import jakarta.persistence.*;
import lombok.*;


@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "participant", schema = "flx_rb")
public class Participant {

    @Id
    private String employeeId;

    @NonNull
    private String name;

    @NonNull
    private int age;

    @NonNull
    private String city;
}