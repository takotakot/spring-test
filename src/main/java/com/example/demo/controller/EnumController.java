package com.example.demo.controller;

import java.util.Optional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.enums.Priority;

@RestController
@RequestMapping("/enum")
public class EnumController {
    @GetMapping
    public String getWithEnum(
            @RequestParam(value = "priority") Optional<Priority> priority) {
        if (priority.isPresent()) {
            var priorityValue = priority.get();
            System.out.println("priority: " + priorityValue + priorityValue.label);
            return "Priority is: " + priorityValue;
        }
        return "No params given.";
    }
}
