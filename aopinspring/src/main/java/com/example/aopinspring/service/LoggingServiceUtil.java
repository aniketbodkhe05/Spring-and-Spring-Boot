package com.example.aopinspring.service;


public class LoggingServiceUtil {

    public static void logStart(String className,String methodName){
        System.out.println("Executing ->  " + className +": " + methodName);
    }
}
