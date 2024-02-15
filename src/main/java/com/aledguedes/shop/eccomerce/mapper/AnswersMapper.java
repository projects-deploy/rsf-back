package com.aledguedes.shop.eccomerce.mapper;

import com.aledguedes.shop.eccomerce.dtoRequest.AnswersRequest;
import com.aledguedes.shop.eccomerce.dtoResponse.AnswersResponse;
import com.aledguedes.shop.eccomerce.model.Answers;

public interface AnswersMapper {

    Answers toAnswers(AnswersRequest answersRequest);
    AnswersResponse toAnswersResponse(Answers answers);
}
