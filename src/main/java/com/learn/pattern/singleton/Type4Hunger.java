package com.learn.pattern.singleton;

/**
 * #########饿汉式单例模式############
 *
 * 若类的属性方法比较多，加载要慢且占内存
 * 线程安全
 */
public class Type4Hunger {
    private Type4Hunger() {

    }

    private static Type4Hunger INSTANCE = new Type4Hunger();

    public static Type4Hunger getINSTANCE() {
        return INSTANCE;
    }
}
