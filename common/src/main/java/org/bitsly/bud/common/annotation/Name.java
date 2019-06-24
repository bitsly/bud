package org.bitsly.bud.common.annotation;

import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target({ElementType.FIELD,ElementType.PARAMETER})
public @interface Name {
    @AliasFor("msgTemplate")
    String value() default "";
}
