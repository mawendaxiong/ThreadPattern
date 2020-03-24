package com.learn.pattern.SingleThreadedExcution;

public class Person implements Runnable {
    private String name;
    private String country;
    private Gate gate;

    public Person(String name, String country, Gate gate) {
        this.name = name;
        this.country = country;
        this.gate = gate;
    }


    @Override
    public void run() {
        while (true){
            gate.pass(this.name, this.country);
        }
    }
}
