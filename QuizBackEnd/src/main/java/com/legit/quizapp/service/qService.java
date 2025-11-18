package com.legit.quizapp.service;

import com.legit.quizapp.dao.qDAO;
import com.legit.quizapp.model.Quiz;
import com.legit.quizapp.model.Quiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class qService {

    @Autowired
    qDAO dao;

    public ResponseEntity<List<Quiz>> getAllQuestions() {
        try{
            return new ResponseEntity<>(dao.findAll(), HttpStatus.OK) ;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST) ;
    }

    public ResponseEntity<List<Quiz>> getQuestionsByCategory(String category){
        try{
            return new ResponseEntity<>(dao.findByCategory(category), HttpStatus.OK);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST) ;
    }

    public ResponseEntity<String> addQuestion(Quiz quiz) {
        try{
            dao.save(quiz);
            return new ResponseEntity<>("SUCCESS: added!", HttpStatus.CREATED);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>("ERROR: Not added!", HttpStatus.BAD_REQUEST) ;
    }

    public ResponseEntity<String> removeQuestion(Integer id) {
        try{
            dao.deleteById(id);
            return new ResponseEntity<>("SUCCESS: deleted!", HttpStatus.OK);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>("ERROR: Not deleted!", HttpStatus.BAD_REQUEST);
    }


    public ResponseEntity<String> updateQuestion(Quiz quiz) {
        try{
            dao.save(quiz);
            return new ResponseEntity<>("SUCCESS: updated!", HttpStatus.OK);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>("ERROR: Not updated!", HttpStatus.BAD_REQUEST);
    }


    public ResponseEntity<Quiz> getQuestionById(Integer id){
        try {
            Optional<Quiz> quiz = dao.findById(id);
            return quiz.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<List<Quiz>> getQuestionsByDifficulty(String difficulty) {
        try {
            return new ResponseEntity<>(dao.findByDifficulty(difficulty), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    public List<Quiz> getByIds(List<Integer> ids) {
        return dao.findAllById(ids);
    }
}











