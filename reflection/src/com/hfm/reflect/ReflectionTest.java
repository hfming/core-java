package com.hfm.reflect;

import java.lang.annotation.Annotation;
import java.lang.reflect.*;

/**
 * 反射 Demo
 */
public class ReflectionTest {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchFieldException {
        // 方式一：Class.forName("完整的包名.类名");
        // 将字节码文件加载进内存，返回Class对象 多用于配置文件，将类名定义在配置文件中。读取文件，加载类
        Class stringClass1 = Class.forName("java.lang.String");
        System.out.println(stringClass1);
        // 方式二：类名.Class
        // 通过类名的属性class获取 多用于参数的传递
        Class stringClass2 = String.class;
        System.out.println(stringClass2);
        // 方式三:对象.getClass()
        // getClass()方法在Object类中定义着。多用于对象的获取字节码的方式
        String str = new String("Class加载");
        Class stringClass3 = str.getClass();
        System.out.println(stringClass3);
        // 通过类加载器方式
        ClassLoader classLoader = ReflectionTest.class.getClassLoader();
        Class<String> aClass = (Class<String>) classLoader.loadClass("java.lang.String");

        // 同一个字节码文件(*.class)在一次程序运行过程中，只会被加载一次，不论通过哪一种方式获取的Class对象都是同一个。
        System.out.println(stringClass1 == stringClass2 && stringClass1 == stringClass3);
        System.out.println("-----------------------------");

        /**
         * 获取构造方法
         */
        // 方式一：获取公有化构造方法
        Constructor[] constructors = stringClass1.getConstructors();
        for (Constructor constructor : constructors) {
            System.out.println(constructor);
        }
        System.out.println("-----------------------------");
        // 方式二：获取私有的构造方法
        Constructor[] constructors2 = stringClass1.getDeclaredConstructors();
        for (Constructor constructor : constructors2) {
            System.out.println(constructor);
        }
        System.out.println("-----------------------------");
        // 方式三：获取其中一个构造方法
        Constructor constructor = stringClass1.getConstructor(String.class);
        System.out.println(constructor);
        Constructor  constructor2 = stringClass1.getConstructor(StringBuilder.class);
        System.out.println(constructor2);
        System.out.println("-----------------------------");
        // 方式四：获取其中一个私有的构造函数
        Constructor constructor3 = stringClass1.getDeclaredConstructor(String.class);
        System.out.println(constructor3);
        System.out.println("-----------------------------");

        /**
         * 创建对象
         */
        // 返回的是Object对象需要进行数据类型转化
        String str2 = (String) constructor.newInstance("反射创建对象");
        System.out.println(str2);
        String str3 = (String) constructor3.newInstance("私有的构造方法创建对象");
        System.out.println(str3);
        System.out.println("-----------------------------");
        /**
         * 获取方法
         */
        // 方式一：获取所有公共方法，包括继承下来的方法。
        Method[] methods = stringClass1.getMethods();
        for (Method method : methods) {
            System.out.println(method);
        }
        System.out.println("-----------------------------");
        // 方式二：获取所有私有方法,但是不包括继承下来的方法。
        Method[] methods2 = stringClass1.getDeclaredMethods();
        for (Method method : methods2) {
            System.out.println(method);
        }
        System.out.println("-----------------------------");
        // 方式三:获取单个公共方法
        // 第一个参数是方法名， 第二参数是形参列表的数据类型。
        Method method = stringClass1.getMethod("trim", null);
        System.out.println(method);
        System.out.println("-----------------------------");
        // 方式四:获取单个私有方法
        Method method2 = stringClass1.getDeclaredMethod("isLatin1", null);
        System.out.println(method2);
        System.out.println("-----------------------------");

        /**
         * 执行方法:第一个参数：方法的调用者对象， 第二参数： 方法执行所需要的参数。
         */
        Object invoke1 = method.invoke(str, null);
        System.out.println(invoke1);
        // 如果为私有方法需要设置为可以访问才能够使用
        method2.setAccessible(true);
        Object invoke = method2.invoke(str, null);
        System.out.println(invoke);
        System.out.println("-----------------------------");
        /**
         * 获取成员变量
         */
        // 方式一:获取所有公共成员变量
        Field[] fields = stringClass1.getFields();
        for (Field field : fields) {
            System.out.println(field);
        }
        System.out.println("-----------------------------");
        // 方式二:获取所有私有成员变量
        Field[] fields2 = stringClass1.getDeclaredFields();
        for (Field field : fields2) {
            System.out.println(field);
        }
        System.out.println("-----------------------------");
        // 方式三:获取单个公共成员变量
        Field field = stringClass1.getField("CASE_INSENSITIVE_ORDER");
        System.out.println(field);
        System.out.println("-----------------------------");
        // 方式四:获取单个私有成员变量
        Field field2 = stringClass1.getDeclaredField("serialVersionUID");
        System.out.println(field2);

        /**
         * get及set方法
         */
        // 设置忽略访问权限修饰符的安全检查 暴力反射
        field.setAccessible(true);
        System.out.println( field.get(str));
        // 参数1 对象，参数二 成员变量的值
//        field.set(str,true);
//        field.get(str);

        // 私有成员需要设置为可以访问
        field2.setAccessible(true);
//        field2.set("对象", "成员变量的值");
//        field2.get(str);

        // 获取父类
        Class<? super String> superclass = String.class.getSuperclass();

        // 获取所有接口
        Class<?>[] interfaces = String.class.getInterfaces();

        // 获取注解
        Annotation[] annotations = String.class.getAnnotations();

//        获取父类泛型类型
        Type genericSuperclass = String.class.getGenericSuperclass();
//        泛型类型
        TypeVariable<Class<String>>[] typeParameters = String.class.getTypeParameters();
//        获取实际的泛型类型参数数组

    }
}
