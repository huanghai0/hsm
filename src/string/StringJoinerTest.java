package string;

import java.util.StringJoiner;
import java.util.stream.IntStream;

public class StringJoinerTest {
    public static void main(String[] args) {
        StringJoiner sj = new StringJoiner(",");
//        sj.add("#");

        IntStream.range(1, 10).forEach(i -> {
            sj.add(i + "");
        });
//        sj.add("#");
        System.out.println(sj);
    }
}
