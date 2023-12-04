package com.n3.aldi.tool.selenium.base;

public class TestUtilities extends  BaseTest{

    //ONLY FOR DEBUGGING REASONS
    // STATIC SLEEP

    protected  void  sleep(long millis)   {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
           e.printStackTrace();
        }
    }



}
