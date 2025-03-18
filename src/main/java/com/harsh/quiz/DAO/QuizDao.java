package com.harsh.quiz.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.harsh.quiz.model.Quiz;

@Repository
public interface QuizDAO extends JpaRepository<Quiz, Integer>  {

}
