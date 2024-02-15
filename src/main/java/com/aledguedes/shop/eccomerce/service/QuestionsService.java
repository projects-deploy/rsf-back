package com.aledguedes.shop.eccomerce.service;

import java.util.List;

import com.aledguedes.shop.eccomerce.dtoRequest.QuestionsRequest;
import com.aledguedes.shop.eccomerce.dtoResponse.DeleteResponse;
import com.aledguedes.shop.eccomerce.dtoResponse.QuestionsResponse;

public interface QuestionsService {

    List<QuestionsResponse> listAll();
    QuestionsResponse questionById(Long brand_id);
    QuestionsResponse createQuestions(QuestionsRequest brand);
    QuestionsResponse updateQuestions(QuestionsRequest brand, Long brand_id);

    List<QuestionsResponse> questionByCustomerId(Long customer_id);
    DeleteResponse deleteQuestion(Long question_id);
    List<QuestionsResponse> getQuestionsByProductId(Long product_id);
}
