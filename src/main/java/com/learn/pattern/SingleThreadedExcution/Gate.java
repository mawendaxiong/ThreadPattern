package com.learn.pattern.SingleThreadedExcution;

/**
 * pass()加上synchronized关键字，一次只让一个线程通过，保证数据的一致性
 */
public class Gate {
    private String name = "null";
    private String country ="null";

    public synchronized void pass(String name,String country){
        this.name = name;
        this.country = country;
        check();
    }

    private void check() {
        if (this.name.charAt(0)!=this.country.charAt(0)){
            System.out.println(this.name+" pass the door fail,the country: "+this.country);
        }
    }
}
