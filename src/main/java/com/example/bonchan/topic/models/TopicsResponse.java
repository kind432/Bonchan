package com.example.bonchan.topic.models;


public class TopicsResponse {
    private Iterable<Topic> topics;

    public TopicsResponse(Iterable<Topic> topics) {
        this.topics = topics;
    }

    public Iterable<Topic> getTopics() {
        return topics;
    }

    public void setTopics(Iterable<Topic> topics) {
        this.topics = topics;
    }
}
