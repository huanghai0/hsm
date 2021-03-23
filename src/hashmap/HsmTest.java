package hashmap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;

public class HsmTest {

    public static void main(String[] args) {

        String[] arr = new String[]{"甲", "乙", "丙", "丁"};

        Random random = new Random();
        HashMap<String, Student> map = new HashMap<>();

        for (int i = 0; i < 100; i++) {
            Student student = new Student(arr[random.nextInt(4)], random.nextInt(4));
            map.put("str" + i, student);
        }

        Map<Student, Integer> res = new HashMap<>();
//        for (Map.Entry<String, Student> entry : map.entrySet()) {
//
//            if (res.containsKey(entry.getValue())) {
//                res.put(entry.getValue(), res.get(entry.getValue()) + 1);
//            } else {
//                res.put(entry.getValue(), 1);
//            }
//        }


//        map.forEach((k,v) ->{
//            map.entrySet().removeIf(key -> key.equals("A"));
//
//            if (res.containsKey(v)) {
//                res.put(v, res.get(v) + 1);
//            } else {
//                res.put(v, 1);
//            }
//        });

//        Iterator<Map.Entry<String,Student>> iterator = map.entrySet().iterator();
//        while (iterator.hasNext()){
//            Map.Entry<String,Student> entry = iterator.next();
//
//            iterator.remove();
//
//        }

        map.entrySet().parallelStream().forEach(entry -> {
            if (res.containsKey(entry.getValue())) {
                res.put(entry.getValue(), res.get(entry.getValue()) + 1);
            } else {
                res.put(entry.getValue(), 1);
            }
        });

        

        for (Map.Entry<Student, Integer> entry : res.entrySet()) {
            System.out.println("key = " + entry.getKey() + ", value = " + entry.getValue() + ", hash code = " + entry.hashCode());
        }
        System.out.println(res.size());


    }

}
