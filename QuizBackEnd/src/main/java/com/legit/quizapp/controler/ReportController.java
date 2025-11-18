package com.legit.quizapp.controler;

import com.legit.quizapp.service.EmailService;
import com.legit.quizapp.service.qService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/report")
@CrossOrigin(origins = "http://localhost:3000")
public class ReportController {
    private qService quizService;

    @Autowired
    private EmailService emailService;

    @PostMapping("{marks}")
    public void reportMarks(@PathVariable Integer marks){
        emailService.sendQuizReport(marks);
    }
}
