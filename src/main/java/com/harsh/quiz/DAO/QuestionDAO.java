package com.harsh.quiz.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.harsh.quiz.Question;

@Repository
public interface QuestionDAO extends JpaRepository<Question,Integer> {
	
}
