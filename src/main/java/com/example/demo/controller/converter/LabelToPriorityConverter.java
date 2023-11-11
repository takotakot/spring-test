package com.example.demo.controller.converter;

import java.util.Optional;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import com.example.demo.enums.Priority;

@Component
public class LabelToPriorityConverter implements Converter<String, Optional<Priority>> {

    @Override
    public Optional<Priority> convert(String label) {
        return Priority.findByLabel(label);
    }
}
