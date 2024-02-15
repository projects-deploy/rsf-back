package com.aledguedes.shop.eccomerce.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.aledguedes.shop.eccomerce.dtoRequest.QuestionsRequest;
import com.aledguedes.shop.eccomerce.dtoResponse.DeleteResponse;
import com.aledguedes.shop.eccomerce.dtoResponse.QuestionsResponse;
import com.aledguedes.shop.eccomerce.service.QuestionsService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@CrossOrigin("*")
@RequiredArgsConstructor
@RequestMapping("/api/questions")
public class QuestionsController {

    private final QuestionsService questionsService;

    @GetMapping
    public List<QuestionsResponse> listAll() {
        return questionsService.listAll();
    }

    @GetMapping(value = "/{questions_id}")
    public QuestionsResponse questionById(@PathVariable Long questions_id) {
        return questionsService.questionById(questions_id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public QuestionsResponse createQuestions(@RequestBody @Valid QuestionsRequest questions) {
        return questionsService.createQuestions(questions);
    }

    @PutMapping(value = "/{questions_id}")
    public QuestionsResponse updateQuestions(@RequestBody @Valid QuestionsRequest questions, @PathVariable Long questions_id) {
        return questionsService.updateQuestions(questions, questions_id);
    }

    @GetMapping(value = "find/by-customer")
    public List<QuestionsResponse> questionByCustomerId(
        @RequestParam(name = "q", required = false, defaultValue = "") Long customer_id) {
        return questionsService.questionByCustomerId(customer_id);
    }

    @DeleteMapping("/delete")
    public DeleteResponse deleteQuestion(
    		@RequestParam(name = "question", required = false, defaultValue = "") Long question_id) {
    	return questionsService.deleteQuestion(question_id);
    }

    @GetMapping(value = "/find/by-product")
    public List<QuestionsResponse> getQuestionsByProductId(
        @RequestParam(name = "p", required = false, defaultValue = "") Long product_id) {
        return questionsService.getQuestionsByProductId(product_id);
    }

    
    
}
