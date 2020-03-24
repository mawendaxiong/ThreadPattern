package com.learn.pattern.producer_consumer;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.LinkedList;
import java.util.Queue;

public class ProductQueue {
    private final LinkedList<Product> queue;

    private final static int FULL = 100;
    private final static int EMPTY = 0;
    public ProductQueue() {
        this.queue = new LinkedList<>();
    }

    public synchronized void put(Product product){
        while (queue.size()>=FULL){
            try {
                String name = Thread.currentThread().getName();
                System.out.println("the queue is full, "+name+" need to wait");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        queue.addLast(product);
        notifyAll();
    }

    public synchronized Product get(){
        while (queue.size()<=EMPTY){
            try {
                String name = Thread.currentThread().getName();
                System.out.println("the queue is empty, "+name+" need to wait");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Product first = queue.removeFirst();
        notifyAll();
        return first;
    }
}
