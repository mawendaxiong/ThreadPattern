package com.learn.pattern.GuardedSuspension;

import java.util.LinkedList;

public class RequestQueue {
    private static LinkedList<Request> list = new LinkedList<>();
    private int number = 0;
    private int MAX_NUMBER = 100;

    public synchronized Request get() throws InterruptedException {
        while (number <= 0) {
            this.wait();
        }
        Request request = list.removeFirst();
        number--;
        System.out.println("request size:"+number);
        this.notifyAll();
        return request;
    }

    public synchronized void put(Request request) throws InterruptedException {
        while (number > MAX_NUMBER) {
            this.wait();
        }
        list.addLast(request);
        number++;
        System.out.println("request size:"+number);
        this.notifyAll();
    }
}
