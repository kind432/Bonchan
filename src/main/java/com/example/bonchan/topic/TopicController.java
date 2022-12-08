package com.example.bonchan.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path ="topics")
public class TopicController {
    private final TopicService topicService;
    @Autowired
    public TopicController(TopicService topicService) {
        this.topicService = topicService;
    }

    @GetMapping(path = "/")
    public Iterable<Topic> GetAllTopics() {
        return topicService.GetAllTopics();
    }
    @GetMapping(path = "/{forumId}")
    public Iterable<Topic> GetTopicsByForumId(@PathVariable Long forumId) {
        return topicService.GetTopicsByForumId(forumId);
    }

    @GetMapping(path = "/getById/{id}")
    public Optional<Topic> GetTopicId(@PathVariable Long id) {
        return topicService.GetTopicById(id);
    }

    @PostMapping(path = "/create")
    public Topic CreateTopic(@RequestBody Topic request) {
        return topicService.CreateTopic(request);
    }

    @DeleteMapping(path = "/delete/{id}")
    public void DeleteTopic(@PathVariable Long id) {
        topicService.DeleteTopic(id);
    }

    @PutMapping(path = "/update")
    public Topic UpdateTopic(@RequestBody Topic request) {
        return topicService.UpdateTopic(request);
    }
}
