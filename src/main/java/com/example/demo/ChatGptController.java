package com.example.demo;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
class ChatGptController {

    private final ChatGptRepository repository;

    ChatGptController(ChatGptRepository repository) {
        this.repository = repository;
    }


    // Aggregate root
    // tag::get-aggregate-root[]
    @GetMapping("/chatgpt")
    List<ChatGpt> all() {
        return repository.findAll();
    }
    // end::get-aggregate-root[]

    @PostMapping("/chatgpt")
    ChatGpt newChatGpt(@RequestBody ChatGpt newChatGpt) {
        return repository.save(newChatGpt);
    }

    // Single item

    @GetMapping("/chatgpt/{id}")
    ChatGpt one(@PathVariable Long id) {

        return repository.findById(id)
                .orElseThrow();
    }

    @PutMapping("/chatgpt/{id}")
    ChatGpt replaceEmployee(@RequestBody ChatGpt newChatGpt, @PathVariable Long id) {

        return repository.findById(id)
                .map(chatGpt -> {
                    chatGpt.setMessage(newChatGpt.getMessage());
                    chatGpt.setPrompt(newChatGpt.getPrompt());
                    return repository.save(chatGpt);
                })
                .orElseGet(() -> {
                    newChatGpt.setId(id);
                    return repository.save(newChatGpt);
                });
    }

    @DeleteMapping("/chatgpt/{id}")
    void deleteEmployee(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
