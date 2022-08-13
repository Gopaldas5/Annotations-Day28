package com.bridgeLbz;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class AnnotationExample {
    @Override
    @MethodInfo(author = "Gopal", comments = "Main methods ", date = "12-08-2022", revision = 1)
    public String toString(){
        return "Overridden toString method";
    }

    @Deprecated
    @MethodInfo(comments = "Deprecated method ", date = "12-08-2022")
    public static void oldMethod(){
        System.out.println("Old method, don't use it");
    }

    public static void main(String[] args) {

        try {
            for (Method method : AnnotationExample.class.getMethods()){
                //Checks if MethodInfo annotation is present for the method
              if (method.isAnnotationPresent(MethodInfo.class)){
                  try{
                      //iterates all the annotations available in the method
                      for (Annotation annotation : method.getDeclaredAnnotations()){
                          System.out.println("Annotation in method  "+ method+ ": "+ annotation);
                      }
                      MethodInfo methodAnnotation = method.getAnnotation(MethodInfo.class);
                      if (methodAnnotation.revision() == 1){
                          System.out.println("Method with revision no 1 =" +method);
                      }
                  }catch (Throwable ex){
                      ex.printStackTrace();
                  }
              }
            }
        }catch (SecurityException e){
            e.printStackTrace();
        }
    }

}
