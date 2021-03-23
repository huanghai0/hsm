package doubletest;

public class divDouble {
    public static void main(String[] args) {

        Double dd1 = 5.0;
        Double dd2 = 6.0;
        if(dd1 instanceof Number){
            System.out.println("///////////////////");
        }
        double a = div(dd1,dd2);

        double b= Double.MIN_VALUE;
        System.out.println("---|| "+b);

    }

    private static double div(Object o1,Object o2){
        if(o1 == null || o2 == null) return 0D;

        double d1 = (Double) o1;
        double d2 = (Double) o2;

        return d1/d2;

    }

    
}
