package com.ggingmin.postgres.model;

public enum StudentType {

    GRADUATE("Graduate"),
    UNDERGRADUATE("Undergraduate"),
    EXCHANGE("Exchange");

    private final String displayName;

    StudentType(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
