package dynamic.proxy.nopadapter;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Set;

public class SetProxyFactory {

    public static Set getSetProxy(final Set s) {
        return (Set) Proxy.newProxyInstance
          (s.getClass().getClassLoader(),
                new Class[] { Set.class },
                new InvocationHandler() {
                    public Object invoke(Object proxy, Method method, 
                      Object[] args) throws Throwable {
                        return method.invoke(s, args);
                    }
                });
    }
}