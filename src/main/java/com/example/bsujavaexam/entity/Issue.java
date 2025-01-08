package com.example.bsujavaexam.entity;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Issue {
    private String expression;
    private double result;
    private boolean correctCalculated;
    private String errorMessage;

    public Issue(String expression) {
        this.expression = expression;
        this.result = 0.0;
        this.correctCalculated = false;
        this.errorMessage = "";
    }
}

