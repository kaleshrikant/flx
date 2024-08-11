package com.shrikant.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Data
@AllArgsConstructor
@Document("rate")
public class Rate {

    private String loanStatus;
    private double loanRate;
}
