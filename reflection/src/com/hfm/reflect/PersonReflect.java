package com.hfm.reflect;

import java.lang.annotation.Annotation;
import java.lang.reflect.*;

/**
 * @author hfm Email:hfming2016@163.com
 * @version v 1.01
 * @Description
 * @date 2020-05-11 18:19
 */
public class PersonReflect {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchFieldException, NoSuchMethodException, InvocationTargetException {
        Class<Person> aClass = (Class<Person>) Class.forName("com.hfm.reflect.Person");

        //获取属性结构
        //getFields():获取当前运行时类及其父类中声明为public访问权限的属性
        Field[] fields = aClass.getFields();
        for (Field f : fields) {
            //1.权限修饰符
            int modifier = f.getModifiers();
            System.out.print(Modifier.toString(modifier) + "\t");

            //2.数据类型
            Class type = f.getType();
            System.out.print(type.getName() + "\t");

            //3.变量名
            String fName = f.getName();
            System.out.print(fName);
            System.out.println();
            System.out.println(f);
        }
        System.out.println();

        //getDeclaredFields():获取当前运行时类中声明的所有属性。（不包含父类中声明的属性）
        Field[] declaredFields = aClass.getDeclaredFields();
        for (Field f : declaredFields) {
            System.out.println(f);
        }
        System.out.println("==========================");

        //getMethods():获取当前运行时类及其所有父类中声明为public权限的方法
        Method[] methods = aClass.getMethods();
        for (Method m : methods) {
            //1.获取方法声明的注解
            Annotation[] annos = m.getAnnotations();
            for (Annotation a : annos) {
                System.out.println(a);
            }
            //2.权限修饰符
            System.out.print(Modifier.toString(m.getModifiers()) + "\t");

            //3.返回值类型
            System.out.print(m.getReturnType().getName() + "\t");

            //4.方法名
            System.out.print(m.getName());
            System.out.print("(");
            //5.形参列表
            Class[] parameterTypes = m.getParameterTypes();
            if (!(parameterTypes == null && parameterTypes.length == 0)) {
                for (int i = 0; i < parameterTypes.length; i++) {
                    if (i == parameterTypes.length - 1) {
                        System.out.print(parameterTypes[i].getName() + " args_" + i);
                        break;
                    }
                    System.out.print(parameterTypes[i].getName() + " args_" + i + ",");
                }
            }
            System.out.print(")");

            //6.抛出的异常
            Class[] exceptionTypes = m.getExceptionTypes();
            if (exceptionTypes.length > 0) {
                System.out.print("throws ");
                for (int i = 0; i < exceptionTypes.length; i++) {
                    if (i == exceptionTypes.length - 1) {
                        System.out.print(exceptionTypes[i].getName());
                        break;
                    }
                    System.out.print(exceptionTypes[i].getName() + ",");
                }
            }
            System.out.println();
            System.out.println(m);
        }
        System.out.println();
        // getDeclaredMethods():获取当前运行时类中声明的所有方法。（不包含父类中声明的方法）
        Method[] declaredMethods = aClass.getDeclaredMethods();
        for (Method m : declaredMethods) {
            System.out.println(m);
        }
        System.out.println("==========================");
        // getConstructors():获取当前运行时类中声明为public的构造器
        Constructor[] constructors = aClass.getConstructors();
        for (Constructor c : constructors) {
            System.out.println(c);
        }

        System.out.println();
        // getDeclaredConstructors():获取当前运行时类中声明的所有的构造器
        Constructor[] declaredConstructors = aClass.getDeclaredConstructors();
        for (Constructor c : declaredConstructors) {
            System.out.println(c);
        }
        System.out.println("==========================");
        Person person = aClass.newInstance();
        System.out.println(person.toString());

        /// 获取代泛型的父类
        Type genericSuperclass = aClass.getGenericSuperclass();
        System.out.println(genericSuperclass);
        // 获取父类
        Class<? super Person> superclass = aClass.getSuperclass();
        System.out.println(superclass);

        /// 获取泛型参数
        ParameterizedType parameterizedType = (ParameterizedType) genericSuperclass;
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        for (Type actualTypeArgument : actualTypeArguments) {
            System.out.println(actualTypeArgument.getTypeName());
        }

        /// 获取接口
        Class<?>[] interfaces = aClass.getInterfaces();
        for (Class<?> anInterface : interfaces) {
            System.out.println(anInterface);
        }

        /// 获取泛型接口
        Type[] genericInterfaces = aClass.getGenericInterfaces();
        for (Type genericInterface : genericInterfaces) {
            System.out.println(genericInterface);
        }

        /// 获取包
        Package aPackage = aClass.getPackage();
        System.out.println(aPackage);
        /**
         * 获取指定的属性：要求运行时类中属性声明为public
         */
        //通常不采用此方法
        Field id = aClass.getField("id");

        // 设置当前属性的值set():参数1：指明设置哪个对象的属性   参数2：将此属性值设置为多少
        id.set(person, 1001);

        // 获取当前属性的值get():参数1：获取哪个对象的当前属性值
        int pId = (int) id.get(person);
        System.out.println(pId);

        /**
         *    1. getDeclaredField(String fieldName):获取运行时类中指定变量名的属性
         */
        Field name = aClass.getDeclaredField("name");

        // 2.保证当前属性是可访问的
        name.setAccessible(true);
        // 3.获取、设置指定对象的此属性值
        name.set(person, "Tom");

        System.out.println(name.get(person));

        /// 非静态方法
        // 获取指定的某个方法getDeclaredMethod():参数1 ：指明获取的方法的名称  参数2：指明获取的方法的形参列表
        Method show = aClass.getDeclaredMethod("show", String.class);
        // 2.保证当前方法是可访问的
        show.setAccessible(true);

        // 调用方法的invoke():参数1：方法的调用者  参数2：给方法形参赋值的实参invoke()的返回值即为对应类中调用的方法的返回值。
        // String nation = p.show("CHN");
        Object returnValue = show.invoke(person, "CHN");
        System.out.println(returnValue);

        /// 静态方法
        System.out.println("*************如何调用静态方法*****************");
        Method showDesc = aClass.getDeclaredMethod("showDesc");
        showDesc.setAccessible(true);
        // 如果调用的运行时类中的方法没有返回值，则此invoke()返回null
        // Object returnVal = showDesc.invoke(null);
        Object returnVal = showDesc.invoke(Person.class);
        // null
        System.out.println(returnVal);

        /**
         * 获取指定的构造器getDeclaredConstructor():参数：指明构造器的参数列表
         */
        Constructor constructor = aClass.getDeclaredConstructor(String.class);

        // 2.保证此构造器是可访问的
        constructor.setAccessible(true);

        // 3.调用此构造器创建运行时类的对象
        Person per = (Person) constructor.newInstance("Tom");
        System.out.println(per);
    }
}
