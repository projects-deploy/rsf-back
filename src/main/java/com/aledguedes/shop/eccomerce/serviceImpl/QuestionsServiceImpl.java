package com.aledguedes.shop.eccomerce.serviceImpl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.aledguedes.shop.eccomerce.dtoRequest.QuestionsRequest;
import com.aledguedes.shop.eccomerce.dtoResponse.AnswersResponse;
import com.aledguedes.shop.eccomerce.dtoResponse.CustomerResponse;
import com.aledguedes.shop.eccomerce.dtoResponse.DeleteResponse;
import com.aledguedes.shop.eccomerce.dtoResponse.QuestionsResponse;
import com.aledguedes.shop.eccomerce.exceptions.core.CustomerNotFoundException;
import com.aledguedes.shop.eccomerce.exceptions.core.QuestionsNotFoundException;
import com.aledguedes.shop.eccomerce.exceptions.core.UserNotFoundException;
import com.aledguedes.shop.eccomerce.mapper.AnswersMapper;
import com.aledguedes.shop.eccomerce.mapper.CustomerMapper;
import com.aledguedes.shop.eccomerce.mapper.QuestionsMapper;
import com.aledguedes.shop.eccomerce.model.Answers;
import com.aledguedes.shop.eccomerce.model.Customer;
import com.aledguedes.shop.eccomerce.model.Questions;
import com.aledguedes.shop.eccomerce.repository.AnswersRepository;
import com.aledguedes.shop.eccomerce.repository.CustomerRepository;
import com.aledguedes.shop.eccomerce.repository.QuestionsRepository;
import com.aledguedes.shop.eccomerce.service.QuestionsService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@SuppressWarnings("null")
public class QuestionsServiceImpl implements QuestionsService {

	private final CustomerMapper customerMapper;
	private final CustomerRepository customerRepository;

	private final QuestionsMapper questionsMapper;
	private final QuestionsRepository questionsRepository;

	private final AnswersMapper answersMapper;
	private final AnswersRepository answersRepository;

	@Override
	public List<QuestionsResponse> listAll() {
		List<Questions> questions = questionsRepository.findAll();

		return questions.stream().map(question -> {
			QuestionsResponse response = questionsMapper.toQuestionsResponse(question);
			var user = customerRepository.findById(question.getCustomerId()).orElseThrow(UserNotFoundException::new);
			var userDTO = customerMapper.toCustomerResponse(user);

			response.setCustomer(userDTO);
			return response;
		}).collect(Collectors.toList());
	}

	@Override
	public QuestionsResponse questionById(Long questions_id) {

		Questions question = questionsRepository.findById(questions_id).orElseThrow(QuestionsNotFoundException::new);

		long customer_id = question.getCustomerId();
		CustomerResponse user = customerRepository.findById(customer_id).map(customerMapper::toCustomerResponse)
				.orElseThrow(CustomerNotFoundException::new);

		var questionDTO = questionsMapper.toQuestionsResponse(question);

		questionDTO.setCustomer(user);

		return questionDTO;
	}

	@Override
	public QuestionsResponse createQuestions(QuestionsRequest questionsRequest) {
		try {
			var newQuestions = questionsMapper.toQuestions(questionsRequest);
			var createdQuestions = questionsRepository.save(newQuestions);
			return questionsMapper.toQuestionsResponse(createdQuestions);
		} catch (Exception e) {
			System.out.println("DEBUG = " + e.getMessage());
		}
		return null;
	}

	@Override
	public QuestionsResponse updateQuestions(QuestionsRequest questionsRequest, Long questions_id) {
		try {
			var questions = questionsRepository.findById(questions_id).orElseThrow(QuestionsNotFoundException::new);
			BeanUtils.copyProperties(questionsRequest, questions, "id", "createdAt", "updatedAt");
			var questionsAtualizado = questionsRepository.save(questions);
			return questionsMapper.toQuestionsResponse(questionsAtualizado);
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	@Override
	public List<QuestionsResponse> questionByCustomerId(Long customer_id) {
		return questionsRepository.findByCustomerId(customer_id).stream().map(questionsMapper::toQuestionsResponse)
				.toList();
	}

	@Override
	public DeleteResponse deleteQuestion(Long question_id) {
		var status = HttpStatus.OK;
		String deletionMessage = "Item deletado com sucesso.";
		var body = DeleteResponse.builder().status(status.value()).message(deletionMessage)
				.timestamp(LocalDateTime.now()).build();

		return body;
	}

	@Override
	public List<QuestionsResponse> getQuestionsByProductId(Long product_id) {

		try {
			List<Questions> questions = questionsRepository.findByProductId(product_id);

			List<QuestionsResponse> responses = questions.stream().map(question -> {
				QuestionsResponse response = questionsMapper.toQuestionsResponse(question);
				var user = customerRepository.findById(question.getCustomerId()).orElseThrow(UserNotFoundException::new);
				var userDTO = customerMapper.toCustomerResponse(user);

				response.setCustomer(userDTO);
				return response;
			}).collect(Collectors.toList());

			for (QuestionsResponse res : responses) {
				List<Answers> answers = answersRepository.findByQuestionId(res.getId());
				List<AnswersResponse> answerDTOs = answers.stream()
						.map(answersMapper::toAnswersResponse)
						.collect(Collectors.toList());
				res.setAnswers(answerDTOs);
			}
			return responses;
		} catch (Exception e) {
			return null;
		}
	}
	
	@SuppressWarnings("unused")
	private CustomerResponse getCustomerById(Long customerId) {
	    Customer customer = customerRepository.findById(customerId).orElseThrow(UserNotFoundException::new);
	    return customerMapper.toCustomerResponse(customer);
	}

}
