package com.ferdynan.cinemareserve.persistence.entity;

public enum AgeCategory {
    ALL_AGES("Без вікових обмежень"),
    PARENTAL_GUIDANCE("12+ та 16+ (з батьками)"),
    ADULTS_ONLY("18+");

    private final String description;

    AgeCategory(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
