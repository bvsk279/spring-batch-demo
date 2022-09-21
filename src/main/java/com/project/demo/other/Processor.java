package com.project.demo.other;

import org.springframework.batch.item.ItemProcessor;

public class Processor {
    public String process(String name){
        return name.toUpperCase();
    }
}
