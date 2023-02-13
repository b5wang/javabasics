package com.b5wang.javabasics.designpattern.proxy;


/**
 * https://www.cnblogs.com/tuyang1129/p/12878549.html
 *
 * Spring APO implementation theory: Dynamic proxy.
 * If we configure the aspect on a spring bean, when spring is initializing this bean it creates a proxy object of this bean.
 * Subsequent calling the bean is to call the proxy method.
 * Spring APO is using 2 types of proxy, JDK dynamic proxy and CGLib dynamic proxy.
 *
 * */
public class SpringAopTheory {

    /**
     * JDK dynamic proxy:
     * 1) Class want to proxy must have interface
     * 2) Only the methods in interface can be set aspect
     *
     * */

}
