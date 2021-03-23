package random;

public class RandomTest {

    static int i =1;
    public static void main(String[] args) {
//        Random random = new Random();
//        System.out.println(random.nextInt(10));
//        String s1 = new String("1");
//        String s2 = new String("1");
//        String s3 = "1";
//        String s4 = "1";
//        System.out.println(s4.equals(s3));
//        System.out.println(s1 == s2);
        RandomTest randomTest = new RandomTest();
        randomTest.add();
        i++;
        System.out.println("i2 =" +i);



    }
        private void add() {
            System.out.println("i3 =" + i);
        }

    static {
        i++;
        System.out.println("i1 =" +i);
    }


}
