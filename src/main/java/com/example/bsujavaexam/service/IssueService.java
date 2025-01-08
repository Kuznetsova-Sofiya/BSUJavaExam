package com.example.bsujavaexam.service;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;
import org.example.bsujavafinalproject.configuration.MessageConfiguration;
import org.example.bsujavafinalproject.entity.Issue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IssueService {

    @Autowired
    private MessageConfiguration message;

    public Issue solve(Issue issue){
        try {
            Expression expression = new ExpressionBuilder(issue.getExpression()).build();
            double result = expression.evaluate();
            issue.setResult(result);
            issue.setCorrectCalculated(true);
            issue.setErrorMessage(message.getNoErrors());


        } catch (IllegalArgumentException | ArithmeticException e) {
            issue.setCorrectCalculated(false);
            issue.setErrorMessage(e.getMessage());
        }

        return issue;
    }
}
