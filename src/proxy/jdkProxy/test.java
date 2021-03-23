package proxy.jdkProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class test {
    public static void main(String[] args) {
        UserDao userDao = new UserDaoImpl();
        InvocationHandler proxyHandel = new ProxyHandel(userDao);

        ClassLoader loader = userDao.getClass().getClassLoader();
        Class<?>[] inface = userDao.getClass().getInterfaces();
        UserDao proxy = (UserDao) Proxy.newProxyInstance(loader, inface, proxyHandel);
        proxy.saveUser();

    }
}
