package com.example.bsujavaexam.controller;

import com.example.bsujavaexam.configuration.MessageConfiguration;
import com.example.bsujavaexam.entity.Issue;
import com.example.bsujavaexam.service.IssueService;
import com.example.bsujavaexam.service.ReadFileService;
import com.example.bsujavaexam.service.WriteFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.ArrayList;

@Controller
@RequestMapping("/")
public class ApplicationController {

    @Autowired
    private MessageConfiguration messageConfiguration;

    @Autowired
    private IssueService issueService;

    @Autowired
    private ReadFileService readFileService;

    @Autowired
    private WriteFileService writeFileService;

    private ArrayList<Issue> userIssues = new ArrayList<>();

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/upload")
    public String showForm(Model model) {
        model.addAttribute("modelText", messageConfiguration.getTextFileUpload());
        return "file-upload";
    }

    @PostMapping("/fresult")
    public String showResults(MultipartFile file, Model model) {

        if (file.isEmpty()) {
            model.addAttribute("modelText", messageConfiguration.getTextFileUpload());
            return "file-upload";
        }

        userIssues = new ArrayList<>();
        try {
            File tempFile = File.createTempFile("upload-", file.getOriginalFilename());
            file.transferTo(tempFile);

            ArrayList<Issue> list = readFileService.readFile(tempFile);
            for (Issue issue : list) {
                userIssues.add(issueService.solve(issue));
            }

            tempFile.delete();


        } catch (IOException e) {
            System.out.println("-> yps");
        }

        model.addAttribute("issues", userIssues);
        return "file-result";
    }




    @GetMapping("/uresult")
    public String showResults(Model model) {
        userIssues = new ArrayList<>();
        model.addAttribute("issues", userIssues);
        return "user-result";
    }

    @PostMapping("/uresult")
    public String calculate(String expression, Model model) {
        Issue issue = issueService.solve(new Issue(expression));

        userIssues.add(issue);
        model.addAttribute("issues", userIssues);
        return "user-result";
    }




    @PostMapping("/download")
    public ResponseEntity<InputStreamResource> downloadFile(@RequestParam("fileType") String fileType,
                                                            @RequestParam("fileName") String fileName) {
        try {
            // Создаём временный файл и записываем в него результат вычислений
            File tempFile = writeFileService.writeFile(fileName, fileType, userIssues);

            // Создаём поток для передачи файла
            InputStreamResource resource = new InputStreamResource(new FileInputStream(tempFile));
            String headerValue = "attachment;filename=" + fileName + "." + fileType;

            // Формируем HTTP-ответ
            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION, headerValue)
                    .contentType(MediaType.APPLICATION_OCTET_STREAM)
                    .contentLength(tempFile.length())
                    .body(resource);

        } catch (IOException exception) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }

    }


    @GetMapping("/download")
    public String download() {
        return "file-download";
    }
}
