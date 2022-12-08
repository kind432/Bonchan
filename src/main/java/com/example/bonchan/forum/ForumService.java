package com.example.bonchan.forum;

import com.example.bonchan.subcategory.SubcategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class ForumService {
    private final ForumRepository forumRepository;
    private final SubcategoryRepository subcategoryRepository;
    @Autowired
    public ForumService(ForumRepository forumRepository, SubcategoryRepository subcategoryRepository) {
        this.forumRepository = forumRepository;
        this.subcategoryRepository = subcategoryRepository;
    }

    public Optional<Forum> getForumById(Long forumId) {
        forumRepository.findById(forumId).orElseThrow(() -> new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR));
        return forumRepository.findById(forumId);
    }

    public Iterable<Forum> getForumsBySubcategoryId(Long subcategoryId) {
        return forumRepository.findBySubcategoryId(subcategoryId);
    }

    public Forum createForum(Forum forum) {
        subcategoryRepository.findById(forum.getSubcategory().getId()).orElseThrow(() -> new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR));
        return forumRepository.save(forum);
    }

    public Forum updateForum(Forum forum) {
        subcategoryRepository.findById(forum.getSubcategory().getId()).orElseThrow(() -> new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR));
        forumRepository.findById(forum.getId()).orElseThrow(() -> new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR));
        return forumRepository.save(forum);
    }

    public void deleteForum(Long id) {
        forumRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR));
        forumRepository.deleteById(id);
    }
}
