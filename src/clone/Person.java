package clone;

import java.io.*;

public class Person implements Serializable, Cloneable {
    private String name;
    private int age;
    private Addr addr;
    private static final long serialVersionUID = -1L;

    public Person() {
    }

    static class Addr implements Cloneable, Serializable {
        public int cityNo;
        public String city;

        public Addr(int cityNo, String city) {
            this.cityNo = cityNo;
            this.city = city;
        }


        public void setCityNo(int cityNo) {
            this.cityNo = cityNo;
        }

        @Override
        public String toString() {
            return "Addr{" +
                    "cityNo=" + cityNo +
                    ", city='" + city + '\'' +
                    '}';
        }

        @Override
        protected Object clone() throws CloneNotSupportedException {
            Object obj = super.clone();
            return obj;
        }
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", addr=" + addr +
                '}';
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;

    }

    public Addr getAddr() {
        return addr;
    }

    public void setAddr(Addr addr) {
        this.addr = addr;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Object obj = super.clone();
        Addr a = ((Person) obj).getAddr();
        ((Person) obj).setAddr((Addr) a.clone());
        return obj;
    }

    public static <T extends Serializable> T tclone(T obj) {
        T cloneObj = null;
        try {
            // 写入字节流
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            ObjectOutputStream obs = new ObjectOutputStream(out);
            obs.writeObject(obj);
            obs.close();
            // 分配内存，写入原始对象，生成新对象
            ByteArrayInputStream ios = new ByteArrayInputStream(out.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(ios);
            // 返回生成的新对象
            cloneObj = (T) ois.readObject();
            ois.close();
        } catch (Exception e) {
//            logger.error("拷贝失败：" + e);
        }
        return cloneObj;
    }

    public static void main(String[] args) throws CloneNotSupportedException, IOException {
        Addr addr = new Addr(1, "北京");
        Person p1 = new Person("A", 12);
        p1.setAddr(addr);

        Person p2 = (Person) p1.tclone(p1);
        System.out.println(p1 == p2);
        System.out.println(p1);
        System.out.println(p2);

        p2.addr.setCityNo(2222);

        System.out.println(p2.getClass() +"--------------");

        System.out.println(p1);
        System.out.println(p2);

    }
}
