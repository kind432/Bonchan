package com.example.bonchan.topic;

import com.example.bonchan.category.CategoryRepository;
import com.example.bonchan.topic.models.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class TopicService {
    private final TopicRepository topicRepository;
    private final CategoryRepository categoryRepository;
    @Autowired
    public TopicService(TopicRepository topicRepository, CategoryRepository categoryRepository) {
        this.topicRepository = topicRepository;
        this.categoryRepository = categoryRepository;
    }

    public Iterable<Topic> getTopicsByCategoryId(Long categoryId) {
        return topicRepository.findByCategoryId(categoryId);
    }

    public Topic createTopic(Topic topic) {
        var category = categoryRepository.findById(topic.getCategory().getId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR));
        return topicRepository.save(topic);
    }

    public Topic updateTopic(Topic topic) {
        var category = categoryRepository.findById(topic.getCategory().getId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR));
        var top = topicRepository.findById(topic.getId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR));
        return topicRepository.save(topic);
    }

    public void deleteTopic(Long id) {
        var top = topicRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR));
        topicRepository.deleteById(id);
    }
}
