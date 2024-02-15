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

import com.aledguedes.shop.eccomerce.dtoRequest.AnswersRequest;
import com.aledguedes.shop.eccomerce.dtoResponse.AnswersResponse;
import com.aledguedes.shop.eccomerce.dtoResponse.DeleteResponse;
import com.aledguedes.shop.eccomerce.service.AnswersService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@CrossOrigin("*")
@RequiredArgsConstructor
@RequestMapping("/api/answers")
public class AnswersController {

    private final AnswersService answersService;

    @GetMapping
    public List<AnswersResponse> listAll() {
        return answersService.listAll();
    }

    @GetMapping(value = "/{answers_id}")
    public AnswersResponse answersById(@PathVariable Long answers_id) {
        return answersService.answersById(answers_id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AnswersResponse createAnswers(@RequestBody @Valid AnswersRequest answers) {
        return answersService.createAnswers(answers);
    }

    @PutMapping(value = "/{answers_id}")
    public AnswersResponse updateAnswers(@RequestBody @Valid AnswersRequest answers, @PathVariable Long answers_id) {
        return answersService.updateAnswers(answers, answers_id);
    }

    @GetMapping(value = "find/by-question")
    public List<AnswersResponse> answerByQuestionId(
        @RequestParam(name = "q", required = false, defaultValue = "") Long question_id) {
        return answersService.answerByQuestionId(question_id);
    }
    
    @DeleteMapping("/delete")
    public DeleteResponse deleteQuestion(
    		@RequestParam(name = "answer", required = false, defaultValue = "") Long question_id) {
    	return answersService.deleteQuestion(question_id);
    }
    
   
}
