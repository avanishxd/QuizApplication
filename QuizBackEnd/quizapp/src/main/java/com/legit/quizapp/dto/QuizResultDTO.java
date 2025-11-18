package com.legit.quizapp.dto;

import java.util.List;

public class QuizResultDTO {
    private String userName;
    private String userEmail;
    private String quizTitle;
    private List<QuizAnswerDTO> answers;
    private long timeTaken; // seconds

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getQuizTitle() {
        return quizTitle;
    }

    public void setQuizTitle(String quizTitle) {
        this.quizTitle = quizTitle;
    }

    public List<QuizAnswerDTO> getAnswers() {
        return answers;
    }

    public void setAnswers(List<QuizAnswerDTO> answers) {
        this.answers = answers;
    }

    public long getTimeTaken() {
        return timeTaken;
    }

    public void setTimeTaken(long timeTaken) {
        this.timeTaken = timeTaken;
    }
}
