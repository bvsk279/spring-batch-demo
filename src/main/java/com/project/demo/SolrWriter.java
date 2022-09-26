package com.project.demo;

import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.core.StepExecutionListener;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.UpdateResponse;
import org.apache.http.client.HttpClient;
import java.util.List;


public class SolrWriter implements ItemWriter<Person>,StepExecutionListener {
    private String collection;
    private HttpSolrClient solrClient;
    private String solrUrl;

    public void setCollection(String collection) {
        this.collection = collection;
    }

    public void setSolrClient(HttpSolrClient solrClient) {
        this.solrClient = solrClient;
    }

    public void setSolrUrl(String solrUrl) {
        this.solrUrl = solrUrl;
    }

    public HttpClient client;

    public HttpClient getSolrClient(){
        return solrClient.Builder(solrUrl)
                .withConnectionTimeout(10000)
                .withSocketTimeout(60000)
                .build();
    }

    @Override
    public void beforeStep(StepExecution stepExecution){
        System.out.println("before step:"+ Integer.toString(stepExecution.getCommitCount()));
    }

    public void write(List<? extends Person> people){
        for(Person p: people){
            System.out.println(p.getAge());
            try {
                UpdateResponse response = solrClient.addBean(collection, p);
                solrClient.commit(collection);
            }
            catch(Exception e){
                System.out.println(e);
            }
        }
    }

    @Override
    public ExitStatus afterStep(StepExecution stepExecution){
        System.out.println("after step:"+ Integer.toString(stepExecution.getCommitCount()));
        return null;
    }
//
//    SolrWriter(String collection, String solrUrl){
//        this.collection = collection;
//        this.solrUrl = solrUrl;
//
//    }
}
