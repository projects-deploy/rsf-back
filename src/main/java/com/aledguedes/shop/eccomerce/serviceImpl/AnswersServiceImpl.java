package com.aledguedes.shop.eccomerce.serviceImpl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.aledguedes.shop.eccomerce.dtoRequest.AnswersRequest;
import com.aledguedes.shop.eccomerce.dtoResponse.AnswersResponse;
import com.aledguedes.shop.eccomerce.dtoResponse.DeleteResponse;
import com.aledguedes.shop.eccomerce.exceptions.core.AnswersNotFoundException;
import com.aledguedes.shop.eccomerce.mapper.AnswersMapper;
import com.aledguedes.shop.eccomerce.repository.AnswersRepository;
import com.aledguedes.shop.eccomerce.service.AnswersService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@SuppressWarnings("null")
public class AnswersServiceImpl implements AnswersService {

    private final AnswersMapper answersMapper;
    private final AnswersRepository answersRepository;

    @Override
    public List<AnswersResponse> listAll() {
        return answersRepository.findAll()
                .stream()
                .map(answersMapper::toAnswersResponse)
                .toList();
    }

    @Override
    public AnswersResponse answersById(Long answers_id) {
        return answersRepository.findById(answers_id)
                .map(answersMapper::toAnswersResponse)
                .orElseThrow(AnswersNotFoundException::new);
    }

    @Override
    public AnswersResponse createAnswers(AnswersRequest answersRequest) {
        try {
            var newAnswers = answersMapper.toAnswers(answersRequest);
            var createdAnswers = answersRepository.save(newAnswers);
            return answersMapper.toAnswersResponse(createdAnswers);
        } catch (Exception e) {
            System.out.println("DEBUG = " + e.getMessage());
        }
        return null;
    }

    @Override
    public AnswersResponse updateAnswers(AnswersRequest answersRequest, Long answers_id) {
        try {
            var answers = answersRepository.findById(answers_id)
                    .orElseThrow(AnswersNotFoundException::new);
            BeanUtils.copyProperties(answersRequest, answers, "id", "createdAt", "updatedAt");
            var answersAtualizado = answersRepository.save(answers);
            return answersMapper.toAnswersResponse(answersAtualizado);
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public List<AnswersResponse> answerByQuestionId(Long question_id) {
        return answersRepository.findByQuestionId(question_id)
                .stream()
                .map(answersMapper::toAnswersResponse)
                .toList();
    }

	@Override
	public DeleteResponse deleteQuestion(Long question_id) {
		var status = HttpStatus.OK;
		String deletionMessage = "Item deletado com sucesso.";
		var body = DeleteResponse.builder()
                .status(status.value())
                .message(deletionMessage)
                .timestamp(LocalDateTime.now())
                .build();
		
		return body;
	}

}
