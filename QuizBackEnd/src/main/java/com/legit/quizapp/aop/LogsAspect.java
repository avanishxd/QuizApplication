package com.legit.quizapp.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Aspect
public class LogsAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(LogsAspect.class);

//    @Before("execution(* com.legit.quizapp.service.qService.getAllQuestions(..))")
//    public void logGetAllQuestions(){
//        LOGGER.info("------------------------Get Request for (/allQuestions) was made------------------------");
//    }
//
//    @Before("execution(* com.legit.quizapp.service.qService.getQuestionById(..))")
//    public void logGetQuestionByID(){
//        LOGGER.info("------------------------Get Request for (findQuestion/{id}) was made------------------------");
//    }
//
//    @Before("execution(* com.legit.quizapp.service.qService.getQuestionsByCategory(..))")
//    public void logGetQuestionsByCategory(){
//        LOGGER.info("------------------------Get Request for (/category/{category}) was made------------------------");
//    }

    @Before("execution(* com.legit.quizapp.service.qService.*(..))")
    public void logMethod(JoinPoint jp){
        LOGGER.info("------------Method called: "+jp.getSignature().getName()+"      |       Parameters: "+ Arrays.toString(jp.getArgs())+"------------");
    }



}
