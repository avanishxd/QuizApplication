    package com.legit.quizapp.model;

    import jakarta.persistence.*;
    import lombok.Data;
    import org.springframework.boot.autoconfigure.domain.EntityScan;

    @Entity
    @Data
    public class Quiz {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id;
        private String category;
        private String difficulty;
        private String option1;
        private String option2;
        private String option3;
        private String option4;
        private String question;
        private String answer;
    }
