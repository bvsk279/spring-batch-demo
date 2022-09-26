package com.project.demo;

import org.apache.solr.client.solrj.beans.Field;
import org.springframework.stereotype.Component;

@Component
public class Person {
    @Field
    private int id;

    @Field
    private String name;

    @Field
    private int age;

    public int getId() {
        return id;
    }

    @Field("id")
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    @Field("name")
    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    @Field("age")
    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return id + "," + name + "," + age;
    }
}
