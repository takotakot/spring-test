package com.example.demo.controller;

import java.util.stream.Stream;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

@RestController
@RequestMapping("/enum")
public class EnumController {
    public enum tPriority {
        HIGH("高"), MIDDLE("中"), LOW("低");

        private String priorityWord;

        private tPriority(String priorityWord) {
            this.priorityWord = priorityWord;
        }

        @JsonValue
        public String getPriorityWord() {
            return priorityWord;
        }

        @JsonCreator
        public static tPriority create(String priorityWord) {
            if (priorityWord == null) {
                return null;
            }
            return Stream.of(tPriority.values())
                    .filter(v -> priorityWord.equals(v.getPriorityWord())).findFirst()
                    .orElseThrow(() -> new IllegalArgumentException());
        }

        public void setPriorityWord(String priorityWord) {
            this.priorityWord = priorityWord;
        }

    }

    public enum tStatus {
        WAITING("未着手"), WORKING("着手"), COMPLETED("完了");

        private String statusWord;

        private tStatus(String statusWord) {
            this.statusWord = statusWord;
        }

        @JsonValue
        public String getStatusWord() {
            return statusWord;
        }

        @JsonCreator
        public static tStatus create(String statusWord) {
            if (statusWord == null) {
                return null;
            }
            return Stream.of(tStatus.values()).filter(v -> statusWord.equals(v.getStatusWord()))
                    .findFirst().orElseThrow(() -> new IllegalArgumentException());
        }

        public void setStatusWord(String statusWord) {
            this.statusWord = statusWord;
        }
    }

    // @ModelAttribute tStatus taskStatus
    // と以下コードを併用すると、取得可能
    // @ModelAttribute
    // public tStatus getStatus(
    //         @RequestParam(value = "taskStatus", required = false) String statusWord) {
    //     return tStatus.create(statusWord);
    // }

    @GetMapping
    public String getTasks(
            @RequestParam(value = "taskPriority", required = false) tPriority taskPriority,
            @RequestParam(value = "taskStatus", required = false) tStatus taskStatus
            // @ModelAttribute(name = "taskStatus", binding = false) tStatus taskStatus
            ) {
        System.out.println("taskPriority: " + taskPriority);
        System.out.println("taskStatus: " + taskStatus);
        return "OK";
    }
}
