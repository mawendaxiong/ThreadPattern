package com.learn.pattern.GuardedSuspension;


public class Server implements Runnable {
    private RequestQueue queue;

    public Server(RequestQueue queue) {
        this.queue = queue;
    }

    public void doWork() {
        try {
            Request request = queue.get();
            System.out.println(Thread.currentThread().getName() + " --- " + request.getMessage());
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void run() {
        while (true) {
            doWork();
        }
    }
}
