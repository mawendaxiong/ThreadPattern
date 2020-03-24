package com.learn.pattern.producer_consumer;

import java.util.stream.IntStream;

public class MainTest {
    public static void main(String[] args) {
        ProductQueue queue = new ProductQueue();
        Producer producer = new Producer(queue);
        Consumer consumer = new Consumer(queue);

        IntStream.range(0,3).boxed().forEach(i->new Thread(producer,"p"+i).start());
        IntStream.range(0,6).boxed().forEach(i->new Thread(consumer,"c"+i).start());


    }
}
