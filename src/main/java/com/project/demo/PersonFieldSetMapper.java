package com.project.demo;

import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;

public class PersonFieldSetMapper implements FieldSetMapper<Person> {

    @Override
    public Person mapFieldSet(FieldSet fieldSet) throws BindException {

        //Instantiating the report object
        Person person = new Person();

        //Setting the fields
        person.setId(fieldSet.readInt(0));
        person.setName(fieldSet.readString(1));
        person.setAge(fieldSet.readInt(2));

        return person;
    }
}
