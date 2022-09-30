package com.example.bonchan.forum;

import com.example.bonchan.subcategory.SubcategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class ForumService {
    private final ForumRepository forumRepository;
    private final SubcategoryRepository subcategoryRepository;
    @Autowired
    public ForumService(ForumRepository forumRepository, SubcategoryRepository subcategoryRepository) {
        this.forumRepository = forumRepository;
        this.subcategoryRepository = subcategoryRepository;
    }

    public Iterable<Forum> getForumsBySubcategoryId(Long subcategoryId) {
        return forumRepository.findBySubcategoryId(subcategoryId);
    }

    public Forum createForum(Forum forum) {
        var subcategory = subcategoryRepository.findById(forum.getSubcategory().getId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR));
        return forumRepository.save(forum);
    }

    public Forum updateForum(Forum forum) {
        var subcategory = subcategoryRepository.findById(forum.getSubcategory().getId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR));
        var foru = forumRepository.findById(forum.getId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR));
        return forumRepository.save(forum);
    }

    public void deleteForum(Long id) {
        var foru = forumRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR));
        forumRepository.deleteById(id);
    }
}
