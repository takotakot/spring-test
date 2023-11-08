package com.example.demo.controller.converter;

import com.example.demo.controller.EnumController;
import org.springframework.core.convert.converter.Converter;

public class TaskPriorityParamConverter implements Converter<String, EnumController.tPriority> {

    @Override
    public EnumController.tPriority convert(String priorityWord) {
        // Below throws IllegalArgumentException
        return EnumController.tPriority.create(priorityWord);
    }
}
