package com.learn.pattern.singleton;

/**
 * #########内部类单例模式############
 *
 * 外部类加载的时候不会立即加载，保证了懒加载
 * 在调用getInstance()方法的时候才会去实例化InnerClass
 * 实例化InnerClass的时候会初始化INSTANCE
 * 同时实例化对象的时候jvm会保证线程安全
 * 所以内部类单例模式也是线程安全的
 */
public class Type4InnerClass {
    private Type4InnerClass(){

    }

    public static Type4InnerClass getInstance(){
        return InnerClass.INSTANCE;
    }

    private static final class InnerClass{
        private static Type4InnerClass INSTANCE = new Type4InnerClass();
    }
}
