package com.project.demo.other;

import com.project.demo.Person;
import com.project.demo.Writer;

import java.io.IOException;
import java.util.ArrayList;

public class JobApp {
    public static void main(String[] args) {
        String readerFile = "D:/Learnings/course-api/src/main/resources/files/names.csv";
        String writerFilePath = "D:/Learnings/course-api/src/main/resources/files/";

        Reader r = new Reader(readerFile);
        Processor p = new Processor();
        Writer w = new Writer();

        ArrayList<String> names = new ArrayList();

        try{
            ArrayList<Person> persons = r.readExcel();
            for(Person person: persons){
                String name = p.process(person.getName());
                names.add(name);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        //Writer
        w.createFile(writerFilePath);
        w.write(names);
    }
}
