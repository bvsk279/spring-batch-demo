package com.project.demo.other;

import com.project.demo.Person;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.item.ItemStreamException;
import org.springframework.batch.item.file.MultiResourceItemReader;
import org.springframework.batch.item.support.AbstractItemStreamItemReader;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

import org.apache.commons.csv.CSVRecord;
import org.apache.commons.csv.CSVFormat;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.io.FileReader;

public class Reader{

    final String filePath;

    public ArrayList<Person> readExcel() throws IOException {
        FileReader in = new FileReader(filePath);
        Iterable<CSVRecord> records = CSVFormat.RFC4180.withFirstRecordAsHeader().parse(in);
        ArrayList<Person> persons = new ArrayList<Person>();
        for (CSVRecord record : records) {
            Person p = new Person();
            p.setId(Integer.parseInt(record.get("id")));
            p.setName(record.get("name"));
            p.setAge(Integer.parseInt(record.get("age")));

            persons.add(p);
        }
        return persons;
    }

    Reader(String readerFilePath){
        this.filePath = readerFilePath;
    }
}
