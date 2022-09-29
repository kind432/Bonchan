package com.example.bonchan.theme;

import com.example.bonchan.theme.models.Theme;
import com.example.bonchan.topic.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class ThemeService {
    private final ThemeRepository themeRepository;
    private final TopicRepository topicRepository;

    @Autowired
    public ThemeService(ThemeRepository themeRepository, TopicRepository topicRepository) {
        this.themeRepository = themeRepository;
        this.topicRepository = topicRepository;
    }

    public Iterable<Theme> getThemesByTopicId(Long topicId) {
        return themeRepository.findByTopicId(topicId);
    }

    public Theme createTheme(Theme theme) {
        var topic = topicRepository.findById(theme.getTopic().getId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR));
        return themeRepository.save(theme);
    }

    public Theme updateTheme(Theme theme) {
        var topic = topicRepository.findById(theme.getTopic().getId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR));
        var them = themeRepository.findById(theme.getId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR));
        return themeRepository.save(theme);
    }

    public void deleteTheme(Long id) {
        var theme = themeRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR));
        themeRepository.deleteById(id);
    }
}
