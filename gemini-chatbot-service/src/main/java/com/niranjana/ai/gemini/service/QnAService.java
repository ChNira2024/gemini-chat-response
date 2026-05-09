package com.niranjana.ai.gemini.service;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.niranjana.ai.gemini.exception.GeminiApiException;

@Service
public class QnAService {

    private static final Logger log = LoggerFactory.getLogger(QnAService.class);

    @Value("${gemini.api.base-url}")
    private String geminiApiBaseUrl;

    @Value("${gemini.api.key}")
    private String geminiApiKey;
    
    @Value("${gemini.api.model}")
    private String geminiApiModel;

    private final WebClient webClient;
    private final ObjectMapper objectMapper = new ObjectMapper();

    public QnAService(WebClient.Builder builder) {
        this.webClient = builder.build();
    }

    public String getAnswer(String question) {
        log.info("Received question: {}", question);

        String prompt = buildPrompt(question);

        try {
            Map<String, Object> requestBody = Map.of(
                    "contents", new Object[]{
                            Map.of("parts", new Object[]{
                                    Map.of("text", prompt)
                            })
                    }
            );
            String response = webClient.post()
            		.uri(geminiApiBaseUrl + "/" + geminiApiModel + ":generateContent?key=" + geminiApiKey)
                    .header("Content-Type", "application/json")
                    .bodyValue(requestBody)
                    .retrieve()
                    .bodyToMono(String.class)
                    .block();
            
            log.debug("Full Gemini API Response: {}", response);

            String parsedResponse = extractResponseContent(response);

            log.info("Generated parsedResponse: {}", parsedResponse);

            return parsedResponse;

        } catch (Exception ex) {
            log.error("Error while calling Gemini API", ex);
            throw new GeminiApiException("Failed to get response from AI service");
        }
    }

    private String extractResponseContent(String response) {
        try {
            JsonNode rootNode = objectMapper.readTree(response);

            JsonNode textNode = rootNode.path("candidates")
                    .path(0)
                    .path("content")
                    .path("parts")
                    .path(0)
                    .path("text");

            if (textNode.isMissingNode() || textNode.asText().trim().isEmpty()) {
                log.error("Invalid Gemini response: {}", response);
                throw new GeminiApiException("Invalid response from AI");
            }

            return textNode.asText().trim();

        } catch (Exception e) {
            log.error("Error parsing Gemini response", e);
            throw new GeminiApiException("Error parsing AI response");
        }
    }

    private String buildPrompt(String question) {
        return "Answer the following question clearly and concisely:\n\n" + question;
    }
}