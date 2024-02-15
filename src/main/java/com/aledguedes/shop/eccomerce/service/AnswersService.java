package com.aledguedes.shop.eccomerce.service;

import java.util.List;

import com.aledguedes.shop.eccomerce.dtoRequest.AnswersRequest;
import com.aledguedes.shop.eccomerce.dtoResponse.AnswersResponse;
import com.aledguedes.shop.eccomerce.dtoResponse.DeleteResponse;

public interface AnswersService {

    List<AnswersResponse> listAll();
    AnswersResponse answersById(Long answers_id);
    AnswersResponse createAnswers(AnswersRequest answers);
    AnswersResponse updateAnswers(AnswersRequest answers, Long answers_id);

    List<AnswersResponse> answerByQuestionId(Long question_id);
    
    DeleteResponse deleteQuestion(Long question_id);
}
