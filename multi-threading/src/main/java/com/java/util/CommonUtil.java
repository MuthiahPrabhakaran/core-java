package com.java.util;

public class CommonUtil {


    public static void sleep(long delayInMilliSeconds) {
        try {
            Thread.sleep(delayInMilliSeconds);
        } catch (InterruptedException e) {
            LoggerUtil.log("Exception while interrupting the thread - " + e.getMessage());
        }
    }
}
