package io.eeaters.hiking.portal.util;

import org.springframework.beans.BeanUtils;

import java.lang.reflect.Constructor;

/**
 * @author yjwan
 * @version 1.0
 */
public interface ConvertUtils {

    static <F, T> T toEntity(F t, Class<T> tClass) {
        if (t == null) {
            return null;
        }
        try {
            Constructor<T> constructor = tClass.getConstructor();
            T result = constructor.newInstance();

            BeanUtils.copyProperties(t, result);
            return result;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}

    