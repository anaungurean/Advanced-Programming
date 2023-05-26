package org.example;

import org.testng.annotations.Test;

import java.lang.reflect.Method;

import java.lang.reflect.Modifier;

public class Main {

    public static void main(String[] args) throws Exception {
        Class<?> clazz = Class.forName("org.example.MyProgram");

         Method[] methods = clazz.getMethods();
        int passed =0, failed=0;
         for (Method method : methods) {

            System.out.println("Method: " + method.getName());
            int modifiers = method.getModifiers();
            System.out.println("Modifiers: " + Modifier.toString(modifiers));


            if (method.isAnnotationPresent(Test.class)) {
                      try {
                         method.invoke(null);
                         passed++;
                     } catch (Throwable ex) {
                         System.out.printf("Test %s failed: %s %n",
                                 methods, ex.getCause());
                         failed++;
                     }
                 }


             Class<?>[] parameterTypes = method.getParameterTypes();
            System.out.println("Parameter Types:");
            for (Class<?> parameterType : parameterTypes) {
                System.out.println(parameterType.getName());
            }

             Class<?> returnType = method.getReturnType();
            System.out.println("Return Type: " + returnType.getName());


        }
         System.out.println();System.out.println("Au trecut : " + passed);

    }
}

