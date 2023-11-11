package com.example.demo.enums;

import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Priority {
    HIGH("高"), MIDDLE("中"), LOW("低");

    // public static final Set<Priority> ALL_TYPES = Stream.of(Priority.values()).collect(Collectors.toSet());
    public static final Map<String, Priority> PRIORITY_LABEL_MAP = Stream.of(Priority.values()).collect(Collectors.toMap(t -> t.label, t -> t));

    public final String label;

    private Priority(String label) {
        this.label = label;
    }

    public static Optional<Priority> findByLabel(String label) {
        return Optional.ofNullable(PRIORITY_LABEL_MAP.get(label));
    }
}
