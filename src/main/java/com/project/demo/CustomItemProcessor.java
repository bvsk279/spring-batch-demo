package com.project.demo;

import org.springframework.batch.item.ItemProcessor;

import java.util.Locale;

// Implementing the ItemProcessor interface
public class CustomItemProcessor implements ItemProcessor<Person, Person> {

    @Override
    public Person process(Person item) throws Exception {
        item.setName(item.getName().toUpperCase());
        System.out.println("Processing..." + item);
        return item;
    }
}
