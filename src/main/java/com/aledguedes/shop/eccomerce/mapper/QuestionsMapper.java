package com.aledguedes.shop.eccomerce.mapper;

import com.aledguedes.shop.eccomerce.dtoRequest.QuestionsRequest;
import com.aledguedes.shop.eccomerce.dtoResponse.QuestionsResponse;
import com.aledguedes.shop.eccomerce.model.Questions;

public interface QuestionsMapper {

    Questions toQuestions(QuestionsRequest questionsRequest);
    QuestionsResponse toQuestionsResponse(Questions questions);
}
