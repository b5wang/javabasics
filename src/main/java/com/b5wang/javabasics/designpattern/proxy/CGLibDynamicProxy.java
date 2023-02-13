package com.b5wang.javabasics.designpattern.proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CGLibDynamicProxy {


    public static void main(String[] args){
        MethodInterceptor methodInterceptor = new MethodInterceptor(){

            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                System.out.println("------Pre process-------------");
                // 此处一定要使用proxy的invokeSuper方法来调用目标类的方法
                methodProxy.invokeSuper(o, objects);
                System.out.println("------Post process-------------");
                return null;
            }
        };


        Enhancer enhancer = new Enhancer();
        // 设置目标类
        enhancer.setSuperclass(EnglishGreetings.class);
        // 设置拦截器对象
        enhancer.setCallback(methodInterceptor);
        // 创建子类 即代理
        EnglishGreetings targetClassProxy = (EnglishGreetings) enhancer.create();

        System.out.println(targetClassProxy.hello("Tom"));
        System.out.println(targetClassProxy.goodMorning("Tom"));
    }

}
