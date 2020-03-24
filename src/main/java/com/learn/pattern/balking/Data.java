package com.learn.pattern.balking;

public class Data {
    private String message;
    private String context;
    private boolean save;

    public Data(String message) {
        this.message = message;
        this.save = false;
    }

    public synchronized void write(String newMessage){
        context+=newMessage;
        save=false;
    }

    public synchronized void save(){
        if (!save){
            message+=context;
            save=true;
            System.out.println("is not save,"+Thread.currentThread().getName()+" go to save");
            System.out.println("word==============="+message);
            return;
        }
        System.out.println("is saved,"+Thread.currentThread().getName()+" don't need to save");
        return;
    }
}
