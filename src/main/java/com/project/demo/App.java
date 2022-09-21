package com.project.demo;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class App {

    public static void main(String[] args) throws Exception {

        String[] springConfig  =  { "jobs/csv-to-db.xml" }; //jobs/demo-job.xml

        // Creating the application context object
        ApplicationContext context = new ClassPathXmlApplicationContext(springConfig);

        // Creating the job launcher
        JobLauncher jobLauncher = (JobLauncher) context.getBean("jobLauncher");

        // Creating the job
        Job job = (Job) context.getBean("csvToDbJob"); //demoJob

        // Executing the JOB
        JobExecution execution = jobLauncher.run(job, new JobParameters());
        System.out.println("Exit Status : " + execution.getStatus());
    }

}
