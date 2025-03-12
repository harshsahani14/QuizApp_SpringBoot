package com.harsh.quiz;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Question {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)//WHY THIS
	private int id;
	private String title;
	private String option1;
	private String option2;
	private String option3;
	private String option4;
	private String rightOption;
	private String difficultyLevel;
	private String category;
}
