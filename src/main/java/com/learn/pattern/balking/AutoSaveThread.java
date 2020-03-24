package com.learn.pattern.balking;

import java.util.concurrent.TimeUnit;

public class AutoSaveThread implements Runnable {
    private Data data;

    public AutoSaveThread(Data data) {
        this.data = data;
    }

    @Override
    public void run() {
        while (true){
            try {
                TimeUnit.SECONDS.sleep(2);
                data.save();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
