package com.aledguedes.shop.eccomerce.mapperImpl;

import org.springframework.stereotype.Component;

import com.aledguedes.shop.eccomerce.dtoRequest.AnswersRequest;
import com.aledguedes.shop.eccomerce.dtoResponse.AnswersResponse;
import com.aledguedes.shop.eccomerce.mapper.AnswersMapper;
import com.aledguedes.shop.eccomerce.model.Answers;

@Component
public class AnswersMapperImpl implements AnswersMapper {

    @Override
    public Answers toAnswers(AnswersRequest answersRequest) {
        if (answersRequest == null) {
            return null;
        }

        return Answers.builder()
                .content(answersRequest.getContent())
                .questionId(answersRequest.getQuestionId())
                .build();
    }

    @Override
    public AnswersResponse toAnswersResponse(Answers answers) {
        if (answers == null) {
            return null;
        }

        return AnswersResponse.builder()
                .id(answers.getId())
                .content(answers.getContent())
                .createdAt(answers.getCreatedAt())
                .updatedAt(answers.getUpdatedAt())
                .build();
    }
}
