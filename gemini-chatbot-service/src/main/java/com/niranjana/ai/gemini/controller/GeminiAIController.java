package com.niranjana.ai.gemini.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.niranjana.ai.gemini.dto.ApiResponse;
import com.niranjana.ai.gemini.dto.QuestionRequest;
import com.niranjana.ai.gemini.service.QnAService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/question")
public class GeminiAIController {

    private static final Logger log = LoggerFactory.getLogger(GeminiAIController.class);

    private final QnAService qnAService;

    public GeminiAIController(QnAService qnAService) {
        this.qnAService = qnAService;
    }

    @PostMapping("/ask")
    public ResponseEntity<ApiResponse<String>> askQuestion(@Valid @RequestBody QuestionRequest request) {

        log.info("Received question: {}", request.getQuestion());

        String answer = qnAService.getAnswer(request.getQuestion());

        log.info("Response sent successfully");

        return ResponseEntity.ok(new ApiResponse<>(true, "Answer fetched successfully", answer)
        );
    }
}