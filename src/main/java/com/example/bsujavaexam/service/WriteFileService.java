package com.example.bsujavaexam.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import org.example.bsujavafinalproject.entity.Issue;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

@Service
public class WriteFileService {
    public File writeFile(String fileName, String fileType, ArrayList<Issue> content) throws IOException {
        File file = switch (fileType.toLowerCase()) {
            case "txt" -> writeTxtFile(fileName, content);
            case "xml" -> writeXmlFile(fileName, content);
            case "json" -> writeJsonFile(fileName, content);
            case "yaml" -> writeYamlFile(fileName, content);
            default -> throw new IllegalArgumentException("Unsupported file type: " + fileType);
        };

        return file;
    }

    private File writeTxtFile(String fileName, ArrayList<Issue> content) throws IOException {
        File file = File.createTempFile(fileName, ".txt");
        try (FileWriter writer = new FileWriter(file)) {
            for (Issue issue : content) {
                writer.write(issue.toString() + "\n");
            }
        }
        return file;
    }

    private File writeXmlFile(String fileName, ArrayList<Issue> content) throws IOException {
        File file = File.createTempFile(fileName, ".xml");
        XmlMapper xmlMapper = new XmlMapper();
        xmlMapper.writeValue(file, content);
        return file;
    }

    private File writeJsonFile(String fileName, ArrayList<Issue> content) throws IOException {
        File file = File.createTempFile(fileName, ".json");
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(file, content);
        return file;
    }

    private File writeYamlFile(String fileName, ArrayList<Issue> content) throws IOException {
        File file = File.createTempFile(fileName, ".yaml");
        ObjectMapper yamlMapper = new ObjectMapper(new YAMLFactory());
        yamlMapper.writeValue(file, content);
        return file;
    }
}
