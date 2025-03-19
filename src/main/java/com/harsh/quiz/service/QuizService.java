package com.harsh.quiz.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.harsh.quiz.dao.QuestionDAO;
import com.harsh.quiz.dao.QuizDAO;
import com.harsh.quiz.model.Question;
import com.harsh.quiz.model.QuestionWrapper;
import com.harsh.quiz.model.Quiz;
import com.harsh.quiz.model.Response;

@Service
public class QuizService {
	
	@Autowired
	QuizDAO quizDao;
	
	@Autowired
	QuestionDAO questionDao;
	
	public ResponseEntity<String> createQuiz(String category,int numQ,String quizT) {
		
		Quiz quiz = new Quiz();
		 
		quiz.setTitle(quizT);
		
		List<Question> questions = questionDao.findRandomQuestionsByCategory(category,numQ);
		
		quiz.setQuestions(questions);
		
		quizDao.save(quiz);
		
		return new ResponseEntity("sucess",HttpStatus.CREATED);
				
	}
	

	public ResponseEntity<List<QuestionWrapper>> getQuiz(int id) {
		
		Optional<Quiz> quiz = quizDao.findById(id);
		
		List<Question> quizQuestions = quiz.get().getQuestions();		
		List<QuestionWrapper> userQuestions = new ArrayList<>();
		
		for(Question q:quizQuestions) {
			QuestionWrapper  questionWrapper = new QuestionWrapper(q.getId(),q.getQuestionTitle(), q.getOption1(), q.getOption2(), q.getOption3(), q.getOption4());
			userQuestions.add(questionWrapper);
		}
		
		return new ResponseEntity<>(userQuestions,HttpStatus.OK);
	}


	public ResponseEntity<List<Integer>> calculateResult(int id, List<Response> responses) {
		
		Optional<Quiz> quiz = quizDao.findById(id);
		
		List<Question> questions = quiz.get().getQuestions();
		
		int rightCount = 0;
		
		for(int i=0;i<responses.size();i++) {
			
			if( responses.get(i).getResponse().equals(questions.get(i).getRightAnswer())  ) {
				rightCount++;
			}
		}
		return new ResponseEntity<>(new ArrayList<>(Arrays.asList(rightCount,questions.size())),HttpStatus.OK);
	}

}
