package pattern.template;

public class Application extends Library {
    @Override
    protected void step3() {
        System.out.println("方法3实现");
    }

    public static void main(String[] args) {
        Application application = new Application();
        application.templateMethod();
    }
}
