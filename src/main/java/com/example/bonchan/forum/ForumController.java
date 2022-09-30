package com.example.bonchan.forum;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path ="forums")
public class ForumController {
    private ForumService forumService;
    @Autowired
    public ForumController(ForumService forumService) {
        this.forumService = forumService;
    }

    @GetMapping(path = "/{subcategoryId}")
    public Iterable<Forum> getForumsBySubcategoryId(@PathVariable Long subcategoryId) {
        return forumService.getForumsBySubcategoryId(subcategoryId);
    }

    @PostMapping(path = "/create")
    public Forum createForum(@RequestBody Forum request) {
        return forumService.createForum(request);
    }

    @PutMapping(path = "/update")
    public Forum updateForum(@RequestBody Forum request){
        return forumService.updateForum(request);
    }

    @DeleteMapping(path = "/delete/{id}")
    public void deleteForum(@PathVariable Long id) {
        forumService.deleteForum(id);
    }

}
