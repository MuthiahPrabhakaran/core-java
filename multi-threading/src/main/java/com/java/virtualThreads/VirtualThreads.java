package com.java.virtualThreads;

import com.java.util.CommonUtil;

import static com.java.util.LoggerUtil.log;

public class VirtualThreads {

    public static void doSomeWork(int index) {
        log("started doSomeWork: " + index);
        CommonUtil.sleep(1000);
        log("finished doSomeWork: " + index);
    }

    public static void main(String[] args) {
        var thread1 = Thread.ofVirtual().name("t1");
        var thread2 = Thread.ofVirtual().name("t2");

        thread1.start(() -> {
            log("Run task1 in the background");
        });

        thread2.start(ExploreThreads::doSomeWork);

        log("Program Completed");
        CommonUtil.sleep(1000);
    }

}
