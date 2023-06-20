package com.ysoyso.annotation.orm.runtime;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Column {
    /**
     * 列名
     * @return
     */
    String name() default "";

    /**
     * 主键
     * @return
     */
    boolean identity() default false;

    /**
     * 索引
     * @return
     */
    boolean index() default false;

    /**
     * 唯一索引
     * @return
     */
    boolean unique() default false;

    /**
     * 可空
     * @return
     */
    boolean nullable() default false;

    /**
     * 自增
     * @return
     */
    boolean autoincrement() default false;

    /**
     * 注释
     * @return
     */
    String description() default "";

    /**
     * 禁止作为字段
     * @return
     */
    boolean skip() default false;
}
