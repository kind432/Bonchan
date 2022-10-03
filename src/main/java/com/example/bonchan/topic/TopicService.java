package com.example.bonchan.topic;

import com.example.bonchan.forum.ForumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class TopicService {
    private final TopicRepository topicRepository;
    private final ForumRepository forumRepository;

    @Autowired
    public TopicService(TopicRepository topicRepository, ForumRepository forumRepository) {
        this.topicRepository = topicRepository;
        this.forumRepository = forumRepository;
    }
    public Iterable<Topic> getAllTopics() {
        return topicRepository.findAll();
    }
    public Iterable<Topic> getTopicsByForumId(Long forumId) {
        return topicRepository.findByForumId(forumId);
    }
    public Topic createTopic(Topic topic) {
        var forum = forumRepository.findById(topic.getForum().getId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR));
        return topicRepository.save(topic);
    }

    public Topic updateTopic(Topic topic) {
        var forum = forumRepository.findById(topic.getForum().getId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR));
        var top = topicRepository.findById(topic.getId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR));
        return topicRepository.save(topic);
    }

    public void deleteTopic(Long id) {
        var topic = topicRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR));
        topicRepository.deleteById(id);
    }
}
