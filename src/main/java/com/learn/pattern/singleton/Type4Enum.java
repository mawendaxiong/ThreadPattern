package com.learn.pattern.singleton;

/**
 * #########枚举单例模式############
 *
 * 枚举本来就是线程安全的，所以该单例没问题
 * 也是最好的单例模式
 */
public enum Type4Enum {
    INSTANCE;

    public Type4Enum getInstance(){
        return INSTANCE;
    }
}
