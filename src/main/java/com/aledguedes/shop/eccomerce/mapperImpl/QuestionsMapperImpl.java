package com.aledguedes.shop.eccomerce.mapperImpl;

import org.springframework.stereotype.Component;

import com.aledguedes.shop.eccomerce.dtoRequest.QuestionsRequest;
import com.aledguedes.shop.eccomerce.dtoResponse.QuestionsResponse;
import com.aledguedes.shop.eccomerce.mapper.QuestionsMapper;
import com.aledguedes.shop.eccomerce.model.Questions;

@Component
public class QuestionsMapperImpl implements QuestionsMapper {

    @Override
    public Questions toQuestions(QuestionsRequest questionsRequest) {
        if (questionsRequest == null) {
            return null;
        }

        return Questions.builder()
                .content(questionsRequest.getContent())
                .customerId(questionsRequest.getCustomerId())
                .productId(questionsRequest.getProductId())
                .build();
    }

    @Override
    public QuestionsResponse toQuestionsResponse(Questions questions) {
        if (questions == null) {
            return null;
        }

        return QuestionsResponse.builder()
                .id(questions.getId())
                .content(questions.getContent())
                .product_id(questions.getProductId())
                .createdAt(questions.getCreatedAt())
                .updatedAt(questions.getUpdatedAt())
                .build();
    }
}
