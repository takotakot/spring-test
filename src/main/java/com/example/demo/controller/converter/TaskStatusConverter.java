package com.example.demo.controller.converter;

import com.example.demo.controller.EnumController;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.stream.Stream;

@Converter(autoApply = true)
public class TaskStatusConverter implements AttributeConverter<EnumController.tStatus, String> {

    @Override
    public String convertToDatabaseColumn(EnumController.tStatus taskStatus) {
        if (taskStatus == null) {
            return null;
        }
        return taskStatus.getStatusWord();
    }

    @Override
    public EnumController.tStatus convertToEntityAttribute(String statusWord) {
        if (statusWord == null) {
            return null;
        }

        return Stream.of(EnumController.tStatus.values())
                .filter(c -> c.getStatusWord().equals(statusWord))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
