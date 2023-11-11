package com.example.demo.enums;

public enum Priority {
    HIGH("高"), MIDDLE("中"), LOW("低");

    public final String label;

    private Priority(String label) {
        this.label = label;
    }
}
