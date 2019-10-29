package zcq.com.morning.annotation;

import java.lang.annotation.*;

/**
 * @author zhengchuqin
 * @version 1.0
 * @since 2019/09/30
 */
@Documented
@Target({ElementType.TYPE, ElementType.METHOD})
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface PrintLog {
    String desc();
}
