package pattern.template;

public abstract class Library {

    private void step1() {
        System.out.println("方法1");
    }

    private void step2() {
        System.out.println("方法2");
    }

    //变化的方法
    protected abstract void step3();

    public void templateMethod() {
        step1();
        step2();
        step3();
    }

}
