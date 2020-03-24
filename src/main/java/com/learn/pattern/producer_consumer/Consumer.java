package com.learn.pattern.producer_consumer;

import java.util.concurrent.TimeUnit;

public class Consumer implements Runnable {
    private final ProductQueue queue;

    public Consumer(ProductQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            Product product = queue.get();
            String name = Thread.currentThread().getName();
            System.out.println("Thread:" + name + "get the product: " + product.getNumber());
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
