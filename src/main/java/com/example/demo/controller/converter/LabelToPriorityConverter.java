package com.example.demo.controller.converter;

import com.example.demo.enums.Priority;
import java.util.Optional;
import org.springframework.core.convert.converter.Converter;

public class LabelToPriorityConverter implements Converter<String, Optional<Priority>> {

    @Override
    public Optional<Priority> convert(String label) {
        return Priority.findByLabel(label);
    }
}
