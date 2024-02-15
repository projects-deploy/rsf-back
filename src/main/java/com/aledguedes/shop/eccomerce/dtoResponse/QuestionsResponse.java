package com.aledguedes.shop.eccomerce.dtoResponse;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class QuestionsResponse {

    private Long id;
    private String content;
    private Long product_id;
    List<AnswersResponse> answers;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @JsonIgnoreProperties({ "favorites", "reviews" })
    private CustomerResponse customer;

}
