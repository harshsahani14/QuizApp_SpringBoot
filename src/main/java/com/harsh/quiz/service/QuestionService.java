package com.harsh.quiz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.harsh.quiz.Question;
import com.harsh.quiz.DAO.QuestionDAO;

@Service
public class QuestionService {
	
	@Autowired
	QuestionDAO questionDAO;
	
	public List<Question> getAllQuestions(){
		return questionDAO.findAll();
	}
}
