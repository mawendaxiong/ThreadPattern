package com.learn.pattern.producer_consumer;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class Producer implements Runnable {
    private final ProductQueue queue;

    public Producer(ProductQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true){
            Product product = new Product(UUID.randomUUID().toString().replace("-",""));
            queue.put(product);
            String name = Thread.currentThread().getName();
            System.out.println("Thread: "+name+" new a product:"+product.getNumber());
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
