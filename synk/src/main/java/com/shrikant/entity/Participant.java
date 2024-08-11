package com.shrikant.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Builder
@Data
@AllArgsConstructor
@Document("participant")
public class Participant {

    private String employeeId;
    private String name;
    private int age;
    private int creditScore;
    private long annualSalary;
    private long existingDebt;
    private long loanAmount;

    private Rate rate;

    private Long offerId;
}