package com.learn.pattern.SingleThreadedExcution;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class MainTest {
    public static void main(String[] args) {
        final Gate gate = new Gate();
        Person person1 = new Person("alex", "acountry", gate);
        Person person2 = new Person("blex", "bcountry", gate);
        Person person3 = new Person("clex", "ccountry", gate);
        Person person4 = new Person("dlex", "dcountry", gate);

        ArrayBlockingQueue<Runnable> queue = new ArrayBlockingQueue<>(30);
        ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 10, 30, TimeUnit.HOURS, queue);
        executor.submit(person1);
        executor.submit(person2);
        executor.submit(person3);
        executor.submit(person4);

    }
}
