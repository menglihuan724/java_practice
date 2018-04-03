package AnnotaitonDemo;

@MyAnnotation(value="java",week=Week.SUN)
class UseAnnotation{
	public static void main(String[] args) {
		if(UseAnnotation.class.isAnnotationPresent(MyAnnotation.class)){
			MyAnnotation annotation= UseAnnotation.class.getAnnotation(MyAnnotation.class);
			System.out.println(annotation);
			System.out.println(annotation.color());
			System.out.println(annotation.value());
			System.out.println(annotation.week());
			System.out.println(annotation.annotationType());
		}
	}
}