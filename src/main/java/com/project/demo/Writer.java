package com.project.demo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Writer {
    private String fileName;

    public void createFile(String filePath) {
        SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
        String timeStamp = date.format(new Date());
        this.fileName = filePath + "processed_" + timeStamp + ".txt";
        try {
            File f = new File(fileName);
            if (f.createNewFile()) {
                System.out.println("File created: " + f.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void write(ArrayList<String> names) {
        try {
            FileWriter fw = new FileWriter(fileName);
            for (String name : names) {
                fw.write(name + "\n");
            }
            fw.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}
