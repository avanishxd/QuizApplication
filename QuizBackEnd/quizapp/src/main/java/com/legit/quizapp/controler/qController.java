package com.legit.quizapp.controler;

import com.legit.quizapp.model.Quiz;
import com.legit.quizapp.service.qService;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/question")
public class qController {

    @Autowired
    qService service;

    @GetMapping("/allQuestions")
    public ResponseEntity<List<Quiz>> getAllQuestions(){
        return service.getAllQuestions();
    }

    @GetMapping("/category/{category}")
    public ResponseEntity<List<Quiz>> getQuestionByCategory(@PathVariable String category){
        return service.getQuestionsByCategory(category);
    }

    @GetMapping("findQuestion/{id}")
    public ResponseEntity<Quiz> getQuestionById(@PathVariable Integer id){
        return service.getQuestionById(id);
    }

    @PostMapping("add")
    public ResponseEntity<String> addQuestion(@RequestBody Quiz quiz){
        return service.addQuestion(quiz);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deleteQuestion(@PathVariable Integer id){
        return service.removeQuestion(id);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<String> updateQuestion(@RequestBody Quiz quiz){
        return service.updateQuestion(quiz);
    }

    @GetMapping("/difficulty/{difficulty}")
    public ResponseEntity<List<Quiz>> getQuestionsByDifficulty(@PathVariable String difficulty) {
        return service.getQuestionsByDifficulty(difficulty);
    }

}

