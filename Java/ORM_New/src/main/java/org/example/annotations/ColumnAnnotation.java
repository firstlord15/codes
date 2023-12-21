package org.example.annotations;

import org.example.tables.DatabaseType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface ColumnAnnotation {
    String name() default "";
    boolean nullable() default true;
    DatabaseType type() default DatabaseType.STRING;
}
