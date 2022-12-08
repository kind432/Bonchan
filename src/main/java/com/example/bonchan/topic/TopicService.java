package com.example.bonchan.topic;

import com.example.bonchan.forum.ForumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class TopicService {
    private final TopicRepository topicRepository;
    private final ForumRepository forumRepository;

    @Autowired
    public TopicService(TopicRepository topicRepository, ForumRepository forumRepository) {
        this.topicRepository = topicRepository;
        this.forumRepository = forumRepository;
    }
    public Iterable<Topic> GetAllTopics() {
        return topicRepository.findAll();
    }
    public Iterable<Topic> GetTopicsByForumId(Long forumId) {
        return topicRepository.findByForumId(forumId);
    }
    public Topic CreateTopic(Topic topic) {
        forumRepository.findById(topic.getForum().getId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR));
        return topicRepository.save(topic);
    }

    public Optional<Topic> GetTopicById(Long id) {
        return topicRepository.findById(id);
    }

    public Topic UpdateTopic(Topic topic) {
        forumRepository.findById(topic.getForum().getId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR));
        topicRepository.findById(topic.getId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR));
        return topicRepository.save(topic);
    }

    public void DeleteTopic(Long id) {
        topicRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR));
        topicRepository.deleteById(id);
    }
}
