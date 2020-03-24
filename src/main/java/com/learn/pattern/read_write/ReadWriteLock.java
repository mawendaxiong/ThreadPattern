package com.learn.pattern.read_write;

public class ReadWriteLock {
    private final Object lock = new Object();

    private volatile boolean read;

    private volatile int readNumber;

    public void doRead() {

    }

    public synchronized void doWrite() {
        while (readNumber>0){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        read=false;

    }
}
