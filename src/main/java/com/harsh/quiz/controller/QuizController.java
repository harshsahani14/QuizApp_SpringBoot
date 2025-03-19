package com.harsh.quiz.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.harsh.quiz.model.QuestionWrapper;
import com.harsh.quiz.model.Response;
import com.harsh.quiz.service.QuizService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("quiz")
public class QuizController {
	
	@Autowired
	QuizService quizService;
	
	@PostMapping("create")
	public ResponseEntity<String> createQuiz(@RequestParam("category") String category,@RequestParam("numQ") int numQ,@RequestParam("quizT") String quizT ) {
		return quizService.createQuiz(category,numQ,quizT);
	}
	
	@GetMapping("get/{id}")
	public ResponseEntity<List<QuestionWrapper>> getQuiz(@PathVariable int id){
		return quizService.getQuiz(id);
	}
	
	@GetMapping("submit/{id}")
	public ResponseEntity<List<Integer>> calculateResult(@PathVariable int id,@RequestBody List<Response> responses){
		return quizService.calculateResult(id,responses);
	}
	
}
