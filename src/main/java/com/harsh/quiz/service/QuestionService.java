package com.harsh.quiz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.harsh.quiz.Question;
import com.harsh.quiz.dao.QuestionDAO;

@Service
public class QuestionService {
	
	@Autowired
	QuestionDAO questionDAO;
	
	public List<Question> getAllQuestions(){
		return questionDAO.findAll();
	}
	
	public List<Question> getQuestionsByCategory(String category){
		return questionDAO.findByCategory(category);
	}
	
	public Question addQuestion(Question question) {
		
		Question savedQuestion = questionDAO.save(question);
		return savedQuestion;
	}
}
