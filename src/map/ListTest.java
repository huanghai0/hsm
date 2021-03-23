package map;

import java.util.*;

public class ListTest {
    public static void main(String[] args) {

        List<Double> list = new ArrayList<>();
        list.add(1.01D);
        if (list instanceof List){
            List<Double> mylist = (List)list;
            for (Double str : mylist){
                System.out.println(str);
            }
            System.out.println("-----------");
        }
        SortedSet<Map> set = new TreeSet<Map>(new Comparator<Map>() {
            @Override
            public int compare(Map o1, Map o2) {
                Double val1 = new Double(String.valueOf(o1.get("value")));
                Double val2 = new Double(String.valueOf(o2.get("value")));
                String key1 = (String) o1.get("key");
                String key2 = (String) o2.get("key");
                int res = val2.compareTo(val1);
                return res !=0 ? res : key1.compareTo(key2);
            }
        });
        Map<String,Object> map1 = new HashMap<>();
        Map<String,Object> map2 = new HashMap<>();
        Map<String,Object> map3 = new HashMap<>();
        Map<String,Object> map4 = new HashMap<>();

        map1.put("key","B");
        map1.put("value",100.03D);
        set.add(map1);
        map2.put("key","C");
        map2.put("value",330.03D);
        set.add(map2);
        map3.put("key","A");
        map3.put("value",300.001D);
        set.add(map3);
        map4.put("key","D");
        map4.put("value",9.001D);
        set.add(map4);

        System.out.println("set: "+set.size());
        List<Double> list1 = new ArrayList<>();
        for(Map<String,Object> m : set){
            if(list1.size()<2){
                list1.add((Double) m.get("value"));
            }
        }
        for (Double s:list1){
            System.out.println(s);
        }
    }
}
