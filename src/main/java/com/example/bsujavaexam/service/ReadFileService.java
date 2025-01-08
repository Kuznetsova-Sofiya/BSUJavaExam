package com.example.bsujavaexam.service;

import com.example.bsujavaexam.entity.Issue;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class ReadFileService {

    public ArrayList<Issue> readFile(File file) {
        return switch (getFileType(file.getName())) {
            case "txt" -> readTxtFile(file);
            case "xml" -> readXmlFile(file);
            case "json" -> readJsonFile(file);
            case "yaml" -> readYamlFile(file);
            default -> new ArrayList<>();
        };
    }

    private String getFileType(String filename) {
        return filename.substring(filename.lastIndexOf(".") + 1);
    }

    private ArrayList<Issue> readTxtFile(File file) {
        ArrayList<Issue> issues = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                issues.add(new Issue(line.trim()));
            }
            return issues;
        } catch (IOException e) {
            return issues;
        }
    }

    private ArrayList<Issue> readXmlFile(File file) {
        XmlMapper xmlMapper = new XmlMapper();
        try {
            return xmlMapper.readValue(file, xmlMapper.getTypeFactory().constructCollectionType(List.class, Issue.class));
        } catch (IOException e) {
            return new ArrayList<>();
        }
    }

    private ArrayList<Issue> readJsonFile(File file) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(file, objectMapper.getTypeFactory().constructCollectionType(List.class, Issue.class));
        } catch (IOException e) {
            return new ArrayList<>();
        }
    }

    private ArrayList<Issue> readYamlFile(File file) {
        YAMLMapper yamlMapper = new YAMLMapper();
        try {
            return yamlMapper.readValue(file, yamlMapper.getTypeFactory().constructCollectionType(List.class, Issue.class));
        } catch (IOException e) {
            return new ArrayList<>();
        }
    }
}
