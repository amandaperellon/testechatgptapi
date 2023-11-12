package com.example.demo;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
class ChatGpt {

    private @Id @GeneratedValue Long id;
    private String message;
    private String prompt;
    

    ChatGpt(String message, String prompt) {

        this.message = message;
        this.prompt = prompt;
    }

    public ChatGpt() {
        
    }

    public Long getId() {
        return this.id;
    }

    public String getMessage() {
        return this.message;
    }

    public String getPrompt() {
        return this.prompt;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setPrompt(String prompt) {
        this.prompt = prompt;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.message, this.prompt);
    }

    @Override
    public String toString() {
        return "ChatGpt{" + "id=" + this.id + ", message='" + this.message + '\'' + ", prompt='" + this.prompt + '\'' + '}';
    }
    
}