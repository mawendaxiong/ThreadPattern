package com.learn.pattern.GuardedSuspension;

import java.util.UUID;

public class Client implements Runnable {

    private RequestQueue queue;

    public Client(RequestQueue queue) {
        this.queue = queue;
    }

    public void send() {
        try {
            Request request = new Request(UUID.randomUUID().toString().replace("-", ""));
            System.out.println(Thread.currentThread().getName()+" put message: "+request.getMessage());
            queue.put(request);
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while (true) {
            send();
        }
    }
}
