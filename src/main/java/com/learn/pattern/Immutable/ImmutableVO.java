package com.learn.pattern.Immutable;

/**
 * Immutable是不可变对象模式，即一个对象是共享数据（临界数据），会被多个线程使用
 * final修饰class，防止使用子类修改值
 * final修饰字段，防止修改字段值
 * private修饰字段，仅类内可见
 */
public final class ImmutableVO {
    private final String a;
    private final String b;

    public ImmutableVO(String a, String b) {
        this.a = a;
        this.b = b;
    }

    public String getA() {
        return a;
    }

    public String getB() {
        return b;
    }

    public ImmutableVO editA(String a){
        return new ImmutableVO(a,this.b);
    }

    public ImmutableVO editB(String b){
        return new ImmutableVO(this.a,b);
    }
}
