package matches;

import java.text.NumberFormat;

public class MyMatches {
    public static void main(String[] args) {
        String str = "^([1-9]\\d*)?9[0-9]000$";
        NumberFormat nf = NumberFormat.getInstance();
        nf.setGroupingUsed(false);

        double d = 124397000D;
        System.out.println(d);
        String sd = nf.format(d) + "";
        System.out.println(sd);
        if (sd.contains(".")) {
            System.out.println("------");
            sd = sd.substring(0, sd.indexOf("."));
        }
        System.out.println(sd);
        boolean flag = sd.matches(str);
        System.out.println(flag);


    }
}
