package com.java.virtualThreads;

import static com.java.util.CommonUtil.sleep;
import static com.java.util.LoggerUtil.log;

public class HelloWorldThreads {

    private static String result = "";

    private static void hello() {
        sleep(500);
        result = result.concat("Hello");
    }

    private static void world() {
        sleep(600);
        result = result.concat(" World");
    }

    public static void main(String[] args) throws InterruptedException {
        var thread1 = Thread.ofPlatform().name("t1")
                .start(HelloWorldThreads::hello);
        var thread2 = Thread.ofPlatform().name("t2")
                .start(HelloWorldThreads::world);

        // join
        thread1.join();
        thread2.join();

        log("Result is " + result);
    }
}
