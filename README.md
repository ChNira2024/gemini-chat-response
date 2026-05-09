# 🤖 AI QnA Chatbot Service (Spring Boot + Gemini AI + React)

## 📖 Project Overview

The AI QnA Chatbot Service is a full-stack application that integrates Google Gemini AI with a Spring Boot backend and a React frontend. It enables users to ask questions and receive intelligent AI-generated responses in real time. The system also displays token usage details for better API usage tracking and optimization.

The backend is built using Spring Boot with a clean layered architecture, while the frontend provides a simple chat-like UI for interaction.

---

## 🚀 Features

- 🤖 AI-powered question answering using Google Gemini API  
- 🌐 RESTful APIs using Spring Boot  
- ⚛️ React-based user interface  
- 📦 Clean architecture (Controller → Service → DTO)  
- ⚠️ Global exception handling  
- 📊 Token usage tracking (prompt, response, total tokens)  
- 🔐 Secure API key management using environment variables  
- 🧾 Standardized API response structure  
- 📘 Logging using SLF4J  
- 🔄 External API integration using WebClient  

---

## 🛠️ Tech Stack

### Backend
- Java 17+
- Spring Boot
- Spring Web
- WebClient
- Jackson
- SLF4J Logging

### Frontend
- React.js
- Bootstrap / CSS
- Axios / Fetch API

### External API
- Google Gemini AI

---

## 🧩 Architecture Flow

React UI → Spring Boot Controller → Service Layer → Gemini API → Response Parsing → ApiResponse DTO → Frontend UI

---

## 📡 API Endpoint

### 🔹 Ask Question

**POST** `/api/qna/ask`

### 📥 Request
```json
{
  "question": "What is Java?"
}
