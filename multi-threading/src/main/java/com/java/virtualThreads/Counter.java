package com.java.virtualThreads;

import com.java.util.CommonUtil;

import java.util.concurrent.locks.ReentrantLock;

import static com.java.util.LoggerUtil.log;

public class Counter {

    private int counter;

    private final ReentrantLock reentrantLock = new ReentrantLock();

    private final Object lock = new Object();

    public int getAndIncrement(int index) {
        synchronized (lock) {
            log("started getAndIncrement: " + index);
            CommonUtil.sleep(1000);
            log("finished getAndIncrement: " + index);
            return counter++;
        }
    }

    public void getAndIncrementUsingReentrantLock(int index) {
        reentrantLock.lock();
        try {
            log("started getAndIncrementUsingReentrantLock: " + index);
            CommonUtil.sleep(1000);
            log("finished getAndIncrementUsingReentrantLock: " + index);
            counter++;
        } finally {
            reentrantLock.unlock();
        }
    }
}
