package com.example.bonchan.theme;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path ="themes")
public class ThemeController {
    private final ThemeService themeService;
    @Autowired
    public ThemeController(ThemeService themeService) {
        this.themeService = themeService;
    }

    @GetMapping(path = "/{topicId}")
    public Iterable<Theme> getThemesByTopicId(@PathVariable Long topicId) {
        return themeService.getThemesByTopicId(topicId);
    }

    @PostMapping(path = "/create")
    public Theme createTheme(@RequestBody Theme request) {
        return themeService.createTheme(request);
    }

    @DeleteMapping(path = "/delete/{id}")
    public void deleteTheme(@PathVariable Long id) {
        themeService.deleteTheme(id);
    }

    @PutMapping(path = "/update")
    public Theme updateTheme(@RequestBody Theme request) {
        return themeService.updateTheme(request);
    }
}
