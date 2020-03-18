package com.springdemo.annotations;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class FileFortuneService implements FortuneService {

    private String fortunesFile = "D:/fortunes.txt";
    private List<String> theFortunes;
    private Random random = new Random();

    public FileFortuneService() {
        System.out.println("FileFortune default constructor");
    }

    @PostConstruct
    private void loadFortunesFromFile() {
        System.out.println("Loading the file...");
        File theFile = new File(fortunesFile);

        System.out.println("Reading fortunes from file: " + theFile);
        System.out.println("File exists: " + theFile.exists());

        theFortunes = new ArrayList<String>();

        // read fortunes from file
        try (BufferedReader br = new BufferedReader(new FileReader(theFile))) {
            String templine;

            while ((templine = br.readLine()) != null) {
                theFortunes.add(templine);
                System.out.println("Adding the fortune to array...");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getFortune() {
        int index = random.nextInt(theFortunes.size());
        return theFortunes.get(index);
    }
}
