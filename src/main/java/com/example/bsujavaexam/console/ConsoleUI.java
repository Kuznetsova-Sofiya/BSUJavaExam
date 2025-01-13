package com.example.bsujavaexam.console;

import com.example.bsujavaexam.entity.Issue;
import java.util.Scanner;


public class ConsoleUI {

    public static void main(String[] args) {
        ConsoleUI consoleUi = new ConsoleUI();
        consoleUi.work();
    }

    public void work(){
        ConsoleIssueService consoleIssueService = new ConsoleIssueService();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите математическое выражение или 'exit' для выхода:");

        while (true) {
            System.out.print(">>> ");
            String input = scanner.nextLine();

            if ("exit".equalsIgnoreCase(input.trim())) {
                System.out.println("Выход из программы.");
                break;
            }

            Issue issue = new Issue(input);
            System.out.println("Вычисленное выражение:");
            System.out.println(consoleIssueService.solve(issue));
        }

        scanner.close();
    }


}
