package random;


import java.sql.Timestamp;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
//import java.sql.Date;
import java.util.UUID;

public class sToInt {
    public static void main(String[] args) throws ParseException {


        SimpleDateFormat f=new SimpleDateFormat("yyyyMMddHHmmss");
//        java.util.Date utilDate=new Date();
//        String date = f.format(utilDate);
//        java.sql.Date sqlDate=new java.sql.Date(utilDate.getTime());
//        System.out.println(sqlDate);

        SimpleDateFormat df1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date nowdate = new Date();
        System.out.println(nowdate);
        nowdate = f.parse("20200615"+"000000");
        System.out.println(nowdate);
    }


}
