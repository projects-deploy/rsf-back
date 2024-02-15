package com.aledguedes.shop.eccomerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aledguedes.shop.eccomerce.model.Answers;

public interface AnswersRepository extends JpaRepository<Answers, Long> {
    
        List<Answers> findByQuestionId(Long question_id);
}
