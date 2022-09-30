package com.example.bonchan.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path ="topics")
public class TopicController {
    private final TopicService topicService;
    @Autowired
    public TopicController(TopicService topicService) {
        this.topicService = topicService;
    }

    @GetMapping(path = "/{forumId}")
    public Iterable<Topic> getTopicsByForumId(@PathVariable Long forumId) {
        return topicService.getTopicsByForumId(forumId);
    }

    @PostMapping(path = "/create")
    public Topic createTopic(@RequestBody Topic request) {
        return topicService.createTopic(request);
    }

    @DeleteMapping(path = "/delete/{id}")
    public void deleteTopic(@PathVariable Long id) {
        topicService.deleteTopic(id);
    }

    @PutMapping(path = "/update")
    public Topic updateTopic(@RequestBody Topic request) {
        return topicService.updateTopic(request);
    }
}
