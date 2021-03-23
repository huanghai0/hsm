package proxy.jdkProxy;

public class UserDaoImpl implements UserDao {
    @Override
    public void saveUser() {
        System.out.println("----保存用户---");
    }
}
