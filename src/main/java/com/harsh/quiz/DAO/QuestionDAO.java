package com.harsh.quiz.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.harsh.quiz.model.Question;

@Repository
public interface QuestionDAO extends JpaRepository<Question,Integer> {
	
	List<Question> findByCategory(String category);

	@Query(value = "SELECT * FROM question q WHERE q.category = ?1 ORDER BY RAND() LIMIT 20", nativeQuery = true)
	List<Question> findRandomQuestionsByCategory(String category, int numQ);

}
