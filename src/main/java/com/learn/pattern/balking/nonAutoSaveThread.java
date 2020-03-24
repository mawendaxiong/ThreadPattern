package com.learn.pattern.balking;

import java.util.concurrent.TimeUnit;

public class nonAutoSaveThread implements Runnable {
    private Data data;

    public nonAutoSaveThread(Data data) {
        this.data = data;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            String message = "new message" + i;
            data.write(message);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            data.save();
        }
    }
}
