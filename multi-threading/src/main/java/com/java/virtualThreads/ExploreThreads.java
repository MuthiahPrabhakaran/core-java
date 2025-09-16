package com.java.virtualThreads;

import com.java.util.CommonUtil;
import static com.java.util.LoggerUtil.log;

public class ExploreThreads {

    public static void doSomeWork() {
        log("Started some work");
        CommonUtil.sleep(1000);
        log("Finished some work");
    }

    public static void main(String[] args) {
        var thread1 = Thread.ofPlatform().name("t1");
        thread1.start(() -> {
            log("Run task1 in the background");
        });

        var thread2 = Thread.ofPlatform().name("t2");
        thread2.start(ExploreThreads::doSomeWork);

        log("Program Completed");
    }
}
