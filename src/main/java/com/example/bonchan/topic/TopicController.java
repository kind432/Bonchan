package com.example.bonchan.topic;

import com.example.bonchan.topic.models.Topic;
import com.example.bonchan.topic.models.TopicsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path ="topics")
public class TopicController {
    private TopicService topicService;
    @Autowired
    public TopicController(TopicService topicService) {
        this.topicService = topicService;
    }

    @GetMapping(path = "/{categoryId}")
    public TopicsResponse getTopicsByCategoryId(@PathVariable Long categoryId) {
        return new TopicsResponse(topicService.getTopicsByCategoryId(categoryId));
    }

    @PostMapping(path = "/create")
    public Topic createTopic(@RequestBody Topic request) {
        return topicService.createTopic(request);
    }

    @PutMapping(path = "/update")
    public Topic updateTopic(@RequestBody Topic request){
        return topicService.updateTopic(request);
    }

    @DeleteMapping(path = "/delete/{id}")
    public void deleteTopic(@PathVariable Long id) {
        topicService.deleteTopic(id);
    }

}
