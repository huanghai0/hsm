package date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

public class getMaxContinuityDay {

    public static int getMax(Long[] list) {
        int count = 0;
        for (int i = 0; i < list.length - 1; i++) {
            int temp = 1;
            for (int j = i + 1; j < list.length; j++) {
                Long l1 = list[i] + (j - i) * 24 * 60 * 60 * 1000;
                Long l2 = list[j];
                if (l1.toString().equals(l2.toString())) {
                    temp++;
                }
                if (temp > count) count = temp;
            }
        }
        return count;
    }

    public static int getMaxContinuityDay(List<Date> list) {

        List<Long> tmplist = new ArrayList<>();
        for (Date tmp : list) {
            Long ll = tmp.getTime() - ((tmp.getTime() + 28800000) % 86400000);
            tmplist.add(ll);
        }

        Collections.sort(tmplist);
        tmplist = tmplist.stream().distinct().collect(Collectors.toList());

//        for (Long tmplon : reslist) {
//            System.out.println(tmplon);
//            Date date = new Date(tmplon);
//            System.out.println(date);
//        }

        int count = 0;
        int i = 24 * 3600 * 1000;
        int size = list.size();

        Iterator<Long> iterator = tmplist.iterator();
        while (iterator.hasNext()) {
            int temp = 1;
            Long la = iterator.next();

            for (int j = 1; j < size; j++) {
                if (tmplist.contains(la + j * i)) {
                    temp++;
                } else {
                    break;
                }
            }
            size--;
            if (temp > count) count = temp;
        }
        return count;
    }

    public static void main(String[] args) throws ParseException {

        List<Date> list = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd HHmmss");
        String[] strArr = {"20201121 132334", "20201123 061334", "20201125 135434", "20201124 013834"};
        for (String str : strArr) {
            Date date = sdf.parse(str);
            System.out.println(date);
            list.add(date);
        }
        int a = getMaxContinuityDay(list);
        System.out.println(a);


//        List<Map.Entry<Object,Object>> listll = new ArrayList<Map.Entry<Object,Object>>(hashMap.entrySet());
//        Collections.sort(listll, new Comparator<Map.Entry<Object, Object>>() {
//            @Override
//            public int compare(Map.Entry<Object, Object> o1, Map.Entry<Object, Object> o2) {
//                return ((Date) o1.getKey()).compareTo((Date) o2.getKey());
//            }
//        });

        String ss = "^([1-9]\\d*)?9[0-9]000$";
        Object yyy = 593000L;
        if (yyy instanceof Double) {
            double d = ((Double) yyy).doubleValue();
            System.out.println(d);
            String sd = d + "";
            sd = sd.substring(0, sd.indexOf("."));
            System.out.println(sd);
            Boolean flag = sd.matches(ss);
            System.out.println(flag);
            System.out.println("!!!!!!!!!!!!!!!!!!");
        }
        if (yyy instanceof Long) {
            Long d = ((Long) yyy).longValue();
            System.out.println(d);
            String sd = d + "";
            System.out.println(sd);
            //sd = sd.substring(0, sd.indexOf("L"));
            System.out.println(sd);
            Boolean flag = sd.matches(ss);
            System.out.println(flag);
            System.out.println("????????????????");
        }
    }
}
