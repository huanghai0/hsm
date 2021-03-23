package pattern.strategy;

public class Duck {
    //把飞的行为接口聚合过来
    private FlyBehavior flyBehavior;

    public Duck(FlyBehavior flyBehavior) {
        this.flyBehavior = flyBehavior;
    }

    public void fly() {
        flyBehavior.fly();
    }

    public static void main(String[] args) {
//        FlyBehavior flyBehavior = new GoodFlyBehavior();
        FlyBehavior flyBehavior = new BadFlyBehavior();
        Duck duck = new Duck(flyBehavior);

        duck.fly();
    }

}
