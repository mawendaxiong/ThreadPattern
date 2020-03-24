package com.learn.pattern.singleton;

/**
 * #########双重检测单例模式############
 *
 * 实现了懒加载，并且用双重检测保证了多线程下的安全性。
 * volatile修饰的INSTANCE是双重检测的关键，保证了INSTANCE的可见性
 */
public class Type4LazyDoubleCheck {
    private Type4LazyDoubleCheck() {

    }

    private static volatile Type4LazyDoubleCheck INSTANCE = null;

    public static Type4LazyDoubleCheck getINSTANCE() {
        if (null == INSTANCE) {
            synchronized (Type4LazyDoubleCheck.class) {
                if (null == INSTANCE) {
                    INSTANCE = new Type4LazyDoubleCheck();
                }
            }
        }
        return INSTANCE;
    }
}
