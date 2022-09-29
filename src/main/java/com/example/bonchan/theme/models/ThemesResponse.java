package com.example.bonchan.theme.models;

public class ThemesResponse {
    private Iterable<Theme> themes;

    public ThemesResponse(Iterable<Theme> themes) {
        this.themes = themes;
    }

    public Iterable<Theme> getThemes() {
        return themes;
    }

    public void setThemes(Iterable<Theme> themes) {
        this.themes = themes;
    }
}
