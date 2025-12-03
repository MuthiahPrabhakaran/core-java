package com.java.virtualThreads;

import com.java.util.CommonUtil;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

import static com.java.util.LoggerUtil.log;

public class MaxVirtualThreads {

    static AtomicInteger atomicInteger = new AtomicInteger();

    public static void doSomeWork(int index) {
        log("started doSomeWork: " + index);
        CommonUtil.sleep(1000);
        log("finished doSomeWork: " + index);
    }
    public static void main(String[] args) {
//        int MAX_THREADS = 1000_000;
        log("Total no of available cores: " + CommonUtil.noOfCores());
        int MAX_THREADS = 10;
        IntStream.rangeClosed(1, MAX_THREADS)
                .forEach( i -> {
                    Thread.ofVirtual().start(() -> MaxVirtualThreads.doSomeWork(i));
                    atomicInteger.incrementAndGet();
                    log("No of threads: " + atomicInteger.get());
                });
        log("Program Completed");
        CommonUtil.sleep(20000);

    }

}
