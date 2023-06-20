package com.ysoyso.reflection;

import java.lang.reflect.*;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class ReflectionDemo {
    public static void main(String[] args) throws NoSuchMethodException {
        Class<?> clazz = SomeClass.class;

        // 获取类名
        String className = clazz.getName();
        System.out.println(className);

        // 获取构造函数
        Constructor<?>[] constructors = clazz.getConstructors();
        System.out.println(Arrays.toString(constructors));

        // 获取属性
        Field[] fields = clazz.getDeclaredFields();
        System.out.println(Arrays.toString(fields));

        // 获取方法
        Method[] methods = clazz.getMethods();
        System.out.println(Arrays.toString(methods));
        // 创建对象
        try {
            System.out.println("----------newInstance----------");
            SomeClass obj = (SomeClass) clazz.newInstance();
            Constructor<?> constructor = clazz.getConstructor(String.class);
            SomeClass obj2 = (SomeClass) constructor.newInstance("new Some class");
            // 调用方法
            System.out.println("----------call methodName----------");
            Method method = clazz.getMethod("methodName", String.class);
            Object result = method.invoke(obj, "Hello World");
            System.out.println(result);

            System.out.println("------------call methodNamePrivate----------------");
            // 调用私有方法
            Method methodPrivate = clazz.getDeclaredMethod("methodNamePrivate");
            methodPrivate.setAccessible(true);
            Object resultPrivate = methodPrivate.invoke(obj);
            System.out.println(resultPrivate);

            System.out.println("------------get fieldName----------------");
            // 访问私有属性
            Field field = clazz.getDeclaredField("fieldName");
            field.setAccessible(true);
            Object value = field.get(obj2);
            System.out.println(value);
        } catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException |
                 NoSuchFieldException e) {
            throw new RuntimeException(e);
        }
        System.out.println("----------genericType-------------");
        genericType();
        System.out.println("----------getGenericTypeArguments-------------");
        getGenericTypeArguments();

        // 动态代理
        UserService userService = new UserServiceImpl();
        UserService proxy = (UserService) Proxy.newProxyInstance(
                UserService.class.getClassLoader(),
                new Class<?>[]{UserService.class, OtherInterface.class},
                new UserServiceProxy(userService)
        );
        proxy.addUser("Alice", "123456");
    }

    /**
     * 泛型类型检查
     * ParameterizedType接口表示参数化类型（即泛型类型），
     * 而TypeVariable接口表示类型变量。
     * 通过这些接口，可以获取泛型类型参数的信息，并进行类型检查。
     */
    private static void genericType() throws NoSuchMethodException {
        Class<?> clazz = SomeClass.class;
        Method method = clazz.getMethod("setValue", List.class);
        Type[] types = method.getGenericParameterTypes();
        System.out.println(Arrays.toString(types));
        if (types[0] instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) types[0];
            Type[] actualTypes = parameterizedType.getActualTypeArguments();
            if (actualTypes.length > 0 && actualTypes[0] instanceof Class<?>) {
                Class<?> genericClass = (Class<?>) actualTypes[0];
                System.out.println(genericClass.getSimpleName());
            }
        }
    }
    public static void getGenericTypeArguments() {
        Class<?> clazz = SomeClass.class;
        List<Class<?>> genericTypes = new ArrayList<>();
        Type[] types = clazz.getGenericInterfaces();
        System.out.println(Arrays.toString(types));
        for (Type type : types) {
            if (type instanceof ParameterizedType) {
                ParameterizedType pt = (ParameterizedType) type;
                for (Type t : pt.getActualTypeArguments()) {
                    genericTypes.add((Class<?>)t);
                }
            }
        }
        System.out.println(genericTypes);
    }

    // 缓存反射对象
    private static final Map<Class<?>, Map<String, Field>> fieldCache = new ConcurrentHashMap<>();

    public static Field getField(Class<?> clazz, String fieldName) throws NoSuchFieldException {
        Map<String, Field> fields = fieldCache.computeIfAbsent(clazz, key -> new HashMap<>());
        Field field = fields.get(fieldName);
        if (field == null) {
            field = clazz.getDeclaredField(fieldName);
            field.setAccessible(true);
            fields.put(fieldName, field);
        }
        return field;
    }

    // 动态代理

    public interface UserService {
        void addUser(String username, String password);
    }

    public interface OtherInterface {
        void otherMethod(String args);
    }

    public static class UserServiceImpl implements UserService, OtherInterface {
        public void addUser(String username, String password) {
            System.out.println("add user: " + username + ", password: " + password);
        }

        @Override
        public void otherMethod(String args) {
            System.out.println("other method: " + args);
        }
    }

    public static class UserServiceProxy implements InvocationHandler {
        private Object target;

        public UserServiceProxy(Object target) {
            this.target = target;
        }

        /**
         * @param proxy:  承载被调用的方法的代理类实例
         * @param method: 代理类实例上实现的接口的方法
         * @param args:   代理类实例上的被调用方法的参数，为一个object数组，
         *                当被调用的方法无入参时，args为null，基本类型的参数将会
         *                被其相应的包装类型的参数转换，比如int会被转换成Integer，
         *                boolean会被转换成Boolean
         * @return
         * @throws Throwable
         */
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            Class<?> clazz = proxy.getClass();
            System.out.println("------------invoke interfaces----------------");
            Class<?>[] interfaces = clazz.getInterfaces();
            for (Class<?> cla : interfaces) {
                System.out.println(cla.getSimpleName());
            }
            System.out.println("-------------methods------------------");
            Method[] methods = clazz.getMethods();
            for (Method m : methods) {
                System.out.println(m.getName());
            }

            System.out.println("------------invoke----------------");
            System.out.println("before method: " + method.getName());
            Object result = method.invoke(target, args);
            System.out.println("after method: " + method.getName());

            return result;
        }
    }
}
