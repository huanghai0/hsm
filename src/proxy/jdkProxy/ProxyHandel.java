package proxy.jdkProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ProxyHandel implements InvocationHandler {
    private UserDao userDao;
    public ProxyHandel(UserDao userDao){
        this.userDao = userDao;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        start();
        UserDao userDaoProxy = (UserDao) method.invoke(userDao,args);
        end();
        return userDaoProxy;
    }

    public void start(){
        System.out.println("---代理开始---");
    }
    public void end(){
        System.out.println("---代理结束---");
    }
}
