package com.example.demo.controller.converter;

import java.util.stream.Stream;
import com.example.demo.controller.EnumController;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter
public class TaskPriorityConverter implements AttributeConverter<EnumController.tPriority, String> {

    @Override
    public String convertToDatabaseColumn(EnumController.tPriority taskPriority) {
        if (taskPriority == null) {
            return null;
        }
        return taskPriority.getPriorityWord();
    }

    @Override
    public EnumController.tPriority convertToEntityAttribute(String priorityWord) {
        if (priorityWord == null) {
            return null;
        }

        return Stream.of(EnumController.tPriority.values())
                .filter(c -> c.getPriorityWord().equals(priorityWord))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
