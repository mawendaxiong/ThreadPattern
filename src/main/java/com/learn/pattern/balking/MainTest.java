package com.learn.pattern.balking;

public class MainTest {
    public static void main(String[] args) {
        final Data data = new Data("===");
        Thread auto = new Thread(new AutoSaveThread(data),"autoThread");
        Thread noAuto = new Thread(new nonAutoSaveThread(data),"nonAutoThread");
        auto.start();
        noAuto.start();
    }
}
