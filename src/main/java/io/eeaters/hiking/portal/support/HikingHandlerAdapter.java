package io.eeaters.hiking.portal.support;


import java.util.function.Consumer;

/**
 * @author yjwan
 * @version 1.0
 */
public interface HikingHandlerAdapter <T> {

    /**
     * 是否支持扩展
     * @param target 目标对象
     * @return true进入下一步
     */
    boolean support(T target);


    /**
     * 执行扩展逻辑
     *
     * @param target   目标对象
     * @param consumer 执行逻辑
     */
    default void handle(T target, Consumer<T> consumer) {
        consumer.accept(target);
    }

}

    