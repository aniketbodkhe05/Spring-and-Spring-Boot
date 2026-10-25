package com.example.aopadvance.aspect;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoginAspect {

//    @Before("execution(String com.example.aopadvance.servicd.StudentService.createStudent())")
//    public void logBeforeMethod(JoinPoint joinPoint){
//
//        Object arr= joinPoint.getArgs();
//        System.out.println("Student is going to be saved");
//    }
    @AfterReturning(
            value="execution(String com.example.aopadvance.servicd.StudentService.createStudent())",
    returning="result")
    public void lofAfterReturning(String result){
//        System.out.println("LoginAfter Returning method called ");
        System.out.println("target method returned:"+result);
    }

}
