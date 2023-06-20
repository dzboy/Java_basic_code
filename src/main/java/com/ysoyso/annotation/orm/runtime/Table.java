package com.ysoyso.annotation.orm.runtime;

import java.lang.annotation.*;

/**
 * CREATE TABLE `tableName` (
 *   `field` type(length) UNSIGNED/COLLATE utf8mb4_unicode_ci NOT NULL AUTO_INCREMENT DEFAULT 'normal' COMMENT 'description',
 *   PRIMARY KEY (`field`),
 *   UNIQUE KEY `field` (`field`) USING BTREE
 *   INDEX (`field`)
 * ) ENGINE=INNODB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='description'
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Table {
    String ENGINE_INNODB = "INNODB";
    String ENGINE_MEMORY = "MEMORY";
    String ENGINE_MYISAM = "MYISAM";
    String name() default "";

    String engine() default ENGINE_INNODB;

    String description() default "";
}
