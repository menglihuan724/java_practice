package AnnotaitonDemo;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.text.Annotation;


@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD,ElementType.TYPE})
public @interface MyAnnotation {
	String value();
	String color() default "bule";
	annotationText annotation() default @annotationText("MY");
	Week week() default Week.MON;
}
@interface annotationText {
String value();
}
enum Week{
	MON,SUN;
}