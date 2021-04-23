package 设计模式.compiler.test;

import 设计模式.proxy.Moveable;

import java.lang.reflect.Method;

public class Test2 {
    public static void main(String[] args) {
        Method[] methods = Moveable.class.getMethods();
        for (Method m : methods) {
            System.out.println(m.getName());
        }
    }
}
