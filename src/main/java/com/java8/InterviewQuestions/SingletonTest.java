package com.java8.InterviewQuestions;



public class SingletonTest {

    private static  SingletonTest instance;
    private SingletonTest() {

    }
    public  static synchronized SingletonTest  getInstance(){
        if(instance==null){
            instance=new SingletonTest();
        }
        return instance;
    }
}
