package com.example.bsujavaexam.console;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;
import com.example.bsujavaexam.entity.Issue;

public class ConsoleIssueService {

    public Issue solve(Issue issue){
        try {
            Expression expression = new ExpressionBuilder(issue.getExpression()).build();
            double result = expression.evaluate();
            issue.setResult(result);
            issue.setCorrectCalculated(true);
            issue.setErrorMessage("нет ошибки");


        } catch (IllegalArgumentException | ArithmeticException e) {
            issue.setCorrectCalculated(false);
            issue.setErrorMessage(e.getMessage());
        }

        return issue;
    }
}
