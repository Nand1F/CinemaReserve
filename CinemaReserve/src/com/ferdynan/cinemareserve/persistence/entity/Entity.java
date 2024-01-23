package com.ferdynan.cinemareserve.persistence.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public abstract class Entity {
    protected final UUID id;
    protected List<String> errors;

    protected Entity(UUID id ) {
        this.id = id;
        errors = new ArrayList<>();
    }

    public UUID getId() {
        return id;
    }

    public List<String> getErrors() {
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }
}