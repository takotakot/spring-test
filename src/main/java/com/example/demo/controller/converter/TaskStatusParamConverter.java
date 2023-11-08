package com.example.demo.controller.converter;

import com.example.demo.controller.EnumController;
import org.springframework.core.convert.converter.Converter;

public class TaskStatusParamConverter implements Converter<String, EnumController.tStatus> {

    @Override
    public EnumController.tStatus convert(String statusWord) {
        // Below throws IllegalArgumentException
        return EnumController.tStatus.create(statusWord);
    }
}
