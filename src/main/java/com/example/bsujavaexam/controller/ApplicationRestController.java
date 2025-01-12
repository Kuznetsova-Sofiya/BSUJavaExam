package com.example.bsujavaexam.controller;

import io.swagger.v3.oas.annotations.Operation;

import com.example.bsujavaexam.entity.Issue;
import com.example.bsujavaexam.service.IssueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/solve")
public class ApplicationRestController {

    @Autowired
    private IssueService issueService;

    @Operation(summary = "Позволяет вычислить 1 выражение")
    @PostMapping("/one")
    public ResponseEntity<Issue> solveExpression(@RequestBody Issue issue) {
        Issue solvedIssue = issueService.solve(issue);
        return ResponseEntity.ok(solvedIssue);
    }
    @Operation(summary = "Позволяет вычислить коллекцию выражений")
    @PostMapping("/much")
    public ResponseEntity<ArrayList<Issue>> solveExpressions(@RequestBody ArrayList<Issue> issues) {
        ArrayList<Issue> results = new ArrayList<>();
        for (Issue issue : issues) {
            results.add(issueService.solve(issue));
        }
        return ResponseEntity.ok(results);
    }
}

/*
http://localhost:8080/api/solve/one
POST

в raw
{
  "expression": "2 + 2 * 3"
}



http://localhost:8080/api/solve/much
POST

в raw
[
  { "expression": "2 + 2 * 3" },
  { "expression": "(5 + 3) / 2" },
  { "expression": "10 / 0" },
  { "expression": "5!" }
]


http://localhost:8080/swagger-ui.html

Postman
 */