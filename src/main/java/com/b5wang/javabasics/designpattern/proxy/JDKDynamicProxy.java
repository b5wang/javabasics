package com.b5wang.javabasics.designpattern.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JDKDynamicProxy {

    public static void main(String[] args){

        InvocationHandler handler = new InvocationHandler(){

            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                if(proxy != null){
                    System.out.println(proxy.getClass().getName());
                }

                System.out.println("-- It is going to call method: " + method.toString());
                if(method.getName().equals("hello")){
                    String name = (String)args[0];
                    return "Hello, " + name + ".....";
                }else if(method.getName().equals("goodMorning")){
                    String name = (String)args[0];
                    return "Good morning Sir. " + name + ".....";
                }

                return null;
            }

        };

        // Dynamic proxy essential
        // public class HelloDynamicProxy implements Hello {
        //    InvocationHandler handler;
        //    public HelloDynamicProxy(InvocationHandler handler) {
        //        this.handler = handler;
        //    }
        //    public void morning(String name) {
        //        handler.invoke(
        //                this,
        //                Hello.class.getMethod("morning", String.class),
        //                new Object[] { name });
        //    }
        //}

        Greetings greetings = new EnglishGreetings();
        System.out.println(greetings.hello("Tom"));
        System.out.println(greetings.goodMorning("Tom"));

        // JDK dynamic proxy
        Greetings greetingsProxy = (Greetings) Proxy.newProxyInstance(Greetings.class.getClassLoader(),new Class[]{Greetings.class},handler);
        System.out.println(greetingsProxy.hello("Tom"));
        System.out.println(greetingsProxy.goodMorning("Tom"));

        System.out.println(greetingsProxy.hello("Peter"));
        System.out.println(greetingsProxy.goodMorning("Peter"));

    }

}


