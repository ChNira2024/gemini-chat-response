package com.niranjana.ai.gemini.dto;


import jakarta.validation.constraints.NotBlank;

public class QuestionRequest {

    @NotBlank(message = "Question cannot be empty")
    private String question;

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public QuestionRequest(@NotBlank(message = "Question cannot be empty") String question) {
		super();
		this.question = question;
	}

	public QuestionRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "QuestionRequest [question=" + question + "]";
	}
    
    
}