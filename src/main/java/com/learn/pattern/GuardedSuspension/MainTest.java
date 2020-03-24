package com.learn.pattern.GuardedSuspension;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Server不是直接接收Request，而是从RequestQueue中取出Request
 * RequestQueue充当一个缓冲区，当达到一定的量是不再接收任务
 *
 * 与producerConsumer很相似，区别在于从队列中获取信息的角色不同。
 * GuardedSuspension 是消费者让生产者去等待
 * priducerConsumer  是生产者让消费者去等待
 */
public class MainTest {
    public static void main(String[] args) {
        RequestQueue queue = new RequestQueue();

        ArrayBlockingQueue blockingQueue = new ArrayBlockingQueue(20);
        ThreadPoolExecutor executor = new ThreadPoolExecutor(10,15,10, TimeUnit.MINUTES,blockingQueue);

        Client client1 = new Client(queue);
        Client client2 = new Client(queue);
//        Client client3 = new Client(queue);
//        Client client4 = new Client(queue);

        Server server1 = new Server(queue);
        Server server2 = new Server(queue);

        executor.submit(client1);
        executor.submit(client2);
//        executor.submit(client3);
//        executor.submit(client4);
        executor.submit(server1);
        executor.submit(server2);


    }
}
