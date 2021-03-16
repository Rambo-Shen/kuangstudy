package learning.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * MyAnnotation
 */

@Target(value = {ElementType.METHOD,ElementType.FIELD,ElementType.TYPE})
@Retention(value = RetentionPolicy.RUNTIME)
public @interface MyAnnotation {
    String name() default "";    
    int age() default 0;
}
/**
 * InnerMyAnnotation
 */
class InnerMyAnnotation {

    @MyAnnotation    
    private int id;

    @MyAnnotation(name = "rambo")
    public void name() {
        
    }
    
}