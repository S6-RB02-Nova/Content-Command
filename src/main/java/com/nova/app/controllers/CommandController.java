package com.nova.app.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.nova.app.models.Content;
import com.nova.app.rabbitmq.ContentJsonProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/command")
@RequiredArgsConstructor
public class CommandController {

    private final ContentJsonProducer contentJsonProducer;

    @PostMapping("/post/create")
    public ResponseEntity<?> createPost(@RequestBody Content content) throws JsonProcessingException {
        content.setContentTimeStamp(LocalDate.now());
        contentJsonProducer.sendMessage(content);
        return ResponseEntity.ok().build();
    }
}
