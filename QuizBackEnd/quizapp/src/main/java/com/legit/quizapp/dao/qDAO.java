package com.legit.quizapp.dao;

import com.legit.quizapp.model.Quiz;
import com.legit.quizapp.model.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface qDAO extends JpaRepository<Quiz, Integer> {
    List<Quiz> findByCategory(String category);
    List<Quiz> findByDifficulty(String difficulty);
}
