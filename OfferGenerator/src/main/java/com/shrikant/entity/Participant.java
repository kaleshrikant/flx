package com.shrikant.entity;

import jakarta.persistence.*;
import lombok.*;


@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "offer", schema = "offer_db")
public class Participant {

    @Id
    private String employeeId;

    @NonNull
    private String accountName;

    // Only when : "loanStatus": "Approved"
    private Long offerId;

}