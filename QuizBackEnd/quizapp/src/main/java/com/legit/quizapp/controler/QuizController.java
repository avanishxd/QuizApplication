//package com.legit.quizapp.controler;
//
//import com.legit.quizapp.dto.QuizAnswerDTO;
//import com.legit.quizapp.dto.QuizResultDTO;
//import com.legit.quizapp.model.Quiz;
//import com.legit.quizapp.model.User;
//import com.legit.quizapp.service.EmailService;
//import com.legit.quizapp.service.UserService;
//import com.legit.quizapp.service.qService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//import java.util.Map;
//import java.util.Optional;
//import java.util.stream.Collectors;
//
//@RestController
//@RequestMapping("/quiz")
//@CrossOrigin(origins = "http://localhost:3000")
//public class QuizController {
//
//    @Autowired
//    private qService quizService;
//
//    @Autowired
//    private EmailService emailService;
//
//    @Autowired
//    private UserService userService;
//
//    @PostMapping("/submit")
//    public ResponseEntity<?> submitQuiz(@RequestBody QuizResultDTO quizResult) {
//        try {
//            Optional<User> optionalUser = userService.findByUsername(quizResult.getUserName());
//            if (optionalUser.isEmpty()) {
//                return ResponseEntity.status(400).body("User not found");
//            }
//            String userEmail = optionalUser.get().getEmail();
//
//            List<QuizAnswerDTO> answers = quizResult.getAnswers();
//
//            List<Integer> questionIds = answers.stream().map(QuizAnswerDTO::getQuestionId).collect(Collectors.toList());
//            List<Quiz> questions = quizService.getByIds(questionIds);
//
//            int correctCount = 0;
//            int wrongCount = 0;
//            int totalScore = 0;
//
//            for (Quiz question : questions) {
//                QuizAnswerDTO userAnswer = answers.stream()
//                        .filter(a -> a.getQuestionId() == question.getId())
//                        .findFirst()
//                        .orElse(null);
//
//                if (userAnswer != null) {
//                    if (question.getAnswer().equalsIgnoreCase(userAnswer.getSelectedAnswer())) {
//                        correctCount++;
//                        switch (question.getDifficulty().toLowerCase()) {
//                            case "easy":
//                                totalScore += 2;
//                                break;
//                            case "medium":
//                                totalScore += 4;
//                                break;
//                            case "hard":
//                                totalScore += 6;
//                                break;
//                        }
//                    } else {
//                        wrongCount++;
//                    }
//                }
//            }
//
//            String timeTaken = quizResult.getTimeTaken() + " seconds";
//
//            System.out.println("Sending mail to: " + userEmail);
//            try {
//                emailService.sendQuizReport(
//                        userEmail,
//                        quizResult.getUserName(),
//                        quizResult.getQuizTitle(),
//                        totalScore,
//                        questions.size(),
//                        correctCount,
//                        wrongCount,
//                        timeTaken
//                );
//                System.out.println("Email sent successfully.");
//            } catch (Exception e) {
//                System.err.println("Email sending failed:");
//                e.printStackTrace();
//                return ResponseEntity.status(500).body("Quiz submitted, but failed to send email: " + e.getMessage());
//            }
//
//            Map<String, Object> response = Map.of(
//                    "score", totalScore,
//                    "correctCount", correctCount,
//                    "wrongCount", wrongCount,
//                    "timeTaken", timeTaken,
//                    "message", "Quiz submitted successfully and report emailed."
//            );
//            return ResponseEntity.ok(response);
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            return ResponseEntity.status(500).body("Error processing quiz: " + e.getMessage());
//        }
//    }
//}
