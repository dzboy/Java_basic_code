package com.ysoyso.annotation.pkg;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedType;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Arrays;

public class ReflectAnnDemo {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class<Api> apiClass = Api.class;
        // 判断类是否包含AnnDemo注解
        System.out.println(apiClass.isAnnotationPresent(AnnDemo.class));
        // 获取类的所有注解
        Annotation[] annotations = apiClass.getAnnotations();
        System.out.println(annotations.length);
        for (Annotation annotation : annotations) {
            // 获取注解类型信息
            Class<?> clazz = annotation.annotationType();
            System.out.println(clazz.getSimpleName());
            // 通过反射方法，获取注解中属性的值
            Method method = annotation.getClass().getDeclaredMethod("names");
            String[] names = (String[]) method.invoke(annotation);
            System.out.println(Arrays.toString(names));

            // 获取注解的接口信息
            AnnotatedType[] types = clazz.getAnnotatedInterfaces();
            System.out.println(types.length);
            for (AnnotatedType annotatedType : types) {
                Type type = annotatedType.getType();
                System.out.println(type.getTypeName());
            }
        }

    }
}
